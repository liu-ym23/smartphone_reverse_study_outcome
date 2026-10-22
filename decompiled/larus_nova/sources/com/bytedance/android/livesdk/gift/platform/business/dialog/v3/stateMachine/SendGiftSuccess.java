package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SendGiftSuccess;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelEffect;", "giftId", "", "sendCount", "(JJ)V", "getGiftId", "()J", "getSendCount", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SendGiftSuccess implements GiftPanelEffect {
    private final long giftId;
    private final long sendCount;

    public final long getGiftId() {
        return this.giftId;
    }

    public final long getSendCount() {
        return this.sendCount;
    }

    public SendGiftSuccess(long r100, long r101) {
        this.giftId = r100;
        this.sendCount = r101;
    }
}
