package com.stepos.core.ability.text;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.EmbeddingAbility", f = "EmbeddingAbility.kt", l = {ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR, ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR}, m = "doInfer-0E7RQCE")
/* loaded from: classes.dex */
public final class EmbeddingAbility$doInfer$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EmbeddingAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddingAbility$doInfer$2(EmbeddingAbility embeddingAbility, qb.b<? super EmbeddingAbility$doInfer$2> bVar) {
        super(bVar);
        this.this$0 = embeddingAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM63doInfer0E7RQCE = this.this$0.m63doInfer0E7RQCE((c.g) null, (Object) null, (qb.b<? super Result<d.e>>) this);
        return objM63doInfer0E7RQCE == CoroutineSingletons.f10059a ? objM63doInfer0E7RQCE : new Result(objM63doInfer0E7RQCE);
    }
}
