package e6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n implements f5.c, h5.d {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f2394a;

    /* renamed from: b, reason: collision with root package name */
    public final f5.h f2395b;

    public n(f5.c cVar, f5.h hVar) {
        this.f2394a = cVar;
        this.f2395b = hVar;
    }

    @Override // h5.d
    public final h5.d getCallerFrame() {
        f5.c cVar = this.f2394a;
        if (cVar instanceof h5.d) {
            return (h5.d) cVar;
        }
        return null;
    }

    @Override // f5.c
    public final f5.h getContext() {
        return this.f2395b;
    }

    @Override // f5.c
    public final void resumeWith(Object obj) {
        this.f2394a.resumeWith(obj);
    }
}
