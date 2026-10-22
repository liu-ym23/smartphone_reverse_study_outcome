package com.bytedanceos.appstore.buss.network;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8799b;

    public d(int r10, String r11) {
        q.g(r11, "errorMessage");
        super(null);
        this.f8798a = r10;
        this.f8799b = r11;
    }

    public final int a() {
        return this.f8798a;
    }

    public final String b() {
        return this.f8799b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.f8798a == r11.f8798a) goto L12;
        return false;
    L12:
        if (q.b(this.f8799b, r11.f8799b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f8798a) * 31) + this.f8799b.hashCode();
    }

    public String toString() {
        return "AssistantApiErrorResponse(errorCode=" + this.f8798a + ", errorMessage=" + this.f8799b + ')';
    }
}
