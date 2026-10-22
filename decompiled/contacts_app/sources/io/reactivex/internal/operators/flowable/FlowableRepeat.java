package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {
    final long count;

    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> downstream;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;

        RepeatSubscriber(Subscriber<? super T> r1, long r2, SubscriptionArbiter r4, Publisher<? extends T> r5) {
            this.downstream = r1;
            this.sa = r4;
            this.source = r5;
            this.remaining = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            this.sa.setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 == 0) goto L8;
            subscribeNext();
            return;
        L8:
            this.downstream.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L13;
            int r0 = 1;
        L6:
            if (this.sa.isCancelled() == true) goto L7;
            long r1 = this.produced;
            if (r1 == 0) goto L11;
            this.produced = 0;
            this.sa.produced(r1);
        L11:
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    public FlowableRepeat(Flowable<T> r1, long r2) {
        super(r1);
        this.count = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r8) {
        SubscriptionArbiter r4 = new SubscriptionArbiter(false);
        r8.onSubscribe(r4);
        long r0 = this.count;
        long r2 = Long.MAX_VALUE;
        if (r0 == Long.MAX_VALUE) goto L5;
        r2 = r0 - 1;
    L5:
        new RepeatSubscriber(r8, r2, r4, this.source).subscribeNext();
    }
}
