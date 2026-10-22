package com.bytedance.android.shopping.new_cart.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final Object a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if ((r100 instanceof Map) == true) goto L5;
        r100 = null;
    L5:
        Map r102 = (Map) r100;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.get(r101);
    }
}
