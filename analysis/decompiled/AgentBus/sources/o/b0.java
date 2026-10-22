package o;

import i1.d1;
import i1.s1;
import ia.j1;

/* loaded from: classes.dex */
public final class b0 extends i1.k implements s0.d, s1, i1.n, s0.n {

    /* renamed from: v, reason: collision with root package name */
    public s0.p f7023v;

    /* renamed from: w, reason: collision with root package name */
    public final a0 f7024w;

    /* renamed from: x, reason: collision with root package name */
    public final c0 f7025x;

    /* renamed from: y, reason: collision with root package name */
    public final d0 f7026y;

    public b0(q.i iVar) {
        a0 a0Var = new a0();
        a0Var.f7012t = iVar;
        l0(a0Var);
        this.f7024w = a0Var;
        c0 c0Var = new c0();
        l0(c0Var);
        this.f7025x = c0Var;
        d0 d0Var = new d0();
        l0(d0Var);
        this.f7026y = d0Var;
        l0(new s0.q(new j1(1, s0.s.f9203a, s0.s.class, "onDispatchEventsCompleted", "onDispatchEventsCompleted(Landroidx/compose/ui/focus/FocusTargetNode;)V", 0, 3), 3));
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // s0.d
    public final void f(s0.p pVar) {
        e0 e0VarL0;
        if (q7.k.a(this.f7023v, pVar)) {
            return;
        }
        boolean zA = pVar.a();
        g7.d dVar = null;
        if (zA) {
            ia.d0.s(Z(), null, null, new a6.r(this, dVar, 6), 3);
        }
        if (this.f6810s) {
            i1.l.n(this);
        }
        a0 a0Var = this.f7024w;
        q.i iVar = a0Var.f7012t;
        if (iVar != null) {
            if (zA) {
                q.d dVar2 = a0Var.f7013u;
                if (dVar2 != null) {
                    a0Var.l0(iVar, new q.e(dVar2));
                    a0Var.f7013u = null;
                }
                q.d dVar3 = new q.d();
                a0Var.l0(iVar, dVar3);
                a0Var.f7013u = dVar3;
            } else {
                q.d dVar4 = a0Var.f7013u;
                if (dVar4 != null) {
                    a0Var.l0(iVar, new q.e(dVar4));
                    a0Var.f7013u = null;
                }
            }
        }
        d0 d0Var = this.f7026y;
        if (zA != d0Var.f7034t) {
            if (zA) {
                d1 d1Var = d0Var.f7035u;
                if (d1Var != null && d1Var.z0().f6810s && (e0VarL0 = d0Var.l0()) != null) {
                    e0VarL0.l0(d0Var.f7035u);
                }
            } else {
                e0 e0VarL02 = d0Var.l0();
                if (e0VarL02 != null) {
                    e0VarL02.l0(null);
                }
            }
            d0Var.f7034t = zA;
        }
        c0 c0Var = this.f7025x;
        if (zA) {
            c0Var.getClass();
            q7.v vVar = new q7.v();
            i1.l.r(c0Var, new a8.e(11, vVar, c0Var));
            if (vVar.f8820f != null) {
                throw new ClassCastException();
            }
        }
        c0Var.getClass();
        this.f7023v = pVar;
    }

    public final void o0(q.i iVar) {
        q.d dVar;
        a0 a0Var = this.f7024w;
        if (q7.k.a(a0Var.f7012t, iVar)) {
            return;
        }
        q.i iVar2 = a0Var.f7012t;
        if (iVar2 != null && (dVar = a0Var.f7013u) != null) {
            iVar2.b(new q.e(dVar));
        }
        a0Var.f7013u = null;
        a0Var.f7012t = iVar;
    }

    @Override // i1.n
    public final void q(d1 d1Var) {
        this.f7026y.q(d1Var);
    }

    @Override // i1.s1
    public final void u(p1.i iVar) {
        s0.p pVar = this.f7023v;
        boolean z4 = false;
        if (pVar != null && pVar.a()) {
            z4 = true;
        }
        w7.t[] tVarArr = p1.u.f8372a;
        p1.v vVar = p1.s.f8354k;
        w7.t tVar = p1.u.f8372a[4];
        vVar.a(iVar, Boolean.valueOf(z4));
        iVar.i(p1.h.f8297t, new p1.a(null, new a8.c(17, this)));
    }
}
