package com.byted.cast.mediacommon;

import android.os.Build;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class VideoProfile implements Cloneable {
    public static final String TAG = "RTCScreenProfile";

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private int I_FRAME_INTERVAL;

    @SerializedName("camera")
    private int cameraInfo;

    @SerializedName("enableOpenGL")
    private boolean enableOpenGL;
    private AVSYNC_TYPE mAVSyncType;

    @SerializedName("bitrate")
    private int mBitrate;

    @SerializedName("bitrateBps")
    private Integer mBitrateBps;

    @SerializedName("bitrateMode")
    private MediaSetting.BITRATE_MODE mBitrateMode;

    @SerializedName("bitrateModeStr")
    private String mBitrateModeStr;

    @SerializedName("codecId")
    private MediaSetting.VCODEC_ID mCodecId;

    @SerializedName("dpi")
    private int mDpi;

    @SerializedName("mFps")
    private int mFps;

    @SerializedName("height")
    private int mHeight;

    @SerializedName("initialQP")
    private Integer mInitialQP;

    @SerializedName("initialQPB")
    private Integer mInitialQPB;

    @SerializedName("initialQPI")
    private Integer mInitialQPI;

    @SerializedName("initialQPP")
    private Integer mInitialQPP;

    @SerializedName("isEnabled")
    private boolean mIsEnabled;

    @SerializedName("fixedResolution")
    private boolean mIsFixedResolution;

    @SerializedName("maxBitrate")
    private int mMaxBitrate;

    @SerializedName("maxQP")
    private Integer mMaxQP;

    @SerializedName("maxQPB")
    private Integer mMaxQPB;

    @SerializedName("maxQPP")
    private Integer mMaxQPP;

    @SerializedName("minQP")
    private Integer mMinQP;

    @SerializedName("minQPB")
    private Integer mMinQPB;

    @SerializedName("minQPP")
    private Integer mMinQPP;

    @SerializedName("resize")
    private boolean mNeedResize;

    @SerializedName("projectMode")
    private PROJECTION_MODE mProjectionMode;

    @SerializedName("QP")
    private Integer mQp;

    @SerializedName("sccType")
    private SCC_TYPE mSccType;

    @SerializedName("sourceType")
    private MediaSetting.VIDEO_SOURCE_TYPE mSourceType;

    @SerializedName("startCert")
    private Object mStartCert;

    @SerializedName("stopCert")
    private Object mStopCert;
    private MediaSetting.STREAM_TYPE mStreamType;

    @SerializedName("mVirtualDisplayFlag")
    private int mVirtualDisplayFlag;

    @SerializedName("VirtualDisplayHeight")
    private int mVirtualDisplayHeight;

    @SerializedName("mVirtualDisplayName")
    private String mVirtualDisplayName;

    @SerializedName("VirtualDisplayWidth")
    private int mVirtualDisplayWidth;

    @SerializedName("width")
    private int mWidth;

    @SerializedName("MediaCodecFormat")
    Map<String, Integer> mediaFormatConfig;

    @SerializedName("enableModifyFps")
    private boolean modifyFps;

    @SerializedName("enableSetMaxFps")
    private boolean setMaxFps;

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

    public static final enum SCC_TYPE extends Enum<SCC_TYPE> {
        private static final /* synthetic */ SCC_TYPE[] $VALUES = null;
        public static final SCC_TYPE COMPATIBLE = null;
        public static final SCC_TYPE FULL_FEATURE = null;
        public static final SCC_TYPE NONE = null;

        static {
            SCC_TYPE r100 = new SCC_TYPE(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            SCC_TYPE r101 = new SCC_TYPE("COMPATIBLE", 1);
            COMPATIBLE = r101;
            SCC_TYPE r102 = new SCC_TYPE("FULL_FEATURE", 2);
            FULL_FEATURE = r102;
            $VALUES = new SCC_TYPE[]{r100, r101, r102};
        }

        public static SCC_TYPE[] values() {
            return (SCC_TYPE[]) $VALUES.clone();
        }

        public static SCC_TYPE valueOf(String r100) {
            return (SCC_TYPE) a.a(SCC_TYPE.class, r100);
        }

        private SCC_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public VideoProfile() {
        this.mVirtualDisplayWidth = TECameraUtils.CAPTURE_NORMAL;
        this.mVirtualDisplayHeight = 1080;
        this.mWidth = TECameraUtils.CAPTURE_NORMAL;
        this.mHeight = 1080;
        this.mDpi = 480;
        this.mNeedResize = false;
        this.mCodecId = MediaSetting.VCODEC_ID.H264;
        this.mBitrateMode = MediaSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        this.mSourceType = MediaSetting.VIDEO_SOURCE_TYPE.SCREEN;
        this.mBitrate = 16000;
        this.mMaxBitrate = 19200;
        this.mFps = 30;
        this.mVirtualDisplayFlag = 16;
        this.mVirtualDisplayName = "VirtualDisplay-Recorder";
        this.I_FRAME_INTERVAL = 60;
        this.cameraInfo = 1;
        this.mStartCert = null;
        this.mStopCert = null;
        this.mIsFixedResolution = true;
        this.mSccType = SCC_TYPE.NONE;
        this.mIsEnabled = true;
        this.modifyFps = false;
        this.setMaxFps = true;
        this.enableOpenGL = true;
        this.mProjectionMode = PROJECTION_MODE.PHONE_MIRROR;
        this.mMinQP = null;
        this.mMaxQP = null;
        this.mMinQPP = null;
        this.mMaxQPP = null;
        this.mMinQPB = null;
        this.mMaxQPB = null;
        this.mInitialQP = null;
        this.mInitialQPI = null;
        this.mInitialQPP = null;
        this.mInitialQPB = null;
        this.mQp = null;
        this.mBitrateModeStr = null;
        this.mBitrateBps = null;
        this.mAVSyncType = AVSYNC_TYPE.SYNC_LOW_LATENCY;
        this.mStreamType = MediaSetting.STREAM_TYPE.STREAM_ES;
    }

    public VideoProfile clone() {
        return (VideoProfile) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public AVSYNC_TYPE getAVSyncType() {
        return this.mAVSyncType;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public Integer getBitrateBps() {
        return this.mBitrateBps;
    }

    public MediaSetting.BITRATE_MODE getBitrateMode() {
        return this.mBitrateMode;
    }

    public String getBitrateModeStr() {
        return this.mBitrateModeStr;
    }

    public int getCameraInfo() {
        return this.cameraInfo;
    }

    public MediaSetting.VCODEC_ID getCodecId() {
        return this.mCodecId;
    }

    public int getDpi() {
        return this.mDpi;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getFrameInterval() {
        return this.I_FRAME_INTERVAL;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Integer getInitialQP() {
        return this.mInitialQP;
    }

    public Integer getInitialQPB() {
        return this.mInitialQPB;
    }

    public Integer getInitialQPI() {
        return this.mInitialQPI;
    }

    public Integer getInitialQPP() {
        return this.mInitialQPP;
    }

    public int getMaxBitrate() {
        return this.mMaxBitrate;
    }

    public Integer getMaxQP() {
        return this.mMaxQP;
    }

    public Integer getMaxQPB() {
        return this.mMaxQPB;
    }

    public Integer getMaxQPP() {
        return this.mMaxQPP;
    }

    public Map<String, Integer> getMediaFormat() {
        return this.mediaFormatConfig;
    }

    public Integer getMinQP() {
        return this.mMinQP;
    }

    public Integer getMinQPB() {
        return this.mMinQPB;
    }

    public Integer getMinQPP() {
        return this.mMinQPP;
    }

    public PROJECTION_MODE getProjectionMode() {
        return this.mProjectionMode;
    }

    public Integer getQp() {
        return this.mQp;
    }

    public SCC_TYPE getSccType() {
        return this.mSccType;
    }

    public MediaSetting.VIDEO_SOURCE_TYPE getSourceType() {
        return this.mSourceType;
    }

    public MediaSetting.STREAM_TYPE getStreamType() {
        return this.mStreamType;
    }

    public int getVirtualDisplayFlag() {
        return this.mVirtualDisplayFlag;
    }

    public int getVirtualDisplayHeight() {
        return this.mVirtualDisplayHeight;
    }

    public String getVirtualDisplayName() {
        return this.mVirtualDisplayName;
    }

    public int getVirtualDisplayWidth() {
        return this.mVirtualDisplayWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isEnableModifyFps() {
        return this.modifyFps;
    }

    public boolean isEnableSetMaxFps() {
        return this.setMaxFps;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isFixedResolution() {
        return this.mIsFixedResolution;
    }

    public boolean isNeedResize() {
        return this.mNeedResize;
    }

    public boolean isOpenGlEnable() {
        return this.enableOpenGL;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8143clone() throws CloneNotSupportedException {
        return clone();
    }

    public void enableModifyFps(boolean r100) {
        this.modifyFps = r100;
    }

    public void enableOpenGL(boolean r100) {
        this.enableOpenGL = r100;
    }

    public void enableSetMaxFps(boolean r100) {
        this.setMaxFps = r100;
    }

    public void setAVSyncType(AVSYNC_TYPE r100) {
        this.mAVSyncType = r100;
    }

    public VideoProfile setBitrateBps(Integer r100) {
        this.mBitrateBps = r100;
        return this;
    }

    public VideoProfile setBitrateModeStr(String r100) {
        this.mBitrateModeStr = r100;
        return this;
    }

    public void setCameraInfo(int r100) {
        this.cameraInfo = r100;
    }

    public VideoProfile setCodecId(MediaSetting.VCODEC_ID r100) {
        this.mCodecId = r100;
        return this;
    }

    public VideoProfile setDpi(int r100) {
        this.mDpi = r100;
        return this;
    }

    public VideoProfile setEnabled(boolean r100) {
        this.mIsEnabled = r100;
        return this;
    }

    public VideoProfile setFixedResolution(boolean r100) {
        this.mIsFixedResolution = r100;
        return this;
    }

    public void setFps(int r100) {
        this.mFps = r100;
    }

    public void setFrameInterval(int r100) {
        this.I_FRAME_INTERVAL = r100;
    }

    public VideoProfile setInitialQP(Integer r100) {
        this.mInitialQP = r100;
        return this;
    }

    public VideoProfile setInitialQPB(Integer r100) {
        this.mInitialQPB = r100;
        return this;
    }

    public VideoProfile setInitialQPI(Integer r100) {
        this.mInitialQPI = r100;
        return this;
    }

    public VideoProfile setInitialQPP(Integer r100) {
        this.mInitialQPP = r100;
        return this;
    }

    public VideoProfile setMaxQP(Integer r100) {
        this.mMaxQP = r100;
        return this;
    }

    public VideoProfile setMaxQPB(Integer r100) {
        this.mMaxQPB = r100;
        return this;
    }

    public VideoProfile setMaxQPP(Integer r100) {
        this.mMaxQPP = r100;
        return this;
    }

    public boolean setMediaFormat(Map<String, Integer> r100) {
        this.mediaFormatConfig = r100;
        if (Build.VERSION.SDK_INT > 21) goto L7;
        return false;
    L7:
        if (r100 != null) goto L9;
    L17:
        return true;
    L9:
        if (r100.containsKey("bitrate-mode") == false) goto L17;
        int r101 = r100.get("bitrate-mode").intValue();
        if (r101 != 1) goto L13;
        this.mBitrateMode = MediaSetting.BITRATE_MODE.BITRATE_MODE_VBR;
        goto L17
    L13:
        if (r101 == 2) goto L15;
        this.mBitrateMode = MediaSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        goto L17
    L15:
        this.mBitrateMode = MediaSetting.BITRATE_MODE.BITRATE_MODE_CBR;
        goto L17
    }

    public VideoProfile setMinQP(Integer r100) {
        this.mMinQP = r100;
        return this;
    }

    public VideoProfile setMinQPB(Integer r100) {
        this.mMinQPB = r100;
        return this;
    }

    public VideoProfile setMinQPP(Integer r100) {
        this.mMinQPP = r100;
        return this;
    }

    public void setNeedResize(boolean r100) {
        this.mNeedResize = r100;
    }

    public void setProjectionMode(PROJECTION_MODE r100) {
        this.mProjectionMode = r100;
    }

    public VideoProfile setQp(Integer r100) {
        this.mQp = r100;
        return this;
    }

    public VideoProfile setSccType(SCC_TYPE r100) {
        this.mSccType = r100;
        return this;
    }

    public void setSourceType(MediaSetting.VIDEO_SOURCE_TYPE r100) {
        this.mSourceType = r100;
    }

    public void setVirtualDisplayFlag(int r100) {
        this.mVirtualDisplayFlag = r100;
    }

    public void setVirtualDisplayName(String r100) {
        this.mVirtualDisplayName = r100;
    }

    public VideoProfile setBitrate(int r100, int r101) {
        this.mBitrate = r100;
        this.mMaxBitrate = r101;
        return this;
    }

    public VideoProfile setResolution(int r100, int r101) {
        this.mWidth = r100;
        this.mHeight = r101;
        return this;
    }

    public void setVirtualDisplayWH(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L7;
        this.mVirtualDisplayWidth = r100;
        this.mVirtualDisplayHeight = r101;
        return;
    L7:
        return;
    }
}
