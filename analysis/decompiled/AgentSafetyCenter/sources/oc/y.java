package oc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements nb.c, pb.d {

    /* renamed from: c, reason: collision with root package name */
    public nb.c f9410c;

    /* renamed from: f, reason: collision with root package name */
    public nb.g f9411f;

    @Override // pb.d
    public final pb.d getCallerFrame() {
        nb.c cVar = this.f9410c;
        if (cVar instanceof pb.d) {
            return (pb.d) cVar;
        }
        return null;
    }

    @Override // nb.c
    public final nb.g getContext() {
        return this.f9411f;
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        this.f9410c.resumeWith(obj);
    }
}
