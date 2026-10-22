package com.bytedance.android.ec.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n {
    public static final String a(PromotionDepositPresaleActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getStatus");
        if (b(r100) == false) goto L6;
        return PromotionDepositPresaleActivity.SALE;
    L6:
        if (r100.getAppointStatus() != 2) goto L8;
        return PromotionDepositPresaleActivity.RESERVED;
    L8:
        return PromotionDepositPresaleActivity.WAIT_RESERVE;
    }

    public static final boolean b(PromotionDepositPresaleActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isInDepositPresale");
        long r101 = r100.getBeginTime();
        long r102 = r100.getEndTime();
        long r103 = r100.getCurrentTime();
        if (r101 <= r103) goto L6;
    L8:
        return false;
    L6:
        if (r102 < r103) goto L8;
        return true;
    }
}
