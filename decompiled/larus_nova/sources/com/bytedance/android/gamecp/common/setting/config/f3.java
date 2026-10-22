package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/f3;", "", "", "tipsCountEveryTimeLimit", "I", "getTipsCountEveryTimeLimit", "()I", "tipsCountAllAppTimeLimit", "getTipsCountAllAppTimeLimit", "", "enableAutoResolution", "Z", "getEnableAutoResolution", "()Z", "performanceEventTimeTrigger", "getPerformanceEventTimeTrigger", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f3 {

    @SerializedName("enable_auto_resolution")
    private final boolean enableAutoResolution;

    @SerializedName("performance_event_time_trigger")
    private final int performanceEventTimeTrigger;

    @SerializedName("resolution_tips_all_app_time_limit_count")
    private final int tipsCountAllAppTimeLimit;

    @SerializedName("resolution_tips_every_time_limit_count")
    private final int tipsCountEveryTimeLimit;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f3) == false) goto L14;
        f3 r101 = (f3) r100;
        if (this.tipsCountEveryTimeLimit == r101.tipsCountEveryTimeLimit) goto L8;
        return false;
    L8:
        if (this.tipsCountAllAppTimeLimit == r101.tipsCountAllAppTimeLimit) goto L10;
        return false;
    L10:
        if (this.enableAutoResolution == r101.enableAutoResolution) goto L12;
        return false;
    L12:
        if (this.performanceEventTimeTrigger == r101.performanceEventTimeTrigger) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        int r100 = ((this.tipsCountEveryTimeLimit * 31) + this.tipsCountAllAppTimeLimit) * 31;
        boolean r101 = this.enableAutoResolution;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((r100 + r102) * 31) + this.performanceEventTimeTrigger;
    }

    public final String toString() {
        return "ResolutionSwitchConfig(tipsCountEveryTimeLimit=" + this.tipsCountEveryTimeLimit + ", tipsCountAllAppTimeLimit=" + this.tipsCountAllAppTimeLimit + ", enableAutoResolution=" + this.enableAutoResolution + ", performanceEventTimeTrigger=" + this.performanceEventTimeTrigger + ")";
    }

    public f3() {
        this.tipsCountEveryTimeLimit = 1;
        this.tipsCountAllAppTimeLimit = 3;
        this.enableAutoResolution = true;
        this.performanceEventTimeTrigger = 15;
    }
}
