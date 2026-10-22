package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/* JADX INFO: loaded from: classes45.dex */
public interface ObservableSubscribeProxy<T> {
    Disposable subscribe();

    Disposable subscribe(Consumer<? super T> r100);

    Disposable subscribe(Consumer<? super T> r100, Consumer<? super Throwable> r101);

    Disposable subscribe(Consumer<? super T> r100, Consumer<? super Throwable> r101, Action r102);

    Disposable subscribe(Consumer<? super T> r100, Consumer<? super Throwable> r101, Action r102, Consumer<? super Disposable> r103);

    void subscribe(Observer<? super T> r100);

    @CheckReturnValue
    <E extends Observer<? super T>> E subscribeWith(E r100);

    @CheckReturnValue
    TestObserver<T> test();

    @CheckReturnValue
    TestObserver<T> test(boolean r100);
}
