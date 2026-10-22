package bv5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f20838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f20839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f20840d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f20837a, r101.f20837a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f20838b, r101.f20838b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f20839c, r101.f20839c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f20840d, r101.f20840d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f20837a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f20838b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f20839c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.f20840d);
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public final String toString() {
        return "AttitudeCorrectionSample(source=" + this.f20837a + ", timestampS=" + this.f20838b + ", yawDeltaDeg=" + this.f20839c + ", yawMeasStdDeg=" + this.f20840d + ")";
    }

    public a(String r100, double r101, double r102, double r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f20837a = r100;
        this.f20838b = r101;
        this.f20839c = r102;
        this.f20840d = r103;
    }
}
