package com.stepos.core.ability.text;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import v6.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.RiskClassifyAbility$moderate$decision$1$1$1", f = "RiskClassifyAbility.kt", l = {80}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RiskClassifyAbility$moderate$decision$1$1$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {
    final /* synthetic */ String $chunk;
    final /* synthetic */ Object $record;
    int label;
    final /* synthetic */ RiskClassifyAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskClassifyAbility$moderate$decision$1$1$1(RiskClassifyAbility riskClassifyAbility, String str, Object obj, qb.b<? super RiskClassifyAbility$moderate$decision$1$1$1> bVar) {
        super(2, bVar);
        this.this$0 = riskClassifyAbility;
        this.$chunk = str;
        this.$record = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new RiskClassifyAbility$moderate$decision$1$1$1(this.this$0, this.$chunk, this.$record, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        RiskClassifyAbility riskClassifyAbility = this.this$0;
        c.g gVar = new c.g(this.$chunk, null, 6);
        Object obj2 = this.$record;
        this.label = 1;
        Object objInferModel = riskClassifyAbility.inferModel(gVar, obj2, this);
        return objInferModel == coroutineSingletons ? coroutineSingletons : objInferModel;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
        return ((RiskClassifyAbility$moderate$decision$1$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
