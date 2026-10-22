package com.stepos.account.oauth;

import android.content.Intent;

/* loaded from: classes.dex */
public class AuthException extends Exception {
    private String accountName;
    private int code;
    private Intent mHandleIntent;

    public AuthException(Intent intent) {
        this.mHandleIntent = intent;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getCode() {
        return this.code;
    }

    public Intent getHandleIntent() {
        return this.mHandleIntent;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mHandleIntent != null ? "intent need to be handled." : super.getMessage();
    }

    public AuthException(int i2, String str) {
        super(str);
        this.code = i2;
    }

    public AuthException(int i2, String str, String str2) {
        super(str);
        this.code = i2;
        this.accountName = str2;
    }

    public AuthException(int i2, String str, Throwable th) {
        super(str, th);
        this.code = i2;
    }
}
