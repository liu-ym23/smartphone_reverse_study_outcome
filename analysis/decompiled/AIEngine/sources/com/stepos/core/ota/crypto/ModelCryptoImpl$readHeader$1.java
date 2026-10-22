package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl", f = "ModelCryptoImpl.kt", l = {34}, m = "readHeader-gIAlu-s")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$readHeader$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$readHeader$1(ModelCryptoImpl modelCryptoImpl, b<? super ModelCryptoImpl$readHeader$1> bVar) {
        super(bVar);
        this.this$0 = modelCryptoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo126readHeadergIAlus = this.this$0.mo126readHeadergIAlus(null, this);
        return objMo126readHeadergIAlus == CoroutineSingletons.f10059a ? objMo126readHeadergIAlus : new Result(objMo126readHeadergIAlus);
    }
}
