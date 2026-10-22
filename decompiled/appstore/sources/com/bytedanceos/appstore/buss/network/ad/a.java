package com.bytedanceos.appstore.buss.network.ad;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8788b;

    public a(int r10, String r11) {
        q.g(r11, "errorMessage");
        super(null);
        this.f8787a = r10;
        this.f8788b = r11;
    }

    public final int a() {
        return this.f8787a;
    }

    public final String b() {
        return this.f8788b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f8787a == r11.f8787a) goto L12;
        return false;
    L12:
        if (q.b(this.f8788b, r11.f8788b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f8787a) * 31) + this.f8788b.hashCode();
    }

    public String toString() {
        return "AdApiErrorResponse(errorCode=" + this.f8787a + ", errorMessage=" + this.f8788b + ')';
    }
}
