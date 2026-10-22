package d2;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final o[] f2797b = {new o(0), new o(4294967296L), new o(8589934592L)};

    /* renamed from: c, reason: collision with root package name */
    public static final long f2798c = s7.a.Q(Float.NaN, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f2799a;

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public static final long b(long j2) {
        return f2797b[(int) ((j2 & 1095216660480L) >>> 32)].f2800a;
    }

    public static final float c(long j2) {
        return Float.intBitsToFloat((int) (j2 & 4294967295L));
    }

    public static String d(long j2) {
        long jB = b(j2);
        if (o.a(jB, 0L)) {
            return "Unspecified";
        }
        if (o.a(jB, 4294967296L)) {
            return c(j2) + ".sp";
        }
        if (!o.a(jB, 8589934592L)) {
            return "Invalid";
        }
        return c(j2) + ".em";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f2799a == ((n) obj).f2799a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2799a);
    }

    public final String toString() {
        return d(this.f2799a);
    }
}
