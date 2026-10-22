package com.stepos.core.ability.text;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.RerankingAbility", f = "RerankingAbility.kt", l = {ErrorCodes.CALLER_NOT_IN_SERVICE_WHITE_LIST_ERROR}, m = "doInfer-0E7RQCE")
/* loaded from: classes.dex */
public final class RerankingAbility$doInfer$2 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RerankingAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RerankingAbility$doInfer$2(RerankingAbility rerankingAbility, qb.b<? super RerankingAbility$doInfer$2> bVar) {
        super(bVar);
        this.this$0 = rerankingAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM66doInfer0E7RQCE = this.this$0.m66doInfer0E7RQCE((c.e) null, (Object) null, (qb.b<? super Result<d.e>>) this);
        return objM66doInfer0E7RQCE == CoroutineSingletons.f10059a ? objM66doInfer0E7RQCE : new Result(objM66doInfer0E7RQCE);
    }
}
