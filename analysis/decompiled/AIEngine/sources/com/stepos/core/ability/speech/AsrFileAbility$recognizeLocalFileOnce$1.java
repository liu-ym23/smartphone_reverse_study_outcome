package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFileAbility", f = "AsrFileAbility.kt", l = {429, 431}, m = "recognizeLocalFileOnce-yxL6bBk")
/* loaded from: classes.dex */
public final class AsrFileAbility$recognizeLocalFileOnce$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrFileAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFileAbility$recognizeLocalFileOnce$1(AsrFileAbility asrFileAbility, qb.b<? super AsrFileAbility$recognizeLocalFileOnce$1> bVar) {
        super(bVar);
        this.this$0 = asrFileAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM41recognizeLocalFileOnceyxL6bBk = this.this$0.m41recognizeLocalFileOnceyxL6bBk(null, null, null, null, this);
        return objM41recognizeLocalFileOnceyxL6bBk == CoroutineSingletons.f10059a ? objM41recognizeLocalFileOnceyxL6bBk : new Result(objM41recognizeLocalFileOnceyxL6bBk);
    }
}
