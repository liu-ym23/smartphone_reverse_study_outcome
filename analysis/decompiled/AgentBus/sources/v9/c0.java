package v9;

/* loaded from: classes.dex */
public final class c0 extends m implements y0 {

    /* renamed from: g, reason: collision with root package name */
    public final z f10539g;

    /* renamed from: h, reason: collision with root package name */
    public final v f10540h;

    public c0(z zVar, v vVar) {
        q7.k.e(zVar, "delegate");
        q7.k.e(vVar, "enhancement");
        this.f10539g = zVar;
        this.f10540h = vVar;
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        z0 z0VarZ = c.z(this.f10539g.I0(z4), this.f10540h.H0().I0(z4));
        q7.k.c(z0VarZ, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (z) z0VarZ;
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        z0 z0VarZ = c.z(this.f10539g.K0(i0Var), this.f10540h);
        q7.k.c(z0VarZ, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (z) z0VarZ;
    }

    @Override // v9.m
    public final z N0() {
        return this.f10539g;
    }

    @Override // v9.m
    public final m P0(z zVar) {
        return new c0(zVar, this.f10540h);
    }

    @Override // v9.m
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public final c0 G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVar = this.f10539g;
        q7.k.e(zVar, "type");
        v vVar = this.f10540h;
        q7.k.e(vVar, "type");
        return new c0(zVar, vVar);
    }

    @Override // v9.y0
    public final v T() {
        return this.f10540h;
    }

    @Override // v9.z
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.f10540h + ")] " + this.f10539g;
    }

    @Override // v9.y0
    public final z0 u0() {
        return this.f10539g;
    }
}
