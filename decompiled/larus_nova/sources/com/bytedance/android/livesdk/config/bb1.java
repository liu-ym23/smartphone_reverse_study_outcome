package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/bb1;", "", "", "filter", "I", "getFilter", "()I", "", "enableLimit", "Z", "getEnableLimit", "()Z", "roomMaxTimes", "getRoomMaxTimes", "dayMaxTimes", "getDayMaxTimes", "overHandleTimes", "getOverHandleTimes", "", "overHandleMs", "J", "getOverHandleMs", "()J", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class bb1 {

    @SerializedName("day_max_times")
    private final int dayMaxTimes;

    @SerializedName("enable_limit")
    private final boolean enableLimit;

    @SerializedName("message_filter")
    private final int filter;

    @SerializedName("over_handle_day")
    private final long overHandleMs;

    @SerializedName("over_handle_times")
    private final int overHandleTimes;

    @SerializedName("room_max_times")
    private final int roomMaxTimes;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof bb1) == false) goto L18;
        bb1 r101 = (bb1) r100;
        if (this.filter == r101.filter) goto L8;
        return false;
    L8:
        if (this.enableLimit == r101.enableLimit) goto L10;
        return false;
    L10:
        if (this.roomMaxTimes == r101.roomMaxTimes) goto L12;
        return false;
    L12:
        if (this.dayMaxTimes == r101.dayMaxTimes) goto L14;
        return false;
    L14:
        if (this.overHandleTimes == r101.overHandleTimes) goto L16;
        return false;
    L16:
        if (this.overHandleMs == r101.overHandleMs) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = this.filter * 31;
        boolean r101 = this.enableLimit;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (((((((r100 + r102) * 31) + this.roomMaxTimes) * 31) + this.dayMaxTimes) * 31) + this.overHandleTimes) * 31;
        long r104 = this.overHandleMs;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "MessageGroupFilter(filter=" + this.filter + ", enableLimit=" + this.enableLimit + ", roomMaxTimes=" + this.roomMaxTimes + ", dayMaxTimes=" + this.dayMaxTimes + ", overHandleTimes=" + this.overHandleTimes + ", overHandleMs=" + this.overHandleMs + ')';
    }

    public bb1() {
        this.filter = 0;
        this.enableLimit = false;
        this.roomMaxTimes = 0;
        this.dayMaxTimes = 0;
        this.overHandleTimes = 0;
        this.overHandleMs = 0;
    }
}
