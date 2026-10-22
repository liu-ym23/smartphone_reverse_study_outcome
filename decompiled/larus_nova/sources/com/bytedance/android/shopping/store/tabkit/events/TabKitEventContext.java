package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.event.eventdumper.EventParamProvider;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "Lcom/bytedance/android/ec/core/event/BaseEventContext;", "tabKitViewModel", "Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "(Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;)V", "pageType", "", "getPageType", "()Ljava/lang/String;", "getTabKitViewModel", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitEventContext extends BaseEventContext {
    private final TabKitViewModel tabKitViewModel;

    @EventParamProvider("page_type")
    public final String getPageType() {
        Integer r100 = this.tabKitViewModel.getScreenState().getValue();
        if (r100 != null) goto L6;
    L8:
        return "brand_channel_half";
    L6:
        if (r100.intValue() != 0) goto L8;
        return "brand_channel_all";
    }

    public final TabKitViewModel getTabKitViewModel() {
        return this.tabKitViewModel;
    }

    public TabKitEventContext(TabKitViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "tabKitViewModel");
        this.tabKitViewModel = r100;
    }
}
