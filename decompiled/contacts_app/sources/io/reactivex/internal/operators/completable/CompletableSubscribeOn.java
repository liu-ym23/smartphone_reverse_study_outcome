package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableSubscribeOn extends Completable {
    final Scheduler scheduler;
    final CompletableSource source;

    static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final CompletableObserver downstream;
        final CompletableSource source;
        final SequentialDisposable task;

        SubscribeOnObserver(CompletableObserver r1, CompletableSource r2) {
            this.downstream = r1;
            this.source = r2;
            this.task = new SequentialDisposable();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.subscribe(this);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    public CompletableSubscribeOn(CompletableSource r1, Scheduler r2) {
        this.source = r1;
        this.scheduler = r2;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r3) {
        SubscribeOnObserver r0 = new SubscribeOnObserver(r3, this.source);
        r3.onSubscribe(r0);
        Disposable r2 = this.scheduler.scheduleDirect(r0);
        r0.task.replace(r2);
    }
}
