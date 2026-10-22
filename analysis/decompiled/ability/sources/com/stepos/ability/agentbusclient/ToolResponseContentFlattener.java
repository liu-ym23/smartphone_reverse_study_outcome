package com.stepos.ability.agentbusclient;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/stepos/ability/agentbusclient/ToolResponseContentFlattener;", "", AppAgent.CONSTRUCT, "()V", "flatten", "content", "", "parseValue", "value", "objectToMap", "", "obj", "Lorg/json/JSONObject;", "arrayToList", "", "arr", "Lorg/json/JSONArray;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolResponseContentFlattener {
    public static final ToolResponseContentFlattener INSTANCE = new ToolResponseContentFlattener();

    private ToolResponseContentFlattener() {
    }

    private final List<Object> arrayToList(JSONArray arr) {
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(parseValue(arr.opt(i)));
        }
        return arrayList;
    }

    private final Map<String, Object> objectToMap(JSONObject obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(obj.length());
        Iterator<String> itKeys = obj.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, parseValue(obj.opt(next)));
        }
        return linkedHashMap;
    }

    private final Object parseValue(Object value) {
        Object objA;
        if (value == null || value.equals(JSONObject.NULL)) {
            return null;
        }
        if (value instanceof JSONObject) {
            return objectToMap((JSONObject) value);
        }
        if (value instanceof JSONArray) {
            return arrayToList((JSONArray) value);
        }
        if (!(value instanceof String)) {
            return value;
        }
        String string = m.R0((String) value).toString();
        if (t.e0(string, "{", false)) {
            try {
                objA = objectToMap(new JSONObject(string));
            } catch (Throwable th) {
                objA = b.a(th);
            }
            if (objA instanceof Result.Failure) {
                return value;
            }
        } else {
            if (!t.e0(string, "[", false)) {
                return value;
            }
            try {
                objA = arrayToList(new JSONArray(string));
            } catch (Throwable th2) {
                objA = b.a(th2);
            }
            if (objA instanceof Result.Failure) {
                return value;
            }
        }
        return objA;
    }

    public final Object flatten(String content) {
        if (content == null || m.s0(content)) {
            return null;
        }
        return parseValue(content);
    }
}
