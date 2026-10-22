package kotlinx.coroutines.flow;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ChannelFlowBuilder<T> extends ChannelFlow<T> {
    private final p<ProducerScope<? super T>, qb.b<? super n>, Object> block;

    public /* synthetic */ ChannelFlowBuilder(p pVar, d dVar, int i10, BufferOverflow bufferOverflow, int i11, e eVar) {
        this(pVar, (i11 & 2) != 0 ? EmptyCoroutineContext.f10057a : dVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public static <T> Object collectTo$suspendImpl(ChannelFlowBuilder<T> channelFlowBuilder, ProducerScope<? super T> producerScope, qb.b<? super n> bVar) {
        Object objInvoke = ((ChannelFlowBuilder) channelFlowBuilder).block.invoke(producerScope, bVar);
        return objInvoke == CoroutineSingletons.f10059a ? objInvoke : n.f10413a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, qb.b<? super n> bVar) {
        return collectTo$suspendImpl(this, producerScope, bVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> create(d dVar, int i10, BufferOverflow bufferOverflow) {
        return new ChannelFlowBuilder(this.block, dVar, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowBuilder(p<? super ProducerScope<? super T>, ? super qb.b<? super n>, ? extends Object> pVar, d dVar, int i10, BufferOverflow bufferOverflow) {
        super(dVar, i10, bufferOverflow);
        this.block = pVar;
    }
}
