package com.bytedance.android.live.saas.middleware.monitor.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/config/OutApmConfig;", "", "blockDetect", "", "blockThresholdMs", "", "batteryDetect", "(ZJZ)V", "getBatteryDetect", "()Z", "setBatteryDetect", "(Z)V", "getBlockDetect", "setBlockDetect", "getBlockThresholdMs", "()J", "setBlockThresholdMs", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class OutApmConfig {
    private boolean batteryDetect;
    private boolean blockDetect;
    private long blockThresholdMs;

    public OutApmConfig() {
        this(false, 0, false, 7, null);
    }

    public static /* synthetic */ OutApmConfig copy$default(OutApmConfig r100, boolean r101, long r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.blockDetect;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.blockThresholdMs;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.batteryDetect;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.blockDetect;
    }

    public final long component2() {
        return this.blockThresholdMs;
    }

    public final boolean component3() {
        return this.batteryDetect;
    }

    public final OutApmConfig copy(boolean r100, long r101, boolean r102) {
        return new OutApmConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OutApmConfig) == false) goto L12;
        OutApmConfig r101 = (OutApmConfig) r100;
        if (this.blockDetect == r101.blockDetect) goto L8;
        return false;
    L8:
        if (this.blockThresholdMs == r101.blockThresholdMs) goto L10;
        return false;
    L10:
        if (this.batteryDetect == r101.batteryDetect) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.blockDetect;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.blockThresholdMs;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        boolean r105 = this.batteryDetect;
        if (r105 == true) goto L10;
        r101 = r105;
    L10:
        return r104 + r101;
    }

    public String toString() {
        return "OutApmConfig(blockDetect=" + this.blockDetect + ", blockThresholdMs=" + this.blockThresholdMs + ", batteryDetect=" + this.batteryDetect + ")";
    }

    public final boolean getBatteryDetect() {
        return this.batteryDetect;
    }

    public final boolean getBlockDetect() {
        return this.blockDetect;
    }

    public final long getBlockThresholdMs() {
        return this.blockThresholdMs;
    }

    public final void setBatteryDetect(boolean r100) {
        this.batteryDetect = r100;
    }

    public final void setBlockDetect(boolean r100) {
        this.blockDetect = r100;
    }

    public final void setBlockThresholdMs(long r100) {
        this.blockThresholdMs = r100;
    }

    public OutApmConfig(boolean r100, long r101, boolean r102) {
        this.blockDetect = r100;
        this.blockThresholdMs = r101;
        this.batteryDetect = r102;
    }

    public /* synthetic */ OutApmConfig(boolean r100, long r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 2500;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
