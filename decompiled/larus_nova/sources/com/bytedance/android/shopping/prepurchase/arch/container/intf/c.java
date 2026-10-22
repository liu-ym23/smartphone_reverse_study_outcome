package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements xi.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Biz f180788a;

    public c(Biz r100) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        this.f180788a = r100;
    }

    @Override // xi.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a(this.f180788a.getValue() + '_' + r100).a(r101);
    }

    @Override // xi.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a(this.f180788a.getValue() + '_' + r100).i(r101);
    }

    @Override // xi.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        dm.a.b r103 = dm.a.f469202a;
        dm.a.a(this.f180788a.getValue() + '_' + r100).b(r101, r102);
    }
}
