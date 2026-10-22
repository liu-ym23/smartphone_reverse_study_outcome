package h5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g extends a {
    public g(f5.c cVar) {
        super(cVar);
        if (cVar != null && cVar.getContext() != f5.i.f2626a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // f5.c
    public f5.h getContext() {
        return f5.i.f2626a;
    }
}
