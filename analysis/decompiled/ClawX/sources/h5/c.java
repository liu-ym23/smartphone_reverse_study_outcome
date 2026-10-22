package h5;

import a6.b0;
import a6.m;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class c extends a {
    private final f5.h _context;
    private transient f5.c intercepted;

    public c(f5.c cVar, f5.h hVar) {
        super(cVar);
        this._context = hVar;
    }

    @Override // f5.c
    public f5.h getContext() {
        f5.h hVar = this._context;
        p.b(hVar);
        return hVar;
    }

    public final f5.c intercepted() {
        f5.c cVar = this.intercepted;
        if (cVar != null) {
            return cVar;
        }
        f5.e eVar = (f5.e) getContext().o(f5.d.f2625a);
        f5.c eVar2 = eVar != null ? new f6.e((b0) eVar, this) : this;
        this.intercepted = eVar2;
        return eVar2;
    }

    @Override // h5.a
    public void releaseIntercepted() {
        f5.c cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            f5.f fVarO = getContext().o(f5.d.f2625a);
            p.b(fVarO);
            f6.e eVar = (f6.e) cVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.e.f2637h;
            while (atomicReferenceFieldUpdater.get(eVar) == f6.a.f2629c) {
            }
            Object obj = atomicReferenceFieldUpdater.get(eVar);
            m mVar = obj instanceof m ? (m) obj : null;
            if (mVar != null) {
                mVar.o();
            }
        }
        this.intercepted = b.f3033a;
    }

    public c(f5.c cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
