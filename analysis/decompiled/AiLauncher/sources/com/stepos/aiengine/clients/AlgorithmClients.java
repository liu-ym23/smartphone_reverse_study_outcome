package com.stepos.aiengine.clients;

import Y8.h;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.asr.IAsrFileRecognition;
import com.stepos.aiengine.algorithm.asr.IAsrRealtimeRecognition;
import com.stepos.aiengine.algorithm.asr.IAsrRecognition;
import com.stepos.aiengine.algorithm.asr.IAsrSseRecognition;
import com.stepos.aiengine.algorithm.chat.IChat;
import com.stepos.aiengine.algorithm.chineseclip.IChineseClip;
import com.stepos.aiengine.algorithm.compsmooth.ICompSmooth;
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
import com.stepos.aiengine.algorithm.perception.IPerception;
import com.stepos.aiengine.algorithm.privacyclassify.IPrivacyClassify;
import com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard;
import com.stepos.aiengine.algorithm.reranking.IReranking;
import com.stepos.aiengine.algorithm.riskclassify.IRiskClassify;
import com.stepos.aiengine.algorithm.sla.ISla;
import com.stepos.aiengine.algorithm.superresolution.ISuperResolution;
import com.stepos.aiengine.algorithm.tts.ITTS;
import com.stepos.aiengine.algorithm.tts.ITtsStreaming;
import com.stepos.aiengine.algorithm.vad.IVadDetection;
import com.stepos.aiengine.api.IAlgorithmSet;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AlgorithmClients;
import com.stepos.core.ability.AbilityType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00068\u0006¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\rR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u00068\u0006¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\rR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020)0\u00068\u0006¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\rR\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000\u00068\u0006¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\rR\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00068\u0006¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\rR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u00068\u0006¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\rR\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020<0\u00068\u0006¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\rR\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020@0\u00068\u0006¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020@0\u00068\u0006¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\rR\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020G0\u00068\u0006¢\u0006\f\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\rR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020K0\u00068\u0006¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bM\u0010\rR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020O0\u00068\u0006¢\u0006\f\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\rR\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020S0\u00068\u0006¢\u0006\f\n\u0004\bT\u0010\u000b\u001a\u0004\bU\u0010\rR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0\u00068\u0006¢\u0006\f\n\u0004\bX\u0010\u000b\u001a\u0004\bY\u0010\rR\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00068\u0006¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b]\u0010\rR\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020_0\u00068\u0006¢\u0006\f\n\u0004\b`\u0010\u000b\u001a\u0004\ba\u0010\rR\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020c0\u00068\u0006¢\u0006\f\n\u0004\bd\u0010\u000b\u001a\u0004\be\u0010\rR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020g0\u00068\u0006¢\u0006\f\n\u0004\bh\u0010\u000b\u001a\u0004\bi\u0010\rR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020k0\u00068\u0006¢\u0006\f\n\u0004\bl\u0010\u000b\u001a\u0004\bm\u0010\rR\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020o0\u00068\u0006¢\u0006\f\n\u0004\bp\u0010\u000b\u001a\u0004\bq\u0010\rR\u001d\u0010v\u001a\b\u0012\u0004\u0012\u00020s0\u00068\u0006¢\u0006\f\n\u0004\bt\u0010\u000b\u001a\u0004\bu\u0010\rR\u001d\u0010y\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\bw\u0010\u000b\u001a\u0004\bx\u0010\rR\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020z0\u00068\u0006¢\u0006\f\n\u0004\b{\u0010\u000b\u001a\u0004\b|\u0010\rR\u001f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020~0\u00068\u0006¢\u0006\r\n\u0004\b\u007f\u0010\u000b\u001a\u0005\b\u0080\u0001\u0010\rR!\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010\u00068\u0006¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u000b\u001a\u0005\b\u0084\u0001\u0010\rR!\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u00068\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u000b\u001a\u0005\b\u0088\u0001\u0010\rR \u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u000b\u001a\u0005\b\u008b\u0001\u0010\rR0\u0010\u0091\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0005\b\u0013\u0010\u0090\u0001¨\u0006\u0092\u0001"}, d2 = {"Lcom/stepos/aiengine/clients/AlgorithmClients;", "", "<init>", "()V", "", "algorithmName", "Lcom/stepos/aiengine/client/AlgorithmClient;", "of", "(Ljava/lang/String;)Lcom/stepos/aiengine/client/AlgorithmClient;", "Lcom/stepos/aiengine/algorithm/chat/IChat;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/aiengine/client/AlgorithmClient;", "getChat", "()Lcom/stepos/aiengine/client/AlgorithmClient;", AbilityType.CHAT, Const.INTENT_KEY_PKGNAME, "getChatVision", "chatVision", "Lcom/stepos/aiengine/algorithm/highlight/IHighlight;", "c", "getHighlight", "highlight", "Lcom/stepos/aiengine/algorithm/privacyguard/IPrivacyGuard;", Const.INTENT_KEY_UMID, "getPrivacyGuard", "privacyGuard", "Lcom/stepos/aiengine/algorithm/compsmooth/ICompSmooth;", "e", "getCompSmooth", "compSmooth", "Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "f", "getGuiAgent", "guiAgent", "Lcom/stepos/aiengine/algorithm/perception/IPerception;", Const.INTENT_KEY_BACKGROUND_COMMAND, "getPerception", "perception", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getSmsParse", "smsParse", "Lcom/stepos/aiengine/algorithm/embedding/IEmbedding;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "getBgeEmbedding", "bgeEmbedding", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "getEmbedding", "embedding", "Lcom/stepos/aiengine/algorithm/reranking/IReranking;", "k", "getReranking", "reranking", "Lcom/stepos/aiengine/algorithm/privacyclassify/IPrivacyClassify;", "l", "getPrivacyClassify", "privacyClassify", "Lcom/stepos/aiengine/algorithm/riskclassify/IRiskClassify;", "m", "getRiskClassify", "riskClassify", "Lcom/stepos/aiengine/algorithm/imagematting/IImageMatting;", "n", "getImageMatting", "imageMatting", "Lcom/stepos/aiengine/algorithm/imageinpaint/IImageInpaint;", "o", "getImageInpaint", "imageInpaint", "p", "getImageInpaintAigc", "imageInpaintAigc", "Lcom/stepos/aiengine/algorithm/imageextend/IImageExtend;", "q", "getImageExtend", "imageExtend", "Lcom/stepos/aiengine/algorithm/interactivesegment/IInteractiveSegment;", "r", "getInteractiveSegment", "interactiveSegment", "Lcom/stepos/aiengine/algorithm/chineseclip/IChineseClip;", "s", "getChineseClip", "chineseClip", "Lcom/stepos/aiengine/algorithm/asr/IAsrRecognition;", "t", "getAsr", AbilityType.ASR, "Lcom/stepos/aiengine/algorithm/asr/IAsrFileRecognition;", "u", "getAsrFile", "asrFile", "Lcom/stepos/aiengine/algorithm/asr/IAsrRealtimeRecognition;", "v", "getAsrRealtime", "asrRealtime", "Lcom/stepos/aiengine/algorithm/asr/IAsrSseRecognition;", "w", "getAsrSse", "asrSse", "Lcom/stepos/aiengine/algorithm/vad/IVadDetection;", "x", "getVad", "vad", "Lcom/stepos/aiengine/algorithm/sla/ISla;", "y", "getSla", "sla", "Lcom/stepos/aiengine/algorithm/face/IFaceDetect;", "z", "getFaceDetect", "faceDetect", "Lcom/stepos/aiengine/algorithm/face/IFaceEmbed;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getFaceEmbed", "faceEmbed", "Lcom/stepos/aiengine/algorithm/face/IFaceQuality;", "B", "getFaceQuality", "faceQuality", "C", "getMobileChat", "mobileChat", "Lcom/stepos/aiengine/algorithm/tts/ITTS;", "D", "getTts", "tts", "Lcom/stepos/aiengine/algorithm/tts/ITtsStreaming;", ExifInterface.LONGITUDE_EAST, "getTtsStream", "ttsStream", "Lcom/stepos/aiengine/algorithm/superresolution/ISuperResolution;", "F", "getSuperResolution", "superResolution", "Lcom/stepos/aiengine/algorithm/imagecaption/IImageCaption;", "G", "getImageCaption", "imageCaption", "H", "getTaskClassify", "taskClassify", "", "I", "LY8/h;", "()Ljava/util/Map;", "clientMap", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AlgorithmClients {
    public static final AlgorithmClients INSTANCE = new AlgorithmClients();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IChat> chat = new AlgorithmClient<>(t.b(IChat.class), IAlgorithmSet.ALGORITHM_CHAT);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IChat> chatVision = new AlgorithmClient<>(t.b(IChat.class), IAlgorithmSet.ALGORITHM_CHAT_VISION);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IHighlight> highlight = new AlgorithmClient<>(t.b(IHighlight.class), IAlgorithmSet.ALGORITHM_HIGHLIGHT);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IPrivacyGuard> privacyGuard = new AlgorithmClient<>(t.b(IPrivacyGuard.class), IAlgorithmSet.ALGORITHM_PRIVACY_GUARD);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<ICompSmooth> compSmooth = new AlgorithmClient<>(t.b(ICompSmooth.class), IAlgorithmSet.ALGORITHM_COMPSMOOTH);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IGuiAgent> guiAgent = new AlgorithmClient<>(t.b(IGuiAgent.class), IAlgorithmSet.ALGORITHM_GUI_AGENT);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IPerception> perception = new AlgorithmClient<>(t.b(IPerception.class), IAlgorithmSet.ALGORITHM_PERCEPTION);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IChat> smsParse = new AlgorithmClient<>(t.b(IChat.class), IAlgorithmSet.ALGORITHM_SMS_PARSE);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IEmbedding> bgeEmbedding = new AlgorithmClient<>(t.b(IEmbedding.class), IAlgorithmSet.ALGORITHM_BGE_EMBEDDING);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IEmbedding> embedding = new AlgorithmClient<>(t.b(IEmbedding.class), IAlgorithmSet.ALGORITHM_EMBEDDING);

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IReranking> reranking = new AlgorithmClient<>(t.b(IReranking.class), IAlgorithmSet.ALGORITHM_RERANKING);

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IPrivacyClassify> privacyClassify = new AlgorithmClient<>(t.b(IPrivacyClassify.class), IAlgorithmSet.ALGORITHM_PRIVACY_CLASSIFY);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IRiskClassify> riskClassify = new AlgorithmClient<>(t.b(IRiskClassify.class), IAlgorithmSet.ALGORITHM_RISK_CLASSIFY);

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IImageMatting> imageMatting = new AlgorithmClient<>(t.b(IImageMatting.class), IAlgorithmSet.ALGORITHM_IMAGE_MATTING);

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IImageInpaint> imageInpaint = new AlgorithmClient<>(t.b(IImageInpaint.class), IAlgorithmSet.ALGORITHM_IMAGE_INPAINT);

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IImageInpaint> imageInpaintAigc = new AlgorithmClient<>(t.b(IImageInpaint.class), IAlgorithmSet.ALGORITHM_IMAGE_INPAINT_AIGC);

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IImageExtend> imageExtend = new AlgorithmClient<>(t.b(IImageExtend.class), IAlgorithmSet.ALGORITHM_IMAGE_EXTEND);

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IInteractiveSegment> interactiveSegment = new AlgorithmClient<>(t.b(IInteractiveSegment.class), IAlgorithmSet.ALGORITHM_INTERACTIVE_SEGMENT);

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IChineseClip> chineseClip = new AlgorithmClient<>(t.b(IChineseClip.class), IAlgorithmSet.ALGORITHM_CHINESE_CLIP);

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IAsrRecognition> asr = new AlgorithmClient<>(t.b(IAsrRecognition.class), IAlgorithmSet.ALGORITHM_ASR);

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IAsrFileRecognition> asrFile = new AlgorithmClient<>(t.b(IAsrFileRecognition.class), IAlgorithmSet.ALGORITHM_ASR_FILE);

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IAsrRealtimeRecognition> asrRealtime = new AlgorithmClient<>(t.b(IAsrRealtimeRecognition.class), IAlgorithmSet.ALGORITHM_ASR_REALTIME);

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IAsrSseRecognition> asrSse = new AlgorithmClient<>(t.b(IAsrSseRecognition.class), IAlgorithmSet.ALGORITHM_ASR_SSE);

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IVadDetection> vad = new AlgorithmClient<>(t.b(IVadDetection.class), IAlgorithmSet.ALGORITHM_VAD);

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<ISla> sla = new AlgorithmClient<>(t.b(ISla.class), IAlgorithmSet.ALGORITHM_SLA);

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IFaceDetect> faceDetect = new AlgorithmClient<>(t.b(IFaceDetect.class), IAlgorithmSet.ALGORITHM_FACE_DETECT);

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IFaceEmbed> faceEmbed = new AlgorithmClient<>(t.b(IFaceEmbed.class), IAlgorithmSet.ALGORITHM_FACE_EMBED);

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IFaceQuality> faceQuality = new AlgorithmClient<>(t.b(IFaceQuality.class), IAlgorithmSet.ALGORITHM_FACE_QUALITY);

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IChat> mobileChat = new AlgorithmClient<>(t.b(IChat.class), IAlgorithmSet.ALGORITHM_MOBILE_CHAT);

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<ITTS> tts = new AlgorithmClient<>(t.b(ITTS.class), IAlgorithmSet.ALGORITHM_TTS);

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<ITtsStreaming> ttsStream = new AlgorithmClient<>(t.b(ITtsStreaming.class), IAlgorithmSet.ALGORITHM_TTS_STREAM);

    /* renamed from: F, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<ISuperResolution> superResolution = new AlgorithmClient<>(t.b(ISuperResolution.class), IAlgorithmSet.ALGORITHM_SUPER_RESOLUTION);

    /* renamed from: G, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IImageCaption> imageCaption = new AlgorithmClient<>(t.b(IImageCaption.class), IAlgorithmSet.ALGORITHM_IMAGE_CAPTION);

    /* renamed from: H, reason: collision with root package name and from kotlin metadata */
    public static final AlgorithmClient<IChat> taskClassify = new AlgorithmClient<>(t.b(IChat.class), IAlgorithmSet.ALGORITHM_TASK_CLASSIFY);

    /* renamed from: I, reason: collision with root package name and from kotlin metadata */
    public static final h clientMap = C4848b.b(new InterfaceC5063a() { // from class: P4.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AlgorithmClients.b();
        }
    });

    public static final Map b() {
        List listP = C1173v.p(chat, chatVision, highlight, privacyGuard, compSmooth, guiAgent, perception, smsParse, bgeEmbedding, embedding, reranking, privacyClassify, riskClassify, imageMatting, imageInpaint, imageInpaintAigc, imageExtend, interactiveSegment, chineseClip, asr, asrFile, asrRealtime, asrSse, sla, faceDetect, faceEmbed, faceQuality, mobileChat, tts, superResolution, imageCaption, taskClassify);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listP, 10)), 16));
        for (Object obj : listP) {
            linkedHashMap.put(((AlgorithmClient) obj).getAlgorithmId(), obj);
        }
        return linkedHashMap;
    }

    public final Map<String, AlgorithmClient<?>> c() {
        return (Map) clientMap.getValue();
    }

    public final AlgorithmClient<IAsrRecognition> getAsr() {
        return asr;
    }

    public final AlgorithmClient<IAsrFileRecognition> getAsrFile() {
        return asrFile;
    }

    public final AlgorithmClient<IAsrRealtimeRecognition> getAsrRealtime() {
        return asrRealtime;
    }

    public final AlgorithmClient<IAsrSseRecognition> getAsrSse() {
        return asrSse;
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

    public final AlgorithmClient<ICompSmooth> getCompSmooth() {
        return compSmooth;
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

    public final AlgorithmClient<IPerception> getPerception() {
        return perception;
    }

    public final AlgorithmClient<IPrivacyClassify> getPrivacyClassify() {
        return privacyClassify;
    }

    public final AlgorithmClient<IPrivacyGuard> getPrivacyGuard() {
        return privacyGuard;
    }

    public final AlgorithmClient<IReranking> getReranking() {
        return reranking;
    }

    public final AlgorithmClient<IRiskClassify> getRiskClassify() {
        return riskClassify;
    }

    public final AlgorithmClient<ISla> getSla() {
        return sla;
    }

    public final AlgorithmClient<IChat> getSmsParse() {
        return smsParse;
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

    public final AlgorithmClient<ITtsStreaming> getTtsStream() {
        return ttsStream;
    }

    public final AlgorithmClient<IVadDetection> getVad() {
        return vad;
    }

    public final AlgorithmClient<?> of(String algorithmName) {
        p.i(algorithmName, "algorithmName");
        return c().get(algorithmName);
    }
}
