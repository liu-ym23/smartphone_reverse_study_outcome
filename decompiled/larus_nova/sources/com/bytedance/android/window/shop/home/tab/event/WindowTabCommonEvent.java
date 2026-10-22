package com.bytedance.android.window.shop.home.tab.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/event/WindowTabCommonEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "eventName", "", "itemType", "", "(Ljava/lang/String;I)V", "authorId", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "getItemType", "()I", "setItemType", "(I)V", "storeType", "getStoreType", "subTabId", "getSubTabId", "setSubTabId", "tabId", "getTabId", "setTabId", "tabName", "getTabName", "setTabName", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WindowTabCommonEvent extends BaseMetricsEvent2 {

    @EventKey("author_id")
    private String authorId;

    @EventKey("window_item_type")
    private int itemType;

    @EventKey(a.KEY_STORE_TYPE)
    private final String storeType;

    @EventKey("classification_sub_tab_id")
    private String subTabId;

    @EventKey("classification_tab_id")
    private String tabId;

    @EventKey("classification_tab")
    private String tabName;

    public final String getAuthorId() {
        return this.authorId;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final String getStoreType() {
        return this.storeType;
    }

    public final String getSubTabId() {
        return this.subTabId;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setItemType(int r100) {
        this.itemType = r100;
    }

    public final void setSubTabId(String r100) {
        this.subTabId = r100;
    }

    public final void setTabId(String r100) {
        this.tabId = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public WindowTabCommonEvent(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.itemType = r101;
        this.storeType = LiveEndPageData.TAG_WINDOW;
    }
}
