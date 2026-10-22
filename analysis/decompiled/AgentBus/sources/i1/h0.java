package i1;

/* loaded from: classes.dex */
public final class h0 implements w0.d {

    /* renamed from: f, reason: collision with root package name */
    public final w0.b f4489f = new w0.b();

    /* renamed from: g, reason: collision with root package name */
    public m f4490g;

    @Override // w0.d
    public final long D() {
        return this.f4489f.D();
    }

    @Override // d2.c
    public final long F(long j2) {
        return this.f4489f.F(j2);
    }

    @Override // d2.c
    public final float J(long j2) {
        return this.f4489f.J(j2);
    }

    @Override // w0.d
    public final void L(long j2, long j4, long j10, float f10) {
        this.f4489f.L(j2, j4, j10, f10);
    }

    @Override // w0.d
    public final void O(u0.f fVar, u0.z zVar, float f10, w0.c cVar, int i2) {
        this.f4489f.O(fVar, zVar, f10, cVar, i2);
    }

    @Override // d2.c
    public final long R(float f10) {
        return this.f4489f.R(f10);
    }

    @Override // w0.d
    public final void U(long j2, long j4, long j10, w0.c cVar, int i2) {
        this.f4489f.U(j2, j4, j10, cVar, i2);
    }

    @Override // d2.c
    public final float X(float f10) {
        return f10 / this.f4489f.c();
    }

    public final void a() {
        w0.b bVar = this.f4489f;
        u0.l lVarA = bVar.f10630g.a();
        j jVar = this.f4490g;
        if (jVar == null) {
            throw m.x.i("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        n0.l lVar = (n0.l) jVar;
        n0.l lVarE = lVar.f6797f.f6802k;
        if (lVarE == null || (lVarE.f6800i & 4) == 0) {
            lVarE = null;
        } else {
            while (lVarE != null) {
                int i2 = lVarE.f6799h;
                if ((i2 & 2) != 0) {
                    break;
                } else if ((i2 & 4) != 0) {
                    break;
                } else {
                    lVarE = lVarE.f6802k;
                }
            }
            lVarE = null;
        }
        if (lVarE == null) {
            d1 d1VarS = l.s(jVar, 4);
            if (d1VarS.z0() == lVar.f6797f) {
                d1VarS = d1VarS.f4438u;
                q7.k.b(d1VarS);
            }
            d1VarS.P0(lVarA, (x0.b) bVar.f10630g.f10130b);
            return;
        }
        d0.e eVar = null;
        while (lVarE != null) {
            if (lVarE instanceof m) {
                m mVar = (m) lVarE;
                x0.b bVar2 = (x0.b) bVar.f10630g.f10130b;
                d1 d1VarS2 = l.s(mVar, 4);
                long jW = ib.k.W(d1VarS2.f3758h);
                f0 f0Var = d1VarS2.f4437t;
                f0Var.getClass();
                ((j1.y) l.w(f0Var)).getSharedDrawScope().b(lVarA, jW, d1VarS2, mVar, bVar2);
            } else if ((lVarE.f6799h & 4) != 0 && (lVarE instanceof k)) {
                int i10 = 0;
                for (n0.l lVar2 = ((k) lVarE).f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
                    if ((lVar2.f6799h & 4) != 0) {
                        i10++;
                        if (i10 == 1) {
                            lVarE = lVar2;
                        } else {
                            if (eVar == null) {
                                eVar = new d0.e(new n0.l[16]);
                            }
                            if (lVarE != null) {
                                eVar.b(lVarE);
                                lVarE = null;
                            }
                            eVar.b(lVar2);
                        }
                    }
                }
                if (i10 == 1) {
                }
            }
            lVarE = l.e(eVar);
        }
    }

    public final void b(u0.l lVar, long j2, d1 d1Var, m mVar, x0.b bVar) {
        m mVar2 = this.f4490g;
        this.f4490g = mVar;
        d2.l lVar2 = d1Var.f4437t.B;
        w0.b bVar2 = this.f4489f;
        u5.h hVar = bVar2.f10630g;
        w0.a aVar = ((w0.b) hVar.f10131c).f10629f;
        d2.c cVar = aVar.f10625a;
        d2.l lVar3 = aVar.f10626b;
        u0.l lVarA = hVar.a();
        u5.h hVar2 = bVar2.f10630g;
        long jB = hVar2.b();
        x0.b bVar3 = (x0.b) hVar2.f10130b;
        hVar2.h(d1Var);
        hVar2.i(lVar2);
        hVar2.g(lVar);
        hVar2.j(j2);
        hVar2.f10130b = bVar;
        lVar.h();
        try {
            mVar.e(this);
            lVar.g();
            hVar2.h(cVar);
            hVar2.i(lVar3);
            hVar2.g(lVarA);
            hVar2.j(jB);
            hVar2.f10130b = bVar3;
            this.f4490g = mVar2;
        } catch (Throwable th) {
            lVar.g();
            hVar2.h(cVar);
            hVar2.i(lVar3);
            hVar2.g(lVarA);
            hVar2.j(jB);
            hVar2.f10130b = bVar3;
            throw th;
        }
    }

    @Override // d2.c
    public final float c() {
        return this.f4489f.c();
    }

    @Override // w0.d
    public final long d() {
        return this.f4489f.d();
    }

    public final void e(u0.f fVar, long j2, w0.c cVar) {
        w0.b bVar = this.f4489f;
        bVar.f10629f.f10627c.k(fVar, w0.b.a(bVar, j2, cVar, 3));
    }

    public final d2.l f() {
        return this.f4489f.f10629f.f10626b;
    }

    @Override // d2.c
    public final float j() {
        return this.f4489f.j();
    }

    @Override // d2.c
    public final long n(float f10) {
        return this.f4489f.n(f10);
    }

    @Override // d2.c
    public final float o(float f10) {
        return this.f4489f.c() * f10;
    }

    @Override // w0.d
    public final u5.h r() {
        return this.f4489f.f10630g;
    }

    @Override // d2.c
    public final float t(long j2) {
        return this.f4489f.t(j2);
    }

    @Override // d2.c
    public final int y(float f10) {
        return this.f4489f.y(f10);
    }

    @Override // w0.d
    public final void z(long j2, float f10, float f11, long j4, long j10, w0.c cVar) {
        this.f4489f.z(j2, f10, f11, j4, j10, cVar);
    }
}
