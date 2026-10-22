package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleTimeout$TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
    private static final long serialVersionUID = 37497744973048446L;
    final SingleObserver<? super T> downstream;
    final TimeoutFallbackObserver<T> fallback;
    SingleSource<? extends T> other;
    final AtomicReference<Disposable> task;
    final long timeout;
    final TimeUnit unit;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 2071387740092105509L;
        final SingleObserver<? super T> downstream;

        public TimeoutFallbackObserver(SingleObserver<? super T> r10) {
            this.downstream = r10;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r10) {
            this.downstream.onSuccess(r10);
        }
    }

    public SingleTimeout$TimeoutMainObserver(SingleObserver<? super T> r10, SingleSource<? extends T> r11, long r12, TimeUnit r13) {
        this.downstream = r10;
        this.other = r11;
        this.timeout = r12;
        this.unit = r13;
        this.task = new AtomicReference();
        if (r11 == null) goto L5;
        this.fallback = new TimeoutFallbackObserver(r10);
        return;
    L5:
        this.fallback = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> r10 = this.fallback;
        if (r10 == null) goto L6;
        DisposableHelper.dispose(r10);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 != r12) goto L5;
    L7:
        qf.a.e(r10);
        return;
    L5:
        if (compareAndSet(r11, r12) == false) goto L7;
        DisposableHelper.dispose(this.task);
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 != r12) goto L5;
        return;
    L5:
        if (compareAndSet(r11, r12) == false) goto L9;
        DisposableHelper.dispose(this.task);
        this.downstream.onSuccess(r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (compareAndSet(r10, r11) == false) goto L14;
        if (r10 == null) goto L8;
        r10.dispose();
    L8:
        SingleSource<? extends T> r12 = this.other;
        if (r12 != null) goto L11;
        this.downstream.onError(new TimeoutException(ExceptionHelper.c(this.timeout, this.unit)));
        return;
    L11:
        this.other = null;
        r12.subscribe(this.fallback);
        return;
    }
}
