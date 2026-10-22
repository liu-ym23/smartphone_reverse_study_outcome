package com.bytedance.android.window.shop.holder;

import android.view.View;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowProductEmptyNoticeHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/z;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductEmptyNoticeHolder extends ShopWindowItemHolder<z> {
    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowProductEmptyNoticeHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r100) {
        Intrinsics.checkNotNullParameter((z) r100, "vo");
    }
}
