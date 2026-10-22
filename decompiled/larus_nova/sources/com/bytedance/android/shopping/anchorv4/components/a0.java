package com.bytedance.android.shopping.anchorv4.components;

/* JADX INFO: loaded from: classes12.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f166070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f166071b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L10;
        a0 r101 = (a0) r100;
        if (this.f166070a == r101.f166070a) goto L8;
        return false;
    L8:
        if (this.f166071b == r101.f166071b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f166070a * 31) + this.f166071b;
    }

    public final String toString() {
        return "ScrollInfo(index=" + this.f166070a + ", offset=" + this.f166071b + ")";
    }

    public a0(int r100, int r101) {
        this.f166070a = r100;
        this.f166071b = r101;
    }
}
