package kotlinx.coroutines.flow;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.ProducerScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__BuildersKt {
    public static final <T> Flow<T> callbackFlow(p<? super ProducerScope<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return new CallbackFlowBuilder(pVar, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> channelFlow(p<? super ProducerScope<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return new ChannelFlowBuilder(pVar, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> flow(p<? super FlowCollector<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return new SafeFlow(pVar);
    }

    public static final <T> Flow<T> flowOf(final T t8) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, qb.b<? super n> bVar) {
                Object objEmit = flowCollector.emit((Object) t8, bVar);
                return objEmit == CoroutineSingletons.f10059a ? objEmit : n.f10413a;
            }
        };
    }
}
