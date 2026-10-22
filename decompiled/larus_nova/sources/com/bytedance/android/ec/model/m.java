package com.bytedance.android.ec.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m {
    public static final boolean a(ProductPriceInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPriceValid");
        if (r100.getMinPrice() != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getMinPrice().longValue() <= 0) goto L7;
        return true;
    }
}
