package com.stepos.aiengine.api;

import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\bR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\b¨\u0006#"}, d2 = {"Lcom/stepos/aiengine/api/IAlgorithmSet;", "", "", "algorithm", "getPluginName", "(Ljava/lang/String;)Ljava/lang/String;", "getPackageName", "ALGORITHM_CHAT", "Ljava/lang/String;", "ALGORITHM_CHAT_VISION", "ALGORITHM_HIGHLIGHT", "ALGORITHM_PRIVACY_GUARD", "ALGORITHM_GUI_AGENT", "ALGORITHM_SMS_PARSE", "ALGORITHM_EMBEDDING", "ALGORITHM_BGE_EMBEDDING", "ALGORITHM_RERANKING", "ALGORITHM_IMAGE_MATTING", "ALGORITHM_IMAGE_INPAINT", "ALGORITHM_IMAGE_INPAINT_AIGC", "ALGORITHM_IMAGE_EXTEND", "ALGORITHM_INTERACTIVE_SEGMENT", "ALGORITHM_CHINESE_CLIP", "ALGORITHM_SPEECH_RECOGNITION", "ALGORITHM_ASR", "ALGORITHM_TTS", "ALGORITHM_FACE_DETECT", "ALGORITHM_FACE_EMBED", "ALGORITHM_FACE_QUALITY", "ALGORITHM_IMAGE_CAPTION", "ALGORITHM_SUPER_RESOLUTION", "ALGORITHM_MOBILE_CHAT", "ALGORITHM_TASK_CLASSIFY", "ALGORITHM_CHAT_V73", BffConstant.Cmd.Chat, "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IAlgorithmSet {
    public static final String ALGORITHM_ASR = "stepos-asr";
    public static final String ALGORITHM_BGE_EMBEDDING = "bge-embedding";
    public static final String ALGORITHM_CHAT = "stepos-chat";
    public static final String ALGORITHM_CHAT_V73 = "chat-v73";
    public static final String ALGORITHM_CHAT_VISION = "stepos-chat-vision";
    public static final String ALGORITHM_CHINESE_CLIP = "stepos-chinese-clip";
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
    public static final String ALGORITHM_PRIVACY_GUARD = "stepos-privacy-guard";
    public static final String ALGORITHM_RERANKING = "stepos-reranking";
    public static final String ALGORITHM_SMS_PARSE = "stepos-sms-parse";
    public static final String ALGORITHM_SPEECH_RECOGNITION = "stepos-speech-recognition";
    public static final String ALGORITHM_SUPER_RESOLUTION = "stepos-super-resolution";
    public static final String ALGORITHM_TASK_CLASSIFY = "stepos-task-classify";
    public static final String ALGORITHM_TTS = "stepos-tts";
    public static final IAlgorithmSet INSTANCE = new IAlgorithmSet();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/aiengine/api/IAlgorithmSet$Chat;", "", "", "PLUGIN_SMSPARSE", "Ljava/lang/String;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Chat {
        public static final Chat INSTANCE = new Chat();
        public static final String PLUGIN_SMSPARSE = "smsparse";
    }

    public static final String getPackageName(String algorithm) {
        k.f(algorithm, "algorithm");
        return "com.stepos.aiengine";
    }

    public static final String getPluginName(String algorithm) {
        k.f(algorithm, "algorithm");
        return algorithm.equals(ALGORITHM_CHAT) ? Chat.PLUGIN_SMSPARSE : "";
    }
}
