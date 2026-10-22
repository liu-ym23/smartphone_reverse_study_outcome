package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableWithLatestFromMany$WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 1577321883966341961L;
    final Function<? super Object[], R> combiner;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final ObservableWithLatestFromMany$WithLatestInnerObserver[] observers;
    final AtomicReference<Disposable> upstream;
    final AtomicReferenceArray<Object> values;

    public ObservableWithLatestFromMany$WithLatestFromObserver(Observer<? super R> r10, Function<? super Object[], R> r11, int r12) {
        this.downstream = r10;
        this.combiner = r11;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r13 = new ObservableWithLatestFromMany$WithLatestInnerObserver[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13[r14] = new ObservableWithLatestFromMany$WithLatestInnerObserver(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        this.observers = r13;
        this.values = new AtomicReferenceArray(r12);
        this.upstream = new AtomicReference();
        this.error = new AtomicThrowable();
    }

    public void cancelAllBut(int r10) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r11 = this.observers;
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L8;
        if (r12 == r10) goto L7;
        r11[r12].dispose();
    L7:
        r12 = r12 + 1;
        goto L4
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r10 = this.observers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].dispose();
        r12 = r12 + 1;
        goto L3
    }

    public void innerComplete(int r10, boolean r11) {
        if (r11 == true) goto L5;
        this.done = true;
        cancelAllBut(r10);
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
        return;
    }

    public void innerError(int r10, Throwable r11) {
        this.done = true;
        DisposableHelper.dispose(this.upstream);
        cancelAllBut(r10);
        io.reactivex.internal.util.d.c(this.downstream, r11, this, this.error);
    }

    public void innerNext(int r10, Object r11) {
        this.values.set(r10, r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        cancelAllBut(-1);
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        cancelAllBut(-1);
        io.reactivex.internal.util.d.c(this.downstream, r10, this, this.error);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        AtomicReferenceArray<Object> r11 = this.values;
        int r12 = r11.length();
        Object[] r13 = new Object[r12 + 1];
        int r14 = 0;
        r13[0] = r10;
    L6:
        if (r14 >= r12) goto L17;
        Object r15 = r11.get(r14);
        if (r15 == null) goto L9;
        r14 = r14 + 1;
        r13[r14] = r15;
        goto L6
    L9:
        return;
    L17:
        Object r16 = io.reactivex.internal.functions.a.b(this.combiner.apply(r13), "combiner returned a null value");     // Catch: Throwable -> L14
        io.reactivex.internal.util.d.e(this.downstream, r16, this, this.error);
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    public void subscribe(ObservableSource<?>[] r10, int r11) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] r12 = this.observers;
        AtomicReference<Disposable> r13 = this.upstream;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L10;
        if (DisposableHelper.isDisposed(r13.get()) == true) goto L14;
        if (this.done == true) goto L15;
        r10[r14].subscribe(r12[r14]);
        r14 = r14 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
