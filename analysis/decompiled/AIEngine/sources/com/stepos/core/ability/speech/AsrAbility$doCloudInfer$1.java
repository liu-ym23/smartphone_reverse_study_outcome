package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrAbility", f = "ASRAbility.kt", l = {432, 463}, m = "doCloudInfer-0E7RQCE")
/* loaded from: classes.dex */
public final class AsrAbility$doCloudInfer$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrAbility$doCloudInfer$1(AsrAbility asrAbility, qb.b<? super AsrAbility$doCloudInfer$1> bVar) {
        super(bVar);
        this.this$0 = asrAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM35doCloudInfer0E7RQCE = this.this$0.m35doCloudInfer0E7RQCE((c.a) null, (Object) null, (qb.b<? super Result<d.q>>) this);
        return objM35doCloudInfer0E7RQCE == CoroutineSingletons.f10059a ? objM35doCloudInfer0E7RQCE : new Result(objM35doCloudInfer0E7RQCE);
    }
}
