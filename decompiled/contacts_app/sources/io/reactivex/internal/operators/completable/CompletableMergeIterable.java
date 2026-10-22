package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableMergeIterable extends Completable {
    final Iterable<? extends CompletableSource> sources;

    static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
        private static final long serialVersionUID = -7730517613164279224L;
        final CompletableObserver downstream;
        final CompositeDisposable set;
        final AtomicInteger wip;

        MergeCompletableObserver(CompletableObserver r1, CompositeDisposable r2, AtomicInteger r3) {
            this.downstream = r1;
            this.set = r2;
            this.wip = r3;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.set.add(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r3) {
            this.set.dispose();
            if (compareAndSet(false, true) == false) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(false, true) == false) goto L9;
            this.downstream.onComplete();
            return;
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r5) {
        CompositeDisposable r0 = new CompositeDisposable();
        r5.onSubscribe(r0);
        Iterator r4 = (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");     // Catch: Throwable -> L26
        AtomicInteger r1 = new AtomicInteger(1);
        MergeCompletableObserver r2 = new MergeCompletableObserver(r5, r0, r1);
    L6:
        if (r0.isDisposed() == true) goto L7;
        if (r4.hasNext() == false) goto L10;
        if (r0.isDisposed() == true) goto L14;
        CompletableSource r6 = (CompletableSource) ObjectHelper.requireNonNull(r4.next(), "The iterator returned a null CompletableSource");     // Catch: Throwable -> L20
        if (r0.isDisposed() == true) goto L18;
        r1.getAndIncrement();
        r6.subscribe(r2);
        goto L6
    L18:
        return;
    L20:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.dispose();
        r2.onError(th);
        return;
    L14:
        return;
    L10:
        r2.onComplete();
        return;
    L23:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.dispose();
        r2.onError(th);
        return;
    L7:
        return;
    L26:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r5.onError(th);
    }
}
