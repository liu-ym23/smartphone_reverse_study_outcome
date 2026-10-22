package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final ObservableSource<?>[] otherArray;
    final Iterable<? extends ObservableSource<?>> otherIterable;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ ObservableWithLatestFromMany this$0;

        SingletonArrayFunc(ObservableWithLatestFromMany r1) {
            this.this$0 = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T r3) throws Exception {
            return (R) ObjectHelper.requireNonNull(this.this$0.combiner.apply(new Object[]{r3}), "The combiner returned a null value");
        }
    }

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReference<Disposable> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromObserver(Observer<? super R> r2, Function<? super Object[], R> r3, int r4) {
            this.downstream = r2;
            this.combiner = r3;
            WithLatestInnerObserver[] r5 = new WithLatestInnerObserver[r4];
            int r6 = 0;
        L3:
            if (r6 >= r4) goto L5;
            r5[r6] = new WithLatestInnerObserver(this, r6);
            r6 = r6 + 1;
            goto L3
        L5:
            this.observers = r5;
            this.values = new AtomicReferenceArray(r4);
            this.upstream = new AtomicReference();
            this.error = new AtomicThrowable();
        }

        void subscribe(ObservableSource<?>[] r6, int r7) {
            WithLatestInnerObserver[] r0 = this.observers;
            AtomicReference<Disposable> r1 = this.upstream;
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L10;
            if (DisposableHelper.isDisposed(r1.get()) == true) goto L14;
            if (this.done == true) goto L15;
            r6[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            AtomicReferenceArray<Object> r0 = this.values;
            int r1 = r0.length();
            Object[] r2 = new Object[r1 + 1];
            int r3 = 0;
            r2[0] = r5;
        L6:
            if (r3 >= r1) goto L17;
            Object r6 = r0.get(r3);
            if (r6 == null) goto L9;
            r3 = r3 + 1;
            r2[r3] = r6;
            goto L6
        L9:
            return;
        L17:
            Object r7 = ObjectHelper.requireNonNull(this.combiner.apply(r2), "combiner returned a null value");     // Catch: Throwable -> L14
            HalfSerializer.onNext(this.downstream, r7, this, this.error);
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            WithLatestInnerObserver[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        void innerNext(int r1, Object r2) {
            this.values.set(r1, r2);
        }

        void innerError(int r2, Throwable r3) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(r2);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        void innerComplete(int r1, boolean r2) {
            if (r2 == true) goto L5;
            this.done = true;
            cancelAllBut(r1);
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        void cancelAllBut(int r3) {
            WithLatestInnerObserver[] r2 = this.observers;
            int r0 = 0;
        L4:
            if (r0 >= r2.length) goto L8;
            if (r0 == r3) goto L7;
            r2[r0].dispose();
        L7:
            r0 = r0 + 1;
            goto L4
        }
    }

    static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r2) {
            if (this.hasValue == true) goto L5;
            this.hasValue = true;
        L5:
            this.parent.innerNext(this.index, r2);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }

    public ObservableWithLatestFromMany(ObservableSource<T> r1, ObservableSource<?>[] r2, Function<? super Object[], R> r3) {
        super(r1);
        this.otherArray = r2;
        this.otherIterable = null;
        this.combiner = r3;
    }

    public ObservableWithLatestFromMany(ObservableSource<T> r1, Iterable<? extends ObservableSource<?>> r2, Function<? super Object[], R> r3) {
        super(r1);
        this.otherArray = null;
        this.otherIterable = r2;
        this.combiner = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r6) {
        ObservableSource<?>[] r0 = this.otherArray;
        if (r0 != null) goto L16;
        r0 = new ObservableSource[8];
        Iterator<? extends ObservableSource<?>> r1 = this.otherIterable.iterator();     // Catch: Throwable -> L13
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L17;
        ObservableSource<?> r3 = r1.next();     // Catch: Throwable -> L13
        if (r2 != r0.length) goto L11;
        r0 = (ObservableSource[]) Arrays.copyOf(r0, (r2 >> 1) + r2);     // Catch: Throwable -> L13
    L11:
        int r4 = r2 + 1;     // Catch: Throwable -> L13
        r0[r2] = r3;     // Catch: Throwable -> L13
        r2 = r4;
    L17:
        if (r2 != 0) goto L20;
        new ObservableMap(this.source, new SingletonArrayFunc(this)).subscribeActual(r6);
        return;
    L20:
        WithLatestFromObserver r5 = new WithLatestFromObserver(r6, this.combiner, r2);
        r6.onSubscribe(r5);
        r5.subscribe(r0, r2);
        this.source.subscribe(r5);
        return;
    L13:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r6);
        return;
    L16:
        r2 = r0.length;
        goto L17
    }
}
