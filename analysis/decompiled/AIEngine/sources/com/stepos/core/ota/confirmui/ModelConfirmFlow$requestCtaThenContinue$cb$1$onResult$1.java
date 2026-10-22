package com.stepos.core.ota.confirmui;

import com.stepos.core.deepbinder.IOtaDeepBinderService;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ota.confirmui.ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1", f = "ModelConfirmFlow.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ boolean $granted;
    final /* synthetic */ IOtaDeepBinderService $service;
    int label;
    final /* synthetic */ ModelConfirmFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1(boolean z, ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, qb.b<? super ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1> bVar) {
        super(2, bVar);
        this.$granted = z;
        this.this$0 = modelConfirmFlow;
        this.$service = iOtaDeepBinderService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1(this.$granted, this.this$0, this.$service, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        if (this.$granted) {
            this.this$0.afterCta(this.$service);
        } else {
            this.this$0.fail(4001, "CTA denied");
        }
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
