package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ObservableRefCount extends mf.e {

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount parent;
        long subscriberCount;
        Disposable timer;

        public RefConnection(ObservableRefCount r10) {
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Disposable r10) throws Exception {
            accept2(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Disposable r10) throws Exception {
            DisposableHelper.replace(this, r10);
            throw null;
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount parent;
        Disposable upstream;

        public RefCountObserver(Observer<? super T> r10, ObservableRefCount r11, RefConnection r12) {
            this.downstream = r10;
            this.connection = r12;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r10) {
            if (compareAndSet(false, true) == true) goto L7;
            qf.a.e(r10);
            return;
        L7:
            throw null;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r10) {
            this.downstream.onNext(r10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }
    }
}
