package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import lb.n;
import qb.b;
import zb.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar) {
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        DeferredCoroutine lazyDeferredCoroutine = coroutineStart.isLazy() ? new LazyDeferredCoroutine(dVarNewCoroutineContext, pVar) : new DeferredCoroutine(dVarNewCoroutineContext, true);
        ((AbstractCoroutine) lazyDeferredCoroutine).start(coroutineStart, lazyDeferredCoroutine, pVar);
        return (Deferred<T>) lazyDeferredCoroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f10057a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, dVar, coroutineStart, pVar);
    }

    public static final Job launch(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, p<? super CoroutineScope, ? super b<? super n>, ? extends Object> pVar) {
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        AbstractCoroutine lazyStandaloneCoroutine = coroutineStart.isLazy() ? new LazyStandaloneCoroutine(dVarNewCoroutineContext, pVar) : new StandaloneCoroutine(dVarNewCoroutineContext, true);
        lazyStandaloneCoroutine.start(coroutineStart, lazyStandaloneCoroutine, pVar);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f10057a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, dVar, coroutineStart, pVar);
    }

    public static final <T> Object withContext(d dVar, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar, b<? super T> bVar) {
        Object result$kotlinx_coroutines_core;
        d context = bVar.getContext();
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(context, dVar);
        JobKt.ensureActive(dVarNewCoroutineContext);
        if (dVarNewCoroutineContext == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(dVarNewCoroutineContext, bVar);
            result$kotlinx_coroutines_core = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, pVar);
        } else {
            c.a aVar = c.a.f10058a;
            if (g.b(dVarNewCoroutineContext.get(aVar), context.get(aVar))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(dVarNewCoroutineContext, bVar);
                d context2 = undispatchedCoroutine.getContext();
                Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context2, null);
                try {
                    Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, pVar);
                    ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    result$kotlinx_coroutines_core = objStartUndispatchedOrReturn;
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(dVarNewCoroutineContext, bVar);
                CancellableKt.startCoroutineCancellable(pVar, dispatchedCoroutine, dispatchedCoroutine);
                result$kotlinx_coroutines_core = dispatchedCoroutine.getResult$kotlinx_coroutines_core();
            }
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return result$kotlinx_coroutines_core;
    }
}
