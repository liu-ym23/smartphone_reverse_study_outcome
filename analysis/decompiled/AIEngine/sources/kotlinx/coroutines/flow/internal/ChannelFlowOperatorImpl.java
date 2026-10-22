package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChannelFlowOperatorImpl<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ ChannelFlowOperatorImpl(Flow flow, d dVar, int i10, BufferOverflow bufferOverflow, int i11, e eVar) {
        this(flow, (i11 & 2) != 0 ? EmptyCoroutineContext.f10057a : dVar, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> create(d dVar, int i10, BufferOverflow bufferOverflow) {
        return new ChannelFlowOperatorImpl(this.flow, dVar, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object flowCollect(FlowCollector<? super T> flowCollector, b<? super n> bVar) {
        Object objCollect = this.flow.collect(flowCollector, bVar);
        return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
    }

    public ChannelFlowOperatorImpl(Flow<? extends T> flow, d dVar, int i10, BufferOverflow bufferOverflow) {
        super(flow, dVar, i10, bufferOverflow);
    }
}
