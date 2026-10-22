package com.stepos.core.ota.crypto;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl", f = "ModelCryptoImpl.kt", l = {ErrorCodes.NOT_SET_VERSION_CODE_ERROR}, m = "decryptToFile-BWLJW6A")
/* loaded from: classes.dex */
public final class ModelCryptoImpl$decryptToFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModelCryptoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCryptoImpl$decryptToFile$1(ModelCryptoImpl modelCryptoImpl, b<? super ModelCryptoImpl$decryptToFile$1> bVar) {
        super(bVar);
        this.this$0 = modelCryptoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo123decryptToFileBWLJW6A = this.this$0.mo123decryptToFileBWLJW6A(null, null, null, this);
        return objMo123decryptToFileBWLJW6A == CoroutineSingletons.f10059a ? objMo123decryptToFileBWLJW6A : new Result(objMo123decryptToFileBWLJW6A);
    }
}
