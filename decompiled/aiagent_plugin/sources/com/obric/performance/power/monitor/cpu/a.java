package com.obric.performance.power.monitor.cpu;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.performance.power.monitor.utils.EnsureLoad;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CPUMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1010a f36959a = null;
    private static Map<Integer, Long> j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f36960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f36961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f36962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f36963e;
    private final boolean f;
    private CPUInfo g;
    private int h;
    private com.obric.performance.power.monitor.cpu.b i;

    /* JADX INFO: renamed from: com.obric.performance.power.monitor.cpu.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CPUMonitor.kt */
    public static final class C1010a {
        public /* synthetic */ C1010a(h r1) {
            this();
        }

        private C1010a() {
        }
    }

    /* JADX INFO: compiled from: CPUMonitor.kt */
    public static final class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r4, String r5) {
            o.e(r4, "dir");
            o.e(r5, "name");
            if (d.o.o.b(r5, MonitorConstants.CPU, false, 2, null) == true) goto L5;
        L17:
            return false;
        L5:
            if (r5.length() < 4) goto L17;
            int r3 = 3;
            int r0 = r5.length();
        L7:
            if (r3 >= r0) goto L15;
            if (o.a(r5.charAt(r3), 48) < 0) goto L14;
            if (o.a(r5.charAt(r3), 57) > 0) goto L14;
            r3 = r3 + 1;
        L14:
            return false;
        L15:
            return true;
        }
    }

    static {
        f36959a = new C1010a(null);
    }

    public a() {
        this(false, false, false, null, false, 31, null);
    }

    public a(boolean r25, boolean r26, boolean r27, int[] r28, boolean r29) {
        this.f36960b = r25;
        this.f36961c = r26;
        this.f36962d = r27;
        this.f36963e = r28;
        this.f = r29;
        this.h = -1;
        this.i = new com.obric.performance.power.monitor.cpu.b(0.0d, 0.0d, 0.0d, 0.0d, 0, 0, null, 0, 0, null, null, 2047, null);
    }

    public /* synthetic */ a(boolean r4, boolean r5, boolean r6, int[] r7, boolean r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = true;
    L5:
        boolean r0 = false;
        if ((r9 & 2) == 0) goto L8;
        boolean r11 = false;
    L10:
        if ((r9 & 4) == 0) goto L12;
        boolean r1 = false;
    L14:
        if ((r9 & 8) == 0) goto L16;
        r7 = null;
    L16:
        int[] r2 = r7;
        if ((r9 & 16) != 0) goto L20;
        r0 = r8;
    L20:
        this(r4, r11, r1, r2, r0);
        return;
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }

    public final com.obric.performance.power.monitor.cpu.b a() {
        return this.i;
    }

    public final int b() {
        int r0 = this.h;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = d();
        this.h = r1;
        return r1;
    }

    private final int d() {
        String[] r3 = new File("/sys/devices/system/cpu").list((FilenameFilter) ZeusTransformUtils.preCheckCast(new b(), FilenameFilter.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L5;
        int r4 = r3.length;
    L6:
        a("CPUMonitor", "cpu number:" + r4);
        return r4;
    L5:
        r4 = 0;
        goto L6
    }

    public final void c() {
        if (EnsureLoad.f37016a.a() == true) goto L6;
        b("CPUMonitor", "so load fail");
        return;
    L6:
        boolean r4 = false;
        if (this.f36960b == true) goto L21;
        int[] r1 = this.f36963e;
        if (r1 == null) goto L19;
        if (r1 != null) goto L12;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L21;
    L12:
        if (r1.length != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 != true) goto L17;
        r2 = true;
        goto L18
    L14:
        r3 = false;
    L19:
        b("CPUMonitor", "error param");
        return;
    L21:
        this.i.j();
        boolean r7 = this.f36960b;
        boolean r6 = this.f;
        int[] r8 = this.f36963e;
        boolean r10 = this.f36961c;
        CPUInfo r5 = CPUNative.a(r7, r6, r7, r8, r10, r10);
        CPUInfo r9 = this.g;
        if (r9 == null) goto L87;
        this.i.d(System.currentTimeMillis() - r9.getRefreshTime());
        long r11 = r5.getProcCpu() - r9.getProcCpu();
        long r12 = 0;
        if (r11 <= 0) goto L34;
        this.i.c(r11);
        com.obric.performance.power.monitor.cpu.b r13 = this.i;
        r13.b((r13.g() / this.i.h()) / ((double) b()));
        long r14 = r5.getDevCpu() - r9.getDevCpu();
        if (r14 <= 0) goto L34;
        this.i.a(r14);
        com.obric.performance.power.monitor.cpu.b r15 = this.i;
        r15.a(r15.g() / r14);
        long r16 = r5.getDevIdle() - r9.getDevIdle();
        if (1 <= r16) goto L30;
    L32:
        if (r4 == false) goto L34;
        this.i.b(r16);
        com.obric.performance.power.monitor.cpu.b r17 = this.i;
        r17.d(((double) 1) - (r17.e() / this.i.d()));
        goto L34
    L30:
        if (r16 > r14) goto L32;
        r4 = true;
    L34:
        Map<Integer, Map<Long, Long>> r18 = r5.getDevCpuFreqMap();
        if (r18 == null) goto L46;
        Map<Integer, Map<Long, Long>> r19 = r9.getDevCpuFreqMap();
        if (r19 == null) goto L46;
        Map<Integer, Map<Long, Long>> r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r21 = r18.entrySet().iterator();
    L40:
        if (r21.hasNext() == false) goto L44;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r21.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r111 = ((Number) ZeusTransformUtils.preCheckCast(r110.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        Map<Long, Long> r112 = (Map) ZeusTransformUtils.preCheckCast(r110.getValue(), Map.class, "com.obric.aiagent.plugin");
        Map<Long, Long> r113 = (Map) ZeusTransformUtils.preCheckCast(r19.get(Integer.valueOf(r111)), Map.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L40;
        r20.put(Integer.valueOf(r111), a(r112, r113));
        goto L40
    L44:
        this.i.a(r20);
    L46:
        if (this.f36962d == false) goto L63;
        Map<Integer, Map<Long, Long>> r22 = this.i.f();
        if (r22 == null) goto L63;
        a(r22);
        double r23 = 0.0d;
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r114 = r22.entrySet().iterator();
    L51:
        if (r114.hasNext() == false) goto L62;
        Map.Entry r115 = (Map.Entry) ZeusTransformUtils.preCheckCast(r114.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r116 = ((Number) ZeusTransformUtils.preCheckCast(r115.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        Map r117 = (Map) ZeusTransformUtils.preCheckCast(r115.getValue(), Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Long> r118 = j;
        o.a(r118);
        Long r119 = (Long) ZeusTransformUtils.preCheckCast(r118.get(Integer.valueOf(r116)), Long.class, "com.obric.aiagent.plugin");
        if (r119 == null) goto L51;
        long r120 = ((Number) ZeusTransformUtils.preCheckCast(r119, Number.class, "com.obric.aiagent.plugin")).longValue();
        Iterator r121 = r117.entrySet().iterator();
    L56:
        if (r121.hasNext() == false) goto L58;
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r122 = r114;
        Map.Entry r123 = (Map.Entry) ZeusTransformUtils.preCheckCast(r121.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r12 = r12 + (((Number) ZeusTransformUtils.preCheckCast(r123.getKey(), Number.class, "com.obric.aiagent.plugin")).longValue() * ((Number) ZeusTransformUtils.preCheckCast(r123.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue());
        r114 = r122;
        r121 = r121;
        goto L56
    L58:
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r124 = r114;
        double r24 = r12 / (r120 * this.i.h());
        c("CPUMonitor", "policyId:" + r116 + " policyAverage:" + r24);
        if (r24 <= 1.0d) goto L61;
        r24 = 1.0d;
    L61:
        r23 = r23 + r24;
        r114 = r124;
        r12 = 0;
        goto L51
    L62:
        double r25 = r23 / ((double) r22.size());
        d("CPUMonitor", "cpuUsageFactor:" + r25);
        com.obric.performance.power.monitor.cpu.b r26 = this.i;
        r26.c(r26.a() * r25);
    L63:
        Map<Integer, Long> r27 = r5.getThreadCpuMap();
        if (r27 == null) goto L76;
        Map<Integer, Long> r28 = r9.getThreadCpuMap();
        if (r28 == null) goto L76;
        Map<Integer, Long> r29 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<Integer, Long>> r30 = r27.entrySet().iterator();
    L69:
        if (r30.hasNext() == false) goto L75;
        Map.Entry r31 = (Map.Entry) ZeusTransformUtils.preCheckCast(r30.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r32 = ((Number) ZeusTransformUtils.preCheckCast(r31.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        long r33 = ((Number) ZeusTransformUtils.preCheckCast(r31.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Long r34 = (Long) ZeusTransformUtils.preCheckCast(r28.get(Integer.valueOf(r32)), Long.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L69;
        long r35 = r33 - ((Number) ZeusTransformUtils.preCheckCast(r34, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r35 < 0) goto L69;
        r29.put(Integer.valueOf(r32), Long.valueOf(r35));
        goto L69
    L75:
        this.i.b(r29);
    L76:
        Map<Integer, Map<Integer, Long>> r36 = r5.getThreadCpuPolicyMap();
        if (r36 == null) goto L87;
        Map<Integer, Map<Integer, Long>> r37 = r9.getThreadCpuPolicyMap();
        if (r37 == null) goto L87;
        Map<Integer, Map<Integer, Long>> r38 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<Integer, Map<Integer, Long>>> r39 = r36.entrySet().iterator();
    L82:
        if (r39.hasNext() == false) goto L86;
        Map.Entry r40 = (Map.Entry) ZeusTransformUtils.preCheckCast(r39.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r41 = ((Number) ZeusTransformUtils.preCheckCast(r40.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        Map<Integer, Long> r42 = (Map) ZeusTransformUtils.preCheckCast(r40.getValue(), Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Long> r43 = (Map) ZeusTransformUtils.preCheckCast(r37.get(Integer.valueOf(r41)), Map.class, "com.obric.aiagent.plugin");
        if (r43 == null) goto L82;
        r38.put(Integer.valueOf(r41), b(r42, r43));
        goto L82
    L86:
        this.i.c(r38);
    L87:
        this.g = r5;
    }

    private final void a(Map<Integer, Map<Long, Long>> r13) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        if (j != null) goto L38;
        c r14 = c.f36964a;
        monitor-enter(r14);
    L35:
        th = move-exception;
        throw th;
    L7:
        if (j != null) goto L32;
        j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        Map<Integer, Integer> r0 = CPUNative.f36957a.a();     // Catch: Throwable -> L35
        if (r0 == null) goto L32;
        Iterator<Map.Entry<Integer, Integer>> r1 = r0.entrySet().iterator();     // Catch: Throwable -> L35
    L12:
        if (r1.hasNext() == false) goto L32;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L35
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.getValue(), Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L35
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r12.get(Integer.valueOf(r3)), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r5 == null) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L35
        Long r7 = null;
        if (r6.hasNext() == true) goto L18;
        Object r8 = null;
    L27:
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8, Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r9 == null) goto L30;
        r7 = (Long) ZeusTransformUtils.preCheckCast(r9.getKey(), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
    L30:
        if (r7 == null) goto L12;
        d("CPUMonitor", "cpuNum:" + r4 + " maxFreq:" + r7);     // Catch: Throwable -> L35
        Integer r10 = Integer.valueOf(r3);     // Catch: Throwable -> L35
        Map<Integer, Long> r11 = j;     // Catch: Throwable -> L35
        o.a(r11);     // Catch: Throwable -> L35
        r11.put(r10, Long.valueOf(((long) r4) * r7.longValue()));     // Catch: Throwable -> L35
        goto L12
    L18:
        r8 = r6.next();     // Catch: Throwable -> L35
        if (r6.hasNext() == false) goto L27;
        long r15 = ((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r8, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L35
    L22:
        Object r16 = r6.next();     // Catch: Throwable -> L35
        long r17 = ((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r16, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L35
        if (r15 >= r17) goto L26;
        r8 = r16;
        r15 = r17;
    L26:
        if (r6.hasNext() == true) goto L22;
    L32:
        x r18 = x.f38692a;     // Catch: Throwable -> L35
        monitor-exit(r14);
        return;
    }

    private final Map<Long, Long> a(Map<Long, Long> r9, Map<Long, Long> r10) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        Map<Long, Long> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r13 = r8.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.getKey(), Number.class, "com.obric.aiagent.plugin")).longValue();
        long r4 = ((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(r11.get(Long.valueOf(r2)), Long.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L4;
        long r5 = r4 - ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue();
        r12.put(Long.valueOf(r2), Long.valueOf(r5));
        goto L4
    L8:
        return r12;
    }

    private final Map<Integer, Long> b(Map<Integer, Long> r8, Map<Integer, Long> r9) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map<Integer, Long> r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r12 = r7.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(r10.get(Integer.valueOf(r2)), Long.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        long r5 = r3 - ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue();
        r11.put(Integer.valueOf(r2), Long.valueOf(r5));
        goto L4
    L8:
        return r11;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
