package com.bytedance.android.live.core.setting.v2.helper;

import a70.b;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
    public MapDeserializerDoubleAsIntFix() {
    }

    public final Object a(JsonElement r100) {
        if (r100.isJsonArray() == false) goto L12;
        ArrayList r101 = new ArrayList();
        JsonArray r102 = r100.getAsJsonArray();
        if (r102 == null) goto L10;
        Iterator<JsonElement> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.add(a(r103.next()));
    L10:
        return r101;
    L12:
        if (r100.isJsonObject() == false) goto L21;
        LinkedTreeMap r104 = new LinkedTreeMap();
        JsonObject r105 = r100.getAsJsonObject();
        if (r105 == null) goto L19;
        Iterator<Map.Entry<String, JsonElement>> r106 = r105.entrySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<String, JsonElement> r107 = r106.next();
        r104.put(r107.getKey(), a(r107.getValue()));
    L19:
        return r104;
    L21:
        if (r100.isJsonPrimitive() == false) goto L49;
        JsonPrimitive r108 = r100.getAsJsonPrimitive();
        if (r108.isBoolean() == false) goto L27;
        return Boolean.valueOf(r108.getAsBoolean());
    L27:
        if (r108.isString() == false) goto L31;
        return r108.getAsString();
    L31:
        if (r108.isNumber() == false) goto L53;
        Number r109 = r108.getAsNumber();
        if (Math.ceil(r109.doubleValue()) != r109.longValue()) goto L48;
        if (r109.floatValue() >= 0.0f) goto L46;
        if ((r109 instanceof LazilyParsedNumber) == true) goto L39;
    L41:
        boolean r110 = false;
    L42:
        if (r110 == false) goto L46;
        b.e("_GSON", "isFloat num= " + r109);
        return Double.valueOf(r109.doubleValue());
    L39:
        if (new BigDecimal(r109.toString()).scale() <= 0) goto L41;
        r110 = true;
    L46:
        return Long.valueOf(r109.longValue());
    L48:
        return Double.valueOf(r109.doubleValue());
    L53:
        return null;
    L49:
        return null;
    }

    @Override // com.google.gson.JsonDeserializer
    public final Map<String, Object> deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        Object r103 = a(r100);
        if (r103 != null) goto L7;
        return null;
    L7:
        return (Map) r103;
    }
}
