package com.bytedance.android.livesdkapi.roomplayer;

import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 ¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfig;", "", "builder", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;", "(Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;)V", "abConfig", "", "getAbConfig", "()Ljava/lang/String;", "cachePath", "getCachePath", "callback", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectCallback;", "getCallback", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectCallback;", "deviceName", "getDeviceName", ICEffectKeys.KEY_IS_IC_EFFECT_LICENSE, "getLicense", "logKey", "getLogKey", "logLevel", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerEffectLogLevel;", "getLogLevel", "()Lcom/bytedance/android/livesdkapi/roomplayer/PlayerEffectLogLevel;", "messageListener", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectMessageListener;", "getMessageListener", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectMessageListener;", "needInitAfterFirstFrame", "", "getNeedInitAfterFirstFrame", "()Z", "setNeedInitAfterFirstFrame", "(Z)V", "platformConfig", "getPlatformConfig", "resourceFinder", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectResourceFinder;", "getResourceFinder", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectResourceFinder;", "useGL30", "getUseGL30", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoEffectInitConfig {
    private final String abConfig;
    private final String cachePath;
    private final VideoEffectCallback callback;
    private final String deviceName;
    private final String license;
    private final String logKey;
    private final PlayerEffectLogLevel logLevel;
    private final VideoEffectMessageListener messageListener;
    private boolean needInitAfterFirstFrame;
    private final String platformConfig;
    private final VideoEffectResourceFinder resourceFinder;
    private final boolean useGL30;

    public final String getAbConfig() {
        return this.abConfig;
    }

    public final String getCachePath() {
        return this.cachePath;
    }

    public final VideoEffectCallback getCallback() {
        return this.callback;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getLogKey() {
        return this.logKey;
    }

    public final PlayerEffectLogLevel getLogLevel() {
        return this.logLevel;
    }

    public final VideoEffectMessageListener getMessageListener() {
        return this.messageListener;
    }

    public final boolean getNeedInitAfterFirstFrame() {
        return this.needInitAfterFirstFrame;
    }

    public final String getPlatformConfig() {
        return this.platformConfig;
    }

    public final VideoEffectResourceFinder getResourceFinder() {
        return this.resourceFinder;
    }

    public final boolean getUseGL30() {
        return this.useGL30;
    }

    public VideoEffectInitConfig(VideoEffectInitConfigBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.platformConfig = r100.getPlatformConfig$live_player_api_saasRelease();
        this.cachePath = r100.getCachePath$live_player_api_saasRelease();
        this.abConfig = r100.getAbConfig$live_player_api_saasRelease();
        this.license = r100.getLicense$live_player_api_saasRelease();
        this.useGL30 = r100.getUseGL30$live_player_api_saasRelease();
        this.deviceName = r100.getDeviceName$live_player_api_saasRelease();
        this.logKey = r100.getLogKey$live_player_api_saasRelease();
        this.logLevel = r100.getLogLevel$live_player_api_saasRelease();
        this.messageListener = r100.getMessageListener$live_player_api_saasRelease();
        this.callback = r100.getCallback$live_player_api_saasRelease();
        this.resourceFinder = r100.getResourceFinder$live_player_api_saasRelease();
        this.needInitAfterFirstFrame = true;
    }

    public final void setNeedInitAfterFirstFrame(boolean r100) {
        this.needInitAfterFirstFrame = r100;
    }
}
