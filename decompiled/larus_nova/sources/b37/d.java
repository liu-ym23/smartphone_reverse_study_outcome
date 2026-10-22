package b37;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f17212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f17213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f17214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f17215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f17216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f17218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f17219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f17221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f17223l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Double.compare(this.f17212a, r101.f17212a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f17213b, r101.f17213b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f17214c, r101.f17214c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f17215d, r101.f17215d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f17216e, r101.f17216e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f17217f, r101.f17217f) == 0) goto L27;
        return false;
    L27:
        if (this.f17218g == r101.f17218g) goto L30;
        return false;
    L30:
        if (this.f17219h == r101.f17219h) goto L33;
        return false;
    L33:
        if (this.f17220i == r101.f17220i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f17221j, r101.f17221j) == true) goto L39;
        return false;
    L39:
        if (this.f17222k == r101.f17222k) goto L42;
        return false;
    L42:
        if (this.f17223l == r101.f17223l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f17212a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f17213b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f17214c);
        int r105 = (((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + Float.floatToIntBits(this.f17215d)) * 31) + Float.floatToIntBits(this.f17216e)) * 31) + Float.floatToIntBits(this.f17217f)) * 31;
        long r106 = this.f17218g;
        int r107 = (((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f17219h) * 31;
        int r108 = 1231;
        if (this.f17220i == false) goto L5;
        int r109 = 1231;
    L6:
        int r110 = (((((r107 + r109) * 31) + this.f17221j.hashCode()) * 31) + this.f17222k) * 31;
        if (this.f17223l == true) goto L11;
        r108 = 1237;
    L11:
        return r110 + r108;
    L5:
        r109 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocationInfo(latitude=" + this.f17212a + ", longitude=" + this.f17213b + ", altitude=" + this.f17214c + ", accuracy=" + this.f17215d + ", bearing=" + this.f17216e + ", speed=" + this.f17217f + ", timestamp=" + this.f17218g + ", locateType=" + this.f17219h + ", hasAltitude=" + this.f17220i + ", coordinateSystem=" + this.f17221j + ", trustedLevel=" + this.f17222k + ", validLatlng=" + this.f17223l + ")";
    }

    public d(double r100, double r101, double r110, float r111, float r112, float r113, long r114, int r115, boolean r116, boolean r117) {
        Intrinsics.checkNotNullParameter("gcj02", "coordinateSystem");
        this.f17212a = r100;
        this.f17213b = r101;
        this.f17214c = r110;
        this.f17215d = r111;
        this.f17216e = r112;
        this.f17217f = r113;
        this.f17218g = r114;
        this.f17219h = r115;
        this.f17220i = r116;
        this.f17221j = "gcj02";
        this.f17222k = 1;
        this.f17223l = r117;
    }
}
