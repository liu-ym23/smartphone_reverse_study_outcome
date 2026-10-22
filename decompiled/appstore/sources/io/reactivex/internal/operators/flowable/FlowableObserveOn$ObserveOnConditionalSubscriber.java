package io.reactivex.internal.operators.flowable;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableObserveOn$ObserveOnConditionalSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    private static final long serialVersionUID = 644624475404284533L;
    long consumed;
    final ConditionalSubscriber<? super T> downstream;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> r10, mf.f.a r11, boolean r12, int r13) {
        super(r11, r12, r13);
        this.downstream = r10;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = 1;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = 2;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() throws Exception {
        T r10 = this.queue.poll();
        if (r10 != null) goto L5;
    L10:
        return r10;
    L5:
        if (this.sourceMode == 1) goto L10;
        long r11 = this.consumed + 1;
        if (r11 != this.limit) goto L9;
        this.consumed = 0;
        this.upstream.request(r11);
        goto L10
    L9:
        this.consumed = r11;
        goto L10
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        ConditionalSubscriber<? super T> r10 = this.downstream;
        SimpleQueue<T> r11 = this.queue;
        long r12 = this.produced;
        long r13 = this.consumed;
        int r14 = 1;
    L3:
        long r15 = this.requested.get();
    L5:
        if (r12 == r15) goto L25;
        boolean r16 = this.done;
        T r17 = r11.poll();     // Catch: Throwable -> L22
        if (r17 != null) goto L10;
        boolean r18 = true;
    L12:
        if (checkTerminated(r16, r18, r10) == true) goto L13;
        if (r18 == true) goto L25;
        if (r10.tryOnNext(r17) == false) goto L19;
        r12 = r12 + 1;
    L19:
        r13 = r13 + 1;
        if (r13 != this.limit) goto L5;
        this.upstream.request(r13);
        r13 = 0;
        goto L5
    L13:
        return;
    L10:
        r18 = false;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.cancel();
        r11.clear();
        r10.onError(th);
        throw null;
    L25:
        if (r12 == r15) goto L27;
    L29:
        int r19 = get();
        if (r14 == r19) goto L31;
        r14 = r19;
        goto L3
    L31:
        this.produced = r12;
        this.consumed = r13;
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L3;
        return;
    L27:
        if (checkTerminated(this.done, r11.isEmpty(), r10) == false) goto L29;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runBackfused() {
        int r10 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        boolean r11 = this.done;
        this.downstream.onNext(null);
        if (r11 == true) goto L8;
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L4;
        return;
    L8:
        this.cancelled = true;
        Throwable r12 = this.error;
        if (r12 == null) goto L11;
        this.downstream.onError(r12);
        throw null;
    L11:
        this.downstream.onComplete();
        throw null;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runSync() {
        ConditionalSubscriber<? super T> r10 = this.downstream;
        SimpleQueue<T> r11 = this.queue;
        long r12 = this.produced;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
    L5:
        if (r12 == r14) goto L20;
        T r15 = r11.poll();     // Catch: Throwable -> L16
        if (this.cancelled == true) goto L9;
        if (r15 == null) goto L14;
        if (r10.tryOnNext(r15) == false) goto L5;
        r12 = r12 + 1;
        goto L5
    L14:
        this.cancelled = true;
        r10.onComplete();
        throw null;
    L9:
        return;
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.cancel();
        r10.onError(th);
        throw null;
    L20:
        if (this.cancelled == true) goto L21;
        if (r11.isEmpty() == true) goto L30;
        int r16 = get();
        if (r13 == r16) goto L26;
        r13 = r16;
        goto L3
    L26:
        this.produced = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    L30:
        this.cancelled = true;
        r10.onComplete();
        throw null;
    }
}
