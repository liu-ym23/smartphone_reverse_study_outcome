package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableMergeArray extends Completable {
    final CompletableSource[] sources;

    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;
        final CompletableObserver downstream;
        final AtomicBoolean once;
        final CompositeDisposable set;

        InnerCompletableObserver(CompletableObserver r1, AtomicBoolean r2, CompositeDisposable r3, int r4) {
            this.downstream = r1;
            this.once = r2;
            this.set = r3;
            lazySet(r4);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.set.add(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r4) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.once.compareAndSet(false, true) == false) goto L9;
            this.downstream.onComplete();
            return;
        }
    }

    public CompletableMergeArray(CompletableSource[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r6) {
        CompositeDisposable r0 = new CompositeDisposable();
        InnerCompletableObserver r2 = new InnerCompletableObserver(r6, new AtomicBoolean(), r0, this.sources.length + 1);
        r6.onSubscribe(r0);
        CompletableSource[] r5 = this.sources;
        int r7 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L11;
        CompletableSource r3 = r5[r1];
        if (r0.isDisposed() == true) goto L6;
        if (r3 == null) goto L8;
        r3.subscribe(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        r0.dispose();
        r2.onError(new NullPointerException("A completable source is null"));
        return;
    L6:
        return;
    L11:
        r2.onComplete();
    }
}
