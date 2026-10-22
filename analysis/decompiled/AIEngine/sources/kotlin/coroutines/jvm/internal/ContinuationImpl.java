package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import qb.b;
import rb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final d _context;
    private transient b<Object> intercepted;

    public ContinuationImpl(b<Object> bVar, d dVar) {
        super(bVar);
        this._context = dVar;
    }

    @Override // qb.b
    public d getContext() {
        d dVar = this._context;
        g.c(dVar);
        return dVar;
    }

    public final b<Object> intercepted() {
        b<Object> bVarInterceptContinuation = this.intercepted;
        if (bVarInterceptContinuation == null) {
            c cVar = (c) getContext().get(c.a.f10058a);
            if (cVar == null || (bVarInterceptContinuation = cVar.interceptContinuation(this)) == null) {
                bVarInterceptContinuation = this;
            }
            this.intercepted = bVarInterceptContinuation;
        }
        return bVarInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        b<?> bVar = this.intercepted;
        if (bVar != null && bVar != this) {
            d.a aVar = getContext().get(c.a.f10058a);
            g.c(aVar);
            ((c) aVar).releaseInterceptedContinuation(bVar);
        }
        this.intercepted = a.f11763a;
    }

    public ContinuationImpl(b<Object> bVar) {
        this(bVar, bVar != null ? bVar.getContext() : null);
    }
}
