package i7;

import g7.j;
import g7.l;
import ia.m;
import ia.x;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q7.k;

/* loaded from: classes.dex */
public abstract class c extends a {
    private final l _context;
    private transient g7.d intercepted;

    public c(g7.d dVar, l lVar) {
        super(dVar);
        this._context = lVar;
    }

    @Override // g7.d
    public l getContext() {
        l lVar = this._context;
        k.b(lVar);
        return lVar;
    }

    public final g7.d intercepted() {
        g7.d dVar = this.intercepted;
        if (dVar != null) {
            return dVar;
        }
        g7.g gVar = (g7.g) getContext().o(g7.f.f3865f);
        g7.d gVar2 = gVar != null ? new na.g((x) gVar, this) : this;
        this.intercepted = gVar2;
        return gVar2;
    }

    @Override // i7.a
    public void releaseIntercepted() {
        g7.d dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            j jVarO = getContext().o(g7.f.f3865f);
            k.b(jVarO);
            na.g gVar = (na.g) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.g.f6899m;
            while (atomicReferenceFieldUpdater.get(gVar) == na.b.f6889c) {
            }
            Object obj = atomicReferenceFieldUpdater.get(gVar);
            m mVar = obj instanceof m ? (m) obj : null;
            if (mVar != null) {
                mVar.o();
            }
        }
        this.intercepted = b.f4732f;
    }

    public c(g7.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
