package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001e\u00103\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000e¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/HamletBusinessConfig;", "", "()V", "aedEnable", "", "getAedEnable", "()Z", "setAedEnable", "(Z)V", "aedInterval", "", "getAedInterval", "()I", "setAedInterval", "(I)V", "audienceSeiSendInterval", "", "getAudienceSeiSendInterval", "()J", "setAudienceSeiSendInterval", "(J)V", "audioCheckDelayEnable", "getAudioCheckDelayEnable", "setAudioCheckDelayEnable", "audioDelayCheckInterval", "getAudioDelayCheckInterval", "setAudioDelayCheckInterval", "audioStreamInfoSendInterval", "getAudioStreamInfoSendInterval", "setAudioStreamInfoSendInterval", "avatarLoadRetryCount", "getAvatarLoadRetryCount", "setAvatarLoadRetryCount", "hamletAppLogEnable", "getHamletAppLogEnable", "setHamletAppLogEnable", "mouthEnable", "getMouthEnable", "setMouthEnable", "setLiveCoreSurfaceViewNull", "getSetLiveCoreSurfaceViewNull", "setSetLiveCoreSurfaceViewNull", "useSurfaceView", "getUseSurfaceView", "setUseSurfaceView", "vadEnable", "getVadEnable", "setVadEnable", "vadInterval", "getVadInterval", "setVadInterval", "xplayMaxRetryCount", "getXplayMaxRetryCount", "setXplayMaxRetryCount", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HamletBusinessConfig {

    @SerializedName("aed_enable")
    private boolean aedEnable;

    @SerializedName("aed_interval")
    private int aedInterval;

    @SerializedName("audience_sei_send_interval")
    private long audienceSeiSendInterval;

    @SerializedName("audio_delay_enable")
    private boolean audioCheckDelayEnable;

    @SerializedName("audio_delay_check_interval")
    private long audioDelayCheckInterval;

    @SerializedName("audio_stream_info_send_interaval")
    private long audioStreamInfoSendInterval;

    @SerializedName("avatar_load_retry_count")
    private int avatarLoadRetryCount;

    @SerializedName("hamlet_app_log_enable")
    private boolean hamletAppLogEnable;

    @SerializedName("mouth_enable")
    private boolean mouthEnable;

    @SerializedName("set_live_core_surface_view_null")
    private boolean setLiveCoreSurfaceViewNull;

    @SerializedName("xplay_use_surface_view")
    private boolean useSurfaceView;

    @SerializedName("vad_enable")
    private boolean vadEnable;

    @SerializedName("vad_interval")
    private int vadInterval;

    @SerializedName("xplay_max_retry_count")
    private int xplayMaxRetryCount;

    public HamletBusinessConfig() {
        this.mouthEnable = true;
        this.vadEnable = true;
        this.vadInterval = 200;
        this.aedInterval = 2000;
        this.audioCheckDelayEnable = true;
        this.audioDelayCheckInterval = 180000;
        this.xplayMaxRetryCount = 2;
        this.useSurfaceView = true;
        this.avatarLoadRetryCount = 2;
        this.setLiveCoreSurfaceViewNull = true;
        this.hamletAppLogEnable = true;
        this.aedEnable = true;
        this.audioStreamInfoSendInterval = 200;
        this.audienceSeiSendInterval = 1000;
    }

    public final boolean getAedEnable() {
        return this.aedEnable;
    }

    public final int getAedInterval() {
        return this.aedInterval;
    }

    public final long getAudienceSeiSendInterval() {
        return this.audienceSeiSendInterval;
    }

    public final boolean getAudioCheckDelayEnable() {
        return this.audioCheckDelayEnable;
    }

    public final long getAudioDelayCheckInterval() {
        return this.audioDelayCheckInterval;
    }

    public final long getAudioStreamInfoSendInterval() {
        return this.audioStreamInfoSendInterval;
    }

    public final int getAvatarLoadRetryCount() {
        return this.avatarLoadRetryCount;
    }

    public final boolean getHamletAppLogEnable() {
        return this.hamletAppLogEnable;
    }

    public final boolean getMouthEnable() {
        return this.mouthEnable;
    }

    public final boolean getSetLiveCoreSurfaceViewNull() {
        return this.setLiveCoreSurfaceViewNull;
    }

    public final boolean getUseSurfaceView() {
        return this.useSurfaceView;
    }

    public final boolean getVadEnable() {
        return this.vadEnable;
    }

    public final int getVadInterval() {
        return this.vadInterval;
    }

    public final int getXplayMaxRetryCount() {
        return this.xplayMaxRetryCount;
    }

    public final void setAedEnable(boolean r100) {
        this.aedEnable = r100;
    }

    public final void setAedInterval(int r100) {
        this.aedInterval = r100;
    }

    public final void setAudienceSeiSendInterval(long r100) {
        this.audienceSeiSendInterval = r100;
    }

    public final void setAudioCheckDelayEnable(boolean r100) {
        this.audioCheckDelayEnable = r100;
    }

    public final void setAudioDelayCheckInterval(long r100) {
        this.audioDelayCheckInterval = r100;
    }

    public final void setAudioStreamInfoSendInterval(long r100) {
        this.audioStreamInfoSendInterval = r100;
    }

    public final void setAvatarLoadRetryCount(int r100) {
        this.avatarLoadRetryCount = r100;
    }

    public final void setHamletAppLogEnable(boolean r100) {
        this.hamletAppLogEnable = r100;
    }

    public final void setMouthEnable(boolean r100) {
        this.mouthEnable = r100;
    }

    public final void setSetLiveCoreSurfaceViewNull(boolean r100) {
        this.setLiveCoreSurfaceViewNull = r100;
    }

    public final void setUseSurfaceView(boolean r100) {
        this.useSurfaceView = r100;
    }

    public final void setVadEnable(boolean r100) {
        this.vadEnable = r100;
    }

    public final void setVadInterval(int r100) {
        this.vadInterval = r100;
    }

    public final void setXplayMaxRetryCount(int r100) {
        this.xplayMaxRetryCount = r100;
    }
}
