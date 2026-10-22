package g5;

import android.util.Pair;
import com.bytedance.monitor.collector.AbsMonitor;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.MonitorType;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;

/* JADX INFO: loaded from: classes.dex */
public class e extends AbsMonitor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TaskRunnable f19938i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f19939a;

        public a(e r10) {
            this.f19939a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19939a.g();
        }
    }

    public e(int r10) {
        super(r10, MonitorType.PROC_MONITOR);
        this.f19935f = 200;
        this.f19936g = 1000;
        this.f19937h = true;
        this.f19938i = k5.a.d("collect-proc", new a(this));
    }

    public static long h(int r10) {
    L9:
        return -1;
    L4:
        if (PerfMonitorManager.f7820t == true) goto L6;
        return -1;
    L6:
        return MonitorJni.doGetCpuTime(r10) * g.a();
    }

    public static void i() {
        if (PerfMonitorManager.f7820t == true) goto L5;
        return;
    L5:
        MonitorJni.doInit();     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public synchronized Pair a() {
        monitor-enter(this);
        if (PerfMonitorManager.f7820t == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair r10 = new Pair(this.f7705a, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public synchronized Pair b(long r10, long r11) {
        monitor-enter(this);
        if (PerfMonitorManager.f7820t == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair r12 = new Pair(this.f7705a, MonitorJni.getProcInfoTimeRange(r10, r11));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void d() {
        super.d();
        if (PerfMonitorManager.f7820t == true) goto L6;
        return;
    L6:
        if (this.f7707c == 0) goto L20;
        boolean r10 = this.f19937h;     // Catch: Throwable -> L16
        if (r10 == false) goto L11;
        this.f19936g = 5000;     // Catch: Throwable -> L16
    L12:
        MonitorJni.keepProcHyperOpen(r10);     // Catch: Throwable -> L16
        MonitorJni.doStart();     // Catch: Throwable -> L16
        IAsyncTaskManager r11 = this.f7709e;     // Catch: Throwable -> L16
        if (r11 == null) goto L21;
        r11.scheduleWithFixedDelay(this.f19938i, 0, this.f19936g);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L11:
        this.f19936g = 1000;     // Catch: Throwable -> L16
        goto L12
    L20:
        return;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void e() {
        super.e();
        if (PerfMonitorManager.f7820t == true) goto L6;
        return;
    L6:
        IAsyncTaskManager r10 = this.f7709e;     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        r10.removeTask(this.f19938i);     // Catch: Throwable -> L11
    L9:
        MonitorJni.doStop();     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void f(int r10) {
        if (PerfMonitorManager.f7820t == true) goto L5;
        return;
    L5:
        e();     // Catch: Throwable -> L18
        if (r10 != 0) goto L8;
        return;
    L8:
        if (r10 != 1) goto L10;
        this.f19935f = 200;     // Catch: Throwable -> L18
        this.f19936g = 1000;     // Catch: Throwable -> L18
        MonitorJni.setBufferSize(200);     // Catch: Throwable -> L18
    L16:
        d();     // Catch: Throwable -> L18
        return;
    L10:
        if (r10 != 2) goto L12;
    L14:
        this.f19935f = 400;     // Catch: Throwable -> L18
        this.f19936g = 1000;     // Catch: Throwable -> L18
        MonitorJni.setBufferSize(400);     // Catch: Throwable -> L18
        goto L16
    L12:
        if (r10 == 3) goto L14;
    }

    public synchronized void g() {
        monitor-enter(this);
        if (PerfMonitorManager.f7820t == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.doCollect();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }
}
