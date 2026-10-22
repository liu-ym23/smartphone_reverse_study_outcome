package com.bytedance.android.live.recharge.platform.business.model.diamond;

/* JADX INFO: loaded from: classes47.dex */
public final class j {
    public static final boolean a(g r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getPreCalcInfo();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return false;
    L13:
        if (r100.getCouponBarInfo() == null) goto L18;
        return true;
    L18:
        return false;
    L10:
        r102 = false;
        goto L11
    }
}
