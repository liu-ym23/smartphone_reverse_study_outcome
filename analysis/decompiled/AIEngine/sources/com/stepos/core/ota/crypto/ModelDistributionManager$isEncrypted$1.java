package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelDistributionManager", f = "ModelDistributionManager.kt", l = {35}, m = "isEncrypted-gIAlu-s")
/* loaded from: classes.dex */
public final class ModelDistributionManager$isEncrypted$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModelDistributionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelDistributionManager$isEncrypted$1(ModelDistributionManager modelDistributionManager, b<? super ModelDistributionManager$isEncrypted$1> bVar) {
        super(bVar);
        this.this$0 = modelDistributionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo136isEncryptedgIAlus = this.this$0.mo136isEncryptedgIAlus(null, this);
        return objMo136isEncryptedgIAlus == CoroutineSingletons.f10059a ? objMo136isEncryptedgIAlus : new Result(objMo136isEncryptedgIAlus);
    }
}
