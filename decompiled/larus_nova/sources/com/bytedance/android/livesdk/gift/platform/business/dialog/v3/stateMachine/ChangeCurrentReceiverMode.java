package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeCurrentReceiverMode;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "shouldShowGuestListPanel", "", "(Z)V", "getShouldShowGuestListPanel", "()Z", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeCurrentReceiverMode extends GiftRepoAction {
    private final boolean shouldShowGuestListPanel;

    public final boolean getShouldShowGuestListPanel() {
        return this.shouldShowGuestListPanel;
    }

    public ChangeCurrentReceiverMode(boolean r100) {
        super("ChangeCurrentReceiverMode");
        this.shouldShowGuestListPanel = r100;
    }
}
