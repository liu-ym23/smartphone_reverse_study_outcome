package com.stepos.core.ability.speech;

import com.stepos.core.common.cloud.AccountTokenCache;
import com.stepos.core.common.cloud.CloudApiException;
import com.stepos.core.common.cloud.CloudConfigBootstrap;
import com.stepos.core.common.cloud.CloudCorrelationSource;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.cloud.CloudInferenceClient;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudTransportConfig;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFileCloudClient {
    private final String TAG;
    private final AsrCloudConfig config;
    private final CloudTransportConfig transport;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RecognizeOutcome {
        private final CloudSessionCorrelationState correlation;
        private final AsrFileResult result;

        public RecognizeOutcome(AsrFileResult result, CloudSessionCorrelationState correlation) {
            kotlin.jvm.internal.g.f(result, "result");
            kotlin.jvm.internal.g.f(correlation, "correlation");
            this.result = result;
            this.correlation = correlation;
        }

        public static /* synthetic */ RecognizeOutcome copy$default(RecognizeOutcome recognizeOutcome, AsrFileResult asrFileResult, CloudSessionCorrelationState cloudSessionCorrelationState, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                asrFileResult = recognizeOutcome.result;
            }
            if ((i10 & 2) != 0) {
                cloudSessionCorrelationState = recognizeOutcome.correlation;
            }
            return recognizeOutcome.copy(asrFileResult, cloudSessionCorrelationState);
        }

        public final AsrFileResult component1() {
            return this.result;
        }

        public final CloudSessionCorrelationState component2() {
            return this.correlation;
        }

        public final RecognizeOutcome copy(AsrFileResult result, CloudSessionCorrelationState correlation) {
            kotlin.jvm.internal.g.f(result, "result");
            kotlin.jvm.internal.g.f(correlation, "correlation");
            return new RecognizeOutcome(result, correlation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RecognizeOutcome)) {
                return false;
            }
            RecognizeOutcome recognizeOutcome = (RecognizeOutcome) obj;
            return kotlin.jvm.internal.g.b(this.result, recognizeOutcome.result) && kotlin.jvm.internal.g.b(this.correlation, recognizeOutcome.correlation);
        }

        public final CloudSessionCorrelationState getCorrelation() {
            return this.correlation;
        }

        public final AsrFileResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.correlation.hashCode() + (this.result.hashCode() * 31);
        }

        public String toString() {
            return "RecognizeOutcome(result=" + this.result + ", correlation=" + this.correlation + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SubmitOutcome {
        private final String gatewayTraceId;
        private final String responseXTraceId;
        private final String taskId;

        public SubmitOutcome(String taskId, String str, String gatewayTraceId) {
            kotlin.jvm.internal.g.f(taskId, "taskId");
            kotlin.jvm.internal.g.f(gatewayTraceId, "gatewayTraceId");
            this.taskId = taskId;
            this.responseXTraceId = str;
            this.gatewayTraceId = gatewayTraceId;
        }

        public static /* synthetic */ SubmitOutcome copy$default(SubmitOutcome submitOutcome, String str, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = submitOutcome.taskId;
            }
            if ((i10 & 2) != 0) {
                str2 = submitOutcome.responseXTraceId;
            }
            if ((i10 & 4) != 0) {
                str3 = submitOutcome.gatewayTraceId;
            }
            return submitOutcome.copy(str, str2, str3);
        }

        public final String component1() {
            return this.taskId;
        }

        public final String component2() {
            return this.responseXTraceId;
        }

        public final String component3() {
            return this.gatewayTraceId;
        }

        public final SubmitOutcome copy(String taskId, String str, String gatewayTraceId) {
            kotlin.jvm.internal.g.f(taskId, "taskId");
            kotlin.jvm.internal.g.f(gatewayTraceId, "gatewayTraceId");
            return new SubmitOutcome(taskId, str, gatewayTraceId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubmitOutcome)) {
                return false;
            }
            SubmitOutcome submitOutcome = (SubmitOutcome) obj;
            return kotlin.jvm.internal.g.b(this.taskId, submitOutcome.taskId) && kotlin.jvm.internal.g.b(this.responseXTraceId, submitOutcome.responseXTraceId) && kotlin.jvm.internal.g.b(this.gatewayTraceId, submitOutcome.gatewayTraceId);
        }

        public final String getGatewayTraceId() {
            return this.gatewayTraceId;
        }

        public final String getResponseXTraceId() {
            return this.responseXTraceId;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public int hashCode() {
            int iHashCode = this.taskId.hashCode() * 31;
            String str = this.responseXTraceId;
            return this.gatewayTraceId.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public String toString() {
            String str = this.taskId;
            String str2 = this.responseXTraceId;
            return ai.onnxruntime.a.o(ai.onnxruntime.a.s("SubmitOutcome(taskId=", str, ", responseXTraceId=", str2, ", gatewayTraceId="), this.gatewayTraceId, ")");
        }
    }

    public AsrFileCloudClient(AsrCloudConfig config) {
        kotlin.jvm.internal.g.f(config, "config");
        this.config = config;
        this.TAG = "AsrFileCloudClient";
        this.transport = CloudConfigBootstrap.INSTANCE.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CloudSessionCorrelationState buildFileCorrelation(SubmitOutcome submitOutcome, String str) {
        String str2 = null;
        if (str != null && !gc.q.t0(str)) {
            str2 = str;
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        String responseXTraceId = submitOutcome.getResponseXTraceId();
        if (responseXTraceId == null || gc.q.t0(responseXTraceId)) {
            return new CloudSessionCorrelationState(submitOutcome.getTaskId(), CloudCorrelationSource.ASYNC_TASK_ID, str3, submitOutcome.getGatewayTraceId(), 0, submitOutcome.getTaskId(), 0L, 0L, 0L, 0L, 976, null);
        }
        return new CloudSessionCorrelationState(responseXTraceId, CloudCorrelationSource.RESPONSE_HEADER_X_TRACE_ID, str3, submitOutcome.getGatewayTraceId(), 0, submitOutcome.getTaskId(), 0L, 0L, 0L, 0L, 976, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateTokenOnAuthFailure(Throwable th, String str) {
        if (th instanceof CloudApiException) {
            CloudApiException cloudApiException = (CloudApiException) th;
            if (CloudHttpErrorMapper.INSTANCE.shouldInvalidateUserToken(Integer.valueOf(cloudApiException.getHttpCode()))) {
                AccountTokenCache.INSTANCE.invalidate(str + "_http_" + cloudApiException.getHttpCode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: pollUntilDone-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m46pollUntilDoneyxL6bBk(java.lang.String r13, long r14, java.lang.String r16, zb.a<lb.n> r17, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileResult>> r18) {
        /*
            r12 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$1 r1 = (com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$1 r1 = new com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$1
            r1.<init>(r12, r0)
        L1a:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r1.label
            r11 = 1
            if (r2 == 0) goto L31
            if (r2 != r11) goto L29
            kotlin.c.b(r0)
            goto L4a
        L29:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            kotlin.c.b(r0)
            com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$2 r2 = new com.stepos.core.ability.speech.AsrFileCloudClient$pollUntilDone$2
            r9 = 0
            r3 = r12
            r5 = r13
            r6 = r14
            r4 = r16
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r8, r9)
            r1.label = r11
            java.lang.Object r0 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r1)
            if (r0 != r10) goto L4a
            return r10
        L4a:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.f9987a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileCloudClient.m46pollUntilDoneyxL6bBk(java.lang.String, long, java.lang.String, zb.a, qb.b):java.lang.Object");
    }

    /* renamed from: pollUntilDone-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m47pollUntilDoneyxL6bBk$default(AsrFileCloudClient asrFileCloudClient, String str, long j10, String str2, zb.a aVar, qb.b bVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            aVar = null;
        }
        return asrFileCloudClient.m46pollUntilDoneyxL6bBk(str, j10, str2, aVar, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: recognize-bMdYcbs$default, reason: not valid java name */
    public static /* synthetic */ Object m48recognizebMdYcbs$default(AsrFileCloudClient asrFileCloudClient, AsrFileRequest asrFileRequest, Long l10, String str, String str2, zb.l lVar, zb.a aVar, qb.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = "";
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            lVar = null;
        }
        if ((i10 & 32) != 0) {
            aVar = null;
        }
        return asrFileCloudClient.m50recognizebMdYcbs(asrFileRequest, l10, str, str2, lVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: submitTask-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m49submitTaskBWLJW6A(com.stepos.core.ability.speech.AsrFileRequest r26, java.lang.String r27, java.lang.String r28, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileCloudClient.SubmitOutcome>> r29) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileCloudClient.m49submitTaskBWLJW6A(com.stepos.core.ability.speech.AsrFileRequest, java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    public static final lb.n submitTask_BWLJW6A$lambda$2(Ref$ObjectRef ref$ObjectRef, Map headers) {
        kotlin.jvm.internal.g.f(headers, "headers");
        ref$ObjectRef.f10076a = CloudInferenceClient.INSTANCE.extractResponseXTraceId((Map<String, String>) headers);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String tag(String str) {
        return gc.q.t0(str) ? "[ASR-FILE]" : ai.onnxruntime.a.k("[ASR-FILE] inferId=", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: recognize-bMdYcbs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m50recognizebMdYcbs(com.stepos.core.ability.speech.AsrFileRequest r14, java.lang.Long r15, java.lang.String r16, java.lang.String r17, zb.l<? super com.stepos.core.common.cloud.CloudSessionCorrelationState, lb.n> r18, zb.a<lb.n> r19, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileCloudClient.RecognizeOutcome>> r20) {
        /*
            r13 = this;
            r0 = r20
            boolean r1 = r0 instanceof com.stepos.core.ability.speech.AsrFileCloudClient$recognize$3
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.core.ability.speech.AsrFileCloudClient$recognize$3 r1 = (com.stepos.core.ability.speech.AsrFileCloudClient$recognize$3) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ability.speech.AsrFileCloudClient$recognize$3 r1 = new com.stepos.core.ability.speech.AsrFileCloudClient$recognize$3
            r1.<init>(r13, r0)
        L1a:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r1.label
            r12 = 1
            if (r2 == 0) goto L31
            if (r2 != r12) goto L29
            kotlin.c.b(r0)
            goto L52
        L29:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            kotlin.c.b(r0)
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ability.speech.AsrFileCloudClient$recognize$4 r2 = new com.stepos.core.ability.speech.AsrFileCloudClient$recognize$4
            r10 = 0
            r3 = r13
            r4 = r14
            r8 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r1.label = r12
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r1)
            if (r0 != r11) goto L52
            return r11
        L52:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.f9987a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileCloudClient.m50recognizebMdYcbs(com.stepos.core.ability.speech.AsrFileRequest, java.lang.Long, java.lang.String, java.lang.String, zb.l, zb.a, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: recognize-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m51recognizegIAlus(java.lang.String r12, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileResult>> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.stepos.core.ability.speech.AsrFileCloudClient$recognize$1
            if (r0 == 0) goto L14
            r0 = r13
            com.stepos.core.ability.speech.AsrFileCloudClient$recognize$1 r0 = (com.stepos.core.ability.speech.AsrFileCloudClient$recognize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            com.stepos.core.ability.speech.AsrFileCloudClient$recognize$1 r0 = new com.stepos.core.ability.speech.AsrFileCloudClient$recognize$1
            r0.<init>(r11, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r8.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.c.b(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r11 = r13.f9987a
            goto L57
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            kotlin.c.b(r13)
            com.stepos.core.ability.speech.AsrFileRequest$Companion r13 = com.stepos.core.ability.speech.AsrFileRequest.Companion
            com.stepos.core.ability.speech.AsrCloudConfig r1 = r11.config
            p6.c r1 = r1.getFile()
            com.stepos.core.ability.speech.AsrFileRequest r12 = r13.fromParams(r12, r1)
            r8.label = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 62
            r10 = 0
            r1 = r11
            r2 = r12
            java.lang.Object r11 = m48recognizebMdYcbs$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r11 != r0) goto L57
            return r0
        L57:
            boolean r12 = r11 instanceof kotlin.Result.Failure
            if (r12 != 0) goto L61
            com.stepos.core.ability.speech.AsrFileCloudClient$RecognizeOutcome r11 = (com.stepos.core.ability.speech.AsrFileCloudClient.RecognizeOutcome) r11
            com.stepos.core.ability.speech.AsrFileResult r11 = r11.getResult()
        L61:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileCloudClient.m51recognizegIAlus(java.lang.String, qb.b):java.lang.Object");
    }
}
