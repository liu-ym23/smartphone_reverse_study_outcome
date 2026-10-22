package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveRTChorusSpatialAudioConfig;", "", "()V", "chorusSpatialEnable", "", "getChorusSpatialEnable", "()I", "setChorusSpatialEnable", "(I)V", "distanceParams", "getDistanceParams", "setDistanceParams", "spatialLayout", "getSpatialLayout", "setSpatialLayout", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRTChorusSpatialAudioConfig {

    @SerializedName("spatial_audio_enable")
    private int chorusSpatialEnable;

    @SerializedName("distance_params")
    private int distanceParams;

    @SerializedName("spatial_layout")
    private int spatialLayout;

    public LiveRTChorusSpatialAudioConfig() {
        this.distanceParams = 15;
    }

    public final int getChorusSpatialEnable() {
        return this.chorusSpatialEnable;
    }

    public final int getDistanceParams() {
        return this.distanceParams;
    }

    public final int getSpatialLayout() {
        return this.spatialLayout;
    }

    public final void setChorusSpatialEnable(int r100) {
        this.chorusSpatialEnable = r100;
    }

    public final void setDistanceParams(int r100) {
        this.distanceParams = r100;
    }

    public final void setSpatialLayout(int r100) {
        this.spatialLayout = r100;
    }
}
