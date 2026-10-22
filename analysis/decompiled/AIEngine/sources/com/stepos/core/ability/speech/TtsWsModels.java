package com.stepos.core.ability.speech;

import androidx.datastore.preferences.protobuf.b1;
import com.tonyodev.fetch2core.server.FileResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.collections.EmptyList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsWsModels {
    private static final int CJK_START = 11904;
    public static final TtsWsModels INSTANCE = new TtsWsModels();
    private static final char[] SENTENCE_END_PUNCT = {12290, 65281, 65311, '!', '?'};
    private static final char[] SECONDARY_BREAK_PUNCT_ALWAYS = {65292, 12289, 65307, 65306, 8230, '\n'};
    private static final char[] SECONDARY_BREAK_PUNCT_ASCII = {',', ';', ':'};
    private static final char[] TRAILING_CLOSERS = {12301, 12303, '\"', '\'', 65289, ')', 12305};
    private static final char[] OPEN_QUOTES = {12300, 12302, '\"', '\'', 65288, '('};
    private static final char[] CLOSE_QUOTES = {12301, 12303, '\"', '\'', 65289, ')'};

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class ServerEvent {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class AudioComplete extends ServerEvent {
            public static final AudioComplete INSTANCE = new AudioComplete();

            private AudioComplete() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof AudioComplete);
            }

            public int hashCode() {
                return 1696874809;
            }

            public String toString() {
                return "AudioComplete";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class AudioDelta extends ServerEvent {
            private final boolean finished;
            private final byte[] pcm;
            private final int sampleRate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AudioDelta(byte[] pcm, int i10, boolean z) {
                super(null);
                kotlin.jvm.internal.g.f(pcm, "pcm");
                this.pcm = pcm;
                this.sampleRate = i10;
                this.finished = z;
            }

            public static /* synthetic */ AudioDelta copy$default(AudioDelta audioDelta, byte[] bArr, int i10, boolean z, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    bArr = audioDelta.pcm;
                }
                if ((i11 & 2) != 0) {
                    i10 = audioDelta.sampleRate;
                }
                if ((i11 & 4) != 0) {
                    z = audioDelta.finished;
                }
                return audioDelta.copy(bArr, i10, z);
            }

            public final byte[] component1() {
                return this.pcm;
            }

            public final int component2() {
                return this.sampleRate;
            }

            public final boolean component3() {
                return this.finished;
            }

            public final AudioDelta copy(byte[] pcm, int i10, boolean z) {
                kotlin.jvm.internal.g.f(pcm, "pcm");
                return new AudioDelta(pcm, i10, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AudioDelta)) {
                    return false;
                }
                AudioDelta audioDelta = (AudioDelta) obj;
                return kotlin.jvm.internal.g.b(this.pcm, audioDelta.pcm) && this.sampleRate == audioDelta.sampleRate && this.finished == audioDelta.finished;
            }

            public final boolean getFinished() {
                return this.finished;
            }

            public final byte[] getPcm() {
                return this.pcm;
            }

            public final int getSampleRate() {
                return this.sampleRate;
            }

            public int hashCode() {
                return Boolean.hashCode(this.finished) + ai.onnxruntime.a.d(this.sampleRate, Arrays.hashCode(this.pcm) * 31, 31);
            }

            public String toString() {
                String string = Arrays.toString(this.pcm);
                int i10 = this.sampleRate;
                return a0.a.m(h0.e.f("AudioDelta(pcm=", string, ", sampleRate=", i10, ", finished="), this.finished, ")");
            }

            public /* synthetic */ AudioDelta(byte[] bArr, int i10, boolean z, int i11, kotlin.jvm.internal.e eVar) {
                this(bArr, i10, (i11 & 4) != 0 ? false : z);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class AudioPaused extends ServerEvent {
            public static final AudioPaused INSTANCE = new AudioPaused();

            private AudioPaused() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof AudioPaused);
            }

            public int hashCode() {
                return 437233966;
            }

            public String toString() {
                return "AudioPaused";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class ConnectionDone extends ServerEvent {
            private final String sessionId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectionDone(String sessionId) {
                super(null);
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                this.sessionId = sessionId;
            }

            public static /* synthetic */ ConnectionDone copy$default(ConnectionDone connectionDone, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = connectionDone.sessionId;
                }
                return connectionDone.copy(str);
            }

            public final String component1() {
                return this.sessionId;
            }

            public final ConnectionDone copy(String sessionId) {
                kotlin.jvm.internal.g.f(sessionId, "sessionId");
                return new ConnectionDone(sessionId);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ConnectionDone) && kotlin.jvm.internal.g.b(this.sessionId, ((ConnectionDone) obj).sessionId);
            }

            public final String getSessionId() {
                return this.sessionId;
            }

            public int hashCode() {
                return this.sessionId.hashCode();
            }

            public String toString() {
                return a0.a.k("ConnectionDone(sessionId=", this.sessionId, ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Error extends ServerEvent {
            private final int code;
            private final String message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(int i10, String message) {
                super(null);
                kotlin.jvm.internal.g.f(message, "message");
                this.code = i10;
                this.message = message;
            }

            public static /* synthetic */ Error copy$default(Error error, int i10, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    i10 = error.code;
                }
                if ((i11 & 2) != 0) {
                    str = error.message;
                }
                return error.copy(i10, str);
            }

            public final int component1() {
                return this.code;
            }

            public final String component2() {
                return this.message;
            }

            public final Error copy(int i10, String message) {
                kotlin.jvm.internal.g.f(message, "message");
                return new Error(i10, message);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return this.code == error.code && kotlin.jvm.internal.g.b(this.message, error.message);
            }

            public final int getCode() {
                return this.code;
            }

            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode() + (Integer.hashCode(this.code) * 31);
            }

            public String toString() {
                return "Error(code=" + this.code + ", message=" + this.message + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Ignored extends ServerEvent {
            public static final Ignored INSTANCE = new Ignored();

            private Ignored() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Ignored);
            }

            public int hashCode() {
                return -1320627620;
            }

            public String toString() {
                return "Ignored";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SentenceEnd extends ServerEvent {
            public static final SentenceEnd INSTANCE = new SentenceEnd();

            private SentenceEnd() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof SentenceEnd);
            }

            public int hashCode() {
                return -1322402814;
            }

            public String toString() {
                return "SentenceEnd";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class SessionReady extends ServerEvent {
            public static final SessionReady INSTANCE = new SessionReady();

            private SessionReady() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof SessionReady);
            }

            public int hashCode() {
                return -1947769501;
            }

            public String toString() {
                return "SessionReady";
            }
        }

        public /* synthetic */ ServerEvent(kotlin.jvm.internal.e eVar) {
            this();
        }

        private ServerEvent() {
        }
    }

    private TtsWsModels() {
    }

    private final int breakEndAtOrAfter(CharSequence charSequence, int i10, zb.l<? super Integer, Boolean> lVar) {
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < charSequence.length()) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                do {
                    i10++;
                    if (i10 >= charSequence.length()) {
                        break;
                    }
                } while (mb.l.b0(TRAILING_CLOSERS, charSequence.charAt(i10)));
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private final boolean isBreakAt(CharSequence charSequence, int i10, boolean z) {
        return isSentenceEndAt(charSequence, i10) || isSecondaryBreakAt(charSequence, i10, z);
    }

    private final boolean isSecondaryBreakAt(CharSequence charSequence, int i10, boolean z) {
        char cCharAt = charSequence.charAt(i10);
        if (mb.l.b0(SECONDARY_BREAK_PUNCT_ALWAYS, cCharAt)) {
            return true;
        }
        if (!mb.l.b0(SECONDARY_BREAK_PUNCT_ASCII, cCharAt)) {
            return false;
        }
        int i11 = i10 + 1;
        if (i11 >= charSequence.length()) {
            return z;
        }
        char cCharAt2 = charSequence.charAt(i11);
        return b1.N(cCharAt2) || cCharAt2 >= CJK_START;
    }

    private final boolean isSentenceEndAt(CharSequence charSequence, int i10) {
        return mb.l.b0(SENTENCE_END_PUNCT, charSequence.charAt(i10));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int mapUpstreamErrorCode(org.json.JSONObject r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L9
            java.lang.String r2 = "code"
            java.lang.Object r2 = r3.opt(r2)
            goto La
        L9:
            r2 = 0
        La:
            boolean r3 = r2 instanceof java.lang.String
            r0 = 270003(0x41eb3, float:3.78355E-40)
            if (r3 == 0) goto L4a
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r2.hashCode()
            switch(r3) {
                case -1757296911: goto L46;
                case -1186342796: goto L3a;
                case -1077300100: goto L2d;
                case -902294502: goto L2a;
                case -834449111: goto L21;
                case 778975750: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L49
        L1b:
            java.lang.String r3 = "internal_error"
        L1d:
            r2.equals(r3)
            goto L49
        L21:
            java.lang.String r3 = "invalid_value"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L42
            goto L49
        L2a:
            java.lang.String r3 = "pong_timeout"
            goto L1d
        L2d:
            java.lang.String r3 = "risk_blocked"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L36
            goto L49
        L36:
            r2 = 270007(0x41eb7, float:3.7836E-40)
            return r2
        L3a:
            java.lang.String r3 = "missing_param"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L49
        L42:
            r2 = 270006(0x41eb6, float:3.78359E-40)
            return r2
        L46:
            java.lang.String r3 = "max_idle_timeout"
            goto L1d
        L49:
            return r0
        L4a:
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L67
            com.stepos.core.error.AIEngineError r3 = com.stepos.core.error.AIEngineError.INSTANCE
            java.lang.Number r2 = (java.lang.Number) r2
            int r1 = r2.intValue()
            java.lang.String r3 = r3.getModule(r1)
            java.lang.String r1 = "CLOUD"
            boolean r3 = kotlin.jvm.internal.g.b(r3, r1)
            if (r3 == 0) goto L67
            int r2 = r2.intValue()
            return r2
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsWsModels.mapUpstreamErrorCode(org.json.JSONObject):int");
    }

    private final JSONObject maskAudioFieldInPlace(JSONObject jSONObject) throws JSONException {
        String strOptString;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        String str = "";
        if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("audio", "")) != null) {
            if (gc.q.t0(strOptString)) {
                strOptString = jSONObject.optString("delta", "");
            }
            if (strOptString != null) {
                str = strOptString;
            }
        }
        if (jSONObjectOptJSONObject != null && str.length() > 0) {
            jSONObjectOptJSONObject.put("audio", com.stepos.core.ota.d.e(str.length(), "<b64 len=", (str.length() * 3) / 4, ", pcm_est=", ">"));
            return jSONObject;
        }
        if (str.length() > 0) {
            jSONObject.put("delta", com.stepos.core.ota.d.e(str.length(), "<b64 len=", (str.length() * 3) / 4, ", pcm_est=", ">"));
        }
        return jSONObject;
    }

    private final JSONObject maskTextFieldInPlace(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject == null) {
            return jSONObject;
        }
        String strOptString = jSONObjectOptJSONObject.optString("text", "");
        kotlin.jvm.internal.g.c(strOptString);
        if (strOptString.length() > 0) {
            jSONObjectOptJSONObject.put("text", "<text len=" + strOptString.length() + ">");
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.core.ability.speech.TtsWsModels.ServerEvent parseAudioDelta(org.json.JSONObject r7, int r8) {
        /*
            r6 = this;
            java.lang.String r6 = "data"
            org.json.JSONObject r6 = r7.optJSONObject(r6)
            java.lang.String r0 = ""
            if (r6 == 0) goto L35
            java.lang.String r1 = "audio"
            java.lang.String r2 = r6.optString(r1, r0)
            if (r2 == 0) goto L35
            boolean r3 = gc.q.t0(r2)
            java.lang.String r4 = "delta"
            if (r3 == 0) goto L1e
            java.lang.String r2 = r7.optString(r4, r0)
        L1e:
            if (r2 == 0) goto L35
            boolean r3 = gc.q.t0(r2)
            if (r3 == 0) goto L36
            org.json.JSONObject r1 = r7.optJSONObject(r1)
            if (r1 == 0) goto L35
            java.lang.String r1 = r1.optString(r4, r0)
            if (r1 != 0) goto L33
            goto L35
        L33:
            r2 = r1
            goto L36
        L35:
            r2 = r0
        L36:
            java.lang.String r1 = "status"
            if (r6 == 0) goto L40
            java.lang.String r3 = r6.optString(r1, r0)
            if (r3 != 0) goto L41
        L40:
            r3 = r0
        L41:
            java.lang.String r4 = "finished"
            boolean r3 = r3.equalsIgnoreCase(r4)
            r5 = 0
            if (r3 != 0) goto L57
            java.lang.String r0 = r7.optString(r1, r0)
            boolean r0 = gc.o.f0(r0, r4)
            if (r0 == 0) goto L55
            goto L57
        L55:
            r0 = r5
            goto L58
        L57:
            r0 = 1
        L58:
            boolean r1 = gc.q.t0(r2)
            if (r1 == 0) goto L66
            if (r0 == 0) goto L63
            com.stepos.core.ability.speech.TtsWsModels$ServerEvent$AudioComplete r6 = com.stepos.core.ability.speech.TtsWsModels.ServerEvent.AudioComplete.INSTANCE
            return r6
        L63:
            com.stepos.core.ability.speech.TtsWsModels$ServerEvent$Ignored r6 = com.stepos.core.ability.speech.TtsWsModels.ServerEvent.Ignored.INSTANCE
            return r6
        L66:
            java.util.Base64$Decoder r1 = java.util.Base64.getDecoder()
            byte[] r1 = r1.decode(r2)
            java.lang.String r2 = "sample_rate"
            if (r6 == 0) goto L85
            int r6 = r6.optInt(r2, r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            if (r6 <= 0) goto L7d
            goto L7e
        L7d:
            r3 = 0
        L7e:
            if (r3 == 0) goto L85
            int r6 = r3.intValue()
            goto L89
        L85:
            int r6 = r7.optInt(r2, r8)
        L89:
            com.stepos.core.ability.speech.TtsWsModels$ServerEvent$AudioDelta r7 = new com.stepos.core.ability.speech.TtsWsModels$ServerEvent$AudioDelta
            kotlin.jvm.internal.g.c(r1)
            if (r6 <= 0) goto L91
            r8 = r6
        L91:
            r7.<init>(r1, r8, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsWsModels.parseAudioDelta(org.json.JSONObject, int):com.stepos.core.ability.speech.TtsWsModels$ServerEvent");
    }

    private final boolean shouldContinueAfterSentenceEnd(String str, int i10, StringBuilder sb2) {
        if (sb2.length() >= 2 && sb2.charAt(sb2.length() - 2) == 12301) {
            int i11 = i10 + 1;
            while (i11 < str.length() && b1.N(str.charAt(i11))) {
                i11++;
            }
            if (i11 < str.length()) {
                return true;
            }
        }
        return false;
    }

    public final int anyBreakEndAtOrAfter(CharSequence text, int i10, boolean z) {
        kotlin.jvm.internal.g.f(text, "text");
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < text.length()) {
            if (INSTANCE.isBreakAt(text, i10, z)) {
                do {
                    i10++;
                    if (i10 >= text.length()) {
                        break;
                    }
                } while (mb.l.b0(TRAILING_CLOSERS, text.charAt(i10)));
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final String buildTextDelta(String text, String sessionId) {
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(sessionId, "sessionId");
        String string = new JSONObject().put(FileResponse.FIELD_TYPE, "tts.text.delta").put("data", new JSONObject().put("session_id", sessionId).put("text", text)).toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String buildTextDone(String sessionId) {
        kotlin.jvm.internal.g.f(sessionId, "sessionId");
        String string = new JSONObject().put(FileResponse.FIELD_TYPE, "tts.text.done").put("data", new JSONObject().put("session_id", sessionId)).toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String buildTtsCreate(TtsCloudConfig config, String sessionId) throws JSONException {
        kotlin.jvm.internal.g.f(config, "config");
        kotlin.jvm.internal.g.f(sessionId, "sessionId");
        JSONObject jSONObjectPut = new JSONObject().put("session_id", sessionId).put("voice_id", config.voice());
        String strResponseFormat = config.responseFormat();
        if (gc.q.t0(strResponseFormat)) {
            strResponseFormat = "pcm";
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("response_format", strResponseFormat).put("sample_rate", config.sampleRate() > 0 ? config.sampleRate() : 24000);
        if (config.speed() > 0.0d) {
            jSONObjectPut2.put("speed_ratio", config.speed());
        }
        if (config.volume() > 0.0d) {
            jSONObjectPut2.put("volume_ratio", config.volume());
        }
        String strInstruction = config.instruction();
        if (gc.q.t0(strInstruction)) {
            strInstruction = null;
        }
        if (strInstruction != null) {
            jSONObjectPut2.put("instruction", strInstruction);
        }
        String strMode = config.mode();
        if (gc.q.t0(strMode)) {
            strMode = null;
        }
        if (strMode != null) {
            jSONObjectPut2.put("mode", strMode);
        }
        String strTextNormalization = config.textNormalization();
        String str = gc.q.t0(strTextNormalization) ? null : strTextNormalization;
        if (str != null) {
            jSONObjectPut2.put("text_normalization", str);
        }
        if (config.markdownFilter()) {
            jSONObjectPut2.put("markdown_filter", true);
        }
        String string = new JSONObject().put(FileResponse.FIELD_TYPE, "tts.create").put("data", jSONObjectPut2).toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final boolean endsWithSentencePunctuation(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        String string = gc.q.N0(text).toString();
        if (string.length() == 0) {
            return false;
        }
        int length = string.length() - 1;
        while (length >= 0 && mb.l.b0(TRAILING_CLOSERS, string.charAt(length))) {
            length--;
        }
        return length >= 0 && mb.l.b0(SENTENCE_END_PUNCT, string.charAt(length));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:3:0x0007, B:6:0x001c, B:8:0x0022, B:15:0x0031, B:14:0x002d), top: B:19:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<java.lang.String, java.lang.String> eventTypeAndSession(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r4 = ""
            java.lang.String r0 = "raw"
            kotlin.jvm.internal.g.f(r5, r0)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L37
            r0.<init>(r5)     // Catch: java.lang.Exception -> L37
            java.lang.String r5 = "type"
            java.lang.String r5 = r0.optString(r5, r4)     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = "data"
            org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch: java.lang.Exception -> L37
            java.lang.String r2 = "session_id"
            if (r1 == 0) goto L2d
            java.lang.String r1 = r1.optString(r2, r4)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto L2d
            boolean r3 = gc.q.t0(r1)     // Catch: java.lang.Exception -> L37
            if (r3 != 0) goto L29
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == 0) goto L2d
            goto L31
        L2d:
            java.lang.String r1 = r0.optString(r2, r4)     // Catch: java.lang.Exception -> L37
        L31:
            kotlin.Pair r0 = new kotlin.Pair     // Catch: java.lang.Exception -> L37
            r0.<init>(r5, r1)     // Catch: java.lang.Exception -> L37
            return r0
        L37:
            kotlin.Pair r5 = new kotlin.Pair
            r5.<init>(r4, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsWsModels.eventTypeAndSession(java.lang.String):kotlin.Pair");
    }

    public final String formatForDiagLog(String raw) {
        JSONObject jSONObject;
        String strOptString;
        kotlin.jvm.internal.g.f(raw, "raw");
        try {
            jSONObject = new JSONObject(raw);
            strOptString = jSONObject.optString(FileResponse.FIELD_TYPE, "");
        } catch (Exception unused) {
        }
        if (kotlin.jvm.internal.g.b(strOptString, "tts.response.audio.delta")) {
            return maskAudioFieldInPlace(jSONObject).toString();
        }
        if (kotlin.jvm.internal.g.b(strOptString, "tts.text.delta")) {
            return maskTextFieldInPlace(jSONObject).toString();
        }
        return raw;
    }

    public final int lastBreakEndAtOrBefore(CharSequence text, int i10, boolean z) {
        kotlin.jvm.internal.g.f(text, "text");
        int i11 = -1;
        for (int i12 = 0; i12 < text.length() && i12 < i10; i12++) {
            if (isBreakAt(text, i12, z)) {
                int i13 = i12 + 1;
                while (i13 < text.length() && mb.l.b0(TRAILING_CLOSERS, text.charAt(i13))) {
                    i13++;
                }
                if (i13 <= i10) {
                    i11 = i13;
                }
            }
        }
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096 A[Catch: Exception -> 0x00e6, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e6, blocks: (B:3:0x0009, B:5:0x0016, B:9:0x0023, B:12:0x002d, B:14:0x0030, B:16:0x0038, B:19:0x0040, B:22:0x004a, B:24:0x0053, B:26:0x0056, B:21:0x0046, B:28:0x005c, B:31:0x0066, B:33:0x0069, B:69:0x00d2, B:36:0x0073, B:47:0x0090, B:49:0x0096, B:52:0x009e, B:56:0x00aa, B:39:0x007b, B:42:0x0084, B:44:0x0087, B:58:0x00b4, B:61:0x00bd, B:64:0x00c6, B:66:0x00c9, B:71:0x00d5, B:74:0x00de, B:76:0x00e3), top: B:84:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.ability.speech.TtsWsModels.ServerEvent parseServerEvent(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsWsModels.parseServerEvent(java.lang.String, int):com.stepos.core.ability.speech.TtsWsModels$ServerEvent");
    }

    public final int sentenceBreakEndAtOrAfter(CharSequence text, int i10) {
        kotlin.jvm.internal.g.f(text, "text");
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < text.length()) {
            if (INSTANCE.isSentenceEndAt(text, i10)) {
                do {
                    i10++;
                    if (i10 >= text.length()) {
                        break;
                    }
                } while (mb.l.b0(TRAILING_CLOSERS, text.charAt(i10)));
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final List<String> splitIntoSentences(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        if (gc.q.t0(text)) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = gc.q.E0(text, new char[]{'\n'}).iterator();
        while (it.hasNext()) {
            String string = gc.q.L0(gc.o.h0((String) it.next(), '\r', ' ')).toString();
            if (string.length() != 0) {
                arrayList.addAll(splitLineIntoSentences$ability_release(string));
            }
        }
        return arrayList;
    }

    public final List<String> splitLineIntoSentences$ability_release(String src) {
        String str;
        kotlin.jvm.internal.g.f(src, "src");
        if (src.length() == 0) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= src.length()) {
                break;
            }
            char cCharAt = src.charAt(i10);
            if (mb.l.b0(OPEN_QUOTES, cCharAt)) {
                i11++;
            } else if (mb.l.b0(CLOSE_QUOTES, cCharAt) && i11 - 1 < 0) {
                i11 = 0;
            }
            sb2.append(cCharAt);
            if (mb.l.b0(SENTENCE_END_PUNCT, cCharAt) && i11 == 0 && !shouldContinueAfterSentenceEnd(src, i10, sb2)) {
                while (true) {
                    i10++;
                    if (i10 >= src.length() || !mb.l.b0(TRAILING_CLOSERS, src.charAt(i10))) {
                        break;
                    }
                    sb2.append(src.charAt(i10));
                }
                String string = sb2.toString();
                kotlin.jvm.internal.g.e(string, "toString(...)");
                String string2 = gc.q.L0(string).toString();
                str = string2.length() > 0 ? string2 : null;
                if (str != null) {
                    arrayList.add(str);
                }
                sb2.setLength(0);
            } else {
                i10++;
            }
        }
        String string3 = sb2.toString();
        kotlin.jvm.internal.g.e(string3, "toString(...)");
        String string4 = gc.q.L0(string3).toString();
        str = string4.length() > 0 ? string4 : null;
        if (str != null) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public final String wireEventType(String frame) {
        Object objA;
        kotlin.jvm.internal.g.f(frame, "frame");
        try {
            objA = new JSONObject(frame).optString(FileResponse.FIELD_TYPE, "");
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        String str = (CharSequence) (objA instanceof Result.Failure ? "" : objA);
        if (gc.q.t0(str)) {
            str = "?";
        }
        return str;
    }
}
