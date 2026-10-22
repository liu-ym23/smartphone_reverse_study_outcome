package com.bytedance.android.shopping.store.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g {
    public static final Map<String, String> b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toNullableStrMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L8;
        String r106 = r105.toString();
    L9:
        r101.put(r104, r106);
        goto L4
    L8:
        r106 = null;
        goto L9
    L10:
        return r101;
    }

    public static final void a(Map<String, Object> r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$putIfNotNull");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 == null) goto L6;
        r100.put(r101, r102);
        return;
    }
}
