package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes6.dex */
public final class n<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public F f190676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S f190677b;

    public final int hashCode() {
        F r100 = this.f190676a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        S r103 = this.f190677b;
        if (r103 == null) goto L11;
        r101 = r103.hashCode();
    L11:
        return r102 ^ r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f190676a) + " " + this.f190677b + com.alipay.sdk.m.u.i.f25855d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof n) == true) goto L5;
        return false;
    L5:
        n r101 = (n) r100;
        F r102 = r101.f190676a;
        F r103 = this.f190676a;
        if (r102 == r103) goto L12;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L25;
        S r105 = r101.f190677b;
        S r106 = this.f190677b;
        if (r105 == r106) goto L21;
        if (r105 != null) goto L18;
    L20:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r105.equals(r106) == false) goto L20;
    L21:
        r107 = true;
        goto L22
    L25:
        return false;
    L9:
        if (r102.equals(r103) == false) goto L11;
    L12:
        r104 = true;
        goto L13
    }

    public n(F r100, S r101) {
        this.f190676a = r100;
        this.f190677b = r101;
    }
}
