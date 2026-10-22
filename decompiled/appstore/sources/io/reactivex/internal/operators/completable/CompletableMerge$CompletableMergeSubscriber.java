package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
    private static final long serialVersionUID = -2108443387387077490L;
    final boolean delayErrors;
    final CompletableObserver downstream;
    final AtomicThrowable error;
    final int maxConcurrency;
    final io.reactivex.disposables.a set;
    Subscription upstream;

    public final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 251330541679988317L;
        final /* synthetic */ CompletableMerge$CompletableMergeSubscriber this$0;

        public MergeInnerObserver(CompletableMerge$CompletableMergeSubscriber r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public CompletableMerge$CompletableMergeSubscriber(CompletableObserver r10, int r11, boolean r12) {
        this.downstream = r10;
        this.maxConcurrency = r11;
        this.delayErrors = r12;
        this.set = new io.reactivex.disposables.a();
        this.error = new AtomicThrowable();
        lazySet(1);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
    }

    public void innerComplete(MergeInnerObserver r10) {
        this.set.delete(r10);
        if (decrementAndGet() != 0) goto L9;
        Throwable r11 = this.error.get();
        if (r11 == null) goto L7;
        this.downstream.onError(r11);
        return;
    L7:
        this.downstream.onComplete();
        return;
    L9:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
        this.upstream.request(1);
        return;
    }

    public void innerError(MergeInnerObserver r10, Throwable r11) {
        this.set.delete(r10);
        if (this.delayErrors == true) goto L11;
        this.upstream.cancel();
        this.set.dispose();
        if (this.error.addThrowable(r11) == true) goto L7;
        qf.a.e(r11);
        return;
    L7:
        if (getAndSet(0) <= 0) goto L20;
        this.downstream.onError(this.error.terminate());
        return;
    L20:
        return;
    L11:
        if (this.error.addThrowable(r11) == true) goto L13;
        qf.a.e(r11);
        return;
    L13:
        if (decrementAndGet() != 0) goto L16;
        this.downstream.onError(this.error.terminate());
        return;
    L16:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
        this.upstream.request(1);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (this.error.get() == null) goto L7;
        this.downstream.onError(this.error.terminate());
        return;
    L7:
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.delayErrors == true) goto L11;
        this.set.dispose();
        if (this.error.addThrowable(r10) == true) goto L7;
        qf.a.e(r10);
        return;
    L7:
        if (getAndSet(0) <= 0) goto L17;
        this.downstream.onError(this.error.terminate());
        return;
    L17:
        return;
    L11:
        if (this.error.addThrowable(r10) == true) goto L13;
        qf.a.e(r10);
        return;
    L13:
        if (decrementAndGet() != 0) goto L20;
        this.downstream.onError(this.error.terminate());
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public /* bridge */ /* synthetic */ void onNext(Object r10) {
        onNext((CompletableSource) r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L7;
        r10.request(Long.MAX_VALUE);
        return;
    L7:
        r10.request(r11);
        return;
    }

    public void onNext(CompletableSource r10) {
        getAndIncrement();
        MergeInnerObserver r11 = new MergeInnerObserver(this);
        this.set.add(r11);
        r10.subscribe(r11);
    }
}
