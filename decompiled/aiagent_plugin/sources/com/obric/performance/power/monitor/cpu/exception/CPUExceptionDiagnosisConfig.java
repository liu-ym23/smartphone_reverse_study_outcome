package com.obric.performance.power.monitor.cpu.exception;

import com.google.gson.annotations.SerializedName;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.List;

/* JADX INFO: compiled from: CPUExceptionDiagnosisConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CPUExceptionDiagnosisConfig {

    @SerializedName("aiagent_enable")
    private final boolean aiagentEnable;

    @SerializedName("background_exception_ratio")
    private final float backgroundExceptionRatio;

    @SerializedName("background_sampled_rate")
    private final float backgroundSampledRate;

    @SerializedName("dump_interval_millis")
    private final long dumpIntervalMillis;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("front_exception_ratio")
    private final float frontExceptionRatio;

    @SerializedName("front_sampled_rate")
    private final float frontSampledRate;

    @SerializedName("measure_cpu_time_millis")
    private final long measureCpuTime;

    @SerializedName("period_interval_millis")
    private final long periodInterval;

    @SerializedName("stack_frame_promotion_enabled")
    private final boolean stackFramePromotionEnabled;

    @SerializedName("stack_frame_skip_class_prefixes")
    private final List<String> stackFrameSkipClassPrefixes;

    @SerializedName("thread_filter_exact_names")
    private final List<String> threadFilterExactNames;

    @SerializedName("thread_filter_name_prefixes")
    private final List<String> threadFilterNamePrefixes;

    @SerializedName("thread_stack_sleep_max_retry")
    private final int threadStackSleepMaxRetry;

    @SerializedName("top_dump_count")
    private final int topDumpCount;

    public CPUExceptionDiagnosisConfig() {
        this(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
    }

    public static /* synthetic */ CPUExceptionDiagnosisConfig copy$default(CPUExceptionDiagnosisConfig r16, boolean r17, boolean r18, float r19, float r20, long r21, long r23, float r25, float r26, int r27, int r28, long r29, boolean r31, List r32, List r33, List r34, int r35, Object r36) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.aiagent.plugin");
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.aiagent.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        if ((r35 & 1) == 0) goto L5;
        boolean r5 = r16.enable;
    L7:
        if ((r35 & 2) == 0) goto L9;
        boolean r6 = r16.aiagentEnable;
    L11:
        if ((r35 & 4) == 0) goto L13;
        float r7 = r16.frontSampledRate;
    L15:
        if ((r35 & 8) == 0) goto L17;
        float r8 = r16.backgroundSampledRate;
    L19:
        if ((r35 & 16) == 0) goto L21;
        long r9 = r16.periodInterval;
    L23:
        if ((r35 & 32) == 0) goto L25;
        long r11 = r16.measureCpuTime;
    L27:
        if ((r35 & 64) == 0) goto L29;
        float r13 = r16.frontExceptionRatio;
    L31:
        if ((r35 & 128) == 0) goto L33;
        float r14 = r16.backgroundExceptionRatio;
    L35:
        if ((r35 & 256) == 0) goto L37;
        int r15 = r16.topDumpCount;
    L39:
        if ((r35 & 512) == 0) goto L41;
        int r10 = r16.threadStackSleepMaxRetry;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        long r12 = r16.dumpIntervalMillis;
    L46:
        long r210 = r12;
        if ((r35 & 2048) == 0) goto L49;
        boolean r22 = r16.stackFramePromotionEnabled;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        List<String> r24 = r16.stackFrameSkipClassPrefixes;
    L54:
        List<String> r37 = r24;
        if ((r35 & 8192) == 0) goto L57;
        List<String> r30 = r16.threadFilterExactNames;
    L59:
        if ((r35 & 16384) == 0) goto L61;
        List<String> r1 = r16.threadFilterNamePrefixes;
    L63:
        return r16.copy(r5, r6, r7, r8, r9, r11, r13, r14, r15, r10, r210, r22, r37, r30, r1);
    L61:
        r1 = r3;
        goto L63
    L57:
        r30 = r4;
        goto L59
    L53:
        r24 = r2;
        goto L54
    L49:
        r22 = r31;
        goto L51
    L45:
        r12 = r29;
        goto L46
    L41:
        r10 = r28;
        goto L43
    L37:
        r15 = r27;
        goto L39
    L33:
        r14 = r26;
        goto L35
    L29:
        r13 = r25;
        goto L31
    L25:
        r11 = r23;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component10() {
        return this.threadStackSleepMaxRetry;
    }

    public final long component11() {
        return this.dumpIntervalMillis;
    }

    public final boolean component12() {
        return this.stackFramePromotionEnabled;
    }

    public final List<String> component13() {
        return this.stackFrameSkipClassPrefixes;
    }

    public final List<String> component14() {
        return this.threadFilterExactNames;
    }

    public final List<String> component15() {
        return this.threadFilterNamePrefixes;
    }

    public final boolean component2() {
        return this.aiagentEnable;
    }

    public final float component3() {
        return this.frontSampledRate;
    }

    public final float component4() {
        return this.backgroundSampledRate;
    }

    public final long component5() {
        return this.periodInterval;
    }

    public final long component6() {
        return this.measureCpuTime;
    }

    public final float component7() {
        return this.frontExceptionRatio;
    }

    public final float component8() {
        return this.backgroundExceptionRatio;
    }

    public final int component9() {
        return this.topDumpCount;
    }

    public final CPUExceptionDiagnosisConfig copy(boolean r21, boolean r22, float r23, float r24, long r25, long r27, float r29, float r30, int r31, int r32, long r33, boolean r35, List<String> r36, List<String> r37, List<String> r38) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r37, List.class, "com.obric.aiagent.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.aiagent.plugin");
        o.e(r0, "stackFrameSkipClassPrefixes");
        o.e(r2, "threadFilterExactNames");
        o.e(r1, "threadFilterNamePrefixes");
        return new CPUExceptionDiagnosisConfig(r21, r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r35, r0, r2, r1);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, CPUExceptionDiagnosisConfig.class) == true) goto L8;
        return false;
    L8:
        CPUExceptionDiagnosisConfig r10 = (CPUExceptionDiagnosisConfig) ZeusTransformUtils.preCheckCast(r9, CPUExceptionDiagnosisConfig.class, "com.obric.aiagent.plugin");
        if (this.enable == r10.enable) goto L12;
        return false;
    L12:
        if (this.aiagentEnable == r10.aiagentEnable) goto L15;
        return false;
    L15:
        if (Float.compare(this.frontSampledRate, r10.frontSampledRate) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.backgroundSampledRate, r10.backgroundSampledRate) == 0) goto L21;
        return false;
    L21:
        if (this.periodInterval == r10.periodInterval) goto L24;
        return false;
    L24:
        if (this.measureCpuTime == r10.measureCpuTime) goto L27;
        return false;
    L27:
        if (Float.compare(this.frontExceptionRatio, r10.frontExceptionRatio) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.backgroundExceptionRatio, r10.backgroundExceptionRatio) == 0) goto L33;
        return false;
    L33:
        if (this.topDumpCount == r10.topDumpCount) goto L36;
        return false;
    L36:
        if (this.threadStackSleepMaxRetry == r10.threadStackSleepMaxRetry) goto L39;
        return false;
    L39:
        if (this.dumpIntervalMillis == r10.dumpIntervalMillis) goto L42;
        return false;
    L42:
        if (this.stackFramePromotionEnabled == r10.stackFramePromotionEnabled) goto L45;
        return false;
    L45:
        if (o.a(this.stackFrameSkipClassPrefixes, r10.stackFrameSkipClassPrefixes) == true) goto L48;
        return false;
    L48:
        if (o.a(this.threadFilterExactNames, r10.threadFilterExactNames) == true) goto L51;
        return false;
    L51:
        if (o.a(this.threadFilterNamePrefixes, r10.threadFilterNamePrefixes) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Boolean.hashCode(this.enable) * 31) + Boolean.hashCode(this.aiagentEnable)) * 31) + Float.hashCode(this.frontSampledRate)) * 31) + Float.hashCode(this.backgroundSampledRate)) * 31) + Long.hashCode(this.periodInterval)) * 31) + Long.hashCode(this.measureCpuTime)) * 31) + Float.hashCode(this.frontExceptionRatio)) * 31) + Float.hashCode(this.backgroundExceptionRatio)) * 31) + Integer.hashCode(this.topDumpCount)) * 31) + Integer.hashCode(this.threadStackSleepMaxRetry)) * 31) + Long.hashCode(this.dumpIntervalMillis)) * 31) + Boolean.hashCode(this.stackFramePromotionEnabled)) * 31) + this.stackFrameSkipClassPrefixes.hashCode()) * 31) + this.threadFilterExactNames.hashCode()) * 31) + this.threadFilterNamePrefixes.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("CPUExceptionDiagnosisConfig(enable=").append(this.enable).append(", aiagentEnable=").append(this.aiagentEnable).append(", frontSampledRate=").append(this.frontSampledRate).append(", backgroundSampledRate=").append(this.backgroundSampledRate).append(", periodInterval=").append(this.periodInterval).append(", measureCpuTime=").append(this.measureCpuTime).append(", frontExceptionRatio=").append(this.frontExceptionRatio).append(", backgroundExceptionRatio=").append(this.backgroundExceptionRatio).append(", topDumpCount=").append(this.topDumpCount).append(", threadStackSleepMaxRetry=").append(this.threadStackSleepMaxRetry).append(", dumpIntervalMillis=").append(this.dumpIntervalMillis).append(", stackFramePromotionEnabled=");
        r0.append(this.stackFramePromotionEnabled).append(", stackFrameSkipClassPrefixes=").append(this.stackFrameSkipClassPrefixes).append(", threadFilterExactNames=").append(this.threadFilterExactNames).append(", threadFilterNamePrefixes=").append(this.threadFilterNamePrefixes).append(')');
        return r0.toString();
    }

    public CPUExceptionDiagnosisConfig(boolean r7, boolean r8, float r9, float r10, long r11, long r13, float r15, float r16, int r17, int r18, long r19, boolean r21, List<String> r22, List<String> r23, List<String> r24) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "stackFrameSkipClassPrefixes");
        o.e(r3, "threadFilterExactNames");
        o.e(r2, "threadFilterNamePrefixes");
        this.enable = r7;
        this.aiagentEnable = r8;
        this.frontSampledRate = r9;
        this.backgroundSampledRate = r10;
        this.periodInterval = r11;
        this.measureCpuTime = r13;
        this.frontExceptionRatio = r15;
        this.backgroundExceptionRatio = r16;
        this.topDumpCount = r17;
        this.threadStackSleepMaxRetry = r18;
        this.dumpIntervalMillis = r19;
        this.stackFramePromotionEnabled = r21;
        this.stackFrameSkipClassPrefixes = r1;
        this.threadFilterExactNames = r3;
        this.threadFilterNamePrefixes = r2;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getAiagentEnable() {
        return this.aiagentEnable;
    }

    public final float getFrontSampledRate() {
        return this.frontSampledRate;
    }

    public final float getBackgroundSampledRate() {
        return this.backgroundSampledRate;
    }

    public final long getPeriodInterval() {
        return this.periodInterval;
    }

    public final long getMeasureCpuTime() {
        return this.measureCpuTime;
    }

    public final float getFrontExceptionRatio() {
        return this.frontExceptionRatio;
    }

    public final float getBackgroundExceptionRatio() {
        return this.backgroundExceptionRatio;
    }

    public final int getTopDumpCount() {
        return this.topDumpCount;
    }

    public final int getThreadStackSleepMaxRetry() {
        return this.threadStackSleepMaxRetry;
    }

    public final long getDumpIntervalMillis() {
        return this.dumpIntervalMillis;
    }

    public final boolean getStackFramePromotionEnabled() {
        return this.stackFramePromotionEnabled;
    }

    public final List<String> getStackFrameSkipClassPrefixes() {
        return this.stackFrameSkipClassPrefixes;
    }

    public /* synthetic */ CPUExceptionDiagnosisConfig(boolean r19, boolean r20, float r21, float r22, long r23, long r25, float r27, float r28, int r29, int r30, long r31, boolean r33, List r34, List r35, List r36, int r37, h r38) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if ((r37 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r37 & 2) != 0) goto L10;
        r5 = r20;
    L10:
        float r7 = 0.0f;
        if ((r37 & 4) == 0) goto L13;
        float r6 = 0.0f;
    L15:
        if ((r37 & 8) != 0) goto L19;
        r7 = r22;
    L19:
        if ((r37 & 16) == 0) goto L21;
        long r8 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
    L23:
        if ((r37 & 32) == 0) goto L25;
        long r10 = 2000;
    L27:
        if ((r37 & 64) == 0) goto L29;
        float r12 = 0.03f;
    L31:
        if ((r37 & 128) == 0) goto L33;
        float r13 = 0.01f;
    L35:
        if ((r37 & 256) == 0) goto L37;
        int r14 = 5;
    L39:
        if ((r37 & 512) == 0) goto L41;
        int r15 = 5;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        long r16 = 20;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        boolean r9 = true;
    L51:
        if ((r37 & 4096) == 0) goto L53;
        List<String> r11 = b.a();
    L55:
        if ((r37 & 8192) == 0) goto L57;
        List<String> r17 = b.b();
    L59:
        if ((r37 & 16384) == 0) goto L61;
        List<String> r0 = b.c();
    L62:
        this(r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r9, r11, r17, r0);
        return;
    L61:
        r0 = r2;
        goto L62
    L57:
        r17 = r3;
        goto L59
    L53:
        r11 = r1;
        goto L55
    L49:
        r9 = r33;
        goto L51
    L45:
        r16 = r31;
        goto L47
    L41:
        r15 = r30;
        goto L43
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L13:
        r6 = r21;
        goto L15
    L5:
        r4 = r19;
        goto L7
    }

    public final List<String> getThreadFilterExactNames() {
        return this.threadFilterExactNames;
    }

    public final List<String> getThreadFilterNamePrefixes() {
        return this.threadFilterNamePrefixes;
    }

    public final long cpuExceptionTime(boolean r3) {
        if (r3 == false) goto L4;
        float r4 = this.backgroundExceptionRatio;
    L6:
        return (long) (this.measureCpuTime * n.a(r4, 0.0f, 1.0f));
    L4:
        r4 = this.frontExceptionRatio;
        goto L6
    }
}
