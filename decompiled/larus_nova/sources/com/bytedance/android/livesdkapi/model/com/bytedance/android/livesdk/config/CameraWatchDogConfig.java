package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/CameraWatchDogConfig;", "", "()V", "delaySeconds", "", "getDelaySeconds", "()I", "setDelaySeconds", "(I)V", "enable", "", "getEnable", "()Z", "enableDumpStacktrace", "getEnableDumpStacktrace", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CameraWatchDogConfig {

    @SerializedName("delay_seconds")
    private int delaySeconds;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_dump_stacktrace")
    private final boolean enableDumpStacktrace;

    public CameraWatchDogConfig() {
        this.delaySeconds = 8;
    }

    public final int getDelaySeconds() {
        return this.delaySeconds;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableDumpStacktrace() {
        return this.enableDumpStacktrace;
    }

    public final void setDelaySeconds(int r100) {
        this.delaySeconds = r100;
    }
}
