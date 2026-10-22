package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    private static final long serialVersionUID = 8443155186132538303L;
    final boolean delayErrors;
    volatile boolean disposed;
    final CompletableObserver downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;
    final io.reactivex.disposables.a set;
    Subscription upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 8606673141535671828L;
        final /* synthetic */ FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber this$0;

        public InnerObserver(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber r10) {
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

    public FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber(CompletableObserver r10, Function<? super T, ? extends CompletableSource> r11, boolean r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.set = new io.reactivex.disposables.a();
        this.maxConcurrency = r13;
        lazySet(1);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void innerComplete(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T>.InnerObserver r10) {
        this.set.delete(r10);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T>.InnerObserver r10, Throwable r11) {
        this.set.delete(r10);
        onError(r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (decrementAndGet() != 0) goto L9;
        Throwable r10 = this.errors.terminate();
        if (r10 == null) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        this.downstream.onComplete();
        return;
    L9:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
        this.upstream.request(1);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        dispose();
        if (getAndSet(0) <= 0) goto L20;
        Throwable r11 = this.errors.terminate();
        this.downstream.onError(r11);
        return;
    L20:
        return;
    L7:
        if (decrementAndGet() != 0) goto L10;
        Throwable r12 = this.errors.terminate();
        this.downstream.onError(r12);
        return;
    L10:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L18;
        this.upstream.request(1);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        CompletableSource r11 = (CompletableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
        getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.disposed == false) goto L6;
        return;
    L6:
        if (this.set.add(r12) == false) goto L15;
        r11.subscribe(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
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
}
