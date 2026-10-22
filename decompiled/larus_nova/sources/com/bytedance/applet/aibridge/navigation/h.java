package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class h {
    public static final JsonObject a(JSONObject r100) {
        JsonObject r101 = new JsonParser().parse(r100.toString()).getAsJsonObject();     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L4
        return r101;
    L4:
        e = move-exception;
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("js_event", "toGsonJsonObject failed: type=".concat(e.getClass().getSimpleName()));
        JsonObject r103 = new JsonObject();
        r103.addProperty("_error", "json_conversion_failed");
        return r103;
    }
}
