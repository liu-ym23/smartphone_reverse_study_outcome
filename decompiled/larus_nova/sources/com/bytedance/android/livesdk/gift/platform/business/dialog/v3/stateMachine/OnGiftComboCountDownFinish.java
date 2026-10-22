package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnGiftComboCountDownFinish;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "isSearch", "", "(Z)V", "()Z", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnGiftComboCountDownFinish extends GiftUIAction {
    private final boolean isSearch;

    public OnGiftComboCountDownFinish() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public OnGiftComboCountDownFinish(boolean r100) {
        super(false, "OnGiftComboCountDownFinish", 1, null);
        this.isSearch = r100;
    }

    public /* synthetic */ OnGiftComboCountDownFinish(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
