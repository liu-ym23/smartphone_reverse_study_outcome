package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final e f15979a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15980b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15981c;

    public n(e eVar, long j10, boolean z10) {
        this.f15979a = eVar;
        this.f15980b = j10;
        this.f15981c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return yb.k.a(this.f15979a, nVar.f15979a) && this.f15980b == nVar.f15980b && this.f15981c == nVar.f15981c;
    }

    public final int hashCode() {
        e eVar = this.f15979a;
        return Boolean.hashCode(this.f15981c) + k0.a.i(this.f15980b, (eVar == null ? 0 : eVar.hashCode()) * 31, 31);
    }

    public final String toString() {
        return "CacheView(bundle=" + this.f15979a + ", updatedAtMs=" + this.f15980b + ", withinTtl=" + this.f15981c + ")";
    }
}
