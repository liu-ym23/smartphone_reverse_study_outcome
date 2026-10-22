package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClickTabItem;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "tabIndex", "", "pageType", "isFromGuide", "", "(IIZ)V", "()Z", "getPageType", "()I", "getTabIndex", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickTabItem extends GiftUIAction {
    private final boolean isFromGuide;
    private final int pageType;
    private final int tabIndex;

    public final int getPageType() {
        return this.pageType;
    }

    public final int getTabIndex() {
        return this.tabIndex;
    }

    public final boolean isFromGuide() {
        return this.isFromGuide;
    }

    public ClickTabItem(int r100, int r101, boolean r102) {
        super(false, "ClickTabItem", 1, null);
        this.tabIndex = r100;
        this.pageType = r101;
        this.isFromGuide = r102;
    }

    public /* synthetic */ ClickTabItem(int r100, int r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this(r100, r101, r102);
    }
}
