package com.bytedance.android.shopping.store.utils;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/ListMapNumberAdapter;", "Lcom/google/gson/JsonSerializer;", "", "", "", "", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListMapNumberAdapter implements JsonSerializer<List<? extends Map<String, ? extends Object>>>, JsonDeserializer<List<? extends Map<String, ? extends Object>>> {
    public ListMapNumberAdapter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.gson.JsonElement] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Double] */
    @Override // com.google.gson.JsonDeserializer
    public final List<? extends Map<String, ? extends Object>> deserialize(JsonElement r110, Type r111, JsonDeserializationContext r112) {
        if (r110 == null) goto L37;
        if (r110.isJsonArray() == false) goto L37;
        ArrayList r113 = new ArrayList();
        Iterator<JsonElement> r114 = r110.getAsJsonArray().iterator();
    L8:
        if (r114.hasNext() == false) goto L46;
        JsonElement r115 = r114.next();
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator r116 = r115.getAsJsonObject().entrySet().iterator();
    L11:
        if (r116.hasNext() == false) goto L35;
        Map.Entry r101 = (Map.Entry) r116.next();
        String r102 = (String) r101.getKey();
        ?? r103 = (JsonElement) r101.getValue();
        if (r103.isJsonPrimitive() == false) goto L34;
        JsonPrimitive r104 = r103.getAsJsonPrimitive();
        if (r104.isNumber() == false) goto L18;
        String r105 = r104.getAsString();
        if (StringsKt.contains$default(r105, '.', false, 2, null) == false) goto L24;
    L33:
        r103 = Double.valueOf(r104.getAsDouble());
        goto L34
    L24:
        if (StringsKt.contains(r105, 'e', true) == true) goto L33;
        long r106 = CastLongProtector.parseLong(r105);
        long r107 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= r106) goto L30;
    L32:
        r103 = Long.valueOf(r106);
        goto L34
    L30:
        if (r107 < r106) goto L32;
        r103 = Integer.valueOf((int) r106);
        goto L34
    L18:
        if (r104.isBoolean() == false) goto L20;
        r103 = Boolean.valueOf(r104.getAsBoolean());
        goto L34
    L20:
        r103 = r104.getAsString();
    L34:
        r100.put(r102, r103);
        goto L11
    L35:
        r113.add(r100);
        goto L8
    L46:
        return r113;
    L37:
        return CollectionsKt.emptyList();
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(List<? extends Map<String, ? extends Object>> r110, Type r111, JsonSerializationContext r112) {
        List<? extends Map<String, ? extends Object>> r113 = r110;
        if (r113 == null) goto L38;
        JsonArray r114 = new JsonArray();
        Iterator<? extends Map<String, ? extends Object>> r115 = r113.iterator();
    L7:
        if (r115.hasNext() == false) goto L33;
        Map<String, ? extends Object> r100 = r115.next();
        JsonObject r101 = new JsonObject();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L31;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r112 != null) goto L14;
    L29:
        JsonElement r106 = new JsonPrimitive(r105.toString());
    L30:
        r101.add(r104, r106);
        goto L10
    L14:
        if ((r105 instanceof Number) == false) goto L24;
        Number r107 = (Number) r105;
        long r108 = r107.longValue();
        if (r108 != r107.doubleValue()) goto L23;
        long r109 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE > r108) goto L23;
        if (r109 < r108) goto L23;
        Object r116 = Integer.valueOf((int) r108);
    L27:
        r106 = r112.serialize(r116);
        if (r106 != null) goto L30;
    L23:
        r116 = Long.valueOf(r108);
        goto L27
    L24:
        if (r105 != null) goto L26;
        r116 = "";
        goto L27
    L26:
        r116 = r105;
        goto L27
    L31:
        r114.add(r101);
        goto L7
    L33:
        return r114;
    L38:
        return JsonNull.INSTANCE;
    }
}
