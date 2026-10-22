package b0;

/* loaded from: classes.dex */
public final class c0 implements k2 {

    /* renamed from: f, reason: collision with root package name */
    public final ia.b0 f1116f;

    public c0(ia.b0 b0Var) {
        this.f1116f = b0Var;
    }

    @Override // b0.k2
    public final void c() {
    }

    @Override // b0.k2
    public final void f() {
        ia.b0 b0Var = this.f1116f;
        if (b0Var instanceof n2) {
            ((n2) b0Var).a();
        } else {
            ia.d0.e(b0Var, new n0(1));
        }
    }

    @Override // b0.k2
    public final void h() {
        ia.b0 b0Var = this.f1116f;
        if (b0Var instanceof n2) {
            ((n2) b0Var).a();
        } else {
            ia.d0.e(b0Var, new n0(1));
        }
    }
}
