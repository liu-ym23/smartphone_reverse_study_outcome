package pc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class q extends kc.a implements pb.d {

    /* renamed from: h, reason: collision with root package name */
    public final nb.c f9980h;

    public q(nb.c cVar, nb.g gVar) {
        super(gVar, true);
        this.f9980h = cVar;
    }

    @Override // kc.e1
    public final boolean N() {
        return true;
    }

    @Override // pb.d
    public final pb.d getCallerFrame() {
        nb.c cVar = this.f9980h;
        if (cVar instanceof pb.d) {
            return (pb.d) cVar;
        }
        return null;
    }

    @Override // kc.e1
    public void p(Object obj) {
        a.h(kc.w.w(obj), td.h.y(this.f9980h));
    }

    @Override // kc.e1
    public void q(Object obj) {
        this.f9980h.resumeWith(kc.w.w(obj));
    }
}
