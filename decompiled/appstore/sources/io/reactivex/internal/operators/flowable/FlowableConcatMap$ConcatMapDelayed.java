package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatMap$ConcatMapDelayed<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = -2945777694260521066L;
    final Subscriber<? super R> downstream;
    final boolean veryEnd;

    public FlowableConcatMap$ConcatMapDelayed(Subscriber<? super R> r10, Function<? super T, ? extends Publisher<? extends R>> r11, int r12, boolean r13) {
        super(r11, r12);
        this.downstream = r10;
        this.veryEnd = r13;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.inner.cancel();
        this.upstream.cancel();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.cancelled == true) goto L6;
        if (this.active == true) goto L62;
        boolean r10 = this.done;
        if (r10 == true) goto L12;
    L66:
        T r11 = this.queue.poll();     // Catch: Throwable -> L58
        if (r11 != null) goto L21;
        boolean r12 = true;
    L22:
        if (r10 == false) goto L29;
        if (r12 == false) goto L29;
        Throwable r13 = this.errors.terminate();
        if (r13 == null) goto L27;
        this.downstream.onError(r13);
        return;
    L27:
        this.downstream.onComplete();
        return;
    L29:
        if (r12 == true) goto L62;
        Publisher r14 = (Publisher) io.reactivex.internal.functions.a.b(this.mapper.apply(r11), "The mapper returned a null Publisher");     // Catch: Throwable -> L55
        if (this.sourceMode == 1) goto L38;
        int r15 = this.consumed + 1;
        if (r15 != this.limit) goto L36;
        this.consumed = 0;
        this.upstream.request(r15);
        goto L38
    L36:
        this.consumed = r15;
    L38:
        if ((r14 instanceof Callable) == false) goto L54;
        Object r16 = ((Callable) r14).call();     // Catch: Throwable -> L42
    L48:
        if (r16 == null) goto L5;
        if (this.inner.isUnbounded() == true) goto L52;
        this.active = true;
        FlowableConcatMap$ConcatMapInner<R> r17 = this.inner;
        r17.setSubscription(new c(r16, r17));
        goto L62
    L52:
        this.downstream.onNext(r16);
    L42:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        if (this.veryEnd == false) goto L45;
        r16 = null;
        goto L48
    L45:
        this.upstream.cancel();
        this.downstream.onError(this.errors.terminate());
        return;
    L54:
        this.active = true;
        r14.subscribe(this.inner);
    L55:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L21:
        r12 = false;
    L58:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L12:
        if (this.veryEnd == true) goto L66;
        if (this.errors.get() == null) goto L66;
        this.downstream.onError(this.errors.terminate());
        return;
    L62:
        if (decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapSupport
    public void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.veryEnd == true) goto L7;
        this.upstream.cancel();
        this.done = true;
    L7:
        this.active = false;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapSupport
    public void innerNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        this.inner.request(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}
