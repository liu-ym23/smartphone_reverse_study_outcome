package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes44.dex */
public final class j {
    public static final JsonElement a(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if ((r102 instanceof JsonPrimitive) == true) goto L5;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return JsonNull.INSTANCE;
    L5:
        if (((JsonPrimitive) r102).isString() == false) goto L15;
        return GsonProtectorUtils.parse(new JsonParser(), ((JsonPrimitive) r102).getAsString());
    L17:
        return r102;
    L15:
        return r102;
    }
}
