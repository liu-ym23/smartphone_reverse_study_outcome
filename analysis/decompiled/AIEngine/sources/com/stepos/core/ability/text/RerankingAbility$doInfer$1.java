package com.stepos.core.ability.text;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.RerankingAbility", f = "RerankingAbility.kt", l = {41}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class RerankingAbility$doInfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RerankingAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RerankingAbility$doInfer$1(RerankingAbility rerankingAbility, qb.b<? super RerankingAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = rerankingAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM67doInfergIAlus = this.this$0.m67doInfergIAlus((c.e) null, (qb.b<? super Result<d.e>>) this);
        return objM67doInfergIAlus == CoroutineSingletons.f10059a ? objM67doInfergIAlus : new Result(objM67doInfergIAlus);
    }
}
