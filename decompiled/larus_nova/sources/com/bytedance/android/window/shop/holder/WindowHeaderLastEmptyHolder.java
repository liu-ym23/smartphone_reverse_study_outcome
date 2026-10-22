package com.bytedance.android.window.shop.holder;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.presenter.t;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHeaderLastEmptyHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Loq3/e;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderLastEmptyHolder extends ShopWindowGenericHolder<oq3.e> {
    public WindowHeaderLastEmptyHolder(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100, new View(r100.getContext()));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return new t(r100);
    }
}
