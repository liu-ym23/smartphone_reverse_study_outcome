package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshMostlyUsedTabPinTopStatus;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "targetPinTopStrategy", "", "pagerPosition", "(II)V", "getPagerPosition", "()I", "getTargetPinTopStrategy", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshMostlyUsedTabPinTopStatus extends GiftRepoAction {
    private final int pagerPosition;
    private final int targetPinTopStrategy;

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getTargetPinTopStrategy() {
        return this.targetPinTopStrategy;
    }

    public RefreshMostlyUsedTabPinTopStatus(int r100, int r101) {
        super("RefreshMostlyUsedTabPinTopStatus");
        this.targetPinTopStrategy = r100;
        this.pagerPosition = r101;
    }
}
