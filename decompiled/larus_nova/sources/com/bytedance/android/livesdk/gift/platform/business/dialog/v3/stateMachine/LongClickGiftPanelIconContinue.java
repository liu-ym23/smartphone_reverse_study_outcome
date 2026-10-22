package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@TraceExclude
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/LongClickGiftPanelIconContinue;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "", "position", "I", "getPosition", "()I", "positionX", "getPositionX", "positionY", "getPositionY", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "showInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "getShowInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "", "isSearch", "Z", "()Z", "<init>", "(IIIIILcom/bytedance/android/livesdk/gift/platform/core/model/n;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongClickGiftPanelIconContinue extends GiftUIAction {
    private final int counterPosition;
    private final boolean isSearch;
    private final int position;
    private final int positionX;
    private final int positionY;
    private final n showInfo;
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

    public final n getShowInfo() {
        return this.showInfo;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public LongClickGiftPanelIconContinue(int r100, int r101, int r102, int r103, int r104, n r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "showInfo");
        super(false, "LongClickGiftPanelIconContinue", 1, null);
        this.position = r100;
        this.positionX = r101;
        this.positionY = r102;
        this.counterPosition = r103;
        this.topicPagerPosition = r104;
        this.showInfo = r110;
        this.isSearch = r111;
    }

    public /* synthetic */ LongClickGiftPanelIconContinue(int r110, int r111, int r112, int r113, int r114, n r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 8) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r117 & 16) == 0) goto L9;
        int r101 = -1;
    L11:
        if ((r117 & 32) == 0) goto L13;
        n r102 = new n(null, null, 7);
    L15:
        if ((r117 & 64) == 0) goto L17;
        boolean r103 = false;
    L18:
        this(r110, r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
