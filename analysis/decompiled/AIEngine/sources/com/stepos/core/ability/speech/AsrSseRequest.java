package com.stepos.core.ability.speech;

import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.model.manifest.ModelManifest;
import com.tonyodev.fetch2core.server.FileResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseRequest {
    private static final String AUDIO_DATA_SENTINEL = "@{{AIENGINE_ASR_SSE_AUDIO_DATA}}@";
    public static final Companion Companion = new Companion(null);
    private final String audioData;
    private final Integer bits;
    private final Integer channel;
    private final String codec;
    private final boolean enableItn;
    private final boolean enableTimestamp;
    private final String formatType;
    private final List<String> hotwords;
    private final String language;
    private final String modelName;
    private final Integer sampleRate;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final Integer positiveIntOrNull(p6.c cVar, String key) {
            cVar.getClass();
            kotlin.jvm.internal.g.f(key, "key");
            JSONObject jSONObject = cVar.f11439a;
            if (!jSONObject.has(key)) {
                return null;
            }
            int iOptInt = jSONObject.optInt(key, 0);
            Integer numValueOf = Integer.valueOf(iOptInt);
            if (iOptInt > 0) {
                return numValueOf;
            }
            return null;
        }

        private final String stringOrNull(p6.c cVar, String key) {
            cVar.getClass();
            kotlin.jvm.internal.g.f(key, "key");
            if (!cVar.f11439a.has(key)) {
                return null;
            }
            String strB = cVar.b(key, "");
            if (gc.q.t0(strB)) {
                return null;
            }
            return strB;
        }

        public final String formatTypeOf(p6.c sseParams, String probed) {
            kotlin.jvm.internal.g.f(sseParams, "sseParams");
            kotlin.jvm.internal.g.f(probed, "probed");
            if (!gc.q.t0(probed)) {
                return probed;
            }
            String strStringOrNull = AsrSseRequest.Companion.stringOrNull(sseParams.a("format"), FileResponse.FIELD_TYPE);
            return strStringOrNull == null ? "" : strStringOrNull;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, kotlin.collections.EmptyList] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final AsrSseRequest fromConfig(p6.c sseParams, String audioData, String formatType, String str, Integer num, Integer num2, Integer num3) {
            kotlin.jvm.internal.g.f(sseParams, "sseParams");
            kotlin.jvm.internal.g.f(audioData, "audioData");
            kotlin.jvm.internal.g.f(formatType, "formatType");
            p6.c cVarA = sseParams.a("transcription");
            p6.c cVarA2 = sseParams.a("format");
            String strB = cVarA.b(ModelManifest.TYPE_MODEL, "stepaudio-2.5-asr");
            JSONObject jSONObject = cVarA.f11439a;
            String strB2 = cVarA.b("language", "zh");
            String typeOf = formatTypeOf(sseParams, formatType);
            String strStringOrNull = str == null ? stringOrNull(cVarA2, "codec") : str;
            Integer numPositiveIntOrNull = num == null ? positiveIntOrNull(cVarA2, "rate") : num;
            Integer numPositiveIntOrNull2 = num2 == null ? positiveIntOrNull(cVarA2, "bits") : num2;
            Integer numPositiveIntOrNull3 = num3 == null ? positiveIntOrNull(cVarA2, "channel") : num3;
            boolean zOptBoolean = jSONObject.optBoolean("enable_itn", true);
            boolean zOptBoolean2 = jSONObject.optBoolean("enable_timestamp", false);
            List arrayList = EmptyList.f10001a;
            kotlin.jvm.internal.g.f(arrayList, "default");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("hotwords");
            if (jSONArrayOptJSONArray != null) {
                arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                int length = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i10, "");
                    kotlin.jvm.internal.g.c(strOptString);
                    if (!gc.q.t0(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
            }
            return new AsrSseRequest(audioData, strB, strB2, typeOf, strStringOrNull, numPositiveIntOrNull, numPositiveIntOrNull2, numPositiveIntOrNull3, zOptBoolean, zOptBoolean2, arrayList);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class JsonTemplate {
        private final String prefix;
        private final String suffix;

        public JsonTemplate(String prefix, String suffix) {
            kotlin.jvm.internal.g.f(prefix, "prefix");
            kotlin.jvm.internal.g.f(suffix, "suffix");
            this.prefix = prefix;
            this.suffix = suffix;
        }

        public static /* synthetic */ JsonTemplate copy$default(JsonTemplate jsonTemplate, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = jsonTemplate.prefix;
            }
            if ((i10 & 2) != 0) {
                str2 = jsonTemplate.suffix;
            }
            return jsonTemplate.copy(str, str2);
        }

        public final String component1() {
            return this.prefix;
        }

        public final String component2() {
            return this.suffix;
        }

        public final JsonTemplate copy(String prefix, String suffix) {
            kotlin.jvm.internal.g.f(prefix, "prefix");
            kotlin.jvm.internal.g.f(suffix, "suffix");
            return new JsonTemplate(prefix, suffix);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JsonTemplate)) {
                return false;
            }
            JsonTemplate jsonTemplate = (JsonTemplate) obj;
            return kotlin.jvm.internal.g.b(this.prefix, jsonTemplate.prefix) && kotlin.jvm.internal.g.b(this.suffix, jsonTemplate.suffix);
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public int hashCode() {
            return this.suffix.hashCode() + (this.prefix.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("JsonTemplate(prefix=", this.prefix, ", suffix=", this.suffix, ")");
        }
    }

    public AsrSseRequest(String audioData, String modelName, String language, String formatType, String str, Integer num, Integer num2, Integer num3, boolean z, boolean z3, List<String> hotwords) {
        kotlin.jvm.internal.g.f(audioData, "audioData");
        kotlin.jvm.internal.g.f(modelName, "modelName");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(formatType, "formatType");
        kotlin.jvm.internal.g.f(hotwords, "hotwords");
        this.audioData = audioData;
        this.modelName = modelName;
        this.language = language;
        this.formatType = formatType;
        this.codec = str;
        this.sampleRate = num;
        this.bits = num2;
        this.channel = num3;
        this.enableItn = z;
        this.enableTimestamp = z3;
        this.hotwords = hotwords;
    }

    public static /* synthetic */ AsrSseRequest copy$default(AsrSseRequest asrSseRequest, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, Integer num3, boolean z, boolean z3, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = asrSseRequest.audioData;
        }
        if ((i10 & 2) != 0) {
            str2 = asrSseRequest.modelName;
        }
        if ((i10 & 4) != 0) {
            str3 = asrSseRequest.language;
        }
        if ((i10 & 8) != 0) {
            str4 = asrSseRequest.formatType;
        }
        if ((i10 & 16) != 0) {
            str5 = asrSseRequest.codec;
        }
        if ((i10 & 32) != 0) {
            num = asrSseRequest.sampleRate;
        }
        if ((i10 & 64) != 0) {
            num2 = asrSseRequest.bits;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            num3 = asrSseRequest.channel;
        }
        if ((i10 & 256) != 0) {
            z = asrSseRequest.enableItn;
        }
        if ((i10 & VadSessionManager.FRAME_BYTES) != 0) {
            z3 = asrSseRequest.enableTimestamp;
        }
        if ((i10 & 1024) != 0) {
            list = asrSseRequest.hotwords;
        }
        boolean z10 = z3;
        List list2 = list;
        Integer num4 = num3;
        boolean z11 = z;
        Integer num5 = num;
        Integer num6 = num2;
        String str6 = str5;
        String str7 = str3;
        return asrSseRequest.copy(str, str2, str7, str4, str6, num5, num6, num4, z11, z10, list2);
    }

    public static /* synthetic */ JsonTemplate toJsonTemplate$default(AsrSseRequest asrSseRequest, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = AUDIO_DATA_SENTINEL;
        }
        return asrSseRequest.toJsonTemplate(str);
    }

    public final String component1() {
        return this.audioData;
    }

    public final boolean component10() {
        return this.enableTimestamp;
    }

    public final List<String> component11() {
        return this.hotwords;
    }

    public final String component2() {
        return this.modelName;
    }

    public final String component3() {
        return this.language;
    }

    public final String component4() {
        return this.formatType;
    }

    public final String component5() {
        return this.codec;
    }

    public final Integer component6() {
        return this.sampleRate;
    }

    public final Integer component7() {
        return this.bits;
    }

    public final Integer component8() {
        return this.channel;
    }

    public final boolean component9() {
        return this.enableItn;
    }

    public final AsrSseRequest copy(String audioData, String modelName, String language, String formatType, String str, Integer num, Integer num2, Integer num3, boolean z, boolean z3, List<String> hotwords) {
        kotlin.jvm.internal.g.f(audioData, "audioData");
        kotlin.jvm.internal.g.f(modelName, "modelName");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(formatType, "formatType");
        kotlin.jvm.internal.g.f(hotwords, "hotwords");
        return new AsrSseRequest(audioData, modelName, language, formatType, str, num, num2, num3, z, z3, hotwords);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrSseRequest)) {
            return false;
        }
        AsrSseRequest asrSseRequest = (AsrSseRequest) obj;
        return kotlin.jvm.internal.g.b(this.audioData, asrSseRequest.audioData) && kotlin.jvm.internal.g.b(this.modelName, asrSseRequest.modelName) && kotlin.jvm.internal.g.b(this.language, asrSseRequest.language) && kotlin.jvm.internal.g.b(this.formatType, asrSseRequest.formatType) && kotlin.jvm.internal.g.b(this.codec, asrSseRequest.codec) && kotlin.jvm.internal.g.b(this.sampleRate, asrSseRequest.sampleRate) && kotlin.jvm.internal.g.b(this.bits, asrSseRequest.bits) && kotlin.jvm.internal.g.b(this.channel, asrSseRequest.channel) && this.enableItn == asrSseRequest.enableItn && this.enableTimestamp == asrSseRequest.enableTimestamp && kotlin.jvm.internal.g.b(this.hotwords, asrSseRequest.hotwords);
    }

    public final String getAudioData() {
        return this.audioData;
    }

    public final Integer getBits() {
        return this.bits;
    }

    public final Integer getChannel() {
        return this.channel;
    }

    public final String getCodec() {
        return this.codec;
    }

    public final boolean getEnableItn() {
        return this.enableItn;
    }

    public final boolean getEnableTimestamp() {
        return this.enableTimestamp;
    }

    public final String getFormatType() {
        return this.formatType;
    }

    public final List<String> getHotwords() {
        return this.hotwords;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final Integer getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        int iA = v1.d.a(v1.d.a(v1.d.a(this.audioData.hashCode() * 31, 31, this.modelName), 31, this.language), 31, this.formatType);
        String str = this.codec;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.sampleRate;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.bits;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.channel;
        return this.hotwords.hashCode() + ai.onnxruntime.a.f(ai.onnxruntime.a.f((iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31, 31, this.enableItn), 31, this.enableTimestamp);
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", this.audioData);
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(ModelManifest.TYPE_MODEL, this.modelName);
        jSONObject4.put("language", this.language);
        jSONObject4.put("enable_itn", this.enableItn);
        jSONObject4.put("enable_timestamp", this.enableTimestamp);
        if (!this.hotwords.isEmpty()) {
            jSONObject4.put("hotwords", new JSONArray((Collection) this.hotwords));
        }
        lb.n nVar = lb.n.f10413a;
        jSONObject3.put("transcription", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        if (!gc.q.t0(this.formatType)) {
            jSONObject5.put(FileResponse.FIELD_TYPE, this.formatType);
        }
        String str = this.codec;
        if (str != null) {
            jSONObject5.put("codec", str);
        }
        Integer num = this.sampleRate;
        if (num != null) {
            jSONObject5.put("rate", num.intValue());
        }
        Integer num2 = this.bits;
        if (num2 != null) {
            jSONObject5.put("bits", num2.intValue());
        }
        Integer num3 = this.channel;
        if (num3 != null) {
            jSONObject5.put("channel", num3.intValue());
        }
        jSONObject3.put("format", jSONObject5);
        jSONObject2.put("input", jSONObject3);
        jSONObject.put("audio", jSONObject2);
        return jSONObject;
    }

    public final JsonTemplate toJsonTemplate(String audioDataPlaceholder) {
        kotlin.jvm.internal.g.f(audioDataPlaceholder, "audioDataPlaceholder");
        String string = copy$default(this, audioDataPlaceholder, null, null, null, null, null, null, null, false, false, null, 2046, null).toJson().toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        int iR0 = gc.q.r0(string, audioDataPlaceholder, 0, false, 6);
        if (iR0 < 0) {
            throw new IllegalArgumentException("audio.data sentinel not found in serialized request");
        }
        String strSubstring = string.substring(0, iR0);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        String strSubstring2 = string.substring(audioDataPlaceholder.length() + iR0);
        kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
        return new JsonTemplate(strSubstring, strSubstring2);
    }

    public String toString() {
        String str = this.audioData;
        String str2 = this.modelName;
        String str3 = this.language;
        String str4 = this.formatType;
        String str5 = this.codec;
        Integer num = this.sampleRate;
        Integer num2 = this.bits;
        Integer num3 = this.channel;
        boolean z = this.enableItn;
        boolean z3 = this.enableTimestamp;
        List<String> list = this.hotwords;
        StringBuilder sbS = ai.onnxruntime.a.s("AsrSseRequest(audioData=", str, ", modelName=", str2, ", language=");
        ai.onnxruntime.a.z(sbS, str3, ", formatType=", str4, ", codec=");
        sbS.append(str5);
        sbS.append(", sampleRate=");
        sbS.append(num);
        sbS.append(", bits=");
        sbS.append(num2);
        sbS.append(", channel=");
        sbS.append(num3);
        sbS.append(", enableItn=");
        sbS.append(z);
        sbS.append(", enableTimestamp=");
        sbS.append(z3);
        sbS.append(", hotwords=");
        sbS.append(list);
        sbS.append(")");
        return sbS.toString();
    }

    public AsrSseRequest(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, Integer num3, boolean z, boolean z3, List list, int i10, kotlin.jvm.internal.e eVar) {
        this(str, str2, (i10 & 4) != 0 ? "zh" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : num, (i10 & 64) != 0 ? null : num2, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : num3, (i10 & 256) != 0 ? true : z, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? false : z3, (i10 & 1024) != 0 ? EmptyList.f10001a : list);
    }
}
