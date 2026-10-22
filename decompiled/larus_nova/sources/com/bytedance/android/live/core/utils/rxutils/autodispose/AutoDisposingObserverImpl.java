package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes45.dex */
final class AutoDisposingObserverImpl<T> extends AtomicInteger implements Observer, Disposable {
    private final Observer<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable;

    public class a extends io.reactivex.observers.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AutoDisposingObserverImpl f66294b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f66294b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.f66294b.mainDisposable);
        }

        public a(AutoDisposingObserverImpl r100) {
            this.f66294b = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f66294b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            this.f66294b.onError(r100);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoDisposableHelper.dispose(this.mainDisposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.mainDisposable.get() != AutoDisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (isDisposed() == true) goto L11;
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        Observer<? super T> r100 = this.delegate;
        AtomicThrowable r101 = this.error;
        if (getAndIncrement() != 0) goto L12;
        Throwable r102 = r101.terminate();
        if (r102 == null) goto L9;
        r100.onError(r102);
        return;
    L9:
        r100.onComplete();
        return;
    L12:
        return;
    }

    public Observer<? super T> delegateObserver() {
        return this.delegate;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        if (isDisposed() == true) goto L11;
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        Observer<? super T> r101 = this.delegate;
        AtomicThrowable r102 = this.error;
        if (r102.addThrowable(r100) == true) goto L7;
        RxJavaPlugins.onError(r100);
        return;
    L7:
        if (getAndIncrement() != 0) goto L12;
        r101.onError(r102.terminate());
        return;
    L12:
        return;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        if (isDisposed() == true) goto L18;
        Observer<? super T> r101 = this.delegate;
        AtomicThrowable r102 = this.error;
        boolean r103 = false;
        if (get() == 0) goto L7;
    L15:
        if (r103 == false) goto L19;
        this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        return;
    L19:
        return;
    L7:
        if (compareAndSet(0, 1) == false) goto L15;
        r101.onNext(r100);
        if (decrementAndGet() == 0) goto L15;
        Throwable r104 = r102.terminate();
        if (r104 == null) goto L13;
        r101.onError(r104);
    L14:
        r103 = true;
        goto L15
    L13:
        r101.onComplete();
        goto L14
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        a r101 = new a(this);
        if (l.b(this.scopeDisposable, r101, AutoDisposingObserverImpl.class) == false) goto L6;
        this.delegate.onSubscribe(this);
        this.scope.subscribe(r101);
        l.b(this.mainDisposable, r100, AutoDisposingObserverImpl.class);
        return;
    }

    public AutoDisposingObserverImpl(CompletableSource r100, Observer<? super T> r101) {
        this.mainDisposable = new AtomicReference();
        this.scopeDisposable = new AtomicReference();
        this.error = new AtomicThrowable();
        this.scope = r100;
        this.delegate = r101;
    }
}
