package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.ModelDistributionManager", f = "ModelDistributionManager.kt", l = {81, 84, 87, 94}, m = "openDecryptedStream-yxL6bBk")
/* loaded from: classes.dex */
public final class ModelDistributionManager$openDecryptedStream$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModelDistributionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelDistributionManager$openDecryptedStream$1(ModelDistributionManager modelDistributionManager, b<? super ModelDistributionManager$openDecryptedStream$1> bVar) {
        super(bVar);
        this.this$0 = modelDistributionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo137openDecryptedStreamyxL6bBk = this.this$0.mo137openDecryptedStreamyxL6bBk(null, null, 0, null, this);
        return objMo137openDecryptedStreamyxL6bBk == CoroutineSingletons.f10059a ? objMo137openDecryptedStreamyxL6bBk : new Result(objMo137openDecryptedStreamyxL6bBk);
    }
}
