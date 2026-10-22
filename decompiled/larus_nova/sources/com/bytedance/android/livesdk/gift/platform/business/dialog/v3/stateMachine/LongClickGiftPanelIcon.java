package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.core.model.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/LongClickGiftPanelIcon;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "", "position", "I", "getPosition", "()I", "listPagerPosition", "getListPagerPosition", "positionX", "getPositionX", "positionY", "getPositionY", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "showInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "getShowInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "", "isSearch", "Z", "()Z", "<init>", "(IIIIIILcom/bytedance/android/livesdk/gift/platform/core/model/n;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongClickGiftPanelIcon extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int listPagerPosition;
    private final int position;
    private final int positionX;
    private final int positionY;
    private final n showInfo;
    private final int topicPagerPosition;

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getListPagerPosition() {
        return this.listPagerPosition;
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

    public final n getShowInfo() {
        return this.showInfo;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public LongClickGiftPanelIcon(int r100, int r101, int r102, int r103, int r104, int r110, n r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "showInfo");
        super(false, "LongClickGiftPanelIcon", 1, null);
        this.position = r100;
        this.listPagerPosition = r101;
        this.positionX = r102;
        this.positionY = r103;
        this.counterPosition = r104;
        this.topicPagerPosition = r110;
        this.showInfo = r111;
        this.isSearch = r112;
    }

    public /* synthetic */ LongClickGiftPanelIcon(int r110, int r111, int r112, int r113, int r114, int r115, n r116, boolean r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 16) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r211 & 32) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r211 & 64) == 0) goto L13;
        n r117 = new n(null, null, 7);
    L15:
        if ((r211 & 128) == 0) goto L17;
        boolean r118 = false;
    L18:
        this(r110, r111, r112, r113, r100, r101, r117, r118);
        return;
    L17:
        r118 = r210;
        goto L18
    L13:
        r117 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
