package n;

/* loaded from: classes.dex */
public final class m0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public final h f6659a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6660b;

    public m0(v vVar, long j2) {
        this.f6659a = vVar;
        this.f6660b = j2;
    }

    @Override // n.h
    public final h1 a(q6.b bVar) {
        return new n0(this.f6659a.a(bVar), this.f6660b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return m0Var.f6660b == this.f6660b && q7.k.a(m0Var.f6659a, this.f6659a);
    }

    public final int hashCode() {
        return Long.hashCode(this.f6660b) + (this.f6659a.hashCode() * 31);
    }
}
