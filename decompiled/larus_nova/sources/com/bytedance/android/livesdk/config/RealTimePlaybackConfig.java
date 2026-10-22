package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/RealTimePlaybackConfig;", "", "()V", "enableForceSeekResolution", "", "getEnableForceSeekResolution", "()Z", "seekForceResolution", "", "getSeekForceResolution", "()Ljava/lang/String;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RealTimePlaybackConfig {

    @SerializedName("enable_force_seek_resolution")
    private final boolean enableForceSeekResolution;

    @SerializedName("seek_force_resolution")
    private final String seekForceResolution;

    public RealTimePlaybackConfig() {
        this.enableForceSeekResolution = true;
        this.seekForceResolution = PlayerResolution.SDKKEY.ORIGIN;
    }

    public final boolean getEnableForceSeekResolution() {
        return this.enableForceSeekResolution;
    }

    public final String getSeekForceResolution() {
        return this.seekForceResolution;
    }
}
