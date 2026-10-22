package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 3258103020495908596L;
    final SingleObserver<? super R> downstream;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    public static final class a implements SingleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference f20700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SingleObserver f20701b;

        public a(AtomicReference r10, SingleObserver r11) {
            this.f20700a = r10;
            this.f20701b = r11;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            this.f20701b.onError(r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this.f20700a, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object r10) {
            this.f20701b.onSuccess(r10);
        }
    }

    public SingleFlatMap$SingleFlatMapCallback(SingleObserver<? super R> r10, Function<? super T, ? extends SingleSource<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        SingleSource r11 = (SingleSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The single returned by the mapper is null");     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        r11.subscribe(new a(this, this.downstream));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }
}
