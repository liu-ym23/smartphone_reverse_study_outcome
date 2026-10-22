package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.download.api.constant.BaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/HamletLiveMediaMockConfig;", "", "()V", "defaultBitrate", "", "getDefaultBitrate", "()I", "setDefaultBitrate", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "fps", "getFps", "setFps", "maxBitrate", "getMaxBitrate", "setMaxBitrate", "minBitrate", "getMinBitrate", "setMinBitrate", "resolution", "getResolution", "setResolution", "resolution1080Config", "", "getResolution1080Config", "()Ljava/lang/String;", "setResolution1080Config", "(Ljava/lang/String;)V", "resolution720Config", "getResolution720Config", "setResolution720Config", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HamletLiveMediaMockConfig {

    @SerializedName("defaultBitrate")
    private int defaultBitrate;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fps")
    private int fps;

    @SerializedName("maxBitrate")
    private int maxBitrate;

    @SerializedName("minBitrate")
    private int minBitrate;

    @SerializedName("resolution")
    private int resolution;

    @SerializedName("resolution_1080_config")
    private String resolution1080Config;

    @SerializedName("resolution_720_config")
    private String resolution720Config;

    public HamletLiveMediaMockConfig() {
        this.resolution = 1080;
        this.maxBitrate = 5000000;
        this.minBitrate = 2500000;
        this.defaultBitrate = BaseConstants.Time.HOUR;
        this.fps = 30;
        this.resolution1080Config = "1920x1080";
        this.resolution720Config = "1080x720";
    }

    public final int getDefaultBitrate() {
        return this.defaultBitrate;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final int getMinBitrate() {
        return this.minBitrate;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final String getResolution1080Config() {
        return this.resolution1080Config;
    }

    public final String getResolution720Config() {
        return this.resolution720Config;
    }

    public final void setDefaultBitrate(int r100) {
        this.defaultBitrate = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setFps(int r100) {
        this.fps = r100;
    }

    public final void setMaxBitrate(int r100) {
        this.maxBitrate = r100;
    }

    public final void setMinBitrate(int r100) {
        this.minBitrate = r100;
    }

    public final void setResolution(int r100) {
        this.resolution = r100;
    }

    public final void setResolution1080Config(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolution1080Config = r100;
    }

    public final void setResolution720Config(String r100) {
        this.resolution720Config = r100;
    }
}
