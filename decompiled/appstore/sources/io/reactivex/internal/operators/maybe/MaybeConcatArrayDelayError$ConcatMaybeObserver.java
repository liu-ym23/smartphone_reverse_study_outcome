package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeConcatArrayDelayError$ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final Subscriber<? super T> downstream;
    final AtomicThrowable errors;
    int index;
    long produced;
    final AtomicLong requested;
    final MaybeSource<? extends T>[] sources;

    public MaybeConcatArrayDelayError$ConcatMaybeObserver(Subscriber<? super T> r10, MaybeSource<? extends T>[] r11) {
        this.downstream = r10;
        this.sources = r11;
        this.requested = new AtomicLong();
        this.disposables = new SequentialDisposable();
        this.current = new AtomicReference(NotificationLite.COMPLETE);
        this.errors = new AtomicThrowable();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<Object> r10 = this.current;
        Subscriber<? super T> r11 = this.downstream;
        SequentialDisposable r12 = this.disposables;
    L7:
        if (r12.isDisposed() == true) goto L8;
        Object r13 = r10.get();
        if (r13 == null) goto L29;
        if (r13 == NotificationLite.COMPLETE) goto L17;
        long r14 = this.produced;
        if (r14 == this.requested.get()) goto L29;
        this.produced = r14 + 1;
        r10.lazySet(null);
        r11.onNext(r13);
    L19:
        if (r12.isDisposed() == true) goto L29;
        int r15 = this.index;
        MaybeSource<? extends T>[] r16 = this.sources;
        if (r15 == r16.length) goto L23;
        this.index = r15 + 1;
        r16[r15].subscribe(this);
        goto L29
    L23:
        if (this.errors.get() == null) goto L25;
        r11.onError(this.errors.terminate());
        return;
    L25:
        r11.onComplete();
        return;
    L17:
        r10.lazySet(null);
    L29:
        if (decrementAndGet() != 0) goto L7;
        return;
    L8:
        r10.lazySet(null);
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.current.lazySet(NotificationLite.COMPLETE);
        if (this.errors.addThrowable(r10) == false) goto L5;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        this.disposables.replace(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.current.lazySet(r10);
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }
}
