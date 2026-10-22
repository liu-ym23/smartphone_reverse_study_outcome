package o;

import i1.d1;
import i1.x1;

/* loaded from: classes.dex */
public final class d0 extends n0.l implements x1, i1.n {

    /* renamed from: v, reason: collision with root package name */
    public static final q0 f7033v = new q0();

    /* renamed from: t, reason: collision with root package name */
    public boolean f7034t;

    /* renamed from: u, reason: collision with root package name */
    public d1 f7035u;

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // i1.x1
    public final Object k() {
        return f7033v;
    }

    public final e0 l0() {
        if (!this.f6810s) {
            return null;
        }
        x1 x1VarI = i1.l.i(this, e0.f7041u);
        if (x1VarI instanceof e0) {
            return (e0) x1VarI;
        }
        return null;
    }

    @Override // i1.n
    public final void q(d1 d1Var) {
        e0 e0VarL0;
        this.f7035u = d1Var;
        if (this.f7034t) {
            if (!d1Var.z0().f6810s) {
                e0 e0VarL02 = l0();
                if (e0VarL02 != null) {
                    e0VarL02.l0(null);
                    return;
                }
                return;
            }
            d1 d1Var2 = this.f7035u;
            if (d1Var2 == null || !d1Var2.z0().f6810s || (e0VarL0 = l0()) == null) {
                return;
            }
            e0VarL0.l0(this.f7035u);
        }
    }
}
