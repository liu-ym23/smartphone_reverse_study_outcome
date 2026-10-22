package com.stepos.aiengine.clients;

import C7.f;
import P3.d;
import com.stepos.aiengine.algorithm.asr.IAsrRecognition;
import com.stepos.aiengine.algorithm.chat.IChat;
import com.stepos.aiengine.algorithm.chineseclip.IChineseClip;
import com.stepos.aiengine.algorithm.embedding.IEmbedding;
import com.stepos.aiengine.algorithm.face.IFaceDetect;
import com.stepos.aiengine.algorithm.face.IFaceEmbed;
import com.stepos.aiengine.algorithm.face.IFaceQuality;
import com.stepos.aiengine.algorithm.guiagent.IGuiAgent;
import com.stepos.aiengine.algorithm.highlight.IHighlight;
import com.stepos.aiengine.algorithm.imagecaption.IImageCaption;
import com.stepos.aiengine.algorithm.imageextend.IImageExtend;
import com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint;
import com.stepos.aiengine.algorithm.imagematting.IImageMatting;
import com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment;
import com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard;
import com.stepos.aiengine.algorithm.reranking.IReranking;
import com.stepos.aiengine.algorithm.superresolution.ISuperResolution;
import com.stepos.aiengine.algorithm.tts.ITTS;
import com.stepos.aiengine.algorithm.voice.ISpeechRecognition;
import com.stepos.aiengine.api.IAlgorithmSet;
import com.stepos.aiengine.client.AlgorithmClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00048\u0006¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000bR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000bR\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000bR\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000bR\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020.0\u00048\u0006¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000bR\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002050\u00048\u0006¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000bR\u001d\u0010<\u001a\b\u0012\u0004\u0012\u0002090\u00048\u0006¢\u0006\f\n\u0004\b:\u0010\t\u001a\u0004\b;\u0010\u000bR\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\u00048\u0006¢\u0006\f\n\u0004\b>\u0010\t\u001a\u0004\b?\u0010\u000bR\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u00048\u0006¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bC\u0010\u000bR\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00048\u0006¢\u0006\f\n\u0004\bF\u0010\t\u001a\u0004\bG\u0010\u000bR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020I0\u00048\u0006¢\u0006\f\n\u0004\bJ\u0010\t\u001a\u0004\bK\u0010\u000bR\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020M0\u00048\u0006¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bO\u0010\u000bR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0\u00048\u0006¢\u0006\f\n\u0004\bR\u0010\t\u001a\u0004\bS\u0010\u000bR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\bU\u0010\t\u001a\u0004\bV\u0010\u000bR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020X0\u00048\u0006¢\u0006\f\n\u0004\bY\u0010\t\u001a\u0004\bZ\u0010\u000bR\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0\u00048\u0006¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b^\u0010\u000bR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020`0\u00048\u0006¢\u0006\f\n\u0004\ba\u0010\t\u001a\u0004\bb\u0010\u000bR\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\bd\u0010\t\u001a\u0004\be\u0010\u000b¨\u0006g"}, d2 = {"Lcom/stepos/aiengine/clients/AlgorithmClients;", "", "", "algorithmName", "Lcom/stepos/aiengine/client/AlgorithmClient;", "of", "(Ljava/lang/String;)Lcom/stepos/aiengine/client/AlgorithmClient;", "Lcom/stepos/aiengine/algorithm/chat/IChat;", "a", "Lcom/stepos/aiengine/client/AlgorithmClient;", "getChat", "()Lcom/stepos/aiengine/client/AlgorithmClient;", "chat", "b", "getChatVision", "chatVision", "Lcom/stepos/aiengine/algorithm/highlight/IHighlight;", "c", "getHighlight", "highlight", "Lcom/stepos/aiengine/algorithm/privacyguard/IPrivacyGuard;", "d", "getPrivacyGuard", "privacyGuard", "Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "e", "getGuiAgent", "guiAgent", "f", "getSmsParse", "smsParse", "Lcom/stepos/aiengine/algorithm/embedding/IEmbedding;", "g", "getBgeEmbedding", "bgeEmbedding", "h", "getEmbedding", "embedding", "Lcom/stepos/aiengine/algorithm/reranking/IReranking;", "i", "getReranking", "reranking", "Lcom/stepos/aiengine/algorithm/imagematting/IImageMatting;", "j", "getImageMatting", "imageMatting", "Lcom/stepos/aiengine/algorithm/imageinpaint/IImageInpaint;", "k", "getImageInpaint", "imageInpaint", "l", "getImageInpaintAigc", "imageInpaintAigc", "Lcom/stepos/aiengine/algorithm/imageextend/IImageExtend;", "m", "getImageExtend", "imageExtend", "Lcom/stepos/aiengine/algorithm/interactivesegment/IInteractiveSegment;", "n", "getInteractiveSegment", "interactiveSegment", "Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "o", "getChineseClip", "chineseClip", "Lcom/stepos/aiengine/algorithm/voice/ISpeechRecognition;", "p", "getSpeechRecognition", "speechRecognition", "Lcom/stepos/aiengine/algorithm/asr/IAsrRecognition;", "q", "getAsr", "asr", "Lcom/stepos/aiengine/algorithm/face/IFaceDetect;", "r", "getFaceDetect", "faceDetect", "Lcom/stepos/aiengine/algorithm/face/IFaceEmbed;", "s", "getFaceEmbed", "faceEmbed", "Lcom/stepos/aiengine/algorithm/face/IFaceQuality;", "t", "getFaceQuality", "faceQuality", "u", "getMobileChat", "mobileChat", "Lcom/stepos/aiengine/algorithm/tts/ITTS;", "v", "getTts", "tts", "Lcom/stepos/aiengine/algorithm/superresolution/ISuperResolution;", "w", "getSuperResolution", "superResolution", "Lcom/stepos/aiengine/algorithm/imagecaption/IImageCaption;", "x", "getImageCaption", "imageCaption", "y", "getTaskClassify", "taskClassify", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlgorithmClients {
    public static final AlgorithmClients INSTANCE = new AlgorithmClients();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient chat;

    /* renamed from: b, reason: from kotlin metadata */
    public static final AlgorithmClient chatVision;

    /* renamed from: c, reason: from kotlin metadata */
    public static final AlgorithmClient highlight;

    /* renamed from: d, reason: from kotlin metadata */
    public static final AlgorithmClient privacyGuard;

    /* renamed from: e, reason: from kotlin metadata */
    public static final AlgorithmClient guiAgent;

    /* renamed from: f, reason: from kotlin metadata */
    public static final AlgorithmClient smsParse;

    /* renamed from: g, reason: from kotlin metadata */
    public static final AlgorithmClient bgeEmbedding;

    /* renamed from: h, reason: from kotlin metadata */
    public static final AlgorithmClient embedding;

    /* renamed from: i, reason: from kotlin metadata */
    public static final AlgorithmClient reranking;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient imageMatting;

    /* renamed from: k, reason: from kotlin metadata */
    public static final AlgorithmClient imageInpaint;

    /* renamed from: l, reason: from kotlin metadata */
    public static final AlgorithmClient imageInpaintAigc;

    /* renamed from: m, reason: from kotlin metadata */
    public static final AlgorithmClient imageExtend;

    /* renamed from: n, reason: from kotlin metadata */
    public static final AlgorithmClient interactiveSegment;

    /* renamed from: o, reason: from kotlin metadata */
    public static final AlgorithmClient chineseClip;

    /* renamed from: p, reason: from kotlin metadata */
    public static final AlgorithmClient speechRecognition;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient asr;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient faceDetect;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient faceEmbed;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient faceQuality;

    /* renamed from: u, reason: from kotlin metadata */
    public static final AlgorithmClient mobileChat;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient tts;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient superResolution;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient imageCaption;

    /* renamed from: y, reason: from kotlin metadata */
    public static final AlgorithmClient taskClassify;

    /* renamed from: z, reason: collision with root package name */
    public static final f f3523z;

    static {
        n nVar = m.f4928a;
        chat = new AlgorithmClient(nVar.b(IChat.class), IAlgorithmSet.ALGORITHM_CHAT);
        chatVision = new AlgorithmClient(nVar.b(IChat.class), IAlgorithmSet.ALGORITHM_CHAT_VISION);
        highlight = new AlgorithmClient(nVar.b(IHighlight.class), IAlgorithmSet.ALGORITHM_HIGHLIGHT);
        privacyGuard = new AlgorithmClient(nVar.b(IPrivacyGuard.class), IAlgorithmSet.ALGORITHM_PRIVACY_GUARD);
        guiAgent = new AlgorithmClient(nVar.b(IGuiAgent.class), IAlgorithmSet.ALGORITHM_GUI_AGENT);
        smsParse = new AlgorithmClient(nVar.b(IChat.class), IAlgorithmSet.ALGORITHM_SMS_PARSE);
        bgeEmbedding = new AlgorithmClient(nVar.b(IEmbedding.class), IAlgorithmSet.ALGORITHM_BGE_EMBEDDING);
        embedding = new AlgorithmClient(nVar.b(IEmbedding.class), IAlgorithmSet.ALGORITHM_EMBEDDING);
        reranking = new AlgorithmClient(nVar.b(IReranking.class), IAlgorithmSet.ALGORITHM_RERANKING);
        imageMatting = new AlgorithmClient(nVar.b(IImageMatting.class), IAlgorithmSet.ALGORITHM_IMAGE_MATTING);
        imageInpaint = new AlgorithmClient(nVar.b(IImageInpaint.class), IAlgorithmSet.ALGORITHM_IMAGE_INPAINT);
        imageInpaintAigc = new AlgorithmClient(nVar.b(IImageInpaint.class), IAlgorithmSet.ALGORITHM_IMAGE_INPAINT_AIGC);
        imageExtend = new AlgorithmClient(nVar.b(IImageExtend.class), IAlgorithmSet.ALGORITHM_IMAGE_EXTEND);
        interactiveSegment = new AlgorithmClient(nVar.b(IInteractiveSegment.class), IAlgorithmSet.ALGORITHM_INTERACTIVE_SEGMENT);
        chineseClip = new AlgorithmClient(nVar.b(IChineseClip.class), IAlgorithmSet.ALGORITHM_CHINESE_CLIP);
        speechRecognition = new AlgorithmClient(nVar.b(ISpeechRecognition.class), IAlgorithmSet.ALGORITHM_SPEECH_RECOGNITION);
        asr = new AlgorithmClient(nVar.b(IAsrRecognition.class), IAlgorithmSet.ALGORITHM_ASR);
        faceDetect = new AlgorithmClient(nVar.b(IFaceDetect.class), IAlgorithmSet.ALGORITHM_FACE_DETECT);
        faceEmbed = new AlgorithmClient(nVar.b(IFaceEmbed.class), IAlgorithmSet.ALGORITHM_FACE_EMBED);
        faceQuality = new AlgorithmClient(nVar.b(IFaceQuality.class), IAlgorithmSet.ALGORITHM_FACE_QUALITY);
        mobileChat = new AlgorithmClient(nVar.b(IChat.class), IAlgorithmSet.ALGORITHM_MOBILE_CHAT);
        tts = new AlgorithmClient(nVar.b(ITTS.class), IAlgorithmSet.ALGORITHM_TTS);
        superResolution = new AlgorithmClient(nVar.b(ISuperResolution.class), IAlgorithmSet.ALGORITHM_SUPER_RESOLUTION);
        imageCaption = new AlgorithmClient(nVar.b(IImageCaption.class), IAlgorithmSet.ALGORITHM_IMAGE_CAPTION);
        taskClassify = new AlgorithmClient(nVar.b(IChat.class), IAlgorithmSet.ALGORITHM_TASK_CLASSIFY);
        f3523z = a.a(new d(2));
    }

    public final AlgorithmClient<IAsrRecognition> getAsr() {
        return asr;
    }

    public final AlgorithmClient<IEmbedding> getBgeEmbedding() {
        return bgeEmbedding;
    }

    public final AlgorithmClient<IChat> getChat() {
        return chat;
    }

    public final AlgorithmClient<IChat> getChatVision() {
        return chatVision;
    }

    public final AlgorithmClient<IChineseClip> getChineseClip() {
        return chineseClip;
    }

    public final AlgorithmClient<IEmbedding> getEmbedding() {
        return embedding;
    }

    public final AlgorithmClient<IFaceDetect> getFaceDetect() {
        return faceDetect;
    }

    public final AlgorithmClient<IFaceEmbed> getFaceEmbed() {
        return faceEmbed;
    }

    public final AlgorithmClient<IFaceQuality> getFaceQuality() {
        return faceQuality;
    }

    public final AlgorithmClient<IGuiAgent> getGuiAgent() {
        return guiAgent;
    }

    public final AlgorithmClient<IHighlight> getHighlight() {
        return highlight;
    }

    public final AlgorithmClient<IImageCaption> getImageCaption() {
        return imageCaption;
    }

    public final AlgorithmClient<IImageExtend> getImageExtend() {
        return imageExtend;
    }

    public final AlgorithmClient<IImageInpaint> getImageInpaint() {
        return imageInpaint;
    }

    public final AlgorithmClient<IImageInpaint> getImageInpaintAigc() {
        return imageInpaintAigc;
    }

    public final AlgorithmClient<IImageMatting> getImageMatting() {
        return imageMatting;
    }

    public final AlgorithmClient<IInteractiveSegment> getInteractiveSegment() {
        return interactiveSegment;
    }

    public final AlgorithmClient<IChat> getMobileChat() {
        return mobileChat;
    }

    public final AlgorithmClient<IPrivacyGuard> getPrivacyGuard() {
        return privacyGuard;
    }

    public final AlgorithmClient<IReranking> getReranking() {
        return reranking;
    }

    public final AlgorithmClient<IChat> getSmsParse() {
        return smsParse;
    }

    public final AlgorithmClient<ISpeechRecognition> getSpeechRecognition() {
        return speechRecognition;
    }

    public final AlgorithmClient<ISuperResolution> getSuperResolution() {
        return superResolution;
    }

    public final AlgorithmClient<IChat> getTaskClassify() {
        return taskClassify;
    }

    public final AlgorithmClient<ITTS> getTts() {
        return tts;
    }

    public final AlgorithmClient<?> of(String algorithmName) {
        k.f(algorithmName, "algorithmName");
        return (AlgorithmClient) ((Map) f3523z.getF4884a()).get(algorithmName);
    }
}
