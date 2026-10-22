package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/* JADX INFO: loaded from: classes45.dex */
public interface SingleSubscribeProxy<T> {
    Disposable subscribe();

    Disposable subscribe(Consumer<? super T> r100);

    Disposable subscribe(Consumer<? super T> r100, Consumer<? super Throwable> r101);

    Disposable subscribe(ttc.a<? super T, ? super Throwable> r100);

    void subscribe(SingleObserver<? super T> r100);

    @CheckReturnValue
    <E extends SingleObserver<? super T>> E subscribeWith(E r100);

    @CheckReturnValue
    TestObserver<T> test();

    @CheckReturnValue
    TestObserver<T> test(boolean r100);
}
