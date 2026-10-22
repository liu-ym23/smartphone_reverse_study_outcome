package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeUnsubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler scheduler;

    static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final MaybeObserver<? super T> downstream;
        Disposable ds;
        final Scheduler scheduler;

        UnsubscribeOnMaybeObserver(MaybeObserver<? super T> r1, Scheduler r2) {
            this.downstream = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable r0 = getAndSet(DisposableHelper.DISPOSED);
            if (r0 == DisposableHelper.DISPOSED) goto L6;
            this.ds = r0;
            this.scheduler.scheduleDirect(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }
    }

    public MaybeUnsubscribeOn(MaybeSource<T> r1, Scheduler r2) {
        super(r1);
        this.scheduler = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r3) {
        this.source.subscribe(new UnsubscribeOnMaybeObserver(r3, this.scheduler));
    }
}
