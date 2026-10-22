package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrAbility", f = "ASRAbility.kt", l = {516, 517, 528}, m = "inferSingleLocal-gIAlu-s")
/* loaded from: classes.dex */
public final class AsrAbility$inferSingleLocal$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrAbility$inferSingleLocal$1(AsrAbility asrAbility, qb.b<? super AsrAbility$inferSingleLocal$1> bVar) {
        super(bVar);
        this.this$0 = asrAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM34inferSingleLocalgIAlus = this.this$0.m34inferSingleLocalgIAlus(null, this);
        return objM34inferSingleLocalgIAlus == CoroutineSingletons.f10059a ? objM34inferSingleLocalgIAlus : new Result(objM34inferSingleLocalgIAlus);
    }
}
