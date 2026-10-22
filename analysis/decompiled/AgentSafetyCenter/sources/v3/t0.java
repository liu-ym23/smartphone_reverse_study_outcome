package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 implements nb.e {

    /* renamed from: c, reason: collision with root package name */
    public t0 f14725c;

    /* renamed from: f, reason: collision with root package name */
    public z f14726f;

    public final void a(z zVar) {
        if (this.f14726f == zVar) {
            od.f.e("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
            return;
        }
        t0 t0Var = this.f14725c;
        if (t0Var != null) {
            t0Var.a(zVar);
        }
    }

    @Override // nb.g
    public final Object fold(Object obj, xb.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // nb.g
    public final nb.e get(nb.f fVar) {
        return ac.a.t(this, fVar);
    }

    @Override // nb.e
    public final nb.f getKey() {
        return s0.f14719c;
    }

    @Override // nb.g
    public final nb.g minusKey(nb.f fVar) {
        return ac.a.H(this, fVar);
    }

    @Override // nb.g
    public final nb.g plus(nb.g gVar) {
        return ac.a.N(this, gVar);
    }
}
