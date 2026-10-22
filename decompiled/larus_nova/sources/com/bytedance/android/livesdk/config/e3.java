package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/e3;", "", "", "enable", "Z", "getEnable", "()Z", "", "count", "J", "getCount", "()J", "time_diff", "getTime_diff", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e3 {

    @SerializedName("count")
    private final long count;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("time_diff")
    private final long time_diff;

    public e3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e3) == false) goto L12;
        e3 r101 = (e3) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.count == r101.count) goto L10;
        return false;
    L10:
        if (this.time_diff == r101.time_diff) goto L19;
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
        long r102 = this.count;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.time_diff;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "DynamicAggregateALogConfig(enable=" + this.enable + ", count=" + this.count + ", time_diff=" + this.time_diff + ")";
    }

    public e3(int r100) {
        this.enable = true;
        this.count = 30;
        this.time_diff = 5000;
    }
}
