package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public y0 f15057a;

    /* renamed from: b, reason: collision with root package name */
    public y0 f15058b;

    @Override // w.y0
    public final int a(o2.c cVar, o2.l lVar) {
        return Math.max(this.f15057a.a(cVar, lVar), this.f15058b.a(cVar, lVar));
    }

    @Override // w.y0
    public final int b(o2.c cVar, o2.l lVar) {
        return Math.max(this.f15057a.b(cVar, lVar), this.f15058b.b(cVar, lVar));
    }

    @Override // w.y0
    public final int c(o2.c cVar) {
        return Math.max(this.f15057a.c(cVar), this.f15058b.c(cVar));
    }

    @Override // w.y0
    public final int d(o2.c cVar) {
        return Math.max(this.f15057a.d(cVar), this.f15058b.d(cVar));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return yb.k.a(v0Var.f15057a, this.f15057a) && yb.k.a(v0Var.f15058b, this.f15058b);
    }

    public final int hashCode() {
        return (this.f15058b.hashCode() * 31) + this.f15057a.hashCode();
    }

    public final String toString() {
        return "(" + this.f15057a + " ∪ " + this.f15058b + ')';
    }
}
