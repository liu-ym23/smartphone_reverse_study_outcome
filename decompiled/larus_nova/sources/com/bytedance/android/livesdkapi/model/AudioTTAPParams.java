package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AudioTTAPParams;", "", "()V", "effectType", "", "getEffectType", "()I", "setEffectType", "(I)V", "enableTTAP", "", "getEnableTTAP", "()Z", "setEnableTTAP", "(Z)V", "enableVolumeGain", "getEnableVolumeGain", "setEnableVolumeGain", "volumeLGain", "", "getVolumeLGain", "()F", "setVolumeLGain", "(F)V", "volumeRGain", "getVolumeRGain", "setVolumeRGain", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioTTAPParams {
    private int effectType;
    private boolean enableTTAP;
    private boolean enableVolumeGain;
    private float volumeLGain;
    private float volumeRGain;

    public String toString() {
        return "AudioTTAPParams(enableTTAP=" + this.enableTTAP + ", enableVolumeGain=" + this.enableVolumeGain + ",  effectType=" + this.effectType + ", volumeLGain=" + this.volumeLGain + ",volumeRGain=" + this.volumeRGain + ')';
    }

    public AudioTTAPParams() {
        this.volumeLGain = 1.0f;
        this.volumeRGain = 1.0f;
    }

    public final int getEffectType() {
        return this.effectType;
    }

    public final boolean getEnableTTAP() {
        return this.enableTTAP;
    }

    public final boolean getEnableVolumeGain() {
        return this.enableVolumeGain;
    }

    public final float getVolumeLGain() {
        return this.volumeLGain;
    }

    public final float getVolumeRGain() {
        return this.volumeRGain;
    }

    public final void setEffectType(int r100) {
        this.effectType = r100;
    }

    public final void setEnableTTAP(boolean r100) {
        this.enableTTAP = r100;
    }

    public final void setEnableVolumeGain(boolean r100) {
        this.enableVolumeGain = r100;
    }

    public final void setVolumeLGain(float r100) {
        this.volumeLGain = r100;
    }

    public final void setVolumeRGain(float r100) {
        this.volumeRGain = r100;
    }
}
