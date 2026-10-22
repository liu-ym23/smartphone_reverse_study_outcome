package io.reactivex.internal.operators.mixed;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final Observable<T> source;

    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapSingleObserver<Object> INNER_DISPOSED = null;
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicReference<SwitchMapSingleObserver<R>> inner;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        Disposable upstream;

        static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapSingleMainObserver<?, R> parent;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r1) {
                this.item = r1;
                this.parent.drain();
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r2) {
                this.parent.innerError(this, r2);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        static {
            INNER_DISPOSED = new SwitchMapSingleObserver(null);
        }

        SwitchMapSingleMainObserver(Observer<? super R> r1, Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.errors = new AtomicThrowable();
            this.inner = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            SwitchMapSingleObserver<R> r0 = this.inner.get();
            if (r0 == null) goto L17;
            r0.dispose();
        L17:
            SingleSource r5 = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null SingleSource");     // Catch: Throwable -> L14
            SwitchMapSingleObserver r1 = new SwitchMapSingleObserver(this);
        L7:
            SwitchMapSingleObserver<R> r2 = this.inner.get();
            if (r2 == INNER_DISPOSED) goto L22;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.inner, r2, r1) == false) goto L7;
            r5.subscribe(r1);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            this.inner.getAndSet((SwitchMapSingleObserver<R>) INNER_DISPOSED);
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            disposeInner();
        L7:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        void disposeInner() {
            AtomicReference<SwitchMapSingleObserver<R>> r1 = this.inner;
            SwitchMapSingleObserver<Object> r0 = INNER_DISPOSED;
            SwitchMapSingleObserver<R> r2 = r1.getAndSet((SwitchMapSingleObserver<R>) r0);
            if (r2 == null) goto L7;
            if (r2 == r0) goto L8;
            r2.dispose();
            return;
        L8:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerError(SwitchMapSingleObserver<R> r3, Throwable r4) {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.inner, r3, null) == true) goto L5;
        L11:
            RxJavaPlugins.onError(r4);
            return;
        L5:
            if (this.errors.addThrowable(r4) == false) goto L11;
            if (this.delayErrors == true) goto L9;
            this.upstream.dispose();
            disposeInner();
        L9:
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super R> r0 = this.downstream;
            AtomicThrowable r1 = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> r2 = this.inner;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (r1.get() != null) goto L12;
        L15:
            boolean r5 = this.done;
            SwitchMapSingleObserver<R> r6 = r2.get();
            if (r6 != null) goto L18;
            boolean r7 = true;
        L19:
            if (r5 == false) goto L26;
            if (r7 == false) goto L26;
            Throwable r8 = r1.terminate();
            if (r8 == null) goto L24;
            r0.onError(r8);
            return;
        L24:
            r0.onComplete();
            return;
        L26:
            if (r7 == true) goto L31;
            if (r6.item == null) goto L31;
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r2, r6, null);
            r0.onNext(r6.item);
        L31:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L18:
            r7 = false;
            goto L19
        L12:
            if (this.delayErrors == true) goto L15;
            r0.onError(r1.terminate());
            return;
        }
    }

    public ObservableSwitchMapSingle(Observable<T> r1, Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3) {
        this.source = r1;
        this.mapper = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r4) {
        if (ScalarXMapZHelper.tryAsSingle(this.source, this.mapper, r4) == true) goto L6;
        this.source.subscribe(new SwitchMapSingleMainObserver(r4, this.mapper, this.delayErrors));
        return;
    }
}
