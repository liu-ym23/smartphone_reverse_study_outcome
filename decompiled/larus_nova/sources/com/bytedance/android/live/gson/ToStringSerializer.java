package com.bytedance.android.live.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes45.dex */
public class ToStringSerializer implements JsonSerializer<Object> {
    public ToStringSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Object r100, Type r101, JsonSerializationContext r102) {
        if (r100 == null) goto L6;
        return r102.serialize(r100.toString());
    L6:
        return r102.serialize(null);
    }
}
