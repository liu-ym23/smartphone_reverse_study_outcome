package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreIdentify;", "", "", "value", "I", "getValue", "()I", "SAMICoreIdentify_EngineExecutor_KWS", "SAMICoreIdentify_EngineExecutor_AudioMetrics", "SAMICoreIdentify_EngineExecutor_Common", "SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup", "SAMICoreIdentify_Non_Streaming_Wakeup", "SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader", "SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC", "SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC", "SAMICoreIdentify_EngineExecutor_CE_VAD", "SAMICoreIdentify_TTS_Online", "SAMICoreIdentify_MultiSpeakerEmbedding_Online", "SAMICoreIdentify_Streaming_ASR_Online", "SAMICoreIdentify_Streaming_TTS_Online", "SAMICoreIdentify_Streaming_Playing_TTS_Online", "SAMICoreIdentify_Streaming_ASR_Async_Online", "SAMICoreIdentify_Streaming_VC_Online", "SAMICoreIdentify_Bidirectional_TTS_Online", "SAMICoreIdentify_Voice_Assistant_Online", "SAMICoreIdentify_Voice_Assistant_TimeStretcher", "SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer", "SAMICoreIdentify_Voice_Assistant_Online_V2", "SAMICoreIdentify_RealtimeCall_Aec", "SAMICoreIdentify_Offline_Full_Duplex", "SAMICoreIdentify_Streaming_ASR_Online_V2", "SAMICoreIdentify_Audio_Encode", "SAMICoreIdentify_AISTunnel", "SAMICoreIdentify_AISAbility", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreIdentify extends Enum<LiveWrappedSAMICoreIdentify> {
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_AISAbility = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_AISTunnel = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Audio_Encode = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Bidirectional_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_AudioMetrics = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_CE_VAD = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_Common = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_KWS = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_MultiSpeakerEmbedding_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Non_Streaming_Wakeup = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Offline_Full_Duplex = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_RealtimeCall_Aec = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_ASR_Async_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_ASR_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_ASR_Online_V2 = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_Playing_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_VC_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_Online_V2 = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_TimeStretcher = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSAMICoreIdentify[] f147276a = null;
    private final int value;

    public static LiveWrappedSAMICoreIdentify valueOf(String r100) {
        return (LiveWrappedSAMICoreIdentify) a.a(LiveWrappedSAMICoreIdentify.class, r100);
    }

    public static LiveWrappedSAMICoreIdentify[] values() {
        return (LiveWrappedSAMICoreIdentify[]) f147276a.clone();
    }

    static {
        LiveWrappedSAMICoreIdentify r100 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_KWS", 0, 507);
        SAMICoreIdentify_EngineExecutor_KWS = r100;
        LiveWrappedSAMICoreIdentify r101 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_AudioMetrics", 1, 508);
        SAMICoreIdentify_EngineExecutor_AudioMetrics = r101;
        LiveWrappedSAMICoreIdentify r102 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_Common", 2, 512);
        SAMICoreIdentify_EngineExecutor_Common = r102;
        LiveWrappedSAMICoreIdentify r103 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup", 3, 515);
        SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup = r103;
        LiveWrappedSAMICoreIdentify r104 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Non_Streaming_Wakeup", 4, 517);
        SAMICoreIdentify_Non_Streaming_Wakeup = r104;
        LiveWrappedSAMICoreIdentify r105 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader", 5, 518);
        SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader = r105;
        LiveWrappedSAMICoreIdentify r106 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC", 6, MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION);
        SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC = r106;
        LiveWrappedSAMICoreIdentify r107 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC", 7, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY);
        SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC = r107;
        LiveWrappedSAMICoreIdentify r108 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_CE_VAD", 8, 557);
        SAMICoreIdentify_EngineExecutor_CE_VAD = r108;
        LiveWrappedSAMICoreIdentify r109 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_TTS_Online", 9, 601);
        SAMICoreIdentify_TTS_Online = r109;
        LiveWrappedSAMICoreIdentify r110 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_MultiSpeakerEmbedding_Online", 10, 615);
        SAMICoreIdentify_MultiSpeakerEmbedding_Online = r110;
        LiveWrappedSAMICoreIdentify r111 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_ASR_Online", 11, 650);
        SAMICoreIdentify_Streaming_ASR_Online = r111;
        LiveWrappedSAMICoreIdentify r112 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_TTS_Online", 12, 651);
        SAMICoreIdentify_Streaming_TTS_Online = r112;
        LiveWrappedSAMICoreIdentify r113 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_Playing_TTS_Online", 13, 652);
        SAMICoreIdentify_Streaming_Playing_TTS_Online = r113;
        LiveWrappedSAMICoreIdentify r114 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_ASR_Async_Online", 14, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM);
        SAMICoreIdentify_Streaming_ASR_Async_Online = r114;
        LiveWrappedSAMICoreIdentify r115 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_VC_Online", 15, 654);
        SAMICoreIdentify_Streaming_VC_Online = r115;
        LiveWrappedSAMICoreIdentify r116 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Bidirectional_TTS_Online", 16, 655);
        SAMICoreIdentify_Bidirectional_TTS_Online = r116;
        LiveWrappedSAMICoreIdentify r117 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_Online", 17, 656);
        SAMICoreIdentify_Voice_Assistant_Online = r117;
        LiveWrappedSAMICoreIdentify r118 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_TimeStretcher", 18, 657);
        SAMICoreIdentify_Voice_Assistant_TimeStretcher = r118;
        LiveWrappedSAMICoreIdentify r119 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer", 19, 658);
        SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer = r119;
        LiveWrappedSAMICoreIdentify r120 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_Online_V2", 20, 659);
        SAMICoreIdentify_Voice_Assistant_Online_V2 = r120;
        LiveWrappedSAMICoreIdentify r121 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_RealtimeCall_Aec", 21, 660);
        SAMICoreIdentify_RealtimeCall_Aec = r121;
        LiveWrappedSAMICoreIdentify r122 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Offline_Full_Duplex", 22, 661);
        SAMICoreIdentify_Offline_Full_Duplex = r122;
        LiveWrappedSAMICoreIdentify r123 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_ASR_Online_V2", 23, 670);
        SAMICoreIdentify_Streaming_ASR_Online_V2 = r123;
        LiveWrappedSAMICoreIdentify r124 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Audio_Encode", 24, 800);
        SAMICoreIdentify_Audio_Encode = r124;
        LiveWrappedSAMICoreIdentify r125 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_AISTunnel", 25, 9100);
        SAMICoreIdentify_AISTunnel = r125;
        LiveWrappedSAMICoreIdentify r126 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_AISAbility", 26, 9101);
        SAMICoreIdentify_AISAbility = r126;
        f147276a = new LiveWrappedSAMICoreIdentify[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreIdentify(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
