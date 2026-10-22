package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements xi.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180803a;

    public m(final Biz r100, final c r101) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "fallback");
        this.f180803a = LazyKt.lazy(new SplitAlogService$base$2(r100, r101));
    }

    @Override // xi.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((xi.b) this.f180803a.getValue()).d(r100, r101);
    }

    @Override // xi.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((xi.b) this.f180803a.getValue()).i(r100, r101);
    }

    @Override // xi.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ((xi.b) this.f180803a.getValue()).e(r100, r101, r102);
    }
}
