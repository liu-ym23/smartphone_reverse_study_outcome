package com.stepos.core.ability.speech;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsCloudWsSession$runOnUplinkChain$1$1", f = "TtsCloudWsSession.kt", l = {643, 645}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TtsCloudWsSession$runOnUplinkChain$1$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ zb.l<qb.b<? super lb.n>, Object> $block;
    final /* synthetic */ Job $prev;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsCloudWsSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TtsCloudWsSession$runOnUplinkChain$1$1(Job job, TtsCloudWsSession ttsCloudWsSession, zb.l<? super qb.b<? super lb.n>, ? extends Object> lVar, qb.b<? super TtsCloudWsSession$runOnUplinkChain$1$1> bVar) {
        super(2, bVar);
        this.$prev = job;
        this.this$0 = ttsCloudWsSession;
        this.$block = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        TtsCloudWsSession$runOnUplinkChain$1$1 ttsCloudWsSession$runOnUplinkChain$1$1 = new TtsCloudWsSession$runOnUplinkChain$1$1(this.$prev, this.this$0, this.$block, bVar);
        ttsCloudWsSession$runOnUplinkChain$1$1.L$0 = obj;
        return ttsCloudWsSession$runOnUplinkChain$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if (r6.invoke(r5) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:33:0x005e, B:35:0x0066, B:32:0x005a, B:13:0x0020, B:23:0x003d, B:25:0x0049, B:18:0x002e, B:20:0x0032, B:6:0x000e, B:30:0x0057, B:27:0x004c), top: B:45:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097 A[DONT_GENERATE] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "[TTS-Stream] uplink chain task failed (skip, keep chain alive): x-trace-id="
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r5.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L27
            if (r2 == r4) goto L1c
            if (r2 != r3) goto L14
            kotlin.c.b(r6)     // Catch: java.lang.Throwable -> L12
            goto L57
        L12:
            r6 = move-exception
            goto L5a
        L14:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1c:
            java.lang.Object r2 = r5.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.c.b(r6)     // Catch: java.lang.Throwable -> L24
            goto L3d
        L24:
            r6 = move-exception
            goto L9f
        L27:
            kotlin.c.b(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlinx.coroutines.Job r2 = r5.$prev     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L3d
            r5.L$0 = r6     // Catch: java.lang.Throwable -> L24
            r5.label = r4     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r2.join(r5)     // Catch: java.lang.Throwable -> L24
            if (r6 != r1) goto L3d
            goto L56
        L3d:
            com.stepos.core.ability.speech.TtsCloudWsSession r6 = r5.this$0     // Catch: java.lang.Throwable -> L24
            java.util.concurrent.atomic.AtomicBoolean r6 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getClosed$p(r6)     // Catch: java.lang.Throwable -> L24
            boolean r6 = r6.get()     // Catch: java.lang.Throwable -> L24
            if (r6 != 0) goto L8b
            zb.l<qb.b<? super lb.n>, java.lang.Object> r6 = r5.$block     // Catch: java.lang.Throwable -> L24
            r2 = 0
            r5.L$0 = r2     // Catch: java.lang.Throwable -> L12
            r5.label = r3     // Catch: java.lang.Throwable -> L12
            java.lang.Object r6 = r6.invoke(r5)     // Catch: java.lang.Throwable -> L12
            if (r6 != r1) goto L57
        L56:
            return r1
        L57:
            lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L12
            goto L5e
        L5a:
            kotlin.Result$Failure r6 = kotlin.c.a(r6)     // Catch: java.lang.Throwable -> L24
        L5e:
            com.stepos.core.ability.speech.TtsCloudWsSession r1 = r5.this$0     // Catch: java.lang.Throwable -> L24
            java.lang.Throwable r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L8b
            com.stepos.core.common.log.LogModule r2 = com.stepos.core.common.log.LogModule.ABILITY     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getTAG$p(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getCurrentTraceId$p(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L24
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L24
            r4.append(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r0 = ", "
            r4.append(r0)     // Catch: java.lang.Throwable -> L24
            r4.append(r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L24
            com.stepos.core.common.log.AIEngineLogger.w(r2, r3, r6)     // Catch: java.lang.Throwable -> L24
        L8b:
            com.stepos.core.ability.speech.TtsCloudWsSession r6 = r5.this$0
            java.util.concurrent.atomic.AtomicInteger r6 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getUplinkShapeInFlight$p(r6)
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L9c
            com.stepos.core.ability.speech.TtsCloudWsSession r5 = r5.this$0
            com.stepos.core.ability.speech.TtsCloudWsSession.access$onUplinkFeedComplete(r5)
        L9c:
            lb.n r5 = lb.n.f10413a
            return r5
        L9f:
            com.stepos.core.ability.speech.TtsCloudWsSession r0 = r5.this$0
            java.util.concurrent.atomic.AtomicInteger r0 = com.stepos.core.ability.speech.TtsCloudWsSession.access$getUplinkShapeInFlight$p(r0)
            int r0 = r0.decrementAndGet()
            if (r0 != 0) goto Lb0
            com.stepos.core.ability.speech.TtsCloudWsSession r5 = r5.this$0
            com.stepos.core.ability.speech.TtsCloudWsSession.access$onUplinkFeedComplete(r5)
        Lb0:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsCloudWsSession$runOnUplinkChain$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((TtsCloudWsSession$runOnUplinkChain$1$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
