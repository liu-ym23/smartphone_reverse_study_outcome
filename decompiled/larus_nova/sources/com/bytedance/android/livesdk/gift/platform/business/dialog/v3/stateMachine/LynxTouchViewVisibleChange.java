package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/LynxTouchViewVisibleChange;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "lynxTouchViewVisible", "", "topDetailVisible", "(ZZ)V", "getLynxTouchViewVisible", "()Z", "getTopDetailVisible", "toString", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxTouchViewVisibleChange extends GiftRepoAction {
    private final boolean lynxTouchViewVisible;
    private final boolean topDetailVisible;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction
    public String toString() {
        return getTag() + "{lynxTouch=" + this.lynxTouchViewVisible + ",topDetail=" + this.topDetailVisible + '}';
    }

    public final boolean getLynxTouchViewVisible() {
        return this.lynxTouchViewVisible;
    }

    public final boolean getTopDetailVisible() {
        return this.topDetailVisible;
    }

    public LynxTouchViewVisibleChange(boolean r100, boolean r101) {
        super("LynxTouchViewVisibleChange");
        this.lynxTouchViewVisible = r100;
        this.topDetailVisible = r101;
    }
}
