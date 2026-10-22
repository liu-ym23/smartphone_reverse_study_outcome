package q0;

import i1.u;
import i1.x1;
import m.q;
import n0.l;
import o4.d0;
import q7.k;
import q7.v;

/* loaded from: classes.dex */
public final class d extends l implements x1, u {

    /* renamed from: t, reason: collision with root package name */
    public d f8622t;

    /* renamed from: u, reason: collision with root package name */
    public d f8623u;

    /* renamed from: v, reason: collision with root package name */
    public long f8624v;

    @Override // n0.l
    public final void e0() {
        this.f8623u = null;
        this.f8622t = null;
    }

    @Override // i1.x1
    public final Object k() {
        return c.f8621a;
    }

    public final boolean l0(d0 d0Var) {
        d dVar = this.f8622t;
        if (dVar != null) {
            return dVar.l0(d0Var);
        }
        d dVar2 = this.f8623u;
        if (dVar2 != null) {
            return dVar2.l0(d0Var);
        }
        return false;
    }

    @Override // i1.u
    public final void m(long j2) {
        this.f8624v = j2;
    }

    public final void m0(d0 d0Var) {
        d dVar = this.f8623u;
        if (dVar != null) {
            dVar.m0(d0Var);
            return;
        }
        d dVar2 = this.f8622t;
        if (dVar2 != null) {
            dVar2.m0(d0Var);
        }
    }

    public final void n0(d0 d0Var) {
        d dVar = this.f8623u;
        if (dVar != null) {
            dVar.n0(d0Var);
        }
        d dVar2 = this.f8622t;
        if (dVar2 != null) {
            dVar2.n0(d0Var);
        }
        this.f8622t = null;
    }

    public final void o0(d0 d0Var) {
        x1 x1Var;
        d dVar;
        d dVar2 = this.f8622t;
        if (dVar2 == null || !n7.a.a(dVar2, n7.b.o(d0Var))) {
            if (this.f6797f.f6810s) {
                v vVar = new v();
                i1.l.y(this, new q(vVar, this, d0Var, 3));
                x1Var = (x1) vVar.f8820f;
            } else {
                x1Var = null;
            }
            dVar = (d) x1Var;
        } else {
            dVar = dVar2;
        }
        if (dVar != null && dVar2 == null) {
            dVar.m0(d0Var);
            dVar.o0(d0Var);
            d dVar3 = this.f8623u;
            if (dVar3 != null) {
                dVar3.n0(d0Var);
            }
        } else if (dVar == null && dVar2 != null) {
            d dVar4 = this.f8623u;
            if (dVar4 != null) {
                dVar4.m0(d0Var);
                dVar4.o0(d0Var);
            }
            dVar2.n0(d0Var);
        } else if (!k.a(dVar, dVar2)) {
            if (dVar != null) {
                dVar.m0(d0Var);
                dVar.o0(d0Var);
            }
            if (dVar2 != null) {
                dVar2.n0(d0Var);
            }
        } else if (dVar != null) {
            dVar.o0(d0Var);
        } else {
            d dVar5 = this.f8623u;
            if (dVar5 != null) {
                dVar5.o0(d0Var);
            }
        }
        this.f8622t = dVar;
    }

    public final void p0(d0 d0Var) {
        d dVar = this.f8623u;
        if (dVar != null) {
            dVar.p0(d0Var);
            return;
        }
        d dVar2 = this.f8622t;
        if (dVar2 != null) {
            dVar2.p0(d0Var);
        }
    }
}
