package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j extends a {
    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.a
    public final Integer D() {
        return -1;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.a
    public final int E() {
        return ExtensionsKt.a(16);
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.a
    public final int F() {
        return ExtensionsKt.a(54);
    }

    public j(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }
}
