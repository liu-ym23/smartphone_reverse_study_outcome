package com.stepos.core.ability.speech;

import com.stepos.core.common.util.AsrParamKeys;
import com.stepos.core.data.ContentParams;
import com.stepos.core.model.manifest.ModelManifest;
import com.tonyodev.fetch2core.server.FileResponse;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrCloudConfig {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_SILENCE_MS = 5000;
    public static final int MIN_SILENCE_MS = 200;
    public static final String SCENE_MODE_FILE = "file";
    public static final String SCENE_MODE_STREAM = "stream";
    private final ContentParams clientParams;
    private final long maxPollTimeMs;
    private final p6.c params;
    private final long pollIntervalMs;
    private final String sceneType;
    private final long timeoutMs;
    private final String wsEndpoint;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ResolvedTurnDetection {
        private final int silenceMs;
        private final double threshold;
        private final String type;

        public ResolvedTurnDetection(String type, int i10, double d8) {
            kotlin.jvm.internal.g.f(type, "type");
            this.type = type;
            this.silenceMs = i10;
            this.threshold = d8;
        }

        public static /* synthetic */ ResolvedTurnDetection copy$default(ResolvedTurnDetection resolvedTurnDetection, String str, int i10, double d8, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = resolvedTurnDetection.type;
            }
            if ((i11 & 2) != 0) {
                i10 = resolvedTurnDetection.silenceMs;
            }
            if ((i11 & 4) != 0) {
                d8 = resolvedTurnDetection.threshold;
            }
            return resolvedTurnDetection.copy(str, i10, d8);
        }

        public final String component1() {
            return this.type;
        }

        public final int component2() {
            return this.silenceMs;
        }

        public final double component3() {
            return this.threshold;
        }

        public final ResolvedTurnDetection copy(String type, int i10, double d8) {
            kotlin.jvm.internal.g.f(type, "type");
            return new ResolvedTurnDetection(type, i10, d8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedTurnDetection)) {
                return false;
            }
            ResolvedTurnDetection resolvedTurnDetection = (ResolvedTurnDetection) obj;
            return kotlin.jvm.internal.g.b(this.type, resolvedTurnDetection.type) && this.silenceMs == resolvedTurnDetection.silenceMs && Double.compare(this.threshold, resolvedTurnDetection.threshold) == 0;
        }

        public final int getSilenceMs() {
            return this.silenceMs;
        }

        public final double getThreshold() {
            return this.threshold;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return Double.hashCode(this.threshold) + ai.onnxruntime.a.d(this.silenceMs, this.type.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.type;
            int i10 = this.silenceMs;
            double d8 = this.threshold;
            StringBuilder sbF = h0.e.f("ResolvedTurnDetection(type=", str, ", silenceMs=", i10, ", threshold=");
            sbF.append(d8);
            sbF.append(")");
            return sbF.toString();
        }
    }

    public AsrCloudConfig() {
        this(0L, 0L, 0L, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AsrCloudConfig copy$default(AsrCloudConfig asrCloudConfig, long j10, long j11, long j12, String str, p6.c cVar, ContentParams contentParams, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = asrCloudConfig.timeoutMs;
        }
        long j13 = j10;
        if ((i10 & 2) != 0) {
            j11 = asrCloudConfig.pollIntervalMs;
        }
        return asrCloudConfig.copy(j13, j11, (i10 & 4) != 0 ? asrCloudConfig.maxPollTimeMs : j12, (i10 & 8) != 0 ? asrCloudConfig.wsEndpoint : str, (i10 & 16) != 0 ? asrCloudConfig.params : cVar, (i10 & 32) != 0 ? asrCloudConfig.clientParams : contentParams, (i10 & 64) != 0 ? asrCloudConfig.sceneType : str2);
    }

    public final long closeAckTimeoutMs() {
        return getStream().a("preempt").f11439a.optLong("close_ack_timeout_ms", 2000L);
    }

    public final long component1() {
        return this.timeoutMs;
    }

    public final long component2() {
        return this.pollIntervalMs;
    }

    public final long component3() {
        return this.maxPollTimeMs;
    }

    public final String component4() {
        return this.wsEndpoint;
    }

    public final p6.c component5() {
        return this.params;
    }

    public final ContentParams component6() {
        return this.clientParams;
    }

    public final String component7() {
        return this.sceneType;
    }

    public final AsrCloudConfig copy(long j10, long j11, long j12, String wsEndpoint, p6.c params, ContentParams contentParams, String str) {
        kotlin.jvm.internal.g.f(wsEndpoint, "wsEndpoint");
        kotlin.jvm.internal.g.f(params, "params");
        return new AsrCloudConfig(j10, j11, j12, wsEndpoint, params, contentParams, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrCloudConfig)) {
            return false;
        }
        AsrCloudConfig asrCloudConfig = (AsrCloudConfig) obj;
        return this.timeoutMs == asrCloudConfig.timeoutMs && this.pollIntervalMs == asrCloudConfig.pollIntervalMs && this.maxPollTimeMs == asrCloudConfig.maxPollTimeMs && kotlin.jvm.internal.g.b(this.wsEndpoint, asrCloudConfig.wsEndpoint) && kotlin.jvm.internal.g.b(this.params, asrCloudConfig.params) && kotlin.jvm.internal.g.b(this.clientParams, asrCloudConfig.clientParams) && kotlin.jvm.internal.g.b(this.sceneType, asrCloudConfig.sceneType);
    }

    public final ContentParams getClientParams() {
        return this.clientParams;
    }

    public final p6.c getFile() {
        return this.params.a(SCENE_MODE_FILE);
    }

    public final long getMaxPollTimeMs() {
        return this.maxPollTimeMs;
    }

    public final p6.c getParams() {
        return this.params;
    }

    public final long getPollIntervalMs() {
        return this.pollIntervalMs;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final p6.c getStream() {
        p6.c cVar = this.params;
        cVar.getClass();
        boolean zHas = cVar.f11439a.has(SCENE_MODE_STREAM);
        p6.c cVar2 = this.params;
        return zHas ? cVar2.a(SCENE_MODE_STREAM) : cVar2;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final String getWsEndpoint() {
        return this.wsEndpoint;
    }

    public int hashCode() {
        int iHashCode = (this.params.hashCode() + v1.d.a(a0.a.c(a0.a.c(Long.hashCode(this.timeoutMs) * 31, this.pollIntervalMs, 31), this.maxPollTimeMs, 31), 31, this.wsEndpoint)) * 31;
        ContentParams contentParams = this.clientParams;
        int iHashCode2 = (iHashCode + (contentParams == null ? 0 : contentParams.hashCode())) * 31;
        String str = this.sceneType;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final ResolvedTurnDetection resolveTurnDetection() {
        int iIntValue;
        ContentParams contentParams = this.clientParams;
        String strB = "";
        Double d8 = null;
        String string = (contentParams == null || !contentParams.containsKey(AsrParamKeys.REALTIME_TURN_DETECTION_TYPE)) ? null : contentParams.getString(AsrParamKeys.REALTIME_TURN_DETECTION_TYPE, "");
        Integer numValueOf = (contentParams == null || !contentParams.containsKey(AsrParamKeys.REALTIME_TURN_DETECTION_SILENCE_MS)) ? null : Integer.valueOf(contentParams.getInt(AsrParamKeys.REALTIME_TURN_DETECTION_SILENCE_MS, 0));
        Double dValueOf = (contentParams == null || !contentParams.containsKey(AsrParamKeys.REALTIME_TURN_DETECTION_THRESHOLD)) ? null : Double.valueOf(contentParams.getDouble(AsrParamKeys.REALTIME_TURN_DETECTION_THRESHOLD, 0.0d));
        p6.c cVarA = getStream().a("turn_detection");
        if (string == null) {
            strB = cVarA.b(FileResponse.FIELD_TYPE, "");
        } else if (string.equals(AsrParamKeys.TURN_DETECTION_SERVER_VAD)) {
            strB = AsrParamKeys.TURN_DETECTION_SERVER_VAD;
        }
        if (!strB.equals(AsrParamKeys.TURN_DETECTION_SERVER_VAD)) {
            return new ResolvedTurnDetection(strB, 0, 0.0d);
        }
        boolean zB = kotlin.jvm.internal.g.b(string, AsrParamKeys.TURN_DETECTION_SERVER_VAD);
        if (!zB || numValueOf == null || 200 > (iIntValue = numValueOf.intValue()) || iIntValue >= 5001) {
            numValueOf = null;
        }
        int iIntValue2 = numValueOf != null ? numValueOf.intValue() : cVarA.f11439a.optInt("silence_duration_ms", 0);
        if (zB && dValueOf != null) {
            double dDoubleValue = dValueOf.doubleValue();
            if (0.0d <= dDoubleValue && dDoubleValue <= 1.0d) {
                d8 = dValueOf;
            }
        }
        return new ResolvedTurnDetection(AsrParamKeys.TURN_DETECTION_SERVER_VAD, iIntValue2, d8 != null ? d8.doubleValue() : cVarA.f11439a.optDouble("threshold", 0.0d));
    }

    public final String streamModel() {
        return getStream().a("transcription").b(ModelManifest.TYPE_MODEL, "");
    }

    public final int streamVadSilenceMs() {
        return resolveTurnDetection().getSilenceMs();
    }

    public final String streamVadType() {
        return resolveTurnDetection().getType();
    }

    public String toString() {
        long j10 = this.timeoutMs;
        long j11 = this.pollIntervalMs;
        long j12 = this.maxPollTimeMs;
        String str = this.wsEndpoint;
        p6.c cVar = this.params;
        ContentParams contentParams = this.clientParams;
        String str2 = this.sceneType;
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "AsrCloudConfig(timeoutMs=", ", pollIntervalMs=");
        sbQ.append(j11);
        a0.a.s(j12, ", maxPollTimeMs=", ", wsEndpoint=", sbQ);
        sbQ.append(str);
        sbQ.append(", params=");
        sbQ.append(cVar);
        sbQ.append(", clientParams=");
        sbQ.append(contentParams);
        sbQ.append(", sceneType=");
        sbQ.append(str2);
        sbQ.append(")");
        return sbQ.toString();
    }

    public AsrCloudConfig(long j10, long j11, long j12, String wsEndpoint, p6.c params, ContentParams contentParams, String str) {
        kotlin.jvm.internal.g.f(wsEndpoint, "wsEndpoint");
        kotlin.jvm.internal.g.f(params, "params");
        this.timeoutMs = j10;
        this.pollIntervalMs = j11;
        this.maxPollTimeMs = j12;
        this.wsEndpoint = wsEndpoint;
        this.params = params;
        this.clientParams = contentParams;
        this.sceneType = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AsrCloudConfig(long j10, long j11, long j12, String str, p6.c cVar, ContentParams contentParams, String str2, int i10, kotlin.jvm.internal.e eVar) {
        p6.c cVar2;
        long j13 = (i10 & 1) != 0 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : j10;
        long j14 = (i10 & 2) != 0 ? 1000L : j11;
        long j15 = (i10 & 4) != 0 ? 600000L : j12;
        String str3 = (i10 & 8) != 0 ? "" : str;
        if ((i10 & 16) != 0) {
            p6.c cVar3 = p6.c.f11438b;
            cVar2 = p6.c.f11438b;
        } else {
            cVar2 = cVar;
        }
        this(j13, j14, j15, str3, cVar2, (i10 & 32) != 0 ? null : contentParams, (i10 & 64) != 0 ? null : str2);
    }
}
