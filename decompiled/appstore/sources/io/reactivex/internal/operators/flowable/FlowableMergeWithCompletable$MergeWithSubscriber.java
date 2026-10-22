package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableMergeWithCompletable$MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4592979584110982903L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean mainDone;
    final AtomicReference<Subscription> mainSubscription;
    volatile boolean otherDone;
    final OtherObserver otherObserver;
    final AtomicLong requested;

    public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
        private static final long serialVersionUID = -2935427570954647017L;
        final FlowableMergeWithCompletable$MergeWithSubscriber<?> parent;

        public OtherObserver(FlowableMergeWithCompletable$MergeWithSubscriber<?> r10) {
            this.parent = r10;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public FlowableMergeWithCompletable$MergeWithSubscriber(Subscriber<? super T> r10) {
        this.downstream = r10;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone == false) goto L6;
        io.reactivex.internal.util.d.b(this.downstream, this, this.error);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.otherObserver);
        io.reactivex.internal.util.d.d(this.downstream, r10, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        io.reactivex.internal.util.d.f(this.downstream, r10, this, this.error);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, r10);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone == false) goto L6;
        io.reactivex.internal.util.d.b(this.downstream, this, this.error);
        return;
    }

    public void otherError(Throwable r10) {
        SubscriptionHelper.cancel(this.mainSubscription);
        io.reactivex.internal.util.d.d(this.downstream, r10, this, this.error);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, r10);
    }
}
