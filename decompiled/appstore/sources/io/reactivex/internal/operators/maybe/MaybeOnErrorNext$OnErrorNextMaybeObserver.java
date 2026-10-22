package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 2026620218879969836L;
    final boolean allowFatal;
    final MaybeObserver<? super T> downstream;
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

    public static final class a implements MaybeObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MaybeObserver f20651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f20652b;

        public a(MaybeObserver r10, AtomicReference r11) {
            this.f20651a = r10;
            this.f20652b = r11;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f20651a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.f20651a.onError(r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this.f20652b, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object r10) {
            this.f20651a.onSuccess(r10);
        }
    }

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(MaybeObserver<? super T> r10, Function<? super Throwable, ? extends MaybeSource<? extends T>> r11, boolean r12) {
        this.downstream = r10;
        this.resumeFunction = r11;
        this.allowFatal = r12;
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
        this.downstream.onComplete();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        if (this.allowFatal == false) goto L5;
    L14:
        MaybeSource r11 = (MaybeSource) io.reactivex.internal.functions.a.b(this.resumeFunction.apply(r10), "The resumeFunction returned a null MaybeSource");     // Catch: Throwable -> L11
        DisposableHelper.replace(this, null);
        r11.subscribe(new a(this.downstream, this));
        return;
    L11:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L5:
        if ((r10 instanceof Exception) == true) goto L14;
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
