package com.stepos.core.ability.speech;

import android.os.Bundle;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.data.ContentParams;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsCloudConfig {
    public static final long DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS = 10000;
    public static final long DEFAULT_AUDIO_FIRST_FRAME_BUDGET_MS = 120000;
    public static final int DEFAULT_DOWNSTREAM_BUFFER_CAPACITY = 64;
    public static final long DEFAULT_FINISH_DRAIN_MIN_MS = 3000;
    public static final String DEFAULT_FINISH_TEXT_DONE_STRATEGY = "after_idle_drain";
    public static final int DEFAULT_MAX_CHARS_PER_SEGMENT = 1000;
    public static final String DEFAULT_MODE = "default";
    public static final long DEFAULT_SSE_PREBUFFER_TARGET_MS = 200;
    public static final long DEFAULT_SSE_PREBUFFER_TTFT_BUDGET_MS = 1000;
    public static final String DEFAULT_STREAM_BACKPRESSURE_MODE = "SUSPEND";
    public static final long DEFAULT_STREAM_MAX_BINDER_QUEUE_MS = 500;
    public static final long DEFAULT_TAIL_SILENCE_PAD_MS = 1800;
    public static final long DEFAULT_UPLINK_COMMIT_HOLD_TIMEOUT_MS = 2000;
    public static final int DEFAULT_UPLINK_COMMIT_MAX_HOLD_CHARS = 60;
    public static final int DEFAULT_UPLINK_COMMIT_MIN_CHARS = 30;
    public static final long DEFAULT_UPLINK_EST_MS_PER_CHAR = 200;
    public static final long DEFAULT_UPLINK_MAX_BACKLOG_MS = 8000;
    public static final int DEFAULT_UPLINK_MAX_CHARS_PER_DELTA = 60;
    public static final long DEFAULT_UPLINK_PACING_MAX_WAIT_MS = 8000;
    public static final long DEFAULT_UPLINK_PAREN_TIMEOUT_MS = 1500;
    public static final long DEFAULT_UPLINK_SENTENCE_PACING_TIMEOUT_MS = 8000;
    public static final long DEFAULT_UPLINK_SENTENCE_PACING_TIMEOUT_MS_CONVERSATION = 2000;
    public static final boolean DEFAULT_UPLINK_SENTENCE_PIPELINE = true;
    public static final long DEFAULT_UPLINK_WIRE_MIN_INTERVAL_MS = 300;
    public static final String FINISH_TEXT_DONE_AFTER_IDLE_DRAIN = "after_idle_drain";
    public static final String FINISH_TEXT_DONE_IMMEDIATE = "immediate";
    public static final String FINISH_TEXT_DONE_IMMEDIATE_LEGACY = "after_flush_ack";
    public static final String KEY_INSTRUCTION = "tts.instruction";
    public static final String KEY_MODE = "tts.mode";
    public static final String KEY_SAMPLE_RATE = "tts.sample_rate";
    public static final String KEY_SPEED = "tts.speed";
    public static final String KEY_TEXT_NORMALIZATION = "tts.text_normalization";
    public static final String KEY_VOICE = "tts.voice";
    public static final String KEY_VOLUME = "tts.volume";
    public static final String MODE_CONVERSATION = "conversation";
    public static final String SAMPLE_RATE_ALLOWED_HINT = "8000/16000/22050/24000/48000";
    private final p6.c params;
    private final p6.c policy;
    private final String sceneType;
    private final long timeoutMs;
    private final String wsEndpoint;
    public static final Companion Companion = new Companion(null);
    private static final Set<Integer> ALLOWED_SAMPLE_RATES = mb.l.s0(new Integer[]{8000, 16000, 22050, 24000, 48000});

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final Set<Integer> getALLOWED_SAMPLE_RATES() {
            return TtsCloudConfig.ALLOWED_SAMPLE_RATES;
        }

        public final p6.c requestOverrides(ContentParams contentParams) throws JSONException {
            Integer numSanitizeSampleRate;
            if (contentParams == null) {
                return p6.c.f11438b;
            }
            JSONObject jSONObject = new JSONObject();
            String string = contentParams.getString("tts.voice", "");
            if (gc.q.t0(string)) {
                string = null;
            }
            if (string != null) {
                jSONObject.put("voice", string);
            }
            if (contentParams.containsKey("tts.speed")) {
                jSONObject.put("speed", contentParams.getFloat("tts.speed", 1.0f));
            }
            if (contentParams.containsKey("tts.volume")) {
                jSONObject.put("volume", contentParams.getFloat("tts.volume", 1.0f));
            }
            String string2 = contentParams.getString("tts.instruction", "");
            if (gc.q.t0(string2)) {
                string2 = null;
            }
            if (string2 != null) {
                jSONObject.put("instruction", string2);
            }
            String string3 = contentParams.getString(TtsCloudConfig.KEY_MODE, "");
            if (gc.q.t0(string3)) {
                string3 = null;
            }
            if (string3 != null) {
                jSONObject.put("mode", string3);
            }
            String string4 = contentParams.getString(TtsCloudConfig.KEY_TEXT_NORMALIZATION, "");
            String str = gc.q.t0(string4) ? null : string4;
            if (str != null) {
                jSONObject.put("text_normalization", str);
            }
            if (contentParams.containsKey("tts.sample_rate") && (numSanitizeSampleRate = sanitizeSampleRate(contentParams.getInt("tts.sample_rate", 0))) != null) {
                jSONObject.put("sample_rate", numSanitizeSampleRate.intValue());
            }
            return new p6.c(jSONObject);
        }

        public final void requireValidSampleRate(ContentParams contentParams) {
            if (contentParams == null || !contentParams.containsKey("tts.sample_rate")) {
                return;
            }
            int i10 = contentParams.getInt("tts.sample_rate", 0);
            if (!getALLOWED_SAMPLE_RATES().contains(Integer.valueOf(i10))) {
                throw new OrchestrationRejectedException(AIEngineError.INVALID_ARGUMENT, sampleRateRejectMessage(i10));
            }
        }

        public final String sampleRateRejectMessage(int i10) {
            return ai.onnxruntime.providers.a.a(i10, "采样率仅支持 8000/16000/22050/24000/48000 Hz，当前为 ");
        }

        public final Integer sanitizeSampleRate(int i10) {
            Integer numValueOf = Integer.valueOf(i10);
            if (TtsCloudConfig.Companion.getALLOWED_SAMPLE_RATES().contains(Integer.valueOf(numValueOf.intValue()))) {
                return numValueOf;
            }
            return null;
        }

        private Companion() {
        }

        public final void requireValidSampleRate(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("tts.sample_rate")) {
                return;
            }
            int i10 = bundle.getInt("tts.sample_rate", 0);
            if (!getALLOWED_SAMPLE_RATES().contains(Integer.valueOf(i10))) {
                throw new OrchestrationRejectedException(AIEngineError.INVALID_ARGUMENT, sampleRateRejectMessage(i10));
            }
        }
    }

    public TtsCloudConfig() {
        this(0L, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TtsCloudConfig copy$default(TtsCloudConfig ttsCloudConfig, long j10, String str, p6.c cVar, p6.c cVar2, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = ttsCloudConfig.timeoutMs;
        }
        long j11 = j10;
        if ((i10 & 2) != 0) {
            str = ttsCloudConfig.wsEndpoint;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            cVar = ttsCloudConfig.params;
        }
        p6.c cVar3 = cVar;
        if ((i10 & 8) != 0) {
            cVar2 = ttsCloudConfig.policy;
        }
        p6.c cVar4 = cVar2;
        if ((i10 & 16) != 0) {
            str2 = ttsCloudConfig.sceneType;
        }
        return ttsCloudConfig.copy(j11, str3, cVar3, cVar4, str2);
    }

    public final long audioDoneIdleWatchdogMs() {
        return dc.h.b0(this.policy.f11439a.optLong("audio_done_idle_watchdog_ms", DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS), 2000L, HysteresisStrategy.DEFAULT_DWELL_MS);
    }

    public final long audioFirstFrameBudgetMs() {
        return dc.h.b0(this.policy.f11439a.optLong("audio_first_frame_budget_ms", DEFAULT_AUDIO_FIRST_FRAME_BUDGET_MS), 2000L, 180000L);
    }

    public final long component1() {
        return this.timeoutMs;
    }

    public final String component2() {
        return this.wsEndpoint;
    }

    public final p6.c component3() {
        return this.params;
    }

    public final p6.c component4() {
        return this.policy;
    }

    public final String component5() {
        return this.sceneType;
    }

    public final TtsCloudConfig copy(long j10, String wsEndpoint, p6.c params, p6.c policy, String str) {
        kotlin.jvm.internal.g.f(wsEndpoint, "wsEndpoint");
        kotlin.jvm.internal.g.f(params, "params");
        kotlin.jvm.internal.g.f(policy, "policy");
        return new TtsCloudConfig(j10, wsEndpoint, params, policy, str);
    }

    public final int downstreamBufferCapacity() {
        int iOptInt = this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).f11439a.optInt("bufferSize", 64);
        if (iOptInt < 1) {
            return 1;
        }
        return iOptInt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TtsCloudConfig)) {
            return false;
        }
        TtsCloudConfig ttsCloudConfig = (TtsCloudConfig) obj;
        return this.timeoutMs == ttsCloudConfig.timeoutMs && kotlin.jvm.internal.g.b(this.wsEndpoint, ttsCloudConfig.wsEndpoint) && kotlin.jvm.internal.g.b(this.params, ttsCloudConfig.params) && kotlin.jvm.internal.g.b(this.policy, ttsCloudConfig.policy) && kotlin.jvm.internal.g.b(this.sceneType, ttsCloudConfig.sceneType);
    }

    public final long finishDrainMinMs() {
        return dc.h.b0(this.policy.f11439a.optLong("finish_drain_min_ms", 3000L), 0L, HysteresisStrategy.DEFAULT_DWELL_MS);
    }

    public final boolean finishTextDoneImmediately() {
        String strFinishTextDoneStrategy = finishTextDoneStrategy();
        return kotlin.jvm.internal.g.b(strFinishTextDoneStrategy, FINISH_TEXT_DONE_IMMEDIATE) || kotlin.jvm.internal.g.b(strFinishTextDoneStrategy, FINISH_TEXT_DONE_IMMEDIATE_LEGACY) || kotlin.jvm.internal.g.b(mode(), MODE_CONVERSATION);
    }

    public final String finishTextDoneStrategy() {
        String strB = this.policy.b("finish_text_done_strategy", "after_idle_drain");
        return gc.q.t0(strB) ? "after_idle_drain" : strB;
    }

    public final p6.c getParams() {
        return this.params;
    }

    public final p6.c getPolicy() {
        return this.policy;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final String getWsEndpoint() {
        return this.wsEndpoint;
    }

    public int hashCode() {
        int iHashCode = (this.policy.hashCode() + ((this.params.hashCode() + v1.d.a(Long.hashCode(this.timeoutMs) * 31, 31, this.wsEndpoint)) * 31)) * 31;
        String str = this.sceneType;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String instruction() {
        return this.params.b("instruction", "");
    }

    public final boolean isConversationMode() {
        return kotlin.jvm.internal.g.b(mode(), MODE_CONVERSATION);
    }

    public final boolean markdownFilter() {
        return this.params.f11439a.optBoolean("markdown_filter", false);
    }

    public final int maxCharsPerSegment() {
        return dc.h.a0(this.params.f11439a.optInt("max_chars_per_segment", 1000), 100, 10000);
    }

    public final String mode() {
        String strB = this.params.b("mode", "default");
        return gc.q.t0(strB) ? "default" : strB;
    }

    public final String model() {
        return this.params.b(ModelManifest.TYPE_MODEL, "");
    }

    public final String responseFormat() {
        return this.params.b("response_format", "");
    }

    public final int sampleRate() {
        return this.params.f11439a.optInt("sample_rate", 0);
    }

    public final double speed() {
        return this.params.f11439a.optDouble("speed", 0.0d);
    }

    public final long ssePrebufferTargetMs() {
        return dc.h.b0(this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).f11439a.optLong("prebufferTargetMs", 200L), 0L, 1000L);
    }

    public final long ssePrebufferTtftBudgetMs() {
        return dc.h.b0(this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).f11439a.optLong("prebufferTtftBudgetMs", 1000L), 200L, FileStorageUploader.LOG_HEARTBEAT_MS);
    }

    public final String streamBackpressureMode() {
        return this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).b("mode", DEFAULT_STREAM_BACKPRESSURE_MODE);
    }

    public final int streamBatchChunks() {
        int iOptInt = this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).f11439a.optInt("batchChunks", 1);
        if (iOptInt < 1) {
            return 1;
        }
        return iOptInt;
    }

    public final String streamFormat() {
        return this.params.b("stream_format", "");
    }

    public final long streamMaxBinderQueueMs() {
        long jOptLong = this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).f11439a.optLong("maxBinderQueueMs", 500L);
        if (jOptLong <= 0) {
            return 0L;
        }
        return dc.h.b0(jOptLong, 50L, FileStorageUploader.LOG_HEARTBEAT_MS);
    }

    public final long tailSilencePadMs() {
        return dc.h.b0(this.policy.a(AsrCloudConfig.SCENE_MODE_STREAM).f11439a.optLong("tailSilencePadMs", DEFAULT_TAIL_SILENCE_PAD_MS), 0L, FileStorageUploader.LOG_HEARTBEAT_MS);
    }

    public final String textNormalization() {
        return this.params.b("text_normalization", "");
    }

    public String toString() {
        long j10 = this.timeoutMs;
        String str = this.wsEndpoint;
        p6.c cVar = this.params;
        p6.c cVar2 = this.policy;
        String str2 = this.sceneType;
        StringBuilder sbO = a0.a.o("TtsCloudConfig(timeoutMs=", j10, ", wsEndpoint=", str);
        sbO.append(", params=");
        sbO.append(cVar);
        sbO.append(", policy=");
        sbO.append(cVar2);
        return ai.onnxruntime.a.p(sbO, ", sceneType=", str2, ")");
    }

    public final boolean uplinkAdaptivePacing() {
        return this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optBoolean("adaptive_pacing", true);
    }

    public final long uplinkCommitHoldTimeoutMs() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("commit_hold_timeout_ms", 2000L), 200L, DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS);
    }

    public final int uplinkCommitMaxHoldChars() {
        int iOptInt = this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optInt("commit_max_hold_chars", 60);
        int iUplinkCommitMinChars = uplinkCommitMinChars();
        if (iUplinkCommitMinChars < 1) {
            iUplinkCommitMinChars = 1;
        }
        return dc.h.a0(iOptInt, iUplinkCommitMinChars, 1000);
    }

    public final int uplinkCommitMinChars() {
        return dc.h.a0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optInt("commit_min_chars", 30), 0, 200);
    }

    public final long uplinkEstMsPerChar() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("est_ms_per_char", 200L), 40L, 1000L);
    }

    public final String uplinkFinishTerminator() {
        return this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).b("finish_terminator", "。");
    }

    public final long uplinkMaxBacklogMs() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("max_backlog_ms", 8000L), 1000L, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
    }

    public final int uplinkMaxCharsPerDelta() {
        return dc.h.a0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optInt("max_chars_per_delta", 60), 4, VadSessionManager.FRAME_BYTES);
    }

    public final long uplinkPacingMaxWaitMs() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("pacing_max_wait_ms", 8000L), 500L, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
    }

    public final boolean uplinkParenAware() {
        return this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optBoolean("paren_aware", true);
    }

    public final long uplinkParenTimeoutMs() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("paren_timeout_ms", DEFAULT_UPLINK_PAREN_TIMEOUT_MS), 200L, DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS);
    }

    public final boolean uplinkPreferSentenceSplit() {
        return this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optBoolean("prefer_sentence_split", true);
    }

    public final long uplinkSentencePacingTimeoutMs() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("sentence_pacing_timeout_ms", isConversationMode() ? 2000L : 8000L), 1000L, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
    }

    public final boolean uplinkSentencePipeline() {
        return this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optBoolean("sentence_pipeline", true);
    }

    public final boolean uplinkTerminateOnFinish() {
        return this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optBoolean("terminate_on_finish", true);
    }

    public final long uplinkWireMinIntervalMs() {
        return dc.h.b0(this.policy.a(ModelCallFlywheelBizMapper.MSG_TYPE_UPLINK).f11439a.optLong("wire_min_interval_ms", 300L), 0L, FileStorageUploader.LOG_HEARTBEAT_MS);
    }

    public final String voice() {
        return this.params.b("voice", "");
    }

    public final double volume() {
        return this.params.f11439a.optDouble("volume", 0.0d);
    }

    public TtsCloudConfig(long j10, String wsEndpoint, p6.c params, p6.c policy, String str) {
        kotlin.jvm.internal.g.f(wsEndpoint, "wsEndpoint");
        kotlin.jvm.internal.g.f(params, "params");
        kotlin.jvm.internal.g.f(policy, "policy");
        this.timeoutMs = j10;
        this.wsEndpoint = wsEndpoint;
        this.params = params;
        this.policy = policy;
        this.sceneType = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TtsCloudConfig(long j10, String str, p6.c cVar, p6.c cVar2, String str2, int i10, kotlin.jvm.internal.e eVar) {
        long j11 = (i10 & 1) != 0 ? HysteresisStrategy.DEFAULT_DWELL_MS : j10;
        String str3 = (i10 & 2) != 0 ? "" : str;
        if ((i10 & 4) != 0) {
            p6.c cVar3 = p6.c.f11438b;
            cVar = p6.c.f11438b;
        }
        p6.c cVar4 = cVar;
        if ((i10 & 8) != 0) {
            p6.c cVar5 = p6.c.f11438b;
            cVar2 = p6.c.f11438b;
        }
        this(j11, str3, cVar4, cVar2, (i10 & 16) != 0 ? null : str2);
    }
}
