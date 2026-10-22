package androidx.lifecycle;

/* loaded from: classes.dex */
public final class h0 implements t, AutoCloseable {

    /* renamed from: f, reason: collision with root package name */
    public final String f998f;

    /* renamed from: g, reason: collision with root package name */
    public final g0 f999g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1000h;

    public h0(String str, g0 g0Var) {
        this.f998f = str;
        this.f999g = g0Var;
    }

    @Override // androidx.lifecycle.t
    public final void b(v vVar, p pVar) {
        if (pVar == p.ON_DESTROY) {
            this.f1000h = false;
            vVar.a().f(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }

    public final void g(x xVar, q6.b bVar) {
        q7.k.e(bVar, "registry");
        q7.k.e(xVar, "lifecycle");
        if (this.f1000h) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1000h = true;
        xVar.a(this);
        bVar.M0(this.f998f, (a3.a) this.f999g.f994a.f166j);
    }
}
