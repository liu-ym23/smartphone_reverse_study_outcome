package com.stepos.core.common.net;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.common.net.OkHttpTransport", f = "OkHttpTransport.kt", l = {22}, m = "execute-gIAlu-s")
/* loaded from: classes.dex */
public final class OkHttpTransport$execute$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkHttpTransport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpTransport$execute$1(OkHttpTransport okHttpTransport, b<? super OkHttpTransport$execute$1> bVar) {
        super(bVar);
        this.this$0 = okHttpTransport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo102executegIAlus = this.this$0.mo102executegIAlus(null, this);
        return objMo102executegIAlus == CoroutineSingletons.f10059a ? objMo102executegIAlus : new Result(objMo102executegIAlus);
    }
}
