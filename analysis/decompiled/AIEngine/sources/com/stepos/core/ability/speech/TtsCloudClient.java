package com.stepos.core.ability.speech;

import android.os.SystemClock;
import android.util.Base64;
import com.stepos.core.ability.speech.TtsCloudClient;
import com.stepos.core.common.cloud.AccountTokenCache;
import com.stepos.core.common.cloud.AuthHeaderResult;
import com.stepos.core.common.cloud.BffModelProxy;
import com.stepos.core.common.cloud.CloudApiException;
import com.stepos.core.common.cloud.CloudCorrelationSource;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.cloud.CloudInferenceClient;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudSseEventLog;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manifest.ModelManifest;
import com.tonyodev.fetch2core.server.FileResponse;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsCloudClient {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int DEFAULT_SAMPLE_RATE = 24000;

    @Deprecated
    public static final String LOG_PREFIX = "[tts-sse]";

    @Deprecated
    public static final long SSE_DOWNLINK_GAP_WARN_MS = 200;

    @Deprecated
    public static final String TYPE_AUDIO_DELTA = "speech.audio.delta";

    @Deprecated
    public static final String TYPE_AUDIO_DONE = "speech.audio.done";

    @Deprecated
    public static final String TYPE_AUDIO_ERROR = "speech.audio.error";
    private final String TAG;
    private final TtsCloudConfig config;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsCloudClient$synthesizeStream$1", f = "TtsCloudClient.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsCloudClient$synthesizeStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<ProducerScope<? super byte[]>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ AtomicReference<CloudSessionCorrelationState> $correlationOut;
        final /* synthetic */ String $instruction;
        final /* synthetic */ zb.l<CloudSessionCorrelationState, lb.n> $onCorrelationEstablished;
        final /* synthetic */ float $speed;
        final /* synthetic */ String $text;
        final /* synthetic */ String $traceId;
        final /* synthetic */ String $voice;
        final /* synthetic */ float $volume;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.core.ability.speech.TtsCloudClient$synthesizeStream$1$1", f = "TtsCloudClient.kt", l = {64}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.speech.TtsCloudClient$synthesizeStream$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00551 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
            final /* synthetic */ AtomicReference<CloudSessionCorrelationState> $correlationOut;
            final /* synthetic */ String $instruction;
            final /* synthetic */ zb.l<CloudSessionCorrelationState, lb.n> $onCorrelationEstablished;
            final /* synthetic */ ProducerScope<byte[]> $producer;
            final /* synthetic */ float $speed;
            final /* synthetic */ String $text;
            final /* synthetic */ String $traceId;
            final /* synthetic */ String $voice;
            final /* synthetic */ float $volume;
            int label;
            final /* synthetic */ TtsCloudClient this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00551(TtsCloudClient ttsCloudClient, String str, String str2, String str3, float f8, float f9, String str4, AtomicReference<CloudSessionCorrelationState> atomicReference, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, ProducerScope<? super byte[]> producerScope, qb.b<? super C00551> bVar) {
                super(2, bVar);
                this.this$0 = ttsCloudClient;
                this.$traceId = str;
                this.$text = str2;
                this.$voice = str3;
                this.$speed = f8;
                this.$volume = f9;
                this.$instruction = str4;
                this.$correlationOut = atomicReference;
                this.$onCorrelationEstablished = lVar;
                this.$producer = producerScope;
            }

            private static final String invokeSuspend$diag(int i10, Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, Ref$IntRef ref$IntRef, Ref$IntRef ref$IntRef2, long j10) {
                long j11 = i10 > 0 ? ref$LongRef.f10075a / i10 : 0L;
                long j12 = ref$LongRef2.f10075a;
                long j13 = j12 > 0 ? j10 - j12 : 0L;
                double d8 = j13 > 0 ? j11 / j13 : -1.0d;
                int i11 = ref$IntRef.f10074a;
                String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d8)}, 1));
                int i12 = ref$IntRef2.f10074a;
                long j14 = ref$LongRef.f10075a;
                StringBuilder sb2 = new StringBuilder("chunks=");
                sb2.append(i11);
                sb2.append(" recvAudio=");
                sb2.append(j11);
                a0.a.s(j13, "ms/wall=", "ms rtf=", sb2);
                com.stepos.core.ota.d.o(i12, str, " stalls=", " bytes=", sb2);
                sb2.append(j14);
                return sb2.toString();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final lb.n invokeSuspend$lambda$1(AtomicBoolean atomicBoolean, String str, AtomicReference atomicReference, zb.l lVar, Map map) {
                if (!atomicBoolean.compareAndSet(false, true)) {
                    return lb.n.f10413a;
                }
                String strExtractResponseXTraceId = CloudInferenceClient.INSTANCE.extractResponseXTraceId((Map<String, String>) map);
                if (strExtractResponseXTraceId != null && !gc.q.t0(strExtractResponseXTraceId)) {
                    CloudCorrelationSource cloudCorrelationSource = CloudCorrelationSource.RESPONSE_HEADER_X_TRACE_ID;
                    String str2 = (String) map.get(BffModelProxy.HEADER_TRACE_ID);
                    CloudSessionCorrelationState cloudSessionCorrelationState = new CloudSessionCorrelationState(strExtractResponseXTraceId, cloudCorrelationSource, str == null ? "" : str, str2 == null ? "" : str2, 0, null, 0L, 0L, 0L, 0L, 1008, null);
                    if (atomicReference != null) {
                        atomicReference.set(cloudSessionCorrelationState);
                    }
                    if (lVar != null) {
                        lVar.invoke(cloudSessionCorrelationState);
                    }
                }
                return lb.n.f10413a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final lb.n invokeSuspend$lambda$2(TtsCloudClient ttsCloudClient, AtomicBoolean atomicBoolean, Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, long j10, String str, Ref$LongRef ref$LongRef3, Ref$IntRef ref$IntRef2, ProducerScope producerScope, int i10, String str2) throws TtsCloudException {
                byte[] audioDelta = ttsCloudClient.parseAudioDelta(str2, atomicBoolean);
                if (audioDelta != null) {
                    if (!(audioDelta.length == 0)) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        ref$IntRef.f10074a++;
                        ref$LongRef.f10075a += audioDelta.length;
                        if (ref$LongRef2.f10075a == 0) {
                            ref$LongRef2.f10075a = jElapsedRealtime;
                            LogModule logModule = LogModule.ABILITY;
                            String str3 = ttsCloudClient.TAG;
                            StringBuilder sbR = ai.onnxruntime.a.r(jElapsedRealtime - j10, "[tts-sse] first pcm chunk: ttfb=", "ms bytes=", audioDelta.length);
                            sbR.append(" traceId=");
                            sbR.append(str);
                            AIEngineLogger.i(logModule, str3, sbR.toString());
                        } else {
                            long j11 = jElapsedRealtime - ref$LongRef3.f10075a;
                            if (j11 > 200) {
                                ref$IntRef2.f10074a++;
                                LogModule logModule2 = LogModule.ABILITY;
                                String str4 = ttsCloudClient.TAG;
                                StringBuilder sbO = a0.a.o("[tts-sse][NET-DOWN] downlink stall gap=", j11, "ms (weak downlink?): ", invokeSuspend$diag(i10, ref$LongRef, ref$LongRef2, ref$IntRef, ref$IntRef2, jElapsedRealtime));
                                sbO.append(" traceId=");
                                sbO.append(str);
                                AIEngineLogger.w(logModule2, str4, sbO.toString());
                            }
                        }
                        ref$LongRef3.f10075a = jElapsedRealtime;
                        if (ChannelResult.m158isClosedimpl(ChannelsKt.trySendBlocking(producerScope, audioDelta))) {
                            throw new CancellationException("downstream closed");
                        }
                    }
                }
                return lb.n.f10413a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                return new C00551(this.this$0, this.$traceId, this.$text, this.$voice, this.$speed, this.$volume, this.$instruction, this.$correlationOut, this.$onCorrelationEstablished, this.$producer, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objGatewayHeadersResult$default;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    BffModelProxy bffModelProxy = BffModelProxy.INSTANCE;
                    String sceneType = this.this$0.config.getSceneType();
                    this.label = 1;
                    objGatewayHeadersResult$default = BffModelProxy.gatewayHeadersResult$default(bffModelProxy, "tts", sceneType, 0L, this, 4, null);
                    if (objGatewayHeadersResult$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                    objGatewayHeadersResult$default = obj;
                }
                AuthHeaderResult authHeaderResult = (AuthHeaderResult) objGatewayHeadersResult$default;
                if (!(authHeaderResult instanceof AuthHeaderResult.Ready)) {
                    if (kotlin.jvm.internal.g.b(authHeaderResult, AuthHeaderResult.NotLoggedIn.INSTANCE)) {
                        throw new TtsCloudException(AIEngineError.CLOUD_AUTH_FAILED, "not logged in (no user token)");
                    }
                    if (kotlin.jvm.internal.g.b(authHeaderResult, AuthHeaderResult.TransientFailure.INSTANCE)) {
                        throw new TtsCloudException(AIEngineError.CLOUD_TOKEN_TEMP_UNAVAILABLE, "user token temporarily unavailable");
                    }
                    throw new NoWhenBranchMatchedException();
                }
                Map<String, String> headers = ((AuthHeaderResult.Ready) authHeaderResult).getHeaders();
                String str = this.$traceId;
                if (str != null && !gc.q.t0(str)) {
                    headers = kotlin.collections.b.j0(headers, mb.v.b0(new Pair(CloudInferenceClient.HEADER_TRACE_ID, this.$traceId)));
                }
                Map<String, String> map = headers;
                if (map.isEmpty()) {
                    throw new TtsCloudException(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "BFF gateway credentials not ready (appId/appSecret missing)");
                }
                String strSpeechUrl = BffModelProxy.INSTANCE.speechUrl();
                JSONObject jSONObjectBuildBody = this.this$0.buildBody(this.$text, this.$voice, this.$speed, this.$volume, this.$instruction);
                LogModule logModule = LogModule.ABILITY;
                String str2 = this.this$0.TAG;
                String strSanitizeBody = this.this$0.sanitizeBody(jSONObjectBuildBody);
                String strStreamFormat = this.this$0.config.streamFormat();
                boolean z = !gc.q.t0(this.$instruction);
                StringBuilder sbS = ai.onnxruntime.a.s("[tts-sse] synthesizeStream[DIAG] req=", strSanitizeBody, " streamFmt=", strStreamFormat, " hasInstruction=");
                sbS.append(z);
                AIEngineLogger.i(logModule, str2, sbS.toString());
                String string = jSONObjectBuildBody.toString();
                kotlin.jvm.internal.g.e(string, "toString(...)");
                Integer num = new Integer(this.this$0.config.sampleRate());
                if (num.intValue() <= 0) {
                    num = null;
                }
                final int iIntValue = ((num != null ? num.intValue() : 24000) * 2) / 1000;
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                final Ref$LongRef ref$LongRef = new Ref$LongRef();
                final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
                final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                String str3 = this.$traceId;
                if (str3 == null) {
                    str3 = "";
                }
                final String str4 = str3;
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                CloudInferenceClient cloudInferenceClient = CloudInferenceClient.INSTANCE;
                long timeoutMs = this.this$0.config.getTimeoutMs();
                final String str5 = this.$traceId;
                final AtomicReference<CloudSessionCorrelationState> atomicReference = this.$correlationOut;
                final zb.l<CloudSessionCorrelationState, lb.n> lVar = this.$onCorrelationEstablished;
                zb.l<? super Map<String, String>, lb.n> lVar2 = new zb.l() { // from class: com.stepos.core.ability.speech.x
                    @Override // zb.l
                    public final Object invoke(Object obj2) {
                        return TtsCloudClient.AnonymousClass1.C00551.invokeSuspend$lambda$1(atomicBoolean, str5, atomicReference, lVar, (Map) obj2);
                    }
                };
                final TtsCloudClient ttsCloudClient = this.this$0;
                final ProducerScope<byte[]> producerScope = this.$producer;
                Object objM99postSseeH_QyT8 = cloudInferenceClient.m99postSseeH_QyT8(strSpeechUrl, string, timeoutMs, "", map, TtsCloudClient.LOG_PREFIX, lVar2, new zb.l() { // from class: com.stepos.core.ability.speech.y
                    @Override // zb.l
                    public final Object invoke(Object obj2) {
                        return TtsCloudClient.AnonymousClass1.C00551.invokeSuspend$lambda$2(ttsCloudClient, atomicBoolean2, ref$IntRef, ref$LongRef3, ref$LongRef, jElapsedRealtime, str4, ref$LongRef2, ref$IntRef2, producerScope, iIntValue, (String) obj2);
                    }
                });
                AIEngineLogger.i(logModule, this.this$0.TAG, ai.onnxruntime.a.l("[tts-sse] session summary: ", invokeSuspend$diag(iIntValue, ref$LongRef3, ref$LongRef, ref$IntRef, ref$IntRef2, SystemClock.elapsedRealtime()), " traceId=", str4));
                Throwable thB = Result.b(objM99postSseeH_QyT8);
                if (thB == null) {
                    return lb.n.f10413a;
                }
                throw this.this$0.mapError(thB);
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
                return ((C00551) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String str, String str2, String str3, float f8, float f9, String str4, AtomicReference<CloudSessionCorrelationState> atomicReference, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$traceId = str;
            this.$text = str2;
            this.$voice = str3;
            this.$speed = f8;
            this.$volume = f9;
            this.$instruction = str4;
            this.$correlationOut = atomicReference;
            this.$onCorrelationEstablished = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = TtsCloudClient.this.new AnonymousClass1(this.$traceId, this.$text, this.$voice, this.$speed, this.$volume, this.$instruction, this.$correlationOut, this.$onCorrelationEstablished, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                CoroutineDispatcher io = Dispatchers.getIO();
                C00551 c00551 = new C00551(TtsCloudClient.this, this.$traceId, this.$text, this.$voice, this.$speed, this.$volume, this.$instruction, this.$correlationOut, this.$onCorrelationEstablished, producerScope, null);
                this.label = 1;
                if (BuildersKt.withContext(io, c00551, this) == coroutineSingletons) {
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
        public final Object invoke(ProducerScope<? super byte[]> producerScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public TtsCloudClient(TtsCloudConfig config) {
        kotlin.jvm.internal.g.f(config, "config");
        this.config = config;
        this.TAG = "TtsCloudClient";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject buildBody(String str, String str2, float f8, float f9, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ModelManifest.TYPE_MODEL, this.config.model());
        jSONObject.put("input", str);
        jSONObject.put("voice", str2);
        jSONObject.put("response_format", this.config.responseFormat());
        jSONObject.put("sample_rate", this.config.sampleRate());
        jSONObject.put("stream_format", this.config.streamFormat());
        jSONObject.put("speed", f8);
        jSONObject.put("volume", f9);
        jSONObject.put("markdown_filter", this.config.markdownFilter());
        if (!gc.q.t0(this.config.textNormalization())) {
            jSONObject.put("text_normalization", this.config.textNormalization());
        }
        if (!gc.q.t0(str3)) {
            jSONObject.put("instruction", gc.r.R0(200, str3));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable mapError(Throwable th) {
        if ((th instanceof TtsCloudException) || (th instanceof CancellationException)) {
            return th;
        }
        if (!(th instanceof CloudApiException)) {
            String message = th.getMessage();
            if (message == null) {
                message = "cloud tts failed";
            }
            return new TtsCloudException(AIEngineError.CLOUD_SERVER_ERROR, message);
        }
        CloudHttpErrorMapper cloudHttpErrorMapper = CloudHttpErrorMapper.INSTANCE;
        CloudApiException cloudApiException = (CloudApiException) th;
        if (cloudHttpErrorMapper.shouldInvalidateUserToken(Integer.valueOf(cloudApiException.getHttpCode()))) {
            AccountTokenCache.INSTANCE.invalidate("tts_sse_http_" + cloudApiException.getHttpCode());
        }
        return new TtsCloudException(cloudHttpErrorMapper.toErrorCode(Integer.valueOf(cloudApiException.getHttpCode())), a0.a.g("cloud tts http ", cloudApiException.getHttpCode(), ": ", gc.r.R0(200, cloudApiException.getResponseBody())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] parseAudioDelta(String str, AtomicBoolean atomicBoolean) throws TtsCloudException {
        Object objA;
        try {
            objA = new JSONObject(str);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        JSONObject jSONObject = (JSONObject) objA;
        if (jSONObject == null) {
            if (atomicBoolean.compareAndSet(false, true)) {
                CloudSseEventLog.INSTANCE.logUnknown(this.TAG, LOG_PREFIX, "<non-json>", str.length());
            }
            return null;
        }
        String strOptString = jSONObject.optString(FileResponse.FIELD_TYPE);
        if (kotlin.jvm.internal.g.b(strOptString, TYPE_AUDIO_ERROR)) {
            String strOptString2 = jSONObject.optString("message", "cloud tts stream error");
            CloudSseEventLog cloudSseEventLog = CloudSseEventLog.INSTANCE;
            String str2 = this.TAG;
            kotlin.jvm.internal.g.c(strOptString2);
            cloudSseEventLog.logError(str2, LOG_PREFIX, strOptString, strOptString2);
            throw new TtsCloudException(AIEngineError.CLOUD_SERVER_ERROR, strOptString2);
        }
        String strOptString3 = jSONObject.optString("audio", "");
        if (!kotlin.jvm.internal.g.b(strOptString, TYPE_AUDIO_DELTA)) {
            if (kotlin.jvm.internal.g.b(strOptString, TYPE_AUDIO_DONE)) {
                CloudSseEventLog.INSTANCE.logEvent(this.TAG, LOG_PREFIX, strOptString, "b64Len=" + strOptString3.length() + " meta=" + jSONObject.optJSONObject("meta"));
            } else if (atomicBoolean.compareAndSet(false, true)) {
                CloudSseEventLog cloudSseEventLog2 = CloudSseEventLog.INSTANCE;
                String str3 = this.TAG;
                kotlin.jvm.internal.g.c(strOptString);
                cloudSseEventLog2.logUnknown(str3, LOG_PREFIX, strOptString, str.length());
            }
        }
        kotlin.jvm.internal.g.c(strOptString3);
        if (gc.q.t0(strOptString3)) {
            return null;
        }
        return Base64.decode(strOptString3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String sanitizeBody(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("input", "");
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        CloudSseEventLog cloudSseEventLog = CloudSseEventLog.INSTANCE;
        kotlin.jvm.internal.g.c(strOptString);
        jSONObject2.put("input", cloudSseEventLog.redactText(strOptString));
        String string = jSONObject2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ Flow synthesizeStream$default(TtsCloudClient ttsCloudClient, String str, String str2, float f8, float f9, String str3, AtomicReference atomicReference, zb.l lVar, String str4, int i10, Object obj) {
        String str5;
        TtsCloudClient ttsCloudClient2;
        String str6;
        String str7;
        float f10;
        float f11;
        String str8 = (i10 & 16) != 0 ? "" : str3;
        AtomicReference atomicReference2 = (i10 & 32) != 0 ? null : atomicReference;
        zb.l lVar2 = (i10 & 64) != 0 ? null : lVar;
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            str5 = null;
            str6 = str;
            str7 = str2;
            f10 = f8;
            f11 = f9;
            ttsCloudClient2 = ttsCloudClient;
        } else {
            str5 = str4;
            ttsCloudClient2 = ttsCloudClient;
            str6 = str;
            str7 = str2;
            f10 = f8;
            f11 = f9;
        }
        return ttsCloudClient2.synthesizeStream(str6, str7, f10, f11, str8, atomicReference2, lVar2, str5);
    }

    public final Flow<byte[]> synthesizeStream(String text, String voice, float f8, float f9, String instruction, AtomicReference<CloudSessionCorrelationState> atomicReference, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, String str) {
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(voice, "voice");
        kotlin.jvm.internal.g.f(instruction, "instruction");
        return FlowKt.channelFlow(new AnonymousClass1(str, text, voice, f8, f9, instruction, atomicReference, lVar, null));
    }
}
