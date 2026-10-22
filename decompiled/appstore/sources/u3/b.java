package u3;

import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import r3.i;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map f24842d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f24843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f24844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f24845c;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: u3.b$b, reason: collision with other inner class name */
    public class RunnableC0386b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u3.a f24846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f24847b;

        public /* synthetic */ RunnableC0386b(b r10, u3.a r11, a r12) {
            this(r10, r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            i.a("APM-Task");
            this.f24846a.run();     // Catch: Throwable -> L5
        L7:
            i.b();
            return;
        L5:
            th = move-exception;
            s3.a.c("APM-AsyncTask", "thread " + Thread.currentThread().getName() + " exception", th);
            goto L7
        }

        public RunnableC0386b(b r10, u3.a r11) {
            this.f24847b = r10;
            this.f24846a = r11;
        }
    }

    static {
        f24842d = new HashMap();
    }

    public b(String r10) {
        this.f24844b = new ConcurrentHashMap();
        this.f24845c = new ConcurrentHashMap();
        this.f24843a = new ScheduledThreadPoolExecutor(1, new c(r10));
    }

    public static synchronized b a(AsyncTaskManagerType r10) {
        monitor-enter(b.class);
        if (r10 == null) goto L14;
        b r11 = (b) f24842d.get(r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        r11 = new b(r10.name());     // Catch: Throwable -> L9
        f24842d.put(r10, r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);
        return r11;
    L14:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void b(u3.a r10) {
        Runnable r11 = (Runnable) this.f24845c.remove(r10);     // Catch: Throwable -> L5
        if (r11 == null) goto L7;
        this.f24843a.remove(r11);     // Catch: Throwable -> L5
    L7:
        ScheduledFuture r12 = (ScheduledFuture) this.f24844b.remove(r10);     // Catch: Throwable -> L5
        if (r12 == null) goto L15;
        r12.cancel(true);     // Catch: Throwable -> L5
        return;
    L15:
        return;
    L5:
        th = move-exception;
        s3.a.c("APM-AsyncTask", "removeTask failed", th);
    }

    public void c(u3.a r10) {
        if (r10 != null) goto L14;
        return;
    L14:
        RunnableC0386b r11 = new RunnableC0386b(this, r10, null);     // Catch: Throwable -> L7
        if (r10.c() == false) goto L9;
        ScheduledFuture<?> r12 = this.f24843a.scheduleWithFixedDelay(r11, r10.a(), r10.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
    L10:
        this.f24845c.put(r10, r11);     // Catch: Throwable -> L7
        this.f24844b.put(r10, r12);     // Catch: Throwable -> L7
        return;
    L9:
        r12 = this.f24843a.schedule(r11, r10.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        s3.a.c("APM-AsyncTask", "sendTask failed.", th);
    }
}
