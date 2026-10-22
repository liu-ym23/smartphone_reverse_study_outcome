package com.stepos.core.ota.adapter;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ZipArchiveExtractor", f = "InstallAdapters.kt", l = {66}, m = "extract-0E7RQCE")
/* loaded from: classes.dex */
public final class ZipArchiveExtractor$extract$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZipArchiveExtractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipArchiveExtractor$extract$1(ZipArchiveExtractor zipArchiveExtractor, b<? super ZipArchiveExtractor$extract$1> bVar) {
        super(bVar);
        this.this$0 = zipArchiveExtractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo116extract0E7RQCE = this.this$0.mo116extract0E7RQCE(null, null, this);
        return objMo116extract0E7RQCE == CoroutineSingletons.f10059a ? objMo116extract0E7RQCE : new Result(objMo116extract0E7RQCE);
    }
}
