package u0;

/* loaded from: classes.dex */
public final class v extends w {

    /* renamed from: a, reason: collision with root package name */
    public final t0.d f9926a;

    /* renamed from: b, reason: collision with root package name */
    public final f f9927b;

    public v(t0.d dVar) {
        f fVarA;
        this.f9926a = dVar;
        if (n7.o.r(dVar)) {
            fVarA = null;
        } else {
            fVarA = h.a();
            f.b(fVarA, dVar);
        }
        this.f9927b = fVarA;
    }

    @Override // u0.w
    public final t0.c a() {
        t0.d dVar = this.f9926a;
        return new t0.c(dVar.f9660a, dVar.f9661b, dVar.f9662c, dVar.f9663d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            return q7.k.a(this.f9926a, ((v) obj).f9926a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9926a.hashCode();
    }
}
