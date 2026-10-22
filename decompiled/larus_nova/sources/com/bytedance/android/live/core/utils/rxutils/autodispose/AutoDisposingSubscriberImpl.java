package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes45.dex */
final class AutoDisposingSubscriberImpl<T> extends AtomicInteger implements io.reactivex.g, wwc.c, Disposable {
    private final wwc.b<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<wwc.c> mainSubscription;
    private final AtomicReference<wwc.c> ref;
    private final AtomicLong requested;
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable;

    public class a extends io.reactivex.observers.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AutoDisposingSubscriberImpl f66295b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f66295b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoSubscriptionHelper.cancel(this.f66295b.mainSubscription);
        }

        public a(AutoDisposingSubscriberImpl r100) {
            this.f66295b = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f66295b.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            this.f66295b.onError(r100);
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
        wwc.b<? super T> r100 = this.delegate;
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

    public wwc.b<? super T> delegateSubscriber() {
        return this.delegate;
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
        wwc.b<? super T> r101 = this.delegate;
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
        wwc.b<? super T> r101 = this.delegate;
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
    public void onSubscribe(wwc.c r100) {
        a r101 = new a(this);
        if (l.b(this.scopeDisposable, r101, AutoDisposingSubscriberImpl.class) == false) goto L22;
        this.delegate.onSubscribe(this);
        this.scope.subscribe(r101);
        AtomicReference<wwc.c> r102 = this.mainSubscription;
        q.a(r100, "next is null");
    L5:
        boolean r103 = false;
        if (r102.compareAndSet(null, r100) == true) goto L7;
        if (r102.get() == null) goto L5;
        boolean r104 = false;
    L11:
        if (r104 == true) goto L15;
        r100.cancel();
        if (r102.get() == AutoSubscriptionHelper.CANCELLED) goto L16;
        l.a(AutoDisposingSubscriberImpl.class);
    L16:
        if (r103 == false) goto L23;
        AutoSubscriptionHelper.deferredSetOnce(this.ref, this.requested, r100);
        return;
    L23:
        return;
    L15:
        r103 = true;
        goto L16
    L7:
        r104 = true;
        goto L11
    }

    @Override // wwc.c
    public void request(long r100) {
        AutoSubscriptionHelper.deferredRequest(this.ref, this.requested, r100);
    }

    public AutoDisposingSubscriberImpl(CompletableSource r100, wwc.b<? super T> r101) {
        this.mainSubscription = new AtomicReference();
        this.scopeDisposable = new AtomicReference();
        this.error = new AtomicThrowable();
        this.ref = new AtomicReference();
        this.requested = new AtomicLong();
        this.scope = r100;
        this.delegate = r101;
    }
}
