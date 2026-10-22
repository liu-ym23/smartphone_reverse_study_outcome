package com.byted.cast.sdk;

import android.os.Build;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class RTCScreenProfile implements Cloneable {
    public static final String TAG = "RTCScreenProfile";

    @SerializedName("bitrate")
    private int mBitrate;

    @SerializedName("bitrateBps")
    private Integer mBitrateBps;

    @SerializedName("bitrateMode")
    private RTCSetting.BITRATE_MODE mBitrateMode;

    @SerializedName("castContext")
    private ContextManager.CastContext mCastContext;

    @SerializedName("codecId")
    private RTCSetting.VCODEC_ID mCodecId;

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

    @SerializedName("logger")
    private CastLogger mLogger;

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

    @SerializedName("projectMode")
    private PROJECTION_MODE mProjectionMode;

    @SerializedName("QP")
    private Integer mQp;

    @SerializedName("sccType")
    private SCC_TYPE mSccType;

    @SerializedName("width")
    private int mWidth;

    @SerializedName("MediaCodecFormat")
    Map<String, Integer> mediaFormatConfig;

    @SerializedName("virtualDisplayFlag")
    private int virtualDisplayFlag;

    @SerializedName("virtualDisplayName")
    private String virtualDisplayName;

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

    public RTCScreenProfile clone() {
        return (RTCScreenProfile) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public Integer getBitrateBps() {
        return this.mBitrateBps;
    }

    public RTCSetting.BITRATE_MODE getBitrateMode() {
        return this.mBitrateMode;
    }

    public RTCSetting.VCODEC_ID getCodecId() {
        return this.mCodecId;
    }

    public int getDpi() {
        return this.mDpi;
    }

    public int getFps() {
        return this.mFps;
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

    public int getVirtualDisplayFlag() {
        return this.virtualDisplayFlag;
    }

    public String getVirtualDisplayName() {
        return this.virtualDisplayName;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isFixedResolution() {
        return this.mIsFixedResolution;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8145clone() throws CloneNotSupportedException {
        return clone();
    }

    public RTCScreenProfile(ContextManager.CastContext r100) {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDpi = 480;
        this.mCodecId = RTCSetting.VCODEC_ID.H264;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        this.mBitrate = 16000;
        this.mMaxBitrate = 19200;
        this.mFps = 60;
        this.mIsFixedResolution = true;
        this.mSccType = SCC_TYPE.NONE;
        this.mIsEnabled = true;
        this.mProjectionMode = PROJECTION_MODE.PHONE_MIRROR;
        this.virtualDisplayFlag = 1;
        this.virtualDisplayName = "";
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
        this.mBitrateBps = null;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
    }

    public RTCScreenProfile setBitrateBps(Integer r100) {
        this.mBitrateBps = r100;
        return this;
    }

    public RTCScreenProfile setBitrateMode(RTCSetting.BITRATE_MODE r100) {
        this.mBitrateMode = r100;
        return this;
    }

    public RTCScreenProfile setCodecId(RTCSetting.VCODEC_ID r100) {
        this.mCodecId = r100;
        return this;
    }

    public RTCScreenProfile setDpi(int r100) {
        this.mDpi = r100;
        return this;
    }

    public RTCScreenProfile setEnabled(boolean r100) {
        this.mIsEnabled = r100;
        return this;
    }

    public RTCScreenProfile setFixedResolution(boolean r100) {
        this.mIsFixedResolution = r100;
        return this;
    }

    public RTCScreenProfile setInitialQP(Integer r100) {
        this.mInitialQP = r100;
        return this;
    }

    public RTCScreenProfile setInitialQPB(Integer r100) {
        this.mInitialQPB = r100;
        return this;
    }

    public RTCScreenProfile setInitialQPI(Integer r100) {
        this.mInitialQPI = r100;
        return this;
    }

    public RTCScreenProfile setInitialQPP(Integer r100) {
        this.mInitialQPP = r100;
        return this;
    }

    public RTCScreenProfile setMaxQP(Integer r100) {
        this.mMaxQP = r100;
        return this;
    }

    public RTCScreenProfile setMaxQPB(Integer r100) {
        this.mMaxQPB = r100;
        return this;
    }

    public RTCScreenProfile setMaxQPP(Integer r100) {
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
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_VBR;
        goto L17
    L13:
        if (r101 == 2) goto L15;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        goto L17
    L15:
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_CBR;
        goto L17
    }

    public RTCScreenProfile setMinQP(Integer r100) {
        this.mMinQP = r100;
        return this;
    }

    public RTCScreenProfile setMinQPB(Integer r100) {
        this.mMinQPB = r100;
        return this;
    }

    public RTCScreenProfile setMinQPP(Integer r100) {
        this.mMinQPP = r100;
        return this;
    }

    public void setProjectionMode(PROJECTION_MODE r100) {
        this.mProjectionMode = r100;
    }

    public RTCScreenProfile setQp(Integer r100) {
        this.mQp = r100;
        return this;
    }

    public RTCScreenProfile setSccType(SCC_TYPE r100) {
        this.mSccType = r100;
        return this;
    }

    public void setVirtualDisplayFlag(int r100) {
        this.virtualDisplayFlag = r100;
    }

    public void setVirtualDisplayName(String r100) {
        this.virtualDisplayName = r100;
    }

    public void setmFps(int r100) {
        this.mFps = r100;
    }

    public RTCScreenProfile setBitrate(int r100, int r101) {
        this.mBitrate = r100;
        this.mMaxBitrate = r101;
        return this;
    }

    public RTCScreenProfile setResolution(int r100, int r101) {
        this.mWidth = r100;
        this.mHeight = r101;
        return this;
    }
}
