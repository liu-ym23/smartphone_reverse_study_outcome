package com.stepos.agentframework.adapter.bff;

import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"createData", "Lorg/json/JSONObject;", "bff_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BeanKt {
    private static final JSONObject createData() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("result", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", "text");
        jSONObject3.put("text", "找到了5张图片");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        jSONObject2.put("content", jSONArray);
        jSONObject2.put("isError", false);
        return jSONObject;
    }
}
