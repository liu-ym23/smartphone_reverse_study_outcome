package io.reactivex.internal.operators.observable;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ObservablePublishClassic<T> {
    final AtomicReference<PublishObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        InnerDisposable(Observer<? super T> r1) {
            this.child = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != this) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object r0 = getAndSet(this);
            if (r0 == null) goto L7;
            if (r0 == this) goto L8;
            ((PublishObserver) r0).remove(this);
            return;
        L8:
            return;
        }

        void setParent(PublishObserver<T> r2) {
            if (compareAndSet(null, r2) == true) goto L6;
            r2.remove(this);
            return;
        }
    }

    static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = null;
        static final InnerDisposable[] TERMINATED = null;
        final AtomicReference<PublishObserver<T>> current;
        final AtomicReference<InnerDisposable<T>[]> observers;
        final AtomicBoolean shouldConnect;
        final AtomicReference<Disposable> upstream;

        static {
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        PublishObserver(AtomicReference<PublishObserver<T>> r3) {
            this.upstream = new AtomicReference();
            this.observers = new AtomicReference(EMPTY);
            this.current = r3;
            this.shouldConnect = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> r0 = this.observers;
            InnerDisposable<T>[] r1 = TERMINATED;
            if (r0.getAndSet(r1) == r1) goto L6;
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, this, null);
            DisposableHelper.dispose(this.upstream);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.observers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            InnerDisposable<T>[] r3 = this.observers.get();
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].child.onNext(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r4) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, this, null);
            InnerDisposable<T>[] r3 = this.observers.getAndSet(TERMINATED);
            if (r3.length == 0) goto L7;
            int r0 = r3.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L10;
            r3[r1].child.onError(r4);
            r1 = r1 + 1;
            goto L5
        L10:
            return;
        L7:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, this, null);
            InnerDisposable<T>[] r3 = this.observers.getAndSet(TERMINATED);
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].child.onComplete();
            r1 = r1 + 1;
            goto L3
        }

        boolean add(InnerDisposable<T> r5) {
        L2:
            InnerDisposable<T>[] r0 = this.observers.get();
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerDisposable[] r3 = new InnerDisposable[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.observers, r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        void remove(InnerDisposable<T> r7) {
        L2:
            InnerDisposable<T>[] r0 = this.observers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3].equals(r7) == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            InnerDisposable[] r2 = EMPTY;
        L19:
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.observers, r0, r2) == false) goto L2;
            return;
        L17:
            InnerDisposable[] r5 = new InnerDisposable[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r3);
            System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
            r2 = r5;
            goto L19
        L13:
            return;
        L11:
            r3 = -1;
            goto L12
        }
    }

    static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> curr;

        PublishSource(AtomicReference<PublishObserver<T>> r1) {
            this.curr = r1;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> r4) {
            InnerDisposable r0 = new InnerDisposable(r4);
            r4.onSubscribe(r0);
        L3:
            PublishObserver<T> r5 = this.curr.get();
            if (r5 != null) goto L6;
        L7:
            PublishObserver<T> r1 = new PublishObserver(this.curr);
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.curr, r5, r1) == false) goto L3;
            r5 = r1;
        L12:
            if (r5.add(r0) == false) goto L3;
            r0.setParent(r5);
            return;
        L6:
            if (r5.isDisposed() == false) goto L12;
            goto L7
        }
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> r3) {
        AtomicReference r0 = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservablePublish(new PublishSource(r0), r3, r0));
    }

    private ObservablePublish(ObservableSource<T> r1, ObservableSource<T> r2, AtomicReference<PublishObserver<T>> r3) {
        this.onSubscribe = r1;
        this.source = r2;
        this.current = r3;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public ObservableSource<T> publishSource() {
        return this.source;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r1) {
        this.onSubscribe.subscribe(r1);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> r5) {
    L2:
        PublishObserver<T> r0 = this.current.get();
        if (r0 != null) goto L5;
    L6:
        PublishObserver<T> r1 = new PublishObserver(this.current);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, r0, r1) == false) goto L2;
        r0 = r1;
    L10:
        boolean r2 = false;
        if (r0.shouldConnect.get() == false) goto L13;
    L22:
        r5.accept(r0);     // Catch: Throwable -> L19
        if (r2 == false) goto L27;
        this.source.subscribe(r0);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L13:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L22;
        r2 = true;
        goto L22
    L5:
        if (r0.isDisposed() == false) goto L10;
        goto L6
    }
}
