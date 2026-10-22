package c1;

import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f2171a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2172b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2173c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2174d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2175e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2176f;

    /* renamed from: g, reason: collision with root package name */
    public final long f2177g;

    /* renamed from: h, reason: collision with root package name */
    public final long f2178h;

    static {
        h.e(0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    public d(float f5, float f10, float f11, float f12, long j10, long j11, long j12, long j13) {
        this.f2171a = f5;
        this.f2172b = f10;
        this.f2173c = f11;
        this.f2174d = f12;
        this.f2175e = j10;
        this.f2176f = j11;
        this.f2177g = j12;
        this.f2178h = j13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Float.compare(this.f2171a, dVar.f2171a) == 0 && Float.compare(this.f2172b, dVar.f2172b) == 0 && Float.compare(this.f2173c, dVar.f2173c) == 0 && Float.compare(this.f2174d, dVar.f2174d) == 0 && com.stepos.statsrpk.h.n(this.f2175e, dVar.f2175e) && com.stepos.statsrpk.h.n(this.f2176f, dVar.f2176f) && com.stepos.statsrpk.h.n(this.f2177g, dVar.f2177g) && com.stepos.statsrpk.h.n(this.f2178h, dVar.f2178h);
    }

    public final int hashCode() {
        return Long.hashCode(this.f2178h) + k0.a.i(this.f2177g, k0.a.i(this.f2176f, k0.a.i(this.f2175e, k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f2171a) * 31, this.f2172b, 31), this.f2173c, 31), this.f2174d, 31), 31), 31), 31);
    }

    public final String toString() {
        String str = id.c.L(this.f2171a) + ", " + id.c.L(this.f2172b) + ", " + id.c.L(this.f2173c) + ", " + id.c.L(this.f2174d);
        long j10 = this.f2175e;
        long j11 = this.f2176f;
        boolean zN = com.stepos.statsrpk.h.n(j10, j11);
        long j12 = this.f2177g;
        long j13 = this.f2178h;
        if (!zN || !com.stepos.statsrpk.h.n(j11, j12) || !com.stepos.statsrpk.h.n(j12, j13)) {
            StringBuilder sbO = androidx.activity.b.o("RoundRect(rect=", str, ", topLeft=");
            sbO.append((Object) com.stepos.statsrpk.h.H(j10));
            sbO.append(", topRight=");
            sbO.append((Object) com.stepos.statsrpk.h.H(j11));
            sbO.append(", bottomRight=");
            sbO.append((Object) com.stepos.statsrpk.h.H(j12));
            sbO.append(", bottomLeft=");
            sbO.append((Object) com.stepos.statsrpk.h.H(j13));
            sbO.append(')');
            return sbO.toString();
        }
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i3)) {
            StringBuilder sbO2 = androidx.activity.b.o("RoundRect(rect=", str, ", radius=");
            sbO2.append(id.c.L(Float.intBitsToFloat(i)));
            sbO2.append(')');
            return sbO2.toString();
        }
        StringBuilder sbO3 = androidx.activity.b.o("RoundRect(rect=", str, ", x=");
        sbO3.append(id.c.L(Float.intBitsToFloat(i)));
        sbO3.append(", y=");
        sbO3.append(id.c.L(Float.intBitsToFloat(i3)));
        sbO3.append(')');
        return sbO3.toString();
    }
}
