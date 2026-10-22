package com.bytedance.android.shopping.store.home.view;

import com.bytedance.android.shopping.store.home.entity.ToolType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    public static final String a(ToolType r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toEventValue");
        int r101 = e.f184703a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "service";
    L5:
        if (r101 != 2) goto L7;
        return "share";
    L7:
        if (r101 != 3) goto L9;
        return "cart";
    L9:
        if (r101 != 4) goto L11;
        return "order";
    L11:
        if (r101 == 5) goto L13;
        return "unknown";
    L13:
        return "coupon_entrance";
    }
}
