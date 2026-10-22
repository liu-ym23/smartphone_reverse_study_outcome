package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFileCloudClient", f = "AsrFileCloudClient.kt", l = {119}, m = "submitTask-BWLJW6A")
/* loaded from: classes.dex */
public final class AsrFileCloudClient$submitTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrFileCloudClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFileCloudClient$submitTask$1(AsrFileCloudClient asrFileCloudClient, qb.b<? super AsrFileCloudClient$submitTask$1> bVar) {
        super(bVar);
        this.this$0 = asrFileCloudClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM49submitTaskBWLJW6A = this.this$0.m49submitTaskBWLJW6A(null, null, null, this);
        return objM49submitTaskBWLJW6A == CoroutineSingletons.f10059a ? objM49submitTaskBWLJW6A : new Result(objM49submitTaskBWLJW6A);
    }
}
