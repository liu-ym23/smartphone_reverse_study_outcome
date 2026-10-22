package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -2223459372976438024L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<? extends T> other;

    public static final class a implements MaybeObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MaybeObserver f20653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f20654b;

        public a(MaybeObserver r10, AtomicReference r11) {
            this.f20653a = r10;
            this.f20654b = r11;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f20653a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.f20653a.onError(r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this.f20654b, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object r10) {
            this.f20653a.onSuccess(r10);
        }
    }

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> r10, MaybeSource<? extends T> r11) {
        this.downstream = r10;
        this.other = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        Disposable r10 = get();
        if (r10 != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (compareAndSet(r10, null) == false) goto L9;
        this.other.subscribe(new a(this.downstream, this));
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }
}
