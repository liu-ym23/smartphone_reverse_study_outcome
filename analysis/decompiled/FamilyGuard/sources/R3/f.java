package R3;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class f {
    public static void a(Q4.b<?> bVar, AtomicInteger atomicInteger, b bVar2) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thB = bVar2.b();
            if (thB != null) {
                bVar.onError(thB);
            } else {
                bVar.a();
            }
        }
    }

    public static void b(Q4.b<?> bVar, Throwable th, AtomicInteger atomicInteger, b bVar2) {
        if (!bVar2.a(th)) {
            S3.a.r(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(bVar2.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void c(Q4.b<? super T> bVar, T t5, AtomicInteger atomicInteger, b bVar2) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.d(t5);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thB = bVar2.b();
                if (thB != null) {
                    bVar.onError(thB);
                } else {
                    bVar.a();
                }
            }
        }
    }
}
