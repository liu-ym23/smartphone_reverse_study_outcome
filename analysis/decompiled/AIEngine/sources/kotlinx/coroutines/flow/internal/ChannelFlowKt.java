package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChannelFlowKt {
    public static final <T, V> Object withContextUndispatched(d dVar, V v3, Object obj, p<? super V, ? super b<? super T>, ? extends Object> pVar, b<? super T> frame) {
        Object objInvoke;
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(dVar, obj);
        try {
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(frame, dVar);
            if (pVar instanceof BaseContinuationImpl) {
                k.c(2, pVar);
                objInvoke = pVar.invoke(v3, stackFrameContinuation);
            } else {
                objInvoke = jd.b.R(pVar, v3, stackFrameContinuation);
            }
            ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
            if (objInvoke == CoroutineSingletons.f10059a) {
                g.f(frame, "frame");
            }
            return objInvoke;
        } catch (Throwable th) {
            ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
            throw th;
        }
    }

    public static /* synthetic */ Object withContextUndispatched$default(d dVar, Object obj, Object obj2, p pVar, b bVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = ThreadContextKt.threadContextElements(dVar);
        }
        return withContextUndispatched(dVar, obj, obj2, pVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> flowCollector, d dVar) {
        return ((flowCollector instanceof SendingCollector) || (flowCollector instanceof NopCollector)) ? flowCollector : new UndispatchedContextCollector(flowCollector, dVar);
    }
}
