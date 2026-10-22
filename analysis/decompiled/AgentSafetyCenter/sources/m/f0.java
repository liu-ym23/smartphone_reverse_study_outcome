package m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends m1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k0 f7902n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ n0 f7903o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(n0 n0Var, n0 n0Var2, k0 k0Var) {
        super(n0Var2);
        this.f7903o = n0Var;
        this.f7902n = k0Var;
    }

    @Override // m.m1
    public final l.b0 b() {
        return this.f7902n;
    }

    @Override // m.m1
    public final boolean c() {
        n0 n0Var = this.f7903o;
        if (n0Var.getInternalPopup().b()) {
            return true;
        }
        n0Var.f8016j.m(n0Var.getTextDirection(), n0Var.getTextAlignment());
        return true;
    }
}
