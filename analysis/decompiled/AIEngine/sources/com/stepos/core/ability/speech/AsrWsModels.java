package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrCloudConfig;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.util.AsrParamKeys;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manifest.ModelManifest;
import com.tonyodev.fetch2core.server.FileResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrWsModels {
    private static final String APPEND_PREFIX = "{\"type\":\"input_audio_buffer.append\",\"audio\":\"";
    private static final String APPEND_SUFFIX = "\"}";
    public static final AsrWsModels INSTANCE = new AsrWsModels();
    private static final String[] TRANSCRIPT_TEXT_KEYS = {"text", "delta", "stash", "transcript"};

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface ServerEvent {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Completed implements ServerEvent {
            private final long endMs;
            private final String sessionId;
            private final long startMs;
            private final String text;
            private final String type;

            public Completed(String sessionId, String type, String text, long j10, long j11) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                kotlin.jvm.internal.g.f(text, "text");
                this.sessionId = sessionId;
                this.type = type;
                this.text = text;
                this.startMs = j10;
                this.endMs = j11;
            }

            public static /* synthetic */ Completed copy$default(Completed completed, String str, String str2, String str3, long j10, long j11, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = completed.sessionId;
                }
                if ((i10 & 2) != 0) {
                    str2 = completed.type;
                }
                if ((i10 & 4) != 0) {
                    str3 = completed.text;
                }
                if ((i10 & 8) != 0) {
                    j10 = completed.startMs;
                }
                if ((i10 & 16) != 0) {
                    j11 = completed.endMs;
                }
                long j12 = j11;
                String str4 = str3;
                return completed.copy(str, str2, str4, j10, j12);
            }

            public final String component1() {
                return this.sessionId;
            }

            public final String component2() {
                return this.type;
            }

            public final String component3() {
                return this.text;
            }

            public final long component4() {
                return this.startMs;
            }

            public final long component5() {
                return this.endMs;
            }

            public final Completed copy(String sessionId, String type, String text, long j10, long j11) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                kotlin.jvm.internal.g.f(text, "text");
                return new Completed(sessionId, type, text, j10, j11);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Completed)) {
                    return false;
                }
                Completed completed = (Completed) obj;
                return kotlin.jvm.internal.g.b(this.sessionId, completed.sessionId) && kotlin.jvm.internal.g.b(this.type, completed.type) && kotlin.jvm.internal.g.b(this.text, completed.text) && this.startMs == completed.startMs && this.endMs == completed.endMs;
            }

            public final long getEndMs() {
                return this.endMs;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getSessionId() {
                return this.sessionId;
            }

            public final long getStartMs() {
                return this.startMs;
            }

            public final String getText() {
                return this.text;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getType() {
                return this.type;
            }

            public int hashCode() {
                return Long.hashCode(this.endMs) + a0.a.c(v1.d.a(v1.d.a(this.sessionId.hashCode() * 31, 31, this.type), 31, this.text), this.startMs, 31);
            }

            public String toString() {
                String str = this.sessionId;
                String str2 = this.type;
                String str3 = this.text;
                long j10 = this.startMs;
                long j11 = this.endMs;
                StringBuilder sbS = ai.onnxruntime.a.s("Completed(sessionId=", str, ", type=", str2, ", text=");
                com.stepos.core.ota.d.p(j10, str3, ", startMs=", sbS);
                return a0.a.d(j11, ", endMs=", ")", sbS);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Delta implements ServerEvent {
            private final long endMs;
            private final String sessionId;
            private final long startMs;
            private final String stash;
            private final String text;
            private final String type;

            public Delta(String sessionId, String type, String text, String stash, long j10, long j11) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                kotlin.jvm.internal.g.f(text, "text");
                kotlin.jvm.internal.g.f(stash, "stash");
                this.sessionId = sessionId;
                this.type = type;
                this.text = text;
                this.stash = stash;
                this.startMs = j10;
                this.endMs = j11;
            }

            public static /* synthetic */ Delta copy$default(Delta delta, String str, String str2, String str3, String str4, long j10, long j11, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = delta.sessionId;
                }
                if ((i10 & 2) != 0) {
                    str2 = delta.type;
                }
                if ((i10 & 4) != 0) {
                    str3 = delta.text;
                }
                if ((i10 & 8) != 0) {
                    str4 = delta.stash;
                }
                if ((i10 & 16) != 0) {
                    j10 = delta.startMs;
                }
                if ((i10 & 32) != 0) {
                    j11 = delta.endMs;
                }
                long j12 = j11;
                long j13 = j10;
                return delta.copy(str, str2, str3, str4, j13, j12);
            }

            public final String component1() {
                return this.sessionId;
            }

            public final String component2() {
                return this.type;
            }

            public final String component3() {
                return this.text;
            }

            public final String component4() {
                return this.stash;
            }

            public final long component5() {
                return this.startMs;
            }

            public final long component6() {
                return this.endMs;
            }

            public final Delta copy(String sessionId, String type, String text, String stash, long j10, long j11) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                kotlin.jvm.internal.g.f(text, "text");
                kotlin.jvm.internal.g.f(stash, "stash");
                return new Delta(sessionId, type, text, stash, j10, j11);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Delta)) {
                    return false;
                }
                Delta delta = (Delta) obj;
                return kotlin.jvm.internal.g.b(this.sessionId, delta.sessionId) && kotlin.jvm.internal.g.b(this.type, delta.type) && kotlin.jvm.internal.g.b(this.text, delta.text) && kotlin.jvm.internal.g.b(this.stash, delta.stash) && this.startMs == delta.startMs && this.endMs == delta.endMs;
            }

            public final long getEndMs() {
                return this.endMs;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getSessionId() {
                return this.sessionId;
            }

            public final long getStartMs() {
                return this.startMs;
            }

            public final String getStash() {
                return this.stash;
            }

            public final String getText() {
                return this.text;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getType() {
                return this.type;
            }

            public int hashCode() {
                return Long.hashCode(this.endMs) + a0.a.c(v1.d.a(v1.d.a(v1.d.a(this.sessionId.hashCode() * 31, 31, this.type), 31, this.text), 31, this.stash), this.startMs, 31);
            }

            public String toString() {
                String str = this.sessionId;
                String str2 = this.type;
                String str3 = this.text;
                String str4 = this.stash;
                long j10 = this.startMs;
                long j11 = this.endMs;
                StringBuilder sbS = ai.onnxruntime.a.s("Delta(sessionId=", str, ", type=", str2, ", text=");
                ai.onnxruntime.a.z(sbS, str3, ", stash=", str4, ", startMs=");
                sbS.append(j10);
                return a0.a.d(j11, ", endMs=", ")", sbS);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Failure implements ServerEvent {
            private final int code;
            private final String message;
            private final String sessionId;
            private final String type;

            public Failure(String sessionId, String type, int i10, String message) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                kotlin.jvm.internal.g.f(message, "message");
                this.sessionId = sessionId;
                this.type = type;
                this.code = i10;
                this.message = message;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, String str, String str2, int i10, String str3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = failure.sessionId;
                }
                if ((i11 & 2) != 0) {
                    str2 = failure.type;
                }
                if ((i11 & 4) != 0) {
                    i10 = failure.code;
                }
                if ((i11 & 8) != 0) {
                    str3 = failure.message;
                }
                return failure.copy(str, str2, i10, str3);
            }

            public final String component1() {
                return this.sessionId;
            }

            public final String component2() {
                return this.type;
            }

            public final int component3() {
                return this.code;
            }

            public final String component4() {
                return this.message;
            }

            public final Failure copy(String sessionId, String type, int i10, String message) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                kotlin.jvm.internal.g.f(message, "message");
                return new Failure(sessionId, type, i10, message);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Failure)) {
                    return false;
                }
                Failure failure = (Failure) obj;
                return kotlin.jvm.internal.g.b(this.sessionId, failure.sessionId) && kotlin.jvm.internal.g.b(this.type, failure.type) && this.code == failure.code && kotlin.jvm.internal.g.b(this.message, failure.message);
            }

            public final int getCode() {
                return this.code;
            }

            public final String getMessage() {
                return this.message;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getSessionId() {
                return this.sessionId;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getType() {
                return this.type;
            }

            public int hashCode() {
                return this.message.hashCode() + ai.onnxruntime.a.d(this.code, v1.d.a(this.sessionId.hashCode() * 31, 31, this.type), 31);
            }

            public String toString() {
                String str = this.sessionId;
                String str2 = this.type;
                int i10 = this.code;
                String str3 = this.message;
                StringBuilder sbS = ai.onnxruntime.a.s("Failure(sessionId=", str, ", type=", str2, ", code=");
                sbS.append(i10);
                sbS.append(", message=");
                sbS.append(str3);
                sbS.append(")");
                return sbS.toString();
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Ignored implements ServerEvent {
            private final String sessionId;
            private final String type;

            public Ignored(String sessionId, String type) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                this.sessionId = sessionId;
                this.type = type;
            }

            public static /* synthetic */ Ignored copy$default(Ignored ignored, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = ignored.sessionId;
                }
                if ((i10 & 2) != 0) {
                    str2 = ignored.type;
                }
                return ignored.copy(str, str2);
            }

            public final String component1() {
                return this.sessionId;
            }

            public final String component2() {
                return this.type;
            }

            public final Ignored copy(String sessionId, String type) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                return new Ignored(sessionId, type);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Ignored)) {
                    return false;
                }
                Ignored ignored = (Ignored) obj;
                return kotlin.jvm.internal.g.b(this.sessionId, ignored.sessionId) && kotlin.jvm.internal.g.b(this.type, ignored.type);
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getSessionId() {
                return this.sessionId;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getType() {
                return this.type;
            }

            public int hashCode() {
                return this.type.hashCode() + (this.sessionId.hashCode() * 31);
            }

            public String toString() {
                return h0.e.c("Ignored(sessionId=", this.sessionId, ", type=", this.type, ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SessionReady implements ServerEvent {
            private final String sessionId;
            private final String type;

            public SessionReady(String sessionId, String type) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                this.sessionId = sessionId;
                this.type = type;
            }

            public static /* synthetic */ SessionReady copy$default(SessionReady sessionReady, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = sessionReady.sessionId;
                }
                if ((i10 & 2) != 0) {
                    str2 = sessionReady.type;
                }
                return sessionReady.copy(str, str2);
            }

            public final String component1() {
                return this.sessionId;
            }

            public final String component2() {
                return this.type;
            }

            public final SessionReady copy(String sessionId, String type) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                kotlin.jvm.internal.g.f(type, "type");
                return new SessionReady(sessionId, type);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SessionReady)) {
                    return false;
                }
                SessionReady sessionReady = (SessionReady) obj;
                return kotlin.jvm.internal.g.b(this.sessionId, sessionReady.sessionId) && kotlin.jvm.internal.g.b(this.type, sessionReady.type);
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getSessionId() {
                return this.sessionId;
            }

            @Override // com.stepos.core.ability.speech.AsrWsModels.ServerEvent
            public String getType() {
                return this.type;
            }

            public int hashCode() {
                return this.type.hashCode() + (this.sessionId.hashCode() * 31);
            }

            public String toString() {
                return h0.e.c("SessionReady(sessionId=", this.sessionId, ", type=", this.type, ")");
            }
        }

        String getSessionId();

        String getType();
    }

    private AsrWsModels() {
    }

    private final long firstLong(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            if (jSONObject.has(str)) {
                return jSONObject.optLong(str, 0L);
            }
        }
        return 0L;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final int mapErrorCode(String str) {
        switch (str.hashCode()) {
            case -1757296911:
                if (!str.equals("max_idle_timeout")) {
                }
                return AIEngineError.CLOUD_SERVER_ERROR;
            case -1186342796:
                if (str.equals("missing_param")) {
                    return AIEngineError.CLOUD_INVALID_REQUEST;
                }
                break;
            case -1077300100:
                if (str.equals("risk_blocked")) {
                    return AIEngineError.CLOUD_RISK_BLOCKED;
                }
                break;
            case -902294502:
                if (!str.equals("pong_timeout")) {
                }
                return AIEngineError.CLOUD_SERVER_ERROR;
            case -834449111:
                if (str.equals("invalid_value")) {
                    return AIEngineError.CLOUD_INVALID_REQUEST;
                }
                break;
            case 778975750:
                if (!str.equals("internal_error")) {
                }
                return AIEngineError.CLOUD_SERVER_ERROR;
        }
        Integer numC0 = gc.n.c0(str);
        if (numC0 != null) {
            return CloudHttpErrorMapper.INSTANCE.toErrorCode(Integer.valueOf(numC0.intValue()));
        }
        return AIEngineError.CLOUD_SERVER_ERROR;
    }

    private final long segmentEndMs(JSONObject jSONObject) {
        long jFirstLong = firstLong(jSONObject, "end_time", "end_ms");
        return jFirstLong > 0 ? jFirstLong : wordsEdgeMs(jSONObject, false);
    }

    private final long segmentStartMs(JSONObject jSONObject) {
        long jFirstLong = firstLong(jSONObject, "start_time", "start_ms");
        return jFirstLong > 0 ? jFirstLong : wordsEdgeMs(jSONObject, true);
    }

    private final long wordsEdgeMs(JSONObject jSONObject, boolean z) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("words");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return 0L;
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(z ? 0 : jSONArrayOptJSONArray.length() - 1);
        if (jSONObjectOptJSONObject == null) {
            return 0L;
        }
        double dOptDouble = jSONObjectOptJSONObject.optDouble(z ? "start" : "end", 0.0d);
        if (dOptDouble > 0.0d) {
            return (long) (dOptDouble * 1000.0d);
        }
        return 0L;
    }

    public final String buildAppend(String audioBase64) {
        kotlin.jvm.internal.g.f(audioBase64, "audioBase64");
        return APPEND_PREFIX + audioBase64 + APPEND_SUFFIX;
    }

    public final String buildCommit() {
        String string = new JSONObject().put(FileResponse.FIELD_TYPE, "input_audio_buffer.commit").toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String buildSessionUpdate(AsrCloudConfig config) {
        kotlin.jvm.internal.g.f(config, "config");
        p6.c stream = config.getStream();
        p6.c cVarA = stream.a("format");
        JSONObject jSONObjectPut = new JSONObject().put(FileResponse.FIELD_TYPE, cVarA.b(FileResponse.FIELD_TYPE, "pcm")).put("codec", cVarA.b("codec", "pcm_s16le"));
        JSONObject jSONObject = cVarA.f11439a;
        JSONObject jSONObjectPut2 = jSONObjectPut.put("rate", jSONObject.optInt("rate", 16000)).put("bits", jSONObject.optInt("bits", 16)).put("channel", jSONObject.optInt("channel", 1));
        p6.c cVarA2 = stream.a("transcription");
        JSONObject jSONObjectPut3 = new JSONObject().put(ModelManifest.TYPE_MODEL, cVarA2.b(ModelManifest.TYPE_MODEL, "")).put("language", cVarA2.b("language", ""));
        JSONObject jSONObject2 = cVarA2.f11439a;
        JSONObject jSONObjectPut4 = jSONObjectPut3.put("enable_itn", jSONObject2.optBoolean("enable_itn", false)).put("full_rerun_on_commit", jSONObject2.optBoolean("full_rerun_on_commit", false));
        if (jSONObject2.has("enable_timestamp_align")) {
            jSONObjectPut4.put("enable_timestamp_align", jSONObject2.optBoolean("enable_timestamp_align", false));
        }
        AsrCloudConfig.ResolvedTurnDetection resolvedTurnDetectionResolveTurnDetection = config.resolveTurnDetection();
        JSONObject jSONObjectPut5 = new JSONObject().put(FileResponse.FIELD_TYPE, resolvedTurnDetectionResolveTurnDetection.getType());
        if (kotlin.jvm.internal.g.b(resolvedTurnDetectionResolveTurnDetection.getType(), AsrParamKeys.TURN_DETECTION_SERVER_VAD)) {
            jSONObjectPut5.put("silence_duration_ms", resolvedTurnDetectionResolveTurnDetection.getSilenceMs());
            jSONObjectPut5.put("threshold", resolvedTurnDetectionResolveTurnDetection.getThreshold());
        }
        String string = new JSONObject().put(FileResponse.FIELD_TYPE, "session.update").put("session", new JSONObject().put("audio", new JSONObject().put("input", new JSONObject().put("format", jSONObjectPut2).put("transcription", jSONObjectPut4).put("turn_detection", jSONObjectPut5)))).toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String formatForDiagLog(String raw) {
        kotlin.jvm.internal.g.f(raw, "raw");
        try {
            JSONObject jSONObject = new JSONObject(raw);
            for (String str : TRANSCRIPT_TEXT_KEYS) {
                String strOptString = jSONObject.optString(str, "");
                kotlin.jvm.internal.g.c(strOptString);
                if (strOptString.length() > 0) {
                    jSONObject.put(str, "<text len=" + strOptString.length() + ">");
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("words");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString("word", "");
                        kotlin.jvm.internal.g.c(strOptString2);
                        if (strOptString2.length() > 0) {
                            jSONObjectOptJSONObject.put("word", "<w len=" + strOptString2.length() + ">");
                        }
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return ai.onnxruntime.a.g(raw.length(), "<non-json frame len=", ">");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r5.equals("session.updated") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f9, code lost:
    
        if (r5.equals("session.created") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0101, code lost:
    
        return new com.stepos.core.ability.speech.AsrWsModels.ServerEvent.SessionReady(r4, r5);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.ability.speech.AsrWsModels.ServerEvent parseServerEvent(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrWsModels.parseServerEvent(java.lang.String):com.stepos.core.ability.speech.AsrWsModels$ServerEvent");
    }
}
