package com.stepos.core.ability.text;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.RiskClassifyAbility", f = "RiskClassifyAbility.kt", l = {76}, m = "moderate-0E7RQCE")
/* loaded from: classes.dex */
public final class RiskClassifyAbility$moderate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RiskClassifyAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskClassifyAbility$moderate$1(RiskClassifyAbility riskClassifyAbility, qb.b<? super RiskClassifyAbility$moderate$1> bVar) {
        super(bVar);
        this.this$0 = riskClassifyAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM69moderate0E7RQCE = this.this$0.m69moderate0E7RQCE(null, null, this);
        return objM69moderate0E7RQCE == CoroutineSingletons.f10059a ? objM69moderate0E7RQCE : new Result(objM69moderate0E7RQCE);
    }
}
