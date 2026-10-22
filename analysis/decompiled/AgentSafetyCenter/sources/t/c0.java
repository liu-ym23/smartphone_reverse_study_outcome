package t;

import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends u1.m implements b1.d, v1, u1.o, b1.o {

    /* renamed from: u, reason: collision with root package name */
    public b1.p f12946u;

    /* renamed from: v, reason: collision with root package name */
    public b0 f12947v;

    /* renamed from: w, reason: collision with root package name */
    public d0 f12948w;

    /* renamed from: x, reason: collision with root package name */
    public e0 f12949x;

    public final void E0(v.k kVar) {
        v.d dVar;
        b0 b0Var = this.f12947v;
        if (yb.k.a(b0Var.f12942s, kVar)) {
            return;
        }
        v.k kVar2 = b0Var.f12942s;
        if (kVar2 != null && (dVar = b0Var.f12943t) != null) {
            kVar2.b(new v.e(dVar));
        }
        b0Var.f12943t = null;
        b0Var.f12942s = kVar;
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        b1.p pVar = this.f12946u;
        boolean z10 = false;
        if (pVar != null && pVar.a()) {
            z10 = true;
        }
        fc.c[] cVarArr = a2.w.f144a;
        a2.x xVar = a2.u.f126k;
        fc.c cVar = a2.w.f144a[4];
        kVar.d(xVar, Boolean.valueOf(z10));
        kVar.d(a2.j.f69u, new a2.a(null, new ad.l(this, 23)));
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b1.d
    public final void w(b1.p pVar) {
        f0 f0VarB0;
        if (yb.k.a(this.f12946u, pVar)) {
            return;
        }
        boolean zA = pVar.a();
        y.z zVar = null;
        Object[] objArr = 0;
        if (zA) {
            kc.w.u(p0(), null, null, new androidx.room.e(this, objArr == true ? 1 : 0, 12), 3);
        }
        if (this.f15126r) {
            u1.f.n(this);
        }
        b0 b0Var = this.f12947v;
        v.k kVar = b0Var.f12942s;
        if (kVar != null) {
            v.d dVar = b0Var.f12943t;
            if (zA) {
                if (dVar != null) {
                    b0Var.B0(kVar, new v.e(dVar));
                    b0Var.f12943t = null;
                }
                v.d dVar2 = new v.d();
                b0Var.B0(kVar, dVar2);
                b0Var.f12943t = dVar2;
            } else if (dVar != null) {
                b0Var.B0(kVar, new v.e(dVar));
                b0Var.f12943t = null;
            }
        }
        e0 e0Var = this.f12949x;
        if (zA != e0Var.f12965s) {
            if (zA) {
                u1.g1 g1Var = e0Var.f12966t;
                if (g1Var != null && g1Var.H0().f15126r && (f0VarB0 = e0Var.B0()) != null) {
                    f0VarB0.B0(e0Var.f12966t);
                }
            } else {
                f0 f0VarB02 = e0Var.B0();
                if (f0VarB02 != null) {
                    f0VarB02.B0(null);
                }
            }
            e0Var.f12965s = zA;
        }
        d0 d0Var = this.f12948w;
        if (zA) {
            d0Var.getClass();
            yb.u uVar = new yb.u();
            u1.f.r(d0Var, new a1.b(10, uVar, d0Var));
            y.z zVar2 = (y.z) uVar.f16098c;
            if (zVar2 != null) {
                zVar2.a();
                zVar = zVar2;
            }
            d0Var.f12956s = zVar;
        } else {
            y.z zVar3 = d0Var.f12956s;
            if (zVar3 != null) {
                zVar3.b();
            }
            d0Var.f12956s = null;
        }
        d0Var.f12957t = zA;
        this.f12946u = pVar;
    }

    @Override // u1.o
    public final void z(u1.g1 g1Var) {
        this.f12949x.z(g1Var);
    }
}
