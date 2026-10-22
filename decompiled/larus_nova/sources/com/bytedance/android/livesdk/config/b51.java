package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/config/b51;", "", "", "voiceVolume", "I", RXScreenCaptureService.KEY_INDEX, "()I", "setVoiceVolume", "(I)V", "maxVoiceVolume", com.amap.api.col.s.ce.f26391f, "setMaxVoiceVolume", "", "defaultVoiceVolumeRatio", FaceService.girlLabel, "c", "()F", "setDefaultVoiceVolumeRatio", "(F)V", "musicVolume", "h", "setMusicVolume", "maxMusicVolume", "f", "setMaxMusicVolume", "defaultMusicVolumeRatio", "b", "setDefaultMusicVolumeRatio", "echoVolume", "d", "setEchoVolume", "maxEarVolume", "e", "setMaxEarVolume", "defaultEarVolumeRatio", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDefaultEarVolumeRatio", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b51 {

    @SerializedName("default_ear_volume_ratio")
    private float defaultEarVolumeRatio;

    @SerializedName("default_music_volume_ratio")
    private float defaultMusicVolumeRatio;

    @SerializedName("default_voice_volume_ratio")
    private float defaultVoiceVolumeRatio;

    @SerializedName("echo_volume")
    private int echoVolume;

    @SerializedName("max_ear_volume")
    private int maxEarVolume;

    @SerializedName("max_music_volume")
    private int maxMusicVolume;

    @SerializedName("max_voice_volume")
    private int maxVoiceVolume;

    @SerializedName("music_volume")
    private int musicVolume;

    @SerializedName("voice_volume")
    private int voiceVolume;

    public b51() {
        this.voiceVolume = 100;
        this.maxVoiceVolume = 200;
        this.defaultVoiceVolumeRatio = 0.5f;
        this.musicVolume = 50;
        this.maxMusicVolume = 100;
        this.defaultMusicVolumeRatio = 0.5f;
        this.echoVolume = 50;
        this.maxEarVolume = 100;
        this.defaultEarVolumeRatio = 0.5f;
    }

    public final float a() {
        return this.defaultEarVolumeRatio;
    }

    public final float b() {
        return this.defaultMusicVolumeRatio;
    }

    public final float c() {
        return this.defaultVoiceVolumeRatio;
    }

    public final int d() {
        return this.echoVolume;
    }

    public final int e() {
        return this.maxEarVolume;
    }

    public final int f() {
        return this.maxMusicVolume;
    }

    public final int g() {
        return this.maxVoiceVolume;
    }

    public final int h() {
        return this.musicVolume;
    }

    public final int i() {
        return this.voiceVolume;
    }
}
