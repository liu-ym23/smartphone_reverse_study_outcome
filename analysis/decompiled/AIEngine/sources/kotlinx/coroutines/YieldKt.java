package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class YieldKt {
    public static final Object yield(b<? super n> bVar) {
        Object obj;
        d context = bVar.getContext();
        JobKt.ensureActive(context);
        b bVarW = jd.b.w(bVar);
        DispatchedContinuation dispatchedContinuation = bVarW instanceof DispatchedContinuation ? (DispatchedContinuation) bVarW : null;
        if (dispatchedContinuation == null) {
            obj = n.f10413a;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, n.f10413a);
            } else {
                YieldContext yieldContext = new YieldContext();
                d dVarPlus = context.plus(yieldContext);
                n nVar = n.f10413a;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(dVarPlus, nVar);
                obj = (!yieldContext.dispatcherWasUnconfined || DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation)) ? CoroutineSingletons.f10059a : nVar;
            }
            obj = CoroutineSingletons.f10059a;
        }
        return obj == CoroutineSingletons.f10059a ? obj : n.f10413a;
    }
}
