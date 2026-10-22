package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@TraceExclude
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/EndScrollGiftVerticalPanel;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pagerPosition", "", "(I)V", "getPagerPosition", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EndScrollGiftVerticalPanel extends GiftUIAction {
    private final int pagerPosition;

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public EndScrollGiftVerticalPanel(int r100) {
        super(false, "EndScrollGiftVerticalPanel", 1, null);
        this.pagerPosition = r100;
    }
}
