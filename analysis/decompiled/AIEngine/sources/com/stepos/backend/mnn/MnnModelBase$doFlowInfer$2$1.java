package com.stepos.backend.mnn;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.backend.mnn.MnnModelBase$doFlowInfer$2$1", f = "MnnModelBase.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MnnModelBase$doFlowInfer$2$1 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {
    final /* synthetic */ Flow<Result<v6.d>> $flow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MnnModelBase$doFlowInfer$2$1(Flow<? extends Result<? extends v6.d>> flow, qb.b<? super MnnModelBase$doFlowInfer$2$1> bVar) {
        super(2, bVar);
        this.$flow = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        MnnModelBase$doFlowInfer$2$1 mnnModelBase$doFlowInfer$2$1 = new MnnModelBase$doFlowInfer$2$1(this.$flow, bVar);
        mnnModelBase$doFlowInfer$2$1.L$0 = obj;
        return mnnModelBase$doFlowInfer$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow<Result<v6.d>> flow = this.$flow;
            FlowCollector<? super Result<v6.d>> flowCollector2 = new FlowCollector() { // from class: com.stepos.backend.mnn.MnnModelBase$doFlowInfer$2$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj2, qb.b<? super n> bVar) {
                    FlowCollector<Result<? extends Object>> flowCollector3 = flowCollector;
                    Object obj3 = ((Result) obj2).f9987a;
                    if (!(obj3 instanceof Result.Failure)) {
                        obj3 = (v6.d) obj3;
                        kotlin.jvm.internal.g.d(obj3, "null cannot be cast to non-null type kotlin.Any");
                    }
                    Object objEmit = flowCollector3.emit(new Result<>(obj3), bVar);
                    return objEmit == CoroutineSingletons.f10059a ? objEmit : n.f10413a;
                }
            };
            this.label = 1;
            if (flow.collect(flowCollector2, this) == coroutineSingletons) {
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
    public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
        return ((MnnModelBase$doFlowInfer$2$1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
    }
}
