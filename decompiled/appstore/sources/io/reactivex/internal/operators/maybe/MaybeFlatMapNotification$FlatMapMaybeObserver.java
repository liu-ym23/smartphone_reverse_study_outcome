package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeFlatMapNotification$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    final MaybeObserver<? super R> downstream;
    final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
    Disposable upstream;

    public final class a implements MaybeObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaybeFlatMapNotification$FlatMapMaybeObserver f20649a;

        public a(MaybeFlatMapNotification$FlatMapMaybeObserver r10) {
            this.f20649a = r10;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f20649a.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.f20649a.downstream.onError(r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this.f20649a, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object r10) {
            this.f20649a.downstream.onSuccess(r10);
        }
    }

    public MaybeFlatMapNotification$FlatMapMaybeObserver(MaybeObserver<? super R> r10, Function<? super T, ? extends MaybeSource<? extends R>> r11, Function<? super Throwable, ? extends MaybeSource<? extends R>> r12, Callable<? extends MaybeSource<? extends R>> r13) {
        this.downstream = r10;
        this.onSuccessMapper = r11;
        this.onErrorMapper = r12;
        this.onCompleteSupplier = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        MaybeSource r10 = (MaybeSource) io.reactivex.internal.functions.a.b(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource");     // Catch: Exception -> L5
        r10.subscribe(new a(this));
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(e);
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        ((MaybeSource) io.reactivex.internal.functions.a.b(this.onErrorMapper.apply(r10), "The onErrorMapper returned a null MaybeSource")).subscribe(new a(this));
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, e}));
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        MaybeSource r11 = (MaybeSource) io.reactivex.internal.functions.a.b(this.onSuccessMapper.apply(r10), "The onSuccessMapper returned a null MaybeSource");     // Catch: Exception -> L5
        r11.subscribe(new a(this));
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(e);
    }
}
