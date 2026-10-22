package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements j, xi.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xi.b f180707a;

    @Override // xi.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f180707a.d(r100, r101);
    }

    @Override // xi.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f180707a.e(r100, r101, r102);
    }

    @Override // xi.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f180707a.i(r100, r101);
    }

    public n(xi.b r100) {
        Intrinsics.checkNotNullParameter(r100, "logService");
        this.f180707a = r100;
    }
}
