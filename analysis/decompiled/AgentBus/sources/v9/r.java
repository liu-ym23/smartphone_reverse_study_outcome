package v9;

/* loaded from: classes.dex */
public final class r extends p implements y0 {

    /* renamed from: i, reason: collision with root package name */
    public final p f10584i;

    /* renamed from: j, reason: collision with root package name */
    public final v f10585j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p pVar, v vVar) {
        super(pVar.f10580g, pVar.f10581h);
        q7.k.e(pVar, "origin");
        q7.k.e(vVar, "enhancement");
        this.f10584i = pVar;
        this.f10585j = vVar;
    }

    @Override // v9.v
    public final v G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        p pVar = this.f10584i;
        q7.k.e(pVar, "type");
        v vVar = this.f10585j;
        q7.k.e(vVar, "type");
        return new r(pVar, vVar);
    }

    @Override // v9.z0
    public final z0 I0(boolean z4) {
        return c.z(this.f10584i.I0(z4), this.f10585j.H0().I0(z4));
    }

    @Override // v9.z0
    /* renamed from: J0 */
    public final z0 G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        p pVar = this.f10584i;
        q7.k.e(pVar, "type");
        v vVar = this.f10585j;
        q7.k.e(vVar, "type");
        return new r(pVar, vVar);
    }

    @Override // v9.z0
    public final z0 K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return c.z(this.f10584i.K0(i0Var), this.f10585j);
    }

    @Override // v9.p
    public final z L0() {
        return this.f10584i.L0();
    }

    @Override // v9.p
    public final String M0(g9.g gVar, g9.g gVar2) {
        g9.l lVar = gVar2.f3942a;
        return ((Boolean) lVar.f3976m.a(lVar, g9.l.W[11])).booleanValue() ? gVar.Z(this.f10585j) : this.f10584i.M0(gVar, gVar2);
    }

    @Override // v9.y0
    public final v T() {
        return this.f10585j;
    }

    @Override // v9.p
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.f10585j + ")] " + this.f10584i;
    }

    @Override // v9.y0
    public final z0 u0() {
        return this.f10584i;
    }
}
