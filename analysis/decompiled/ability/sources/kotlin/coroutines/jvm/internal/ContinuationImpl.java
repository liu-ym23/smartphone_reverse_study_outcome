package kotlin.coroutines.jvm.internal;

import H7.c;
import H7.d;
import H7.e;
import H7.f;
import H7.h;
import J7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u000f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "LH7/c;", "", "intercepted", "()LH7/c;", "LC7/r;", "releaseIntercepted", "()V", "LH7/h;", "_context", "LH7/h;", "LH7/c;", "getContext", "()LH7/h;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final h _context;
    private transient c<Object> intercepted;

    public ContinuationImpl(h hVar, c cVar) {
        super(cVar);
        this._context = hVar;
    }

    @Override // H7.c
    public h getContext() {
        h hVar = this._context;
        k.c(hVar);
        return hVar;
    }

    public final c<Object> intercepted() {
        c cVarInterceptContinuation = this.intercepted;
        if (cVarInterceptContinuation == null) {
            e eVar = (e) getContext().get(d.f758a);
            if (eVar == null || (cVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                cVarInterceptContinuation = this;
            }
            this.intercepted = cVarInterceptContinuation;
        }
        return cVarInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        c<Object> cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            f fVar = getContext().get(d.f758a);
            k.c(fVar);
            ((e) fVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = a.f878a;
    }

    public ContinuationImpl(c cVar) {
        this(cVar != null ? cVar.getContext() : null, cVar);
    }
}
