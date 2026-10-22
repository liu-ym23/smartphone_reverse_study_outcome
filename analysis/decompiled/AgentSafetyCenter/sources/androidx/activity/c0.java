package androidx.activity;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 implements d {

    /* renamed from: c, reason: collision with root package name */
    public u f659c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ e0 f660f;

    /* JADX WARN: Type inference failed for: r4v1, types: [xb.a, yb.i] */
    @Override // androidx.activity.d
    public final void cancel() {
        e0 e0Var = this.f660f;
        kb.j jVar = e0Var.f665b;
        u uVar = this.f659c;
        jVar.remove(uVar);
        if (yb.k.a(e0Var.f666c, uVar)) {
            uVar.getClass();
            e0Var.f666c = null;
        }
        uVar.getClass();
        uVar.f700b.remove(this);
        ?? r42 = uVar.f701c;
        if (r42 != 0) {
            r42.invoke();
        }
        uVar.f701c = null;
    }
}
