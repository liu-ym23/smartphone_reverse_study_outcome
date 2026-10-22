package com.stepos.core.ota.adapter;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ManifestSourceAdapter", f = "ManifestSourceAdapter.kt", l = {30}, m = "fetch-gIAlu-s")
/* loaded from: classes.dex */
public final class ManifestSourceAdapter$fetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManifestSourceAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManifestSourceAdapter$fetch$1(ManifestSourceAdapter manifestSourceAdapter, b<? super ManifestSourceAdapter$fetch$1> bVar) {
        super(bVar);
        this.this$0 = manifestSourceAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo113fetchgIAlus = this.this$0.mo113fetchgIAlus(null, this);
        return objMo113fetchgIAlus == CoroutineSingletons.f10059a ? objMo113fetchgIAlus : new Result(objMo113fetchgIAlus);
    }
}
