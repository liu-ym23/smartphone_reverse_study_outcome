package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/* JADX INFO: loaded from: classes45.dex */
public interface MaybeSubscribeProxy<T> {
    Disposable subscribe();

    Disposable subscribe(Consumer<? super T> r100);

    Disposable subscribe(Consumer<? super T> r100, Consumer<? super Throwable> r101);

    Disposable subscribe(Consumer<? super T> r100, Consumer<? super Throwable> r101, Action r102);

    void subscribe(io.reactivex.k<? super T> r100);

    @CheckReturnValue
    <E extends io.reactivex.k<? super T>> E subscribeWith(E r100);

    @CheckReturnValue
    TestObserver<T> test();

    @CheckReturnValue
    TestObserver<T> test(boolean r100);
}
