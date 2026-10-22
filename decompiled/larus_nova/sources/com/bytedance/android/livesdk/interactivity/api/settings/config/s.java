package com.bytedance.android.livesdk.interactivity.api.settings.config;

import androidx.camera.core.RetryPolicy;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/s;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "minDuration", "J", "d", "()J", "setMinDuration", "(J)V", "loopDuration", "c", "setLoopDuration", "enableAlarm", "b", "setEnableAlarm", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_alarm")
    private boolean enableAlarm;

    @SerializedName("loop_duration")
    private long loopDuration;

    @SerializedName("min_duration")
    private long minDuration;

    public s() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.minDuration == r101.minDuration) goto L10;
        return false;
    L10:
        if (this.loopDuration == r101.loopDuration) goto L12;
        return false;
    L12:
        if (this.enableAlarm == r101.enableAlarm) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.minDuration;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.loopDuration;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.enableAlarm;
        if (r107 == true) goto L10;
        r101 = r107;
    L10:
        return r106 + r101;
    }

    public final String toString() {
        return "LiveInteractivityMonitorConfig(enable=" + this.enable + ", minDuration=" + this.minDuration + ", loopDuration=" + this.loopDuration + ", enableAlarm=" + this.enableAlarm + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableAlarm;
    }

    public final long c() {
        return this.loopDuration;
    }

    public final long d() {
        return this.minDuration;
    }

    public s(int r100) {
        this.enable = false;
        this.minDuration = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.loopDuration = 60000;
        this.enableAlarm = true;
    }
}
