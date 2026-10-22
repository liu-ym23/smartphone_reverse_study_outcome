package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeNewReceiverPanel;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "show", "", "(Z)V", "getShow", "()Z", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeNewReceiverPanel extends GiftUIAction {
    private final boolean show;

    public final boolean getShow() {
        return this.show;
    }

    public ChangeNewReceiverPanel(boolean r100) {
        super(false, "ChangeNewReceiverPanel", 1, null);
        this.show = r100;
    }
}
