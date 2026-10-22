package com.stepos.core.ota.confirmui;

import com.stepos.core.deepbinder.IOtaDeepBinderService;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ota.confirmui.ModelConfirmFlow$startResume$job$1", f = "ModelConfirmFlow.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelConfirmFlow$startResume$job$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ boolean $cellularPreapproved;
    final /* synthetic */ IOtaDeepBinderService $service;
    int label;
    final /* synthetic */ ModelConfirmFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow$startResume$job$1(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, boolean z, qb.b<? super ModelConfirmFlow$startResume$job$1> bVar) {
        super(2, bVar);
        this.this$0 = modelConfirmFlow;
        this.$service = iOtaDeepBinderService;
        this.$cellularPreapproved = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new ModelConfirmFlow$startResume$job$1(this.this$0, this.$service, this.$cellularPreapproved, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        this.this$0.runResumeGate(this.$service, this.$cellularPreapproved);
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((ModelConfirmFlow$startResume$job$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
