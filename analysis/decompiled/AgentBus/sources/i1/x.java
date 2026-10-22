package i1;

import android.graphics.Paint;

/* loaded from: classes.dex */
public final class x extends d1 {
    public static final h4.s U;
    public v S;
    public w T;

    static {
        h4.s sVarE = u0.z.e();
        sVarE.e(u0.m.f9914d);
        ((Paint) sVarE.f4155g).setStrokeWidth(1.0f);
        sVarE.k(1);
        U = sVarE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(f0 f0Var, v vVar) {
        super(f0Var);
        this.S = vVar;
        this.T = f0Var.f4458l != null ? new w(this) : null;
        if ((((n0.l) vVar).f6797f.f6799h & 512) != 0) {
            throw new ClassCastException();
        }
    }

    @Override // g1.s
    public final void M(long j2, float f10, p7.k kVar) {
        Q0(j2, f10, kVar);
        if (this.f4531o) {
            return;
        }
        M0();
        e0().e();
        q7.k.b(this.f4438u);
    }

    @Override // i1.d1
    public final void P0(u0.l lVar, x0.b bVar) {
        d1 d1Var;
        d1 d1Var2 = this.f4438u;
        q7.k.b(d1Var2);
        d1Var2.s0(lVar, bVar);
        if (!((j1.y) l.w(this.f4437t)).getShowLayoutBounds() || (d1Var = this.f4438u) == null) {
            return;
        }
        if (d2.k.a(this.f3758h, d1Var.f3758h) && d2.i.a(d1Var.E, 0L)) {
            return;
        }
        long j2 = this.f3758h;
        lVar.l(0.5f, 0.5f, ((int) (j2 >> 32)) - 0.5f, ((int) (j2 & 4294967295L)) - 0.5f, U);
    }

    @Override // i1.m0
    public final int S(g1.f fVar) {
        w wVar = this.T;
        if (wVar == null) {
            return l.c(this, fVar);
        }
        k.y yVar = wVar.f4549y;
        int iD = yVar.d(fVar);
        if (iD >= 0) {
            return yVar.f5552c[iD];
        }
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(v vVar) {
        if (!vVar.equals(this.S) && (((n0.l) vVar).f6797f.f6799h & 512) != 0) {
            throw new ClassCastException();
        }
        this.S = vVar;
    }

    @Override // g1.o
    public final g1.s b(long j2) {
        P(j2);
        v vVar = this.S;
        d1 d1Var = this.f4438u;
        q7.k.b(d1Var);
        T0(vVar.G(this, d1Var, j2));
        L0();
        return this;
    }

    @Override // i1.d1
    public final void u0() {
        if (this.T == null) {
            this.T = new w(this);
        }
    }

    @Override // i1.d1
    public final n0 x0() {
        return this.T;
    }

    @Override // i1.d1
    public final n0.l z0() {
        return ((n0.l) this.S).f6797f;
    }
}
