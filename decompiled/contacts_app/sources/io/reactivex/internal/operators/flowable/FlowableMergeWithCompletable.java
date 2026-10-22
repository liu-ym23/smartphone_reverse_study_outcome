package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource other;

    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error;
        volatile boolean mainDone;
        final AtomicReference<Subscription> mainSubscription;
        volatile boolean otherDone;
        final OtherObserver otherObserver;
        final AtomicLong requested;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> parent;

            OtherObserver(MergeWithSubscriber<?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.otherComplete();
            }
        }

        MergeWithSubscriber(Subscriber<? super T> r1) {
            this.downstream = r1;
            this.mainSubscription = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            HalfSerializer.onNext(this.downstream, r3, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone == false) goto L6;
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        void otherError(Throwable r3) {
            SubscriptionHelper.cancel(this.mainSubscription);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone == false) goto L6;
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }
    }

    public FlowableMergeWithCompletable(Flowable<T> r1, CompletableSource r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r2) {
        MergeWithSubscriber r0 = new MergeWithSubscriber(r2);
        r2.onSubscribe(r0);
        this.source.subscribe(r0);
        this.other.subscribe(r0.otherObserver);
    }
}
