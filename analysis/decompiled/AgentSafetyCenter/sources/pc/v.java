package pc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v implements nb.e {

    /* renamed from: c, reason: collision with root package name */
    public o4.q f9987c;

    /* renamed from: f, reason: collision with root package name */
    public ThreadLocal f9988f;

    /* renamed from: g, reason: collision with root package name */
    public w f9989g;

    @Override // nb.g
    public final Object fold(Object obj, xb.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // nb.g
    public final nb.e get(nb.f fVar) {
        if (yb.k.a(this.f9989g, fVar)) {
            return this;
        }
        return null;
    }

    @Override // nb.e
    public final nb.f getKey() {
        return this.f9989g;
    }

    @Override // nb.g
    public final nb.g minusKey(nb.f fVar) {
        return yb.k.a(this.f9989g, fVar) ? nb.h.f8811c : this;
    }

    @Override // nb.g
    public final nb.g plus(nb.g gVar) {
        return ac.a.N(this, gVar);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f9987c + ", threadLocal = " + this.f9988f + ')';
    }
}
