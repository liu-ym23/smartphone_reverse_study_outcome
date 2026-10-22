package com.bytedance.android.live.revenue.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class q {
    public static final Map<String, String> a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$jsonObjToMap");
        Iterator<String> r101 = r100.keys();
        LinkedHashMap r102 = new LinkedHashMap();
    L4:
        if (r101.hasNext() == false) goto L12;
        String r103 = r101.next();
        String r104 = r100.optString(r103);
        if (r104.length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.put(r103, r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L12:
        return MapsKt.toMap(r102);
    }

    public static final <V> JSONObject b(Pair<String, ? extends V>... r100) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair<String, ? extends V> r104 = r100[r103];
        r101.put(r104.getFirst(), r104.getSecond());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final JSONObject c(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new JSONObject(r100);
    }
}
