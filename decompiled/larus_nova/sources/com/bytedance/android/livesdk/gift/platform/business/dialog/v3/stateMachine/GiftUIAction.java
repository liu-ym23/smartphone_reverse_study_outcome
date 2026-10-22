package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftAction;", "needListen", "", "tag", "", "(ZLjava/lang/String;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class GiftUIAction extends GiftAction {
    public GiftUIAction(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        super(r100, r110, 0, 4, null);
    }

    public /* synthetic */ GiftUIAction(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100, r101);
    }
}
