package com.bytedance.ai.applet.base.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f {
    public static final JsonArray a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JsonArray r101 = new JsonArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L23;
        Object r104 = r100.get(r103);
        if ((r104 instanceof Number) == false) goto L8;
        r101.add((Number) r104);
    L22:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof String) == false) goto L11;
        r101.add((String) r104);
        goto L22
    L11:
        if ((r104 instanceof Character) == false) goto L14;
        r101.add((Character) r104);
        goto L22
    L14:
        if ((r104 instanceof Boolean) == false) goto L17;
        r101.add((Boolean) r104);
        goto L22
    L17:
        if ((r104 instanceof JSONObject) == false) goto L20;
        r101.add(b((JSONObject) r104));
        goto L22
    L20:
        if ((r104 instanceof JSONArray) == false) goto L22;
        r101.add(a((JSONArray) r104));
        goto L22
    L23:
        return r101;
    }

    public static final JsonObject b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JsonObject r101 = new JsonObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof Number) == true) goto L7;
        if ((r104 instanceof String) == true) goto L10;
        if ((r104 instanceof Character) == true) goto L13;
        if ((r104 instanceof Boolean) == true) goto L16;
        if ((r104 instanceof JSONObject) == true) goto L19;
        if ((r104 instanceof JSONArray) == false) goto L4;
        r101.add(r103, a((JSONArray) r104));
        goto L4
    L19:
        r101.add(r103, b((JSONObject) r104));
        goto L4
    L16:
        r101.addProperty(r103, (Boolean) r104);
        goto L4
    L13:
        r101.addProperty(r103, (Character) r104);
        goto L4
    L10:
        r101.addProperty(r103, (String) r104);
        goto L4
    L7:
        r101.addProperty(r103, (Number) r104);
        goto L4
    L23:
        return r101;
    }
}
