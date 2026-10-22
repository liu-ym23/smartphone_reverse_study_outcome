package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m {
    public static final String a(Map<String, ? extends Object> r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$firstString");
        Intrinsics.checkNotNullParameter(r101, "keys");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Object r104 = r100.get(r101[r103]);
        if (r104 != null) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return r104.toString();
    L9:
        return null;
    }
}
