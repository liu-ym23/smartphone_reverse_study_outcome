package t0;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final long f9668a;

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public static final float b(long j2) {
        return Float.intBitsToFloat((int) (j2 & 4294967295L));
    }

    public static final float c(long j2) {
        return Math.min(Float.intBitsToFloat((int) ((j2 >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j2 & 2147483647L)));
    }

    public static final float d(long j2) {
        return Float.intBitsToFloat((int) (j2 >> 32));
    }

    public static final boolean e(long j2) {
        return (j2 == 9205357640488583168L) | (Float.intBitsToFloat((int) (j2 >> 32)) <= 0.0f) | (Float.intBitsToFloat((int) (j2 & 4294967295L)) <= 0.0f);
    }

    public static String f(long j2) {
        if (j2 == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + n7.a.D(Float.intBitsToFloat((int) (j2 >> 32))) + ", " + n7.a.D(Float.intBitsToFloat((int) (j2 & 4294967295L))) + ')';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f9668a == ((e) obj).f9668a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9668a);
    }

    public final String toString() {
        return f(this.f9668a);
    }
}
