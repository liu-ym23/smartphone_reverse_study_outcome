package o2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public long f9131a;

    public static final /* synthetic */ p a(long j10) {
        p pVar = new p();
        pVar.f9131a = j10;
        VarHandle.storeStoreFence();
        return pVar;
    }

    public static long b(long j10, float f5, float f10, int i) {
        if ((i & 1) != 0) {
            f5 = Float.intBitsToFloat((int) (j10 >> 32));
        }
        if ((i & 2) != 0) {
            f10 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        }
        return (Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f10) & 4294967295L);
    }

    public static final float c(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    public static final float d(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    public static final long e(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) - Float.intBitsToFloat((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) - Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public static final long f(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat((int) (j10 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static String g(long j10) {
        return "(" + c(j10) + ", " + d(j10) + ") px/sec";
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && this.f9131a == ((p) obj).f9131a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9131a);
    }

    public final String toString() {
        return g(this.f9131a);
    }
}
