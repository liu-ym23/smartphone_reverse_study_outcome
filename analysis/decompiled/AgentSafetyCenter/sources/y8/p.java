package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends q {

    /* renamed from: a, reason: collision with root package name */
    public final n f15983a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15984b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15985c;

    public p(n nVar, boolean z10, boolean z11) {
        this.f15983a = nVar;
        this.f15984b = z10;
        this.f15985c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f15983a.equals(pVar.f15983a) && this.f15984b == pVar.f15984b && this.f15985c == pVar.f15985c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f15985c) + k0.a.h(this.f15983a.hashCode() * 31, 31, this.f15984b);
    }

    public final String toString() {
        return "Ok(view=" + this.f15983a + ", fromCache=" + this.f15984b + ", stale=" + this.f15985c + ")";
    }
}
