package com.stepos.core.ability.speech;

import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.ContentParams;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1", f = "AsrRealtimeBinderCoordinator.kt", l = {1143}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ IInferenceCallback $callback;
    final /* synthetic */ String $callerPkg;
    final /* synthetic */ int $callerUid;
    final /* synthetic */ String $inferId;
    final /* synthetic */ ContentParams $params;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ AsrRealtimeBinderCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1(long j10, AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, IInferenceCallback iInferenceCallback, int i10, String str2, ContentParams contentParams, qb.b<? super AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1> bVar) {
        super(2, bVar);
        this.$timeoutMs = j10;
        this.this$0 = asrRealtimeBinderCoordinator;
        this.$inferId = str;
        this.$callback = iInferenceCallback;
        this.$callerUid = i10;
        this.$callerPkg = str2;
        this.$params = contentParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1(this.$timeoutMs, this.this$0, this.$inferId, this.$callback, this.$callerUid, this.$callerPkg, this.$params, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            long j10 = this.$timeoutMs;
            this.label = 1;
            if (DelayKt.delay(j10, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        if (this.this$0.streamOpenWatchdogs.remove(this.$inferId) == null) {
            return lb.n.f10413a;
        }
        this.this$0.onStreamOpenTimeout(this.$inferId, this.$callback, this.$callerUid, this.$callerPkg, this.$params, this.$timeoutMs);
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
