package com.stepos.core.ability.speech;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$armCommitTimeout$1$1", f = "TtsCloudWsSession.kt", l = {612}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TtsCloudWsSession$armCommitTimeout$1$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ TtsCloudWsSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsCloudWsSession$armCommitTimeout$1$1(long j10, TtsCloudWsSession ttsCloudWsSession, qb.b<? super TtsCloudWsSession$armCommitTimeout$1$1> bVar) {
        super(2, bVar);
        this.$timeoutMs = j10;
        this.this$0 = ttsCloudWsSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new TtsCloudWsSession$armCommitTimeout$1$1(this.$timeoutMs, this.this$0, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zHasBuffered;
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
        Object obj2 = this.this$0.commitLock;
        TtsCloudWsSession ttsCloudWsSession = this.this$0;
        synchronized (obj2) {
            zHasBuffered = ttsCloudWsSession.commitGate.hasBuffered();
        }
        if (!zHasBuffered) {
            return lb.n.f10413a;
        }
        AIEngineLogger.w(LogModule.ABILITY, this.this$0.TAG, a0.a.h("[TTS-Stream] commit gate hold timeout (", this.$timeoutMs, "ms), releasing partial text (upstream idle); it is below the commit threshold so the cloud may not synthesize it until text.done, x-trace-id=", this.this$0.currentTraceId));
        this.this$0.flushCommitGateHeld("hold timeout " + this.$timeoutMs + "ms");
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((TtsCloudWsSession$armCommitTimeout$1$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
