package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f27297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f27298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f27299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f27300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f27301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f27302f;

    public boolean a(g3 r110) {
        double r100 = r110.f27297a;
        double r101 = r110.f27299c;
        double r102 = r110.f27298b;
        double r103 = r110.f27300d;
        if (r100 < this.f27299c) goto L5;
    L11:
        return false;
    L5:
        if (this.f27297a >= r101) goto L11;
        if (r102 >= this.f27300d) goto L11;
        if (this.f27298b >= r103) goto L11;
        return true;
    }

    public boolean a(double r100, double r101) {
        if (this.f27297a <= r100) goto L5;
    L11:
        return false;
    L5:
        if (r100 > this.f27299c) goto L11;
        if (this.f27298b > r101) goto L11;
        if (r101 > this.f27300d) goto L11;
        return true;
    }

    public g3(double r100, double r101, double r102, double r103) {
        this.f27297a = r100;
        this.f27298b = r102;
        this.f27299c = r101;
        this.f27300d = r103;
        this.f27301e = (r100 + r101) / 2.0d;
        this.f27302f = (r102 + r103) / 2.0d;
    }
}
