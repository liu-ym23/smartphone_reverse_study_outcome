package com.bytedance.android.live.core.utils.rxutils;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements CommonTransformer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q80.a f66354a = null;

    public h() {
    }

    static {
        f66354a = new q80.a(new Handler(Looper.getMainLooper()), true);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.d
    public final CompletableSource apply(Completable r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(f66354a);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.n
    public final MaybeSource<T> apply(Maybe<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(f66354a);
    }

    @Override // io.reactivex.ObservableTransformer
    public final ObservableSource<T> apply(Observable<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(f66354a);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.t
    public final SingleSource<T> apply(Single<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(f66354a);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.h
    public final Publisher<T> apply(Flowable<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(f66354a);
    }
}
