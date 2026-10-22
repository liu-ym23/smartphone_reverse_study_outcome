package com.bytedance.android.live.openplatform.impl.base.utils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f84041a;

    public final void b() {
        this.f84041a.clear();
    }

    public a() {
        this.f84041a = new CompositeDisposable();
    }

    public final void a(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f84041a.add(r100);
    }

    public final void c(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f84041a.remove(r100);
    }
}
