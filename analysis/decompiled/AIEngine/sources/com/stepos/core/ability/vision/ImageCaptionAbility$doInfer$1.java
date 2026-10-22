package com.stepos.core.ability.vision;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.vision.ImageCaptionAbility", f = "ImageCaptionAbility.kt", l = {31}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class ImageCaptionAbility$doInfer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageCaptionAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCaptionAbility$doInfer$1(ImageCaptionAbility imageCaptionAbility, b<? super ImageCaptionAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = imageCaptionAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM83doInfergIAlus = this.this$0.m83doInfergIAlus((c.C0155c) null, (b<? super Result<d.r>>) this);
        return objM83doInfergIAlus == CoroutineSingletons.f10059a ? objM83doInfergIAlus : new Result(objM83doInfergIAlus);
    }
}
