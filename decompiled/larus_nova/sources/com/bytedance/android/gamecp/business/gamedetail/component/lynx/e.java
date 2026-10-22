package com.bytedance.android.gamecp.business.gamedetail.component.lynx;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f54496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f54497b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f54496a == r101.f54496a) goto L8;
        return false;
    L8:
        if (Double.compare(this.f54497b, r101.f54497b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f54496a * 31;
        long r101 = Double.doubleToLongBits(this.f54497b);
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GameDetailLynxLayoutStyle(height=" + this.f54496a + ", aspectRatio=" + this.f54497b + ")";
    }

    public e(int r100, double r101) {
        this.f54496a = r100;
        this.f54497b = r101;
    }
}
