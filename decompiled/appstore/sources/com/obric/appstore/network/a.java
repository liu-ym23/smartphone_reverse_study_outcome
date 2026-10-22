package com.obric.appstore.network;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10962b;

    public a(int r10, String r11) {
        q.g(r11, "errorMessage");
        super(null);
        this.f10961a = r10;
        this.f10962b = r11;
    }

    public final int a() {
        return this.f10961a;
    }

    public final String b() {
        return this.f10962b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f10961a == r11.f10961a) goto L12;
        return false;
    L12:
        if (q.b(this.f10962b, r11.f10962b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f10961a) * 31) + this.f10962b.hashCode();
    }

    public String toString() {
        return "ApiErrorResponse(errorCode=" + this.f10961a + ", errorMessage=" + this.f10962b + ')';
    }
}
