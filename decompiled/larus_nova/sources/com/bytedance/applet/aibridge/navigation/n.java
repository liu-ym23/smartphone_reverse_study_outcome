package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n {
    public static final boolean a(double r100, double r101) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
    L31:
        return false;
    L10:
        if (Double.isInfinite(r101) == false) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L31;
        if ((-90.0d) <= r100) goto L19;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L31;
        if ((-180.0d) <= r101) goto L26;
    L28:
        boolean r105 = false;
    L29:
        if (r105 == false) goto L31;
        return true;
    L26:
        if (r101 > 180.0d) goto L28;
        r105 = true;
        goto L29
    L19:
        if (r100 > 90.0d) goto L21;
        r104 = true;
        goto L22
    L12:
        if (Double.isNaN(r101) == true) goto L14;
        r103 = true;
        goto L15
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r102 = true;
        goto L8
    }

    public static final Double b(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        Object r103 = null;
        if (r102 != null) goto L5;
        return null;
    L5:
        if ((!r102.isJsonNull()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L23;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(Double.valueOf(r102.getAsDouble()));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r105) == true) goto L19;
        r103 = r105;
    L19:
        return (Double) r103;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }

    public static final String c(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 == null) goto L28;
        boolean r103 = true;
        if ((!r102.isJsonNull()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L31;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(r102.getAsString());     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r105) == false) goto L17;
        r105 = null;
    L17:
        String r106 = (String) r105;
        if (r106 != null) goto L20;
        return null;
    L20:
        if (r106.length() > 0) goto L23;
        r103 = false;
    L23:
        if (r103 == true) goto L25;
        return null;
    L25:
        return r106;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L31:
        return null;
    L28:
        return null;
    }

    public static final List<com.larus.navigation.api.y> d(JsonArray r110, Function1<? super String, Unit> r210) {
        Intrinsics.checkNotNullParameter(r210, "onInvalid");
        if (r110 != null) goto L6;
        return null;
    L6:
        if (r110.size() <= 15) goto L9;
        r210.invoke("too_many_way_points");
        return null;
    L9:
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<JsonElement> r101 = r110.iterator();
        int r102 = 0;
    L11:
        if (r101.hasNext() == false) goto L43;
        JsonElement r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        JsonElement r105 = r103;
        if (r105.isJsonObject() == true) goto L20;
        r105 = null;
    L20:
        if (r105 == null) goto L41;
        JsonObject r106 = r105.getAsJsonObject();
        if (r106 == null) goto L41;
        Double r111 = b(r106, "latitude");
        if (r111 == null) goto L39;
        double r112 = r111.doubleValue();
        Double r113 = b(r106, "longitude");
        if (r113 == null) goto L37;
        double r114 = r113.doubleValue();
        if (a(r112, r114) == false) goto L30;
        r100.add(new com.larus.navigation.api.y(r112, r114, c(r106, "poiId"), c(r106, "poiType"), c(r106, "poiName")));
        r102 = r104;
    L34:
        e = move-exception;
        int r107 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("nav_jsb_helper", "waypoints[" + r102 + "] invalid: type=" + e.getClass().getSimpleName());
        r210.invoke("invalid_way_point_coordinates");
        return null;
    L30:
        int r108 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r102 + "] coordinate out of range");
        r210.invoke("invalid_way_point_coordinates");
        return null;
    L37:
        int r109 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r102 + "].longitude is null");
        r210.invoke("invalid_way_point_coordinates");
        return null;
    L39:
        int r115 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r102 + "].latitude is null");
        r210.invoke("invalid_way_point_coordinates");
        return null;
    L41:
        int r116 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r102 + "] is not an object");
        r210.invoke("invalid_way_point_coordinates");
        return null;
    L43:
        return r100;
    }
}
