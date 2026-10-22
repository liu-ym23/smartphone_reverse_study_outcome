package com.stepos.core.ability.vision;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.vision.HighlightAbility", f = "HighlightAbility.kt", l = {110}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class HighlightAbility$doInfer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HighlightAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HighlightAbility$doInfer$1(HighlightAbility highlightAbility, b<? super HighlightAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = highlightAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM81doInfergIAlus = this.this$0.m81doInfergIAlus((c.e) null, (b<? super Result<d.q>>) this);
        return objM81doInfergIAlus == CoroutineSingletons.f10059a ? objM81doInfergIAlus : new Result(objM81doInfergIAlus);
    }
}
