package com.byted.cast.mediacommon;

import com.byted.cast.common.config.Config;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class MediaSetting {
    private AudioProfile mAudioProfile;
    private Config mConfig;
    private boolean mEnableAudioFocus;
    private boolean mEnableOrientationEventListener;
    private boolean mIsExternalAudioSource;
    private boolean mIsExternalScreenSource;
    private STREAM_TYPE mStreamType;
    private VideoProfile mVideoProfile;

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

    public static final enum FILL_TYPE extends Enum<FILL_TYPE> {
        private static final /* synthetic */ FILL_TYPE[] $VALUES = null;
        public static final FILL_TYPE PADDING = null;
        public static final FILL_TYPE SCALE = null;

        static {
            FILL_TYPE r100 = new FILL_TYPE("SCALE", 0);
            SCALE = r100;
            FILL_TYPE r101 = new FILL_TYPE("PADDING", 1);
            PADDING = r101;
            $VALUES = new FILL_TYPE[]{r100, r101};
        }

        public static FILL_TYPE[] values() {
            return (FILL_TYPE[]) $VALUES.clone();
        }

        public static FILL_TYPE valueOf(String r100) {
            return (FILL_TYPE) a.a(FILL_TYPE.class, r100);
        }

        private FILL_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PROJECTION_MODE extends Enum<PROJECTION_MODE> {
        private static final /* synthetic */ PROJECTION_MODE[] $VALUES = null;
        public static final PROJECTION_MODE PHONE_MIRROR = null;
        public static final PROJECTION_MODE TNT_DESKTOP = null;

        static {
            PROJECTION_MODE r100 = new PROJECTION_MODE("TNT_DESKTOP", 0);
            TNT_DESKTOP = r100;
            PROJECTION_MODE r101 = new PROJECTION_MODE("PHONE_MIRROR", 1);
            PHONE_MIRROR = r101;
            $VALUES = new PROJECTION_MODE[]{r100, r101};
        }

        public static PROJECTION_MODE[] values() {
            return (PROJECTION_MODE[]) $VALUES.clone();
        }

        public static PROJECTION_MODE valueOf(String r100) {
            return (PROJECTION_MODE) a.a(PROJECTION_MODE.class, r100);
        }

        private PROJECTION_MODE(String r100, int r101) {
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
        public static final VIDEO_SOURCE_TYPE EXTERNAL_SURFACE = null;
        public static final VIDEO_SOURCE_TYPE EXTERNAL_VIDEO = null;
        public static final VIDEO_SOURCE_TYPE SCREEN = null;

        static {
            VIDEO_SOURCE_TYPE r100 = new VIDEO_SOURCE_TYPE("SCREEN", 0);
            SCREEN = r100;
            VIDEO_SOURCE_TYPE r101 = new VIDEO_SOURCE_TYPE("CAMERA", 1);
            CAMERA = r101;
            VIDEO_SOURCE_TYPE r102 = new VIDEO_SOURCE_TYPE("EXTERNAL_SURFACE", 2);
            EXTERNAL_SURFACE = r102;
            VIDEO_SOURCE_TYPE r103 = new VIDEO_SOURCE_TYPE("EXTERNAL_VIDEO", 3);
            EXTERNAL_VIDEO = r103;
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

    public static final enum VideoFormat extends Enum<VideoFormat> {
        private static final /* synthetic */ VideoFormat[] $VALUES = null;
        public static final VideoFormat VIDEO_FORMAT_ABGR = null;
        public static final VideoFormat VIDEO_FORMAT_ARGB = null;
        public static final VideoFormat VIDEO_FORMAT_BGR24 = null;
        public static final VideoFormat VIDEO_FORMAT_BGRA = null;
        public static final VideoFormat VIDEO_FORMAT_ES_H264 = null;
        public static final VideoFormat VIDEO_FORMAT_ES_H265 = null;
        public static final VideoFormat VIDEO_FORMAT_I420 = null;
        public static final VideoFormat VIDEO_FORMAT_NV12 = null;
        public static final VideoFormat VIDEO_FORMAT_NV21 = null;
        public static final VideoFormat VIDEO_FORMAT_RGB24 = null;
        public static final VideoFormat VIDEO_FORMAT_RGB565 = null;
        public static final VideoFormat VIDEO_FORMAT_RGBA = null;
        public static final VideoFormat VIDEO_FORMAT_YUV422P = null;
        public static final VideoFormat VIDEO_FORMAT_YUYV422 = null;
        public static final VideoFormat VIDEO_FORMAT_YVYU422 = null;

        static {
            VideoFormat r100 = new VideoFormat("VIDEO_FORMAT_NV12", 0);
            VIDEO_FORMAT_NV12 = r100;
            VideoFormat r101 = new VideoFormat("VIDEO_FORMAT_NV21", 1);
            VIDEO_FORMAT_NV21 = r101;
            VideoFormat r102 = new VideoFormat("VIDEO_FORMAT_I420", 2);
            VIDEO_FORMAT_I420 = r102;
            VideoFormat r103 = new VideoFormat("VIDEO_FORMAT_YUYV422", 3);
            VIDEO_FORMAT_YUYV422 = r103;
            VideoFormat r104 = new VideoFormat("VIDEO_FORMAT_YVYU422", 4);
            VIDEO_FORMAT_YVYU422 = r104;
            VideoFormat r105 = new VideoFormat("VIDEO_FORMAT_YUV422P", 5);
            VIDEO_FORMAT_YUV422P = r105;
            VideoFormat r110 = new VideoFormat("VIDEO_FORMAT_RGB565", 6);
            VIDEO_FORMAT_RGB565 = r110;
            VideoFormat r111 = new VideoFormat("VIDEO_FORMAT_RGB24", 7);
            VIDEO_FORMAT_RGB24 = r111;
            VideoFormat r112 = new VideoFormat("VIDEO_FORMAT_BGR24", 8);
            VIDEO_FORMAT_BGR24 = r112;
            VideoFormat r113 = new VideoFormat("VIDEO_FORMAT_ARGB", 9);
            VIDEO_FORMAT_ARGB = r113;
            VideoFormat r114 = new VideoFormat("VIDEO_FORMAT_RGBA", 10);
            VIDEO_FORMAT_RGBA = r114;
            VideoFormat r115 = new VideoFormat("VIDEO_FORMAT_ABGR", 11);
            VIDEO_FORMAT_ABGR = r115;
            VideoFormat r106 = new VideoFormat("VIDEO_FORMAT_BGRA", 12);
            VIDEO_FORMAT_BGRA = r106;
            VideoFormat r107 = new VideoFormat("VIDEO_FORMAT_ES_H264", 13);
            VIDEO_FORMAT_ES_H264 = r107;
            VideoFormat r108 = new VideoFormat("VIDEO_FORMAT_ES_H265", 14);
            VIDEO_FORMAT_ES_H265 = r108;
            $VALUES = new VideoFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public static VideoFormat[] values() {
            return (VideoFormat[]) $VALUES.clone();
        }

        public static VideoFormat valueOf(String r100) {
            return (VideoFormat) a.a(VideoFormat.class, r100);
        }

        private VideoFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return this.mVideoProfile.toString() + "\n" + this.mAudioProfile.toString() + "\n";
    }

    public boolean enableOrientationEventListener() {
        return this.mEnableOrientationEventListener;
    }

    public AudioProfile getAudioProfile() {
        return this.mAudioProfile;
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public VideoProfile getVideoProfile() {
        return this.mVideoProfile;
    }

    public boolean isEnableAudioFocus() {
        return this.mEnableAudioFocus;
    }

    public boolean isExternalAudioSource() {
        return this.mIsExternalAudioSource;
    }

    public boolean isExternalScreenSource() {
        return this.mIsExternalScreenSource;
    }

    public void enableAudioFocus(boolean r100) {
        this.mEnableAudioFocus = r100;
    }

    public void setConfig(Config r100) {
        this.mConfig = r100;
    }

    public void setEnableOrientationEventListener(boolean r100) {
        this.mEnableOrientationEventListener = r100;
    }

    public MediaSetting(boolean r100, boolean r101) {
        this.mStreamType = STREAM_TYPE.STREAM_ES;
        this.mEnableOrientationEventListener = false;
        this.mEnableAudioFocus = true;
        this.mIsExternalScreenSource = r100;
        this.mIsExternalAudioSource = r101;
        this.mVideoProfile = new VideoProfile();
        this.mAudioProfile = new AudioProfile();
        this.mConfig = new Config();
    }
}
