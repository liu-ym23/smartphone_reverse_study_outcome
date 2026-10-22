package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final q f8671c = new q(com.stepos.statsrpk.h.t(0), com.stepos.statsrpk.h.t(0));

    /* renamed from: a, reason: collision with root package name */
    public final long f8672a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8673b;

    public q(long j10, long j11) {
        this.f8672a = j10;
        this.f8673b = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return o2.n.b(this.f8672a, qVar.f8672a) && o2.n.b(this.f8673b, qVar.f8673b);
    }

    public final int hashCode() {
        o2.o[] oVarArr = o2.n.f9127b;
        return Long.hashCode(this.f8673b) + (Long.hashCode(this.f8672a) * 31);
    }

    public final String toString() {
        return "TextIndent(firstLine=" + ((Object) o2.n.e(this.f8672a)) + ", restLine=" + ((Object) o2.n.e(this.f8673b)) + ')';
    }
}
