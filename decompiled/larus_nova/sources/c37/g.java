package c37;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f22326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f22327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f22328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f22329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f22330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f22331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f22332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f22333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f22335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f22337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f22338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f22339n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f22340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b37.d f22341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<d> f22342q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Double.compare(this.f22326a, r101.f22326a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f22327b, r101.f22327b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f22328c, r101.f22328c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f22329d, r101.f22329d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f22330e, r101.f22330e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f22331f, r101.f22331f) == 0) goto L27;
        return false;
    L27:
        if (this.f22332g == r101.f22332g) goto L30;
        return false;
    L30:
        if (this.f22333h == r101.f22333h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f22334i, r101.f22334i) == true) goto L36;
        return false;
    L36:
        if (this.f22335j == r101.f22335j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f22336k, r101.f22336k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f22337l, r101.f22337l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f22338m, r101.f22338m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f22339n, r101.f22339n) == true) goto L51;
        return false;
    L51:
        if (this.f22340o == r101.f22340o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f22341p, r101.f22341p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f22342q, r101.f22342q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f22326a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f22327b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f22328c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f22329d);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.f22330e);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.f22331f);
        int r111 = (((((((((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f22332g) * 31) + this.f22333h) * 31) + this.f22334i.hashCode()) * 31) + this.f22335j) * 31;
        String r112 = this.f22336k;
        int r113 = 0;
        if (r112 != null) goto L5;
        int r114 = 0;
    L6:
        int r115 = (r111 + r114) * 31;
        String r116 = this.f22337l;
        if (r116 != null) goto L9;
        int r117 = 0;
    L10:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f22338m;
        if (r119 != null) goto L13;
        int r120 = 0;
    L14:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f22339n;
        if (r122 != null) goto L17;
        int r123 = 0;
    L18:
        int r124 = (r121 + r123) * 31;
        if (this.f22340o == false) goto L21;
        int r125 = 1231;
    L22:
        int r126 = (r124 + r125) * 31;
        b37.d r127 = this.f22341p;
        if (r127 != null) goto L25;
        int r128 = 0;
    L26:
        int r129 = (r126 + r128) * 31;
        List<d> r130 = this.f22342q;
        if (r130 == null) goto L31;
        r113 = r130.hashCode();
    L31:
        return r129 + r113;
    L25:
        r128 = r127.hashCode();
        goto L26
    L21:
        r125 = 1237;
        goto L22
    L17:
        r123 = r122.hashCode();
        goto L18
    L13:
        r120 = r119.hashCode();
        goto L14
    L9:
        r117 = r116.hashCode();
        goto L10
    L5:
        r114 = r112.hashCode();
        goto L6
    }

    public final String toString() {
        return "StartNaviParams(startPointLatitude=" + this.f22326a + ", startPointLongitude=" + this.f22327b + ", startPointAltitude=" + this.f22328c + ", endPointLatitude=" + this.f22329d + ", endPointLongitude=" + this.f22330e + ", endPointAltitude=" + this.f22331f + ", routePlanType=" + this.f22332g + ", notificationResId=" + this.f22333h + ", notificationTitle=" + this.f22334i + ", rotationChangeInterval=" + this.f22335j + ", sessionId=" + this.f22336k + ", businessId=" + this.f22337l + ", poiId=" + this.f22338m + ", poiType=" + this.f22339n + ", enableForegroundService=" + this.f22340o + ", initialLocation=" + this.f22341p + ", wayPoints=" + this.f22342q + ")";
    }

    public static g a(g r210, b37.d r211) {
        double r100 = r210.f22326a;
        double r101 = r210.f22327b;
        double r102 = r210.f22328c;
        double r103 = r210.f22329d;
        double r104 = r210.f22330e;
        double r110 = r210.f22331f;
        int r111 = r210.f22332g;
        int r112 = r210.f22333h;
        String r113 = r210.f22334i;
        int r114 = r210.f22335j;
        String r115 = r210.f22336k;
        String r116 = r210.f22337l;
        String r117 = r210.f22338m;
        Integer r118 = r210.f22339n;
        boolean r119 = r210.f22340o;
        List<d> r120 = r210.f22342q;
        r210.getClass();
        Intrinsics.checkNotNullParameter(r113, "notificationTitle");
        return new g(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r120);
    }

    public g(double r100, double r101, double r102, double r110, double r111, double r112, int r113, int r114, String r115, int r210, String r211, String r212, String r213, Integer r214, boolean r215, b37.d r216, List<d> r217) {
        Intrinsics.checkNotNullParameter(r115, "notificationTitle");
        this.f22326a = r100;
        this.f22327b = r101;
        this.f22328c = r102;
        this.f22329d = r110;
        this.f22330e = r111;
        this.f22331f = r112;
        this.f22332g = r113;
        this.f22333h = r114;
        this.f22334i = r115;
        this.f22335j = r210;
        this.f22336k = r211;
        this.f22337l = r212;
        this.f22338m = r213;
        this.f22339n = r214;
        this.f22340o = r215;
        this.f22341p = r216;
        this.f22342q = r217;
    }
}
