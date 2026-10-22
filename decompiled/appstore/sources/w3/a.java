package w3;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f25326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f25327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExecutorService f25328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ScheduledExecutorService f25329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ExecutorService f25330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ExecutorService f25331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25332g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25333h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25334i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25335j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25336k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25337l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f25338m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f25339n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f25340o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f25341p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c f25342q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f25343r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final BlockingQueue f25344s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final BlockingQueue f25345t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final BlockingQueue f25346u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final RejectedExecutionHandler f25347v = null;

    /* JADX INFO: renamed from: w3.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC0400a implements RejectedExecutionHandler {
        public RejectedExecutionHandlerC0400a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor r11) {
            Executors.newCachedThreadPool().execute(r10);
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f25348d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f25349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f25350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25351c;

        /* JADX INFO: renamed from: w3.a$b$a, reason: collision with other inner class name */
        public class C0401a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f25352a;

            public C0401a(b r10, ThreadGroup r11, Runnable r12, String r13, long r14) {
                this.f25352a = r10;
                super(r11, r12, r13, r14);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        static {
            f25348d = new AtomicInteger(1);
        }

        public b(String r10) {
            this.f25350b = new AtomicInteger(1);
            SecurityManager r11 = System.getSecurityManager();
            if (r11 == null) goto L5;
            ThreadGroup r12 = r11.getThreadGroup();
        L6:
            this.f25349a = r12;
            this.f25351c = r10 + "-" + f25348d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r12 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            C0401a r11 = new C0401a(this, this.f25349a, r10, this.f25351c + this.f25350b.getAndIncrement(), 0);
            if (r11.isDaemon() == false) goto L5;
            r11.setDaemon(false);
        L5:
            return r11;
        }
    }

    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f25353d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f25354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f25355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25356c;

        static {
            f25353d = new AtomicInteger(1);
        }

        public c(String r10) {
            this.f25355b = new AtomicInteger(1);
            SecurityManager r11 = System.getSecurityManager();
            if (r11 == null) goto L5;
            ThreadGroup r12 = r11.getThreadGroup();
        L6:
            this.f25354a = r12;
            this.f25356c = r10 + "-" + f25353d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r12 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(this.f25354a, r10, this.f25356c + this.f25355b.getAndIncrement(), 0);
            if (r11.isDaemon() == false) goto L6;
            r11.setDaemon(false);
        L6:
            if (r11.getPriority() == 5) goto L8;
            r11.setPriority(5);
        L8:
            return r11;
        }
    }

    static {
        int r10 = Runtime.getRuntime().availableProcessors();
        f25332g = r10;
        if (r10 > 0) goto L6;
        r10 = 1;
    L6:
        f25333h = r10;
        int r11 = Math.max(2, Math.min(r10 - 1, 6));
        int r12 = r11 * 2;
        f25334i = r12;
        int r13 = (r11 * 4) + 1;
        f25335j = r13;
        int r15 = Math.max(2, Math.min(r10 - 1, 3));
        f25336k = r15;
        int r16 = (r10 * 2) + 1;
        f25337l = r16;
        c r14 = new c("TTDefaultExecutors");
        f25338m = r14;
        c r17 = new c("TTCpuExecutors");
        f25339n = r17;
        c r18 = new c("TTScheduledExecutors");
        f25340o = r18;
        c r19 = new c("TTDownLoadExecutors");
        f25341p = r19;
        c r110 = new c("TTSerialExecutors");
        f25342q = r110;
        b r111 = new b("TTBackgroundExecutors");
        f25343r = r111;
        LinkedBlockingQueue r112 = new LinkedBlockingQueue();
        f25344s = r112;
        LinkedBlockingQueue r20 = new LinkedBlockingQueue();
        f25345t = r20;
        LinkedBlockingQueue r23 = new LinkedBlockingQueue();
        f25346u = r23;
        RejectedExecutionHandlerC0400a r25 = new RejectedExecutionHandlerC0400a();
        f25347v = r25;
        TimeUnit r26 = TimeUnit.SECONDS;
        w3.b r21 = new w3.b(r12, r13, 30, r26, r112, r14, r25);
        f25326a = r21;
        r21.allowCoreThreadTimeOut(true);
        w3.b r22 = new w3.b(r15, r16, 30, r26, r20, r17, r25);
        f25327b = r22;
        r22.allowCoreThreadTimeOut(true);
        f25329d = Executors.newScheduledThreadPool(3, r18);
        w3.b r24 = new w3.b(2, 2, 30, r26, r23, r19, r25);
        f25328c = r24;
        r24.allowCoreThreadTimeOut(true);
        w3.b r27 = new w3.b(1, 1, 30, r26, new LinkedBlockingQueue(), r110);
        f25330e = r27;
        r27.allowCoreThreadTimeOut(true);
        w3.b r28 = new w3.b(0, 3, 30, r26, new LinkedBlockingQueue(), r111);
        f25331f = r28;
        r28.allowCoreThreadTimeOut(true);
    }

    public static ExecutorService a() {
        return f25326a;
    }

    public static ScheduledExecutorService b() {
        return f25329d;
    }
}
