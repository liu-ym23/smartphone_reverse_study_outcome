package c1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public long f2165a;

    public static final /* synthetic */ b a(long j10) {
        b bVar = new b();
        bVar.f2165a = j10;
        VarHandle.storeStoreFence();
        return bVar;
    }

    public static long b(int i, long j10) {
        return (Float.floatToRawIntBits((i & 1) != 0 ? Float.intBitsToFloat((int) (j10 >> 32)) : 0.0f) << 32) | (Float.floatToRawIntBits((i & 2) != 0 ? Float.intBitsToFloat((int) (j10 & 4294967295L)) : 0.0f) & 4294967295L);
    }

    public static final boolean c(long j10, long j11) {
        return j10 == j11;
    }

    public static final float d(long j10) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat2 * fIntBitsToFloat2) + (fIntBitsToFloat * fIntBitsToFloat));
    }

    public static final float e(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    public static final float f(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    public static final long g(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) - Float.intBitsToFloat((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) - Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public static final long h(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat((int) (j10 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final long i(float f5, long j10) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) * f5;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) * f5;
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static String j(long j10) {
        if ((9223372034707292159L & j10) == 9205357640488583168L) {
            return "Offset.Unspecified";
        }
        return "Offset(" + id.c.L(Float.intBitsToFloat((int) (j10 >> 32))) + ", " + id.c.L(Float.intBitsToFloat((int) (j10 & 4294967295L))) + ')';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && this.f2165a == ((b) obj).f2165a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2165a);
    }

    public final String toString() {
        return j(this.f2165a);
    }
}
