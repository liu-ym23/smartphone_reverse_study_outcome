package pb;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kc.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c extends a {
    private final nb.g _context;
    private transient nb.c intercepted;

    public c(nb.c cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }

    @Override // nb.c
    public nb.g getContext() {
        nb.g gVar = this._context;
        gVar.getClass();
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final nb.c intercepted() {
        c cVar;
        nb.c cVar2 = this.intercepted;
        if (cVar2 != null) {
            return cVar2;
        }
        p pVar = (p) getContext().get(nb.d.f8810c);
        if (pVar != null) {
            pc.f fVar = new pc.f(-1);
            fVar.f9956h = pVar;
            fVar.i = this;
            fVar.f9957j = pc.a.f9944b;
            fVar.f9958k = pc.a.k(getContext());
            VarHandle.storeStoreFence();
            cVar = fVar;
        } else {
            cVar = this;
        }
        this.intercepted = cVar;
        return cVar;
    }

    @Override // pb.a
    public void releaseIntercepted() {
        nb.c cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            nb.e eVar = getContext().get(nb.d.f8810c);
            eVar.getClass();
            pc.f fVar = (pc.f) cVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pc.f.f9955l;
            while (atomicReferenceFieldUpdater.get(fVar) == pc.a.f9945c) {
            }
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            kc.g gVar = obj instanceof kc.g ? (kc.g) obj : null;
            if (gVar != null) {
                gVar.o();
            }
        }
        this.intercepted = b.f9939c;
    }

    public c(nb.c cVar, nb.g gVar) {
        super(cVar);
        this._context = gVar;
    }
}
