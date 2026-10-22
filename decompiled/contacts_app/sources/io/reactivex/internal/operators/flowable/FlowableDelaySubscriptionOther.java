package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    final Publisher<? extends T> main;
    final Publisher<U> other;

    static final class MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2259811067697317255L;
        final Subscriber<? super T> downstream;
        final Publisher<? extends T> main;
        final MainSubscriber<T>.OtherSubscriber other;
        final AtomicReference<Subscription> upstream;

        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3892798459447644106L;
            final /* synthetic */ MainSubscriber this$0;

            OtherSubscriber(MainSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription r3) {
                if (SubscriptionHelper.setOnce(this, r3) == false) goto L6;
                r3.request(Long.MAX_VALUE);
                return;
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object r2) {
                Subscription r3 = get();
                if (r3 == SubscriptionHelper.CANCELLED) goto L6;
                lazySet(SubscriptionHelper.CANCELLED);
                r3.cancel();
                this.this$0.next();
                return;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable r3) {
                if (get() == SubscriptionHelper.CANCELLED) goto L5;
                this.this$0.downstream.onError(r3);
                return;
            L5:
                RxJavaPlugins.onError(r3);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() == SubscriptionHelper.CANCELLED) goto L6;
                this.this$0.next();
                return;
            }
        }

        MainSubscriber(Subscriber<? super T> r1, Publisher<? extends T> r2) {
            this.downstream = r1;
            this.main = r2;
            this.other = new OtherSubscriber(this);
            this.upstream = new AtomicReference();
        }

        void next() {
            this.main.subscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            SubscriptionHelper.deferredRequest(this.upstream, this, r2);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this, r2);
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> r1, Publisher<U> r2) {
        this.main = r1;
        this.other = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        MainSubscriber r0 = new MainSubscriber(r3, this.main);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
    }
}
