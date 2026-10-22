package A3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class m extends t3.e {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f112c;

    /* renamed from: g, reason: collision with root package name */
    public static volatile Object f116g;

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f118a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f119b;

    /* renamed from: h, reason: collision with root package name */
    public static final Object f117h = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f114e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReference f115f = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final int f113d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z4 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int i4 = B3.d.f223a;
        f112c = !z4 && (i4 == 0 || i4 >= 21);
    }

    public m(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!h(scheduledExecutorServiceNewScheduledThreadPool) && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.f118a = scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static Method e(ScheduledExecutorService scheduledExecutorService) throws SecurityException {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public static void f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference atomicReference = f115f;
            if (((ScheduledExecutorService) atomicReference.get()) != null) {
                break;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new B3.h("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, scheduledExecutorServiceNewScheduledThreadPool)) {
                X.n nVar = new X.n(2);
                int i4 = f113d;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(nVar, i4, i4, TimeUnit.MILLISECONDS);
                break;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
        f114e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean h(ScheduledExecutorService scheduledExecutorService) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method methodE;
        if (f112c) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f116g;
                Object obj2 = f117h;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    methodE = e(scheduledExecutorService);
                    if (methodE != null) {
                        obj2 = methodE;
                    }
                    f116g = obj2;
                } else {
                    methodE = (Method) obj;
                }
            } else {
                methodE = e(scheduledExecutorService);
            }
            if (methodE != null) {
                try {
                    methodE.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e4) {
                    E3.c.a(e4);
                } catch (IllegalArgumentException e5) {
                    E3.c.a(e5);
                } catch (InvocationTargetException e6) {
                    E3.c.a(e6);
                }
            }
        }
        return false;
    }

    @Override // t3.h
    public final boolean a() {
        return this.f119b;
    }

    @Override // t3.e
    public final t3.h b(x3.a aVar) {
        return d(aVar, 0L, null);
    }

    @Override // t3.h
    public final void c() {
        this.f119b = true;
        this.f118a.shutdownNow();
        f114e.remove(this.f118a);
    }

    @Override // t3.e
    public final t3.h d(x3.a aVar, long j4, TimeUnit timeUnit) {
        return this.f119b ? G3.f.f653a : g(aVar, j4, timeUnit);
    }

    public final p g(x3.a aVar, long j4, TimeUnit timeUnit) {
        p pVar = new p(E3.c.d(aVar));
        ScheduledExecutorService scheduledExecutorService = this.f118a;
        pVar.b(j4 <= 0 ? scheduledExecutorService.submit(pVar) : scheduledExecutorService.schedule(pVar, j4, timeUnit));
        return pVar;
    }
}
