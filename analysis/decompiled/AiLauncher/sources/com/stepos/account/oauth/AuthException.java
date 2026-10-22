package com.stepos.account.oauth;

import android.content.Intent;

/* loaded from: classes2.dex */
public class AuthException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public Intent f22151a;

    /* renamed from: b, reason: collision with root package name */
    public int f22152b;

    /* renamed from: c, reason: collision with root package name */
    public String f22153c;

    public AuthException(Intent intent) {
        this.f22151a = intent;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f22151a != null ? "intent need to be handled." : super.getMessage();
    }

    public AuthException(int i10, String str) {
        super(str);
        this.f22152b = i10;
    }

    public AuthException(int i10, String str, String str2) {
        super(str);
        this.f22152b = i10;
        this.f22153c = str2;
    }

    public AuthException(int i10, String str, Throwable th) {
        super(str, th);
        this.f22152b = i10;
    }
}
