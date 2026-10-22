package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.AtRestSealer", f = "AtRestSealer.kt", l = {61}, m = "sealDir-gIAlu-s")
/* loaded from: classes.dex */
public final class AtRestSealer$sealDir$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AtRestSealer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtRestSealer$sealDir$1(AtRestSealer atRestSealer, b<? super AtRestSealer$sealDir$1> bVar) {
        super(bVar);
        this.this$0 = atRestSealer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM118sealDirgIAlus = this.this$0.m118sealDirgIAlus(null, this);
        return objM118sealDirgIAlus == CoroutineSingletons.f10059a ? objM118sealDirgIAlus : new Result(objM118sealDirgIAlus);
    }
}
