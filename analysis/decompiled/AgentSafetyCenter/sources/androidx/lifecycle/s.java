package androidx.lifecycle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements v, kc.t {

    /* renamed from: c, reason: collision with root package name */
    public q f1431c;

    /* renamed from: f, reason: collision with root package name */
    public nb.g f1432f;

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) {
        q qVar = this.f1431c;
        if (qVar.b().compareTo(p.f1418c) <= 0) {
            qVar.c(this);
            kc.w.e(this.f1432f, null);
        }
    }

    @Override // kc.t
    public final nb.g n() {
        return this.f1432f;
    }
}
