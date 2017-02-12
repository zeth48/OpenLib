package zeth48.openlib;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button sign;

    private EditText email1;
    private EditText pass;
   // private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign = (Button) findViewById(R.id.signin);
        email1= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.password);
        sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FirebaseAuth firebaseAuth;
        firebaseAuth=FirebaseAuth.getInstance();
        String email=email1.getText().toString().trim();
        String password=pass.getText().toString().trim();
        if(!email.isEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                //    progressDialog=new ProgressDialog(getApplicationContext());
                //    progressDialog.setMessage("Signing In...");
                   // progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                 //   progressDialog.setCancelable(true);
                 //   progressDialog.setIndeterminate(true);
                  //  progressDialog.setProgress(0);
                 //   progressDialog.show();
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), NavBar.class);
                        Toast.makeText(getApplicationContext(), "Signed In", Toast.LENGTH_SHORT).show();
                       // progressDialog.dismiss();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter Correct Credentials.", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }

    }
}




//testing commit