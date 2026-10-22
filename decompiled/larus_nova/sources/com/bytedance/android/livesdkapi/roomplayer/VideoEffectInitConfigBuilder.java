package com.bytedance.android.livesdkapi.roomplayer;

import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u000201J\u0010\u0010:\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010+R\u001a\u0010\u0005\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001a\u0010\u0016\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\nR\u001a\u0010\u0019\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;", "", "platformConfig", "", "cachePath", "abConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAbConfig$live_player_api_saasRelease", "()Ljava/lang/String;", "setAbConfig$live_player_api_saasRelease", "(Ljava/lang/String;)V", "getCachePath$live_player_api_saasRelease", "setCachePath$live_player_api_saasRelease", "callback", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectCallback;", "getCallback$live_player_api_saasRelease", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectCallback;", "setCallback$live_player_api_saasRelease", "(Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectCallback;)V", "deviceName", "getDeviceName$live_player_api_saasRelease", "setDeviceName$live_player_api_saasRelease", ICEffectKeys.KEY_IS_IC_EFFECT_LICENSE, "getLicense$live_player_api_saasRelease", "setLicense$live_player_api_saasRelease", "logKey", "getLogKey$live_player_api_saasRelease", "setLogKey$live_player_api_saasRelease", "logLevel", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerEffectLogLevel;", "getLogLevel$live_player_api_saasRelease", "()Lcom/bytedance/android/livesdkapi/roomplayer/PlayerEffectLogLevel;", "setLogLevel$live_player_api_saasRelease", "(Lcom/bytedance/android/livesdkapi/roomplayer/PlayerEffectLogLevel;)V", "messageListener", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectMessageListener;", "getMessageListener$live_player_api_saasRelease", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectMessageListener;", "setMessageListener$live_player_api_saasRelease", "(Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectMessageListener;)V", "getPlatformConfig$live_player_api_saasRelease", "setPlatformConfig$live_player_api_saasRelease", "resourceFinder", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectResourceFinder;", "getResourceFinder$live_player_api_saasRelease", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectResourceFinder;", "setResourceFinder$live_player_api_saasRelease", "(Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectResourceFinder;)V", "useGL30", "", "getUseGL30$live_player_api_saasRelease", "()Z", "setUseGL30$live_player_api_saasRelease", "(Z)V", "build", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfig;", "callBack", "level", "videoEffectResourceFinder", "finder", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoEffectInitConfigBuilder {
    private String abConfig;
    private String cachePath;
    private VideoEffectCallback callback;
    private String deviceName;
    private String license;
    private String logKey;
    private PlayerEffectLogLevel logLevel;
    private VideoEffectMessageListener messageListener;
    private String platformConfig;
    private VideoEffectResourceFinder resourceFinder;
    private boolean useGL30;

    public final VideoEffectInitConfig build() {
        return new VideoEffectInitConfig(this);
    }

    public final String getAbConfig$live_player_api_saasRelease() {
        return this.abConfig;
    }

    public final String getCachePath$live_player_api_saasRelease() {
        return this.cachePath;
    }

    public final VideoEffectCallback getCallback$live_player_api_saasRelease() {
        return this.callback;
    }

    public final String getDeviceName$live_player_api_saasRelease() {
        return this.deviceName;
    }

    public final String getLicense$live_player_api_saasRelease() {
        return this.license;
    }

    public final String getLogKey$live_player_api_saasRelease() {
        return this.logKey;
    }

    public final PlayerEffectLogLevel getLogLevel$live_player_api_saasRelease() {
        return this.logLevel;
    }

    public final VideoEffectMessageListener getMessageListener$live_player_api_saasRelease() {
        return this.messageListener;
    }

    public final String getPlatformConfig$live_player_api_saasRelease() {
        return this.platformConfig;
    }

    public final VideoEffectResourceFinder getResourceFinder$live_player_api_saasRelease() {
        return this.resourceFinder;
    }

    public final boolean getUseGL30$live_player_api_saasRelease() {
        return this.useGL30;
    }

    public final VideoEffectInitConfigBuilder callBack(VideoEffectCallback r100) {
        this.callback = r100;
        return this;
    }

    public final VideoEffectInitConfigBuilder deviceName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceName");
        this.deviceName = r100;
        return this;
    }

    public final VideoEffectInitConfigBuilder license(String r100) {
        Intrinsics.checkNotNullParameter(r100, ICEffectKeys.KEY_IS_IC_EFFECT_LICENSE);
        this.license = r100;
        return this;
    }

    public final VideoEffectInitConfigBuilder logKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logKey");
        this.logKey = r100;
        return this;
    }

    public final VideoEffectInitConfigBuilder logLevel(PlayerEffectLogLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "level");
        this.logLevel = r100;
        return this;
    }

    public final VideoEffectInitConfigBuilder messageListener(VideoEffectMessageListener r100) {
        this.messageListener = r100;
        return this;
    }

    public final void setAbConfig$live_player_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.abConfig = r100;
    }

    public final void setCachePath$live_player_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cachePath = r100;
    }

    public final void setCallback$live_player_api_saasRelease(VideoEffectCallback r100) {
        this.callback = r100;
    }

    public final void setDeviceName$live_player_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceName = r100;
    }

    public final void setLicense$live_player_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.license = r100;
    }

    public final void setLogKey$live_player_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logKey = r100;
    }

    public final void setLogLevel$live_player_api_saasRelease(PlayerEffectLogLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logLevel = r100;
    }

    public final void setMessageListener$live_player_api_saasRelease(VideoEffectMessageListener r100) {
        this.messageListener = r100;
    }

    public final void setPlatformConfig$live_player_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.platformConfig = r100;
    }

    public final void setResourceFinder$live_player_api_saasRelease(VideoEffectResourceFinder r100) {
        this.resourceFinder = r100;
    }

    public final void setUseGL30$live_player_api_saasRelease(boolean r100) {
        this.useGL30 = r100;
    }

    public final VideoEffectInitConfigBuilder useGL30(boolean r100) {
        this.useGL30 = r100;
        return this;
    }

    public final VideoEffectInitConfigBuilder videoEffectResourceFinder(VideoEffectResourceFinder r100) {
        this.resourceFinder = r100;
        return this;
    }

    public VideoEffectInitConfigBuilder(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "platformConfig");
        Intrinsics.checkNotNullParameter(r101, "cachePath");
        Intrinsics.checkNotNullParameter(r102, "abConfig");
        this.platformConfig = r100;
        this.cachePath = r101;
        this.abConfig = r102;
        this.license = "live";
        this.useGL30 = true;
        this.deviceName = "";
        this.logKey = "live_player_sdk";
        this.logLevel = PlayerEffectLogLevel.LevelDebug;
    }
}
