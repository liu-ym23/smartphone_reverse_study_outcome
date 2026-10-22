package n0;

/* loaded from: classes.dex */
public final class g implements m {

    /* renamed from: a, reason: collision with root package name */
    public final m f6792a;

    /* renamed from: b, reason: collision with root package name */
    public final m f6793b;

    public g(m mVar, m mVar2) {
        this.f6792a = mVar;
        this.f6793b = mVar2;
    }

    @Override // n0.m
    public final Object a(Object obj, p7.n nVar) {
        return this.f6793b.a(this.f6792a.a(obj, nVar), nVar);
    }

    @Override // n0.m
    public final boolean b(p7.k kVar) {
        return this.f6792a.b(kVar) && this.f6793b.b(kVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return q7.k.a(this.f6792a, gVar.f6792a) && q7.k.a(this.f6793b, gVar.f6793b);
    }

    public final int hashCode() {
        return (this.f6793b.hashCode() * 31) + this.f6792a.hashCode();
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("["), (String) a("", f.f6791g), ']');
    }
}
