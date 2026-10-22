package t0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f9654a;

    public static long a(int i2, long j2) {
        return (Float.floatToRawIntBits((i2 & 1) != 0 ? Float.intBitsToFloat((int) (j2 >> 32)) : 0.0f) << 32) | (Float.floatToRawIntBits((i2 & 2) != 0 ? Float.intBitsToFloat((int) (j2 & 4294967295L)) : 0.0f) & 4294967295L);
    }

    public static final boolean b(long j2, long j4) {
        return j2 == j4;
    }

    public static final float c(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat2 * fIntBitsToFloat2) + (fIntBitsToFloat * fIntBitsToFloat));
    }

    public static final float d(long j2) {
        return Float.intBitsToFloat((int) (j2 >> 32));
    }

    public static final float e(long j2) {
        return Float.intBitsToFloat((int) (j2 & 4294967295L));
    }

    public static final long f(long j2, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - Float.intBitsToFloat((int) (j4 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public static final long g(long j2, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j4 & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final long h(float f10, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) * f10;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) * f10;
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static String i(long j2) {
        if ((9223372034707292159L & j2) == 9205357640488583168L) {
            return "Offset.Unspecified";
        }
        return "Offset(" + n7.a.D(Float.intBitsToFloat((int) (j2 >> 32))) + ", " + n7.a.D(Float.intBitsToFloat((int) (j2 & 4294967295L))) + ')';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f9654a == ((b) obj).f9654a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9654a);
    }

    public final String toString() {
        return i(this.f9654a);
    }
}
