package com.bytedance.android.shopping.store.home.frame.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.home.presenter.preview.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final void a(ShopContainerType r100, vi3.c r101) {
        Intrinsics.checkNotNullParameter(r100, "containerType");
        Intrinsics.checkNotNullParameter(r101, "config");
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final void b(ShopContainerType r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final View c(ShopContainerType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return null;
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final vi3.c d(ShopContainerType r100) {
        Intrinsics.checkNotNullParameter(r100, "containerType");
        return null;
    }
}
