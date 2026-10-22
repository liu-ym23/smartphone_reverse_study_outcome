package com.stepos.core.model.task;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.task.AITaskSupervisor", f = "AITaskSupervisor.kt", l = {839, 839}, m = "submit-yxL6bBk")
/* loaded from: classes.dex */
public final class AITaskSupervisor$submit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AITaskSupervisor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AITaskSupervisor$submit$1(AITaskSupervisor aITaskSupervisor, qb.b<? super AITaskSupervisor$submit$1> bVar) {
        super(bVar);
        this.this$0 = aITaskSupervisor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM108submityxL6bBk = this.this$0.m108submityxL6bBk(null, null, null, null, this);
        return objM108submityxL6bBk == CoroutineSingletons.f10059a ? objM108submityxL6bBk : new Result(objM108submityxL6bBk);
    }
}
