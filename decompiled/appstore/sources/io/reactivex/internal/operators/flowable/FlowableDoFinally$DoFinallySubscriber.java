package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableDoFinally$DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    final Subscriber<? super T> downstream;
    final Action onFinally;
    QueueSubscription<T> qs;
    boolean syncFused;
    Subscription upstream;

    public FlowableDoFinally$DoFinallySubscriber(Subscriber<? super T> r10, Action r11) {
        this.downstream = r10;
        this.onFinally = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
        runFinally();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        if ((r10 instanceof QueueSubscription) == false) goto L7;
        this.qs = (QueueSubscription) r10;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() throws Exception {
        T r10 = this.qs.poll();
        if (r10 == null) goto L5;
    L7:
        return r10;
    L5:
        if (this.syncFused == false) goto L7;
        runFinally();
        goto L7
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        this.upstream.request(r10);
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        QueueSubscription<T> r11 = this.qs;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L13:
        return 0;
    L5:
        if ((r10 & 4) != 0) goto L13;
        int r13 = r11.requestFusion(r10);
        if (r13 != 0) goto L9;
    L12:
        return r13;
    L9:
        if (r13 != 1) goto L11;
        r12 = true;
    L11:
        this.syncFused = r12;
        goto L12
    }

    public void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }
}
