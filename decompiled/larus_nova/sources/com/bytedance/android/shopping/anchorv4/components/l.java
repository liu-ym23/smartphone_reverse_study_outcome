package com.bytedance.android.shopping.anchorv4.components;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements SingleObserver<com.bytedance.android.shopping.api.mall.feed.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GulComponent f166103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f166104b;

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        com.bytedance.android.shopping.utils.z.a("gul preload error", r100, null);
        this.f166104b.invoke();
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(com.bytedance.android.shopping.api.mall.feed.d r100) {
        com.bytedance.android.shopping.api.mall.feed.d r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        GulComponent r102 = this.f166103a;
        if (r102.f165959d != null) goto L5;
        r102.f165959d = r101;
    L5:
        this.f166104b.invoke();
    }

    public l(GulComponent r100, Function0 r101) {
        this.f166103a = r100;
        this.f166104b = r101;
    }
}
