package com.stepos.aiengine.api;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b&\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0007J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/stepos/aiengine/api/IAlgorithmSet;", "", "<init>", "()V", "ALGORITHM_CHAT", "", "ALGORITHM_CHAT_VISION", "ALGORITHM_HIGHLIGHT", "ALGORITHM_PRIVACY_GUARD", "ALGORITHM_COMPSMOOTH", "ALGORITHM_GUI_AGENT", "ALGORITHM_PERCEPTION", "ALGORITHM_SMS_PARSE", "ALGORITHM_EMBEDDING", "ALGORITHM_BGE_EMBEDDING", "ALGORITHM_RERANKING", "ALGORITHM_IMAGE_MATTING", "ALGORITHM_IMAGE_INPAINT", "ALGORITHM_IMAGE_INPAINT_AIGC", "ALGORITHM_IMAGE_EXTEND", "ALGORITHM_INTERACTIVE_SEGMENT", "ALGORITHM_CHINESE_CLIP", "ALGORITHM_ASR", "ALGORITHM_ASR_FILE", "ALGORITHM_ASR_REALTIME", "ALGORITHM_ASR_SSE", "ALGORITHM_VAD", "ALGORITHM_SLA", "ALGORITHM_TTS", "ALGORITHM_TTS_STREAM", "ALGORITHM_FACE_DETECT", "ALGORITHM_FACE_EMBED", "ALGORITHM_FACE_QUALITY", "ALGORITHM_IMAGE_CAPTION", "ALGORITHM_SUPER_RESOLUTION", "ALGORITHM_MOBILE_CHAT", "ALGORITHM_PRIVACY_CLASSIFY", "ALGORITHM_RISK_CLASSIFY", "getPluginName", "algorithm", "getPackageName", "ALGORITHM_TASK_CLASSIFY", "Chat", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IAlgorithmSet {
    public static final String ALGORITHM_ASR = "stepos-asr";
    public static final String ALGORITHM_ASR_FILE = "stepos-asr-file";
    public static final String ALGORITHM_ASR_REALTIME = "stepos-asr-realtime";
    public static final String ALGORITHM_ASR_SSE = "stepos-asr-sse";
    public static final String ALGORITHM_BGE_EMBEDDING = "bge-embedding";
    public static final String ALGORITHM_CHAT = "stepos-chat";
    public static final String ALGORITHM_CHAT_VISION = "stepos-chat-vision";
    public static final String ALGORITHM_CHINESE_CLIP = "stepos-chinese-clip";
    public static final String ALGORITHM_COMPSMOOTH = "stepos-compsmooth";
    public static final String ALGORITHM_EMBEDDING = "stepos-embedding";
    public static final String ALGORITHM_FACE_DETECT = "stepos-face-detect";
    public static final String ALGORITHM_FACE_EMBED = "stepos-face-embed";
    public static final String ALGORITHM_FACE_QUALITY = "stepos-face-quality";
    public static final String ALGORITHM_GUI_AGENT = "stepos-gui-agent";
    public static final String ALGORITHM_HIGHLIGHT = "stepos-highlight";
    public static final String ALGORITHM_IMAGE_CAPTION = "stepos-image-caption";
    public static final String ALGORITHM_IMAGE_EXTEND = "stepos-image-extend";
    public static final String ALGORITHM_IMAGE_INPAINT = "stepos-image-inpaint";
    public static final String ALGORITHM_IMAGE_INPAINT_AIGC = "stepos-image-inpaint-aigc";
    public static final String ALGORITHM_IMAGE_MATTING = "stepos-image-matting";
    public static final String ALGORITHM_INTERACTIVE_SEGMENT = "stepos-interactive-segment";
    public static final String ALGORITHM_MOBILE_CHAT = "mobile-chat";
    public static final String ALGORITHM_PERCEPTION = "stepos-perception";
    public static final String ALGORITHM_PRIVACY_CLASSIFY = "stepos-privacy-classify";
    public static final String ALGORITHM_PRIVACY_GUARD = "stepos-privacy-guard";
    public static final String ALGORITHM_RERANKING = "stepos-reranking";
    public static final String ALGORITHM_RISK_CLASSIFY = "stepos-risk-classify";
    public static final String ALGORITHM_SLA = "stepos-sla";
    public static final String ALGORITHM_SMS_PARSE = "stepos-sms-parse";
    public static final String ALGORITHM_SUPER_RESOLUTION = "stepos-super-resolution";
    public static final String ALGORITHM_TASK_CLASSIFY = "stepos-task-classify";
    public static final String ALGORITHM_TTS = "stepos-tts";
    public static final String ALGORITHM_TTS_STREAM = "stepos-tts-stream";
    public static final String ALGORITHM_VAD = "stepos-vad";
    public static final IAlgorithmSet INSTANCE = new IAlgorithmSet();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/aiengine/api/IAlgorithmSet$Chat;", "", "<init>", "()V", "PLUGIN_SMSPARSE", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Chat {
        public static final Chat INSTANCE = new Chat();
        public static final String PLUGIN_SMSPARSE = "smsparse";
    }

    public static final String getPackageName(String algorithm) {
        p.i(algorithm, "algorithm");
        return "com.stepos.aiengine";
    }

    public static final String getPluginName(String algorithm) {
        p.i(algorithm, "algorithm");
        return p.d(algorithm, ALGORITHM_CHAT) ? Chat.PLUGIN_SMSPARSE : "";
    }
}
