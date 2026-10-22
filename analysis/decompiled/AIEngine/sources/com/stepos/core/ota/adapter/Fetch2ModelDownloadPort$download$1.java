package com.stepos.core.ota.adapter;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.Fetch2ModelDownloadPort", f = "Fetch2ModelDownloadPort.kt", l = {83, 488}, m = "download-0E7RQCE")
/* loaded from: classes.dex */
public final class Fetch2ModelDownloadPort$download$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Fetch2ModelDownloadPort this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fetch2ModelDownloadPort$download$1(Fetch2ModelDownloadPort fetch2ModelDownloadPort, b<? super Fetch2ModelDownloadPort$download$1> bVar) {
        super(bVar);
        this.this$0 = fetch2ModelDownloadPort;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo110download0E7RQCE = this.this$0.mo110download0E7RQCE(null, null, this);
        return objMo110download0E7RQCE == CoroutineSingletons.f10059a ? objMo110download0E7RQCE : new Result(objMo110download0E7RQCE);
    }
}
