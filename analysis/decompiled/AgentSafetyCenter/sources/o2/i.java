package o2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public long f9116a;

    public static final /* synthetic */ i a(long j10) {
        i iVar = new i();
        iVar.f9116a = j10;
        VarHandle.storeStoreFence();
        return iVar;
    }

    public static final boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static final long c(long j10, long j11) {
        return ((((int) (j10 >> 32)) - ((int) (j11 >> 32))) << 32) | ((((int) (j10 & 4294967295L)) - ((int) (j11 & 4294967295L))) & 4294967295L);
    }

    public static final long d(long j10, long j11) {
        return ((((int) (j10 >> 32)) + ((int) (j11 >> 32))) << 32) | ((((int) (j10 & 4294967295L)) + ((int) (j11 & 4294967295L))) & 4294967295L);
    }

    public static String e(long j10) {
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append((int) (j10 >> 32));
        sb2.append(", ");
        return androidx.activity.b.l(sb2, (int) (j10 & 4294967295L), ')');
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i) && this.f9116a == ((i) obj).f9116a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9116a);
    }

    public final String toString() {
        return e(this.f9116a);
    }
}
