package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleAmb<T> extends Single<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    static final class AmbSingleObserver<T> implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;
        final CompositeDisposable set;
        Disposable upstream;
        final AtomicBoolean winner;

        AmbSingleObserver(SingleObserver<? super T> r1, CompositeDisposable r2, AtomicBoolean r3) {
            this.downstream = r1;
            this.set = r2;
            this.winner = r3;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.upstream = r1;
            this.set.add(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r4) {
            if (this.winner.compareAndSet(false, true) == false) goto L6;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onSuccess(r4);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r4) {
            if (this.winner.compareAndSet(false, true) == false) goto L5;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }
    }

    public SingleAmb(SingleSource<? extends T>[] r1, Iterable<? extends SingleSource<? extends T>> r2) {
        this.sources = r1;
        this.sourcesIterable = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r9) {
        SingleSource<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L20;
        r0 = new SingleSource[8];
        Iterator<? extends SingleSource<? extends T>> r8 = this.sourcesIterable.iterator();     // Catch: Throwable -> L17
        int r3 = 0;
    L7:
        if (r8.hasNext() == false) goto L21;
        SingleSource<? extends T> r4 = r8.next();     // Catch: Throwable -> L17
        if (r4 == null) goto L10;
        if (r3 != r0.length) goto L15;
        SingleSource<? extends T>[] r5 = new SingleSource[(r3 >> 2) + r3];     // Catch: Throwable -> L17
        System.arraycopy(r0, 0, r5, 0, r3);     // Catch: Throwable -> L17
        r0 = r5;
    L15:
        int r6 = r3 + 1;     // Catch: Throwable -> L17
        r0[r3] = r4;     // Catch: Throwable -> L17
        r3 = r6;
        goto L7
    L10:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r9);     // Catch: Throwable -> L17
        return;
    L21:
        AtomicBoolean r10 = new AtomicBoolean();
        CompositeDisposable r7 = new CompositeDisposable();
        r9.onSubscribe(r7);
        int r11 = 0;
    L22:
        if (r11 >= r3) goto L33;
        SingleSource<? extends T> r12 = r0[r11];
        if (r7.isDisposed() == true) goto L25;
        if (r12 == null) goto L27;
        r12.subscribe(new AmbSingleObserver(r9, r7, r10));
        r11 = r11 + 1;
        goto L22
    L27:
        r7.dispose();
        NullPointerException r1 = new NullPointerException("One of the sources is null");
        if (r10.compareAndSet(false, true) == false) goto L30;
        r9.onError(r1);
        return;
    L30:
        RxJavaPlugins.onError(r1);
        return;
    L25:
        return;
    L33:
        return;
    L17:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r9);
        return;
    L20:
        r3 = r0.length;
        goto L21
    }
}
