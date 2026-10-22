package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    final boolean delayErrors;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final io.reactivex.disposables.a set;
    Disposable upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 8606673141535671828L;
        final /* synthetic */ ObservableFlatMapCompletable$FlatMapCompletableMainObserver this$0;

        public InnerObserver(ObservableFlatMapCompletable$FlatMapCompletableMainObserver r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public ObservableFlatMapCompletable$FlatMapCompletableMainObserver(Observer<? super T> r10, Function<? super T, ? extends CompletableSource> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.set = new io.reactivex.disposables.a();
        lazySet(1);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver r10) {
        this.set.delete(r10);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver r10, Throwable r11) {
        this.set.delete(r10);
        onError(r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (decrementAndGet() != 0) goto L9;
        Throwable r10 = this.errors.terminate();
        if (r10 == null) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        dispose();
        if (getAndSet(0) <= 0) goto L16;
        Throwable r11 = this.errors.terminate();
        this.downstream.onError(r11);
        return;
    L16:
        return;
    L7:
        if (decrementAndGet() != 0) goto L14;
        Throwable r12 = this.errors.terminate();
        this.downstream.onError(r12);
        return;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        CompletableSource r11 = (CompletableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
        getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.disposed == false) goto L6;
        return;
    L6:
        if (this.set.add(r12) == false) goto L15;
        r11.subscribe(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        return r10 & 2;
    }
}
