package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {
    final long n;

    static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;
        final Subscriber<? super T> downstream;
        long remaining;
        Subscription upstream;

        LimitSubscriber(Subscriber<? super T> r1, long r2) {
            this.downstream = r1;
            this.remaining = r2;
            lazySet(r2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r5) {
            if (SubscriptionHelper.validate(this.upstream, r5) == true) goto L5;
            return;
        L5:
            if (this.remaining != 0) goto L7;
            r5.cancel();
            EmptySubscription.complete(this.downstream);
            return;
        L7:
            this.upstream = r5;
            this.downstream.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r7) {
            long r0 = this.remaining;
            if (r0 <= 0) goto L8;
            long r1 = r0 - 1;
            this.remaining = r1;
            this.downstream.onNext(r7);
            if (r1 != 0) goto L9;
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            if (this.remaining <= 0) goto L5;
            this.remaining = 0;
            this.downstream.onError(r5);
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.remaining <= 0) goto L6;
            this.remaining = 0;
            this.downstream.onComplete();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r7) {
            if (SubscriptionHelper.validate(r7) == false) goto L18;
        L4:
            long r0 = get();
            if (r0 == 0) goto L19;
            if (r0 > r7) goto L10;
            long r2 = r0;
        L12:
            if (compareAndSet(r0, r0 - r2) == false) goto L4;
            this.upstream.request(r2);
            return;
        L10:
            r2 = r7;
            goto L12
        L19:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }
    }

    public FlowableLimit(Flowable<T> r1, long r2) {
        super(r1);
        this.n = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r5) {
        this.source.subscribe(new LimitSubscriber(r5, this.n));
    }
}
