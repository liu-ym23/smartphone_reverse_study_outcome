package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b?\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreDataType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SAMICoreDataType_Float", "SAMICoreDataType_Int", "SAMICoreDataType_String", "SAMICoreDataType_Null", "SAMICoreDataType_AudioBuffer", "SAMICoreDataType_Data_Uri_Parameter", "SAMICoreDataType_ContextPrepareParameter", "SAMICoreDataType_ResourceParameter", "SAMICoreDataType_ParameterEvent", "SAMICoreDataType_ProcessorParameter", "SAMICoreDataType_FeatureSet", "SAMICoreDataType_ExtractorParameter", "SAMICoreDataType_ModelBin", "SAMICoreDataType_AecInput", "SAMICoreDataType_TTSCallBack", "SAMICoreDataType_EngineCreateParameter", "SAMICoreDataType_ExecutorCreateParameter", "SAMICoreDataType_TimeAlign", "SAMICoreDataType_LoudNorm", "SAMICoreDataType_LoudNorm2", "SAMICoreDataType_KWS", "SAMICoreDataType_KWS_SA_REAULT", "SAMICoreDataType_TTS_Result", "SAMICoreDataType_ASR_Result", "SAMICoreDataType_AudioBin", "SAMICoreDataType_BeatTracking_Result", "SAMICoreDataType_MusicSourceSeparate_Result", "SAMICoreDataType_MusicTagging_Result", "SAMICoreDataType_Chorus_Result", "SAMICoreDataType_MusicRetarget_Result", "SAMICoreDataType_Midi_Result", "SAMICoreDataType_Token_Result", "SAMICoreDataType_SpeechDisfluency_Result", "SAMICoreDataType_VoiceFilterParam", "SAMICoreDataType_ServerHttpResponse", "SAMICoreDataType_Http_Common_Response", "SAMICoreDataType_WebSocket_Server_Event", "SAMICoreDataType_WebSocket_Connection_Event", "SAMICoreDataType_WebSocket_Asr", "SAMICoreDataType_WebSocket_Tts", "SAMICoreDataType_WebSocket_Vc", "SAMICoreDataType_WebSocket_Vc_Speaker", "SAMICoreDataType_WebSocket_KeepAliveParam", "SAMICoreDataType_WebSocket_Asr_Context_Param", "SAMICoreDataType_WebSocket_Tts_Context_Param", "SAMICoreDataType_Voice_Assistant_Property_Param", "SAMICoreDataType_Voice_Assistant_Audio_data", "SAMICoreDataType_Voice_Assistant_Aec_Context_Param", "SAMICoreDataType_Voice_Assistant_Text_data", "SAMICoreDataType_Voice_Assistant_Trace_Span_Param", "SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param", "SAMICoreDataType_PostProcess_LoudnessStrategy_Param", "SAMICoreDataType_Voice_Assistant_Mem_Upload_Param", "SAMICoreDataType_WebSocket_BidirectionalTTS_Param", "SAMICoreDataType_Voice_Assistant_Info_Upload_Param", "SAMICore_DataType_TimeStretcher_ScaleInfo", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreDataType extends Enum<LiveWrappedSAMICoreDataType> {
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ASR_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_AecInput = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_AudioBin = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_AudioBuffer = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_BeatTracking_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Chorus_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ContextPrepareParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Data_Uri_Parameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_EngineCreateParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ExecutorCreateParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ExtractorParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_FeatureSet = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Float = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Http_Common_Response = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Int = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_KWS = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_KWS_SA_REAULT = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_LoudNorm = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_LoudNorm2 = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Midi_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ModelBin = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_MusicRetarget_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_MusicSourceSeparate_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_MusicTagging_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Null = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ParameterEvent = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_PostProcess_LoudnessStrategy_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ProcessorParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ResourceParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ServerHttpResponse = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_SpeechDisfluency_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_String = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_TTSCallBack = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_TTS_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_TimeAlign = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Token_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_VoiceFilterParam = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Aec_Context_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Audio_data = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Info_Upload_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Mem_Upload_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Property_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Text_data = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Trace_Span_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Asr = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Asr_Context_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_BidirectionalTTS_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Connection_Event = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_KeepAliveParam = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Server_Event = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Tts = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Tts_Context_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Vc = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Vc_Speaker = null;
    public static final LiveWrappedSAMICoreDataType SAMICore_DataType_TimeStretcher_ScaleInfo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSAMICoreDataType[] f147274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<LiveWrappedSAMICoreDataType> f147275b = null;
    private final int value;

    public static LiveWrappedSAMICoreDataType valueOf(String r100) {
        return (LiveWrappedSAMICoreDataType) r27.a.a(LiveWrappedSAMICoreDataType.class, r100);
    }

    public static LiveWrappedSAMICoreDataType[] values() {
        return (LiveWrappedSAMICoreDataType[]) f147274a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreDataType$a] */
    static {
        int r100 = 0;
        LiveWrappedSAMICoreDataType r101 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Float", 0, 0);
        SAMICoreDataType_Float = r101;
        LiveWrappedSAMICoreDataType r102 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Int", 1, 1);
        SAMICoreDataType_Int = r102;
        LiveWrappedSAMICoreDataType r103 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_String", 2, 2);
        SAMICoreDataType_String = r103;
        LiveWrappedSAMICoreDataType r104 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Null", 3, 5);
        SAMICoreDataType_Null = r104;
        LiveWrappedSAMICoreDataType r105 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_AudioBuffer", 4, 50);
        SAMICoreDataType_AudioBuffer = r105;
        LiveWrappedSAMICoreDataType r106 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Data_Uri_Parameter", 5, 52);
        SAMICoreDataType_Data_Uri_Parameter = r106;
        LiveWrappedSAMICoreDataType r107 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ContextPrepareParameter", 6, 100);
        SAMICoreDataType_ContextPrepareParameter = r107;
        LiveWrappedSAMICoreDataType r108 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ResourceParameter", 7, 101);
        SAMICoreDataType_ResourceParameter = r108;
        LiveWrappedSAMICoreDataType r109 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ParameterEvent", 8, 102);
        SAMICoreDataType_ParameterEvent = r109;
        LiveWrappedSAMICoreDataType r110 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ProcessorParameter", 9, 150);
        SAMICoreDataType_ProcessorParameter = r110;
        LiveWrappedSAMICoreDataType r111 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_FeatureSet", 10, 250);
        SAMICoreDataType_FeatureSet = r111;
        LiveWrappedSAMICoreDataType r112 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ExtractorParameter", 11, 251);
        SAMICoreDataType_ExtractorParameter = r112;
        LiveWrappedSAMICoreDataType r113 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ModelBin", 12, 300);
        SAMICoreDataType_ModelBin = r113;
        LiveWrappedSAMICoreDataType r114 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_AecInput", 13, TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG);
        SAMICoreDataType_AecInput = r114;
        LiveWrappedSAMICoreDataType r115 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_TTSCallBack", 14, 400);
        SAMICoreDataType_TTSCallBack = r115;
        LiveWrappedSAMICoreDataType r116 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_EngineCreateParameter", 15, 401);
        SAMICoreDataType_EngineCreateParameter = r116;
        LiveWrappedSAMICoreDataType r117 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ExecutorCreateParameter", 16, 402);
        SAMICoreDataType_ExecutorCreateParameter = r117;
        LiveWrappedSAMICoreDataType r118 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_TimeAlign", 17, 450);
        SAMICoreDataType_TimeAlign = r118;
        LiveWrappedSAMICoreDataType r119 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_LoudNorm", 18, 451);
        SAMICoreDataType_LoudNorm = r119;
        LiveWrappedSAMICoreDataType r120 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_LoudNorm2", 19, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME);
        SAMICoreDataType_LoudNorm2 = r120;
        LiveWrappedSAMICoreDataType r121 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_KWS", 20, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME);
        SAMICoreDataType_KWS = r121;
        LiveWrappedSAMICoreDataType r122 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_KWS_SA_REAULT", 21, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME);
        SAMICoreDataType_KWS_SA_REAULT = r122;
        LiveWrappedSAMICoreDataType r123 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_TTS_Result", 22, 500);
        SAMICoreDataType_TTS_Result = r123;
        LiveWrappedSAMICoreDataType r124 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ASR_Result", 23, 503);
        SAMICoreDataType_ASR_Result = r124;
        LiveWrappedSAMICoreDataType r125 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_AudioBin", 24, 504);
        SAMICoreDataType_AudioBin = r125;
        LiveWrappedSAMICoreDataType r126 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_BeatTracking_Result", 25, 505);
        SAMICoreDataType_BeatTracking_Result = r126;
        LiveWrappedSAMICoreDataType r127 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_MusicSourceSeparate_Result", 26, 506);
        SAMICoreDataType_MusicSourceSeparate_Result = r127;
        LiveWrappedSAMICoreDataType r128 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_MusicTagging_Result", 27, 507);
        SAMICoreDataType_MusicTagging_Result = r128;
        LiveWrappedSAMICoreDataType r129 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Chorus_Result", 28, 508);
        SAMICoreDataType_Chorus_Result = r129;
        LiveWrappedSAMICoreDataType r130 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_MusicRetarget_Result", 29, 509);
        SAMICoreDataType_MusicRetarget_Result = r130;
        LiveWrappedSAMICoreDataType r131 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Midi_Result", 30, 510);
        SAMICoreDataType_Midi_Result = r131;
        LiveWrappedSAMICoreDataType r132 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Token_Result", 31, 511);
        SAMICoreDataType_Token_Result = r132;
        LiveWrappedSAMICoreDataType r133 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_SpeechDisfluency_Result", 32, 512);
        SAMICoreDataType_SpeechDisfluency_Result = r133;
        LiveWrappedSAMICoreDataType r134 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_VoiceFilterParam", 33, 513);
        SAMICoreDataType_VoiceFilterParam = r134;
        LiveWrappedSAMICoreDataType r135 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ServerHttpResponse", 34, 514);
        SAMICoreDataType_ServerHttpResponse = r135;
        LiveWrappedSAMICoreDataType r136 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Http_Common_Response", 35, 517);
        SAMICoreDataType_Http_Common_Response = r136;
        LiveWrappedSAMICoreDataType r137 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Server_Event", 36, 600);
        SAMICoreDataType_WebSocket_Server_Event = r137;
        LiveWrappedSAMICoreDataType r138 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Connection_Event", 37, 601);
        SAMICoreDataType_WebSocket_Connection_Event = r138;
        LiveWrappedSAMICoreDataType r139 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Asr", 38, 602);
        SAMICoreDataType_WebSocket_Asr = r139;
        LiveWrappedSAMICoreDataType r140 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Tts", 39, 603);
        SAMICoreDataType_WebSocket_Tts = r140;
        LiveWrappedSAMICoreDataType r141 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Vc", 40, 604);
        SAMICoreDataType_WebSocket_Vc = r141;
        LiveWrappedSAMICoreDataType r142 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Vc_Speaker", 41, 605);
        SAMICoreDataType_WebSocket_Vc_Speaker = r142;
        LiveWrappedSAMICoreDataType r143 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_KeepAliveParam", 42, 606);
        SAMICoreDataType_WebSocket_KeepAliveParam = r143;
        LiveWrappedSAMICoreDataType r144 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Asr_Context_Param", 43, 650);
        SAMICoreDataType_WebSocket_Asr_Context_Param = r144;
        LiveWrappedSAMICoreDataType r145 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Tts_Context_Param", 44, 651);
        SAMICoreDataType_WebSocket_Tts_Context_Param = r145;
        LiveWrappedSAMICoreDataType r146 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Property_Param", 45, 652);
        SAMICoreDataType_Voice_Assistant_Property_Param = r146;
        LiveWrappedSAMICoreDataType r147 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Audio_data", 46, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM);
        SAMICoreDataType_Voice_Assistant_Audio_data = r147;
        LiveWrappedSAMICoreDataType r148 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Aec_Context_Param", 47, 654);
        SAMICoreDataType_Voice_Assistant_Aec_Context_Param = r148;
        LiveWrappedSAMICoreDataType r149 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Text_data", 48, 655);
        SAMICoreDataType_Voice_Assistant_Text_data = r149;
        LiveWrappedSAMICoreDataType r150 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Trace_Span_Param", 49, 656);
        SAMICoreDataType_Voice_Assistant_Trace_Span_Param = r150;
        LiveWrappedSAMICoreDataType r151 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param", 50, 657);
        SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param = r151;
        LiveWrappedSAMICoreDataType r152 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_PostProcess_LoudnessStrategy_Param", 51, 657);
        SAMICoreDataType_PostProcess_LoudnessStrategy_Param = r152;
        LiveWrappedSAMICoreDataType r153 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Mem_Upload_Param", 52, 680);
        SAMICoreDataType_Voice_Assistant_Mem_Upload_Param = r153;
        LiveWrappedSAMICoreDataType r154 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_BidirectionalTTS_Param", 53, 681);
        SAMICoreDataType_WebSocket_BidirectionalTTS_Param = r154;
        LiveWrappedSAMICoreDataType r155 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Info_Upload_Param", 54, 682);
        SAMICoreDataType_Voice_Assistant_Info_Upload_Param = r155;
        LiveWrappedSAMICoreDataType r156 = new LiveWrappedSAMICoreDataType("SAMICore_DataType_TimeStretcher_ScaleInfo", 55, 800);
        SAMICore_DataType_TimeStretcher_ScaleInfo = r156;
        f147274a = new LiveWrappedSAMICoreDataType[]{r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156};
        Companion = new a();
        f147275b = new SparseArray();
        LiveWrappedSAMICoreDataType[] r157 = values();
        int r158 = r157.length;
    L3:
        if (r100 >= r158) goto L5;
        LiveWrappedSAMICoreDataType r159 = r157[r100];
        f147275b.put(r159.value, r159);
        r100 = r100 + 1;
        goto L3
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return f147275b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
