package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"checkIsLynxPage", "", "pageLynxConfig", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxPageConfig;", "livegift-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class GiftListContractKt {
    public static final boolean checkIsLynxPage(GiftLynxPageConfig r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getPageSchema();
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L13:
        return !r102;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L13
    L4:
        r101 = null;
        goto L6
    }
}
