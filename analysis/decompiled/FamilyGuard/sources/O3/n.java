package O3;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f4422a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f4423b;

    /* renamed from: c, reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f4424c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f4425d = new ConcurrentHashMap();

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f4426a;

        /* renamed from: b, reason: collision with root package name */
        int f4427b;

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f4426a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f4426a = true;
            }
            if (!this.f4426a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f4427b = 1;
                return;
            }
            try {
                this.f4427b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f4427b = 1;
            }
        }
    }

    static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList(n.f4425d.keySet());
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) obj;
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    n.f4425d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f4422a = aVar.f4426a;
        f4423b = aVar.f4427b;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        c(f4422a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void b() {
        d(f4422a);
    }

    static void c(boolean z5, ScheduledExecutorService scheduledExecutorService) {
        if (z5 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f4425d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void d(boolean z5) {
        if (!z5) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f4424c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new j("RxSchedulerPurge"));
            if (atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                b bVar = new b();
                int i5 = f4423b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(bVar, i5, i5, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
