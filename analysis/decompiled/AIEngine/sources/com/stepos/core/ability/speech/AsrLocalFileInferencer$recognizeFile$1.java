package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrLocalFileInferencer", f = "AsrLocalFileInferencer.kt", l = {37}, m = "recognizeFile-yxL6bBk")
/* loaded from: classes.dex */
public final class AsrLocalFileInferencer$recognizeFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsrLocalFileInferencer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrLocalFileInferencer$recognizeFile$1(AsrLocalFileInferencer asrLocalFileInferencer, qb.b<? super AsrLocalFileInferencer$recognizeFile$1> bVar) {
        super(bVar);
        this.this$0 = asrLocalFileInferencer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM54recognizeFileyxL6bBk = this.this$0.m54recognizeFileyxL6bBk(null, null, null, null, this);
        return objM54recognizeFileyxL6bBk == CoroutineSingletons.f10059a ? objM54recognizeFileyxL6bBk : new Result(objM54recognizeFileyxL6bBk);
    }
}
