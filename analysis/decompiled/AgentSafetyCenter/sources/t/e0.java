package t;

import u1.a2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends w0.l implements a2, u1.o {

    /* renamed from: u, reason: collision with root package name */
    public static final y0 f12964u = new y0();

    /* renamed from: s, reason: collision with root package name */
    public boolean f12965s;

    /* renamed from: t, reason: collision with root package name */
    public u1.g1 f12966t;

    public final f0 B0() {
        if (!this.f15126r) {
            return null;
        }
        a2 a2VarI = u1.f.i(this, f0.f12976t);
        if (a2VarI instanceof f0) {
            return (f0) a2VarI;
        }
        return null;
    }

    @Override // u1.a2
    public final Object k() {
        return f12964u;
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    @Override // u1.o
    public final void z(u1.g1 g1Var) {
        f0 f0VarB0;
        this.f12966t = g1Var;
        if (this.f12965s) {
            if (!g1Var.H0().f15126r) {
                f0 f0VarB02 = B0();
                if (f0VarB02 != null) {
                    f0VarB02.B0(null);
                    return;
                }
                return;
            }
            u1.g1 g1Var2 = this.f12966t;
            if (g1Var2 == null || !g1Var2.H0().f15126r || (f0VarB0 = B0()) == null) {
                return;
            }
            f0VarB0.B0(this.f12966t);
        }
    }
}
