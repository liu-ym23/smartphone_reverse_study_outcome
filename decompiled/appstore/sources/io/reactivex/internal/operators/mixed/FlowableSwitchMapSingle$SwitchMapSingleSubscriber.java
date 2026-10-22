package io.reactivex.internal.operators.mixed;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSwitchMapSingle$SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final SwitchMapSingleObserver<Object> INNER_DISPOSED = null;
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    long emitted;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapSingleObserver<R>> inner;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final AtomicLong requested;
    Subscription upstream;

    public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final FlowableSwitchMapSingle$SwitchMapSingleSubscriber<?, R> parent;

        public SwitchMapSingleObserver(FlowableSwitchMapSingle$SwitchMapSingleSubscriber<?, R> r10) {
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            this.parent.innerError(this, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(R r10) {
            this.item = r10;
            this.parent.drain();
        }
    }

    static {
        INNER_DISPOSED = new SwitchMapSingleObserver(null);
    }

    public FlowableSwitchMapSingle$SwitchMapSingleSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends SingleSource<? extends R>> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.inner = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
    }

    public void disposeInner() {
        AtomicReference<SwitchMapSingleObserver<R>> r10 = this.inner;
        SwitchMapSingleObserver<Object> r11 = INNER_DISPOSED;
        SwitchMapSingleObserver<R> r12 = r10.getAndSet((SwitchMapSingleObserver<R>) r11);
        if (r12 == null) goto L7;
        if (r12 == r11) goto L8;
        r12.dispose();
        return;
    L8:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super R> r10 = this.downstream;
        AtomicThrowable r11 = this.errors;
        AtomicReference<SwitchMapSingleObserver<R>> r12 = this.inner;
        AtomicLong r13 = this.requested;
        long r14 = this.emitted;
        int r15 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r11.get() != null) goto L12;
    L15:
        boolean r16 = this.done;
        SwitchMapSingleObserver<R> r17 = r12.get();
        if (r17 != null) goto L18;
        boolean r18 = true;
    L19:
        if (r16 == false) goto L26;
        if (r18 == false) goto L26;
        Throwable r19 = r11.terminate();
        if (r19 == null) goto L24;
        r10.onError(r19);
        return;
    L24:
        r10.onComplete();
        return;
    L26:
        if (r18 == true) goto L33;
        if (r17.item == null) goto L33;
        if (r14 == r13.get()) goto L33;
        p.a(r12, r17, null);
        r10.onNext(r17.item);
        r14 = r14 + 1;
    L33:
        this.emitted = r14;
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L7;
        return;
    L18:
        r18 = false;
        goto L19
    L12:
        if (this.delayErrors == true) goto L15;
        r10.onError(r11.terminate());
        return;
    }

    public void innerError(SwitchMapSingleObserver<R> r10, Throwable r11) {
        if (p.a(this.inner, r10, null) == true) goto L5;
    L11:
        a.e(r11);
        return;
    L5:
        if (this.errors.addThrowable(r11) == false) goto L11;
        if (this.delayErrors == true) goto L9;
        this.upstream.cancel();
        disposeInner();
    L9:
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        a.e(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        disposeInner();
    L7:
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        SwitchMapSingleObserver<R> r11 = this.inner.get();
        if (r11 == null) goto L17;
        r11.dispose();
    L17:
        SingleSource r12 = (SingleSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null SingleSource");     // Catch: Throwable -> L14
        SwitchMapSingleObserver r13 = new SwitchMapSingleObserver(this);
    L7:
        SwitchMapSingleObserver<R> r14 = this.inner.get();
        if (r14 == INNER_DISPOSED) goto L22;
        if (p.a(this.inner, r14, r13) == false) goto L7;
        r12.subscribe(r13);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.inner.getAndSet((SwitchMapSingleObserver<R>) INNER_DISPOSED);
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
    }
}
