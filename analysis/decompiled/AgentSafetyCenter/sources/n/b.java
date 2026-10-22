package n;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8612c;

    /* renamed from: f, reason: collision with root package name */
    public AtomicInteger f8613f;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f8612c) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + this.f8613f.getAndIncrement());
                return thread;
            default:
                AtomicInteger atomicInteger = this.f8613f;
                if (atomicInteger.get() == Integer.MAX_VALUE) {
                    atomicInteger.set(0);
                }
                return new Thread(runnable, "ScheduleTask#" + atomicInteger.getAndIncrement());
        }
    }
}
