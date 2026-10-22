package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final long f3134b = com.stepos.statsrpk.h.a(0, 0);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3135c = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f3136a;

    public static final int a(long j10) {
        return Math.min((int) (j10 >> 32), (int) (j10 & 4294967295L));
    }

    public static String b(long j10) {
        StringBuilder sb2 = new StringBuilder("TextRange(");
        sb2.append((int) (j10 >> 32));
        sb2.append(", ");
        return androidx.activity.b.l(sb2, (int) (j10 & 4294967295L), ')');
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k0) && this.f3136a == ((k0) obj).f3136a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f3136a);
    }

    public final String toString() {
        return b(this.f3136a);
    }
}
