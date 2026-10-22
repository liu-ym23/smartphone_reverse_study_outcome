package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {
    final Consumer<? super T> onDrop;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final Subscriber<? super T> downstream;
        final Consumer<? super T> onDrop;
        Subscription upstream;

        BackpressureDropSubscriber(Subscriber<? super T> r1, Consumer<? super T> r2) {
            this.downstream = r1;
            this.onDrop = r2;
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
        public void onNext(T r5) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (get() == 0) goto L13;
            this.downstream.onNext(r5);
            BackpressureHelper.produced(this, 1);
            return;
        L13:
            this.onDrop.accept(r5);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this, r2);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(T r1) {
    }

    public FlowableOnBackpressureDrop(Flowable<T> r1) {
        super(r1);
        this.onDrop = this;
    }

    public FlowableOnBackpressureDrop(Flowable<T> r1, Consumer<? super T> r2) {
        super(r1);
        this.onDrop = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        this.source.subscribe(new BackpressureDropSubscriber(r3, this.onDrop));
    }
}
