package bv5;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f20897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f20898c;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f20896a == r101.f20896a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f20897b, r101.f20897b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f20898c, r101.f20898c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f20896a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f20897b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f20898c);
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "HeadingDisplayFilterConfig(uiIntervalMs=" + this.f20896a + ", alpha=" + this.f20897b + ", deadZoneDeg=" + this.f20898c + ")";
    }

    public /* synthetic */ i(int r100) {
        this(100, 0.2d, 1.0d);
    }

    public i(long r100, double r101, double r102) {
        this.f20896a = r100;
        this.f20897b = r101;
        this.f20898c = r102;
    }
}
