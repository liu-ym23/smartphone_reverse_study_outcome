package v9;

/* loaded from: classes.dex */
public final class l extends m implements j, y9.e {

    /* renamed from: g, reason: collision with root package name */
    public final z f10564g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10565h;

    public l(z zVar, boolean z4) {
        this.f10564g = zVar;
        this.f10565h = z4;
    }

    @Override // v9.m, v9.v
    public final boolean F0() {
        return false;
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        return z4 ? this.f10564g.I0(z4) : this;
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return new l(this.f10564g.K0(i0Var), this.f10565h);
    }

    @Override // v9.m
    public final z N0() {
        return this.f10564g;
    }

    @Override // v9.m
    public final m P0(z zVar) {
        return new l(zVar, this.f10565h);
    }

    @Override // v9.j
    public final z0 R(v vVar) {
        q7.k.e(vVar, "replacement");
        return c.l(vVar.H0(), this.f10565h);
    }

    @Override // v9.j
    public final boolean j0() {
        z zVar = this.f10564g;
        zVar.E0();
        return zVar.E0().c() instanceof f8.q0;
    }

    @Override // v9.z
    public final String toString() {
        return this.f10564g + " & Any";
    }
}
