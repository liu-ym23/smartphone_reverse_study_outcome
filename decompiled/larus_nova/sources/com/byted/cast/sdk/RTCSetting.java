package com.byted.cast.sdk;

import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.utils.JsonFormatter;
import com.google.gson.annotations.SerializedName;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class RTCSetting extends JsonFormatter {
    private static final String TAG = "RTCSetting";

    @SerializedName("bDecodedByUser")
    private boolean bDecodedByUser;

    @SerializedName("bEnableAudioCallback")
    private boolean bEnableAudioCallback;

    @SerializedName("bEnableAudioMixer")
    private boolean bEnableAudioMixer;

    @SerializedName("bEnableVideoNativeDecode")
    private boolean bEnableVideoNativeDecode;

    @SerializedName("latencyMs")
    private int latencyMs;

    @SerializedName("avsyncType")
    private AVSYNC_TYPE mAVSyncType;

    @SerializedName("audioProfile")
    private RTCAudioProfile mAudioProfile;

    @SerializedName("audioTransType")
    private TRANS_TYPE mAudioTransType;

    @SerializedName("captureType")
    private CAPTURE_TYPE mCaptureType;

    @SerializedName("mirrorId")
    private ContextManager.CastContext mCastContext;

    @SerializedName("decodeType")
    private DECODE_TYPE mDecodeType;

    @SerializedName("enableSourceOpengl")
    private boolean mEnableSourceOpengl;

    @SerializedName("isExternalAudioSource")
    private boolean mIsExternalAudioSource;

    @SerializedName("isExternalScreenSource")
    private boolean mIsExternalScreenSource;

    @SerializedName("isExternalVideoSource")
    private boolean mIsExternalVideoSource;

    @SerializedName("port")
    private int mPort;

    @SerializedName("screenProfile")
    private RTCScreenProfile mScreenProfile;

    @SerializedName("streamType")
    private STREAM_TYPE mStreamType;

    @SerializedName("videoProfile")
    private RTCVideoProfile mVideoProfile;

    @SerializedName("videoSourceType")
    private VIDEO_SOURCE_TYPE mVideoSourceType;

    @SerializedName("videoTransType")
    private TRANS_TYPE mVideoTransType;

    public static final enum ACODEC_ID extends Enum<ACODEC_ID> {
        private static final /* synthetic */ ACODEC_ID[] $VALUES = null;
        public static final ACODEC_ID AAC = null;
        public static final ACODEC_ID AUTO = null;
        public static final ACODEC_ID G729FEC1 = null;
        public static final ACODEC_ID G729FEC2 = null;
        public static final ACODEC_ID ILBC = null;
        public static final ACODEC_ID ISACFIX = null;
        public static final ACODEC_ID OPUS = null;
        public static final ACODEC_ID OPUSFEC1 = null;
        public static final ACODEC_ID OPUSFEC2 = null;
        public static final ACODEC_ID OPUS_8K = null;

        static {
            ACODEC_ID r100 = new ACODEC_ID("AUTO", 0);
            AUTO = r100;
            ACODEC_ID r101 = new ACODEC_ID("ISACFIX", 1);
            ISACFIX = r101;
            ACODEC_ID r102 = new ACODEC_ID("ILBC", 2);
            ILBC = r102;
            ACODEC_ID r103 = new ACODEC_ID("OPUS", 3);
            OPUS = r103;
            ACODEC_ID r104 = new ACODEC_ID("G729FEC2", 4);
            G729FEC2 = r104;
            ACODEC_ID r105 = new ACODEC_ID("G729FEC1", 5);
            G729FEC1 = r105;
            ACODEC_ID r110 = new ACODEC_ID("OPUSFEC1", 6);
            OPUSFEC1 = r110;
            ACODEC_ID r111 = new ACODEC_ID("OPUSFEC2", 7);
            OPUSFEC2 = r111;
            ACODEC_ID r112 = new ACODEC_ID("OPUS_8K", 8);
            OPUS_8K = r112;
            ACODEC_ID r113 = new ACODEC_ID("AAC", 9);
            AAC = r113;
            $VALUES = new ACODEC_ID[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static ACODEC_ID[] values() {
            return (ACODEC_ID[]) $VALUES.clone();
        }

        public static ACODEC_ID valueOf(String r100) {
            return (ACODEC_ID) a.a(ACODEC_ID.class, r100);
        }

        private ACODEC_ID(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum AVSYNC_TYPE extends Enum<AVSYNC_TYPE> {
        private static final /* synthetic */ AVSYNC_TYPE[] $VALUES = null;
        public static final AVSYNC_TYPE SYNC_LOW_LATENCY = null;
        public static final AVSYNC_TYPE SYNC_NORMAL = null;

        static {
            AVSYNC_TYPE r100 = new AVSYNC_TYPE("SYNC_LOW_LATENCY", 0);
            SYNC_LOW_LATENCY = r100;
            AVSYNC_TYPE r101 = new AVSYNC_TYPE("SYNC_NORMAL", 1);
            SYNC_NORMAL = r101;
            $VALUES = new AVSYNC_TYPE[]{r100, r101};
        }

        public static AVSYNC_TYPE[] values() {
            return (AVSYNC_TYPE[]) $VALUES.clone();
        }

        public static AVSYNC_TYPE valueOf(String r100) {
            return (AVSYNC_TYPE) a.a(AVSYNC_TYPE.class, r100);
        }

        private AVSYNC_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum BITRATE_MODE extends Enum<BITRATE_MODE> {
        private static final /* synthetic */ BITRATE_MODE[] $VALUES = null;
        public static final BITRATE_MODE BITRATE_MODE_ABR = null;
        public static final BITRATE_MODE BITRATE_MODE_CBR = null;
        public static final BITRATE_MODE BITRATE_MODE_VBR = null;

        static {
            BITRATE_MODE r100 = new BITRATE_MODE("BITRATE_MODE_ABR", 0);
            BITRATE_MODE_ABR = r100;
            BITRATE_MODE r101 = new BITRATE_MODE("BITRATE_MODE_VBR", 1);
            BITRATE_MODE_VBR = r101;
            BITRATE_MODE r102 = new BITRATE_MODE("BITRATE_MODE_CBR", 2);
            BITRATE_MODE_CBR = r102;
            $VALUES = new BITRATE_MODE[]{r100, r101, r102};
        }

        public static BITRATE_MODE[] values() {
            return (BITRATE_MODE[]) $VALUES.clone();
        }

        public static BITRATE_MODE valueOf(String r100) {
            return (BITRATE_MODE) a.a(BITRATE_MODE.class, r100);
        }

        private BITRATE_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CAPTURE_TYPE extends Enum<CAPTURE_TYPE> {
        private static final /* synthetic */ CAPTURE_TYPE[] $VALUES = null;
        public static final CAPTURE_TYPE JAVA = null;
        public static final CAPTURE_TYPE NATIVE = null;

        static {
            CAPTURE_TYPE r100 = new CAPTURE_TYPE("NATIVE", 0);
            NATIVE = r100;
            CAPTURE_TYPE r101 = new CAPTURE_TYPE("JAVA", 1);
            JAVA = r101;
            $VALUES = new CAPTURE_TYPE[]{r100, r101};
        }

        public static CAPTURE_TYPE[] values() {
            return (CAPTURE_TYPE[]) $VALUES.clone();
        }

        public static CAPTURE_TYPE valueOf(String r100) {
            return (CAPTURE_TYPE) a.a(CAPTURE_TYPE.class, r100);
        }

        private CAPTURE_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DECODE_TYPE extends Enum<DECODE_TYPE> {
        private static final /* synthetic */ DECODE_TYPE[] $VALUES = null;
        public static final DECODE_TYPE DECODE_TYPE_HW = null;
        public static final DECODE_TYPE DECODE_TYPE_SW = null;

        static {
            DECODE_TYPE r100 = new DECODE_TYPE("DECODE_TYPE_SW", 0);
            DECODE_TYPE_SW = r100;
            DECODE_TYPE r101 = new DECODE_TYPE("DECODE_TYPE_HW", 1);
            DECODE_TYPE_HW = r101;
            $VALUES = new DECODE_TYPE[]{r100, r101};
        }

        public static DECODE_TYPE[] values() {
            return (DECODE_TYPE[]) $VALUES.clone();
        }

        public static DECODE_TYPE valueOf(String r100) {
            return (DECODE_TYPE) a.a(DECODE_TYPE.class, r100);
        }

        private DECODE_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum STREAM_TYPE extends Enum<STREAM_TYPE> {
        private static final /* synthetic */ STREAM_TYPE[] $VALUES = null;
        public static final STREAM_TYPE STREAM_ES = null;
        public static final STREAM_TYPE STREAM_RAW = null;

        static {
            STREAM_TYPE r100 = new STREAM_TYPE("STREAM_ES", 0);
            STREAM_ES = r100;
            STREAM_TYPE r101 = new STREAM_TYPE("STREAM_RAW", 1);
            STREAM_RAW = r101;
            $VALUES = new STREAM_TYPE[]{r100, r101};
        }

        public static STREAM_TYPE[] values() {
            return (STREAM_TYPE[]) $VALUES.clone();
        }

        public static STREAM_TYPE valueOf(String r100) {
            return (STREAM_TYPE) a.a(STREAM_TYPE.class, r100);
        }

        private STREAM_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TRANS_TYPE extends Enum<TRANS_TYPE> {
        private static final /* synthetic */ TRANS_TYPE[] $VALUES = null;
        public static final TRANS_TYPE DART = null;
        public static final TRANS_TYPE KCP = null;
        public static final TRANS_TYPE LLAMA = null;
        public static final TRANS_TYPE MOQ = null;
        public static final TRANS_TYPE RTMP = null;
        public static final TRANS_TYPE TCP = null;
        public static final TRANS_TYPE UDP = null;

        static {
            TRANS_TYPE r100 = new TRANS_TYPE("UDP", 0);
            UDP = r100;
            TRANS_TYPE r101 = new TRANS_TYPE("TCP", 1);
            TCP = r101;
            TRANS_TYPE r102 = new TRANS_TYPE("DART", 2);
            DART = r102;
            TRANS_TYPE r103 = new TRANS_TYPE("LLAMA", 3);
            LLAMA = r103;
            TRANS_TYPE r104 = new TRANS_TYPE("KCP", 4);
            KCP = r104;
            TRANS_TYPE r105 = new TRANS_TYPE("RTMP", 5);
            RTMP = r105;
            TRANS_TYPE r110 = new TRANS_TYPE("MOQ", 6);
            MOQ = r110;
            $VALUES = new TRANS_TYPE[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static TRANS_TYPE[] values() {
            return (TRANS_TYPE[]) $VALUES.clone();
        }

        public static TRANS_TYPE valueOf(String r100) {
            return (TRANS_TYPE) a.a(TRANS_TYPE.class, r100);
        }

        private TRANS_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VCODEC_ID extends Enum<VCODEC_ID> {
        private static final /* synthetic */ VCODEC_ID[] $VALUES = null;
        public static final VCODEC_ID AUTO = null;
        public static final VCODEC_ID H264 = null;
        public static final VCODEC_ID H265 = null;
        public static final VCODEC_ID LOSSLESS = null;

        static {
            VCODEC_ID r100 = new VCODEC_ID("AUTO", 0);
            AUTO = r100;
            VCODEC_ID r101 = new VCODEC_ID("H264", 1);
            H264 = r101;
            VCODEC_ID r102 = new VCODEC_ID("H265", 2);
            H265 = r102;
            VCODEC_ID r103 = new VCODEC_ID("LOSSLESS", 3);
            LOSSLESS = r103;
            $VALUES = new VCODEC_ID[]{r100, r101, r102, r103};
        }

        public static VCODEC_ID[] values() {
            return (VCODEC_ID[]) $VALUES.clone();
        }

        public static VCODEC_ID valueOf(String r100) {
            return (VCODEC_ID) a.a(VCODEC_ID.class, r100);
        }

        private VCODEC_ID(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VIDEO_SOURCE_TYPE extends Enum<VIDEO_SOURCE_TYPE> {
        private static final /* synthetic */ VIDEO_SOURCE_TYPE[] $VALUES = null;
        public static final VIDEO_SOURCE_TYPE CAMERA = null;
        public static final VIDEO_SOURCE_TYPE EXTERNAL_DATA = null;
        public static final VIDEO_SOURCE_TYPE EXTERNAL_SURFACE = null;
        public static final VIDEO_SOURCE_TYPE SCREEN = null;

        static {
            VIDEO_SOURCE_TYPE r100 = new VIDEO_SOURCE_TYPE("SCREEN", 0);
            SCREEN = r100;
            VIDEO_SOURCE_TYPE r101 = new VIDEO_SOURCE_TYPE("CAMERA", 1);
            CAMERA = r101;
            VIDEO_SOURCE_TYPE r102 = new VIDEO_SOURCE_TYPE("EXTERNAL_SURFACE", 2);
            EXTERNAL_SURFACE = r102;
            VIDEO_SOURCE_TYPE r103 = new VIDEO_SOURCE_TYPE("EXTERNAL_DATA", 3);
            EXTERNAL_DATA = r103;
            $VALUES = new VIDEO_SOURCE_TYPE[]{r100, r101, r102, r103};
        }

        public static VIDEO_SOURCE_TYPE[] values() {
            return (VIDEO_SOURCE_TYPE[]) $VALUES.clone();
        }

        public static VIDEO_SOURCE_TYPE valueOf(String r100) {
            return (VIDEO_SOURCE_TYPE) a.a(VIDEO_SOURCE_TYPE.class, r100);
        }

        private VIDEO_SOURCE_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static boolean isHWDecodeSupported() {
        return true;
    }

    public AVSYNC_TYPE getAVSyncType() {
        return this.mAVSyncType;
    }

    public RTCAudioProfile getAudioProfile() {
        return this.mAudioProfile;
    }

    public TRANS_TYPE getAudioTransType() {
        return this.mAudioTransType;
    }

    public CAPTURE_TYPE getCaptureType() {
        return this.mCaptureType;
    }

    public DECODE_TYPE getDecodeType() {
        return this.mDecodeType;
    }

    public int getLatencyMs() {
        return this.latencyMs;
    }

    public int getPort() {
        return this.mPort;
    }

    public RTCScreenProfile getScreenProfile() {
        return this.mScreenProfile;
    }

    public STREAM_TYPE getStreamType() {
        return this.mStreamType;
    }

    public RTCVideoProfile getVideoProfile() {
        return this.mVideoProfile;
    }

    public VIDEO_SOURCE_TYPE getVideoSourceType() {
        return this.mVideoSourceType;
    }

    public TRANS_TYPE getVideoTransType() {
        return this.mVideoTransType;
    }

    public boolean isDecodedByUser() {
        return this.bDecodedByUser;
    }

    public boolean isEnableSourceOpengl() {
        return this.mEnableSourceOpengl;
    }

    public boolean isEnableVideoNativeDecode() {
        return this.bEnableVideoNativeDecode;
    }

    public boolean isExternalAudioSource() {
        return this.mIsExternalAudioSource;
    }

    public boolean isExternalScreenSource() {
        return this.mIsExternalScreenSource;
    }

    public boolean isExternalVideoSource() {
        return this.mIsExternalVideoSource;
    }

    public boolean isbEnableAudioCallback() {
        return this.bEnableAudioCallback;
    }

    public boolean isbEnableAudioMixer() {
        return this.bEnableAudioMixer;
    }

    public RTCSetting(ContextManager.CastContext r100) {
        this.mIsExternalVideoSource = false;
        this.mIsExternalAudioSource = false;
        this.mIsExternalScreenSource = false;
        this.bEnableAudioCallback = false;
        this.bEnableAudioMixer = true;
        this.bEnableVideoNativeDecode = false;
        DECODE_TYPE r101 = DECODE_TYPE.DECODE_TYPE_HW;
        this.mDecodeType = r101;
        STREAM_TYPE r102 = STREAM_TYPE.STREAM_ES;
        this.mStreamType = r102;
        AVSYNC_TYPE r103 = AVSYNC_TYPE.SYNC_LOW_LATENCY;
        this.mAVSyncType = r103;
        this.mCaptureType = CAPTURE_TYPE.JAVA;
        this.mAudioTransType = TRANS_TYPE.UDP;
        this.mVideoTransType = TRANS_TYPE.TCP;
        this.mPort = 3229;
        this.mVideoSourceType = VIDEO_SOURCE_TYPE.SCREEN;
        this.latencyMs = 0;
        this.bDecodedByUser = false;
        this.mEnableSourceOpengl = true;
        this.mDecodeType = r101;
        this.mStreamType = r102;
        this.mAVSyncType = r103;
        this.mPort = 3229;
        this.mCastContext = r100;
        this.mAudioProfile = new RTCAudioProfile(r100);
        this.mVideoProfile = new RTCVideoProfile(r100);
        this.mScreenProfile = new RTCScreenProfile(r100);
    }

    public static ACODEC_ID valueOfAudio(int r100) {
        if (r100 == 1) goto L20;
        if (r100 == 3) goto L18;
        switch(r100) {
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            default: goto L8;
        };
    L8:
        return ACODEC_ID.AUTO;
    L10:
        return ACODEC_ID.AAC;
    L12:
        return ACODEC_ID.OPUS_8K;
    L14:
        return ACODEC_ID.OPUSFEC2;
    L16:
        return ACODEC_ID.OPUSFEC1;
    L18:
        return ACODEC_ID.OPUS;
    L20:
        return ACODEC_ID.ISACFIX;
    }

    public static VCODEC_ID valueOfVideo(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return VCODEC_ID.AUTO;
    L11:
        return VCODEC_ID.LOSSLESS;
    L13:
        return VCODEC_ID.H265;
    L15:
        return VCODEC_ID.H264;
    }

    public boolean isAutoPublish(RTCMediaKind r100) {
        if (r100 != RTCMediaKind.AUDIO) goto L7;
        return this.mAudioProfile.isAutoPublish();
    L7:
        if (r100 == RTCMediaKind.VIDEO) goto L9;
        RTCMediaKind r101 = RTCMediaKind.AUDIO;
        return false;
    L9:
        return this.mVideoProfile.isAutoPublish();
    }

    public boolean isAutoSubscribe(RTCMediaKind r100) {
        if (r100 == RTCMediaKind.AUDIO) goto L5;
        return false;
    L5:
        return this.mAudioProfile.isAutoSubscribe();
    }

    public void setAVSyncType(AVSYNC_TYPE r100) {
        this.mAVSyncType = r100;
    }

    public RTCSetting setAudioProfile(RTCAudioProfile r100) {
        this.mAudioProfile = r100;
        return this;
    }

    public void setAudioTransType(TRANS_TYPE r100) {
        this.mAudioTransType = r100;
    }

    public void setCaptureType(CAPTURE_TYPE r100) {
        this.mCaptureType = r100;
    }

    public void setDecodeType(DECODE_TYPE r100) {
        if (isHWDecodeSupported() == false) goto L5;
    L7:
        this.mDecodeType = r100;
        return;
    L5:
        if (r100 != DECODE_TYPE.DECODE_TYPE_HW) goto L7;
    }

    public void setDecodedByUser(boolean r100) {
        this.bDecodedByUser = r100;
    }

    public void setEnableSourceOpengl(boolean r100) {
        this.mEnableSourceOpengl = r100;
    }

    public void setEnableVideoNativeDecode(boolean r100) {
        this.bEnableVideoNativeDecode = r100;
    }

    public RTCSetting setExternalAudioSource(boolean r100) {
        this.mIsExternalAudioSource = r100;
        return this;
    }

    public RTCSetting setExternalScreenSource(boolean r100) {
        this.mIsExternalScreenSource = r100;
        return this;
    }

    public RTCSetting setExternalVideoSource(boolean r100) {
        this.mIsExternalVideoSource = r100;
        return this;
    }

    public void setLatencyMs(int r100) {
        this.latencyMs = r100;
    }

    public void setPort(int r100) {
        this.mPort = r100;
    }

    public RTCSetting setScreenProfile(RTCScreenProfile r100) {
        this.mScreenProfile = r100;
        return this;
    }

    public void setStreamType(STREAM_TYPE r100) {
        this.mStreamType = r100;
    }

    public RTCSetting setVideoProfile(RTCVideoProfile r100) {
        this.mVideoProfile = r100;
        return this;
    }

    public void setVideoSourceType(VIDEO_SOURCE_TYPE r100) {
        this.mVideoSourceType = r100;
    }

    public void setVideoTransType(TRANS_TYPE r100) {
        this.mVideoTransType = r100;
    }

    public void setbEnableAudioCallback(boolean r100) {
        this.bEnableAudioCallback = r100;
    }

    public void setbEnableAudioMixer(boolean r100) {
        this.bEnableAudioMixer = r100;
    }
}
