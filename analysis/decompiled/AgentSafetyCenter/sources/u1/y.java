package u1;

import android.graphics.Paint;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends g1 {
    public static final d1.f T;
    public w R;
    public x S;

    static {
        d1.f fVarF = d1.f0.f();
        fVarF.e(d1.p.f3022e);
        ((Paint) fVarF.f2968b).setStrokeWidth(1.0f);
        fVarF.j(1);
        T = fVarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(g0 g0Var, w wVar) {
        super(g0Var);
        this.R = wVar;
        this.S = g0Var.f13794k != null ? new x(this) : null;
        if ((((w0.l) wVar).f15114c.f15116g & 512) == 0) {
            return;
        }
        od.f.j();
        throw null;
    }

    @Override // u1.g1
    public final void C0() {
        if (this.S == null) {
            this.S = new x(this);
        }
    }

    @Override // u1.g1
    public final p0 F0() {
        return this.S;
    }

    @Override // u1.g1
    public final w0.l H0() {
        return ((w0.l) this.R).f15114c;
    }

    @Override // s1.o0
    public final void R(long j10, float f5, xb.l lVar) {
        W0(j10, f5, lVar);
        if (this.f13881n) {
            return;
        }
        T0();
        p0().c();
        this.f13811t.getClass();
    }

    @Override // u1.g1
    public final void V0(d1.o oVar, g1.b bVar) {
        g1 g1Var;
        g1 g1Var2 = this.f13811t;
        g1Var2.getClass();
        g1Var2.A0(oVar, bVar);
        if (!((v1.t) j0.a(this.f13810s)).getShowLayoutBounds() || (g1Var = this.f13811t) == null) {
            return;
        }
        if (o2.k.b(this.f11279g, g1Var.f11279g) && o2.i.b(g1Var.D, 0L)) {
            return;
        }
        long j10 = this.f11279g;
        oVar.b(0.5f, 0.5f, ((int) (j10 >> 32)) - 0.5f, ((int) (j10 & 4294967295L)) - 0.5f, T);
    }

    @Override // u1.o0
    public final int b0(s1.l lVar) {
        x xVar = this.S;
        if (xVar == null) {
            return f.c(this, lVar);
        }
        p.z zVar = xVar.f13894x;
        int iD = zVar.d(lVar);
        if (iD >= 0) {
            return zVar.f9652c[iD];
        }
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e1(w wVar) {
        if (wVar.equals(this.R) || (((w0.l) wVar).f15114c.f15116g & 512) == 0) {
            this.R = wVar;
        } else {
            od.f.j();
        }
    }

    @Override // s1.e0
    public final s1.o0 q(long j10) {
        U(j10);
        w wVar = this.R;
        g1 g1Var = this.f13811t;
        g1Var.getClass();
        Z0(wVar.f(this, g1Var, j10));
        S0();
        return this;
    }
}
