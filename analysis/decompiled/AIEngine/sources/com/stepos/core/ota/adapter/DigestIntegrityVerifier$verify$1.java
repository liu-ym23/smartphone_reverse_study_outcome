package com.stepos.core.ota.adapter;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.DigestIntegrityVerifier", f = "InstallAdapters.kt", l = {31}, m = "verify-0E7RQCE")
/* loaded from: classes.dex */
public final class DigestIntegrityVerifier$verify$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigestIntegrityVerifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigestIntegrityVerifier$verify$1(DigestIntegrityVerifier digestIntegrityVerifier, b<? super DigestIntegrityVerifier$verify$1> bVar) {
        super(bVar);
        this.this$0 = digestIntegrityVerifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo109verify0E7RQCE = this.this$0.mo109verify0E7RQCE(null, null, this);
        return objMo109verify0E7RQCE == CoroutineSingletons.f10059a ? objMo109verify0E7RQCE : new Result(objMo109verify0E7RQCE);
    }
}
