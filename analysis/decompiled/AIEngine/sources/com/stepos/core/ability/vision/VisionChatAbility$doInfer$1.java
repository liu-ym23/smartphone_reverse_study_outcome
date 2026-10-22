package com.stepos.core.ability.vision;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.vision.VisionChatAbility", f = "VisionChatAbility.kt", l = {ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class VisionChatAbility$doInfer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VisionChatAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisionChatAbility$doInfer$1(VisionChatAbility visionChatAbility, b<? super VisionChatAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = visionChatAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM94doInfergIAlus = this.this$0.m94doInfergIAlus((c.e) null, (b<? super Result<d.q>>) this);
        return objM94doInfergIAlus == CoroutineSingletons.f10059a ? objM94doInfergIAlus : new Result(objM94doInfergIAlus);
    }
}
