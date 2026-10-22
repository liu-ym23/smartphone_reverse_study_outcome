package com.bytedance.android.live.rts.client_utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(JsonElement r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$asPrimitiveType");
        if ((r100 instanceof JsonObject) == false) goto L9;
        JsonObject r102 = (JsonObject) r100;
        Set<String> r103 = r102.keySet();
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L44;
        Object r106 = r105.next();
        r104.put(r106, a(r102.get((String) r106), r101));
        goto L6
    L44:
        return r104;
    L9:
        if ((r100 instanceof JsonArray) == false) goto L15;
        Iterable r107 = (Iterable) r100;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L12:
        if (r109.hasNext() == false) goto L45;
        r108.add(a((JsonElement) r109.next(), r101));
        goto L12
    L45:
        return r108;
    L15:
        if ((r100 instanceof JsonPrimitive) == false) goto L35;
        JsonPrimitive r110 = (JsonPrimitive) r100;
        if (r110.isBoolean() == false) goto L20;
        return Boolean.valueOf(r110.getAsBoolean());
    L20:
        if (r110.isNumber() == false) goto L43;
        BigDecimal r111 = r110.getAsBigDecimal();
        if (r111.stripTrailingZeros().scale() != 0) goto L42;
        long r112 = r111.longValue();
        if (r112 < Integer.MAX_VALUE) goto L26;
    L29:
        boolean r113 = true;
    L30:
        if (r113 == false) goto L41;
        return String.valueOf(r112);
    L41:
        return Integer.valueOf((int) r112);
    L26:
        if (r112 <= Integer.MIN_VALUE) goto L29;
        r113 = false;
        goto L30
    L42:
        return Double.valueOf(r111.doubleValue());
    L43:
        return r110.getAsString();
    L35:
        return null;
    }
}
