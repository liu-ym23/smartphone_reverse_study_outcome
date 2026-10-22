package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableBuffer$BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8223395059921494546L;
    final Callable<U> bufferSupplier;
    final ArrayDeque<U> buffers;
    final int count;
    final Observer<? super U> downstream;
    long index;
    final int skip;
    Disposable upstream;

    public ObservableBuffer$BufferSkipObserver(Observer<? super U> r10, int r11, int r12, Callable<U> r13) {
        this.downstream = r10;
        this.count = r11;
        this.skip = r12;
        this.bufferSupplier = r13;
        this.buffers = new ArrayDeque();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
    L3:
        if (this.buffers.isEmpty() == true) goto L5;
        this.downstream.onNext(this.buffers.poll());
        goto L3
    L5:
        this.downstream.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.buffers.clear();
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        long r11 = this.index;
        this.index = 1 + r11;
        if ((r11 % ((long) this.skip)) == 0) goto L16;
    L9:
        Iterator<U> r12 = this.buffers.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        U r13 = r12.next();
        r13.add(r10);
        if (this.count > r13.size()) goto L11;
        r12.remove();
        this.downstream.onNext(r13);
        goto L11
    L15:
        return;
    L16:
        Collection r14 = (Collection) io.reactivex.internal.functions.a.b(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
        this.buffers.offer((U) r14);
    L6:
        th = move-exception;
        this.buffers.clear();
        this.upstream.dispose();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
