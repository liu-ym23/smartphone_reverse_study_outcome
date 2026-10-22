package o2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public long f9122a;

    public static final /* synthetic */ k a(long j10) {
        k kVar = new k();
        kVar.f9122a = j10;
        VarHandle.storeStoreFence();
        return kVar;
    }

    public static final boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static String c(long j10) {
        return ((int) (j10 >> 32)) + " x " + ((int) (j10 & 4294967295L));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k) && this.f9122a == ((k) obj).f9122a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9122a);
    }

    public final String toString() {
        return c(this.f9122a);
    }
}
