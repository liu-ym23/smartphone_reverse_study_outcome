package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import com.mammon.audiosdk.session.type.ResponseEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\bK\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bL¨\u0006M"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreCallBackEventType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TTS_Started", "TTS_GetResulted", "TTS_Finished", "TTS_Failed", "TTS_WebSocketStateChanged", "ASR_Started", "ASR_GetResulted", "ASR_Finished", "ASR_Failed", "ASR_WebSocketStateChanged", "VC_Started", "VC_GetResulted", "VC_Finished", "VC_Failed", "VC_WebSocketStateChanged", "VC_Player_Finished", "TTS_Player_Finished", "SA_EngineStart", "SA_EngineStop", "SA_EngineError", "SA_WakeupResult", "SA_SidEnrollResult", "SA_SidLoadResult", "SA_PreWakeupResult", "SA_WakeupTimeout", "SA_SidVerifyFailResult", "SA_WakeupEnd", ResponseEvent.TaskStarted, ResponseEvent.TaskFinished, ResponseEvent.TaskFailed, "GetResulted", ResponseEvent.SessionStarted, ResponseEvent.SessionFinished, ResponseEvent.SessionCanceled, ResponseEvent.SessionFailed, "TaskResponse", ResponseEvent.ASRResponse, ResponseEvent.ASREnded, ResponseEvent.ChatResponse, ResponseEvent.ChatEnded, ResponseEvent.TTSSentenceStart, ResponseEvent.TTSResponse, ResponseEvent.TTSSentenceEnd, ResponseEvent.TTSEnded, "WebSocketStateChanged", "CallDisConnectedWithRetry", ResponseEvent.RequestRetried, ResponseEvent.ASRInfo, ResponseEvent.BSResponse, ResponseEvent.BotTriggered, ResponseEvent.AudioUploadEnded, "SpeechStarted", "SpeechEnded", "PlayerStarted", "PlayerStopped", "SessionConfResponse", "PostBackAudioConfig", "VadStarted", "VadEnded", "PVadStarted", "PVadEnded", "SpeakerSimilarity", "VuiReset", "VAD_TimeOut", "WakeUp_Succeed", "WakeUp_Failed", "AIS_Data", "AIS_Ability", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreCallBackEventType extends Enum<LiveWrappedSAMICoreCallBackEventType> {
    public static final LiveWrappedSAMICoreCallBackEventType AIS_Ability = null;
    public static final LiveWrappedSAMICoreCallBackEventType AIS_Data = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASREnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASRInfo = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASRResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_Started = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_WebSocketStateChanged = null;
    public static final LiveWrappedSAMICoreCallBackEventType AudioUploadEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType BSResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType BotTriggered = null;
    public static final LiveWrappedSAMICoreCallBackEventType CallDisConnectedWithRetry = null;
    public static final LiveWrappedSAMICoreCallBackEventType ChatEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType ChatResponse = null;
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreCallBackEventType GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType PVadEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType PVadStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType PlayerStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType PlayerStopped = null;
    public static final LiveWrappedSAMICoreCallBackEventType PostBackAudioConfig = null;
    public static final LiveWrappedSAMICoreCallBackEventType RequestRetried = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_EngineError = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_EngineStart = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_EngineStop = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_PreWakeupResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_SidEnrollResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_SidLoadResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_SidVerifyFailResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_WakeupEnd = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_WakeupResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_WakeupTimeout = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionCanceled = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionConfResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionFailed = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionFinished = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType SpeakerSimilarity = null;
    public static final LiveWrappedSAMICoreCallBackEventType SpeechEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType SpeechStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSSentenceEnd = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSSentenceStart = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Player_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Started = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_WebSocketStateChanged = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskFailed = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskFinished = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType VAD_TimeOut = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Player_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Started = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_WebSocketStateChanged = null;
    public static final LiveWrappedSAMICoreCallBackEventType VadEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType VadStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType VuiReset = null;
    public static final LiveWrappedSAMICoreCallBackEventType WakeUp_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType WakeUp_Succeed = null;
    public static final LiveWrappedSAMICoreCallBackEventType WebSocketStateChanged = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSAMICoreCallBackEventType[] f147272a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<LiveWrappedSAMICoreCallBackEventType> f147273b = null;
    private final int value;

    public static LiveWrappedSAMICoreCallBackEventType valueOf(String r100) {
        return (LiveWrappedSAMICoreCallBackEventType) r27.a.a(LiveWrappedSAMICoreCallBackEventType.class, r100);
    }

    public static LiveWrappedSAMICoreCallBackEventType[] values() {
        return (LiveWrappedSAMICoreCallBackEventType[]) f147272a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreCallBackEventType$a] */
    static {
        int r100 = 0;
        LiveWrappedSAMICoreCallBackEventType r101 = new LiveWrappedSAMICoreCallBackEventType("TTS_Started", 0, 0);
        TTS_Started = r101;
        LiveWrappedSAMICoreCallBackEventType r102 = new LiveWrappedSAMICoreCallBackEventType("TTS_GetResulted", 1, 1);
        TTS_GetResulted = r102;
        LiveWrappedSAMICoreCallBackEventType r103 = new LiveWrappedSAMICoreCallBackEventType("TTS_Finished", 2, 2);
        TTS_Finished = r103;
        LiveWrappedSAMICoreCallBackEventType r104 = new LiveWrappedSAMICoreCallBackEventType("TTS_Failed", 3, 3);
        TTS_Failed = r104;
        LiveWrappedSAMICoreCallBackEventType r105 = new LiveWrappedSAMICoreCallBackEventType("TTS_WebSocketStateChanged", 4, 4);
        TTS_WebSocketStateChanged = r105;
        LiveWrappedSAMICoreCallBackEventType r106 = new LiveWrappedSAMICoreCallBackEventType("ASR_Started", 5, 5);
        ASR_Started = r106;
        LiveWrappedSAMICoreCallBackEventType r107 = new LiveWrappedSAMICoreCallBackEventType("ASR_GetResulted", 6, 6);
        ASR_GetResulted = r107;
        LiveWrappedSAMICoreCallBackEventType r108 = new LiveWrappedSAMICoreCallBackEventType("ASR_Finished", 7, 7);
        ASR_Finished = r108;
        LiveWrappedSAMICoreCallBackEventType r109 = new LiveWrappedSAMICoreCallBackEventType("ASR_Failed", 8, 8);
        ASR_Failed = r109;
        LiveWrappedSAMICoreCallBackEventType r110 = new LiveWrappedSAMICoreCallBackEventType("ASR_WebSocketStateChanged", 9, 9);
        ASR_WebSocketStateChanged = r110;
        LiveWrappedSAMICoreCallBackEventType r111 = new LiveWrappedSAMICoreCallBackEventType("VC_Started", 10, 10);
        VC_Started = r111;
        LiveWrappedSAMICoreCallBackEventType r112 = new LiveWrappedSAMICoreCallBackEventType("VC_GetResulted", 11, 11);
        VC_GetResulted = r112;
        LiveWrappedSAMICoreCallBackEventType r113 = new LiveWrappedSAMICoreCallBackEventType("VC_Finished", 12, 12);
        VC_Finished = r113;
        LiveWrappedSAMICoreCallBackEventType r114 = new LiveWrappedSAMICoreCallBackEventType("VC_Failed", 13, 13);
        VC_Failed = r114;
        LiveWrappedSAMICoreCallBackEventType r115 = new LiveWrappedSAMICoreCallBackEventType("VC_WebSocketStateChanged", 14, 14);
        VC_WebSocketStateChanged = r115;
        LiveWrappedSAMICoreCallBackEventType r116 = new LiveWrappedSAMICoreCallBackEventType("VC_Player_Finished", 15, 15);
        VC_Player_Finished = r116;
        LiveWrappedSAMICoreCallBackEventType r117 = new LiveWrappedSAMICoreCallBackEventType("TTS_Player_Finished", 16, 20);
        TTS_Player_Finished = r117;
        LiveWrappedSAMICoreCallBackEventType r118 = new LiveWrappedSAMICoreCallBackEventType("SA_EngineStart", 17, 50);
        SA_EngineStart = r118;
        LiveWrappedSAMICoreCallBackEventType r119 = new LiveWrappedSAMICoreCallBackEventType("SA_EngineStop", 18, 51);
        SA_EngineStop = r119;
        LiveWrappedSAMICoreCallBackEventType r120 = new LiveWrappedSAMICoreCallBackEventType("SA_EngineError", 19, 52);
        SA_EngineError = r120;
        LiveWrappedSAMICoreCallBackEventType r121 = new LiveWrappedSAMICoreCallBackEventType("SA_WakeupResult", 20, 53);
        SA_WakeupResult = r121;
        LiveWrappedSAMICoreCallBackEventType r122 = new LiveWrappedSAMICoreCallBackEventType("SA_SidEnrollResult", 21, 54);
        SA_SidEnrollResult = r122;
        LiveWrappedSAMICoreCallBackEventType r123 = new LiveWrappedSAMICoreCallBackEventType("SA_SidLoadResult", 22, 55);
        SA_SidLoadResult = r123;
        LiveWrappedSAMICoreCallBackEventType r124 = new LiveWrappedSAMICoreCallBackEventType("SA_PreWakeupResult", 23, 56);
        SA_PreWakeupResult = r124;
        LiveWrappedSAMICoreCallBackEventType r125 = new LiveWrappedSAMICoreCallBackEventType("SA_WakeupTimeout", 24, 57);
        SA_WakeupTimeout = r125;
        LiveWrappedSAMICoreCallBackEventType r126 = new LiveWrappedSAMICoreCallBackEventType("SA_SidVerifyFailResult", 25, 58);
        SA_SidVerifyFailResult = r126;
        LiveWrappedSAMICoreCallBackEventType r127 = new LiveWrappedSAMICoreCallBackEventType("SA_WakeupEnd", 26, 59);
        SA_WakeupEnd = r127;
        LiveWrappedSAMICoreCallBackEventType r128 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TaskStarted, 27, 200);
        TaskStarted = r128;
        LiveWrappedSAMICoreCallBackEventType r129 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TaskFinished, 28, 201);
        TaskFinished = r129;
        LiveWrappedSAMICoreCallBackEventType r130 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TaskFailed, 29, 202);
        TaskFailed = r130;
        LiveWrappedSAMICoreCallBackEventType r131 = new LiveWrappedSAMICoreCallBackEventType("GetResulted", 30, 203);
        GetResulted = r131;
        LiveWrappedSAMICoreCallBackEventType r132 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.SessionStarted, 31, 204);
        SessionStarted = r132;
        LiveWrappedSAMICoreCallBackEventType r133 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.SessionFinished, 32, 205);
        SessionFinished = r133;
        LiveWrappedSAMICoreCallBackEventType r134 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.SessionCanceled, 33, 206);
        SessionCanceled = r134;
        LiveWrappedSAMICoreCallBackEventType r135 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.SessionFailed, 34, 207);
        SessionFailed = r135;
        LiveWrappedSAMICoreCallBackEventType r136 = new LiveWrappedSAMICoreCallBackEventType("TaskResponse", 35, 208);
        TaskResponse = r136;
        LiveWrappedSAMICoreCallBackEventType r137 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.ASRResponse, 36, 209);
        ASRResponse = r137;
        LiveWrappedSAMICoreCallBackEventType r138 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.ASREnded, 37, 210);
        ASREnded = r138;
        LiveWrappedSAMICoreCallBackEventType r139 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.ChatResponse, 38, 211);
        ChatResponse = r139;
        LiveWrappedSAMICoreCallBackEventType r140 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.ChatEnded, 39, 212);
        ChatEnded = r140;
        LiveWrappedSAMICoreCallBackEventType r141 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TTSSentenceStart, 40, 213);
        TTSSentenceStart = r141;
        LiveWrappedSAMICoreCallBackEventType r142 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TTSResponse, 41, 214);
        TTSResponse = r142;
        LiveWrappedSAMICoreCallBackEventType r143 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TTSSentenceEnd, 42, 215);
        TTSSentenceEnd = r143;
        LiveWrappedSAMICoreCallBackEventType r144 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.TTSEnded, 43, 216);
        TTSEnded = r144;
        LiveWrappedSAMICoreCallBackEventType r145 = new LiveWrappedSAMICoreCallBackEventType("WebSocketStateChanged", 44, 217);
        WebSocketStateChanged = r145;
        LiveWrappedSAMICoreCallBackEventType r146 = new LiveWrappedSAMICoreCallBackEventType("CallDisConnectedWithRetry", 45, 218);
        CallDisConnectedWithRetry = r146;
        LiveWrappedSAMICoreCallBackEventType r147 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.RequestRetried, 46, 219);
        RequestRetried = r147;
        LiveWrappedSAMICoreCallBackEventType r148 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.ASRInfo, 47, 220);
        ASRInfo = r148;
        LiveWrappedSAMICoreCallBackEventType r149 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.BSResponse, 48, 221);
        BSResponse = r149;
        LiveWrappedSAMICoreCallBackEventType r150 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.BotTriggered, 49, 222);
        BotTriggered = r150;
        LiveWrappedSAMICoreCallBackEventType r151 = new LiveWrappedSAMICoreCallBackEventType(ResponseEvent.AudioUploadEnded, 50, 223);
        AudioUploadEnded = r151;
        LiveWrappedSAMICoreCallBackEventType r152 = new LiveWrappedSAMICoreCallBackEventType("SpeechStarted", 51, 224);
        SpeechStarted = r152;
        LiveWrappedSAMICoreCallBackEventType r153 = new LiveWrappedSAMICoreCallBackEventType("SpeechEnded", 52, 225);
        SpeechEnded = r153;
        LiveWrappedSAMICoreCallBackEventType r154 = new LiveWrappedSAMICoreCallBackEventType("PlayerStarted", 53, 226);
        PlayerStarted = r154;
        LiveWrappedSAMICoreCallBackEventType r155 = new LiveWrappedSAMICoreCallBackEventType("PlayerStopped", 54, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL);
        PlayerStopped = r155;
        LiveWrappedSAMICoreCallBackEventType r156 = new LiveWrappedSAMICoreCallBackEventType("SessionConfResponse", 55, 230);
        SessionConfResponse = r156;
        LiveWrappedSAMICoreCallBackEventType r157 = new LiveWrappedSAMICoreCallBackEventType("PostBackAudioConfig", 56, 231);
        PostBackAudioConfig = r157;
        LiveWrappedSAMICoreCallBackEventType r158 = new LiveWrappedSAMICoreCallBackEventType("VadStarted", 57, 250);
        VadStarted = r158;
        LiveWrappedSAMICoreCallBackEventType r159 = new LiveWrappedSAMICoreCallBackEventType("VadEnded", 58, 251);
        VadEnded = r159;
        LiveWrappedSAMICoreCallBackEventType r160 = new LiveWrappedSAMICoreCallBackEventType("PVadStarted", 59, 252);
        PVadStarted = r160;
        LiveWrappedSAMICoreCallBackEventType r161 = new LiveWrappedSAMICoreCallBackEventType("PVadEnded", 60, 253);
        PVadEnded = r161;
        LiveWrappedSAMICoreCallBackEventType r162 = new LiveWrappedSAMICoreCallBackEventType("SpeakerSimilarity", 61, 254);
        SpeakerSimilarity = r162;
        LiveWrappedSAMICoreCallBackEventType r163 = new LiveWrappedSAMICoreCallBackEventType("VuiReset", 62, 300);
        VuiReset = r163;
        LiveWrappedSAMICoreCallBackEventType r164 = new LiveWrappedSAMICoreCallBackEventType("VAD_TimeOut", 63, 352);
        VAD_TimeOut = r164;
        LiveWrappedSAMICoreCallBackEventType r165 = new LiveWrappedSAMICoreCallBackEventType("WakeUp_Succeed", 64, 353);
        WakeUp_Succeed = r165;
        LiveWrappedSAMICoreCallBackEventType r166 = new LiveWrappedSAMICoreCallBackEventType("WakeUp_Failed", 65, 354);
        WakeUp_Failed = r166;
        LiveWrappedSAMICoreCallBackEventType r167 = new LiveWrappedSAMICoreCallBackEventType("AIS_Data", 66, 400);
        AIS_Data = r167;
        LiveWrappedSAMICoreCallBackEventType r168 = new LiveWrappedSAMICoreCallBackEventType("AIS_Ability", 67, 401);
        AIS_Ability = r168;
        f147272a = new LiveWrappedSAMICoreCallBackEventType[]{r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168};
        Companion = new a();
        f147273b = new SparseArray();
        LiveWrappedSAMICoreCallBackEventType[] r169 = values();
        int r170 = r169.length;
    L3:
        if (r100 >= r170) goto L5;
        LiveWrappedSAMICoreCallBackEventType r171 = r169[r100];
        f147273b.put(r171.value, r171);
        r100 = r100 + 1;
        goto L3
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return f147273b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreCallBackEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
