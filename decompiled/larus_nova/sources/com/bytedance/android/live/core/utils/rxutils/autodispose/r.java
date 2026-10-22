package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements io.reactivex.b, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f66321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Disposable> f66322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompletableSource f66323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.reactivex.b f66324d;

    public class a extends io.reactivex.observers.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f66325b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f66325b.f66322b.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.f66325b.f66321a);
        }

        public a(r r100) {
            this.f66325b = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f66325b.f66322b.lazySet(AutoDisposableHelper.DISPOSED);
            this.f66325b.onError(r100);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AutoDisposableHelper.dispose(this.f66322b);
        AutoDisposableHelper.dispose(this.f66321a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f66321a.get() != AutoDisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.b
    public final void onComplete() {
        if (isDisposed() == true) goto L6;
        this.f66321a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66322b);
        this.f66324d.onComplete();
        return;
    }

    @Override // io.reactivex.b
    public final void onError(Throwable r100) {
        if (isDisposed() == true) goto L6;
        this.f66321a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66322b);
        this.f66324d.onError(r100);
        return;
    }

    @Override // io.reactivex.b
    public final void onSubscribe(Disposable r100) {
        a r101 = new a(this);
        if (l.b(this.f66322b, r101, r.class) == false) goto L6;
        this.f66324d.onSubscribe(this);
        this.f66323c.subscribe(r101);
        l.b(this.f66321a, r100, r.class);
        return;
    }

    public r(CompletableSource r100, io.reactivex.b r101) {
        this.f66321a = new AtomicReference();
        this.f66322b = new AtomicReference();
        this.f66323c = r100;
        this.f66324d = r101;
    }
}
