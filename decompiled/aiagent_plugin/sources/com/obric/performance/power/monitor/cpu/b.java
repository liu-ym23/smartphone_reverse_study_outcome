package com.obric.performance.power.monitor.cpu;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: CPUMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f36965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f36966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f36967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f36968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f36969e;
    private long f;
    private Map<Integer, Map<Long, Long>> g;
    private long h;
    private long i;
    private Map<Integer, Long> j;
    private Map<Integer, Map<Integer, Long>> k;

    public b() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 0, 0, null, 0, 0, null, null, 2047, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (Double.compare(this.f36965a, r10.f36965a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f36966b, r10.f36966b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f36967c, r10.f36967c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f36968d, r10.f36968d) == 0) goto L21;
        return false;
    L21:
        if (this.f36969e == r10.f36969e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (o.a(this.k, r10.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((Double.hashCode(this.f36965a) * 31) + Double.hashCode(this.f36966b)) * 31) + Double.hashCode(this.f36967c)) * 31) + Double.hashCode(this.f36968d)) * 31) + Long.hashCode(this.f36969e)) * 31) + Long.hashCode(this.f)) * 31;
        Map<Integer, Map<Long, Long>> r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31;
        Map<Integer, Long> r5 = this.j;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<Integer, Map<Integer, Long>> r8 = this.k;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public b(double r7, double r9, double r11, double r13, long r15, long r17, Map<Integer, Map<Long, Long>> r19, long r20, long r22, Map<Integer, Long> r24, Map<Integer, Map<Integer, Long>> r25) {
        Map<Integer, Map<Long, Long>> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Long> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Map<Integer, Long>> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        this.f36965a = r7;
        this.f36966b = r9;
        this.f36967c = r11;
        this.f36968d = r13;
        this.f36969e = r15;
        this.f = r17;
        this.g = r1;
        this.h = r20;
        this.i = r22;
        this.j = r3;
        this.k = r2;
    }

    public /* synthetic */ b(double r23, double r25, double r27, double r29, long r31, long r33, Map r35, long r36, long r38, Map r40, Map r41, int r42, h r43) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r40, Map.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r41, Map.class, "com.obric.aiagent.plugin");
        double r5 = 0.0d;
        if ((r42 & 1) == 0) goto L5;
        double r7 = 0.0d;
    L7:
        if ((r42 & 2) == 0) goto L9;
        double r9 = 0.0d;
    L11:
        if ((r42 & 4) == 0) goto L13;
        double r11 = 0.0d;
    L15:
        if ((r42 & 8) != 0) goto L18;
        r5 = r29;
    L18:
        long r13 = 0;
        if ((r42 & 16) == 0) goto L21;
        long r15 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        long r17 = 0;
    L27:
        if ((r42 & 64) == 0) goto L30;
        r1 = null;
    L30:
        if ((r42 & 128) == 0) goto L32;
        long r20 = 0;
    L34:
        if ((r42 & 256) != 0) goto L38;
        r13 = r38;
    L38:
        if ((r42 & 512) == 0) goto L41;
        r3 = null;
    L41:
        if ((r42 & 1024) == 0) goto L43;
        r2 = null;
    L43:
        this(r7, r9, r11, r5, r15, r17, r1, r20, r13, r3, r2);
        return;
    L32:
        r20 = r36;
        goto L34
    L25:
        r17 = r33;
        goto L27
    L21:
        r15 = r31;
        goto L23
    L13:
        r11 = r27;
        goto L15
    L9:
        r9 = r25;
        goto L11
    L5:
        r7 = r23;
        goto L7
    }

    public final double a() {
        return this.f36965a;
    }

    public final void a(double r1) {
        this.f36965a = r1;
    }

    public final double b() {
        return this.f36966b;
    }

    public final void b(double r1) {
        this.f36966b = r1;
    }

    public final void c(double r1) {
        this.f36967c = r1;
    }

    public final double c() {
        return this.f36968d;
    }

    public final void d(double r1) {
        this.f36968d = r1;
    }

    public final void a(long r1) {
        this.f36969e = r1;
    }

    public final long d() {
        return this.f36969e;
    }

    public final void b(long r1) {
        this.f = r1;
    }

    public final long e() {
        return this.f;
    }

    public final void a(Map<Integer, Map<Long, Long>> r3) {
        this.g = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<Integer, Map<Long, Long>> f() {
        return this.g;
    }

    public final void c(long r1) {
        this.h = r1;
    }

    public final long g() {
        return this.h;
    }

    public final void d(long r1) {
        this.i = r1;
    }

    public final long h() {
        return this.i;
    }

    public final void b(Map<Integer, Long> r3) {
        this.j = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<Integer, Long> i() {
        return this.j;
    }

    public final void c(Map<Integer, Map<Integer, Long>> r3) {
        this.k = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final void j() {
        this.f36965a = 0.0d;
        this.f36966b = 0.0d;
        this.f36967c = 0.0d;
        this.f36968d = 0.0d;
        this.f36969e = 0;
        this.f = 0;
        Map<Integer, Map<Long, Long>> r2 = this.g;
        if (r2 == null) goto L5;
        r2.clear();
    L5:
        this.h = 0;
        this.i = 0;
        Map<Integer, Long> r0 = this.j;
        if (r0 == null) goto L8;
        r0.clear();
    L8:
        Map<Integer, Map<Integer, Long>> r3 = this.k;
        if (r3 == null) goto L12;
        r3.clear();
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("(cpuUsage:").append(this.f36965a).append(", cpuSpeed:").append(this.f36966b).append(", normalizerCpuUsage:").append(this.f36967c).append(", systemCpuUsage:").append(this.f36968d).append(", deviceCpuTime:").append(this.f36969e).append(", deviceIdleTime:").append(this.f).append(", deviceFreqCpuMap:");
        Object r2 = this.g;
        Object r3 = "null";
        if (r2 != null) goto L5;
        r2 = "null";
    L5:
        StringBuilder r4 = r1.append(r2).append(", processCpuTime:").append(this.h).append(", processWallTime:").append(this.i).append(", threadCpuMap:").append(this.j).append(", threadPolicyCpuMap:");
        Map<Integer, Map<Integer, Long>> r6 = this.k;
        if (r6 == null) goto L9;
        r3 = r6;
    L9:
        r4.append(r3).append(')');
        return r0.toString();
    }
}
