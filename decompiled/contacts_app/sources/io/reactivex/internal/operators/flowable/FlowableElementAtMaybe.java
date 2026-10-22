package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final long index;
    final Flowable<T> source;

    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        long count;
        boolean done;
        final MaybeObserver<? super T> downstream;
        final long index;
        Subscription upstream;

        ElementAtSubscriber(MaybeObserver<? super T> r1, long r2) {
            this.downstream = r1;
            this.index = r2;
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
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.count;
            if (r0 != this.index) goto L9;
            this.done = true;
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onSuccess(r5);
            return;
        L9:
            this.count = r0 + 1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public FlowableElementAtMaybe(Flowable<T> r1, long r2) {
        this.source = r1;
        this.index = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r5) {
        this.source.subscribe(new ElementAtSubscriber(r5, this.index));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.source, this.index, null, false));
    }
}
