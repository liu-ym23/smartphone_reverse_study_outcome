package r;

/* loaded from: classes.dex */
public final class l0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f8887a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f8888b;

    public l0(o0 o0Var, o0 o0Var2) {
        this.f8887a = o0Var;
        this.f8888b = o0Var2;
    }

    @Override // r.o0
    public final int a(i1.m0 m0Var, d2.l lVar) {
        return Math.max(this.f8887a.a(m0Var, lVar), this.f8888b.a(m0Var, lVar));
    }

    @Override // r.o0
    public final int b(i1.m0 m0Var) {
        return Math.max(this.f8887a.b(m0Var), this.f8888b.b(m0Var));
    }

    @Override // r.o0
    public final int c(i1.m0 m0Var) {
        return Math.max(this.f8887a.c(m0Var), this.f8888b.c(m0Var));
    }

    @Override // r.o0
    public final int d(i1.m0 m0Var, d2.l lVar) {
        return Math.max(this.f8887a.d(m0Var, lVar), this.f8888b.d(m0Var, lVar));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return q7.k.a(l0Var.f8887a, this.f8887a) && q7.k.a(l0Var.f8888b, this.f8888b);
    }

    public final int hashCode() {
        return (this.f8888b.hashCode() * 31) + this.f8887a.hashCode();
    }

    public final String toString() {
        return "(" + this.f8887a + " ∪ " + this.f8888b + ')';
    }
}
