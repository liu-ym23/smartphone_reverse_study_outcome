package p7;

/* loaded from: classes.dex */
public final class o implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4811a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4812b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f4813c;

    public o(r rVar, boolean z, boolean z2) {
        this.f4811a = z;
        this.f4812b = z2;
        this.f4813c = rVar;
    }

    @Override // p7.w
    public final x e(x xVar) {
        a0 a0Var = xVar instanceof a0 ? (a0) xVar : null;
        if (a0Var == null) {
            a0Var = new a0();
            a0Var.f4762a = false;
            a0Var.f4763b = false;
            a0Var.f4764c = false;
        }
        if (!a0Var.f4762a) {
            boolean z = a0Var.f4763b;
            r rVar = this.f4813c;
            if (!z) {
                if (!this.f4811a && !rVar.q()) {
                    a0Var.f4762a = true;
                    return a0Var;
                }
                a0Var.f4763b = true;
            }
            if (this.f4812b && !a0Var.f4764c) {
                if (!rVar.r()) {
                    a0Var.f4762a = true;
                    return a0Var;
                }
                a0Var.f4764c = true;
            }
        }
        return a0Var;
    }
}
