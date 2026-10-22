package b0;

/* loaded from: classes.dex */
public final class j0 implements k2 {

    /* renamed from: f, reason: collision with root package name */
    public final p7.k f1201f;

    /* renamed from: g, reason: collision with root package name */
    public k0 f1202g;

    public j0(p7.k kVar) {
        this.f1201f = kVar;
    }

    @Override // b0.k2
    public final void c() {
        this.f1202g = (k0) this.f1201f.invoke(b.f1105b);
    }

    @Override // b0.k2
    public final void f() {
    }

    @Override // b0.k2
    public final void h() {
        k0 k0Var = this.f1202g;
        if (k0Var != null) {
            k0Var.a();
        }
        this.f1202g = null;
    }
}
