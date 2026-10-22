package com.bytedance.apm6.cpu.collect;

import android.os.Process;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.apm.util.m;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import v2.f;
import v2.g;

/* JADX INFO: loaded from: classes.dex */
public class b extends q3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.apm6.cpu.collect.a f6766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f6767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u3.a f6768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u2.a f6773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IAssistStat f6774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6775j;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f6776d;

        public a(b r10, long r11, long r12) {
            this.f6776d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w0.c.B() == false) goto L5;
            s3.a.a("APM-CPU", "run: " + b.a(this.f6776d));
        L5:
            b.b(this.f6776d, t2.a.e().g());
            if (b.c(this.f6776d) == true) goto L8;
            b.e(this.f6776d);
            b.f(this.f6776d);
        L8:
            b.d(this.f6776d, false);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.b$b, reason: collision with other inner class name */
    public class C0083b implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f6777a;

        public C0083b(b r10) {
            this.f6777a = r10;
        }

        public int a(ICpuDataService.a r10, ICpuDataService.a r11) {
            return (int) ((r11.a() * 100.0d) - (r10.a() * 100.0d));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((ICpuDataService.a) r10, (ICpuDataService.a) r11);
        }
    }

    public b(com.bytedance.apm6.cpu.collect.a r10, IAssistStat r11) {
        this.f6775j = true;
        this.f6767b = new AtomicBoolean(false);
        this.f6766a = r10;
        this.f6774i = r11;
    }

    public static /* synthetic */ long a(b r10) {
        return r10.f6769d;
    }

    public static /* synthetic */ void b(b r10, boolean r11) {
        r10.k(r11);
    }

    public static /* synthetic */ boolean c(b r10) {
        return r10.f6775j;
    }

    public static /* synthetic */ boolean d(b r10, boolean r11) {
        r10.f6775j = r11;
        return r11;
    }

    public static /* synthetic */ void e(b r10) {
        r10.g();
    }

    public static /* synthetic */ void f(b r10) {
        r10.h();
    }

    public final void g() {
        long r10 = System.currentTimeMillis();
        if ((r10 - this.f6771f) >= this.f6769d) goto L5;
        return;
    L5:
        this.f6771f = r10;
        int r11 = com.bytedance.apm.util.b.b();
        if (r11 > 0) goto L8;
        return;
    L8:
        long r12 = PerfMonitorManager.o().c();
        long r13 = PerfMonitorManager.o().l(r11);
        Thread.sleep(360);     // Catch: InterruptedException -> L30
        long r14 = PerfMonitorManager.o().c();
        long r15 = PerfMonitorManager.o().l(r11) - r13;
        if (r15 <= 0) goto L13;
        double r16 = (r14 - r12) / r15;
        s1.a.b("MonitorCpu", "appCpuRate -> " + r16);
    L14:
        double r17 = (r14 - r12) * 1000.0d;
        double r18 = (r17 / (System.currentTimeMillis() - r10)) / com.bytedance.apm.util.b.h(100);
        if (w0.c.B() == false) goto L18;
        s3.a.a("APM-CPU", String.valueOf(r17) + " " + (System.currentTimeMillis() - r10) + " " + com.bytedance.apm.util.b.h(100));
    L18:
        if (w0.c.B() == false) goto L31;
        s1.a.b("MonitorCpu", "appCpuSpeed -> " + r18);
        s3.a.a("APM-CPU", "collect cpu data, rate: " + r16 + " speed: " + r18);
    L31:
        this.f6774i.refreshCpuStat();     // Catch: Throwable -> L22
        IAssistStat.b r19 = this.f6774i.getCpuFactorTag();     // Catch: Throwable -> L22
    L24:
        if (this.f6766a.f() == false) goto L26;
        this.f6766a.a(r16, r18);
        this.f6766a.k(r19);
    L26:
        x2.a.a().b(r16, r18);
        ApmCpuManager.ICpuDataListener r110 = t2.a.e().d();
        if (r110 == null) goto L35;
        r110.onCpuData(r18, r16, m3.c.a().getSceneString(), r19, NetworkUtils.g(w0.c.g()));
        return;
    L35:
        return;
    L22:
        r19 = null;
        goto L24
    L13:
        r16 = -1.0d;
    }

    public final void h() {
        long r10 = System.currentTimeMillis();
        if ((r10 - this.f6772g) >= this.f6770e) goto L5;
        return;
    L5:
        this.f6772g = r10;
        HashMap r11 = new HashMap();
        HashMap r12 = new HashMap();
        f.d(Process.myPid(), r11);
        Thread.sleep(100);     // Catch: InterruptedException -> L13
        f.d(Process.myPid(), r12);
        IAssistStat.b r13 = this.f6774i.getCpuFactorTag();     // Catch: Exception -> L10
    L11:
        i(0, r11, r12, r13);
        return;
    L10:
        r13 = null;
    L13:
        e = move-exception;
        s3.a.c("APM-CPU", "InterruptedException", e);
    }

    public final void i(long r10, Map r12, Map r13, IAssistStat.b r14) {
        if (r12.isEmpty() == false) goto L5;
        return;
    L5:
        if (r13.isEmpty() == true) goto L62;
        LinkedList r11 = new LinkedList();
        LinkedList r15 = new LinkedList();
        Iterator r16 = r12.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L29;
        Map.Entry r17 = (Map.Entry) r16.next();
        g r18 = (g) r17.getValue();
        if (r18 == null) goto L9;
        g r19 = (g) r13.get(r17.getKey());
        if (r19 == null) goto L9;
        if (r19.g().equals(r18.g()) == false) goto L9;
        long r20 = r19.e() - r18.e();
        if (r20 == 0) goto L9;
        s3.a.a("APM-CPU", "cpu_thread=" + r19.g() + " thread_time=" + r20 + " app_time=" + r10);
        if (r10 == 0) goto L24;
        double r21 = r20 / r10;
        if (r21 <= 9.0E-4d) goto L9;
        r11.add(new m(r19.g(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r21)}))));
        r15.add(new ICpuDataService.a(r19.g(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r21)})).doubleValue(), r19.f()));
        goto L9
    L24:
        double r22 = r20;
        r11.add(new m(r19.g(), Double.valueOf(r22)));
        r15.add(new ICpuDataService.a(r19.g(), r22, r19.f()));
        goto L9
    L29:
        if (r11.isEmpty() == false) goto L31;
        return;
    L31:
        Collections.sort(r15, new C0083b(this));
        x2.a.a().d(r15);
        if (this.f6773h.g() == true) goto L34;
        return;
    L34:
        if (t2.a.e().g() == false) goto L36;
        CpuCacheItem.CpuDataType r110 = CpuCacheItem.CpuDataType.FRONT;
    L37:
        c r111 = new c(r110, m3.c.a().getSceneString(), r11, r14);
        r111.g(ff.b.b(w0.c.g()));
        r111.h(this.f6774i.isCpuSampleEnvironment());     // Catch: Throwable -> L41
    L39:
        l3.a.d(r111);
        return;
    L36:
        r110 = CpuCacheItem.CpuDataType.BACK;
        goto L37
    }

    public final void j() {
        if (this.f6768c != null) goto L6;
        this.f6768c = new a(this, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
        return;
    }

    public final void k(boolean r10) {
        u2.a r11 = this.f6773h;
        if (r10 == false) goto L5;
        long r12 = r11.c();
    L6:
        this.f6769d = r12;
        if (r10 == false) goto L9;
        long r13 = this.f6773h.d();
    L10:
        this.f6770e = r13;
        return;
    L9:
        r13 = this.f6773h.b();
        goto L10
    L5:
        r12 = r11.a();
        goto L6
    }

    public void l() {
        if (this.f6767b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        j();
        if (this.f6768c == null) goto L11;
        u3.b.a(AsyncTaskManagerType.CPU).c(this.f6768c);
    L11:
        this.f6774i.start();     // Catch: Throwable -> L10
        return;
    }

    public void m(u2.a r10) {
        if (this.f6767b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f6773h = r10;
        j();
        if (this.f6768c == null) goto L11;
        u3.b.a(AsyncTaskManagerType.CPU).c(this.f6768c);
    L11:
        this.f6774i.start();     // Catch: Throwable -> L10
        return;
    }

    public void n() {
        if (this.f6767b.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        if (this.f6768c == null) goto L14;
        u3.b.a(AsyncTaskManagerType.CPU).b(this.f6768c);
        this.f6774i.end();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    }
}
