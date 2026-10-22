package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: classes45.dex */
public interface AutoDisposeConverter<T> extends io.reactivex.e<T, v<T>>, io.reactivex.p<T, ObservableSubscribeProxy<T>>, io.reactivex.i<T, MaybeSubscribeProxy<T>>, io.reactivex.r<T, SingleSubscribeProxy<T>>, io.reactivex.a<u> {
    /* synthetic */ Object apply(Completable r100);

    @Override // io.reactivex.e
    /* synthetic */ Object apply(Flowable r100);

    /* synthetic */ Object apply(Maybe r100);

    /* synthetic */ Object apply(Observable r100);

    /* synthetic */ Object apply(Single r100);

    /* synthetic */ Object apply(wtc.a r100);
}
