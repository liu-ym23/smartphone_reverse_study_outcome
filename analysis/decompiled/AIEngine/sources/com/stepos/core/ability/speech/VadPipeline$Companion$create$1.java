package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.VadPipeline;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.VadPipeline$Companion", f = "VadPipeline.kt", l = {259}, m = "create")
/* loaded from: classes.dex */
public final class VadPipeline$Companion$create$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VadPipeline.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VadPipeline$Companion$create$1(VadPipeline.Companion companion, qb.b<? super VadPipeline$Companion$create$1> bVar) {
        super(bVar);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, null, null, this);
    }
}
