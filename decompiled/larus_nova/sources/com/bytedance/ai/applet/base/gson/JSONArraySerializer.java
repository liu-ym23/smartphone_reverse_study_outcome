package com.bytedance.ai.applet.base.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/JSONArraySerializer;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONArray;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonSerializationContext;", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSONArraySerializer implements JsonSerializer<JSONArray> {
    public JSONArraySerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(JSONArray r100, Type r101, JsonSerializationContext r102) {
        JSONArray r103 = r100;
        if (r103 == null) goto L6;
        return f.a(r103);
    L6:
        return new JsonArray();
    }
}
