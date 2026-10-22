package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshGiftMostlyUsedStatus;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "giftId", "", "operateAction", "", "originPageType", "success", "", "(JIIZ)V", "getGiftId", "()J", "getOperateAction", "()I", "getOriginPageType", "getSuccess", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshGiftMostlyUsedStatus extends GiftRepoAction {
    private final long giftId;
    private final int operateAction;
    private final int originPageType;
    private final boolean success;

    public final long getGiftId() {
        return this.giftId;
    }

    public final int getOperateAction() {
        return this.operateAction;
    }

    public final int getOriginPageType() {
        return this.originPageType;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public RefreshGiftMostlyUsedStatus(long r100, @MostlyUsedGiftOperateAction int r101, int r102, boolean r103) {
        super("RefreshGiftMostlyUsedStatus");
        this.giftId = r100;
        this.operateAction = r101;
        this.originPageType = r102;
        this.success = r103;
    }

    public /* synthetic */ RefreshGiftMostlyUsedStatus(long r100, int r101, int r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        boolean r102 = true;
    L6:
        this(r100, r101, r110, r102);
        return;
    L5:
        r102 = r111;
        goto L6
    }
}
