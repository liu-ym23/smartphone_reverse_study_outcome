package com.bytedance.android.ec.core.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/utils/JSONArrayAdapter;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONArray;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JSONArrayAdapter implements JsonSerializer<JSONArray>, JsonDeserializer<JSONArray> {

    public static final class a {
    }

    public JSONArrayAdapter() {
    }

    static {
        new JSONArrayAdapter();
    }

    @Override // com.google.gson.JsonDeserializer
    public final JSONArray deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new JSONArray(r100.toString());
    L7:
        e = move-exception;
        throw new JsonParseException(e);
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(JSONArray r100, Type r101, JsonSerializationContext r102) {
        JSONArray r103 = r100;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 != null) goto L5;
        return null;
    L5:
        JsonArray r104 = new JsonArray();
        int r105 = r103.length();
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L9;
        Object r107 = r103.opt(r106);
        r104.add(r102.serialize(r107, r107.getClass()));
        r106 = r106 + 1;
        goto L6
    L9:
        return r104;
    }
}
