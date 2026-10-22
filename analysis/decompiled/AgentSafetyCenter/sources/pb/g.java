package pb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g extends a {
    public g(nb.c cVar) {
        super(cVar);
        if (cVar == null || cVar.getContext() == nb.h.f8811c) {
            return;
        }
        g5.f.s("Coroutines with restricted suspension must have EmptyCoroutineContext");
        throw null;
    }

    @Override // nb.c
    public final nb.g getContext() {
        return nb.h.f8811c;
    }
}
