package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/e0;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "duration", "J", "b", "()J", "setDuration", "(J)V", "acuThreshold", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAcuThreshold", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("acu_threshold")
    private long acuThreshold;

    @SerializedName("duration")
    private long duration;

    @SerializedName("enable")
    private boolean enable;

    public e0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L12;
        e0 r101 = (e0) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.duration == r101.duration) goto L10;
        return false;
    L10:
        if (this.acuThreshold == r101.acuThreshold) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.duration;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.acuThreshold;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "PSNoMessageMonitorConfig(enable=" + this.enable + ", duration=" + this.duration + ", acuThreshold=" + this.acuThreshold + ")";
    }

    public final long a() {
        return this.acuThreshold;
    }

    public final long b() {
        return this.duration;
    }

    public final boolean c() {
        return this.enable;
    }

    public e0(int r100) {
        this.enable = true;
        this.duration = 40;
        this.acuThreshold = 10;
    }
}
