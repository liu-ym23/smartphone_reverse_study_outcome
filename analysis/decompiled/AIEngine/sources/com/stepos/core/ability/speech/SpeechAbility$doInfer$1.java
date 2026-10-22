package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.SpeechAbility", f = "SpeechAbility.kt", l = {85, 85}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class SpeechAbility$doInfer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpeechAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechAbility$doInfer$1(SpeechAbility speechAbility, qb.b<? super SpeechAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = speechAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM60doInfergIAlus = this.this$0.m60doInfergIAlus((c.g) null, (qb.b<? super Result<d.b>>) this);
        return objM60doInfergIAlus == CoroutineSingletons.f10059a ? objM60doInfergIAlus : new Result(objM60doInfergIAlus);
    }
}
