package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/CloudGroupLiveDeviceScoreConfig;", "", "()V", "deviceScoreThreshold", "", "getDeviceScoreThreshold", "()F", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CloudGroupLiveDeviceScoreConfig {

    @SerializedName("collaborate_permission_device_score")
    private final float deviceScoreThreshold;

    public CloudGroupLiveDeviceScoreConfig() {
    }

    public final float getDeviceScoreThreshold() {
        return this.deviceScoreThreshold;
    }
}
