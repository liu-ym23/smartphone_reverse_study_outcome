package kotlinx.coroutines.internal;

import kotlin.coroutines.d;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;
import rb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements b {
    public final qb.b<T> uCont;

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeCoroutine(d dVar, qb.b<? super T> bVar) {
        super(dVar, true, true);
        this.uCont = bVar;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(Object obj) {
        DispatchedContinuationKt.resumeCancellableWith(jd.b.w(this.uCont), CompletionStateKt.recoverResult(obj, this.uCont));
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void afterResume(Object obj) {
        qb.b<T> bVar = this.uCont;
        bVar.resumeWith(CompletionStateKt.recoverResult(obj, bVar));
    }

    @Override // rb.b
    public final b getCallerFrame() {
        qb.b<T> bVar = this.uCont;
        if (bVar instanceof b) {
            return (b) bVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean isScopedCoroutine() {
        return true;
    }
}
