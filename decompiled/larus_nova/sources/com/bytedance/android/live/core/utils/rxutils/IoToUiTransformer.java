package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes45.dex */
public class IoToUiTransformer<T> implements CommonTransformer<T> {
    public IoToUiTransformer() {
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.d
    public CompletableSource apply(Completable r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.n
    public MaybeSource<T> apply(Maybe<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.t
    public SingleSource<T> apply(Single<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.CommonTransformer, io.reactivex.h
    public Publisher<T> apply(Flowable<T> r100) {
        return r100.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
