package com.stepos.core.ability.text;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.RiskClassifyAbility", f = "RiskClassifyAbility.kt", l = {40}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class RiskClassifyAbility$doInfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RiskClassifyAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskClassifyAbility$doInfer$1(RiskClassifyAbility riskClassifyAbility, qb.b<? super RiskClassifyAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = riskClassifyAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM71doInfergIAlus = this.this$0.m71doInfergIAlus((c.g) null, (qb.b<? super Result<d.q>>) this);
        return objM71doInfergIAlus == CoroutineSingletons.f10059a ? objM71doInfergIAlus : new Result(objM71doInfergIAlus);
    }
}
