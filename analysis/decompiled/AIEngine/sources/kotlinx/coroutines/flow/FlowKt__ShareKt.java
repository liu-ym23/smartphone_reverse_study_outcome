package kotlinx.coroutines.flow;

import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, p<? super FlowCollector<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return new SubscribedSharedFlow(sharedFlow, pVar);
    }
}
