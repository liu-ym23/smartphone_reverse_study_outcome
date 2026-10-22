package l;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: l.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0745c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13416a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13417b;

    public ThreadFactoryC0745c(int i4) {
        this.f13416a = 1;
        this.f13417b = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i4 = this.f13416a;
        Object obj = this.f13417b;
        switch (i4) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + ((AtomicInteger) obj).getAndIncrement());
                return thread;
            case 1:
                AtomicInteger atomicInteger = (AtomicInteger) obj;
                if (atomicInteger.get() == Integer.MAX_VALUE) {
                    atomicInteger.set(0);
                }
                return new Thread(runnable, "ScheduleTask#" + atomicInteger.getAndIncrement());
            default:
                Thread threadNewThread = ((ThreadFactory) obj).newThread(runnable);
                threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
                return threadNewThread;
        }
    }

    public ThreadFactoryC0745c() {
        this.f13416a = 0;
        this.f13417b = new AtomicInteger(0);
    }

    public ThreadFactoryC0745c(ThreadFactory threadFactory) {
        this.f13416a = 2;
        this.f13417b = threadFactory;
    }
}
