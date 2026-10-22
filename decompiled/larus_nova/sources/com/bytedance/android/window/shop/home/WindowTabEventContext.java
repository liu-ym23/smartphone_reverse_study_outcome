package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.event.eventdumper.EventParamProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/home/WindowTabEventContext;", "Lcom/bytedance/android/ec/core/event/BaseEventContext;", "viewModel", "Lcom/bytedance/android/window/shop/home/BaseWindowTabViewModel;", "(Lcom/bytedance/android/window/shop/home/BaseWindowTabViewModel;)V", "subTabId", "", "getSubTabId", "()Ljava/lang/String;", "tabId", "getTabId", "tabName", "getTabName", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabEventContext extends BaseEventContext {
    private final BaseWindowTabViewModel viewModel;

    @EventParamProvider("classification_sub_tab_id")
    public final String getSubTabId() {
        return this.viewModel.getLastSubCategoryId();
    }

    @EventParamProvider("classification_tab_id")
    public final String getTabId() {
        return this.viewModel.getLastCategoryId();
    }

    @EventParamProvider("classification_tab")
    public final String getTabName() {
        String r100 = this.viewModel.getCategoryName();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public WindowTabEventContext(BaseWindowTabViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.viewModel = r100;
    }
}
