package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
@TraceExclude
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnGiftCounterVisibleChanged;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pagerPosition", "", "currentShowRange", "Lkotlin/ranges/IntRange;", "(ILkotlin/ranges/IntRange;)V", "getCurrentShowRange", "()Lkotlin/ranges/IntRange;", "getPagerPosition", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnGiftCounterVisibleChanged extends GiftUIAction {
    private final IntRange currentShowRange;
    private final int pagerPosition;

    public final IntRange getCurrentShowRange() {
        return this.currentShowRange;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public OnGiftCounterVisibleChanged(int r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r101, "currentShowRange");
        super(false, "OnGiftCounterItemVisibleChanged", 1, null);
        this.pagerPosition = r100;
        this.currentShowRange = r101;
    }
}
