package com.obric.aiagent.performance;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ThresholdPssUploadFilesConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThresholdItemConfig {

    @SerializedName("enable_alog")
    private final boolean enableAlog;

    @SerializedName("enable_hprof")
    private final boolean enableHprof;

    @SerializedName("pss_limit")
    private final float pssLimit;

    @SerializedName("recent_alog_ms")
    private final long recentAlogMs;

    public ThresholdItemConfig() {
        this(false, false, 0.0f, 0, 15, null);
    }

    public static /* synthetic */ ThresholdItemConfig copy$default(ThresholdItemConfig r3, boolean r4, boolean r5, float r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableHprof;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enableAlog;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.pssLimit;
    L11:
        float r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.recentAlogMs;
    L14:
        boolean r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final boolean component1() {
        return this.enableHprof;
    }

    public final boolean component2() {
        return this.enableAlog;
    }

    public final float component3() {
        return this.pssLimit;
    }

    public final long component4() {
        return this.recentAlogMs;
    }

    public final ThresholdItemConfig copy(boolean r7, boolean r8, float r9, long r10) {
        return new ThresholdItemConfig(r7, r8, r9, r10);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ThresholdItemConfig.class) == true) goto L8;
        return false;
    L8:
        ThresholdItemConfig r8 = (ThresholdItemConfig) ZeusTransformUtils.preCheckCast(r7, ThresholdItemConfig.class, "com.obric.aiagent.plugin");
        if (this.enableHprof == r8.enableHprof) goto L12;
        return false;
    L12:
        if (this.enableAlog == r8.enableAlog) goto L15;
        return false;
    L15:
        if (Float.compare(this.pssLimit, r8.pssLimit) == 0) goto L18;
        return false;
    L18:
        if (this.recentAlogMs == r8.recentAlogMs) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enableHprof) * 31) + Boolean.hashCode(this.enableAlog)) * 31) + Float.hashCode(this.pssLimit)) * 31) + Long.hashCode(this.recentAlogMs);
    }

    public String toString() {
        return "ThresholdItemConfig(enableHprof=" + this.enableHprof + ", enableAlog=" + this.enableAlog + ", pssLimit=" + this.pssLimit + ", recentAlogMs=" + this.recentAlogMs + ')';
    }

    public ThresholdItemConfig(boolean r1, boolean r2, float r3, long r4) {
        this.enableHprof = r1;
        this.enableAlog = r2;
        this.pssLimit = r3;
        this.recentAlogMs = r4;
    }

    public /* synthetic */ ThresholdItemConfig(boolean r2, boolean r3, float r4, long r5, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = 614400.0f;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = 120000;
    L14:
        this(r2, r3, r4, r5);
    }

    public final boolean getEnableHprof() {
        return this.enableHprof;
    }

    public final boolean getEnableAlog() {
        return this.enableAlog;
    }

    public final float getPssLimit() {
        return this.pssLimit;
    }

    public final long getRecentAlogMs() {
        return this.recentAlogMs;
    }
}
