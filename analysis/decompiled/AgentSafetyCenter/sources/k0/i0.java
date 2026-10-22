package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends u0.w implements r2 {

    /* renamed from: f, reason: collision with root package name */
    public final xb.a f6934f;

    /* renamed from: g, reason: collision with root package name */
    public final y0 f6935g;

    /* renamed from: h, reason: collision with root package name */
    public h0 f6936h = new h0(u0.m.k().g());

    public i0(xb.a aVar, y0 y0Var) {
        this.f6934f = aVar;
        this.f6935g = y0Var;
    }

    @Override // u0.v
    public final u0.x a() {
        return this.f6936h;
    }

    @Override // u0.v
    public final void c(u0.x xVar) {
        xVar.getClass();
        this.f6936h = (h0) xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k0.h0 g(k0.h0 r21, u0.f r22, boolean r23, xb.a r24) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.i0.g(k0.h0, u0.f, boolean, xb.a):k0.h0");
    }

    @Override // k0.r2
    public final Object getValue() {
        xb.l lVarE = u0.m.k().e();
        if (lVarE != null) {
            lVarE.invoke(this);
        }
        u0.f fVarK = u0.m.k();
        return g((h0) u0.m.j(this.f6936h, fVarK), fVarK, true, this.f6934f).f6928f;
    }

    public final h0 h() {
        u0.f fVarK = u0.m.k();
        return g((h0) u0.m.j(this.f6936h, fVarK), fVarK, false, this.f6934f);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DerivedState(value=");
        h0 h0Var = (h0) u0.m.i(this.f6936h);
        sb2.append(h0Var.c(this, u0.m.k()) ? String.valueOf(h0Var.f6928f) : "<Not calculated>");
        sb2.append(")@");
        sb2.append(hashCode());
        return sb2.toString();
    }
}
