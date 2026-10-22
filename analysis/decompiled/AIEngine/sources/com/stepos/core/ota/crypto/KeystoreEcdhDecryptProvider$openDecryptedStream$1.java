package com.stepos.core.ota.crypto;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.KeystoreEcdhDecryptProvider", f = "KeystoreEcdhDecryptProvider.kt", l = {ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR}, m = "openDecryptedStream-gIAlu-s")
/* loaded from: classes.dex */
public final class KeystoreEcdhDecryptProvider$openDecryptedStream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KeystoreEcdhDecryptProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeystoreEcdhDecryptProvider$openDecryptedStream$1(KeystoreEcdhDecryptProvider keystoreEcdhDecryptProvider, b<? super KeystoreEcdhDecryptProvider$openDecryptedStream$1> bVar) {
        super(bVar);
        this.this$0 = keystoreEcdhDecryptProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo132openDecryptedStreamgIAlus = this.this$0.mo132openDecryptedStreamgIAlus(null, this);
        return objMo132openDecryptedStreamgIAlus == CoroutineSingletons.f10059a ? objMo132openDecryptedStreamgIAlus : new Result(objMo132openDecryptedStreamgIAlus);
    }
}
