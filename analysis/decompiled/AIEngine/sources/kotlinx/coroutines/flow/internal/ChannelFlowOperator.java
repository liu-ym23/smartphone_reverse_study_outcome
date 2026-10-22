package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    protected final Flow<S> flow;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {148}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super T>, b<? super n>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChannelFlowOperator<S, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ChannelFlowOperator<S, T> channelFlowOperator, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.this$0 = channelFlowOperator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector<? super T> flowCollector = (FlowCollector) this.L$0;
                ChannelFlowOperator<S, T> channelFlowOperator = this.this$0;
                this.label = 1;
                if (channelFlowOperator.flowCollect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super T> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(Flow<? extends S> flow, d dVar, int i10, BufferOverflow bufferOverflow) {
        super(dVar, i10, bufferOverflow);
        this.flow = flow;
    }

    public static <S, T> Object collect$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, FlowCollector<? super T> flowCollector, b<? super n> bVar) {
        if (channelFlowOperator.capacity == -3) {
            d context = bVar.getContext();
            d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(context, channelFlowOperator.context);
            if (g.b(dVarNewCoroutineContext, context)) {
                Object objFlowCollect = channelFlowOperator.flowCollect(flowCollector, bVar);
                return objFlowCollect == CoroutineSingletons.f10059a ? objFlowCollect : n.f10413a;
            }
            c.a aVar = c.a.f10058a;
            if (g.b(dVarNewCoroutineContext.get(aVar), context.get(aVar))) {
                Object objCollectWithContextUndispatched = channelFlowOperator.collectWithContextUndispatched(flowCollector, dVarNewCoroutineContext, bVar);
                return objCollectWithContextUndispatched == CoroutineSingletons.f10059a ? objCollectWithContextUndispatched : n.f10413a;
            }
        }
        Object objCollect = super.collect(flowCollector, bVar);
        return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
    }

    public static <S, T> Object collectTo$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, ProducerScope<? super T> producerScope, b<? super n> bVar) {
        Object objFlowCollect = channelFlowOperator.flowCollect(new SendingCollector(producerScope), bVar);
        return objFlowCollect == CoroutineSingletons.f10059a ? objFlowCollect : n.f10413a;
    }

    private final Object collectWithContextUndispatched(FlowCollector<? super T> flowCollector, d dVar, b<? super n> bVar) {
        return ChannelFlowKt.withContextUndispatched$default(dVar, ChannelFlowKt.withUndispatchedContextCollector(flowCollector, bVar.getContext()), null, new AnonymousClass2(this, null), bVar, 4, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, b<? super n> bVar) {
        return collect$suspendImpl((ChannelFlowOperator) this, (FlowCollector) flowCollector, bVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, b<? super n> bVar) {
        return collectTo$suspendImpl(this, producerScope, bVar);
    }

    public abstract Object flowCollect(FlowCollector<? super T> flowCollector, b<? super n> bVar);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
