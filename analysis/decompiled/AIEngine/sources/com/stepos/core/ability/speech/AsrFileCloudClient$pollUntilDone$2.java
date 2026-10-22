package com.stepos.core.ability.speech;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$2", f = "AsrFileCloudClient.kt", l = {208, 216}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrFileCloudClient$pollUntilDone$2 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Result<? extends AsrFileResult>>, Object> {
    final /* synthetic */ String $inferId;
    final /* synthetic */ long $maxPollTimeMs;
    final /* synthetic */ zb.a<lb.n> $onFirstResponse;
    final /* synthetic */ String $taskId;
    int I$0;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AsrFileCloudClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFileCloudClient$pollUntilDone$2(AsrFileCloudClient asrFileCloudClient, String str, String str2, long j10, zb.a<lb.n> aVar, qb.b<? super AsrFileCloudClient$pollUntilDone$2> bVar) {
        super(2, bVar);
        this.this$0 = asrFileCloudClient;
        this.$inferId = str;
        this.$taskId = str2;
        this.$maxPollTimeMs = j10;
        this.$onFirstResponse = aVar;
    }

    private static final void invokeSuspend$emitFirstResponseOnce(zb.a<lb.n> aVar, AtomicBoolean atomicBoolean) {
        if (aVar != null && atomicBoolean.compareAndSet(false, true)) {
            aVar.invoke();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        AsrFileCloudClient$pollUntilDone$2 asrFileCloudClient$pollUntilDone$2 = new AsrFileCloudClient$pollUntilDone$2(this.this$0, this.$inferId, this.$taskId, this.$maxPollTimeMs, this.$onFirstResponse, bVar);
        asrFileCloudClient$pollUntilDone$2.L$0 = obj;
        return asrFileCloudClient$pollUntilDone$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, qb.b<? super Result<? extends AsrFileResult>> bVar) {
        return invoke2(coroutineScope, (qb.b<? super Result<AsrFileResult>>) bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0468, code lost:
    
        if (r2.equals("PENDING") != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x046f, code lost:
    
        if (r2.equals("RUNNING") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0477, code lost:
    
        if (r2.equals("RUNNING") == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0479, code lost:
    
        invokeSuspend$emitFirstResponseOnce(r38.$onFirstResponse, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x047e, code lost:
    
        r0 = com.stepos.core.common.log.LogModule.ABILITY;
        r1 = r38.this$0.TAG;
        r3 = r38.this$0.tag(r38.$inferId);
        r4 = r38.$taskId;
        r6 = new java.lang.StringBuilder();
        r6.append(r3);
        r6.append(" stage=ASR_POLL task=");
        r6.append(r4);
        r6.append(" status=");
        r6.append(r2);
        r3 = r23;
        com.stepos.core.common.log.AIEngineLogger.d(r0, r1, a0.a.d(r14, " elapsed=", r3, r6));
        r0 = r12;
        r12 = java.lang.Math.min(r27 * r38.this$0.transport.getResilience().getPollBackoffFactor(), r38.this$0.transport.getResilience().getPollBackoffCapMs());
        r2 = r9;
        r14 = r18;
        r8 = r20;
        r6 = r21;
        r1 = r25;
        r4 = 0;
        r9 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0193 -> B:23:0x019e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r39) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, qb.b<? super Result<AsrFileResult>> bVar) {
        return ((AsrFileCloudClient$pollUntilDone$2) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
