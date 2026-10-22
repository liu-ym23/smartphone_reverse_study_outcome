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
@c(c = "com.stepos.core.ability.vision.FaceDetectAbility", f = "FaceDetectAbility.kt", l = {ErrorCodes.GET_CONTENT_URI_ERROR}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class FaceDetectAbility$doInfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FaceDetectAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceDetectAbility$doInfer$1(FaceDetectAbility faceDetectAbility, b<? super FaceDetectAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = faceDetectAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM74doInfergIAlus = this.this$0.m74doInfergIAlus((c.C0155c) null, (b<? super Result<d.h>>) this);
        return objM74doInfergIAlus == CoroutineSingletons.f10059a ? objM74doInfergIAlus : new Result(objM74doInfergIAlus);
    }
}
