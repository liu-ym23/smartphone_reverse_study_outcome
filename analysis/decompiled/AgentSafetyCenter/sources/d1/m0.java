package d1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: b, reason: collision with root package name */
    public static final long f3015b = (Float.floatToRawIntBits(0.5f) << 32) | (Float.floatToRawIntBits(0.5f) & 4294967295L);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3016c = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f3017a;

    public static final /* synthetic */ m0 a(long j10) {
        m0 m0Var = new m0();
        m0Var.f3017a = j10;
        VarHandle.storeStoreFence();
        return m0Var;
    }

    public static final boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static String c(long j10) {
        return "TransformOrigin(packedValue=" + j10 + ')';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m0) && this.f3017a == ((m0) obj).f3017a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f3017a);
    }

    public final String toString() {
        return c(this.f3017a);
    }
}
