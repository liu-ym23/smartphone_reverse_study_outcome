package com.bytedance.android.ec.core.async;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class DisposableScope implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f43901a;

    public final CompositeDisposable a() {
        return (CompositeDisposable) this.f43901a.getValue();
    }

    public DisposableScope() {
        this.f43901a = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void clearDisposable() {
        a().clear();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final CompositeDisposable compositeDisposable() {
        return a();
    }

    @Override // com.bytedance.android.ec.core.async.b, fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        a().add(r100);
        return r100;
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        a().remove(r100);
    }
}
