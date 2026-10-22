package bv5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f20893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f20894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20895c;

    public static double a(double r100) {
    L3:
        if (r100 <= 180.0d) goto L6;
        r100 = r100 - 360.0d;
    L6:
        if (r100 >= (-180.0d)) goto L8;
        r100 = r100 + 360.0d;
        goto L6
    L8:
        return r100;
    }

    public h(i r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f20893a = r100;
    }

    public final double update(double r100, long r101) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        return Double.NaN;
    L11:
        long r103 = this.f20893a.f20896a;
        if (r103 > 0) goto L14;
    L17:
        double r104 = a(a(r100) - this.f20894b);
        double r105 = Math.abs(r104);
        i r106 = this.f20893a;
        if (r105 < r106.f20898c) goto L20;
        double r107 = a(this.f20894b + (r106.f20897b * r104));
        this.f20894b = r107;
        this.f20895c = r101;
        return r107;
    L20:
        return this.f20894b;
    L14:
        if ((r101 - this.f20895c) >= r103) goto L17;
        return this.f20894b;
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r102 = true;
        goto L8
    }
}
