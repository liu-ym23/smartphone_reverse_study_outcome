package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl", f = "ModelCryptoImpl.kt", l = {181}, m = "sealToFile-yxL6bBk")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$sealToFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$sealToFile$1(ModelCryptoImpl modelCryptoImpl, b<? super ModelCryptoImpl$sealToFile$1> bVar) {
        super(bVar);
        this.this$0 = modelCryptoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM134sealToFileyxL6bBk = this.this$0.m134sealToFileyxL6bBk(null, null, null, 0, this);
        return objM134sealToFileyxL6bBk == CoroutineSingletons.f10059a ? objM134sealToFileyxL6bBk : new Result(objM134sealToFileyxL6bBk);
    }
}
