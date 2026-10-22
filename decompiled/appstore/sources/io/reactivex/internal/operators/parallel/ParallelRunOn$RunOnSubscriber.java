package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import mf.f;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final Subscriber<? super T> downstream;

    public ParallelRunOn$RunOnSubscriber(Subscriber<? super T> r10, int r11, SpscArrayQueue<T> r12, f.a r13) {
        super(r11, r12, r13);
        this.downstream = r10;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        int r10 = this.consumed;
        SpscArrayQueue<T> r11 = this.queue;
        Subscriber<? super T> r12 = this.downstream;
        int r13 = this.limit;
        int r14 = 1;
    L3:
        long r15 = this.requested.get();
        long r16 = 0;
    L5:
        if (r16 == r15) goto L31;
        if (this.cancelled == true) goto L8;
        boolean r17 = this.done;
        if (r17 == false) goto L17;
        Throwable r18 = this.error;
        if (r18 == null) goto L17;
        r11.clear();
        r12.onError(r18);
        throw null;
    L17:
        T r19 = r11.poll();
        if (r19 != null) goto L20;
        boolean r110 = true;
    L21:
        if (r17 == false) goto L26;
        if (r110 == false) goto L26;
        r12.onComplete();
        throw null;
    L26:
        if (r110 == true) goto L31;
        r12.onNext(r19);
        r16 = r16 + 1;
        r10 = r10 + 1;
        if (r10 != r13) goto L5;
        this.upstream.request(r10);
        r10 = 0;
        goto L5
    L20:
        r110 = false;
        goto L21
    L8:
        r11.clear();
        return;
    L31:
        if (r16 != r15) goto L48;
        if (this.cancelled == true) goto L34;
        if (this.done == false) goto L48;
        Throwable r20 = this.error;
        if (r20 != null) goto L45;
        if (r11.isEmpty() == false) goto L48;
        r12.onComplete();
        throw null;
    L45:
        r11.clear();
        r12.onError(r20);
        throw null;
    L34:
        r11.clear();
        return;
    L48:
        if (r16 != 0) goto L50;
    L52:
        int r21 = get();
        if (r21 != r14) goto L57;
        this.consumed = r10;
        r21 = addAndGet(-r14);
        if (r21 != 0) goto L57;
        return;
    L57:
        r14 = r21;
        goto L3
    L50:
        if (r15 == Long.MAX_VALUE) goto L52;
        this.requested.addAndGet(-r16);
        goto L52
    }
}
