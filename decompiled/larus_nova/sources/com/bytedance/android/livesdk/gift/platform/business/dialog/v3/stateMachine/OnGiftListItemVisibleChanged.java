package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
@TraceExclude
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnGiftListItemVisibleChanged;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pagerPosition", "", "currentShowRange", "Lkotlin/ranges/IntRange;", "topicPagerPosition", "firstScroll", "", "(ILkotlin/ranges/IntRange;IZ)V", "getCurrentShowRange", "()Lkotlin/ranges/IntRange;", "getFirstScroll", "()Z", "getPagerPosition", "()I", "getTopicPagerPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnGiftListItemVisibleChanged extends GiftUIAction {
    private final IntRange currentShowRange;
    private final boolean firstScroll;
    private final int pagerPosition;
    private final int topicPagerPosition;

    public final IntRange getCurrentShowRange() {
        return this.currentShowRange;
    }

    public final boolean getFirstScroll() {
        return this.firstScroll;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public OnGiftListItemVisibleChanged(int r100, IntRange r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "currentShowRange");
        super(false, "OnGiftListItemVisibleChanged", 1, null);
        this.pagerPosition = r100;
        this.currentShowRange = r101;
        this.topicPagerPosition = r102;
        this.firstScroll = r103;
    }

    public /* synthetic */ OnGiftListItemVisibleChanged(int r100, IntRange r101, int r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = -1;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        this(r100, r101, r102, r103);
    }
}
