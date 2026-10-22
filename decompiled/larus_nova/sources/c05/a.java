package c05;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.ProcessMonitorConfig;
import com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f21929a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ScheduledFuture<?> f21930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f21931c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<InterfaceC0385a> f21932d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f21933e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f21934f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f21935g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f21936h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f21937i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f21938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f21939k = null;

    /* JADX INFO: renamed from: c05.a$a, reason: collision with other inner class name */
    public interface InterfaceC0385a {
        void onProcessCpuChange(String r100, boolean r101, CpuInfo r102);
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21940a = null;

        static {
            f21940a = new b();
        }

        public b() {
        }

        public static void a() {
            tt5.a.h("ProcessMonitor_CpuCollectTimerService", "CpuTask coming");
        L52:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);
            return;
        L4:
            if (a.f21930b == null) goto L50;
            ScheduledFuture<?> r100 = a.f21930b;     // Catch: Throwable -> L52
            if (r100 != null) goto L8;
        L10:
            boolean r101 = false;
        L11:
            if (r101 == true) goto L50;
            ConcurrentHashMap<String, Integer> r102 = a.f21933e;     // Catch: Throwable -> L52
            if (r102.isEmpty() == true) goto L50;
            Iterator<Map.Entry<String, Integer>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L52
        L17:
            if (r103.hasNext() == false) goto L60;
            Map.Entry<String, Integer> r104 = r103.next();     // Catch: Throwable -> L52
            if (a.f21937i == true) goto L21;
        L31:
            int r105 = c05.b.f21942b;     // Catch: Throwable -> L52
            CpuInfo r106 = c05.b.a.a(r104.getKey(), a.f21936h);     // Catch: Throwable -> L52
        L32:
            if (r106 == null) goto L36;
            Integer r107 = r106.getPid();     // Catch: Throwable -> L52
            if (r107 == null) goto L36;
            int r108 = r107.intValue();     // Catch: Throwable -> L52
        L37:
            ConcurrentHashMap<String, Integer> r109 = a.f21934f;     // Catch: Throwable -> L52
            Integer r110 = r109.get(r104.getKey());     // Catch: Throwable -> L52
            if (r110 == null) goto L40;
            int r111 = r110.intValue();     // Catch: Throwable -> L52
        L41:
            if (r111 <= 0) goto L45;
            if (r108 <= 0) goto L45;
            if (r111 == r108) goto L45;
            tt5.a.k("ProcessMonitor_CpuCollectTimerService", "check process restarted, process=" + r104.getKey() + ", curPid=" + r108);     // Catch: Throwable -> L52
            boolean r112 = true;
        L46:
            r109.put(r104.getKey(), Integer.valueOf(r108));     // Catch: Throwable -> L52
            Iterator<InterfaceC0385a> r113 = a.f21932d.iterator();     // Catch: Throwable -> L52
        L48:
            if (r113.hasNext() == false) goto L17;
            r113.next().onProcessCpuChange(r104.getKey(), r112, r106);     // Catch: Throwable -> L52
        L45:
            r112 = false;
            goto L46
        L40:
            r111 = 0;
        L36:
            r108 = 0;
            goto L37
        L21:
            if (TextUtils.equals("sandboxed_process", r104.getKey()) == false) goto L31;
            int r114 = c05.b.f21942b;     // Catch: Throwable -> L28
            ISandboxProcessServer r115 = c05.b.a.b();     // Catch: Throwable -> L28
            if (r115 != null) goto L25;
            tt5.a.d("ProcessMonitor_CpuCollectTimerService", "sandboxServer is null");     // Catch: Throwable -> L28
        L25:
            if (r115 == null) goto L30;
            r106 = r115.getCurrentCpuRate(r104.getKey(), a.f21936h);     // Catch: Throwable -> L28
        L30:
            r106 = null;
            goto L32
        L28:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);     // Catch: Throwable -> L52
            goto L30
        L60:
            return;
        L8:
            if (r100.isCancelled() != true) goto L10;
            r101 = true;
        L50:
            tt5.a.h("ProcessMonitor_CpuCollectTimerService", "CpuTask ignore run");     // Catch: Throwable -> L52
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static void a() {
    L16:
        th = move-exception;
        tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);
        return;
    L4:
        if (f21930b == null) goto L21;
        ScheduledFuture<?> r100 = f21930b;     // Catch: Throwable -> L16
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L22;
        ScheduledFuture<?> r102 = f21930b;     // Catch: Throwable -> L16
        if (r102 == null) goto L23;
        r102.cancel(true);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L22:
        return;
    L8:
        if (r100.isCancelled() != true) goto L10;
        r101 = true;
        goto L11
    }

    static {
        f21929a = 300000;
        f21931c = 5000;
        f21932d = new CopyOnWriteArrayList();
        f21933e = new ConcurrentHashMap();
        f21934f = new ConcurrentHashMap();
        f21938j = true;
        f21939k = b.f21940a;
        ProcessMonitorConfig r100 = (ProcessMonitorConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(ProcessMonitorConfig.KEY, ProcessMonitorConfig.class, new ProcessMonitorConfig());
        f21931c = r100.getCpuConfig().getIntervalInMills();
        f21935g = r100.getCpuConfig().isDiscardInBackground();
        f21936h = r100.getCpuConfig().isThreadCollectEnable();
        f21937i = r100.getCpuConfig().isSandboxCollectFallback();
        f21929a = r100.getCpuConfig().getBgIntervalInMills();
        tt5.a.h("ProcessMonitor_CpuCollectTimerService", "processMonitorConfig=" + r100);
    }

    public static void b(long r100, long r110) {
        tt5.a.h("ProcessMonitor_CpuCollectTimerService", "restartTask delay=" + r100 + " interval=" + r110);
        a();     // Catch: Throwable -> L8
        ScheduledExecutorService r101 = CoreThreadPool.getDefault().getScheduleThreadPool();     // Catch: Throwable -> L8
        b r102 = f21939k;     // Catch: Throwable -> L8
        if (r110 > 0) goto L6;
        r110 = 5000;
    L6:
        f21930b = r101.scheduleWithFixedDelay(r102, r100, r110, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.f("ProcessMonitor_CpuCollectTimerService", th, false);
    }
}
