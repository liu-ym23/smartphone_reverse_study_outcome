package s4;

/* loaded from: classes.dex */
public abstract class t0 extends x4.q implements InterfaceC1081k0, X, InterfaceC1077i0 {

    /* renamed from: d, reason: collision with root package name */
    public u0 f20370d;

    @Override // s4.InterfaceC1077i0
    public boolean c() {
        return true;
    }

    @Override // s4.InterfaceC1077i0
    public y0 d() {
        return null;
    }

    @Override // s4.X
    public void dispose() {
        v().x0(this);
    }

    @Override // x4.q
    public String toString() {
        return M.a(this) + '@' + M.b(this) + "[job@" + M.b(v()) + ']';
    }

    public final u0 v() {
        u0 u0Var = this.f20370d;
        if (u0Var != null) {
            return u0Var;
        }
        j4.k.t("job");
        return null;
    }

    public final void w(u0 u0Var) {
        this.f20370d = u0Var;
    }
}
