package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(Subscriber<? super T> r2, T r3, AtomicInteger r4, AtomicThrowable r5) {
        if (r4.get() == 0) goto L5;
        return;
    L5:
        if (r4.compareAndSet(0, 1) == false) goto L14;
        r2.onNext(r3);
        if (r4.decrementAndGet() == 0) goto L15;
        Throwable r6 = r5.terminate();
        if (r6 == null) goto L11;
        r2.onError(r6);
        return;
    L11:
        r2.onComplete();
        return;
    L15:
        return;
    }

    public static void onError(Subscriber<?> r1, Throwable r2, AtomicInteger r3, AtomicThrowable r4) {
        if (r4.addThrowable(r2) == true) goto L5;
        RxJavaPlugins.onError(r2);
        return;
    L5:
        if (r3.getAndIncrement() != 0) goto L9;
        r1.onError(r4.terminate());
        return;
    }

    public static void onComplete(Subscriber<?> r0, AtomicInteger r1, AtomicThrowable r2) {
        if (r1.getAndIncrement() != 0) goto L9;
        Throwable r3 = r2.terminate();
        if (r3 == null) goto L7;
        r0.onError(r3);
        return;
    L7:
        r0.onComplete();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(Observer<? super T> r2, T r3, AtomicInteger r4, AtomicThrowable r5) {
        if (r4.get() == 0) goto L5;
        return;
    L5:
        if (r4.compareAndSet(0, 1) == false) goto L14;
        r2.onNext(r3);
        if (r4.decrementAndGet() == 0) goto L15;
        Throwable r6 = r5.terminate();
        if (r6 == null) goto L11;
        r2.onError(r6);
        return;
    L11:
        r2.onComplete();
        return;
    L15:
        return;
    }

    public static void onError(Observer<?> r1, Throwable r2, AtomicInteger r3, AtomicThrowable r4) {
        if (r4.addThrowable(r2) == true) goto L5;
        RxJavaPlugins.onError(r2);
        return;
    L5:
        if (r3.getAndIncrement() != 0) goto L9;
        r1.onError(r4.terminate());
        return;
    }

    public static void onComplete(Observer<?> r0, AtomicInteger r1, AtomicThrowable r2) {
        if (r1.getAndIncrement() != 0) goto L9;
        Throwable r3 = r2.terminate();
        if (r3 == null) goto L7;
        r0.onError(r3);
        return;
    L7:
        r0.onComplete();
        return;
    }
}
