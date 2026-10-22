package com.bytedance.android.livesdk.floatview;

/* JADX INFO: loaded from: classes8.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f125229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f125230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f125231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f125232d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L14;
        j r101 = (j) r100;
        if (this.f125229a == r101.f125229a) goto L8;
        return false;
    L8:
        if (this.f125230b == r101.f125230b) goto L10;
        return false;
    L10:
        if (this.f125231c == r101.f125231c) goto L12;
        return false;
    L12:
        if (this.f125232d == r101.f125232d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f125229a * 31) + this.f125230b) * 31) + this.f125231c) * 31) + this.f125232d;
    }

    public final String toString() {
        return "OriginViewMarginInfo(originLeftMargin=" + this.f125229a + ", originTopMargin=" + this.f125230b + ", originRightMargin=" + this.f125231c + ", originBottomMargin=" + this.f125232d + ")";
    }

    public j(int r100, int r101, int r102, int r103) {
        this.f125229a = r100;
        this.f125230b = r101;
        this.f125231c = r102;
        this.f125232d = r103;
    }
}
