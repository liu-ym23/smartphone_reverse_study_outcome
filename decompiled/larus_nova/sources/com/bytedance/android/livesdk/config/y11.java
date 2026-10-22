package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/y11;", "", "", "fetchStreamDataMaxDelayTime", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setFetchStreamDataMaxDelayTime", "(I)V", "preloadStreamDataModeOnCameraUpdated", "b", "setPreloadStreamDataModeOnCameraUpdated", "streamDataFetchMode", "c", "setStreamDataFetchMode", "streamDataFetchModeForXsg", "d", "setStreamDataFetchModeForXsg", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y11 {

    @SerializedName("fetch_stream_data_max_delay_time")
    private int fetchStreamDataMaxDelayTime;

    @SerializedName("preload_stream_data_mode_on_camera_updated")
    private int preloadStreamDataModeOnCameraUpdated;

    @SerializedName("stream_data_fetch_mode")
    private int streamDataFetchMode;

    @SerializedName("stream_data_fetch_mode_xsg")
    private int streamDataFetchModeForXsg;

    public y11() {
        this.fetchStreamDataMaxDelayTime = 600;
        this.preloadStreamDataModeOnCameraUpdated = 1;
        this.streamDataFetchMode = 3;
        this.streamDataFetchModeForXsg = 3;
    }

    public final int a() {
        return this.fetchStreamDataMaxDelayTime;
    }

    public final int b() {
        return this.preloadStreamDataModeOnCameraUpdated;
    }

    public final int c() {
        return this.streamDataFetchMode;
    }

    public final int d() {
        return this.streamDataFetchModeForXsg;
    }
}
