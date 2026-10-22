package com.android.server.notification;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class NASLearnMoreActivity extends Activity {
    public NASLearnMoreActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLearnMoreDialog();
    }

    private void showLearnMoreDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = builder.setMessage(R.string.permdesc_connection_manager).setPositiveButton(R.string.ok, new AnonymousClass1(this)).create();
        alertDialog.getWindow().setType(2003);
        alertDialog.show();
    }
}
