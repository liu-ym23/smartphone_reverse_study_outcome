package com.byted.cast.mediacommon;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import com.byted.cast.mediacommon.utils.Logger;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ttvecamera.TECameraUtils;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class AudioProfile implements Cloneable {
    public static final String TAG = "RTCAudioProfile";

    @SerializedName("audioAecType")
    private AEC_TYPE mAECType;

    @SerializedName("audioAgcType")
    private AGC_TYPE mAGCType;

    @SerializedName("audioAncType")
    private ANC_TYPE mANCType;

    @SerializedName("audioPtsOptimizeEnable")
    private boolean mAudioPtsOptimizeEnable;

    @SerializedName("audioSource")
    private int mAudioSource;

    @SerializedName("audioStreamType")
    private int mAudioStreamType;

    @SerializedName("bitrate")
    private int mBitrate;

    @SerializedName("audioBitrateMode")
    private MediaSetting.BITRATE_MODE mBitrateMode;

    @SerializedName("bitwidth")
    private int mBitwidth;

    @SerializedName("bluetoothSCOEnabled")
    private boolean mBluetoothSCOEnabled;

    @SerializedName("samplerate")
    private int mCaptureSampleRate;

    @SerializedName("codecId")
    private MediaSetting.ACODEC_ID mCodecId;

    @SerializedName("mEnableAudio")
    private boolean mEnableAudioPause;

    @SerializedName("mIsAudioPer10ms")
    private boolean mIsAudioPer10ms;

    @SerializedName("autoPublish")
    private boolean mIsAutoPublish;

    @SerializedName("autoSubscribe")
    private boolean mIsAutoSubscribe;

    @SerializedName("isEchoDetectionEnabled")
    private boolean mIsEchoDetectionEnabled;

    @SerializedName("mIsEnabled")
    private boolean mIsEnabled;

    @SerializedName("mIsEnabledAudioMix")
    private boolean mIsEnabledAudioMix;

    @SerializedName("isForceAudioMediaProjection")
    private boolean mIsForceAudioManager;

    @SerializedName("isHwAecEnabled")
    private boolean mIsHwAecEnabled;

    @SerializedName("isHwNSEnabled")
    private boolean mIsHwNSEnabled;

    @SerializedName("mIsSeparateAudio")
    private boolean mIsSeparateAudio;

    @SerializedName("maxBitrate")
    private int mMaxBitrate;

    @SerializedName("channels")
    private int mNumberOfChannels;

    @SerializedName("pbsamplerate")
    private int mPlaybackSampleRate;

    public static final enum AEC_TYPE extends Enum<AEC_TYPE> {
        private static final /* synthetic */ AEC_TYPE[] $VALUES = null;
        public static final AEC_TYPE AEC3 = null;
        public static final AEC_TYPE AECM = null;
        public static final AEC_TYPE AUTO = null;
        public static final AEC_TYPE BYTE = null;
        public static final AEC_TYPE NONE = null;

        static {
            AEC_TYPE r100 = new AEC_TYPE(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AEC_TYPE r101 = new AEC_TYPE("AUTO", 1);
            AUTO = r101;
            AEC_TYPE r102 = new AEC_TYPE("AEC3", 2);
            AEC3 = r102;
            AEC_TYPE r103 = new AEC_TYPE("AECM", 3);
            AECM = r103;
            AEC_TYPE r104 = new AEC_TYPE("BYTE", 4);
            BYTE = r104;
            $VALUES = new AEC_TYPE[]{r100, r101, r102, r103, r104};
        }

        public static AEC_TYPE[] values() {
            return (AEC_TYPE[]) $VALUES.clone();
        }

        public static AEC_TYPE valueOf(String r100) {
            return (AEC_TYPE) a.a(AEC_TYPE.class, r100);
        }

        private AEC_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum AGC_TYPE extends Enum<AGC_TYPE> {
        private static final /* synthetic */ AGC_TYPE[] $VALUES = null;
        public static final AGC_TYPE AUTO = null;
        public static final AGC_TYPE BYTE = null;
        public static final AGC_TYPE NONE = null;
        public static final AGC_TYPE WEBRTC = null;

        static {
            AGC_TYPE r100 = new AGC_TYPE(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AGC_TYPE r101 = new AGC_TYPE("AUTO", 1);
            AUTO = r101;
            AGC_TYPE r102 = new AGC_TYPE("WEBRTC", 2);
            WEBRTC = r102;
            AGC_TYPE r103 = new AGC_TYPE("BYTE", 3);
            BYTE = r103;
            $VALUES = new AGC_TYPE[]{r100, r101, r102, r103};
        }

        public static AGC_TYPE[] values() {
            return (AGC_TYPE[]) $VALUES.clone();
        }

        public static AGC_TYPE valueOf(String r100) {
            return (AGC_TYPE) a.a(AGC_TYPE.class, r100);
        }

        private AGC_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ANC_TYPE extends Enum<ANC_TYPE> {
        private static final /* synthetic */ ANC_TYPE[] $VALUES = null;
        public static final ANC_TYPE AUTO = null;
        public static final ANC_TYPE BYTE = null;
        public static final ANC_TYPE NONE = null;
        public static final ANC_TYPE NSX = null;
        public static final ANC_TYPE RNN = null;

        static {
            ANC_TYPE r100 = new ANC_TYPE(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ANC_TYPE r101 = new ANC_TYPE("AUTO", 1);
            AUTO = r101;
            ANC_TYPE r102 = new ANC_TYPE("NSX", 2);
            NSX = r102;
            ANC_TYPE r103 = new ANC_TYPE("BYTE", 3);
            BYTE = r103;
            ANC_TYPE r104 = new ANC_TYPE("RNN", 4);
            RNN = r104;
            $VALUES = new ANC_TYPE[]{r100, r101, r102, r103, r104};
        }

        public static ANC_TYPE[] values() {
            return (ANC_TYPE[]) $VALUES.clone();
        }

        public static ANC_TYPE valueOf(String r100) {
            return (ANC_TYPE) a.a(ANC_TYPE.class, r100);
        }

        private ANC_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static int getFrameSize(int r100) {
        if (r100 != 8000) goto L5;
        return 640;
    L5:
        if (r100 != 16000) goto L7;
        return 1280;
    L7:
        if (r100 != 32000) goto L9;
        return TECameraUtils.CAPTURE_HQ_2X;
    L9:
        if (r100 != 44100) goto L11;
        return 3528;
    L11:
        if (r100 == 48000) goto L13;
        return 3840;
    L13:
        return 4096;
    }

    public static int getSFI(int r100) {
        if (r100 != 8000) goto L5;
        return 11;
    L5:
        if (r100 != 16000) goto L7;
        return 8;
    L7:
        if (r100 != 32000) goto L9;
        return 5;
    L9:
        if (r100 != 44100) goto L11;
        return 4;
    L11:
        if (r100 != 48000) goto L22;
        return 3;
    L22:
        return 4;
    }

    public boolean isAutoPublish() {
        if (this.mIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsAutoPublish == false) goto L7;
        return true;
    }

    public boolean isAutoSubscribe() {
        if (this.mIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsAutoSubscribe == false) goto L7;
        return true;
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public AudioProfile() {
        this.mAudioSource = 8;
        this.mAudioStreamType = 3;
        this.mCaptureSampleRate = 48000;
        this.mPlaybackSampleRate = 48000;
        this.mNumberOfChannels = 2;
        this.mBitwidth = 16;
        this.mBluetoothSCOEnabled = false;
        this.mAudioPtsOptimizeEnable = true;
        this.mIsHwNSEnabled = false;
        this.mIsHwAecEnabled = false;
        this.mCodecId = MediaSetting.ACODEC_ID.AAC;
        this.mAECType = AEC_TYPE.NONE;
        this.mANCType = ANC_TYPE.NONE;
        this.mAGCType = AGC_TYPE.NONE;
        this.mBitrateMode = MediaSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        this.mBitrate = 64;
        this.mMaxBitrate = 192;
        this.mIsAutoPublish = true;
        this.mIsAutoSubscribe = true;
        this.mIsEchoDetectionEnabled = false;
        this.mIsAudioPer10ms = false;
        this.mEnableAudioPause = true;
        this.mIsEnabled = true;
        this.mIsForceAudioManager = false;
        this.mIsEnabledAudioMix = false;
        this.mIsSeparateAudio = false;
    }

    public AudioProfile clone() {
        return (AudioProfile) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public AEC_TYPE getAECType() {
        return this.mAECType;
    }

    public AGC_TYPE getAGCType() {
        return this.mAGCType;
    }

    public ANC_TYPE getANCType() {
        return this.mANCType;
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getAudioStreamType() {
        return this.mAudioStreamType;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public MediaSetting.BITRATE_MODE getBitrateMode() {
        return this.mBitrateMode;
    }

    public int getBitwidth() {
        return this.mBitwidth;
    }

    public MediaSetting.ACODEC_ID getCodecId() {
        return this.mCodecId;
    }

    public int getMaxBitrate() {
        return this.mMaxBitrate;
    }

    public int getNumberOfChannels() {
        return this.mNumberOfChannels;
    }

    public int getPlaySampleRate() {
        return this.mPlaybackSampleRate;
    }

    public int getRecordSampleRate() {
        return this.mCaptureSampleRate;
    }

    public boolean isAudioPer10ms() {
        return this.mIsAudioPer10ms;
    }

    public boolean isAudioPtsOptimizeEnabled() {
        return this.mAudioPtsOptimizeEnable;
    }

    public boolean isBluetoothSCOEnabled() {
        return this.mBluetoothSCOEnabled;
    }

    public boolean isEchoDetectionEnabled() {
        return this.mIsEchoDetectionEnabled;
    }

    public boolean isEnableAudioPause() {
        return this.mEnableAudioPause;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isEnabledAudioMix() {
        return this.mIsEnabledAudioMix;
    }

    public boolean isHwAECEnabled() {
        return this.mIsHwAecEnabled;
    }

    public boolean isHwNSEnabled() {
        return this.mIsHwNSEnabled;
    }

    public boolean isSeparateAudio() {
        return this.mIsSeparateAudio;
    }

    public boolean mIsForceAudioManager() {
        return this.mIsForceAudioManager;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8142clone() throws CloneNotSupportedException {
        return clone();
    }

    public AudioProfile setAECType(AEC_TYPE r100) {
        this.mAECType = r100;
        return this;
    }

    public AudioProfile setAGCType(AGC_TYPE r100) {
        this.mAGCType = r100;
        return this;
    }

    public AudioProfile setANCType(ANC_TYPE r100) {
        this.mANCType = r100;
        return this;
    }

    public void setAudioEnablePause(boolean r100) {
        this.mEnableAudioPause = r100;
    }

    public void setAudioPer10ms(boolean r100) {
        this.mIsAudioPer10ms = r100;
    }

    public AudioProfile setAudioSource(int r100) {
        this.mAudioSource = r100;
        return this;
    }

    public AudioProfile setAudioStreamType(int r100) {
        this.mAudioStreamType = r100;
        return this;
    }

    public AudioProfile setBitrateMode(MediaSetting.BITRATE_MODE r100) {
        this.mBitrateMode = r100;
        return this;
    }

    public AudioProfile setBitwidth(int r100) {
        this.mBitwidth = r100;
        return this;
    }

    public AudioProfile setBluetoothSCOEnabled(boolean r100) {
        this.mBluetoothSCOEnabled = r100;
        return this;
    }

    public AudioProfile setCodecId(MediaSetting.ACODEC_ID r100) {
        this.mCodecId = r100;
        return this;
    }

    public void setEnableAudioMix(boolean r100) {
        this.mIsEnabledAudioMix = r100;
    }

    public AudioProfile setEnabled(boolean r100) {
        this.mIsEnabled = r100;
        if (r100 == true) goto L5;
        this.mIsAutoPublish = false;
        this.mIsAutoSubscribe = false;
    L5:
        return this;
    }

    public AudioProfile setForceAudioManager(boolean r100) {
        this.mIsForceAudioManager = r100;
        return this;
    }

    public boolean setHwAECEnabled(boolean r100) {
        if (AcousticEchoCanceler.isAvailable() == false) goto L6;
        this.mIsHwAecEnabled = r100;
        return true;
    L6:
        Logger.e("RTCAudioProfile", "failed to setAECEnabled, AcousticEchoCanceler not available !");
        return false;
    }

    public boolean setHwNSEnabled(boolean r100) {
        if (NoiseSuppressor.isAvailable() == false) goto L6;
        this.mIsHwNSEnabled = r100;
        return true;
    L6:
        Logger.e("RTCAudioProfile", "failed to setNSEnabled, NoiseSuppressor not available !");
        return false;
    }

    public AudioProfile setIsAutoPublish(boolean r100) {
        this.mIsAutoPublish = r100;
        return this;
    }

    public AudioProfile setIsAutoSubscribe(boolean r100) {
        this.mIsAutoSubscribe = r100;
        return this;
    }

    public AudioProfile setIsEchoDetectionEnabled(boolean r100) {
        this.mIsEchoDetectionEnabled = r100;
        return this;
    }

    public AudioProfile setNumberOfChannels(int r100) {
        this.mNumberOfChannels = r100;
        return this;
    }

    public AudioProfile setPtsOptimizeEnabled(boolean r100) {
        this.mAudioPtsOptimizeEnable = r100;
        return this;
    }

    public AudioProfile setSampleRate(int r100) {
        this.mCaptureSampleRate = r100;
        return this;
    }

    public void setSeparateAudio(boolean r100) {
        this.mIsSeparateAudio = r100;
    }

    public AudioProfile setBitrate(int r100, int r101) {
        this.mBitrate = r100;
        this.mMaxBitrate = r101;
        return this;
    }
}
