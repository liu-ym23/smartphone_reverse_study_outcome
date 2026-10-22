package com.bytedance.ai.applet.render.core.lynx;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    public static final JavaOnlyArray a(JsonArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyArray r101 = new JavaOnlyArray();
        Iterator<JsonElement> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        JsonElement r103 = r102.next();
        if ((r103 instanceof JsonNull) == true) goto L7;
        if ((r103 instanceof JsonObject) == true) goto L10;
        if ((r103 instanceof JsonArray) == true) goto L13;
        if ((r103 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r104 = (JsonPrimitive) r103;
        if (r104.isBoolean() == true) goto L18;
        if (r104.isString() == true) goto L21;
        if (r104.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r104.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r101.add(Long.valueOf(r104.getAsNumber().longValue()));
        goto L4
    L26:
        r101.add(Double.valueOf(r104.getAsNumber().doubleValue()));
        goto L4
    L21:
        r101.add(r104.getAsString());
        goto L4
    L18:
        r101.add(Boolean.valueOf(r104.getAsBoolean()));
        goto L4
    L13:
        r101.add(a((JsonArray) r103));
        goto L4
    L10:
        r101.add(b((JsonObject) r103));
        goto L4
    L7:
        r101.add(null);
        goto L4
    L28:
        return r101;
    }

    public static final JavaOnlyMap b(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<T> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        String r103 = (String) r102.next();
        JsonElement r104 = r100.get(r103);
        if ((r104 instanceof JsonNull) == true) goto L7;
        if ((r104 instanceof JsonObject) == true) goto L10;
        if ((r104 instanceof JsonArray) == true) goto L13;
        if ((r104 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r105 = (JsonPrimitive) r104;
        if (r105.isBoolean() == true) goto L18;
        if (r105.isString() == true) goto L21;
        if (r105.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r105.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r101.put(r103, Long.valueOf(r105.getAsNumber().longValue()));
        goto L4
    L26:
        r101.put(r103, Double.valueOf(r105.getAsNumber().doubleValue()));
        goto L4
    L21:
        r101.put(r103, r105.getAsString());
        goto L4
    L18:
        r101.put(r103, Boolean.valueOf(r105.getAsBoolean()));
        goto L4
    L13:
        r101.put(r103, a((JsonArray) r104));
        goto L4
    L10:
        r101.put(r103, b((JsonObject) r104));
        goto L4
    L7:
        r101.put(r103, null);
        goto L4
    L28:
        return r101;
    }
}
