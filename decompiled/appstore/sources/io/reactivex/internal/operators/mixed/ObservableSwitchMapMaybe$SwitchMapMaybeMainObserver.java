package io.reactivex.internal.operators.mixed;

import androidx.lifecycle.p;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = null;
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapMaybeObserver<R>> inner;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    Disposable upstream;

    public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> parent;

        public SwitchMapMaybeObserver(ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> r10) {
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.parent.innerError(this, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(R r10) {
            this.item = r10;
            this.parent.drain();
        }
    }

    static {
        INNER_DISPOSED = new SwitchMapMaybeObserver(null);
    }

    public ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(Observer<? super R> r10, Function<? super T, ? extends MaybeSource<? extends R>> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.inner = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
    }

    public void disposeInner() {
        AtomicReference<SwitchMapMaybeObserver<R>> r10 = this.inner;
        SwitchMapMaybeObserver<Object> r11 = INNER_DISPOSED;
        SwitchMapMaybeObserver<R> r12 = r10.getAndSet((SwitchMapMaybeObserver<R>) r11);
        if (r12 == null) goto L7;
        if (r12 == r11) goto L8;
        r12.dispose();
        return;
    L8:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super R> r10 = this.downstream;
        AtomicThrowable r11 = this.errors;
        AtomicReference<SwitchMapMaybeObserver<R>> r12 = this.inner;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r11.get() != null) goto L12;
    L15:
        boolean r14 = this.done;
        SwitchMapMaybeObserver<R> r15 = r12.get();
        if (r15 != null) goto L18;
        boolean r16 = true;
    L19:
        if (r14 == false) goto L26;
        if (r16 == false) goto L26;
        Throwable r17 = r11.terminate();
        if (r17 == null) goto L24;
        r10.onError(r17);
        return;
    L24:
        r10.onComplete();
        return;
    L26:
        if (r16 == true) goto L31;
        if (r15.item == null) goto L31;
        p.a(r12, r15, null);
        r10.onNext(r15.item);
    L31:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L18:
        r16 = false;
        goto L19
    L12:
        if (this.delayErrors == true) goto L15;
        r10.onError(r11.terminate());
        return;
    }

    public void innerComplete(SwitchMapMaybeObserver<R> r10) {
        if (p.a(this.inner, r10, null) == false) goto L6;
        drain();
        return;
    }

    public void innerError(SwitchMapMaybeObserver<R> r10, Throwable r11) {
        if (p.a(this.inner, r10, null) == true) goto L5;
    L11:
        a.e(r11);
        return;
    L5:
        if (this.errors.addThrowable(r11) == false) goto L11;
        if (this.delayErrors == true) goto L9;
        this.upstream.dispose();
        disposeInner();
    L9:
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        a.e(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        disposeInner();
    L7:
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        SwitchMapMaybeObserver<R> r11 = this.inner.get();
        if (r11 == null) goto L17;
        r11.dispose();
    L17:
        MaybeSource r12 = (MaybeSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L14
        SwitchMapMaybeObserver r13 = new SwitchMapMaybeObserver(this);
    L7:
        SwitchMapMaybeObserver<R> r14 = this.inner.get();
        if (r14 == INNER_DISPOSED) goto L22;
        if (p.a(this.inner, r14, r13) == false) goto L7;
        r12.subscribe(r13);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
