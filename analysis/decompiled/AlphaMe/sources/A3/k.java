package A3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class k implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final ScheduledExecutorService[] f105b = new ScheduledExecutorService[0];

    /* renamed from: c, reason: collision with root package name */
    public static final ScheduledExecutorService f106c;

    /* renamed from: d, reason: collision with root package name */
    public static final k f107d;

    /* renamed from: e, reason: collision with root package name */
    public static int f108e;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f109a;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f106c = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f107d = new k();
    }

    public k() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f105b;
        this.f109a = new AtomicReference(scheduledExecutorServiceArr);
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        iAvailableProcessors = iAvailableProcessors > 4 ? iAvailableProcessors / 2 : iAvailableProcessors;
        iAvailableProcessors = iAvailableProcessors > 8 ? 8 : iAvailableProcessors;
        ScheduledExecutorService[] scheduledExecutorServiceArr2 = new ScheduledExecutorService[iAvailableProcessors];
        int i4 = 0;
        for (int i5 = 0; i5 < iAvailableProcessors; i5++) {
            scheduledExecutorServiceArr2[i5] = Executors.newScheduledThreadPool(1, l.f110a);
        }
        if (!this.f109a.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2)) {
            while (i4 < iAvailableProcessors) {
                scheduledExecutorServiceArr2[i4].shutdownNow();
                i4++;
            }
        } else {
            while (i4 < iAvailableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr2[i4];
                if (!m.h(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    m.f((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i4++;
            }
        }
    }

    public static ScheduledExecutorService b() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = (ScheduledExecutorService[]) f107d.f109a.get();
        if (scheduledExecutorServiceArr == f105b) {
            return f106c;
        }
        int i4 = f108e + 1;
        if (i4 >= scheduledExecutorServiceArr.length) {
            i4 = 0;
        }
        f108e = i4;
        return scheduledExecutorServiceArr[i4];
    }

    @Override // A3.q
    public final void a() {
        AtomicReference atomicReference;
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            atomicReference = this.f109a;
            scheduledExecutorServiceArr = (ScheduledExecutorService[]) atomicReference.get();
            scheduledExecutorServiceArr2 = f105b;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!atomicReference.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            m.f114e.remove(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }
}
