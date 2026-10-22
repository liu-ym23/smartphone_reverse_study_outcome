package com.stepos.core.ability.speech;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFileCloudClient", f = "AsrFileCloudClient.kt", l = {ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR}, m = "recognize-gIAlu-s")
/* loaded from: classes.dex */
public final class AsrFileCloudClient$recognize$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrFileCloudClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFileCloudClient$recognize$1(AsrFileCloudClient asrFileCloudClient, qb.b<? super AsrFileCloudClient$recognize$1> bVar) {
        super(bVar);
        this.this$0 = asrFileCloudClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM51recognizegIAlus = this.this$0.m51recognizegIAlus(null, this);
        return objM51recognizegIAlus == CoroutineSingletons.f10059a ? objM51recognizegIAlus : new Result(objM51recognizegIAlus);
    }
}
