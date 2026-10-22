package com.stepos.core.ability.speech;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrCloudUploadHelper", f = "AsrCloudUploadHelper.kt", l = {ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR}, m = "ensureAudioUrl-0E7RQCE")
/* loaded from: classes.dex */
public final class AsrCloudUploadHelper$ensureAudioUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrCloudUploadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrCloudUploadHelper$ensureAudioUrl$1(AsrCloudUploadHelper asrCloudUploadHelper, qb.b<? super AsrCloudUploadHelper$ensureAudioUrl$1> bVar) {
        super(bVar);
        this.this$0 = asrCloudUploadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM37ensureAudioUrl0E7RQCE = this.this$0.m37ensureAudioUrl0E7RQCE(null, 0, this);
        return objM37ensureAudioUrl0E7RQCE == CoroutineSingletons.f10059a ? objM37ensureAudioUrl0E7RQCE : new Result(objM37ensureAudioUrl0E7RQCE);
    }
}
