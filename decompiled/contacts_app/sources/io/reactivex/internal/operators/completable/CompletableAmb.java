package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableAmb extends Completable {
    private final CompletableSource[] sources;
    private final Iterable<? extends CompletableSource> sourcesIterable;

    static final class Amb implements CompletableObserver {
        final CompletableObserver downstream;
        final AtomicBoolean once;
        final CompositeDisposable set;
        Disposable upstream;

        Amb(AtomicBoolean r1, CompositeDisposable r2, CompletableObserver r3) {
            this.once = r1;
            this.set = r2;
            this.downstream = r3;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.upstream = r1;
            this.set.add(r1);
        }
    }

    public CompletableAmb(CompletableSource[] r1, Iterable<? extends CompletableSource> r2) {
        this.sources = r1;
        this.sourcesIterable = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r9) {
        CompletableSource[] r0 = this.sources;
        if (r0 != null) goto L20;
        r0 = new CompletableSource[8];
        Iterator<? extends CompletableSource> r8 = this.sourcesIterable.iterator();     // Catch: Throwable -> L17
        int r3 = 0;
    L7:
        if (r8.hasNext() == false) goto L21;
        CompletableSource r4 = r8.next();     // Catch: Throwable -> L17
        if (r4 == null) goto L10;
        if (r3 != r0.length) goto L15;
        CompletableSource[] r5 = new CompletableSource[(r3 >> 2) + r3];     // Catch: Throwable -> L17
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
        CompositeDisposable r10 = new CompositeDisposable();
        r9.onSubscribe(r10);
        AtomicBoolean r7 = new AtomicBoolean();
        int r11 = 0;
    L22:
        if (r11 >= r3) goto L33;
        CompletableSource r12 = r0[r11];
        if (r10.isDisposed() == true) goto L25;
        if (r12 == null) goto L27;
        r12.subscribe(new Amb(r7, r10, r9));
        r11 = r11 + 1;
        goto L22
    L27:
        Throwable r1 = new NullPointerException("One of the sources is null");
        if (r7.compareAndSet(false, true) == false) goto L30;
        r10.dispose();
        r9.onError(r1);
        return;
    L30:
        RxJavaPlugins.onError(r1);
        return;
    L25:
        return;
    L33:
        if (r3 != 0) goto L44;
        r9.onComplete();
        return;
    L44:
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
