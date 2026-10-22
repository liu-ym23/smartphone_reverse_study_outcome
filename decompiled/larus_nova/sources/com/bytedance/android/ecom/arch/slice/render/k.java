package com.bytedance.android.ecom.arch.slice.render;

/* JADX INFO: loaded from: classes44.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50679b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (this.f50678a == r101.f50678a) goto L8;
        return false;
    L8:
        if (this.f50679b == r101.f50679b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f50678a * 31) + this.f50679b;
    }

    public final String toString() {
        return "SlcPoint(x=" + this.f50678a + ", y=" + this.f50679b + ")";
    }

    public k(int r100, int r101) {
        this.f50678a = r100;
        this.f50679b = r101;
    }
}
