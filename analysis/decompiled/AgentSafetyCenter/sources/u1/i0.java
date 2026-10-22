package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 implements f1.d {

    /* renamed from: c, reason: collision with root package name */
    public f1.b f13838c;

    /* renamed from: f, reason: collision with root package name */
    public n f13839f;

    @Override // f1.d
    public final void C(d1.h hVar, long j10, td.h hVar2) {
        this.f13838c.C(hVar, j10, hVar2);
    }

    @Override // o2.c
    public final long E(float f5) {
        return this.f13838c.E(f5);
    }

    @Override // f1.d
    public final void G(d1.e eVar, long j10, long j11, long j12, float f5, d1.l lVar, int i) {
        this.f13838c.G(eVar, j10, j11, j12, f5, lVar, i);
    }

    @Override // o2.c
    public final float J(int i) {
        return this.f13838c.J(i);
    }

    @Override // f1.d
    public final void K(long j10, long j11, long j12, td.h hVar, int i) {
        this.f13838c.K(j10, j11, j12, hVar, i);
    }

    @Override // o2.c
    public final float M(float f5) {
        return f5 / this.f13838c.a();
    }

    @Override // f1.d
    public final void O(long j10, float f5, long j11, td.h hVar) {
        this.f13838c.O(j10, f5, j11, hVar);
    }

    @Override // o2.c
    public final float T() {
        return this.f13838c.T();
    }

    @Override // o2.c
    public final float X(float f5) {
        return this.f13838c.a() * f5;
    }

    @Override // o2.c
    public final float a() {
        return this.f13838c.a();
    }

    @Override // f1.d
    public final p5.m a0() {
        return this.f13838c.f3859f;
    }

    public final void b() {
        f1.b bVar = this.f13838c;
        p5.m mVar = bVar.f3859f;
        d1.o oVarY = bVar.f3859f.y();
        l lVar = this.f13839f;
        if (lVar == null) {
            throw w2.c.a("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        w0.l lVar2 = (w0.l) lVar;
        w0.l lVarE = lVar2.f15114c.f15118j;
        if (lVarE == null || (lVarE.f15117h & 4) == 0) {
            lVarE = null;
        } else {
            while (lVarE != null) {
                int i = lVarE.f15116g;
                if ((i & 2) != 0) {
                    break;
                } else if ((i & 4) != 0) {
                    break;
                } else {
                    lVarE = lVarE.f15118j;
                }
            }
            lVarE = null;
        }
        if (lVarE == null) {
            g1 g1VarS = f.s(lVar, 4);
            if (g1VarS.H0() == lVar2.f15114c) {
                g1VarS = g1VarS.f13811t;
                g1VarS.getClass();
            }
            g1VarS.V0(oVarY, (g1.b) mVar.f9742g);
            return;
        }
        m0.e eVar = null;
        while (lVarE != null) {
            if (lVarE instanceof n) {
                n nVar = (n) lVarE;
                g1.b bVar2 = (g1.b) mVar.f9742g;
                g1 g1VarS2 = f.s(nVar, 4);
                long jI0 = ac.a.i0(g1VarS2.f11279g);
                g0 g0Var = g1VarS2.f13810s;
                g0Var.getClass();
                ((v1.t) j0.a(g0Var)).getSharedDrawScope().c(oVarY, jI0, g1VarS2, nVar, bVar2);
            } else if ((lVarE.f15116g & 4) != 0 && (lVarE instanceof m)) {
                int i3 = 0;
                for (w0.l lVar3 = ((m) lVarE).f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
                    if ((lVar3.f15116g & 4) != 0) {
                        i3++;
                        if (i3 == 1) {
                            lVarE = lVar3;
                        } else {
                            if (eVar == null) {
                                eVar = new m0.e(new w0.l[16]);
                            }
                            if (lVarE != null) {
                                eVar.b(lVarE);
                                lVarE = null;
                            }
                            eVar.b(lVar3);
                        }
                    }
                }
                if (i3 == 1) {
                }
            }
            lVarE = f.e(eVar);
        }
    }

    public final void c(d1.o oVar, long j10, g1 g1Var, n nVar, g1.b bVar) {
        n nVar2 = this.f13839f;
        this.f13839f = nVar;
        f1.b bVar2 = this.f13838c;
        o2.l lVar = g1Var.f13810s.B;
        p5.m mVar = bVar2.f3859f;
        f1.a aVar = ((f1.b) mVar.f9743h).f3858c;
        o2.c cVar = aVar.f3854a;
        o2.l lVar2 = aVar.f3855b;
        d1.o oVarY = mVar.y();
        long jD = mVar.D();
        g1.b bVar3 = (g1.b) mVar.f9742g;
        mVar.P(g1Var);
        mVar.Q(lVar);
        mVar.O(oVar);
        mVar.R(j10);
        mVar.f9742g = bVar;
        oVar.i();
        try {
            nVar.b(this);
            oVar.o();
            mVar.P(cVar);
            mVar.Q(lVar2);
            mVar.O(oVarY);
            mVar.R(jD);
            mVar.f9742g = bVar3;
            this.f13839f = nVar2;
        } catch (Throwable th) {
            oVar.o();
            mVar.P(cVar);
            mVar.Q(lVar2);
            mVar.O(oVarY);
            mVar.R(jD);
            mVar.f9742g = bVar3;
            throw th;
        }
    }

    public final void d(d1.f0 f0Var, long j10, long j11, float f5, td.h hVar) {
        f1.b bVar = this.f13838c;
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        bVar.f3858c.f3856c.b(Float.intBitsToFloat(i), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat(i3), bVar.c(f0Var, hVar, f5, null, 3, 1));
    }

    @Override // f1.d
    public final long e() {
        return this.f13838c.e();
    }

    @Override // o2.c
    public final int e0(float f5) {
        return this.f13838c.e0(f5);
    }

    public final void f(d1.f0 f0Var, long j10, long j11, long j12, float f5, td.h hVar) {
        f1.b bVar = this.f13838c;
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        bVar.f3858c.f3856c.f(Float.intBitsToFloat(i), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j12 >> 32)), Float.intBitsToFloat((int) (j12 & 4294967295L)), bVar.c(f0Var, hVar, f5, null, 3, 1));
    }

    @Override // f1.d
    public final long g0() {
        return this.f13838c.g0();
    }

    @Override // f1.d
    public final o2.l getLayoutDirection() {
        return this.f13838c.f3858c.f3855b;
    }

    @Override // f1.d
    public final void i0(d1.h hVar, d1.f0 f0Var, float f5, td.h hVar2, int i) {
        this.f13838c.i0(hVar, f0Var, f5, hVar2, i);
    }

    @Override // f1.d
    public final void j(long j10, long j11, long j12, float f5, d1.i iVar) {
        this.f13838c.j(j10, j11, j12, f5, iVar);
    }

    @Override // o2.c
    public final long j0(long j10) {
        return this.f13838c.j0(j10);
    }

    @Override // o2.c
    public final float m0(long j10) {
        return this.f13838c.m0(j10);
    }

    @Override // o2.c
    public final long n(float f5) {
        return this.f13838c.n(f5);
    }

    @Override // f1.d
    public final void n0(long j10, float f5, float f10, long j11, long j12, td.h hVar) {
        this.f13838c.n0(j10, f5, f10, j11, j12, hVar);
    }

    @Override // o2.c
    public final float u(long j10) {
        return this.f13838c.u(j10);
    }
}
