package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerInterceptReportConfig;", "", "()V", "audiometricEnable", "", "getAudiometricEnable", "()Z", "setAudiometricEnable", "(Z)V", "audiometricMinInterval", "", "getAudiometricMinInterval", "()J", "setAudiometricMinInterval", "(J)V", "vqMinInterval", "getVqMinInterval", "setVqMinInterval", "vqscoreEnable", "getVqscoreEnable", "setVqscoreEnable", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayerInterceptReportConfig {

    @SerializedName("audiometric_enable")
    private boolean audiometricEnable;

    @SerializedName("audiometric_min_interval")
    private long audiometricMinInterval;

    @SerializedName("vq_min_interval")
    private long vqMinInterval;

    @SerializedName("vqscore_enable")
    private boolean vqscoreEnable;

    public PlayerInterceptReportConfig() {
    }

    public final boolean getAudiometricEnable() {
        return this.audiometricEnable;
    }

    public final long getAudiometricMinInterval() {
        return this.audiometricMinInterval;
    }

    public final long getVqMinInterval() {
        return this.vqMinInterval;
    }

    public final boolean getVqscoreEnable() {
        return this.vqscoreEnable;
    }

    public final void setAudiometricEnable(boolean r100) {
        this.audiometricEnable = r100;
    }

    public final void setAudiometricMinInterval(long r100) {
        this.audiometricMinInterval = r100;
    }

    public final void setVqMinInterval(long r100) {
        this.vqMinInterval = r100;
    }

    public final void setVqscoreEnable(boolean r100) {
        this.vqscoreEnable = r100;
    }
}
