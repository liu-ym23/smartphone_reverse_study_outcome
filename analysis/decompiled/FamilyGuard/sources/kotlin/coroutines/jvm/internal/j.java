package kotlin.coroutines.jvm.internal;

/* loaded from: classes.dex */
public abstract class j extends a {
    public j(Z3.e<Object> eVar) {
        super(eVar);
        if (eVar != null && eVar.getContext() != Z3.j.f6656a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // Z3.e
    public Z3.i getContext() {
        return Z3.j.f6656a;
    }
}
