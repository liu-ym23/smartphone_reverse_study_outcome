package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelJoin$JoinSubscriptionDelayError<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = -5737965195918321883L;

    public ParallelJoin$JoinSubscriptionDelayError(Subscriber<? super T> r10, int r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    public void drainLoop() {
        ParallelJoin$JoinInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        Subscriber<? super T> r12 = this.downstream;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
        long r15 = 0;
    L5:
        if (r15 == r14) goto L34;
        if (this.cancelled == true) goto L8;
        if (this.done.get() != 0) goto L13;
        boolean r16 = true;
    L14:
        int r17 = 0;
        boolean r18 = true;
    L15:
        if (r17 >= r11) goto L25;
        ParallelJoin$JoinInnerSubscriber<T> r19 = r10[r17];
        SimplePlainQueue<T> r110 = r19.queue;
        if (r110 == null) goto L24;
        T r111 = r110.poll();
        if (r111 == null) goto L24;
        r12.onNext(r111);
        r19.requestOne();
        r15 = r15 + 1;
        if (r15 == r14) goto L34;
        r18 = false;
    L24:
        r17 = r17 + 1;
        goto L15
    L25:
        if (r16 == false) goto L32;
        if (r18 == false) goto L32;
        if (this.errors.get() == null) goto L30;
        r12.onError(this.errors.terminate());
        return;
    L30:
        r12.onComplete();
        return;
    L32:
        if (r18 == false) goto L5;
    L13:
        r16 = false;
        goto L14
    L8:
        cleanup();
        return;
    L34:
        if (r15 != r14) goto L60;
        if (this.cancelled == true) goto L37;
        if (this.done.get() != 0) goto L42;
        boolean r20 = true;
    L43:
        int r112 = 0;
    L44:
        if (r112 >= r11) goto L51;
        SimplePlainQueue<T> r113 = r10[r112].queue;
        if (r113 == null) goto L50;
        if (r113.isEmpty() == true) goto L50;
        boolean r114 = false;
    L52:
        if (r20 == false) goto L60;
        if (r114 == false) goto L60;
        if (this.errors.get() == null) goto L57;
        r12.onError(this.errors.terminate());
        return;
    L57:
        r12.onComplete();
        return;
    L50:
        r112 = r112 + 1;
        goto L44
    L51:
        r114 = true;
        goto L52
    L42:
        r20 = false;
        goto L43
    L37:
        cleanup();
        return;
    L60:
        if (r15 != 0) goto L62;
    L64:
        int r21 = get();
        if (r21 != r13) goto L69;
        r21 = addAndGet(-r13);
        if (r21 != 0) goto L69;
        return;
    L69:
        r13 = r21;
        goto L3
    L62:
        if (r14 == Long.MAX_VALUE) goto L64;
        this.requested.addAndGet(-r15);
        goto L64
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onError(Throwable r10) {
        this.errors.addThrowable(r10);
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onNext(ParallelJoin$JoinInnerSubscriber<T> r10, T r11) {
        if (get() != 0) goto L20;
        if (compareAndSet(0, 1) == false) goto L20;
        if (this.requested.get() == 0) goto L13;
        this.downstream.onNext(r11);
        if (this.requested.get() == Long.MAX_VALUE) goto L11;
        this.requested.decrementAndGet();
    L11:
        r10.request(1);
    L17:
        if (decrementAndGet() != 0) goto L27;
        return;
    L27:
        drainLoop();
        return;
    L13:
        if (r10.getQueue().offer(r11) == true) goto L17;
        r10.cancel();
        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
        this.done.decrementAndGet();
        drainLoop();
        return;
    L20:
        if (r10.getQueue().offer(r11) == true) goto L25;
        if (r10.cancel() == false) goto L25;
        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
        this.done.decrementAndGet();
    L25:
        if (getAndIncrement() == 0) goto L27;
    }
}
