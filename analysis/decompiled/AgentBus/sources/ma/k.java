package ma;

import ia.d0;

/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: j, reason: collision with root package name */
    public final i7.i f6501j;

    /* JADX WARN: Multi-variable type inference failed */
    public k(p7.o oVar, la.j jVar, g7.l lVar, int i2, ka.a aVar) {
        super(i2, lVar, aVar, jVar);
        this.f6501j = (i7.i) oVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [i7.i, p7.o] */
    @Override // ma.e
    public final e c(g7.l lVar, int i2, ka.a aVar) {
        return new k(this.f6501j, this.f6485i, lVar, i2, aVar);
    }

    @Override // ma.f
    public final Object f(la.k kVar, g7.d dVar) throws Throwable {
        Object objF = d0.f(new h(this, kVar, null), dVar);
        return objF == h7.a.f4212f ? objF : c7.r.f1986a;
    }
}
