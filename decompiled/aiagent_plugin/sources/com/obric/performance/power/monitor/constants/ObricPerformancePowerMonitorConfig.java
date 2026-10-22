package com.obric.performance.power.monitor.constants;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: PowerMonitorConstants.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ObricPerformancePowerMonitorConfig {

    @SerializedName("aiagent_enable")
    private final boolean aiagentEnabled;

    @SerializedName("background_sampled_rate")
    private final float backgroundSampledRate;

    @SerializedName("collect_current_interval_millis")
    private final long collectCurrentIntervalMillis;

    @SerializedName("enable")
    private final boolean enabled;

    @SerializedName("front_sampled_rate")
    private final float frontSampledRate;

    @SerializedName("report_interval_millis")
    private final long reportIntervalMillis;

    public ObricPerformancePowerMonitorConfig() {
        this(false, false, 0, 0, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ ObricPerformancePowerMonitorConfig copy$default(ObricPerformancePowerMonitorConfig r9, boolean r10, boolean r11, long r12, long r14, float r16, float r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = r9.enabled;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r2 = r9.aiagentEnabled;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r3 = r9.reportIntervalMillis;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r5 = r9.collectCurrentIntervalMillis;
    L19:
        if ((r18 & 16) == 0) goto L21;
        float r7 = r9.frontSampledRate;
    L23:
        if ((r18 & 32) == 0) goto L25;
        float r8 = r9.backgroundSampledRate;
    L27:
        return r9.copy(r1, r2, r3, r5, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final boolean component2() {
        return this.aiagentEnabled;
    }

    public final long component3() {
        return this.reportIntervalMillis;
    }

    public final long component4() {
        return this.collectCurrentIntervalMillis;
    }

    public final float component5() {
        return this.frontSampledRate;
    }

    public final float component6() {
        return this.backgroundSampledRate;
    }

    public final ObricPerformancePowerMonitorConfig copy(boolean r11, boolean r12, long r13, long r15, float r17, float r18) {
        return new ObricPerformancePowerMonitorConfig(r11, r12, r13, r15, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ObricPerformancePowerMonitorConfig.class) == true) goto L8;
        return false;
    L8:
        ObricPerformancePowerMonitorConfig r10 = (ObricPerformancePowerMonitorConfig) ZeusTransformUtils.preCheckCast(r9, ObricPerformancePowerMonitorConfig.class, "com.obric.aiagent.plugin");
        if (this.enabled == r10.enabled) goto L12;
        return false;
    L12:
        if (this.aiagentEnabled == r10.aiagentEnabled) goto L15;
        return false;
    L15:
        if (this.reportIntervalMillis == r10.reportIntervalMillis) goto L18;
        return false;
    L18:
        if (this.collectCurrentIntervalMillis == r10.collectCurrentIntervalMillis) goto L21;
        return false;
    L21:
        if (Float.compare(this.frontSampledRate, r10.frontSampledRate) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.backgroundSampledRate, r10.backgroundSampledRate) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.enabled) * 31) + Boolean.hashCode(this.aiagentEnabled)) * 31) + Long.hashCode(this.reportIntervalMillis)) * 31) + Long.hashCode(this.collectCurrentIntervalMillis)) * 31) + Float.hashCode(this.frontSampledRate)) * 31) + Float.hashCode(this.backgroundSampledRate);
    }

    public String toString() {
        return "ObricPerformancePowerMonitorConfig(enabled=" + this.enabled + ", aiagentEnabled=" + this.aiagentEnabled + ", reportIntervalMillis=" + this.reportIntervalMillis + ", collectCurrentIntervalMillis=" + this.collectCurrentIntervalMillis + ", frontSampledRate=" + this.frontSampledRate + ", backgroundSampledRate=" + this.backgroundSampledRate + ')';
    }

    public ObricPerformancePowerMonitorConfig(boolean r1, boolean r2, long r3, long r5, float r7, float r8) {
        this.enabled = r1;
        this.aiagentEnabled = r2;
        this.reportIntervalMillis = r3;
        this.collectCurrentIntervalMillis = r5;
        this.frontSampledRate = r7;
        this.backgroundSampledRate = r8;
    }

    public /* synthetic */ ObricPerformancePowerMonitorConfig(boolean r2, boolean r3, long r4, long r6, float r8, float r9, int r10, h r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r6 = WsConstants.EXIT_DELAY_TIME;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r8 = 0.0f;
    L18:
        if ((r10 & 32) == 0) goto L20;
        r9 = 0.0f;
    L20:
        this(r2, r3, r4, r6, r8, r9);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getAiagentEnabled() {
        return this.aiagentEnabled;
    }

    public final long getReportIntervalMillis() {
        return this.reportIntervalMillis;
    }

    public final long getCollectCurrentIntervalMillis() {
        return this.collectCurrentIntervalMillis;
    }

    public final float getFrontSampledRate() {
        return this.frontSampledRate;
    }

    public final float getBackgroundSampledRate() {
        return this.backgroundSampledRate;
    }
}
