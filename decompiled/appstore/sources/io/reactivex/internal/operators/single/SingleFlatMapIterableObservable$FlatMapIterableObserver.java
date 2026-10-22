package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final Observer<? super R> downstream;
    volatile Iterator<? extends R> it;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    Disposable upstream;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(Observer<? super R> r10, Function<? super T, ? extends Iterable<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.it = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (this.it != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        Observer<? super R> r11 = this.downstream;
        Iterator<? extends R> r12 = this.mapper.apply(r10).iterator();     // Catch: Throwable -> L28
        if (r12.hasNext() == true) goto L8;
        r11.onComplete();
        return;
    L8:
        if (this.outputFused == false) goto L12;
        this.it = r12;
        r11.onNext(null);
        r11.onComplete();
        return;
    L12:
        if (this.cancelled == true) goto L13;
        r11.onNext(r12.next());
        if (this.cancelled == true) goto L17;
        if (r12.hasNext() == true) goto L12;
        r11.onComplete();
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    L17:
        return;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    L13:
        return;
    L28:
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

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
