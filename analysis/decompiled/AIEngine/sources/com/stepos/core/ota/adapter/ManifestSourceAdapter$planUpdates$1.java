package com.stepos.core.ota.adapter;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ManifestSourceAdapter", f = "ManifestSourceAdapter.kt", l = {38}, m = "planUpdates-BWLJW6A")
/* loaded from: classes.dex */
public final class ManifestSourceAdapter$planUpdates$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManifestSourceAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManifestSourceAdapter$planUpdates$1(ManifestSourceAdapter manifestSourceAdapter, b<? super ManifestSourceAdapter$planUpdates$1> bVar) {
        super(bVar);
        this.this$0 = manifestSourceAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo114planUpdatesBWLJW6A = this.this$0.mo114planUpdatesBWLJW6A(null, null, false, this);
        return objMo114planUpdatesBWLJW6A == CoroutineSingletons.f10059a ? objMo114planUpdatesBWLJW6A : new Result(objMo114planUpdatesBWLJW6A);
    }
}
