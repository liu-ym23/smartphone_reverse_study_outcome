package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.FlowCollector;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2", f = "AsrMultiFilesPipeline.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2 extends SuspendLambda implements zb.p<String, qb.b<? super lb.n>, Object> {
    final /* synthetic */ FlowCollector<Result<d.q>> $$this$flow;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2> bVar) {
        super(2, bVar);
        this.$$this$flow = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2 asrMultiFilesPipeline$runCloudMultiFiles$1$drain$2 = new AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2(this.$$this$flow, bVar);
        asrMultiFilesPipeline$runCloudMultiFiles$1$drain$2.L$0 = obj;
        return asrMultiFilesPipeline$runCloudMultiFiles$1$drain$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            String str = (String) this.L$0;
            FlowCollector<Result<d.q>> flowCollector = this.$$this$flow;
            Result<d.q> result = new Result<>(new d.q(str, null, null, 6));
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

    @Override // zb.p
    public final Object invoke(String str, qb.b<? super lb.n> bVar) {
        return ((AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2) create(str, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
