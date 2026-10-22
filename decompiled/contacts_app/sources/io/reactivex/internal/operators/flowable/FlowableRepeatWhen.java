package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Object>, ? extends Publisher<?>> handler;

    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        RepeatWhenSubscriber(Subscriber<? super T> r1, FlowableProcessor<Object> r2, Subscription r3) {
            super(r1, r2, r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.receiver.cancel();
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            again(0);
        }
    }

    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;
        final AtomicLong requested;
        final Publisher<T> source;
        WhenSourceSubscriber<T, U> subscriber;
        final AtomicReference<Subscription> upstream;

        WhenReceiver(Publisher<T> r1) {
            this.source = r1;
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r2) {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (this.upstream.get() == SubscriptionHelper.CANCELLED) goto L6;
            this.source.subscribe(this.subscriber);
            if (decrementAndGet() != 0) goto L5;
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final Subscriber<? super T> downstream;
        protected final FlowableProcessor<U> processor;
        private long produced;
        protected final Subscription receiver;

        WhenSourceSubscriber(Subscriber<? super T> r2, FlowableProcessor<U> r3, Subscription r4) {
            super(false);
            this.downstream = r2;
            this.processor = r3;
            this.receiver = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription r1) {
            setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        protected final void again(U r6) {
            setSubscription(EmptySubscription.INSTANCE);
            long r0 = this.produced;
            if (r0 == 0) goto L5;
            this.produced = 0;
            produced(r0);
        L5:
            this.receiver.request(1);
            this.processor.onNext(r6);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }
    }

    public FlowableRepeatWhen(Flowable<T> r1, Function<? super Flowable<Object>, ? extends Publisher<?>> r2) {
        super(r1);
        this.handler = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r5) {
        SerializedSubscriber r0 = new SerializedSubscriber(r5);
        FlowableProcessor<T> r1 = UnicastProcessor.create(8).toSerialized();
        Publisher r2 = (Publisher) ObjectHelper.requireNonNull(this.handler.apply(r1), "handler returned a null Publisher");     // Catch: Throwable -> L6
        WhenReceiver r3 = new WhenReceiver(this.source);
        RepeatWhenSubscriber r4 = new RepeatWhenSubscriber(r0, r1, r3);
        r3.subscriber = r4;
        r5.onSubscribe(r4);
        r2.subscribe(r3);
        r3.onNext(0);
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r5);
    }
}
