package com.bytedance.android.live.core.utils;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class JsonUtil {
    private static JsonParser jsonParser;

    static {
        jsonParser = new JsonParser();
    }

    private JsonUtil() {
    }

    public static JSONObject copyJson2(JSONObject r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<String> r101 = r100.keys();
        if (r101 != null) goto L8;
        return null;
    L8:
        JSONObject r102 = new JSONObject();
    L10:
        if (r101.hasNext() == false) goto L12;
        String r103 = r101.next();
        r102.put(r103, r100.opt(r103));
        goto L10
    L12:
        return r102;
    }

    public static Map<String, String> jsonObjectToLinkedMap(JSONObject r100) {
        if (r100 == null) goto L4;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        if (TextUtils.isEmpty(r104) == true) goto L7;
        r101.put(r103, r104);
        goto L7
    L11:
        return r101;
    L4:
        return new LinkedHashMap();
    }

    public static Map<String, String> jsonObjectToMap(JSONObject r100) {
        if (r100 == null) goto L4;
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        if (TextUtils.isEmpty(r104) == true) goto L7;
        r101.put(r103, r104);
        goto L7
    L11:
        return r101;
    L4:
        return new HashMap();
    }

    public static JsonObject parseObject(String r100) throws JsonParseException {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        return jsonParser.parse(r100).getAsJsonObject();
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static String toJSONString(Object r100) throws JsonParseException {
        if (r100 != null) goto L10;
        return "";
    L10:
        return GsonHelper.get().toJson(r100);
    L7:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static <T> T parse(String r100, Type r101) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return (T) GsonHelper.get().fromJson(r100, r101);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T> T parseObject(byte[] r100, Class<T> r101) throws JsonParseException {
        if (r100.length != 0) goto L11;
        return null;
    L11:
        return (T) GsonHelper.get().fromJson(new InputStreamReader(new ByteArrayInputStream(r100)), r101);
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static <T> T parseObject(String r100, Class<T> r101) throws JsonParseException {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        return (T) GsonHelper.get().fromJson(r100, r101);
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }
}
