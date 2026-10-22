package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<Pair<d, Object>> threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(d dVar, b<? super T> bVar) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.INSTANCE;
        super(dVar.get(undispatchedMarker) == null ? dVar.plus(undispatchedMarker) : dVar, bVar);
        this.threadStateToRecover = new ThreadLocal<>();
        if (bVar.getContext().get(c.a.f10058a) instanceof CoroutineDispatcher) {
            return;
        }
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(dVar, null);
        ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
        saveThreadContext(dVar, objUpdateThreadContext);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<d, Object> pair = this.threadStateToRecover.get();
            if (pair != null) {
                ThreadContextKt.restoreThreadContext(pair.f9985a, pair.f9986b);
            }
            this.threadStateToRecover.remove();
        }
        Object objRecoverResult = CompletionStateKt.recoverResult(obj, this.uCont);
        b<T> bVar = this.uCont;
        d context = bVar.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(bVar, context, objUpdateThreadContext) : null;
        try {
            this.uCont.resumeWith(objRecoverResult);
            n nVar = n.f10413a;
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        } catch (Throwable th) {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
            throw th;
        }
    }

    public final boolean clearThreadContext() {
        boolean z = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z;
    }

    public final void saveThreadContext(d dVar, Object obj) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(new Pair<>(dVar, obj));
    }
}
