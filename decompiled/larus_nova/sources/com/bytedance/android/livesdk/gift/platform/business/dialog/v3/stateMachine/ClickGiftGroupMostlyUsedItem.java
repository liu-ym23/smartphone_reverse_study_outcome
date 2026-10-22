package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClickGiftGroupMostlyUsedItem;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "isCurMostlyUsed", "", "(Z)V", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickGiftGroupMostlyUsedItem extends GiftUIAction {
    private final boolean isCurMostlyUsed;

    public final boolean isCurMostlyUsed() {
        return this.isCurMostlyUsed;
    }

    public ClickGiftGroupMostlyUsedItem(boolean r100) {
        super(false, "ClickGroupMostlyUsedItem", 1, null);
        this.isCurMostlyUsed = r100;
    }
}
