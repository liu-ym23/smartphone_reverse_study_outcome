package com.bytedance.android.shopping.sku.params.schema;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final List<Object> a(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        Object r104 = r100.get(r103);     // Catch: Exception -> L15
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = a((JSONArray) r104);     // Catch: Exception -> L15
    L13:
        r101.add(r104);     // Catch: Exception -> L15
    L17:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = b((JSONObject) r104);     // Catch: Exception -> L15
        goto L13
    L11:
        if (r100.isNull(r103) == false) goto L13;
        r104 = null;
    L15:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L17
    L18:
        return r101;
    }

    public static final Map<String, Object> b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toObjectMapForSku");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Exception -> L16
        Object r104 = r100.get(r103);     // Catch: Exception -> L16
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = a((JSONArray) r104);     // Catch: Exception -> L16
    L14:
        r101.put(r103, r104);     // Catch: Exception -> L16
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L12;
        r104 = b((JSONObject) r104);     // Catch: Exception -> L16
        goto L14
    L12:
        if (r100.isNull(r103) == false) goto L14;
        r104 = null;
    L16:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L18:
        return r101;
    }
}
