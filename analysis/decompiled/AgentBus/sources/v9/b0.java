package v9;

/* loaded from: classes.dex */
public final class b0 extends n {

    /* renamed from: h, reason: collision with root package name */
    public final i0 f10538h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(z zVar, i0 i0Var) {
        super(zVar);
        q7.k.e(i0Var, "attributes");
        this.f10538h = i0Var;
    }

    @Override // v9.m, v9.v
    public final i0 D0() {
        return this.f10538h;
    }

    @Override // v9.m
    public final m P0(z zVar) {
        return new b0(zVar, this.f10538h);
    }
}
