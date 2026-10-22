package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2434867452883857743L;
    volatile boolean cancelled;
    final Object[] current;
    final boolean delayErrors;
    final Subscriber<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    final Function<? super Object[], ? extends R> zipper;

    public FlowableZip$ZipCoordinator(Subscriber<? super R> r10, Function<? super Object[], ? extends R> r11, int r12, int r13, boolean r14) {
        this.downstream = r10;
        this.zipper = r11;
        this.delayErrors = r14;
        FlowableZip$ZipSubscriber<T, R>[] r15 = new FlowableZip$ZipSubscriber[r12];
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L5;
        r15[r16] = new FlowableZip$ZipSubscriber(this, r13);
        r16 = r16 + 1;
        goto L3
    L5:
        this.current = new Object[r12];
        this.subscribers = r15;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        cancelAll();
        return;
    }

    public void cancelAll() {
        FlowableZip$ZipSubscriber<T, R>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super R> r10 = this.downstream;
        FlowableZip$ZipSubscriber<T, R>[] r11 = this.subscribers;
        int r12 = r11.length;
        Object[] r13 = this.current;
        int r14 = 1;
    L6:
        long r15 = this.requested.get();
        long r16 = 0;
    L8:
        if (r15 == r16) goto L54;
        if (this.cancelled == true) goto L11;
        if (this.delayErrors == false) goto L15;
    L18:
        boolean r17 = false;
        int r18 = 0;
    L19:
        if (r18 >= r12) goto L47;
        FlowableZip$ZipSubscriber<T, R> r19 = r11[r18];
        if (r13[r18] != null) goto L46;
        boolean r110 = r19.done;     // Catch: Throwable -> L25
        SimpleQueue<T> r111 = r19.queue;     // Catch: Throwable -> L25
        if (r111 == null) goto L27;
        T r112 = r111.poll();     // Catch: Throwable -> L25
    L28:
        if (r112 != null) goto L30;
        boolean r113 = true;
    L31:
        if (r110 == false) goto L38;
        if (r113 == false) goto L38;
        cancelAll();     // Catch: Throwable -> L25
        if (this.errors.get() == null) goto L36;
        r10.onError(this.errors.terminate());     // Catch: Throwable -> L25
        return;
    L36:
        r10.onComplete();     // Catch: Throwable -> L25
        return;
    L38:
        if (r113 == true) goto L45;
        r13[r18] = r112;     // Catch: Throwable -> L25
    L45:
        r17 = true;
        goto L46
    L30:
        r113 = false;
        goto L31
    L27:
        r112 = null;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        if (this.delayErrors == true) goto L45;
        cancelAll();
        r10.onError(this.errors.terminate());
        return;
    L46:
        r18 = r18 + 1;
        goto L19
    L47:
        if (r17 == true) goto L54;
        r10.onNext((Object) io.reactivex.internal.functions.a.b(this.zipper.apply(r13.clone()), "The zipper returned a null value"));
        r16 = r16 + 1;
        Arrays.fill(r13, null);
    L51:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAll();
        this.errors.addThrowable(th);
        r10.onError(this.errors.terminate());
        return;
    L15:
        if (this.errors.get() == null) goto L18;
        cancelAll();
        r10.onError(this.errors.terminate());
        return;
    L11:
        return;
    L54:
        if (r15 != r16) goto L93;
        if (this.cancelled == true) goto L57;
        if (this.delayErrors == false) goto L61;
    L64:
        int r20 = 0;
    L65:
        if (r20 >= r12) goto L93;
        FlowableZip$ZipSubscriber<T, R> r21 = r11[r20];
        if (r13[r20] != null) goto L91;
        boolean r114 = r21.done;     // Catch: Throwable -> L71
        SimpleQueue<T> r22 = r21.queue;     // Catch: Throwable -> L71
        if (r22 == null) goto L73;
        T r23 = r22.poll();     // Catch: Throwable -> L71
    L74:
        if (r23 != null) goto L76;
        boolean r115 = true;
    L77:
        if (r114 == false) goto L84;
        if (r115 == false) goto L84;
        cancelAll();     // Catch: Throwable -> L71
        if (this.errors.get() == null) goto L82;
        r10.onError(this.errors.terminate());     // Catch: Throwable -> L71
        return;
    L82:
        r10.onComplete();     // Catch: Throwable -> L71
        return;
    L84:
        if (r115 == true) goto L91;
        r13[r20] = r23;     // Catch: Throwable -> L71
        goto L91
    L76:
        r115 = false;
        goto L77
    L73:
        r23 = null;
    L71:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        if (this.delayErrors == true) goto L91;
        cancelAll();
        r10.onError(this.errors.terminate());
        return;
    L91:
        r20 = r20 + 1;
        goto L65
    L61:
        if (this.errors.get() == null) goto L64;
        cancelAll();
        r10.onError(this.errors.terminate());
        return;
    L57:
        return;
    L93:
        if (r16 == 0) goto L100;
        int r24 = r11.length;
        int r25 = 0;
    L95:
        if (r25 >= r24) goto L98;
        r11[r25].request(r16);
        r25 = r25 + 1;
        goto L95
    L98:
        if (r15 == Long.MAX_VALUE) goto L100;
        this.requested.addAndGet(-r16);
    L100:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L6;
    }

    public void error(FlowableZip$ZipSubscriber<T, R> r10, Throwable r11) {
        if (this.errors.addThrowable(r11) == false) goto L5;
        r10.done = true;
        drain();
        return;
    L5:
        qf.a.e(r11);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }

    public void subscribe(Publisher<? extends T>[] r10, int r11) {
        FlowableZip$ZipSubscriber<T, R>[] r12 = this.subscribers;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        if (this.cancelled == true) goto L18;
        if (this.delayErrors == true) goto L11;
        if (this.errors.get() == null) goto L11;
        return;
    L11:
        r10[r13].subscribe(r12[r13]);
        r13 = r13 + 1;
        goto L3
    L18:
        return;
    }
}
