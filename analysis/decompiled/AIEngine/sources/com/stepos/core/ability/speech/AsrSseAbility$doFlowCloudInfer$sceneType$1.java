package com.stepos.core.ability.speech;

import com.stepos.base.strategy.OrchestrationRejectedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.FlowCollector;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$doFlowCloudInfer$sceneType$1", f = "AsrSseAbility.kt", l = {214}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrSseAbility$doFlowCloudInfer$sceneType$1 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
    final /* synthetic */ OrchestrationRejectedException $e;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrSseAbility$doFlowCloudInfer$sceneType$1(OrchestrationRejectedException orchestrationRejectedException, qb.b<? super AsrSseAbility$doFlowCloudInfer$sceneType$1> bVar) {
        super(2, bVar);
        this.$e = orchestrationRejectedException;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        AsrSseAbility$doFlowCloudInfer$sceneType$1 asrSseAbility$doFlowCloudInfer$sceneType$1 = new AsrSseAbility$doFlowCloudInfer$sceneType$1(this.$e, bVar);
        asrSseAbility$doFlowCloudInfer$sceneType$1.L$0 = obj;
        return asrSseAbility$doFlowCloudInfer$sceneType$1;
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
            Result result = new Result(kotlin.c.a(this.$e));
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
        return ((AsrSseAbility$doFlowCloudInfer$sceneType$1) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
