package Z7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: Z7.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1138j {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f7542b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public static C1138j f7543c;

    /* renamed from: a, reason: collision with root package name */
    public ScheduledExecutorService f7544a;

    /* renamed from: Z7.j$a */
    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BuglyThread-" + C1138j.f7542b.getAndIncrement());
            return thread;
        }
    }

    public C1138j() {
        this.f7544a = null;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(3, new a());
        this.f7544a = scheduledExecutorServiceNewScheduledThreadPool;
        if (scheduledExecutorServiceNewScheduledThreadPool == null || scheduledExecutorServiceNewScheduledThreadPool.isShutdown()) {
            C1139k.i("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized C1138j a() {
        try {
            if (f7543c == null) {
                f7543c = new C1138j();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7543c;
    }

    public final synchronized boolean b(Runnable runnable) {
        if (!d()) {
            C1139k.i("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            C1139k.i("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        C1139k.h("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f7544a.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (O.f7341c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean c(Runnable runnable, long j10) {
        if (!d()) {
            C1139k.i("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j10 <= 0) {
            j10 = 0;
        }
        C1139k.h("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j10), runnable.getClass().getName());
        try {
            this.f7544a.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (O.f7341c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean d() {
        ScheduledExecutorService scheduledExecutorService = this.f7544a;
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                return true;
            }
        }
        return false;
    }
}
