package com.stepos.core.ability.speech;

import android.os.SystemClock;
import com.stepos.core.ability.speech.AsrSseEvent;
import com.stepos.core.common.cloud.AccountTokenCache;
import com.stepos.core.common.cloud.BffModelProxy;
import com.stepos.core.common.cloud.CloudApiException;
import com.stepos.core.common.cloud.CloudConfigBootstrap;
import com.stepos.core.common.cloud.CloudConnectionWarmer;
import com.stepos.core.common.cloud.CloudCorrelationSource;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudSseEventLog;
import com.stepos.core.common.cloud.CloudTransportConfig;
import com.stepos.core.common.util.TraceIdKeys;
import com.tonyodev.fetch2core.server.FileResponse;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrCloudSseClient {
    private static final Companion Companion = new Companion(null);
    private static final ad.l JSON_MEDIA_TYPE = bd.d.a("application/json; charset=utf-8");

    @Deprecated
    public static final int MAX_ATTEMPTS = 3;

    @Deprecated
    public static final int MAX_SHIFT = 16;

    @Deprecated
    public static final String PATH_AUDIO_DATA = "audio.data";
    private final String TAG = "AsrCloudSseClient";
    private final long timeoutMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final ad.l getJSON_MEDIA_TYPE() {
            return AsrCloudSseClient.JSON_MEDIA_TYPE;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudSseClient", f = "AsrCloudSseClient.kt", l = {189}, m = "runOnce")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudSseClient$runOnce$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrCloudSseClient.this.runOnce(null, null, null, null, null, 0L, 0, null, null, false, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrCloudSseClient$transcribeFlow$1", f = "AsrCloudSseClient.kt", l = {95}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrCloudSseClient$transcribeFlow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03011 extends SuspendLambda implements zb.p<ProducerScope<? super AsrSseEvent>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ long $audioDurationMs;
        final /* synthetic */ byte[] $audioPayload;
        final /* synthetic */ String $inferId;
        final /* synthetic */ zb.l<CloudSessionCorrelationState, lb.n> $onCorrelation;
        final /* synthetic */ boolean $plainTranscriptLog;
        final /* synthetic */ AsrSseRequest $request;
        final /* synthetic */ String $sceneType;
        final /* synthetic */ String $traceId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AsrCloudSseClient this$0;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.core.ability.speech.AsrCloudSseClient$transcribeFlow$1$1", f = "AsrCloudSseClient.kt", l = {TraceIdKeys.MAX_LENGTH, 161}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.speech.AsrCloudSseClient$transcribeFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00521 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
            final /* synthetic */ long $audioDurationMs;
            final /* synthetic */ byte[] $audioPayload;
            final /* synthetic */ String $inferId;
            final /* synthetic */ zb.l<CloudSessionCorrelationState, lb.n> $onCorrelation;
            final /* synthetic */ boolean $plainTranscriptLog;
            final /* synthetic */ ProducerScope<AsrSseEvent> $producer;
            final /* synthetic */ AsrSseRequest $request;
            final /* synthetic */ String $sceneType;
            final /* synthetic */ String $traceId;
            int I$0;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ AsrCloudSseClient this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00521(AsrSseRequest asrSseRequest, AsrCloudSseClient asrCloudSseClient, String str, byte[] bArr, ProducerScope<? super AsrSseEvent> producerScope, String str2, String str3, long j10, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, boolean z, qb.b<? super C00521> bVar) {
                super(2, bVar);
                this.$request = asrSseRequest;
                this.this$0 = asrCloudSseClient;
                this.$inferId = str;
                this.$audioPayload = bArr;
                this.$producer = producerScope;
                this.$traceId = str2;
                this.$sceneType = str3;
                this.$audioDurationMs = j10;
                this.$onCorrelation = lVar;
                this.$plainTranscriptLog = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final lb.n invokeSuspend$lambda$1(Ref$BooleanRef ref$BooleanRef) {
                ref$BooleanRef.f10073a = true;
                return lb.n.f10413a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                return new C00521(this.$request, this.this$0, this.$inferId, this.$audioPayload, this.$producer, this.$traceId, this.$sceneType, this.$audioDurationMs, this.$onCorrelation, this.$plainTranscriptLog, bVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0100  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0106  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0109  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0189 -> B:47:0x018c). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 470
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudSseClient.C03011.C00521.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
                return ((C00521) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C03011(AsrSseRequest asrSseRequest, AsrCloudSseClient asrCloudSseClient, String str, byte[] bArr, String str2, String str3, long j10, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, boolean z, qb.b<? super C03011> bVar) {
            super(2, bVar);
            this.$request = asrSseRequest;
            this.this$0 = asrCloudSseClient;
            this.$inferId = str;
            this.$audioPayload = bArr;
            this.$traceId = str2;
            this.$sceneType = str3;
            this.$audioDurationMs = j10;
            this.$onCorrelation = lVar;
            this.$plainTranscriptLog = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03011 c03011 = new C03011(this.$request, this.this$0, this.$inferId, this.$audioPayload, this.$traceId, this.$sceneType, this.$audioDurationMs, this.$onCorrelation, this.$plainTranscriptLog, bVar);
            c03011.L$0 = obj;
            return c03011;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                CoroutineDispatcher io = Dispatchers.getIO();
                C00521 c00521 = new C00521(this.$request, this.this$0, this.$inferId, this.$audioPayload, producerScope, this.$traceId, this.$sceneType, this.$audioDurationMs, this.$onCorrelation, this.$plainTranscriptLog, null);
                this.label = 1;
                if (BuildersKt.withContext(io, c00521, this) == coroutineSingletons) {
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
        public final Object invoke(ProducerScope<? super AsrSseEvent> producerScope, qb.b<? super lb.n> bVar) {
            return ((C03011) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public AsrCloudSseClient(long j10) {
        this.timeoutMs = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long backoffMs(int i10, int i11) {
        CloudTransportConfig.Resilience resilience = CloudConfigBootstrap.INSTANCE.get().getResilience();
        long reconnectRateLimitedBaseMs = i11 == 270008 ? resilience.getReconnectRateLimitedBaseMs() : resilience.getReconnectBaseMs();
        long reconnectCapMs = resilience.getReconnectCapMs();
        int i12 = i10 - 1;
        if (i12 > 16) {
            i12 = 16;
        }
        long jMin = Math.min(reconnectCapMs, reconnectRateLimitedBaseMs << i12);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (jMin < 1) {
            jMin = 1;
        }
        return threadLocalRandomCurrent.nextLong(jMin);
    }

    private final Throwable mapError(Throwable th) {
        if ((th instanceof AsrSseCloudException) || (th instanceof CancellationException)) {
            return th;
        }
        if (!(th instanceof CloudApiException)) {
            int errorCode = AsrSseErrorMapper.INSTANCE.toErrorCode(th);
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            if (message == null) {
                message = "cloud asr-sse failed";
            }
            return new AsrSseCloudException(errorCode, com.stepos.core.ota.d.i(simpleName, ": ", message));
        }
        CloudApiException cloudApiException = (CloudApiException) th;
        if (CloudHttpErrorMapper.INSTANCE.shouldInvalidateUserToken(Integer.valueOf(cloudApiException.getHttpCode()))) {
            AccountTokenCache.INSTANCE.invalidate("asr_sse_http_" + cloudApiException.getHttpCode());
        }
        return new AsrSseCloudException(AsrSseErrorMapper.INSTANCE.toErrorCode(th), a0.a.g("cloud asr-sse http ", cloudApiException.getHttpCode(), ": ", gc.r.R0(200, cloudApiException.getResponseBody())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runOnce(kotlinx.coroutines.channels.SendChannel<? super com.stepos.core.ability.speech.AsrSseEvent> r25, ad.s r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, long r30, int r32, zb.l<? super com.stepos.core.common.cloud.CloudSessionCorrelationState, lb.n> r33, zb.a<lb.n> r34, boolean r35, qb.b<? super java.lang.Throwable> r36) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrCloudSseClient.runOnce(kotlinx.coroutines.channels.SendChannel, ad.s, java.lang.String, java.lang.String, java.lang.String, long, int, zb.l, zb.a, boolean, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n runOnce$lambda$2(AsrCloudSseClient asrCloudSseClient, Ref$BooleanRef ref$BooleanRef, zb.l lVar, String str, Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef, long j10, String str2, boolean z, Ref$BooleanRef ref$BooleanRef2, SendChannel sendChannel, zb.a aVar, String payload) {
        Object objA;
        JSONObject jSONObject;
        String strH;
        kotlin.jvm.internal.g.f(payload, "payload");
        try {
            objA = new JSONObject(payload);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        JSONObject jSONObject2 = (JSONObject) objA;
        if (jSONObject2 == null) {
            CloudSseEventLog.INSTANCE.logUnknown(asrCloudSseClient.TAG, asrCloudSseClient.tag(str2), "<non-json>", payload.length());
            return lb.n.f10413a;
        }
        if (!ref$BooleanRef.f10073a) {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("meta");
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("session_id", "") : null;
            String str3 = strOptString == null ? "" : strOptString;
            if (!gc.q.t0(str3)) {
                ref$BooleanRef.f10073a = true;
                if (lVar != null) {
                    lVar.invoke(new CloudSessionCorrelationState(str3, CloudCorrelationSource.SSE_META_SESSION_ID, str == null ? "" : str, null, 0, null, 0L, 0L, 0L, 0L, 1016, null));
                }
            }
        }
        String strOptString2 = jSONObject2.optString(FileResponse.FIELD_TYPE);
        if (strOptString2 == null) {
            jSONObject = jSONObject2;
            CloudSseEventLog cloudSseEventLog = CloudSseEventLog.INSTANCE;
            String str4 = asrCloudSseClient.TAG;
            String strTag = asrCloudSseClient.tag(str2);
            kotlin.jvm.internal.g.c(strOptString2);
            cloudSseEventLog.logUnknown(str4, strTag, strOptString2, payload.length());
        } else {
            int iHashCode = strOptString2.hashCode();
            if (iHashCode == -1504384149) {
                jSONObject = jSONObject2;
                if (strOptString2.equals(AsrSseEvent.TYPE_DONE)) {
                    CloudSseEventLog cloudSseEventLog2 = CloudSseEventLog.INSTANCE;
                    String str5 = asrCloudSseClient.TAG;
                    String strTag2 = asrCloudSseClient.tag(str2);
                    AsrTranscriptLog asrTranscriptLog = AsrTranscriptLog.INSTANCE;
                    String strOptString3 = jSONObject.optString("text", "");
                    kotlin.jvm.internal.g.e(strOptString3, "optString(...)");
                    String strTextForLog = asrTranscriptLog.textForLog(strOptString3, z);
                    int i10 = ref$IntRef.f10074a;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("usage");
                    JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("meta");
                    StringBuilder sbF = h0.e.f("text=", strTextForLog, " deltas=", i10, " elapsed=");
                    sbF.append(jElapsedRealtime);
                    sbF.append("ms usage=");
                    sbF.append(jSONObjectOptJSONObject2);
                    sbF.append(" meta=");
                    sbF.append(jSONObjectOptJSONObject3);
                    cloudSseEventLog2.logEvent(str5, strTag2, strOptString2, sbF.toString());
                } else {
                    CloudSseEventLog cloudSseEventLog3 = CloudSseEventLog.INSTANCE;
                    String str42 = asrCloudSseClient.TAG;
                    String strTag3 = asrCloudSseClient.tag(str2);
                    kotlin.jvm.internal.g.c(strOptString2);
                    cloudSseEventLog3.logUnknown(str42, strTag3, strOptString2, payload.length());
                }
            } else if (iHashCode != 96784904) {
                if (iHashCode == 608432367 && strOptString2.equals(AsrSseEvent.TYPE_DELTA)) {
                    ref$IntRef.f10074a++;
                    if (ref$LongRef.f10075a == 0) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        ref$LongRef.f10075a = jElapsedRealtime2;
                        strH = ai.onnxruntime.a.h(jElapsedRealtime2 - j10, " ttfb=", "ms");
                    } else {
                        strH = "";
                    }
                    CloudSseEventLog cloudSseEventLog4 = CloudSseEventLog.INSTANCE;
                    String str6 = asrCloudSseClient.TAG;
                    String strTag4 = asrCloudSseClient.tag(str2);
                    int i11 = ref$IntRef.f10074a;
                    AsrTranscriptLog asrTranscriptLog2 = AsrTranscriptLog.INSTANCE;
                    String strOptString4 = jSONObject2.optString("delta", "");
                    kotlin.jvm.internal.g.e(strOptString4, "optString(...)");
                    String strTextForLog2 = asrTranscriptLog2.textForLog(strOptString4, z);
                    String strOptString5 = jSONObject2.optString("item_id", "");
                    int iOptInt = jSONObject2.optInt("content_index", 0);
                    long jOptLong = jSONObject2.optLong("start_time", 0L);
                    long jOptLong2 = jSONObject2.optLong("end_time", 0L);
                    StringBuilder sbE = h0.e.e("seq=", i11, " delta=", strTextForLog2, " itemId=");
                    com.stepos.core.ota.d.o(iOptInt, strOptString5, " contentIndex=", " start=", sbE);
                    sbE.append(jOptLong);
                    a0.a.s(jOptLong2, "ms end=", "ms", sbE);
                    sbE.append(strH);
                    cloudSseEventLog4.logEvent(str6, strTag4, strOptString2, sbE.toString());
                    jSONObject = jSONObject2;
                }
                jSONObject = jSONObject2;
                CloudSseEventLog cloudSseEventLog32 = CloudSseEventLog.INSTANCE;
                String str422 = asrCloudSseClient.TAG;
                String strTag32 = asrCloudSseClient.tag(str2);
                kotlin.jvm.internal.g.c(strOptString2);
                cloudSseEventLog32.logUnknown(str422, strTag32, strOptString2, payload.length());
            } else if (strOptString2.equals(AsrSseEvent.TYPE_ERROR)) {
                jSONObject = jSONObject2;
                CloudSseEventLog.INSTANCE.logError(asrCloudSseClient.TAG, asrCloudSseClient.tag(str2), strOptString2, jSONObject.optString("message", "") + " meta=" + jSONObject.optJSONObject("meta"));
            } else {
                jSONObject = jSONObject2;
                CloudSseEventLog cloudSseEventLog322 = CloudSseEventLog.INSTANCE;
                String str4222 = asrCloudSseClient.TAG;
                String strTag322 = asrCloudSseClient.tag(str2);
                kotlin.jvm.internal.g.c(strOptString2);
                cloudSseEventLog322.logUnknown(str4222, strTag322, strOptString2, payload.length());
            }
        }
        AsrSseEvent asrSseEventFromEventData = AsrSseEvent.Companion.fromEventData(jSONObject);
        if ((asrSseEventFromEventData instanceof AsrSseEvent.Done) || (asrSseEventFromEventData instanceof AsrSseEvent.Error)) {
            ref$BooleanRef2.f10073a = true;
        }
        if (ChannelResult.m158isClosedimpl(ChannelsKt.trySendBlocking(sendChannel, asrSseEventFromEventData))) {
            throw new CancellationException("downstream closed");
        }
        aVar.invoke();
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String tag(String str) {
        return gc.q.t0(str) ? "[ASR-SSE]" : ai.onnxruntime.a.k("[ASR-SSE] inferId=", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Flow transcribeFlow$default(AsrCloudSseClient asrCloudSseClient, AsrSseRequest asrSseRequest, String str, String str2, String str3, long j10, byte[] bArr, zb.l lVar, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            str3 = "";
        }
        if ((i10 & 16) != 0) {
            j10 = 0;
        }
        if ((i10 & 32) != 0) {
            bArr = null;
        }
        if ((i10 & 64) != 0) {
            lVar = null;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            z = false;
        }
        return asrCloudSseClient.transcribeFlow(asrSseRequest, str, str2, str3, j10, bArr, lVar, z);
    }

    public final Flow<AsrSseEvent> transcribeFlow(AsrSseRequest request, String str, String str2, String inferId, long j10, byte[] bArr, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, boolean z) {
        kotlin.jvm.internal.g.f(request, "request");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        return FlowKt.channelFlow(new C03011(request, this, inferId, bArr, str, str2, j10, lVar, z, null));
    }

    public final void warmConnection(String reason) {
        kotlin.jvm.internal.g.f(reason, "reason");
        CloudConnectionWarmer.INSTANCE.warm(BffModelProxy.INSTANCE.asrSseUrl(), reason);
    }
}
