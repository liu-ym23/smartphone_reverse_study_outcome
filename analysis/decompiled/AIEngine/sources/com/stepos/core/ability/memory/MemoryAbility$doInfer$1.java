package com.stepos.core.ability.memory;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.memory.MemoryAbility", f = "MemoryAbility.kt", l = {ErrorCodes.SERVICE_RECYCLE_ERROR}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class MemoryAbility$doInfer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAbility$doInfer$1(MemoryAbility memoryAbility, b<? super MemoryAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = memoryAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM26doInfergIAlus = this.this$0.m26doInfergIAlus((c.e) null, (b<? super Result<d.q>>) this);
        return objM26doInfergIAlus == CoroutineSingletons.f10059a ? objM26doInfergIAlus : new Result(objM26doInfergIAlus);
    }
}
