package ra;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f11760a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, new a(), new com.stepos.statsapp.v3.lib.plugin.emitter.remote.b(1));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f11761a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            AtomicInteger atomicInteger = this.f11761a;
            if (atomicInteger.get() == Integer.MAX_VALUE) {
                atomicInteger.set(0);
            }
            return new Thread(runnable, "ScheduleTask#" + atomicInteger.getAndIncrement());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ra.b$b, reason: collision with other inner class name */
    public static class C0134b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f11762a = new b();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f11760a.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }
}
