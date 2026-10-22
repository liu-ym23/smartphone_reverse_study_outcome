package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnGiftAnimShakeFinish;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "pagerPosition", "", "position", "counterPosition", "topicPagerPosition", "isSearch", "", "(IIIIZ)V", "getCounterPosition", "()I", "()Z", "getPagerPosition", "getPosition", "getTopicPagerPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnGiftAnimShakeFinish extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int pagerPosition;
    private final int position;
    private final int topicPagerPosition;

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public OnGiftAnimShakeFinish(int r100, int r101, int r102, int r103, boolean r104) {
        super(false, "OnGiftAnimShakeFinish", 1, null);
        this.pagerPosition = r100;
        this.position = r101;
        this.counterPosition = r102;
        this.topicPagerPosition = r103;
        this.isSearch = r104;
    }

    public /* synthetic */ OnGiftAnimShakeFinish(int r100, int r101, int r102, int r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r103 = false;
    L6:
        this(r100, r101, r102, r110, r103);
        return;
    L5:
        r103 = r111;
        goto L6
    }
}
