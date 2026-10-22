package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    Disposable upstream;

    public final class a implements MaybeObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaybeFlatten$FlatMapMaybeObserver f20650a;

        public a(MaybeFlatten$FlatMapMaybeObserver r10) {
            this.f20650a = r10;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f20650a.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.f20650a.downstream.onError(r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this.f20650a, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object r10) {
            this.f20650a.downstream.onSuccess(r10);
        }
    }

    public MaybeFlatten$FlatMapMaybeObserver(MaybeObserver<? super R> r10, Function<? super T, ? extends MaybeSource<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
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
        this.downstream.onComplete();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
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
        MaybeSource r11 = (MaybeSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Exception -> L7
        if (isDisposed() == true) goto L12;
        r11.subscribe(new a(this));
        return;
    L12:
        return;
    L7:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(e);
    }
}
