package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes45.dex */
public final class t<T> implements SingleObserver, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f66331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Disposable> f66332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompletableSource f66333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SingleObserver<? super T> f66334d;

    public class a extends io.reactivex.observers.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f66335b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f66335b.f66332b.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.f66335b.f66331a);
        }

        public a(t r100) {
            this.f66335b = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f66335b.f66332b.lazySet(AutoDisposableHelper.DISPOSED);
            this.f66335b.onError(r100);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AutoDisposableHelper.dispose(this.f66332b);
        AutoDisposableHelper.dispose(this.f66331a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f66331a.get() != AutoDisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        if (isDisposed() == true) goto L6;
        this.f66331a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66332b);
        this.f66334d.onError(r100);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        a r101 = new a(this);
        if (l.b(this.f66332b, r101, t.class) == false) goto L6;
        this.f66334d.onSubscribe(this);
        this.f66333c.subscribe(r101);
        l.b(this.f66331a, r100, t.class);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
        if (isDisposed() == true) goto L6;
        this.f66331a.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.f66332b);
        this.f66334d.onSuccess(r100);
        return;
    }

    public t(CompletableSource r100, SingleObserver<? super T> r101) {
        this.f66331a = new AtomicReference();
        this.f66332b = new AtomicReference();
        this.f66333c = r100;
        this.f66334d = r101;
    }
}
