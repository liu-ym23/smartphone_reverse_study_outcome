package com.bytedance.android.gamecp.common.utils.rx.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.g;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes44.dex */
final class AutoDisposingSubscriberImpl<T> extends AtomicInteger implements g, c, Disposable {
    private final b<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<c> mainSubscription;
    private final AtomicReference<c> ref;
    private final AtomicLong requested;
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable;

    public class a extends io.reactivex.observers.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AutoDisposingSubscriberImpl f57281b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f57281b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoSubscriptionHelper.cancel(this.f57281b.mainSubscription);
        }

        public a(AutoDisposingSubscriberImpl r100) {
            this.f57281b = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f57281b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            this.f57281b.onError(r100);
        }
    }

    @Override // wwc.c
    public void cancel() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoSubscriptionHelper.cancel(this.mainSubscription);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.mainSubscription.get() != AutoSubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // wwc.b
    public void onComplete() {
        if (isDisposed() == true) goto L11;
        this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        b<? super T> r100 = this.delegate;
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

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        if (isDisposed() == true) goto L11;
        this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        b<? super T> r101 = this.delegate;
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

    @Override // wwc.b
    public void onNext(T r100) {
        if (isDisposed() == true) goto L18;
        b<? super T> r101 = this.delegate;
        AtomicThrowable r102 = this.error;
        boolean r103 = false;
        if (get() == 0) goto L7;
    L15:
        if (r103 == false) goto L19;
        this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
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

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        a r101 = new a(this);
        if (com.bytedance.android.gamecp.common.utils.rx.autodispose.a.b(this.scopeDisposable, r101, AutoDisposingSubscriberImpl.class) == false) goto L21;
        this.delegate.onSubscribe(this);
        this.scope.subscribe(r101);
        AtomicReference<c> r102 = this.mainSubscription;
        if (r100 == null) goto L20;
    L6:
        boolean r103 = false;
        if (r102.compareAndSet(null, r100) == true) goto L8;
        if (r102.get() == null) goto L6;
        boolean r104 = false;
    L12:
        if (r104 == true) goto L16;
        r100.cancel();
        if (r102.get() == AutoSubscriptionHelper.CANCELLED) goto L17;
        com.bytedance.android.gamecp.common.utils.rx.autodispose.a.a(AutoDisposingSubscriberImpl.class);
    L17:
        if (r103 == false) goto L25;
        AutoSubscriptionHelper.deferredSetOnce(this.ref, this.requested, r100);
        return;
    L25:
        return;
    L16:
        r103 = true;
        goto L17
    L8:
        r104 = true;
        goto L12
    L20:
        throw new NullPointerException("next is null");
    }

    @Override // wwc.c
    public void request(long r100) {
        AutoSubscriptionHelper.deferredRequest(this.ref, this.requested, r100);
    }

    public AutoDisposingSubscriberImpl(CompletableSource r100, b<? super T> r101) {
        this.mainSubscription = new AtomicReference();
        this.scopeDisposable = new AtomicReference();
        this.error = new AtomicThrowable();
        this.ref = new AtomicReference();
        this.requested = new AtomicLong();
        this.scope = r100;
        this.delegate = r101;
    }
}
