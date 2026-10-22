package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 implements a2 {

    /* renamed from: c, reason: collision with root package name */
    public final xb.l f6962c;

    /* renamed from: f, reason: collision with root package name */
    public k0 f6963f;

    public j0(xb.l lVar) {
        this.f6962c = lVar;
    }

    @Override // k0.a2
    public final void b() {
        k0 k0Var = this.f6963f;
        if (k0Var != null) {
            k0Var.dispose();
        }
        this.f6963f = null;
    }

    @Override // k0.a2
    public final void c() {
        this.f6963f = (k0) this.f6962c.invoke(z.f7152b);
    }

    @Override // k0.a2
    public final void a() {
    }
}
