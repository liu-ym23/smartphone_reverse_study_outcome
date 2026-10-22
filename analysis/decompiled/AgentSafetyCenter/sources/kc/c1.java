package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 extends a1 {
    public e1 i;

    /* renamed from: j, reason: collision with root package name */
    public d1 f7420j;

    /* renamed from: k, reason: collision with root package name */
    public k f7421k;

    /* renamed from: l, reason: collision with root package name */
    public Object f7422l;

    @Override // kc.a1
    public final boolean k() {
        return false;
    }

    @Override // kc.a1
    public final void l(Throwable th) {
        e1 e1Var = this.i;
        d1 d1Var = this.f7420j;
        k kVar = this.f7421k;
        Object obj = this.f7422l;
        e1Var.getClass();
        k kVarR = e1.R(kVar);
        if (kVarR == null || !e1Var.Z(d1Var, kVarR, obj)) {
            d1Var.f7427c.c(2);
            k kVarR2 = e1.R(kVar);
            if (kVarR2 == null || !e1Var.Z(d1Var, kVarR2, obj)) {
                e1Var.p(e1Var.B(d1Var, obj));
            }
        }
    }
}
