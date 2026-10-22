package com.stepos.core.ability.speech;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$emitEvent$1$1", f = "TtsCloudWsSession.kt", l = {1232, 1233}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TtsCloudWsSession$emitEvent$1$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ i7.d $event;
    final /* synthetic */ Job $prev;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsCloudWsSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsCloudWsSession$emitEvent$1$1(Job job, TtsCloudWsSession ttsCloudWsSession, i7.d dVar, qb.b<? super TtsCloudWsSession$emitEvent$1$1> bVar) {
        super(2, bVar);
        this.$prev = job;
        this.this$0 = ttsCloudWsSession;
        this.$event = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        TtsCloudWsSession$emitEvent$1$1 ttsCloudWsSession$emitEvent$1$1 = new TtsCloudWsSession$emitEvent$1$1(this.$prev, this.this$0, this.$event, bVar);
        ttsCloudWsSession$emitEvent$1$1.L$0 = obj;
        return ttsCloudWsSession$emitEvent$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r5.send(r1, r4) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.c.b(r5)     // Catch: java.lang.Throwable -> L10
            goto L4c
        L10:
            r5 = move-exception
            goto L4f
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            java.lang.Object r1 = r4.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.c.b(r5)
            goto L38
        L22:
            kotlin.c.b(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlinx.coroutines.Job r1 = r4.$prev
            if (r1 == 0) goto L38
            r4.L$0 = r5
            r4.label = r3
            java.lang.Object r5 = r1.join(r4)
            if (r5 != r0) goto L38
            goto L4b
        L38:
            com.stepos.core.ability.speech.TtsCloudWsSession r5 = r4.this$0
            i7.d r1 = r4.$event
            kotlinx.coroutines.channels.Channel r5 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getEventChannel$p(r5)     // Catch: java.lang.Throwable -> L10
            r3 = 0
            r4.L$0 = r3     // Catch: java.lang.Throwable -> L10
            r4.label = r2     // Catch: java.lang.Throwable -> L10
            java.lang.Object r5 = r5.send(r1, r4)     // Catch: java.lang.Throwable -> L10
            if (r5 != r0) goto L4c
        L4b:
            return r0
        L4c:
            lb.n r5 = lb.n.f10413a     // Catch: java.lang.Throwable -> L10
            goto L53
        L4f:
            kotlin.Result$Failure r5 = kotlin.c.a(r5)
        L53:
            com.stepos.core.ability.speech.TtsCloudWsSession r4 = r4.this$0
            java.lang.Throwable r5 = kotlin.Result.b(r5)
            if (r5 == 0) goto L74
            java.util.concurrent.atomic.AtomicBoolean r0 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getClosed$p(r4)
            boolean r0 = r0.get()
            if (r0 != 0) goto L74
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r4 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getTAG$p(r4)
            java.lang.String r5 = r5.getMessage()
            java.lang.String r1 = "[TTS-Stream] eventChannel.send failed: "
            ai.onnxruntime.a.w(r1, r5, r0, r4)
        L74:
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession$emitEvent$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((TtsCloudWsSession$emitEvent$1$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
