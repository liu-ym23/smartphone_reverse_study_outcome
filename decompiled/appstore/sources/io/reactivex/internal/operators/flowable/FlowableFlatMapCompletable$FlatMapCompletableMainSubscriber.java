package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Subscriber<? super T> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;
    final io.reactivex.disposables.a set;
    Subscription upstream;

    public final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 8606673141535671828L;
        final /* synthetic */ FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber this$0;

        public InnerConsumer(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber r10) {
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

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(Subscriber<? super T> r10, Function<? super T, ? extends CompletableSource> r11, boolean r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.set = new io.reactivex.disposables.a();
        this.maxConcurrency = r13;
        lazySet(1);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer r10) {
        this.set.delete(r10);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer r10, Throwable r11) {
        this.set.delete(r10);
        onError(r11);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
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
        cancel();
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
        InnerConsumer r12 = new InnerConsumer(this);
        if (this.cancelled == false) goto L6;
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

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() throws Exception {
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        return r10 & 2;
    }
}
