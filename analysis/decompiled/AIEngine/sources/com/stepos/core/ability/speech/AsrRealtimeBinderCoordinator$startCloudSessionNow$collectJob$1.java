package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1", f = "AsrRealtimeBinderCoordinator.kt", l = {1032}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ AsrRealtimeBinderCoordinator.CloudWsHolder $holder;
    final /* synthetic */ String $inferId;
    int label;
    final /* synthetic */ AsrRealtimeBinderCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, AsrRealtimeBinderCoordinator.CloudWsHolder cloudWsHolder, qb.b<? super AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1> bVar) {
        super(2, bVar);
        this.this$0 = asrRealtimeBinderCoordinator;
        this.$inferId = str;
        this.$holder = cloudWsHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1(this.this$0, this.$inferId, this.$holder, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator = this.this$0;
            String str = this.$inferId;
            AsrRealtimeBinderCoordinator.CloudWsHolder cloudWsHolder = this.$holder;
            this.label = 1;
            if (asrRealtimeBinderCoordinator.collectCloudWsEvents(str, cloudWsHolder, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
