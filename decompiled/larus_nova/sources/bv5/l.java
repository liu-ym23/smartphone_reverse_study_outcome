package bv5;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f20933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f20934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f20937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f20938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f20939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double[] f20940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final double f20941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final double f20942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double f20943m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final double f20944n;

    public l() {
        this(true, false, 1.0d, 1.0d, true, true, c.b(30.0d), 0.1d, 0.3d, new double[]{0.05d, 0.05d, 0.05d}, c.b(2.0d), c.b(2.0d), c.b(80.0d), c.b(45.0d));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f20931a == r101.f20931a) goto L12;
        return false;
    L12:
        if (this.f20932b == r101.f20932b) goto L15;
        return false;
    L15:
        if (Double.compare(this.f20933c, r101.f20933c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f20934d, r101.f20934d) == 0) goto L21;
        return false;
    L21:
        if (this.f20935e == r101.f20935e) goto L24;
        return false;
    L24:
        if (this.f20936f == r101.f20936f) goto L27;
        return false;
    L27:
        if (Double.compare(this.f20937g, r101.f20937g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.f20938h, r101.f20938h) == 0) goto L33;
        return false;
    L33:
        if (Double.compare(this.f20939i, r101.f20939i) == 0) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f20940j, r101.f20940j) == true) goto L39;
        return false;
    L39:
        if (Double.compare(this.f20941k, r101.f20941k) == 0) goto L42;
        return false;
    L42:
        if (Double.compare(this.f20942l, r101.f20942l) == 0) goto L45;
        return false;
    L45:
        if (Double.compare(this.f20943m, r101.f20943m) == 0) goto L48;
        return false;
    L48:
        if (Double.compare(this.f20944n, r101.f20944n) == 0) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f20931a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f20932b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = Double.doubleToLongBits(this.f20933c);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = Double.doubleToLongBits(this.f20934d);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        if (this.f20935e == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        if (this.f20936f == true) goto L18;
        r100 = 1237;
    L18:
        int r111 = (r110 + r100) * 31;
        long r112 = Double.doubleToLongBits(this.f20937g);
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = Double.doubleToLongBits(this.f20938h);
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = Double.doubleToLongBits(this.f20939i);
        int r117 = (((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + Arrays.hashCode(this.f20940j)) * 31;
        long r118 = Double.doubleToLongBits(this.f20941k);
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = Double.doubleToLongBits(this.f20942l);
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = Double.doubleToLongBits(this.f20943m);
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        long r124 = Double.doubleToLongBits(this.f20944n);
        return r123 + ((int) (r124 ^ (r124 >>> 32)));
    L13:
        r109 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ZuptConfig(enabled=" + this.f20931a + ", angleUpdateEnabled=" + this.f20932b + ", windowS=" + this.f20933c + ", minIntervalS=" + this.f20934d + ", useBiasCompensation=" + this.f20935e + ", recordDebug=" + this.f20936f + ", gyroRmsThreshRadS=" + this.f20937g + ", accMeanNormThreshMps2=" + this.f20938h + ", accStdNormThreshMps2=" + this.f20939i + ", velMeasStdMps=" + Arrays.toString(this.f20940j) + ", rollMeasStdRad=" + this.f20941k + ", pitchMeasStdRad=" + this.f20942l + ", maxTiltAbsRad=" + this.f20943m + ", angleInnovGateRad=" + this.f20944n + ")";
    }

    public l(boolean r100, boolean r101, double r102, double r103, boolean r110, boolean r111, double r112, double r113, double r114, double[] r115, double r210, double r211, double r212, double r213) {
        Intrinsics.checkNotNullParameter(r115, "velMeasStdMps");
        this.f20931a = r100;
        this.f20932b = r101;
        this.f20933c = r102;
        this.f20934d = r103;
        this.f20935e = r110;
        this.f20936f = r111;
        this.f20937g = r112;
        this.f20938h = r113;
        this.f20939i = r114;
        this.f20940j = r115;
        this.f20941k = r210;
        this.f20942l = r211;
        this.f20943m = r212;
        this.f20944n = r213;
    }
}
