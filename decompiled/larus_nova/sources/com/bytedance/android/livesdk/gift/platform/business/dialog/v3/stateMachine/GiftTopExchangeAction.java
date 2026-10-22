package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopExchangeAction;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "hideCombineExchange", "", "hideCashExchange", "giftPanelType", "", "(ZZI)V", "getGiftPanelType", "()I", "getHideCashExchange", "()Z", "getHideCombineExchange", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopExchangeAction extends GiftUIAction {
    private final int giftPanelType;
    private final boolean hideCashExchange;
    private final boolean hideCombineExchange;

    public GiftTopExchangeAction() {
        this(false, false, 0, 7, null);
    }

    public final int getGiftPanelType() {
        return this.giftPanelType;
    }

    public final boolean getHideCashExchange() {
        return this.hideCashExchange;
    }

    public final boolean getHideCombineExchange() {
        return this.hideCombineExchange;
    }

    public GiftTopExchangeAction(boolean r100, boolean r101, int r102) {
        super(false, "GiftTopExchangeAction", 1, null);
        this.hideCombineExchange = r100;
        this.hideCashExchange = r101;
        this.giftPanelType = r102;
    }

    public /* synthetic */ GiftTopExchangeAction(boolean r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
