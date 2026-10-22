package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/se1;", "", "", "enable", "Z", "b", "()Z", "", "delayTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class se1 {

    @SerializedName("delay_time")
    private final long delayTime;

    @SerializedName("enable")
    private final boolean enable;

    public se1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof se1) == false) goto L10;
        se1 r101 = (se1) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.delayTime == r101.delayTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.delayTime;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "PullStreamChangeConfig(enable=" + this.enable + ", delayTime=" + this.delayTime + ")";
    }

    public final long a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enable;
    }

    public se1(int r100) {
        this.enable = true;
        this.delayTime = 0;
    }
}
