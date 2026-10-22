package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class l {
    public static final Map<String, Object> a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toObjectMap");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Exception -> L16
        Object r104 = r100.get(r103);     // Catch: Exception -> L16
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = cd.a.d((JSONArray) r104);     // Catch: Exception -> L16
    L14:
        r101.put(r103, r104);     // Catch: Exception -> L16
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L12;
        r104 = a((JSONObject) r104);     // Catch: Exception -> L16
        goto L14
    L12:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L14;
        r104 = null;
    L16:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L18:
        return r101;
    }
}
