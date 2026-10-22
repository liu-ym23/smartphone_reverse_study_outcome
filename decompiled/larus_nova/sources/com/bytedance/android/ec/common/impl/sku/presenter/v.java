package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v {
    public static final boolean a(SkuItemInfoVO r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hitSkuNewStyle");
        Integer r101 = r100.getDelayDescStyle();
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r101.intValue() != 1) goto L8;
        return true;
    }
}
