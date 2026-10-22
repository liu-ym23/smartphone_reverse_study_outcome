package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final Subscriber<? super R> downstream;
    volatile Iterator<? extends R> it;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    final AtomicLong requested;
    Disposable upstream;

    public MaybeFlatMapIterableFlowable$FlatMapIterableObserver(Subscriber<? super R> r10, Function<? super T, ? extends Iterable<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.it = null;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super R> r10 = this.downstream;
        Iterator<? extends R> r11 = this.it;
        if (this.outputFused == false) goto L10;
        if (r11 == null) goto L10;
        r10.onNext(null);
        r10.onComplete();
        return;
    L10:
        int r12 = 1;
    L11:
        if (r11 == null) goto L40;
        long r13 = this.requested.get();
        if (r13 == Long.MAX_VALUE) goto L14;
        long r14 = 0;
    L18:
        if (r14 == r13) goto L38;
        if (this.cancelled == true) goto L21;
        r10.onNext((Object) io.reactivex.internal.functions.a.b(r11.next(), "The iterator returned a null value"));
        if (this.cancelled == true) goto L25;
        r14 = r14 + 1;
        if (r11.hasNext() == true) goto L18;
        r10.onComplete();
        return;
    L31:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    L25:
        return;
    L34:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    L21:
        return;
    L38:
        if (r14 == 0) goto L40;
        io.reactivex.internal.util.a.e(this.requested, r14);
        goto L40
    L14:
        fastPath(r10, r11);
        return;
    L40:
        r12 = addAndGet(-r12);
        if (r12 == 0) goto L42;
        if (r11 != null) goto L11;
        r11 = this.it;
        goto L11
    }

    public void fastPath(Subscriber<? super R> r10, Iterator<? extends R> r11) {
    L3:
        if (this.cancelled == true) goto L4;
        r10.onNext(r11.next());
        if (this.cancelled == true) goto L8;
        if (r11.hasNext() == true) goto L3;
        r10.onComplete();
        return;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    L8:
        return;
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (this.it != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        Iterator<? extends R> r11 = this.mapper.apply(r10).iterator();     // Catch: Throwable -> L8
        if (r11.hasNext() == true) goto L6;
        this.downstream.onComplete();
        return;
    L6:
        this.it = r11;
        drain();
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public R poll() throws Exception {
        Iterator<? extends R> r10 = this.it;
        if (r10 == null) goto L8;
        R r11 = (R) io.reactivex.internal.functions.a.b(r10.next(), "The iterator returned a null value");
        if (r10.hasNext() == true) goto L7;
        this.it = null;
    L7:
        return r11;
    L8:
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
