package b27;

import android.util.Pair;
import com.bytedance.monitor.collector.AbsMonitor;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.MonitorType;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends AbsMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f27.e f17063g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f17064a;

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f17064a;     // Catch: Throwable -> L11
            monitor-enter(r100);     // Catch: Throwable -> L11
            if (com.bytedance.monitor.collector.c.f265641j == true) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L11
        L19:
            return;
        L8:
            MonitorJni.doCollect();     // Catch: Throwable -> L16
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public a(h r100) {
            this.f17064a = r100;
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final synchronized Pair<String, String> a() {
        monitor-enter(this);
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r100 = new Pair(this.f265559a, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final void c() {
        super.c();
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L6;
        return;
    L6:
        if (this.f265561c == 0) goto L29;
        boolean r100 = this.f17062f;     // Catch: Throwable -> L23
        if (r100 == false) goto L11;
        this.f17061e = 5000;     // Catch: Throwable -> L23
    L12:
        MonitorJni.keepProcHyperOpen(r100);     // Catch: Throwable -> L23
        MonitorJni.doStart();     // Catch: Throwable -> L23
        f27.d r101 = this.f265562d;     // Catch: Throwable -> L23
        if (r101 == null) goto L30;
        f27.e r102 = this.f17063g;     // Catch: Throwable -> L23
        long r103 = this.f17061e;     // Catch: Throwable -> L23
        if (r102 == null) goto L31;
        g27.c r104 = r101.b(r102);     // Catch: Throwable -> L20
        r104.e(r102);     // Catch: Throwable -> L20
        r104.h(r104.scheduleWithFixedDelay(r102, 0, r103, TimeUnit.MILLISECONDS), r102.hashCode(), true);     // Catch: Throwable -> L20
        goto L33
    L32:
        return;
    L20:
        th = move-exception;
        r101.a(th, "Apm-Async-task-removeTask");     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L30:
        return;
    L11:
        this.f17061e = 1000;     // Catch: Throwable -> L23
        goto L12
    L29:
        return;
    }

    public h(int r100) {
        super(r100, MonitorType.PROC_MONITOR);
        this.f17061e = 1000;
        this.f17062f = true;
        a r101 = new a(this);
        this.f17063g = new f27.e("collect-proc", AsyncTaskType.LIGHT_WEIGHT, r101);
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final void d(int r100) {
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L5;
        return;
    L5:
        this.f265560b = 1;     // Catch: Throwable -> L27
        if (com.bytedance.monitor.collector.c.f265641j == false) goto L15;
        f27.d r101 = this.f265562d;     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        r101.j(this.f17063g);     // Catch: Throwable -> L14
    L12:
        MonitorJni.doStop();     // Catch: Throwable -> L14
    L15:
        if (r100 != 0) goto L17;
        return;
    L17:
        if (r100 != 1) goto L19;
        this.f17061e = 1000;     // Catch: Throwable -> L27
        MonitorJni.setBufferSize(200);     // Catch: Throwable -> L27
    L25:
        c();     // Catch: Throwable -> L27
        return;
    L19:
        if (r100 != 2) goto L21;
    L23:
        this.f17061e = 1000;     // Catch: Throwable -> L27
        MonitorJni.setBufferSize(400);     // Catch: Throwable -> L27
        goto L25
    L21:
        if (r100 == 3) goto L23;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final synchronized Pair<String, String> b(long r100, long r101) {
        monitor-enter(this);
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r102 = new Pair(this.f265559a, MonitorJni.getProcInfoTimeRange(r100, r101));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L12:
        return null;
    }
}
