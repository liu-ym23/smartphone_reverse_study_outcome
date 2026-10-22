package i7;

import g7.l;
import g7.m;

/* loaded from: classes.dex */
public abstract class g extends a {
    public g(g7.d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != m.f3866f) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // g7.d
    public final l getContext() {
        return m.f3866f;
    }
}
