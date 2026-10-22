package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.slice.SliceInitService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45736a = 0;

    static {
    }

    public static Map a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r100, SliceInitService.DEFAULT_SWITCH) == true) goto L106;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L77
        JsonObject r104 = (JsonObject) u0.b(r100, JsonObject.class);     // Catch: Throwable -> L77
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L77
        Iterator<T> r106 = r104.entrySet().iterator();     // Catch: Throwable -> L77
    L16:
        if (r106.hasNext() == false) goto L72;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L77
        CharSequence r108 = (CharSequence) r107.getKey();     // Catch: Throwable -> L77
        if (r108 != null) goto L20;
    L23:
        boolean r109 = true;
    L24:
        if (r109 == true) goto L42;
        JsonElement r110 = (JsonElement) r107.getValue();     // Catch: Throwable -> L77
        if (r110 == null) goto L42;
        if (r110.isJsonPrimitive() != true) goto L42;
        String r111 = ((JsonElement) r107.getValue()).getAsString();     // Catch: Throwable -> L77
        if (r111 != null) goto L32;
    L35:
        boolean r112 = true;
    L37:
        if ((!r112) == true) goto L40;
        r111 = null;
    L40:
        if (r111 == null) goto L16;
        r105.put(r107.getKey(), r111);     // Catch: Throwable -> L77
        goto L16
    L32:
        if (StringsKt.isBlank(r111) == true) goto L35;
        r112 = false;
    L42:
        CharSequence r113 = (CharSequence) r107.getKey();     // Catch: Throwable -> L77
        if (r113 != null) goto L45;
    L48:
        boolean r114 = true;
    L49:
        if (r114 == true) goto L16;
        JsonElement r115 = (JsonElement) r107.getValue();     // Catch: Throwable -> L77
        if (r115 == null) goto L16;
        if (r115.isJsonObject() != true) goto L16;
        String r116 = u0.d(r107.getValue());     // Catch: Throwable -> L77
        if (r116 != null) goto L57;
    L60:
        boolean r117 = true;
    L61:
        if (r117 == false) goto L63;
    L65:
        boolean r118 = false;
    L66:
        if (r118 == true) goto L69;
        r116 = null;
    L69:
        if (r116 == null) goto L16;
        r105.put(r107.getKey(), r116);     // Catch: Throwable -> L77
        goto L16
    L63:
        if ((!Intrinsics.areEqual(r116, SliceInitService.DEFAULT_SWITCH)) == false) goto L65;
        r118 = true;
        goto L66
    L57:
        if (StringsKt.isBlank(r116) == true) goto L60;
        r117 = false;
        goto L61
    L45:
        if (StringsKt.isBlank(r113) == true) goto L48;
        r114 = false;
        goto L49
    L20:
        if (StringsKt.isBlank(r108) == true) goto L23;
        r109 = false;
        goto L24
    L72:
        if ((!r105.isEmpty()) == true) goto L75;
        r105 = null;
    L75:
        Object r119 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L77
    L80:
        if (Result.m9455isFailureimpl(r119) == true) goto L84;
        r102 = r119;
    L84:
        return (Map) r102;
    L77:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L80
    L106:
        return null;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static Object b(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return new Gson().fromJson(r100, r101);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
