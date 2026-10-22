package com.stepos.core.ability;

import Z8.C1173v;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/core/ability/AbilityType;", "", "<init>", "()V", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityType {
    public static final String ANOMALY_DETECTION = "anomaly_detection";
    public static final String ASR = "asr";
    public static final String AUDIO = "audio";
    public static final String CHAT = "chat";
    public static final String CODE = "code";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DOCUMENT = "document";
    public static final String IMAGE = "image";
    public static final String IMAGE_GENERATION = "image_generation";
    public static final String MATH = "math";
    public static final String MULTIMODAL = "multimodal";
    public static final String NER = "ner";
    public static final String QA = "qa";
    public static final String RECOMMENDATION = "recommendation";
    public static final String SENTIMENT = "sentiment";
    public static final String SUMMARIZATION = "summarization";
    public static final String TEXT = "text";
    public static final String TEXT_GENERATION = "text_generation";
    public static final String TRANSLATION = "translation";
    public static final String TTS = "tts";
    public static final String VIDEO = "video";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/stepos/core/ability/AbilityType$Companion;", "", "<init>", "()V", "TEXT", "", "IMAGE", "AUDIO", "VIDEO", "MULTIMODAL", "CHAT", "TRANSLATION", "CODE", "DOCUMENT", "MATH", "QA", "SUMMARIZATION", "SENTIMENT", "NER", "TEXT_GENERATION", "IMAGE_GENERATION", "TTS", "ASR", "RECOMMENDATION", "ANOMALY_DETECTION", "getAllTypes", "", "isValidType", "", "type", "getTypeDescription", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final List<String> getAllTypes() {
            return C1173v.p("text", "image", "audio", "video", AbilityType.MULTIMODAL, AbilityType.CHAT, AbilityType.TRANSLATION, "code", "document", AbilityType.MATH, AbilityType.QA, AbilityType.SUMMARIZATION, AbilityType.SENTIMENT, AbilityType.NER, AbilityType.TEXT_GENERATION, AbilityType.IMAGE_GENERATION, "tts", AbilityType.ASR, AbilityType.RECOMMENDATION, AbilityType.ANOMALY_DETECTION);
        }

        public final String getTypeDescription(String type) {
            p.i(type, "type");
            switch (type.hashCode()) {
                case -1840647503:
                    return !type.equals(AbilityType.TRANSLATION) ? "未知能力类型" : "翻译处理能力：支持文本、语音、图像翻译等";
                case -1355907460:
                    return !type.equals(AbilityType.IMAGE_GENERATION) ? "未知能力类型" : "图像生成能力：支持文生图、图生图等";
                case -1028636743:
                    return !type.equals(AbilityType.RECOMMENDATION) ? "未知能力类型" : "推荐系统能力：支持个性化推荐等";
                case -713761719:
                    return !type.equals(AbilityType.ANOMALY_DETECTION) ? "未知能力类型" : "异常检测能力：支持异常行为检测等";
                case 3600:
                    return !type.equals(AbilityType.QA) ? "未知能力类型" : "知识问答能力：支持事实问答、知识检索等";
                case 96896:
                    return !type.equals(AbilityType.ASR) ? "未知能力类型" : "语音识别能力：支持语音转文本、指令识别等";
                case 108955:
                    return !type.equals(AbilityType.NER) ? "未知能力类型" : "实体识别能力：支持命名实体识别、关系抽取等";
                case 115187:
                    return !type.equals("tts") ? "未知能力类型" : "语音合成能力：支持文本转语音、语音克隆等";
                case 3052376:
                    return !type.equals(AbilityType.CHAT) ? "未知能力类型" : "对话处理能力：支持智能对话、问答系统等";
                case 3059181:
                    return !type.equals("code") ? "未知能力类型" : "代码处理能力：支持代码生成、补全、解释等";
                case 3344136:
                    return !type.equals(AbilityType.MATH) ? "未知能力类型" : "数学处理能力：支持数学计算、公式识别等";
                case 3556653:
                    return !type.equals("text") ? "未知能力类型" : "文本处理能力：支持文本生成、分类、情感分析等";
                case 93166550:
                    return !type.equals("audio") ? "未知能力类型" : "音频处理能力：支持语音识别、合成、分类等";
                case 100313435:
                    return !type.equals("image") ? "未知能力类型" : "图像处理能力：支持图像分类、检测、分割等";
                case 112202875:
                    return !type.equals("video") ? "未知能力类型" : "视频处理能力：支持视频分类、动作识别等";
                case 168859089:
                    return !type.equals(AbilityType.SUMMARIZATION) ? "未知能力类型" : "摘要生成能力：支持文本、视频摘要等";
                case 493807791:
                    return !type.equals(AbilityType.SENTIMENT) ? "未知能力类型" : "情感分析能力：支持情感分类、强度分析等";
                case 861720859:
                    return !type.equals("document") ? "未知能力类型" : "文档处理能力：支持文档理解、生成、摘要等";
                case 1262387476:
                    return !type.equals(AbilityType.MULTIMODAL) ? "未知能力类型" : "多模态处理能力：支持图文理解、跨模态检索等";
                case 1894624106:
                    return !type.equals(AbilityType.TEXT_GENERATION) ? "未知能力类型" : "文本生成能力：支持创意写作、内容生成等";
                default:
                    return "未知能力类型";
            }
        }

        public final boolean isValidType(String type) {
            p.i(type, "type");
            return getAllTypes().contains(type);
        }

        private Companion() {
        }
    }
}
