package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes45.dex */
public final class s<T> implements io.reactivex.k, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f66326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Disposable> f66327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompletableSource f66328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.reactivex.k<? super T> f66329d;

    public class a extends io.reactivex.observers.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f66330b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f66330b.f66327b.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.f66330b.f66326a);
        }

        public a(s r100) {
            this.f66330b = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f66330b.f66327b.lazySet(AutoDisposableHelper.DISPOSED);
            this.f66330b.onError(r100);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AutoDisposableHelper.dispose(this.f66327b);
        AutoDisposableHelper.dispose(this.f66326a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f66326a.get() != AutoDisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.k
    public final void onComplete() {
        if (isDisposed() == true) goto L6;
        this.f66326a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66327b);
        this.f66329d.onComplete();
        return;
    }

    @Override // io.reactivex.k
    public final void onError(Throwable r100) {
        if (isDisposed() == true) goto L6;
        this.f66326a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66327b);
        this.f66329d.onError(r100);
        return;
    }

    @Override // io.reactivex.k
    public final void onSubscribe(Disposable r100) {
        a r101 = new a(this);
        if (l.b(this.f66327b, r101, s.class) == false) goto L6;
        this.f66329d.onSubscribe(this);
        this.f66328c.subscribe(r101);
        l.b(this.f66326a, r100, s.class);
        return;
    }

    @Override // io.reactivex.k
    public final void onSuccess(T r100) {
        if (isDisposed() == true) goto L6;
        this.f66326a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66327b);
        this.f66329d.onSuccess(r100);
        return;
    }

    public s(CompletableSource r100, io.reactivex.k<? super T> r101) {
        this.f66326a = new AtomicReference();
        this.f66327b = new AtomicReference();
        this.f66328c = r100;
        this.f66329d = r101;
    }
}
