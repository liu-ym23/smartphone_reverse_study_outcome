package com.stepos.core.ability.vision;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.vision.InteractiveSegmentAbility", f = "InteractiveSegmentAbility.kt", l = {65}, m = "doInfer-0E7RQCE")
/* loaded from: classes.dex */
public final class InteractiveSegmentAbility$doInfer$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InteractiveSegmentAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractiveSegmentAbility$doInfer$2(InteractiveSegmentAbility interactiveSegmentAbility, b<? super InteractiveSegmentAbility$doInfer$2> bVar) {
        super(bVar);
        this.this$0 = interactiveSegmentAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM90doInfer0E7RQCE = this.this$0.m90doInfer0E7RQCE((c.e) null, (Object) null, (b<? super Result<d.l>>) this);
        return objM90doInfer0E7RQCE == CoroutineSingletons.f10059a ? objM90doInfer0E7RQCE : new Result(objM90doInfer0E7RQCE);
    }
}
