package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClickLynxSeriesCard;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "giftID", "", "(J)V", "getGiftID", "()J", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickLynxSeriesCard extends GiftUIAction {
    private final long giftID;

    public final long getGiftID() {
        return this.giftID;
    }

    public ClickLynxSeriesCard(long r100) {
        super(false, "ClickLynxSeriesCard", 1, null);
        this.giftID = r100;
    }
}
