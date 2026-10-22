package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.FlowCollector;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$client$1", f = "ASRAbility.kt", l = {360}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrAbility$doFlowCloudInfer$client$1 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public AsrAbility$doFlowCloudInfer$client$1(qb.b<? super AsrAbility$doFlowCloudInfer$client$1> bVar) {
        super(2, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        AsrAbility$doFlowCloudInfer$client$1 asrAbility$doFlowCloudInfer$client$1 = new AsrAbility$doFlowCloudInfer$client$1(bVar);
        asrAbility$doFlowCloudInfer$client$1.L$0 = obj;
        return asrAbility$doFlowCloudInfer$client$1;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
        return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Result result = new Result(a0.a.r("AsrFileCloudClient initialization failed"));
            this.label = 1;
            if (flowCollector.emit(result, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
        return ((AsrAbility$doFlowCloudInfer$client$1) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
