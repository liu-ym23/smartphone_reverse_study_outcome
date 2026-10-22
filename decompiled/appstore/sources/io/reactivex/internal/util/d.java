package io.reactivex.internal.util;

import io.reactivex.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static void a(Observer r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r11.getAndIncrement() != 0) goto L9;
        Throwable r13 = r12.terminate();
        if (r13 == null) goto L7;
        r10.onError(r13);
        return;
    L7:
        r10.onComplete();
        return;
    }

    public static void b(Subscriber r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r11.getAndIncrement() != 0) goto L9;
        Throwable r13 = r12.terminate();
        if (r13 == null) goto L7;
        r10.onError(r13);
        return;
    L7:
        r10.onComplete();
        return;
    }

    public static void c(Observer r10, Throwable r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r13.addThrowable(r11) == true) goto L5;
        qf.a.e(r11);
        return;
    L5:
        if (r12.getAndIncrement() != 0) goto L9;
        r10.onError(r13.terminate());
        return;
    }

    public static void d(Subscriber r10, Throwable r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r13.addThrowable(r11) == true) goto L5;
        qf.a.e(r11);
        return;
    L5:
        if (r12.getAndIncrement() != 0) goto L9;
        r10.onError(r13.terminate());
        return;
    }

    public static void e(Observer r10, Object r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r12.get() == 0) goto L5;
        return;
    L5:
        if (r12.compareAndSet(0, 1) == false) goto L14;
        r10.onNext(r11);
        if (r12.decrementAndGet() == 0) goto L15;
        Throwable r14 = r13.terminate();
        if (r14 == null) goto L11;
        r10.onError(r14);
        return;
    L11:
        r10.onComplete();
        return;
    L15:
        return;
    }

    public static void f(Subscriber r10, Object r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r12.get() == 0) goto L5;
        return;
    L5:
        if (r12.compareAndSet(0, 1) == false) goto L14;
        r10.onNext(r11);
        if (r12.decrementAndGet() == 0) goto L15;
        Throwable r14 = r13.terminate();
        if (r14 == null) goto L11;
        r10.onError(r14);
        return;
    L11:
        r10.onComplete();
        return;
    L15:
        return;
    }
}
