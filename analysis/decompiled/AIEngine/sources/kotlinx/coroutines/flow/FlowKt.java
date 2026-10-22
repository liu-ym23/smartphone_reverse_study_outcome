package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.List;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import lb.n;
import zb.p;
import zb.q;
import zb.r;

/* loaded from: classes.dex */
public final class FlowKt {
    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return FlowKt__ShareKt.asStateFlow(mutableStateFlow);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> flow, int i10, BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.buffer(flow, i10, bufferOverflow);
    }

    public static final <T> Flow<T> callbackFlow(p<? super ProducerScope<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.callbackFlow(pVar);
    }

    /* renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m168catch(Flow<? extends T> flow, q<? super FlowCollector<? super T>, ? super Throwable, ? super qb.b<? super n>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.m169catch(flow, qVar);
    }

    public static final <T> Object catchImpl(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, qb.b<? super Throwable> bVar) {
        return FlowKt__ErrorsKt.catchImpl(flow, flowCollector, bVar);
    }

    public static final <T> Flow<T> channelFlow(p<? super ProducerScope<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.channelFlow(pVar);
    }

    public static final Object collect(Flow<?> flow, qb.b<? super n> bVar) {
        return FlowKt__CollectKt.collect(flow, bVar);
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> flow) {
        return FlowKt__ContextKt.conflate(flow);
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow);
    }

    public static final <T> Flow<T> dropWhile(Flow<? extends T> flow, p<? super T, ? super qb.b<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.dropWhile(flow, pVar);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, qb.b<? super n> bVar) {
        return FlowKt__ChannelsKt.emitAll(flowCollector, receiveChannel, bVar);
    }

    public static final void ensureActive(FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.ensureActive(flowCollector);
    }

    public static final <T> Object first(Flow<? extends T> flow, qb.b<? super T> bVar) {
        return FlowKt__ReduceKt.first(flow, bVar);
    }

    public static final <T> Flow<T> flow(p<? super FlowCollector<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.flow(pVar);
    }

    public static final <T> Flow<T> flowOf(T t8) {
        return FlowKt__BuildersKt.flowOf(t8);
    }

    public static final <T> Flow<T> flowOn(Flow<? extends T> flow, d dVar) {
        return FlowKt__ContextKt.flowOn(flow, dVar);
    }

    public static final <T> Job launchIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.launchIn(flow, coroutineScope);
    }

    public static final <T> Flow<T> onCompletion(Flow<? extends T> flow, q<? super FlowCollector<? super T>, ? super Throwable, ? super qb.b<? super n>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.onCompletion(flow, qVar);
    }

    public static final <T> Flow<T> onEach(Flow<? extends T> flow, p<? super T, ? super qb.b<? super n>, ? extends Object> pVar) {
        return FlowKt__TransformKt.onEach(flow, pVar);
    }

    public static final <T> Flow<T> onStart(Flow<? extends T> flow, p<? super FlowCollector<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.onStart(flow, pVar);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, p<? super FlowCollector<? super T>, ? super qb.b<? super n>, ? extends Object> pVar) {
        return FlowKt__ShareKt.onSubscription(sharedFlow, pVar);
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.receiveAsFlow(receiveChannel);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> flow, r<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super qb.b<? super Boolean>, ? extends Object> rVar) {
        return FlowKt__ErrorsKt.retryWhen(flow, rVar);
    }

    public static final <T> Object single(Flow<? extends T> flow, qb.b<? super T> bVar) {
        return FlowKt__ReduceKt.single(flow, bVar);
    }

    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> flow, C c9, qb.b<? super C> bVar) {
        return FlowKt__CollectionKt.toCollection(flow, c9, bVar);
    }

    public static final <T> Object toList(Flow<? extends T> flow, List<T> list, qb.b<? super List<? extends T>> bVar) {
        return FlowKt__CollectionKt.toList(flow, list, bVar);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, qb.b<? super n> bVar) {
        return FlowKt__CollectKt.emitAll(flowCollector, flow, bVar);
    }
}
