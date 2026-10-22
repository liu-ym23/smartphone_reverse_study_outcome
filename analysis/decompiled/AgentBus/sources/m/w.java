package m;

import i1.l0;
import i1.m0;
import n.b1;
import n.t0;
import n.u0;

/* loaded from: classes.dex */
public final class w extends n0.l implements i1.v {
    public long A = l.f6076a;
    public n0.e B;
    public final c1.w C;

    /* renamed from: t, reason: collision with root package name */
    public b1 f6109t;

    /* renamed from: u, reason: collision with root package name */
    public u0 f6110u;

    /* renamed from: v, reason: collision with root package name */
    public u0 f6111v;

    /* renamed from: w, reason: collision with root package name */
    public y f6112w;

    /* renamed from: x, reason: collision with root package name */
    public z f6113x;

    /* renamed from: y, reason: collision with root package name */
    public p7.a f6114y;

    /* renamed from: z, reason: collision with root package name */
    public o f6115z;

    public w(b1 b1Var, u0 u0Var, u0 u0Var2, y yVar, z zVar, p7.a aVar, o oVar) {
        this.f6109t = b1Var;
        this.f6110u = u0Var;
        this.f6111v = u0Var2;
        this.f6112w = yVar;
        this.f6113x = zVar;
        this.f6114y = aVar;
        this.f6115z = oVar;
        d2.b.b(0, 0, 15);
        this.C = new c1.w(16, this);
        new f(this);
    }

    @Override // i1.v
    public final l0 G(m0 m0Var, g1.o oVar, long j2) {
        if (this.f6109t.c() == this.f6109t.f6549d.getValue()) {
            this.B = null;
        } else if (this.B == null) {
            n0.e eVarL0 = l0();
            if (eVarL0 == null) {
                eVarL0 = n0.b.f6772f;
            }
            this.B = eVarL0;
        }
        boolean zJ0 = m0Var.j0();
        d7.a0 a0Var = d7.a0.f2944f;
        if (zJ0) {
            g1.s sVarB = oVar.b(j2);
            long jA = ib.k.a(sVarB.f3756f, sVarB.f3757g);
            this.A = jA;
            return m0Var.l0((int) (jA >> 32), (int) (jA & 4294967295L), a0Var, new g1.v(sVarB, 3));
        }
        if (!((Boolean) this.f6114y.c()).booleanValue()) {
            g1.s sVarB2 = oVar.b(j2);
            return m0Var.l0(sVarB2.f3756f, sVarB2.f3757g, a0Var, new g1.v(sVarB2, 4));
        }
        o oVar2 = this.f6115z;
        u0 u0Var = oVar2.f6084a;
        b1 b1Var = oVar2.f6085b;
        y yVar = oVar2.f6086c;
        z zVar = oVar2.f6087d;
        t0 t0VarA = u0Var != null ? u0Var.a(new p(yVar, zVar, 0), new p(yVar, zVar, 1)) : null;
        b1Var.c();
        q qVar = new q(t0VarA, null, null, 0);
        g1.s sVarB3 = oVar.b(j2);
        long jA2 = ib.k.a(sVarB3.f3756f, sVarB3.f3757g);
        long j4 = !d2.k.a(this.A, l.f6076a) ? this.A : jA2;
        u0 u0Var2 = this.f6110u;
        t0 t0VarA2 = u0Var2 != null ? u0Var2.a(this.C, new v(this, j4, 0)) : null;
        if (t0VarA2 != null) {
            jA2 = ((d2.k) t0VarA2.getValue()).f2792a;
        }
        long jD = d2.b.d(j2, jA2);
        u0 u0Var3 = this.f6111v;
        long j10 = u0Var3 != null ? ((d2.i) u0Var3.a(f.f6060i, new v(this, j4, 1)).getValue()).f2786a : 0L;
        n0.e eVar = this.B;
        return m0Var.l0((int) (jD >> 32), (int) (jD & 4294967295L), a0Var, new u(sVarB3, d2.i.c(eVar != null ? eVar.a(j4, jD, d2.l.f2793f) : 0L, 0L), j10, qVar, 0));
    }

    @Override // n0.l
    public final void d0() {
        this.A = l.f6076a;
    }

    public final n0.e l0() {
        if (this.f6109t.f().a(n.f6080f, n.f6081g)) {
            m mVar = this.f6112w.f6117a.f6056a;
            if (mVar != null) {
                return mVar.f6077a;
            }
            m mVar2 = this.f6113x.f6120a.f6056a;
            if (mVar2 != null) {
                return mVar2.f6077a;
            }
            return null;
        }
        m mVar3 = this.f6113x.f6120a.f6056a;
        if (mVar3 != null) {
            return mVar3.f6077a;
        }
        m mVar4 = this.f6112w.f6117a.f6056a;
        if (mVar4 != null) {
            return mVar4.f6077a;
        }
        return null;
    }
}
