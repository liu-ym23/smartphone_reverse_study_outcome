package com.bytedance.ai.bridge.method.message;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final String a(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonPrimitive() == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 != null) goto L16;
        return null;
    L16:
        return r102.getAsString();
    L8:
        if (r102.getAsJsonPrimitive().isString() == false) goto L10;
        r103 = true;
        goto L11
    }
}
