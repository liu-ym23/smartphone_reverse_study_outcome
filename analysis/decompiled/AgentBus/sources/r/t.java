package r;

/* loaded from: classes.dex */
public final class t implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f8938a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f8939b;

    public t(o0 o0Var, o0 o0Var2) {
        this.f8938a = o0Var;
        this.f8939b = o0Var2;
    }

    @Override // r.o0
    public final int a(i1.m0 m0Var, d2.l lVar) {
        int iA = this.f8938a.a(m0Var, lVar) - this.f8939b.a(m0Var, lVar);
        if (iA < 0) {
            return 0;
        }
        return iA;
    }

    @Override // r.o0
    public final int b(i1.m0 m0Var) {
        int iB = this.f8938a.b(m0Var) - this.f8939b.b(m0Var);
        if (iB < 0) {
            return 0;
        }
        return iB;
    }

    @Override // r.o0
    public final int c(i1.m0 m0Var) {
        int iC = this.f8938a.c(m0Var) - this.f8939b.c(m0Var);
        if (iC < 0) {
            return 0;
        }
        return iC;
    }

    @Override // r.o0
    public final int d(i1.m0 m0Var, d2.l lVar) {
        int iD = this.f8938a.d(m0Var, lVar) - this.f8939b.d(m0Var, lVar);
        if (iD < 0) {
            return 0;
        }
        return iD;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return q7.k.a(tVar.f8938a, this.f8938a) && q7.k.a(tVar.f8939b, this.f8939b);
    }

    public final int hashCode() {
        return this.f8939b.hashCode() + (this.f8938a.hashCode() * 31);
    }

    public final String toString() {
        return "(" + this.f8938a + " - " + this.f8939b + ')';
    }
}
