package nb;

import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements e {
    private final f key;

    public a(f fVar) {
        fVar.getClass();
        this.key = fVar;
    }

    @Override // nb.g
    public <R> R fold(R r10, p pVar) {
        pVar.getClass();
        return (R) pVar.invoke(r10, this);
    }

    @Override // nb.g
    public <E extends e> E get(f fVar) {
        return (E) ac.a.t(this, fVar);
    }

    @Override // nb.e
    public f getKey() {
        return this.key;
    }

    @Override // nb.g
    public g minusKey(f fVar) {
        return ac.a.H(this, fVar);
    }

    @Override // nb.g
    public g plus(g gVar) {
        return ac.a.N(this, gVar);
    }
}
