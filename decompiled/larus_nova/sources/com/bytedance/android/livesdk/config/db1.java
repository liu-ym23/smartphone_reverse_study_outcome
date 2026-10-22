package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/db1;", "", "", "enable", "Z", "b", "()Z", "", "delayHideDuration", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "hideTimes", "getHideTimes", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class db1 {

    @SerializedName("sei_msg_delay_hide_duration")
    private final int delayHideDuration;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("sei_msg_hide_times")
    private final int hideTimes;

    public db1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof db1) == false) goto L12;
        db1 r101 = (db1) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.delayHideDuration == r101.delayHideDuration) goto L10;
        return false;
    L10:
        if (this.hideTimes == r101.hideTimes) goto L19;
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
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((r101 * 31) + this.delayHideDuration) * 31) + this.hideTimes;
    }

    public final String toString() {
        return "MiniGameSEIConfig(enable=" + this.enable + ", delayHideDuration=" + this.delayHideDuration + ", hideTimes=" + this.hideTimes + ")";
    }

    public final int a() {
        return this.delayHideDuration;
    }

    public final boolean b() {
        return this.enable;
    }

    public db1(int r100) {
        this.enable = true;
        this.delayHideDuration = 60;
        this.hideTimes = 10;
    }
}
