package d2;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final long f2801a;

    public static long a(long j2, float f10, float f11, int i2) {
        if ((i2 & 1) != 0) {
            f10 = Float.intBitsToFloat((int) (j2 >> 32));
        }
        if ((i2 & 2) != 0) {
            f11 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        }
        return (Float.floatToRawIntBits(f10) << 32) | (Float.floatToRawIntBits(f11) & 4294967295L);
    }

    public static final float b(long j2) {
        return Float.intBitsToFloat((int) (j2 >> 32));
    }

    public static final float c(long j2) {
        return Float.intBitsToFloat((int) (j2 & 4294967295L));
    }

    public static final long d(long j2, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - Float.intBitsToFloat((int) (j4 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public static final long e(long j2, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j4 & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static String f(long j2) {
        return "(" + b(j2) + ", " + c(j2) + ") px/sec";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f2801a == ((p) obj).f2801a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2801a);
    }

    public final String toString() {
        return f(this.f2801a);
    }
}
