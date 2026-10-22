package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeTopicViewPagerPosition;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "topicPagerPosition", "", "parentPagerPosition", "(II)V", "getParentPagerPosition", "()I", "getTopicPagerPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChangeTopicViewPagerPosition extends GiftUIAction {
    private final int parentPagerPosition;
    private final int topicPagerPosition;

    public final int getParentPagerPosition() {
        return this.parentPagerPosition;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public ChangeTopicViewPagerPosition(int r100, int r101) {
        super(false, "ChangeViewPagerPosition", 1, null);
        this.topicPagerPosition = r100;
        this.parentPagerPosition = r101;
    }
}
