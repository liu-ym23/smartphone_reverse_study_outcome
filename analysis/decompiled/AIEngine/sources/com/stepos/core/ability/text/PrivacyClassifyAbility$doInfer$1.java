package com.stepos.core.ability.text;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.PrivacyClassifyAbility", f = "PrivacyClassifyAbility.kt", l = {39, 40}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class PrivacyClassifyAbility$doInfer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrivacyClassifyAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyClassifyAbility$doInfer$1(PrivacyClassifyAbility privacyClassifyAbility, qb.b<? super PrivacyClassifyAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = privacyClassifyAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM65doInfergIAlus = this.this$0.m65doInfergIAlus((c.g) null, (qb.b<? super Result<d.p>>) this);
        return objM65doInfergIAlus == CoroutineSingletons.f10059a ? objM65doInfergIAlus : new Result(objM65doInfergIAlus);
    }
}
