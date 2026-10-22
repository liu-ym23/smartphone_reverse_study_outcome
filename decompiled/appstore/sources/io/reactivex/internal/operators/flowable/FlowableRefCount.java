package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FlowableRefCount extends mf.b {

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final FlowableRefCount parent;
        long subscriberCount;
        Disposable timer;

        public RefConnection(FlowableRefCount r10) {
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Disposable r10) throws Exception {
            accept2(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Disposable r10) throws Exception {
            DisposableHelper.replace(this, r10);
            throw null;
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Subscriber<? super T> downstream;
        final FlowableRefCount parent;
        Subscription upstream;

        public RefCountSubscriber(Subscriber<? super T> r10, FlowableRefCount r11, RefConnection r12) {
            this.downstream = r10;
            this.connection = r12;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r10) {
            if (compareAndSet(false, true) == true) goto L7;
            qf.a.e(r10);
            return;
        L7:
            throw null;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r10) {
            this.downstream.onNext(r10);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r10) {
            if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r10) {
            this.upstream.request(r10);
        }
    }
}
