package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/i0;", "", "", "enableFluencyMonitor", "Z", "getEnableFluencyMonitor", "()Z", "enableMemoryDeltaMonitor", "getEnableMemoryDeltaMonitor", "enablePowerMonitor", "getEnablePowerMonitor", "", "memoryDeltaReportDelay", "J", "getMemoryDeltaReportDelay", "()J", "enableLiveMonitor", "getEnableLiveMonitor", "enableLiveDeltaMonitor", "getEnableLiveDeltaMonitor", "livePerformanceDeltaCollectInterval", "getLivePerformanceDeltaCollectInterval", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("enable_fluency_monitor")
    private final boolean enableFluencyMonitor;

    @SerializedName("enable_live_delta_monitor")
    private final boolean enableLiveDeltaMonitor;

    @SerializedName("enable_live_monitor")
    private final boolean enableLiveMonitor;

    @SerializedName("enable_memory_delta_monitor")
    private final boolean enableMemoryDeltaMonitor;

    @SerializedName("enable_power_monitor")
    private final boolean enablePowerMonitor;

    @SerializedName("live_performance_delta_collect_interval")
    private final long livePerformanceDeltaCollectInterval;

    @SerializedName("memory_delta_report_delay")
    private final long memoryDeltaReportDelay;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L20;
        i0 r101 = (i0) r100;
        if (this.enableFluencyMonitor == r101.enableFluencyMonitor) goto L8;
        return false;
    L8:
        if (this.enableMemoryDeltaMonitor == r101.enableMemoryDeltaMonitor) goto L10;
        return false;
    L10:
        if (this.enablePowerMonitor == r101.enablePowerMonitor) goto L12;
        return false;
    L12:
        if (this.memoryDeltaReportDelay == r101.memoryDeltaReportDelay) goto L14;
        return false;
    L14:
        if (this.enableLiveMonitor == r101.enableLiveMonitor) goto L16;
        return false;
    L16:
        if (this.enableLiveDeltaMonitor == r101.enableLiveDeltaMonitor) goto L18;
        return false;
    L18:
        if (this.livePerformanceDeltaCollectInterval == r101.livePerformanceDeltaCollectInterval) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        boolean r100 = this.enableFluencyMonitor;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enableMemoryDeltaMonitor;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.enablePowerMonitor;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        long r110 = this.memoryDeltaReportDelay;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        boolean r112 = this.enableLiveMonitor;
        ?? r113 = r112;
        if (r112 == false) goto L14;
        r113 = 1;
    L14:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.enableLiveDeltaMonitor;
        if (r115 == true) goto L18;
        r101 = r115;
    L18:
        int r116 = (r114 + r101) * 31;
        long r117 = this.livePerformanceDeltaCollectInterval;
        return r116 + ((int) (r117 ^ (r117 >>> 32)));
    }

    public final String toString() {
        return "CloudGamePerformanceMonitorConfig(enableFluencyMonitor=" + this.enableFluencyMonitor + ", enableMemoryDeltaMonitor=" + this.enableMemoryDeltaMonitor + ", enablePowerMonitor=" + this.enablePowerMonitor + ", memoryDeltaReportDelay=" + this.memoryDeltaReportDelay + ", enableLiveMonitor=" + this.enableLiveMonitor + ", enableLiveDeltaMonitor=" + this.enableLiveDeltaMonitor + ", livePerformanceDeltaCollectInterval=" + this.livePerformanceDeltaCollectInterval + ")";
    }

    public i0() {
        this.enableFluencyMonitor = false;
        this.enableMemoryDeltaMonitor = false;
        this.enablePowerMonitor = false;
        this.memoryDeltaReportDelay = 300;
        this.enableLiveMonitor = false;
        this.enableLiveDeltaMonitor = false;
        this.livePerformanceDeltaCollectInterval = 16000;
    }
}
