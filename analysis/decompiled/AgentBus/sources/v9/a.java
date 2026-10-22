package v9;

/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: g, reason: collision with root package name */
    public final z f10531g;

    /* renamed from: h, reason: collision with root package name */
    public final z f10532h;

    public a(z zVar, z zVar2) {
        q7.k.e(zVar, "delegate");
        q7.k.e(zVar2, "abbreviation");
        this.f10531g = zVar;
        this.f10532h = zVar2;
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return new a(this.f10531g.K0(i0Var), this.f10532h);
    }

    @Override // v9.m
    public final z N0() {
        return this.f10531g;
    }

    @Override // v9.m
    public final m P0(z zVar) {
        return new a(zVar, this.f10532h);
    }

    @Override // v9.z
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public final a I0(boolean z4) {
        return new a(this.f10531g.I0(z4), this.f10532h.I0(z4));
    }

    @Override // v9.m
    /* renamed from: R0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final a G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVar = this.f10531g;
        q7.k.e(zVar, "type");
        z zVar2 = this.f10532h;
        q7.k.e(zVar2, "type");
        return new a(zVar, zVar2);
    }
}
