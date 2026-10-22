package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFileCloudClient", f = "AsrFileCloudClient.kt", l = {63}, m = "recognize-bMdYcbs")
/* loaded from: classes.dex */
public final class AsrFileCloudClient$recognize$3 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrFileCloudClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFileCloudClient$recognize$3(AsrFileCloudClient asrFileCloudClient, qb.b<? super AsrFileCloudClient$recognize$3> bVar) {
        super(bVar);
        this.this$0 = asrFileCloudClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM50recognizebMdYcbs = this.this$0.m50recognizebMdYcbs(null, null, null, null, null, null, this);
        return objM50recognizebMdYcbs == CoroutineSingletons.f10059a ? objM50recognizebMdYcbs : new Result(objM50recognizebMdYcbs);
    }
}
