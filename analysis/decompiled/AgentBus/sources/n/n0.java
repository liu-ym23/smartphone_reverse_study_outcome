package n;

/* loaded from: classes.dex */
public final class n0 implements h1 {

    /* renamed from: f, reason: collision with root package name */
    public final h1 f6674f;

    /* renamed from: g, reason: collision with root package name */
    public final long f6675g;

    public n0(h1 h1Var, long j2) {
        this.f6674f = h1Var;
        this.f6675g = j2;
    }

    @Override // n.h1
    public final boolean a() {
        return this.f6674f.a();
    }

    @Override // n.h1
    public final long c(n nVar, n nVar2, n nVar3) {
        return this.f6674f.c(nVar, nVar2, nVar3) + this.f6675g;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return n0Var.f6675g == this.f6675g && q7.k.a(n0Var.f6674f, this.f6674f);
    }

    public final int hashCode() {
        return Long.hashCode(this.f6675g) + (this.f6674f.hashCode() * 31);
    }

    @Override // n.h1
    public final n r(long j2, n nVar, n nVar2, n nVar3) {
        long j4 = this.f6675g;
        return j2 < j4 ? nVar3 : this.f6674f.r(j2 - j4, nVar, nVar2, nVar3);
    }

    @Override // n.h1
    public final n s(long j2, n nVar, n nVar2, n nVar3) {
        long j4 = this.f6675g;
        return j2 < j4 ? nVar : this.f6674f.s(j2 - j4, nVar, nVar2, nVar3);
    }
}
