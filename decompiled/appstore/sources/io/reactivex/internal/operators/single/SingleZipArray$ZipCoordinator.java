package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class SingleZipArray$ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -5556924161382950569L;
    final SingleObserver<? super R> downstream;
    final SingleZipArray$ZipSingleObserver<T>[] observers;
    final Object[] values;
    final Function<? super Object[], ? extends R> zipper;

    public SingleZipArray$ZipCoordinator(SingleObserver<? super R> r10, int r11, Function<? super Object[], ? extends R> r12) {
        super(r11);
        this.downstream = r10;
        this.zipper = r12;
        SingleZipArray$ZipSingleObserver<T>[] r13 = new SingleZipArray$ZipSingleObserver[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new SingleZipArray$ZipSingleObserver(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        this.observers = r13;
        this.values = new Object[r11];
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r10 = 0;
        if (getAndSet(0) <= 0) goto L7;
        SingleZipArray$ZipSingleObserver<T>[] r11 = this.observers;
        int r12 = r11.length;
    L5:
        if (r10 >= r12) goto L9;
        r11[r10].dispose();
        r10 = r10 + 1;
        goto L5
    L9:
        return;
    }

    public void disposeExcept(int r10) {
        SingleZipArray$ZipSingleObserver<T>[] r11 = this.observers;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r11[r13].dispose();
        r13 = r13 + 1;
    L5:
        r10 = r10 + 1;
        if (r10 >= r12) goto L8;
        r11[r10].dispose();
        goto L5
    }

    public void innerError(Throwable r10, int r11) {
        if (getAndSet(0) <= 0) goto L5;
        disposeExcept(r11);
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    public void innerSuccess(T r10, int r11) {
        this.values[r11] = r10;
        if (decrementAndGet() != 0) goto L11;
        Object r12 = io.reactivex.internal.functions.a.b(this.zipper.apply(this.values), "The zipper returned a null value");     // Catch: Throwable -> L6
        this.downstream.onSuccess(r12);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() > 0) goto L5;
        return true;
    L5:
        return false;
    }
}
