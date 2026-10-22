package v9;

/* loaded from: classes.dex */
public abstract class n extends m {

    /* renamed from: g, reason: collision with root package name */
    public final z f10574g;

    public n(z zVar) {
        this.f10574g = zVar;
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        return z4 == F0() ? this : this.f10574g.I0(z4).K0(D0());
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return i0Var != D0() ? new b0(this, i0Var) : this;
    }

    @Override // v9.m
    public final z N0() {
        return this.f10574g;
    }
}
