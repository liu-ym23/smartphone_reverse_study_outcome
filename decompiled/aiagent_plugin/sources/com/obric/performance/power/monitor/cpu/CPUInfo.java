package com.obric.performance.power.monitor.cpu;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CPUInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CPUInfo {
    private long devCpu;
    private Map<Integer, Map<Long, Long>> devCpuFreqMap;
    private long devIdle;
    private long procCpu;
    private long refreshTime;
    private Map<Integer, Long> threadCpuMap;
    private Map<Integer, Map<Integer, Long>> threadCpuPolicyMap;

    public CPUInfo() {
        this(0, 0, 0, null, 0, null, null, 127, null);
    }

    public CPUInfo(long r3, long r5, long r7, Map<Integer, Map<Long, Long>> r9, long r10, Map<Integer, Long> r12, Map<Integer, Map<Integer, Long>> r13) {
        Map<Integer, Map<Long, Long>> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Long> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Map<Integer, Long>> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        this.refreshTime = r3;
        this.devCpu = r5;
        this.devIdle = r7;
        this.devCpuFreqMap = r11;
        this.procCpu = r10;
        this.threadCpuMap = r14;
        this.threadCpuPolicyMap = r15;
    }

    public /* synthetic */ CPUInfo(long r14, long r16, long r18, Map r20, long r21, Map r23, Map r24, int r25, h r26) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        long r4 = 0;
        if ((r25 & 1) == 0) goto L5;
        long r6 = 0;
    L7:
        if ((r25 & 2) == 0) goto L9;
        long r8 = 0;
    L11:
        if ((r25 & 4) == 0) goto L13;
        long r10 = 0;
    L14:
        Map r12 = null;
        if ((r25 & 8) == 0) goto L18;
        r0 = null;
    L18:
        if ((r25 & 16) != 0) goto L22;
        r4 = r21;
    L22:
        if ((r25 & 32) == 0) goto L25;
        r2 = null;
    L25:
        if ((r25 & 64) != 0) goto L28;
        r12 = r1;
    L28:
        this(r6, r8, r10, r0, r4, r2, r12);
        return;
    L13:
        r10 = r18;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public final long getRefreshTime() {
        return this.refreshTime;
    }

    public final void setRefreshTime(long r1) {
        this.refreshTime = r1;
    }

    public final long getDevCpu() {
        return this.devCpu;
    }

    public final void setDevCpu(long r1) {
        this.devCpu = r1;
    }

    public final long getDevIdle() {
        return this.devIdle;
    }

    public final void setDevIdle(long r1) {
        this.devIdle = r1;
    }

    public final Map<Integer, Map<Long, Long>> getDevCpuFreqMap() {
        return this.devCpuFreqMap;
    }

    public final void setDevCpuFreqMap(Map<Integer, Map<Long, Long>> r3) {
        this.devCpuFreqMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final long getProcCpu() {
        return this.procCpu;
    }

    public final void setProcCpu(long r1) {
        this.procCpu = r1;
    }

    public final Map<Integer, Long> getThreadCpuMap() {
        return this.threadCpuMap;
    }

    public final void setThreadCpuMap(Map<Integer, Long> r3) {
        this.threadCpuMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<Integer, Map<Integer, Long>> getThreadCpuPolicyMap() {
        return this.threadCpuPolicyMap;
    }

    public final void setThreadCpuPolicyMap(Map<Integer, Map<Integer, Long>> r3) {
        this.threadCpuPolicyMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final void putDeviceCpuFreq(int r5, long r6, long r8) {
        if (this.devCpuFreqMap != null) goto L5;
        this.devCpuFreqMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L5:
        Map<Integer, Map<Long, Long>> r0 = this.devCpuFreqMap;
        if (r0 == null) goto L11;
        Integer r7 = Integer.valueOf(r5);
        Map<Long, Long> r2 = r0.get(r7);
        if (r2 != null) goto L10;
        r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r0.put(r7, r2);
    L10:
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put(Long.valueOf(r6), Long.valueOf(r8));
    L11:
        this.devCpu += r8;
    }

    public final void putThreadCpuPolicy(int r6, int r7, long r8) {
        if (this.threadCpuPolicyMap != null) goto L5;
        this.threadCpuPolicyMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L5:
        Map<Integer, Map<Integer, Long>> r0 = this.threadCpuPolicyMap;
        if (r0 == null) goto L12;
        Integer r2 = Integer.valueOf(r6);
        Map<Integer, Long> r3 = r0.get(r2);
        if (r3 != null) goto L10;
        r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r0.put(r2, r3);
    L10:
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(Integer.valueOf(r7), Long.valueOf(r8));
    L12:
        if (this.threadCpuMap != null) goto L14;
        this.threadCpuMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L14:
        Map<Integer, Long> r5 = this.threadCpuMap;
        if (r5 == null) goto L21;
        Integer r9 = Integer.valueOf(r6);
        Long r1 = r5.get(r9);
        if (r1 != null) goto L19;
        r1 = 0L;
        r5.put(r9, r1);
    L19:
        long r4 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue() + r8;
        r5.put(Integer.valueOf(r6), Long.valueOf(r4));
        return;
    }

    public final void putThreadCpu(int r4, long r5) {
        if (this.threadCpuMap != null) goto L5;
        this.threadCpuMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L5:
        Map<Integer, Long> r3 = this.threadCpuMap;
        if (r3 == null) goto L9;
        r3.put(Integer.valueOf(r4), Long.valueOf(r5));
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("(refreshTime:").append(this.refreshTime).append(", devCpu:").append(this.devCpu).append(", devIdle:").append(this.devIdle).append(", procCpu:").append(this.procCpu).append(", devCpuPolicy:");
        Object r1 = this.devCpuFreqMap;
        Object r2 = "null";
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        StringBuilder r3 = r0.append(r1).append(" threadCpuMap:");
        Object r4 = this.threadCpuMap;
        if (r4 != null) goto L8;
        r4 = "null";
    L8:
        StringBuilder r5 = r3.append(r4).append(" threadCpuPolicyMap:");
        Map<Integer, Map<Integer, Long>> r6 = this.threadCpuPolicyMap;
        if (r6 == null) goto L13;
        r2 = r6;
    L13:
        return r5.append(r2).append(')').toString();
    }
}
