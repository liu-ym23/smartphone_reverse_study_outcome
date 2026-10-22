package com.bytedance.android.ec.model.response.anchorv3;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final int a(PromotionDiscountLabel r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.getType();
        if (r101 != 2) goto L8;
        return 1;
    L8:
        if (r101 != 3) goto L10;
        return 2;
    L10:
        if (r101 != 4) goto L18;
        return 3;
    L18:
        return 0;
    }
}
