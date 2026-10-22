package androidx.lifecycle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 implements v, AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public String f1425c;

    /* renamed from: f, reason: collision with root package name */
    public p0 f1426f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1427g;

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) {
        if (oVar == o.ON_DESTROY) {
            this.f1427g = false;
            xVar.getLifecycle().c(this);
        }
    }

    public final void n(t4.d dVar, q qVar) {
        dVar.getClass();
        qVar.getClass();
        if (this.f1427g) {
            od.f.e("Already attached to lifecycleOwner");
            return;
        }
        this.f1427g = true;
        qVar.a(this);
        dVar.c(this.f1425c, (androidx.activity.f) this.f1426f.f1423a.f634d);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }
}
