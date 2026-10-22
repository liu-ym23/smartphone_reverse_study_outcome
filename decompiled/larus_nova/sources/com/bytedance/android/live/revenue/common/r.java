package com.bytedance.android.live.revenue.common;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class r {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(JsonElement r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toOrgJsonValue");
        if ((r100 instanceof JsonObject) == false) goto L9;
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, JsonElement>> r102 = ((JsonObject) r100).entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L40;
        Map.Entry<String, JsonElement> r103 = r102.next();
        r101.put(r103.getKey(), a(r103.getValue()));
        goto L6
    L40:
        return r101;
    L9:
        if ((r100 instanceof JsonArray) == false) goto L16;
        Iterable r104 = (Iterable) r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L36;
        r105.add(a((JsonElement) r106.next()));
        goto L12
    L36:
        return new JSONArray(r105);
    L16:
        if ((r100 instanceof JsonPrimitive) == false) goto L29;
        JsonPrimitive r107 = (JsonPrimitive) r100;
        if (r107.isBoolean() == false) goto L21;
        return Boolean.valueOf(r107.getAsBoolean());
    L21:
        if (r107.isNumber() == false) goto L24;
        return r107.getAsNumber();
    L24:
        if (r107.isString() == false) goto L27;
        return r107.getAsString();
    L27:
        throw new IllegalArgumentException("Unexpected JsonPrimitive value: " + r100);
    L29:
        if ((r100 instanceof JsonNull) == false) goto L33;
        return JSONObject.NULL;
    L33:
        throw new IllegalArgumentException("Unexpected JsonElement type " + r100.getClass());
    }
}
