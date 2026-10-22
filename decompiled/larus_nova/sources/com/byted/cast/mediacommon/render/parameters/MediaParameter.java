package com.byted.cast.mediacommon.render.parameters;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum MediaParameter extends Enum<MediaParameter> {
    private static final /* synthetic */ MediaParameter[] $VALUES = null;
    public static final MediaParameter Audio_IsAutoPlay = null;
    public static final MediaParameter Audio_JitterBuffer_Delay = null;
    public static final MediaParameter Audio_JitterBuffer_Mode = null;
    public static final MediaParameter Audio_Render_BitRate = null;
    public static final MediaParameter Audio_Render_BitWidth = null;
    public static final MediaParameter Audio_Render_Channel = null;
    public static final MediaParameter Audio_Render_FrameSize = null;
    public static final MediaParameter Audio_Render_SampleRate = null;
    public static final MediaParameter Audio_Render_SessionId = null;
    public static final MediaParameter Audio_Render_max_vol = null;
    public static final MediaParameter Audio_Render_min_vol = null;
    public static final MediaParameter Audio_Render_routingChangedListener = null;
    public static final MediaParameter Audio_Render_volume = null;
    public static final MediaParameter Render_IsOpenJitterBuffer = null;
    public static final MediaParameter Render_IsUseSoftDecoder = null;
    public static final MediaParameter Render_audioLatencyListener = null;
    public static final MediaParameter Render_context = null;
    public static final MediaParameter Render_dumpFilePath = null;
    public static final MediaParameter Render_videoLatencyListener = null;
    public static final MediaParameter Video_Decoder_IsSetSurface = null;
    public static final MediaParameter Video_JitterBuffer_Delay = null;
    public static final MediaParameter Video_JitterBuffer_Mode = null;

    static {
        MediaParameter r100 = new MediaParameter("Video_Decoder_IsSetSurface", 0);
        Video_Decoder_IsSetSurface = r100;
        MediaParameter r101 = new MediaParameter("Audio_IsAutoPlay", 1);
        Audio_IsAutoPlay = r101;
        MediaParameter r102 = new MediaParameter("Render_IsOpenJitterBuffer", 2);
        Render_IsOpenJitterBuffer = r102;
        MediaParameter r103 = new MediaParameter("Render_IsUseSoftDecoder", 3);
        Render_IsUseSoftDecoder = r103;
        MediaParameter r104 = new MediaParameter("Audio_Render_Channel", 4);
        Audio_Render_Channel = r104;
        MediaParameter r105 = new MediaParameter("Audio_Render_SampleRate", 5);
        Audio_Render_SampleRate = r105;
        MediaParameter r110 = new MediaParameter("Audio_Render_BitWidth", 6);
        Audio_Render_BitWidth = r110;
        MediaParameter r111 = new MediaParameter("Audio_Render_FrameSize", 7);
        Audio_Render_FrameSize = r111;
        MediaParameter r112 = new MediaParameter("Audio_Render_BitRate", 8);
        Audio_Render_BitRate = r112;
        MediaParameter r113 = new MediaParameter("Audio_Render_SessionId", 9);
        Audio_Render_SessionId = r113;
        MediaParameter r114 = new MediaParameter("Video_JitterBuffer_Mode", 10);
        Video_JitterBuffer_Mode = r114;
        MediaParameter r115 = new MediaParameter("Audio_JitterBuffer_Mode", 11);
        Audio_JitterBuffer_Mode = r115;
        MediaParameter r106 = new MediaParameter("Audio_JitterBuffer_Delay", 12);
        Audio_JitterBuffer_Delay = r106;
        MediaParameter r107 = new MediaParameter("Video_JitterBuffer_Delay", 13);
        Video_JitterBuffer_Delay = r107;
        MediaParameter r108 = new MediaParameter("Audio_Render_volume", 14);
        Audio_Render_volume = r108;
        MediaParameter r109 = new MediaParameter("Audio_Render_max_vol", 15);
        Audio_Render_max_vol = r109;
        MediaParameter r116 = new MediaParameter("Audio_Render_min_vol", 16);
        Audio_Render_min_vol = r116;
        MediaParameter r117 = new MediaParameter("Audio_Render_routingChangedListener", 17);
        Audio_Render_routingChangedListener = r117;
        MediaParameter r118 = new MediaParameter("Render_videoLatencyListener", 18);
        Render_videoLatencyListener = r118;
        MediaParameter r119 = new MediaParameter("Render_audioLatencyListener", 19);
        Render_audioLatencyListener = r119;
        MediaParameter r120 = new MediaParameter("Render_dumpFilePath", 20);
        Render_dumpFilePath = r120;
        MediaParameter r121 = new MediaParameter("Render_context", 21);
        Render_context = r121;
        $VALUES = new MediaParameter[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121};
    }

    public static MediaParameter[] values() {
        return (MediaParameter[]) $VALUES.clone();
    }

    public static MediaParameter valueOf(String r100) {
        return (MediaParameter) a.a(MediaParameter.class, r100);
    }

    private MediaParameter(String r100, int r101) {
        super(r100, r101);
    }
}
