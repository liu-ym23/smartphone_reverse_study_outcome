package c1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public long f2179a;

    public static final /* synthetic */ e a(long j10) {
        e eVar = new e();
        eVar.f2179a = j10;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public static final boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static final float c(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    public static final float d(long j10) {
        return Math.min(Float.intBitsToFloat((int) ((j10 >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j10 & 2147483647L)));
    }

    public static final float e(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    public static final boolean f(long j10) {
        return (j10 == 9205357640488583168L) | (Float.intBitsToFloat((int) (j10 >> 32)) <= 0.0f) | (Float.intBitsToFloat((int) (j10 & 4294967295L)) <= 0.0f);
    }

    public static String g(long j10) {
        if (j10 == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + id.c.L(Float.intBitsToFloat((int) (j10 >> 32))) + ", " + id.c.L(Float.intBitsToFloat((int) (j10 & 4294967295L))) + ')';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && this.f2179a == ((e) obj).f2179a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2179a);
    }

    public final String toString() {
        return g(this.f2179a);
    }
}
