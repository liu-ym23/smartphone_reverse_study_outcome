package com.bytedance.android.live.core.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z0 {
    public static final <K, V> Map.Entry<K, V> a(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$firstEntryOfMap");
        if (r100.entrySet().iterator().hasNext() == true) goto L5;
        return null;
    L5:
        return r100.entrySet().iterator().next();
    }

    public static final <T> T b(h80.c<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$value");
        T r101 = r100.f484055a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101;
    }

    public static final String c(Object r100) {
        if (r100 == null) goto L4;
        int r101 = r100.hashCode();
    L6:
        return Integer.toHexString(r101);
    L4:
        r101 = 0;
        goto L6
    }
}
