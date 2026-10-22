package com.android.volley;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class AuthFailureError extends VolleyError {
    private Intent mResolutionIntent;

    public AuthFailureError() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mResolutionIntent == null) goto L7;
        return "User needs to (re)enter credentials.";
    L7:
        return super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }

    public AuthFailureError(Intent r10) {
        this.mResolutionIntent = r10;
    }

    public AuthFailureError(NetworkResponse r10) {
        super(r10);
    }

    public AuthFailureError(String r10) {
        super(r10);
    }

    public AuthFailureError(String r10, Exception r11) {
        super(r10, r11);
    }
}
