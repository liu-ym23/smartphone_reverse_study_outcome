package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
    private static final long serialVersionUID = -660395290758764731L;
    volatile boolean cancelled;
    long consumed;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    boolean outputFused;
    final MaybeMergeArray$SimpleQueueWithConsumerIndex<Object> queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a set;
    final int sourceCount;

    public MaybeMergeArray$MergeMaybeObserver(Subscriber<? super T> r10, int r11, MaybeMergeArray$SimpleQueueWithConsumerIndex<Object> r12) {
        this.downstream = r10;
        this.sourceCount = r11;
        this.set = new io.reactivex.disposables.a();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
        this.queue = r12;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.set.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.outputFused == false) goto L8;
        drainFused();
        return;
    L8:
        drainNormal();
    }

    public void drainFused() {
        Subscriber<? super T> r10 = this.downstream;
        MaybeMergeArray$SimpleQueueWithConsumerIndex<Object> r11 = this.queue;
        int r12 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        Throwable r13 = this.error.get();
        if (r13 != null) goto L9;
        if (r11.producerIndex() != this.sourceCount) goto L14;
        boolean r14 = true;
    L16:
        if (r11.isEmpty() == true) goto L18;
        r10.onNext(null);
    L18:
        if (r14 == true) goto L19;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L19:
        r10.onComplete();
        return;
    L14:
        r14 = false;
        goto L16
    L9:
        r11.clear();
        r10.onError(r13);
        return;
    L5:
        r11.clear();
    }

    public void drainNormal() {
        Subscriber<? super T> r10 = this.downstream;
        MaybeMergeArray$SimpleQueueWithConsumerIndex<Object> r11 = this.queue;
        long r12 = this.consumed;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
    L5:
        if (r12 == r14) goto L24;
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (r11.consumerIndex() == this.sourceCount) goto L16;
        Object r15 = r11.poll();
        if (r15 == null) goto L24;
        if (r15 == NotificationLite.COMPLETE) goto L5;
        r10.onNext(r15);
        r12 = r12 + 1;
        goto L5
    L16:
        r10.onComplete();
        return;
    L12:
        r11.clear();
        r10.onError(this.error.terminate());
        return;
    L8:
        r11.clear();
        return;
    L24:
        if (r12 == r14) goto L26;
    L36:
        this.consumed = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    L26:
        if (this.error.get() != null) goto L27;
    L30:
        if (r11.peek() != NotificationLite.COMPLETE) goto L33;
        r11.drop();
        goto L30
    L33:
        if (r11.consumerIndex() != this.sourceCount) goto L36;
        r10.onComplete();
        return;
    L27:
        r11.clear();
        r10.onError(this.error.terminate());
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        this.set.dispose();
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        this.set.add(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() throws Exception {
    L2:
        T r10 = (T) this.queue.poll();
        if (r10 == NotificationLite.COMPLETE) goto L2;
        return r10;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
