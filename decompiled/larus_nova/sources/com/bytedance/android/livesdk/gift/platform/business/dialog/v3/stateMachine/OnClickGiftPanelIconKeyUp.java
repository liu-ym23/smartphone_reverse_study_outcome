package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnClickGiftPanelIconKeyUp;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "position", "", "positionX", "positionY", "counterPosition", "topicPagerPosition", "isSearch", "", "(IIIIIZ)V", "getCounterPosition", "()I", "()Z", "getPosition", "getPositionX", "getPositionY", "getTopicPagerPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnClickGiftPanelIconKeyUp extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int position;
    private final int positionX;
    private final int positionY;
    private final int topicPagerPosition;

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPositionX() {
        return this.positionX;
    }

    public final int getPositionY() {
        return this.positionY;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public OnClickGiftPanelIconKeyUp(int r100, int r101, int r102, int r103, int r104, boolean r110) {
        super(false, "OnClickGiftPanelIconKeyUp", 1, null);
        this.position = r100;
        this.positionX = r101;
        this.positionY = r102;
        this.counterPosition = r103;
        this.topicPagerPosition = r104;
        this.isSearch = r110;
    }

    public /* synthetic */ OnClickGiftPanelIconKeyUp(int r110, int r111, int r112, int r113, int r114, boolean r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r116 & 16) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r116 & 32) == 0) goto L13;
        boolean r102 = false;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
