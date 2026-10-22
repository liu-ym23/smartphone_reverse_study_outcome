package kotlinx.coroutines.intrinsics;

import kotlin.c;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UndispatchedKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void startCoroutineUndispatched(p<? super R, ? super b<? super T>, ? extends Object> pVar, R r, b<? super T> completion) {
        Object objInvoke;
        g.f(completion, "completion");
        try {
            d context = completion.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                if (pVar instanceof BaseContinuationImpl) {
                    k.c(2, pVar);
                    objInvoke = pVar.invoke(r, completion);
                } else {
                    objInvoke = jd.b.R(pVar, r, completion);
                }
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                if (objInvoke != CoroutineSingletons.f10059a) {
                    completion.resumeWith(objInvoke);
                }
            } catch (Throwable th) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            completion.resumeWith(c.a(th2));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, p<? super R, ? super b<? super T>, ? extends Object> pVar) {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            if (pVar instanceof BaseContinuationImpl) {
                k.c(2, pVar);
                completedExceptionally = pVar.invoke(r, scopeCoroutine);
            } else {
                completedExceptionally = jd.b.R(pVar, r, scopeCoroutine);
            }
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        return JobSupportKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> scopeCoroutine, R r, p<? super R, ? super b<? super T>, ? extends Object> pVar) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            if (pVar instanceof BaseContinuationImpl) {
                k.c(2, pVar);
                completedExceptionally = pVar.invoke(r, scopeCoroutine);
            } else {
                completedExceptionally = jd.b.R(pVar, r, scopeCoroutine);
            }
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != scopeCoroutine) {
                throw th2;
            }
            if (completedExceptionally instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) completedExceptionally).cause;
            }
        } else {
            completedExceptionally = JobSupportKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return completedExceptionally;
    }
}
