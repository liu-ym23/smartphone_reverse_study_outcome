package com.obric.performance.power.monitor.cpu.exception;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.performance.power.monitor.constants.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.i;
import d.a.p;
import d.f;
import d.g;
import d.h.b.o;
import d.l.n;
import d.m;
import d.s;
import d.x;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CPUExceptionDiagnosis.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "CPUExceptionDiagnosis";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f36975b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f36976c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f36977d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f36978e = null;
    private static boolean f;
    private static volatile CPUExceptionDiagnosisConfig g;
    private static com.obric.performance.power.monitor.constants.c h;
    private static e i;
    private static volatile boolean j;
    private static volatile boolean k;
    private static final f l = null;
    private static final b m = null;

    /* JADX INFO: renamed from: com.obric.performance.power.monitor.cpu.exception.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class C1011a<T> implements Comparator {
        public C1011a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin")).d(), Number.class, "com.obric.aiagent.plugin")).longValue()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin")).d(), Number.class, "com.obric.aiagent.plugin")).longValue()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CPUExceptionDiagnosis.kt */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.a(a.f36974a) == true) goto L14;
            ILogDepend.Companion.d(a.TAG, "periodTask skip (sample miss)");
        L10:
            if (a.a().get() == false) goto L12;
            a.c(a.f36974a).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), a.b().getPeriodInterval());
            return;
        L12:
            ILogDepend.Companion.d(a.TAG, "already stop");
            return;
        L14:
            a.b(a.f36974a);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            ILogDepend.Companion.e(a.TAG, "periodTask catch error", th);
            goto L10
        }
    }

    public static /* synthetic */ HandlerThread lambda$6c7Gz2E2Gq5BWXcgJnu9gGiWkDI() {
        return j();
    }

    public static /* synthetic */ ThreadGroup lambda$CapXvAiShTaAWVd5WTGIzu9t8C8() {
        return i();
    }

    public static /* synthetic */ x lambda$SXwO1uGzSsIE_vTO8zpkAl8W7Hc(boolean r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$aD3WaTtev_qgPChFAu4w8U0IOAM() {
        return l();
    }

    /* JADX INFO: renamed from: lambda$eh8H5cHHsMS6_qe7J-_WuAGBpmk, reason: not valid java name */
    public static /* synthetic */ x m1247lambda$eh8H5cHHsMS6_qe7J_WuAGBpmk(boolean r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$yIuZz98-qK38skDPmTYtPabmn8E, reason: not valid java name */
    public static /* synthetic */ Handler m1248lambda$yIuZz98qK38skDPmTYtPabmn8E() {
        return k();
    }

    private a() {
    }

    public static final /* synthetic */ AtomicBoolean a() {
        return f36975b;
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.g();
    }

    public static final /* synthetic */ CPUExceptionDiagnosisConfig b() {
        return g;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.h();
    }

    public static final /* synthetic */ Handler c(a r0) {
        return r0.e();
    }

    static {
        f36974a = new a();
        f36975b = new AtomicBoolean(false);
        f36976c = g.a($$Lambda$a$CapXvAiShTaAWVd5WTGIzu9t8C8.INSTANCE);
        f36977d = g.a($$Lambda$a$6c7Gz2E2Gq5BWXcgJnu9gGiWkDI.INSTANCE);
        f36978e = g.a($$Lambda$a$yIuZz98qK38skDPmTYtPabmn8E.INSTANCE);
        f = true;
        g = new CPUExceptionDiagnosisConfig(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
        h = (com.obric.performance.power.monitor.constants.c) ZeusTransformUtils.preCheckCast(com.obric.performance.power.monitor.constants.a.f36950a, com.obric.performance.power.monitor.constants.c.class, "com.obric.aiagent.plugin");
        i = (e) ZeusTransformUtils.preCheckCast(com.obric.performance.power.monitor.constants.b.f36951a, e.class, "com.obric.aiagent.plugin");
        j = true;
        l = g.a($$Lambda$a$aD3WaTtev_qgPChFAu4w8U0IOAM.INSTANCE);
        m = new b();
    }

    private final ThreadGroup c() {
        return (ThreadGroup) ZeusTransformUtils.preCheckCast(f36976c.b(), ThreadGroup.class, "com.obric.aiagent.plugin");
    }

    private static final ThreadGroup i() {
        SecurityManager r0 = System.getSecurityManager();
        if (r0 == null) goto L6;
        ThreadGroup r1 = r0.getThreadGroup();
        if (r1 == null) goto L6;
    L9:
        if (r1 == null) goto L11;
        ThreadGroup r2 = r1.getParent();
    L12:
        if (r2 == null) goto L14;
        r1 = r1.getParent();
        goto L9
    L14:
        if (r1 != null) goto L16;
        ILogDepend.Companion.e(TAG, "threadGroup null");
    L16:
        return r1;
    L11:
        r2 = null;
    L6:
        r1 = Thread.currentThread().getThreadGroup();
        if (r1 != null) goto L9;
        r1 = Looper.getMainLooper().getThread().getThreadGroup();
        goto L9
    }

    private final HandlerThread d() {
        return (HandlerThread) ZeusTransformUtils.preCheckCast(f36977d.b(), HandlerThread.class, "com.obric.aiagent.plugin");
    }

    private static final HandlerThread j() {
        HandlerThread r0 = new HandlerThread("cpu-exception-diagnosis");
        r0.start();
        c.f36982a.a(r0.getThreadId());
        return r0;
    }

    private final Handler e() {
        return (Handler) ZeusTransformUtils.preCheckCast(f36978e.b(), Handler.class, "com.obric.aiagent.plugin");
    }

    private static final Handler k() {
        return new Handler(f36974a.d().getLooper());
    }

    private final String f() {
        return (String) ZeusTransformUtils.preCheckCast(l.b(), String.class, "com.obric.aiagent.plugin");
    }

    private static final String l() {
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return "";
    L7:
        return Application.getProcessName();
    }

    private final boolean g() {
        if (j == false) goto L5;
        float r1 = g.getBackgroundSampledRate();
    L7:
        if (new Random().nextFloat() >= r1) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = g.getFrontSampledRate();
        goto L7
    }

    public final void a(CPUExceptionDiagnosisConfig r7, com.obric.performance.power.monitor.constants.c r8, e r9) {
        com.obric.performance.power.monitor.constants.c r10 = (com.obric.performance.power.monitor.constants.c) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.performance.power.monitor.constants.c.class, "com.obric.aiagent.plugin");
        e r11 = (e) ZeusTransformUtils.wrapperContextForParams(r9, e.class, "com.obric.aiagent.plugin");
        o.e(r7, "config");
        o.e(r10, "appBackgroundDelegate");
        o.e(r11, "screenStateDelegate");
        if (r7.getEnable() == true) goto L7;
        ILogDepend.Companion.d(TAG, "disable, return");
        return;
    L7:
        if (f36975b.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        if (com.obric.performance.power.monitor.utils.b.f37020a.a() == true) goto L12;
        ILogDepend.Companion.e(TAG, "reflect fail");
        return;
    L12:
        ILogDepend.Companion.d(TAG, "start");
        h = r10;
        i = r11;
        r10.a($$Lambda$a$SXwO1uGzSsIE_vTO8zpkAl8W7Hc.INSTANCE);
        r11.a($$Lambda$a$eh8H5cHHsMS6_qe7J_WuAGBpmk.INSTANCE);
        j = r10.a();
        k = r11.a();
        g = r7;
        c.f36982a.a((Collection) ZeusTransformUtils.preCheckCast(g.getThreadFilterExactNames(), Collection.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(g.getThreadFilterNamePrefixes(), Collection.class, "com.obric.aiagent.plugin"));
        e().postDelayed((Runnable) ZeusTransformUtils.preCheckCast(m, Runnable.class, "com.obric.aiagent.plugin"), n.a(new d.l.m(0, g.getPeriodInterval()), (d.k.c) ZeusTransformUtils.preCheckCast(d.k.c.f38513a, d.k.c.class, "com.obric.aiagent.plugin")));
    }

    private static final x a(boolean r2) {
        j = r2;
        ILogDepend.Companion.d(TAG, "OnAppBackGroundListener isBackground: " + j);
        return x.f38692a;
    }

    private static final x b(boolean r2) {
        k = r2;
        ILogDepend.Companion.d(TAG, "OnScreenStateListener isScreenOn: " + k);
        return x.f38692a;
    }

    private final void h() {
        ILogDepend.Companion.d(TAG, "threadCheckAndDump");
        long r2 = System.currentTimeMillis();
        ThreadGroup r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        int r4 = r0.activeCount() * 2;
        if (r4 > 0) goto L8;
        return;
    L8:
        Thread[] r5 = new Thread[r4];
        ILogDepend.Companion.d(TAG, "thread active:" + r4 + " actual:" + r0.enumerate(r5));
        Map<Integer, d> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        int r8 = 0;
    L9:
        if (r8 >= r4) goto L23;
        Thread r11 = r5[r8];
        if (r11 == null) goto L22;
        int r9 = com.obric.performance.power.monitor.utils.b.f37020a.a(r11);
        if (r9 > 0) goto L16;
        ILogDepend.Companion.w(TAG, "getNativeTid fail");
        goto L22
    L16:
        if (f == false) goto L19;
        c r10 = c.f36982a;
        String r13 = r11.getName();
        o.c(r13, "getName(...)");
        r10.a(r9, r13);
    L19:
        if (c.f36982a.b(r9) == true) goto L22;
        Integer r15 = Integer.valueOf(r9);
        String r12 = r11.getName();
        o.c(r12, "getName(...)");
        r1.put(r15, new d(r12, r11, 0, 4, null));
    L22:
        r8 = r8 + 1;
        r4 = r4;
        goto L9
    L23:
        f = false;
        ILogDepend.Companion.d(TAG, "enumerate cost:" + (System.currentTimeMillis() - r2));
        Map r3 = a(r1, p.e((Collection) ZeusTransformUtils.preCheckCast(r1.keySet(), Collection.class, "com.obric.aiagent.plugin")), g.getMeasureCpuTime(), g.cpuExceptionTime(j));
        if (r3.isEmpty() == false) goto L27;
        ILogDepend.Companion.d(TAG, "no issue thread");
        return;
    L27:
        ILogDepend.Companion.d(TAG, "issue thread list:" + r3.size());
        if (g.getTopDumpCount() <= 0) goto L34;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r3.entrySet(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), g.getTopDumpCount()), Iterable.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(p.a(r6, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r14 = r6.iterator();
    L31:
        if (r14.hasNext() == false) goto L33;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        m r17 = s.a(r16.getKey(), r16.getValue());
        r7.put(r17.a(), r17.b());
        goto L31
    L33:
        r3 = r7;
    L34:
        Iterator r18 = r3.entrySet().iterator();
    L36:
        if (r18.hasNext() == false) goto L49;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r20 = ((Number) ZeusTransformUtils.preCheckCast(r19.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        long r21 = ((Number) ZeusTransformUtils.preCheckCast(r19.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        d r22 = (d) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r20)), d.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L36;
        ILogDepend.Companion r23 = ILogDepend.Companion;
        StringBuilder r24 = new StringBuilder().append("try dump as exception, tid:").append(r20).append(", cpu:").append(r21).append(", thread name:").append(r22.a()).append(", processName: ");
        a r25 = f36974a;
        r23.d(TAG, r24.append(r25.f()).toString());
        r22.a(System.currentTimeMillis());
        StackTraceElement[] r26 = r25.a(r22.b());
        if (r26 == null) goto L36;
        Throwable r27 = r25.a(r25.a(r26), "CPUExceptionDiagnosis, thread name: " + r22.a() + ", processName: " + r25.f());
        ILogDepend.Companion.w(TAG, "dump stack as Throwable tid=" + r20 + ", thread name: " + r22.a() + ", processName: " + r25.f(), r27);
        if (k == true) goto L45;
        String r28 = "CPU_EXCEPTION_DIAGNOSIS_SCREEN_OFF";
    L48:
        com.bytedance.crash.f.a(r27, r28);
        goto L36
    L45:
        if (j == false) goto L47;
        r28 = "CPU_EXCEPTION_DIAGNOSIS_BACKGROUND";
        goto L48
    L47:
        r28 = "CPU_EXCEPTION_DIAGNOSIS_FOREGROUND";
        goto L48
    }

    private final Map<Integer, Long> a(Map<Integer, d> r16, int[] r17, long r18, long r20) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        if (r0.isEmpty() == true) goto L63;
        if (r17.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L63;
        com.obric.performance.power.monitor.cpu.a r13 = new com.obric.performance.power.monitor.cpu.a(false, false, false, r17, false, 22, null);
        r13.c();
        Thread.sleep(r18);
        r13.c();
        Map<Integer, Long> r2 = r13.a().i();
        if (r2 == null) goto L24;
        Iterator r4 = ao.a((Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(ao.g(r2), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C1011a(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L24;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(r5.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        d r8 = (d) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r6)), d.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L18;
        String r9 = r8.a();
    L19:
        ILogDepend.Companion r10 = ILogDepend.Companion;
        StringBuilder r11 = new StringBuilder().append("enable dump:");
        if (r7 <= r20) goto L22;
        boolean r14 = true;
    L23:
        r10.d(TAG, r11.append(r14).append(", tid:").append(r6).append(", cpuTime:").append(r7).append(", thread name:").append(r9).append(", processName: ").append(f36974a.f()).toString());
        goto L14
    L22:
        r14 = false;
        goto L23
    L18:
        r9 = null;
    L24:
        ILogDepend.Companion r12 = ILogDepend.Companion;
        StringBuilder r15 = new StringBuilder().append("threadCpuMap size: ");
        Map<Integer, Long> r19 = r13.a().i();
        if (r19 == null) goto L27;
        Integer r21 = Integer.valueOf(r19.size());
    L28:
        r12.d(TAG, r15.append(r21).toString());
        Map<Integer, Long> r22 = r13.a().i();
        if (r22 == null) goto L57;
        LinkedHashMap r23 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Long>> r24 = r22.entrySet().iterator();
    L32:
        if (r24.hasNext() == false) goto L45;
        Map.Entry r25 = (Map.Entry) ZeusTransformUtils.preCheckCast(r24.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d r26 = (d) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r25.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue())), d.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L38;
        Thread r27 = r26.b();
        if (r27 == null) goto L38;
        Thread.State r28 = r27.getState();
    L40:
        if (r28 == Thread.State.TERMINATED) goto L42;
        boolean r29 = true;
    L43:
        if (r29 == false) goto L32;
        r23.put(r25.getKey(), r25.getValue());
        goto L32
    L42:
        r29 = false;
    L38:
        r28 = null;
        goto L40
    L45:
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(r23, Map.class, "com.obric.aiagent.plugin");
        LinkedHashMap r30 = new LinkedHashMap();
        Iterator r31 = r1.entrySet().iterator();
    L47:
        if (r31.hasNext() == false) goto L56;
        Map.Entry r32 = (Map.Entry) ZeusTransformUtils.preCheckCast(r31.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        long r33 = ((Number) ZeusTransformUtils.preCheckCast(r32.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r20 <= r33) goto L51;
    L53:
        boolean r34 = false;
    L54:
        if (r34 == false) goto L47;
        r30.put(r32.getKey(), r32.getValue());
        goto L47
    L51:
        if (r33 > r18) goto L53;
        r34 = true;
        goto L54
    L56:
        Map<Integer, Long> r35 = (Map) ZeusTransformUtils.preCheckCast(r30, Map.class, "com.obric.aiagent.plugin");
    L59:
        if (r35.isEmpty() == false) goto L77;
        ILogDepend.Companion.d(TAG, "filteredResult isEmpty");
        return ao.b();
    L77:
        return r35;
    L57:
        r35 = ao.b();
        goto L59
    L27:
        r21 = null;
        goto L28
    L7:
        r3 = false;
    L63:
        return ao.b();
    }

    private final StackTraceElement[] a(Thread r15) {
        int r14 = n.c(g.getThreadStackSleepMaxRetry(), 0);
        long r1 = n.a(g.getDumpIntervalMillis(), 0);
        int r16 = r14 + 1;
        int r6 = 0;
    L4:
        if (r6 >= r16) goto L32;
        StackTraceElement[] r8 = r15.getStackTrace();     // Catch: Throwable -> L29
        if (r8 != null) goto L9;
        r8 = new StackTraceElement[0];     // Catch: Throwable -> L29
    L9:
        if (r8.length != 0) goto L11;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L15;
        a r10 = f36974a;
        StackTraceElement r12 = r8[0];
        o.c(r12, "get(...)");
        if (r10.a(r12) == false) goto L22;
        ILogDepend.Companion r11 = ILogDepend.Companion;
        String r13 = "stack top still sleep-like, retry " + (r6 + 1) + '/' + r16 + ", thread=" + r15.getName();
        Throwable r17 = new Throwable();
        r17.setStackTrace(r8);
        x r18 = x.f38692a;
        r11.w(TAG, r13, r17);
        if (r6 >= (r16 - 1)) goto L28;
        if (r1 <= 0) goto L28;
        Thread.sleep(r1);
    L28:
        r6 = r6 + 1;
        goto L4
    L22:
        return r8;
    L15:
        if (r6 < (r16 - 1)) goto L17;
    L19:
        ILogDepend.Companion.d(TAG, "java stack is empty, retry " + (r6 + 1) + '/' + r16 + ", thread=" + r15.getName());
        goto L28
    L17:
        if (r1 <= 0) goto L19;
        Thread.sleep(r1);
        goto L19
    L11:
        r9 = false;
    L29:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "getStackTrace failed, name=" + r15.getName(), th);
        return new StackTraceElement[0];
    L32:
        ILogDepend.Companion.d(TAG, "abandon stack after " + r16 + " attempts (still sleep-like), thread=" + r15.getName());
        return null;
    }

    private final boolean a(StackTraceElement r10) {
        String r9 = r10.getClassName();
        String r11 = r10.getMethodName();
        if (o.a(r9, "sun.misc.Unsafe") == false) goto L8;
        if (o.a(r11, "park") == false) goto L8;
    L46:
        return true;
    L8:
        if (o.a(r9, "android.os.MessageQueue") == false) goto L13;
        if (o.a(r11, "nativePollOnce") == true) goto L46;
    L13:
        if (o.a(r9, "java.lang.Thread") == false) goto L18;
        if (o.a(r11, "sleep") == true) goto L46;
    L18:
        if (o.a(r9, "java.lang.Object") == false) goto L23;
        o.a(r11);
        if (d.o.o.b(r11, "wait", false, 2, null) == true) goto L46;
    L23:
        if (o.a(r9, "java.util.concurrent.locks.LockSupport") == false) goto L27;
        o.a(r11);
        if (d.o.o.b(r11, "park", false, 2, null) == true) goto L46;
    L27:
        o.a(r9);
        if (d.o.o.b(r9, "jdk.internal.misc.Unsafe", false, 2, null) == false) goto L33;
        if (o.a(r11, "park") == true) goto L46;
    L33:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("AbstractQueuedSynchronizer", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L40;
        o.a(r11);
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("park", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L46;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("await", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L46;
    L40:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("AbstractQueuedLongSynchronizer", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L47;
        o.a(r11);
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("park", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L46;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("await", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L46;
        return false;
    L47:
        return false;
    }

    private final Throwable a(StackTraceElement[] r1, String r2) {
        Throwable r0 = new Throwable(r2);
        r0.setStackTrace(r1);
        return r0;
    }

    private final StackTraceElement[] a(StackTraceElement[] r8) {
        if (g.getStackFramePromotionEnabled() == true) goto L6;
        return r8;
    L6:
        if (r8.length != 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return r8;
    L11:
        List<String> r9 = g.getStackFrameSkipClassPrefixes();
        int r2 = r8.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L17;
        StackTraceElement r4 = r8[r3];
        a r5 = f36974a;
        String r6 = r4.getClassName();
        o.c(r6, "getClassName(...)");
        if ((!r5.a(r6, r9)) == true) goto L18;
        r3 = r3 + 1;
    L18:
        if (r3 > 0) goto L21;
        return r8;
    L21:
        return (StackTraceElement[]) ZeusTransformUtils.preCheckCast(i.a(new StackTraceElement[]{r8[r3]}, r8), StackTraceElement[].class, "com.obric.aiagent.plugin");
    L17:
        r3 = -1;
        goto L18
    L8:
        r7 = false;
        goto L9
    }

    private final boolean a(String r8, List<String> r9) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r10, "$") == true) goto L8;
        if (d.o.o.b(r8, r10, false, 2, null) == false) goto L4;
        return true;
    L8:
        if (d.o.o.b(r8, "$", false, 2, null) == false) goto L4;
        return true;
    L13:
        return false;
    }
}
