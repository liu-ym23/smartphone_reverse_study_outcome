package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    final Action onFinally;

    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Observer<? super T> downstream;
        final Action onFinally;
        QueueDisposable<T> qd;
        boolean syncFused;
        Disposable upstream;

        DoFinallyObserver(Observer<? super T> r1, Action r2) {
            this.downstream = r1;
            this.onFinally = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L9;
            this.upstream = r2;
            if ((r2 instanceof QueueDisposable) == false) goto L7;
            this.qd = (QueueDisposable) r2;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r4) {
            QueueDisposable<T> r0 = this.qd;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r4 & 4) != 0) goto L13;
            int r5 = r0.requestFusion(r4);
            if (r5 != 0) goto L9;
        L12:
            return r5;
        L9:
            if (r5 != 1) goto L11;
            r1 = true;
        L11:
            this.syncFused = r1;
            goto L12
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r0 = this.qd.poll();
            if (r0 == null) goto L5;
        L7:
            return r0;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }
    }

    public ObservableDoFinally(ObservableSource<T> r1, Action r2) {
        super(r1);
        this.onFinally = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new DoFinallyObserver(r3, this.onFinally));
    }
}
