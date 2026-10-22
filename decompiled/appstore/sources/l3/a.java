package l3;

import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableHandler;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;
import r3.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f21815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f21816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BlockingQueue f21817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f21818d;

    /* JADX INFO: renamed from: l3.a$a, reason: collision with other inner class name */
    public static class RunnableC0300a implements Runnable {
        public RunnableC0300a() {
        }

        /* JADX INFO: Infinite loop detected, blocks: 60, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
        L2:
            i.a("APM-Consumers");
            Monitorable r10 = (Monitorable) a.a().take();     // Catch: Throwable -> L18
            Iterator r11 = a.b().iterator();     // Catch: Throwable -> L18
            boolean r12 = false;
        L6:
            if (r11.hasNext() == false) goto L20;
            MonitorableInterceptor r13 = (MonitorableInterceptor) r11.next();     // Catch: Throwable -> L18
        L14:
            th = move-exception;
            if (r3.a.c() == false) goto L6;
            s3.a.c("APM-Monitor", "interceptor throws a Throwable", th);     // Catch: Throwable -> L18
            goto L6
        L9:
            if (r13.shouldIntercept(r10) == false) goto L6;
            r12 = true;
            if (r3.a.c() == false) goto L20;
            s3.a.f("APM-Monitor", "monitorable intercepted by " + r13.getClass() + " content: " + r10);     // Catch: Throwable -> L14
        L20:
            if (r12 == true) goto L2;
            Iterator r14 = a.c().iterator();     // Catch: Throwable -> L18
        L24:
            if (r14.hasNext() == false) goto L39;
            MonitorableHandler r15 = (MonitorableHandler) r14.next();     // Catch: Throwable -> L18
            i.a("APM-Handler");     // Catch: Throwable -> L18
            if (r10.isValid() == false) goto L32;
            r15.handle(r10);     // Catch: Throwable -> L29
        L36:
            i.b();     // Catch: Throwable -> L18
            goto L24
        L32:
            if (r3.a.c() == false) goto L36;
            s3.a.f("APM-Monitor", "monitorable invalid. ignored. " + r10);     // Catch: Throwable -> L29
            goto L36
        L29:
            th = move-exception;
            s3.a.c("APM-Monitor", "monitorableHandler " + r15 + " handle monitorable " + r10 + "failed.", th);     // Catch: Throwable -> L18
        L39:
            i.b();
        L18:
            th = move-exception;
            s3.a.c("APM", "record error", th);
            goto L39
        }
    }

    static {
        f21815a = new CopyOnWriteArrayList();
        f21816b = new CopyOnWriteArrayList();
        f21817c = new LinkedTransferQueue();
        f21818d = false;
    }

    public static /* synthetic */ BlockingQueue a() {
        return f21817c;
    }

    public static /* synthetic */ List b() {
        return f21816b;
    }

    public static /* synthetic */ List c() {
        return f21815a;
    }

    public static void d(Monitorable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f21817c.offer(r10);
        if (f21818d == true) goto L8;
        g();
        return;
    }

    public static void e(MonitorableHandler r10) {
        if (f21815a.contains(r10) == true) goto L6;
        f21815a.add(r10);
        return;
    }

    public static void f(MonitorableInterceptor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (f21816b.contains(r10) == true) goto L8;
        f21816b.add(r10);
        return;
    }

    public static synchronized void g() {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f21818d == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f21818d = true;     // Catch: Throwable -> L12
        new Thread(new RunnableC0300a(), "APM-Monitor").start();     // Catch: Throwable -> L12
        monitor-exit(a.class);
    }
}
