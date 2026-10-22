package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f75890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f75891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f75892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f75893d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (Double.compare(this.f75890a, r101.f75890a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f75891b, r101.f75891b) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.f75892c, r101.f75892c) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f75893d, r101.f75893d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f75890a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f75891b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f75892c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f75893d);
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "StreamRect(x=" + this.f75890a + ", y=" + this.f75891b + ", width=" + this.f75892c + ", height=" + this.f75893d + ")";
    }

    public h(double r100, double r101, double r102, double r103) {
        this.f75890a = r100;
        this.f75891b = r101;
        this.f75892c = r102;
        this.f75893d = r103;
    }
}
