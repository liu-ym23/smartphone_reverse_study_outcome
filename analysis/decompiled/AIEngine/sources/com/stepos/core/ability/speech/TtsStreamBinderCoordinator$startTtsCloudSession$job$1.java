package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.TtsStreamBinderCoordinator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsStreamBinderCoordinator$startTtsCloudSession$job$1", f = "TtsStreamBinderCoordinator.kt", l = {426}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TtsStreamBinderCoordinator$startTtsCloudSession$job$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ TtsStreamBinderCoordinator.TtsCloudHolder $holder;
    final /* synthetic */ String $inferId;
    int label;
    final /* synthetic */ TtsStreamBinderCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsStreamBinderCoordinator$startTtsCloudSession$job$1(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str, TtsStreamBinderCoordinator.TtsCloudHolder ttsCloudHolder, qb.b<? super TtsStreamBinderCoordinator$startTtsCloudSession$job$1> bVar) {
        super(2, bVar);
        this.this$0 = ttsStreamBinderCoordinator;
        this.$inferId = str;
        this.$holder = ttsCloudHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new TtsStreamBinderCoordinator$startTtsCloudSession$job$1(this.this$0, this.$inferId, this.$holder, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            TtsStreamBinderCoordinator ttsStreamBinderCoordinator = this.this$0;
            String str = this.$inferId;
            TtsStreamBinderCoordinator.TtsCloudHolder ttsCloudHolder = this.$holder;
            this.label = 1;
            if (ttsStreamBinderCoordinator.collectTtsCloudWsEvents(str, ttsCloudHolder, this) == coroutineSingletons) {
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
        return ((TtsStreamBinderCoordinator$startTtsCloudSession$job$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
