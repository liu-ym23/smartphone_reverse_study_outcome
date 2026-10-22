package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility", f = "AsrSseAbility.kt", l = {603}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class AsrSseAbility$doInfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrSseAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrSseAbility$doInfer$1(AsrSseAbility asrSseAbility, qb.b<? super AsrSseAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = asrSseAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM57doInfergIAlus = this.this$0.m57doInfergIAlus((c.a) null, (qb.b<? super Result<d.q>>) this);
        return objM57doInfergIAlus == CoroutineSingletons.f10059a ? objM57doInfergIAlus : new Result(objM57doInfergIAlus);
    }
}
