package ia;

/* loaded from: classes.dex */
public final class p1 extends w1 {

    /* renamed from: i, reason: collision with root package name */
    public final g7.d f4993i;

    public p1(g7.l lVar, p7.n nVar) {
        super(lVar, false);
        this.f4993i = ib.k.r(this, this, nVar);
    }

    @Override // ia.o1
    public final void d0() throws Throwable {
        try {
            na.b.h(ib.k.C(this.f4993i), c7.r.f1986a);
        } catch (Throwable th) {
            th = th;
            if (th instanceof k0) {
                th = ((k0) th).f4965f;
            }
            resumeWith(w7.e0.n(th));
            throw th;
        }
    }
}
