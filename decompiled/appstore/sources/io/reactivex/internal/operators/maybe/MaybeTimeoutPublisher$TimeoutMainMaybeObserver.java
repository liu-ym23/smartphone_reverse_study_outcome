package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -5955289211445418871L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<? extends T> fallback;
    final MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> other;
    final MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> otherObserver;

    public MaybeTimeoutPublisher$TimeoutMainMaybeObserver(MaybeObserver<? super T> r10, MaybeSource<? extends T> r11) {
        this.downstream = r10;
        this.other = new MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(this);
        this.fallback = r11;
        if (r11 == null) goto L5;
        MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> r12 = new MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver(r10);
    L6:
        this.otherObserver = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
        MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> r10 = this.otherObserver;
        if (r10 == null) goto L6;
        DisposableHelper.dispose(r10);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L9;
        MaybeSource<? extends T> r10 = this.fallback;
        if (r10 != null) goto L7;
        this.downstream.onError(new TimeoutException());
        return;
    L7:
        r10.subscribe(this.otherObserver);
        return;
    }

    public void otherError(Throwable r10) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }
}
