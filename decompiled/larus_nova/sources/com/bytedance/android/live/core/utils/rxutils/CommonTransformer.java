package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes45.dex */
public interface CommonTransformer<T> extends ObservableTransformer<T, T>, io.reactivex.t<T, T>, io.reactivex.n<T, T>, io.reactivex.h<T, T>, io.reactivex.d {
    @Override // io.reactivex.d
    /* synthetic */ CompletableSource apply(Completable r100);

    @Override // io.reactivex.n
    /* synthetic */ MaybeSource apply(Maybe r100);

    @Override // io.reactivex.t
    /* synthetic */ SingleSource apply(Single r100);

    @Override // io.reactivex.h
    /* synthetic */ Publisher apply(Flowable r100);
}
