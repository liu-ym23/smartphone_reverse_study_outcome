package com.stepos.core.ability.speech;

import com.stepos.core.common.util.TraceIdKeys;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFileRequest {
    public static final Companion Companion = new Companion(null);
    private final String audioUrl;
    private final int bits;
    private final int channel;
    private final String codec;
    private final boolean enableChannelSplit;
    private final boolean enableSpeakerEmbedding;
    private final boolean enableSpeakerInfo;
    private final String format;
    private final String modelName;
    private final String prompt;
    private final int sampleRate;
    private final boolean showUtterances;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final AsrFileRequest fromParams(String audioUrl, p6.c fileParams) {
            kotlin.jvm.internal.g.f(audioUrl, "audioUrl");
            kotlin.jvm.internal.g.f(fileParams, "fileParams");
            p6.c cVarA = fileParams.a("audio");
            p6.c cVarA2 = fileParams.a("request");
            String strB = cVarA.b("format", "");
            String strB2 = cVarA.b("codec", "");
            JSONObject jSONObject = cVarA.f11439a;
            int iOptInt = jSONObject.optInt("rate", 0);
            int iOptInt2 = jSONObject.optInt("bits", 0);
            int iOptInt3 = jSONObject.optInt("channel", 0);
            String strB3 = cVarA2.b("model_name", "");
            JSONObject jSONObject2 = cVarA2.f11439a;
            return new AsrFileRequest(audioUrl, strB, strB2, iOptInt, iOptInt2, iOptInt3, strB3, jSONObject2.optBoolean("enable_channel_split", false), jSONObject2.optBoolean("show_utterances", false), jSONObject2.optBoolean("enable_speaker_info", false), jSONObject2.optBoolean("enable_speaker_embedding", false), cVarA2.b("prompt", ""));
        }

        private Companion() {
        }
    }

    public AsrFileRequest(String audioUrl, String format, String codec, int i10, int i11, int i12, String modelName, boolean z, boolean z3, boolean z10, boolean z11, String prompt) {
        kotlin.jvm.internal.g.f(audioUrl, "audioUrl");
        kotlin.jvm.internal.g.f(format, "format");
        kotlin.jvm.internal.g.f(codec, "codec");
        kotlin.jvm.internal.g.f(modelName, "modelName");
        kotlin.jvm.internal.g.f(prompt, "prompt");
        this.audioUrl = audioUrl;
        this.format = format;
        this.codec = codec;
        this.sampleRate = i10;
        this.bits = i11;
        this.channel = i12;
        this.modelName = modelName;
        this.enableChannelSplit = z;
        this.showUtterances = z3;
        this.enableSpeakerInfo = z10;
        this.enableSpeakerEmbedding = z11;
        this.prompt = prompt;
    }

    public static /* synthetic */ AsrFileRequest copy$default(AsrFileRequest asrFileRequest, String str, String str2, String str3, int i10, int i11, int i12, String str4, boolean z, boolean z3, boolean z10, boolean z11, String str5, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = asrFileRequest.audioUrl;
        }
        if ((i13 & 2) != 0) {
            str2 = asrFileRequest.format;
        }
        if ((i13 & 4) != 0) {
            str3 = asrFileRequest.codec;
        }
        if ((i13 & 8) != 0) {
            i10 = asrFileRequest.sampleRate;
        }
        if ((i13 & 16) != 0) {
            i11 = asrFileRequest.bits;
        }
        if ((i13 & 32) != 0) {
            i12 = asrFileRequest.channel;
        }
        if ((i13 & 64) != 0) {
            str4 = asrFileRequest.modelName;
        }
        if ((i13 & TraceIdKeys.MAX_LENGTH) != 0) {
            z = asrFileRequest.enableChannelSplit;
        }
        if ((i13 & 256) != 0) {
            z3 = asrFileRequest.showUtterances;
        }
        if ((i13 & VadSessionManager.FRAME_BYTES) != 0) {
            z10 = asrFileRequest.enableSpeakerInfo;
        }
        if ((i13 & 1024) != 0) {
            z11 = asrFileRequest.enableSpeakerEmbedding;
        }
        if ((i13 & 2048) != 0) {
            str5 = asrFileRequest.prompt;
        }
        boolean z12 = z11;
        String str6 = str5;
        boolean z13 = z3;
        boolean z14 = z10;
        String str7 = str4;
        boolean z15 = z;
        int i14 = i11;
        int i15 = i12;
        return asrFileRequest.copy(str, str2, str3, i10, i14, i15, str7, z15, z13, z14, z12, str6);
    }

    public final String component1() {
        return this.audioUrl;
    }

    public final boolean component10() {
        return this.enableSpeakerInfo;
    }

    public final boolean component11() {
        return this.enableSpeakerEmbedding;
    }

    public final String component12() {
        return this.prompt;
    }

    public final String component2() {
        return this.format;
    }

    public final String component3() {
        return this.codec;
    }

    public final int component4() {
        return this.sampleRate;
    }

    public final int component5() {
        return this.bits;
    }

    public final int component6() {
        return this.channel;
    }

    public final String component7() {
        return this.modelName;
    }

    public final boolean component8() {
        return this.enableChannelSplit;
    }

    public final boolean component9() {
        return this.showUtterances;
    }

    public final AsrFileRequest copy(String audioUrl, String format, String codec, int i10, int i11, int i12, String modelName, boolean z, boolean z3, boolean z10, boolean z11, String prompt) {
        kotlin.jvm.internal.g.f(audioUrl, "audioUrl");
        kotlin.jvm.internal.g.f(format, "format");
        kotlin.jvm.internal.g.f(codec, "codec");
        kotlin.jvm.internal.g.f(modelName, "modelName");
        kotlin.jvm.internal.g.f(prompt, "prompt");
        return new AsrFileRequest(audioUrl, format, codec, i10, i11, i12, modelName, z, z3, z10, z11, prompt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrFileRequest)) {
            return false;
        }
        AsrFileRequest asrFileRequest = (AsrFileRequest) obj;
        return kotlin.jvm.internal.g.b(this.audioUrl, asrFileRequest.audioUrl) && kotlin.jvm.internal.g.b(this.format, asrFileRequest.format) && kotlin.jvm.internal.g.b(this.codec, asrFileRequest.codec) && this.sampleRate == asrFileRequest.sampleRate && this.bits == asrFileRequest.bits && this.channel == asrFileRequest.channel && kotlin.jvm.internal.g.b(this.modelName, asrFileRequest.modelName) && this.enableChannelSplit == asrFileRequest.enableChannelSplit && this.showUtterances == asrFileRequest.showUtterances && this.enableSpeakerInfo == asrFileRequest.enableSpeakerInfo && this.enableSpeakerEmbedding == asrFileRequest.enableSpeakerEmbedding && kotlin.jvm.internal.g.b(this.prompt, asrFileRequest.prompt);
    }

    public final String getAudioUrl() {
        return this.audioUrl;
    }

    public final int getBits() {
        return this.bits;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final String getCodec() {
        return this.codec;
    }

    public final boolean getEnableChannelSplit() {
        return this.enableChannelSplit;
    }

    public final boolean getEnableSpeakerEmbedding() {
        return this.enableSpeakerEmbedding;
    }

    public final boolean getEnableSpeakerInfo() {
        return this.enableSpeakerInfo;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final boolean getShowUtterances() {
        return this.showUtterances;
    }

    public int hashCode() {
        return this.prompt.hashCode() + ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.f(v1.d.a(ai.onnxruntime.a.d(this.channel, ai.onnxruntime.a.d(this.bits, ai.onnxruntime.a.d(this.sampleRate, v1.d.a(v1.d.a(this.audioUrl.hashCode() * 31, 31, this.format), 31, this.codec), 31), 31), 31), 31, this.modelName), 31, this.enableChannelSplit), 31, this.showUtterances), 31, this.enableSpeakerInfo), 31, this.enableSpeakerEmbedding);
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("format", this.format);
        jSONObject2.put("codec", this.codec);
        jSONObject2.put("url", this.audioUrl);
        if (kotlin.jvm.internal.g.b(this.format, "raw")) {
            jSONObject2.put("rate", this.sampleRate);
            jSONObject2.put("bits", this.bits);
            jSONObject2.put("channel", this.channel);
        }
        lb.n nVar = lb.n.f10413a;
        jSONObject.put("audio", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("model_name", this.modelName);
        jSONObject3.put("enable_channel_split", this.enableChannelSplit);
        jSONObject3.put("show_utterances", this.showUtterances);
        jSONObject3.put("enable_speaker_info", this.enableSpeakerInfo);
        jSONObject3.put("enable_speaker_embedding", this.enableSpeakerEmbedding);
        if (this.prompt.length() > 0) {
            jSONObject3.put("prompt", this.prompt);
        }
        jSONObject.put("request", jSONObject3);
        return jSONObject;
    }

    public String toString() {
        String str = this.audioUrl;
        String str2 = this.format;
        String str3 = this.codec;
        int i10 = this.sampleRate;
        int i11 = this.bits;
        int i12 = this.channel;
        String str4 = this.modelName;
        boolean z = this.enableChannelSplit;
        boolean z3 = this.showUtterances;
        boolean z10 = this.enableSpeakerInfo;
        boolean z11 = this.enableSpeakerEmbedding;
        String str5 = this.prompt;
        StringBuilder sbS = ai.onnxruntime.a.s("AsrFileRequest(audioUrl=", str, ", format=", str2, ", codec=");
        com.stepos.core.ota.d.o(i10, str3, ", sampleRate=", ", bits=", sbS);
        h0.e.l(sbS, i11, ", channel=", i12, ", modelName=");
        sbS.append(str4);
        sbS.append(", enableChannelSplit=");
        sbS.append(z);
        sbS.append(", showUtterances=");
        sbS.append(z3);
        sbS.append(", enableSpeakerInfo=");
        sbS.append(z10);
        sbS.append(", enableSpeakerEmbedding=");
        sbS.append(z11);
        sbS.append(", prompt=");
        sbS.append(str5);
        sbS.append(")");
        return sbS.toString();
    }

    public /* synthetic */ AsrFileRequest(String str, String str2, String str3, int i10, int i11, int i12, String str4, boolean z, boolean z3, boolean z10, boolean z11, String str5, int i13, kotlin.jvm.internal.e eVar) {
        this(str, (i13 & 2) != 0 ? "" : str2, (i13 & 4) != 0 ? "" : str3, (i13 & 8) != 0 ? 0 : i10, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? 0 : i12, (i13 & 64) != 0 ? "" : str4, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? false : z, (i13 & 256) != 0 ? false : z3, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? false : z10, (i13 & 1024) == 0 ? z11 : false, (i13 & 2048) != 0 ? "" : str5);
    }
}
