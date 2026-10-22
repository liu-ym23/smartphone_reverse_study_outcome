package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/k21;", "", "", "enabled", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnabled", "(Z)V", "", "volumeSampleInterval", "I", "e", "()I", "setVolumeSampleInterval", "(I)V", "screenClickSampleInterval", "d", "setScreenClickSampleInterval", "screenClickSampleDuration", "c", "setScreenClickSampleDuration", "flushInterval", "b", "setFlushInterval", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k21 {

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("flush_interval_seconds")
    private int flushInterval;

    @SerializedName("screen_click_sample_duration_seconds")
    private int screenClickSampleDuration;

    @SerializedName("screen_click_sample_interval_seconds")
    private int screenClickSampleInterval;

    @SerializedName("volume_sample_interval_seconds")
    private int volumeSampleInterval;

    public k21() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k21) == false) goto L16;
        k21 r101 = (k21) r100;
        if (this.enabled == r101.enabled) goto L8;
        return false;
    L8:
        if (this.volumeSampleInterval == r101.volumeSampleInterval) goto L10;
        return false;
    L10:
        if (this.screenClickSampleInterval == r101.screenClickSampleInterval) goto L12;
        return false;
    L12:
        if (this.screenClickSampleDuration == r101.screenClickSampleDuration) goto L14;
        return false;
    L14:
        if (this.flushInterval == r101.flushInterval) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.enabled;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((((((r101 * 31) + this.volumeSampleInterval) * 31) + this.screenClickSampleInterval) * 31) + this.screenClickSampleDuration) * 31) + this.flushInterval;
    }

    public final String toString() {
        return "LiveDataCollectConfig(enabled=" + this.enabled + ", volumeSampleInterval=" + this.volumeSampleInterval + ", screenClickSampleInterval=" + this.screenClickSampleInterval + ", screenClickSampleDuration=" + this.screenClickSampleDuration + ", flushInterval=" + this.flushInterval + ")";
    }

    public final boolean a() {
        return this.enabled;
    }

    public final int b() {
        return this.flushInterval;
    }

    public final int c() {
        return this.screenClickSampleDuration;
    }

    public final int d() {
        return this.screenClickSampleInterval;
    }

    public final int e() {
        return this.volumeSampleInterval;
    }

    public k21(int r100) {
        this.enabled = false;
        this.volumeSampleInterval = 30;
        this.screenClickSampleInterval = 10;
        this.screenClickSampleDuration = 5;
        this.flushInterval = 600;
    }
}
