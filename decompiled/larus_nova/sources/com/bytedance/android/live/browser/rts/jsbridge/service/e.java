package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.annie.param.UtilsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f64183a = null;

    public static final class a {
        public a() {
        }

        public static Map a(Object r100) {
            if ((r100 instanceof JSONObject) == false) goto L7;
            int r101 = mm0.c.f514412a;
            return MapsKt.toMutableMap(mm0.c.e((JSONObject) r100));
        L7:
            if ((r100 instanceof JsonObject) == true) goto L9;
            return null;
        L9:
            return MapsKt.toMutableMap(UtilsKt.i((JsonObject) r100));
        }

        public static List b(JsonArray r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonArray");
            ArrayList r101 = new ArrayList();
            Iterator<JsonElement> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L25;
            JsonElement r103 = r102.next();
            if ((r103 instanceof JsonObject) == false) goto L9;
            e.f64183a.getClass();
            Object r104 = c((JsonObject) r103);
        L24:
            r101.add(r104);
            goto L4
        L9:
            if ((r103 instanceof JsonArray) == false) goto L12;
            e.f64183a.getClass();
            r104 = b((JsonArray) r103);
            goto L24
        L12:
            if ((r103 instanceof JsonPrimitive) == false) goto L23;
            JsonPrimitive r105 = (JsonPrimitive) r103;
            if (r105.isString() == false) goto L17;
            r104 = r105.getAsString();
            goto L24
        L17:
            if (r105.isBoolean() == false) goto L20;
            r104 = Boolean.valueOf(r105.getAsBoolean());
            goto L24
        L20:
            if (r105.isNumber() == false) goto L22;
            r104 = r105.getAsNumber();
            goto L24
        L22:
            r104 = r103.toString();
            goto L24
        L23:
            r104 = r103.toString();
            goto L24
        L25:
            return r101;
        }

        public static Map c(JsonObject r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonObj");
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator<Map.Entry<String, JsonElement>> r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L25;
            Map.Entry<String, JsonElement> r103 = r102.next();
            String r104 = r103.getKey();
            JsonElement r105 = r103.getValue();
            if ((r105 instanceof JsonObject) == false) goto L9;
            Object r106 = c((JsonObject) r105);
        L24:
            r101.put(r104, r106);
            goto L4
        L9:
            if ((r105 instanceof JsonArray) == false) goto L12;
            r106 = b((JsonArray) r105);
            goto L24
        L12:
            if ((r105 instanceof JsonPrimitive) == false) goto L23;
            JsonPrimitive r107 = (JsonPrimitive) r105;
            if (r107.isString() == false) goto L17;
            r106 = r107.getAsString();
            goto L24
        L17:
            if (r107.isBoolean() == false) goto L20;
            r106 = Boolean.valueOf(r107.getAsBoolean());
            goto L24
        L20:
            if (r107.isNumber() == false) goto L22;
            r106 = r107.getAsNumber();
            goto L24
        L22:
            r106 = r105.toString();
            goto L24
        L23:
            r106 = r105.toString();
            goto L24
        L25:
            return r101;
        }
    }

    static {
        f64183a = new a();
    }
}
