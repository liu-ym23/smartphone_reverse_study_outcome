package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Subscription upstream;

        SkipLastTimedSubscriber(Subscriber<? super T> r2, long r3, TimeUnit r5, Scheduler r6, int r7, boolean r8) {
            this.requested = new AtomicLong();
            this.downstream = r2;
            this.time = r3;
            this.unit = r5;
            this.scheduler = r6;
            this.queue = new SpscLinkedArrayQueue(r7);
            this.delayError = r8;
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
        public void onNext(T r4) {
            long r0 = this.scheduler.now(this.unit);
            this.queue.offer(Long.valueOf(r0), r4);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
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
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r1 = this.downstream;
            SpscLinkedArrayQueue<Object> r2 = this.queue;
            boolean r3 = this.delayError;
            TimeUnit r4 = this.unit;
            Scheduler r5 = this.scheduler;
            long r6 = this.time;
            int r9 = 1;
        L6:
            long r10 = this.requested.get();
            long r14 = 0;
        L8:
            if (r14 == r10) goto L26;
            boolean r8 = this.done;
            Long r17 = (Long) r2.peek();
            if (r17 != null) goto L12;
            boolean r18 = true;
        L13:
            long r19 = r5.now(r4);
            if (r18 == false) goto L16;
        L18:
            boolean r12 = r18;
        L20:
            if (checkTerminated(r8, r12, r1, r3) == true) goto L21;
            if (r12 == true) goto L26;
            r2.poll();
            r1.onNext(r2.poll());
            r14 = r14 + 1;
            goto L8
        L21:
            return;
        L16:
            if (r17.longValue() <= (r19 - r6)) goto L18;
            r12 = true;
            goto L20
        L12:
            r18 = false;
        L26:
            if (r14 == 0) goto L28;
            BackpressureHelper.produced(this.requested, r14);
        L28:
            r9 = addAndGet(-r9);
            if (r9 != 0) goto L6;
        }

        boolean checkTerminated(boolean r3, boolean r4, Subscriber<? super T> r5, boolean r6) {
            if (this.cancelled == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == false) goto L21;
            if (r6 == false) goto L14;
            if (r4 == false) goto L23;
            Throwable r2 = this.error;
            if (r2 == null) goto L12;
            r5.onError(r2);
        L13:
            return true;
        L12:
            r5.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r7 = this.error;
            if (r7 == null) goto L18;
            this.queue.clear();
            r5.onError(r7);
            return true;
        L18:
            if (r4 == false) goto L24;
            r5.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }
    }

    public FlowableSkipLastTimed(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5, int r6, boolean r7) {
        super(r1);
        this.time = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.bufferSize = r6;
        this.delayError = r7;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r11) {
        this.source.subscribe(new SkipLastTimedSubscriber(r11, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
