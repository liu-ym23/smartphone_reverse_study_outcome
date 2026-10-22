package com.stepos.minor.ui;

import I2.b;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import f2.C0702g;

/* loaded from: classes.dex */
public class MinorPasswordConfirmActivity extends Activity {
    private Intent a(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            Intent intent2 = new Intent();
            if (!intent.hasExtra("reset")) {
                return intent2;
            }
            intent2.putExtra("reset", intent.getBooleanExtra("reset", false));
            return intent2;
        } catch (Exception e6) {
            C0702g.p("MinorPasswordConfirmActivity", "Failed to sanitize intent: " + e6.getMessage());
            return null;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        C0702g.b("MinorPasswordConfirmActivity", "onActivityResult() called with: requestCode = [" + i5 + "], resultCode = [" + i6 + "], data = " + C0702g.j(intent));
        setResult(i6, a(intent));
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        C0702g.b("MinorPasswordConfirmActivity", "start confirm password activity intent = " + C0702g.j(getIntent()));
        super.onCreate(bundle);
        b.c(this, 99);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C0702g.b("MinorPasswordConfirmActivity", "onDestroy() called");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C0702g.b("MinorPasswordConfirmActivity", "onStart() called");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        C0702g.b("MinorPasswordConfirmActivity", "onStop() called");
    }
}
