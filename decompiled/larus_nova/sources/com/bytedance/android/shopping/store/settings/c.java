package com.bytedance.android.shopping.store.settings;

import com.bytedance.android.ec.core.abtest.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static int a() {
        d r100 = d.f43639a;
        jj4.b r101 = jj4.b.f499326b;
        Object r102 = jj4.a.a("ec_shop_classify_filter_tab", Integer.class, 0, false);
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Number) r102).intValue();
    }

    static {
    }
}
