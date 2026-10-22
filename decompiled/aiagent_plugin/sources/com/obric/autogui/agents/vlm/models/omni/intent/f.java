package com.obric.autogui.agents.vlm.models.omni.intent;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import d.h.b.o;

/* JADX INFO: compiled from: OmniRecommendationExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final String a(JsonObject r2) {
        o.e(r2, "<this>");
        JsonElement r3 = r2.get("recommend_task_type");
        if (r3 != null) goto L6;
        return "";
    L6:
        if (r3.isJsonPrimitive() == true) goto L8;
        return "";
    L8:
        if (r3.getAsJsonPrimitive().isString() == false) goto L12;
        String r0 = r3.getAsString();
        o.c(r0, "getAsString(...)");
        return r0;
    L12:
        return "";
    }
}
