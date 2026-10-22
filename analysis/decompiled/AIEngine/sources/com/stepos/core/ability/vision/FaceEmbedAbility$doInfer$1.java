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
@c(c = "com.stepos.core.ability.vision.FaceEmbedAbility", f = "FaceEmbedAbility.kt", l = {ErrorCodes.GET_CONTENT_URI_ERROR}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class FaceEmbedAbility$doInfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FaceEmbedAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceEmbedAbility$doInfer$1(FaceEmbedAbility faceEmbedAbility, b<? super FaceEmbedAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = faceEmbedAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM76doInfergIAlus = this.this$0.m76doInfergIAlus((c.C0155c) null, (b<? super Result<d.i>>) this);
        return objM76doInfergIAlus == CoroutineSingletons.f10059a ? objM76doInfergIAlus : new Result(objM76doInfergIAlus);
    }
}
