package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class PropertyOwner<T> extends c<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f64752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<T, T, T> f64753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<T> f64754c;

    public PropertyOwner() {
        throw null;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f64754c.onComplete();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f64754c.onError(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f64754c.onSubscribe(r100);
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.d
    public final T getValue() {
        return this.f64752a;
    }

    public /* synthetic */ PropertyOwner(Object r100) {
        this(r100, AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.c
    public final void a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        T r101 = this.f64753b.invoke(this.f64752a, r100);
        if (r101 == null) goto L6;
        this.f64752a = r101;
        this.f64754c.onNext(r101);
        return;
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        a(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f64754c.subscribe(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PropertyOwner(T r100, Function2<? super T, ? super T, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "initialValue");
        Intrinsics.checkNotNullParameter(r101, "onChange");
        PublishSubject<T> r102 = PublishSubject.create();
        this.f64753b = r101;
        this.f64754c = r102;
        this.f64752a = r100;
    }
}
