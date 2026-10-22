package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final ObservableSource<?> other;

    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(Observer<? super T> r1, ObservableSource<?> r2) {
            super(r1, r2);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() != 0) goto L6;
            emit();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            if (this.wip.getAndIncrement() != 0) goto L10;
        L4:
            boolean r0 = this.done;
            emit();
            if (r0 == true) goto L6;
            if (this.wip.decrementAndGet() != 0) goto L4;
            return;
        L6:
            this.downstream.onComplete();
            return;
        }
    }

    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Observer<? super T> r1, ObservableSource<?> r2) {
            super(r1, r2);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            emit();
        }
    }

    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> other;
        final ObservableSource<?> sampler;
        Disposable upstream;

        abstract void completion();

        abstract void run();

        SampleMainObserver(Observer<? super T> r2, ObservableSource<?> r3) {
            this.other = new AtomicReference();
            this.downstream = r2;
            this.sampler = r3;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L8;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            if (this.other.get() != null) goto L9;
            this.sampler.subscribe(new SamplerObserver(this));
            return;
        L9:
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completion();
        }

        boolean setOther(Disposable r1) {
            return DisposableHelper.setOnce(this.other, r1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        public void error(Throwable r2) {
            this.upstream.dispose();
            this.downstream.onError(r2);
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        void emit() {
            T r0 = getAndSet(null);
            if (r0 == null) goto L6;
            this.downstream.onNext(r0);
            return;
        }
    }

    static final class SamplerObserver<T> implements Observer<Object> {
        final SampleMainObserver<T> parent;

        SamplerObserver(SampleMainObserver<T> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.parent.setOther(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r1) {
            this.parent.run();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.parent.error(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.complete();
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> r1, ObservableSource<?> r2, boolean r3) {
        super(r1);
        this.other = r2;
        this.emitLast = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        SerializedObserver r0 = new SerializedObserver(r3);
        if (this.emitLast == false) goto L5;
        this.source.subscribe(new SampleMainEmitLast(r0, this.other));
        return;
    L5:
        this.source.subscribe(new SampleMainNoLast(r0, this.other));
    }
}
