package c1;

/* loaded from: classes.dex */
public final class v implements d2.c, g7.d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x f1842f;

    /* renamed from: g, reason: collision with root package name */
    public final ia.m f1843g;

    /* renamed from: h, reason: collision with root package name */
    public ia.m f1844h;

    /* renamed from: i, reason: collision with root package name */
    public g f1845i = g.f1798g;

    /* renamed from: j, reason: collision with root package name */
    public final g7.m f1846j = g7.m.f3866f;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f1847k;

    public v(x xVar, ia.m mVar) {
        this.f1847k = xVar;
        this.f1842f = xVar;
        this.f1843g = mVar;
    }

    @Override // d2.c
    public final long F(long j2) {
        return this.f1842f.F(j2);
    }

    @Override // d2.c
    public final float J(long j2) {
        return this.f1842f.J(j2);
    }

    @Override // d2.c
    public final long R(float f10) {
        return this.f1842f.R(f10);
    }

    @Override // d2.c
    public final float X(float f10) {
        return f10 / this.f1842f.c();
    }

    public final Object b(g gVar, i7.a aVar) {
        ia.m mVar = new ia.m(1, ib.k.C(aVar));
        mVar.s();
        this.f1845i = gVar;
        this.f1844h = mVar;
        Object objR = mVar.r();
        h7.a aVar2 = h7.a.f4212f;
        return objR;
    }

    @Override // d2.c
    public final float c() {
        return this.f1842f.c();
    }

    @Override // g7.d
    public final g7.l getContext() {
        return this.f1846j;
    }

    @Override // d2.c
    public final float j() {
        return this.f1842f.j();
    }

    @Override // d2.c
    public final long n(float f10) {
        return this.f1842f.n(f10);
    }

    @Override // d2.c
    public final float o(float f10) {
        return this.f1842f.c() * f10;
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        x xVar = this.f1847k;
        synchronized (xVar.A) {
            xVar.f1856z.i(this);
        }
        this.f1843g.resumeWith(obj);
    }

    @Override // d2.c
    public final float t(long j2) {
        return this.f1842f.t(j2);
    }

    @Override // d2.c
    public final int y(float f10) {
        return this.f1842f.y(f10);
    }
}
