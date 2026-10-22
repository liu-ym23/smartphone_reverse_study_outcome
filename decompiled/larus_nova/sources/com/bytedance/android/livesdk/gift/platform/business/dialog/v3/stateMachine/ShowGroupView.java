package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowGroupView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelEffect;", "visible", "", "isSearch", "(ZZ)V", "()Z", "getVisible", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowGroupView implements GiftPanelEffect {
    private final boolean isSearch;
    private final boolean visible;

    public final boolean getVisible() {
        return this.visible;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public ShowGroupView(boolean r100, boolean r101) {
        this.visible = r100;
        this.isSearch = r101;
    }

    public /* synthetic */ ShowGroupView(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
