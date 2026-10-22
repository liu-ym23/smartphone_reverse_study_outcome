package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableTimer extends Completable {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver downstream;

        TimerDisposable(CompletableObserver r1) {
            this.downstream = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void setFuture(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }
    }

    public CompletableTimer(long r1, TimeUnit r3, Scheduler r4) {
        this.delay = r1;
        this.unit = r3;
        this.scheduler = r4;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r4) {
        TimerDisposable r0 = new TimerDisposable(r4);
        r4.onSubscribe(r0);
        r0.setFuture(this.scheduler.scheduleDirect(r0, this.delay, this.unit));
    }
}
