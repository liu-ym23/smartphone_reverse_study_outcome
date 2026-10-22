package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public y0 f14949a;

    /* renamed from: b, reason: collision with root package name */
    public y0 f14950b;

    @Override // w.y0
    public final int a(o2.c cVar, o2.l lVar) {
        int iA = this.f14949a.a(cVar, lVar) - this.f14950b.a(cVar, lVar);
        if (iA < 0) {
            return 0;
        }
        return iA;
    }

    @Override // w.y0
    public final int b(o2.c cVar, o2.l lVar) {
        int iB = this.f14949a.b(cVar, lVar) - this.f14950b.b(cVar, lVar);
        if (iB < 0) {
            return 0;
        }
        return iB;
    }

    @Override // w.y0
    public final int c(o2.c cVar) {
        int iC = this.f14949a.c(cVar) - this.f14950b.c(cVar);
        if (iC < 0) {
            return 0;
        }
        return iC;
    }

    @Override // w.y0
    public final int d(o2.c cVar) {
        int iD = this.f14949a.d(cVar) - this.f14950b.d(cVar);
        if (iD < 0) {
            return 0;
        }
        return iD;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return yb.k.a(a0Var.f14949a, this.f14949a) && yb.k.a(a0Var.f14950b, this.f14950b);
    }

    public final int hashCode() {
        return this.f14950b.hashCode() + (this.f14949a.hashCode() * 31);
    }

    public final String toString() {
        return "(" + this.f14949a + " - " + this.f14950b + ')';
    }
}
