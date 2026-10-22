package com.stepos.core.ability.speech;

import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.error.AIEngineError;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.FlowCollector;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$cfg$2", f = "SpeechAbility.kt", l = {238}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SpeechAbility$doFlowCloudInfer$cfg$2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public SpeechAbility$doFlowCloudInfer$cfg$2(qb.b<? super SpeechAbility$doFlowCloudInfer$cfg$2> bVar) {
        super(2, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        SpeechAbility$doFlowCloudInfer$cfg$2 speechAbility$doFlowCloudInfer$cfg$2 = new SpeechAbility$doFlowCloudInfer$cfg$2(bVar);
        speechAbility$doFlowCloudInfer$cfg$2.L$0 = obj;
        return speechAbility$doFlowCloudInfer$cfg$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, qb.b<? super lb.n> bVar) {
        return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "Cloud TTS not configured: cloud.enable is false in abilities.json")));
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
    public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, qb.b<? super lb.n> bVar) {
        return ((SpeechAbility$doFlowCloudInfer$cfg$2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
