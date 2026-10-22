package com.bytedance.android.ec.core.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/utils/JSONObjectAdapter;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONObject;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JSONObjectAdapter implements JsonSerializer<JSONObject>, JsonDeserializer<JSONObject> {
    public JSONObjectAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final JSONObject deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 != null) goto L9;
        return null;
    L9:
        return tv5.a.c(r100);
    L6:
        e = move-exception;
        throw new JsonParseException(e);
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(JSONObject r100, Type r101, JsonSerializationContext r102) {
        JSONObject r103 = r100;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 != null) goto L5;
        return null;
    L5:
        JsonObject r104 = new JsonObject();
        Iterator<String> r105 = r103.keys();
    L7:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();
        Object r107 = r103.opt(r106);
        r104.add(r106, r102.serialize(r107, r107.getClass()));
        goto L7
    L10:
        return r104;
    }
}
