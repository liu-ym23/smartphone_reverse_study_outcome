package com.stepos.core.ability.sla;

import com.stepos.core.data.base.Content;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.sla.SlaAbility", f = "SlaAbility.kt", l = {Content.Types.TYPE_DOUBLE}, m = "doInfer-gIAlu-s")
/* loaded from: classes.dex */
public final class SlaAbility$doInfer$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SlaAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaAbility$doInfer$1(SlaAbility slaAbility, b<? super SlaAbility$doInfer$1> bVar) {
        super(bVar);
        this.this$0 = slaAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo19doInfergIAlus = this.this$0.mo19doInfergIAlus(null, this);
        return objMo19doInfergIAlus == CoroutineSingletons.f10059a ? objMo19doInfergIAlus : new Result(objMo19doInfergIAlus);
    }
}
