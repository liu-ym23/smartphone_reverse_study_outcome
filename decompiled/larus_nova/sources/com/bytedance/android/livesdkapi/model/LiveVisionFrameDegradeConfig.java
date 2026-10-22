package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveVisionFrameDegradeConfig;", "", "()V", "firstLineStyle", "", "getFirstLineStyle", "()I", "secondLineStyle", "getSecondLineStyle", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVisionFrameDegradeConfig {

    @SerializedName("profile")
    private final int firstLineStyle;

    @SerializedName("discovery")
    private final int secondLineStyle;

    public LiveVisionFrameDegradeConfig() {
    }

    public final int getFirstLineStyle() {
        return this.firstLineStyle;
    }

    public final int getSecondLineStyle() {
        return this.secondLineStyle;
    }
}
