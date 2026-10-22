package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FlowCoroutineKt {
    public static final <R> Object flowScope(p<? super CoroutineScope, ? super b<? super R>, ? extends Object> pVar, b<? super R> bVar) {
        FlowCoroutine flowCoroutine = new FlowCoroutine(bVar.getContext(), bVar);
        Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(flowCoroutine, flowCoroutine, pVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return objStartUndispatchedOrReturn;
    }
}
