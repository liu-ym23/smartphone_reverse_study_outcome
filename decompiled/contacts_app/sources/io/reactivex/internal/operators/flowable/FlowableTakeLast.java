package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int count;

    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        final AtomicLong requested;
        Subscription upstream;
        final AtomicInteger wip;

        TakeLastSubscriber(Subscriber<? super T> r2, int r3) {
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.downstream = r2;
            this.count = r3;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.count != size()) goto L5;
            poll();
        L5:
            offer(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) goto L28;
            Subscriber<? super T> r0 = this.downstream;
            long r1 = this.requested.get();
        L6:
            if (this.cancelled == true) goto L7;
            if (this.done == false) goto L27;
            long r5 = 0;
        L12:
            if (r5 == r1) goto L22;
            if (this.cancelled == true) goto L15;
            T r7 = poll();
            if (r7 == null) goto L18;
            r0.onNext(r7);
            r5 = r5 + 1;
            goto L12
        L18:
            r0.onComplete();
            return;
        L15:
            return;
        L22:
            if (r5 == 0) goto L27;
            if (r1 == Long.MAX_VALUE) goto L27;
            r1 = this.requested.addAndGet(-r5);
        L27:
            if (this.wip.decrementAndGet() != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    public FlowableTakeLast(Flowable<T> r1, int r2) {
        super(r1);
        this.count = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        this.source.subscribe(new TakeLastSubscriber(r3, this.count));
    }
}
