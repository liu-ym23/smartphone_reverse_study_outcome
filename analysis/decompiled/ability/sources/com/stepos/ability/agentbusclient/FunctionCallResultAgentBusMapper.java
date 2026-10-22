package com.stepos.ability.agentbusclient;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0014"}, d2 = {"Lcom/stepos/ability/agentbusclient/FunctionCallResultAgentBusMapper;", "", AppAgent.CONSTRUCT, "()V", "fromJson", "", "", "json", "asFunctionCallResult", "isPresent", "", "value", "jsonObjectToMap", "obj", "Lorg/json/JSONObject;", "jsonArrayToList", "", "arr", "Lorg/json/JSONArray;", "jsonValueToKotlin", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FunctionCallResultAgentBusMapper {
    public static final FunctionCallResultAgentBusMapper INSTANCE = new FunctionCallResultAgentBusMapper();

    private FunctionCallResultAgentBusMapper() {
    }

    private final boolean isPresent(Object value) {
        if (value == null) {
            return false;
        }
        return value instanceof String ? !m.s0((CharSequence) value) : value instanceof Map ? !((Map) value).isEmpty() : ((value instanceof Collection) && ((Collection) value).isEmpty()) ? false : true;
    }

    private final List<Object> jsonArrayToList(JSONArray arr) {
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jsonValueToKotlin(arr.opt(i)));
        }
        return arrayList;
    }

    private final Map<String, Object> jsonObjectToMap(JSONObject obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(obj.length());
        Iterator<String> itKeys = obj.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jsonValueToKotlin(obj.opt(next)));
        }
        return linkedHashMap;
    }

    private final Object jsonValueToKotlin(Object value) {
        if (value == null || value.equals(JSONObject.NULL)) {
            return null;
        }
        return value instanceof JSONObject ? jsonObjectToMap((JSONObject) value) : value instanceof JSONArray ? jsonArrayToList((JSONArray) value) : value;
    }

    public final Map<String, Object> asFunctionCallResult(String json) {
        Object objA;
        if (json == null || m.s0(json)) {
            return kotlin.collections.a.M();
        }
        try {
            objA = jsonObjectToMap(new JSONObject(json));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Object objM = kotlin.collections.a.M();
        if (objA instanceof Result.Failure) {
            objA = objM;
        }
        return (Map) objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.String, java.lang.Object> fromJson(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ok"
            if (r9 == 0) goto Lcb
            boolean r1 = j9.m.s0(r9)
            if (r1 == 0) goto Lc
            goto Lcb
        Lc:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L16
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L16
            java.util.Map r9 = r8.jsonObjectToMap(r1)     // Catch: java.lang.Throwable -> L16
            goto L1b
        L16:
            r9 = move-exception
            kotlin.Result$Failure r9 = kotlin.b.a(r9)
        L1b:
            boolean r1 = r9 instanceof kotlin.Result.Failure
            r2 = 0
            if (r1 == 0) goto L21
            r9 = r2
        L21:
            java.util.Map r9 = (java.util.Map) r9
            if (r9 != 0) goto L31
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r0, r8)
            java.util.Map r8 = kotlin.collections.a.Q(r9)
            return r8
        L31:
            java.lang.String r1 = "success"
            java.lang.Object r1 = r9.get(r1)
            boolean r3 = r1 instanceof java.lang.Boolean
            if (r3 == 0) goto L3e
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            goto L3f
        L3e:
            r1 = r2
        L3f:
            if (r1 == 0) goto L46
            boolean r1 = r1.booleanValue()
            goto L47
        L46:
            r1 = 1
        L47:
            java.lang.String r3 = "content"
            java.lang.Object r4 = r9.get(r3)
            java.lang.String r5 = "structuredContent"
            java.lang.Object r6 = r9.get(r5)
            boolean r7 = r8.isPresent(r4)
            boolean r8 = r8.isPresent(r6)
            if (r7 == 0) goto L72
            if (r8 == 0) goto L72
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r3, r4)
            kotlin.Pair r4 = new kotlin.Pair
            r4.<init>(r5, r6)
            kotlin.Pair[] r8 = new kotlin.Pair[]{r8, r4}
            java.util.Map r4 = kotlin.collections.a.R(r8)
            goto L7a
        L72:
            if (r7 == 0) goto L75
            goto L7a
        L75:
            if (r8 == 0) goto L79
            r4 = r6
            goto L7a
        L79:
            r4 = r2
        L7a:
            kotlin.collections.builders.MapBuilder r8 = new kotlin.collections.builders.MapBuilder
            r8.<init>()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r8.put(r0, r5)
            if (r1 == 0) goto L8e
            if (r4 == 0) goto Lbb
            r8.put(r3, r4)
            goto Lbb
        L8e:
            java.lang.String r0 = "errorCode"
            java.lang.Object r1 = r9.get(r0)
            if (r1 != 0) goto L98
            java.lang.String r1 = "ABILITY_CALL_FAILED"
        L98:
            r8.put(r0, r1)
            java.lang.String r0 = "errorMsg"
            java.lang.Object r0 = r9.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto La8
            java.lang.String r0 = (java.lang.String) r0
            goto La9
        La8:
            r0 = r2
        La9:
            if (r0 == 0) goto Lb4
            int r1 = r0.length()
            if (r1 <= 0) goto Lb2
            r2 = r0
        Lb2:
            if (r2 != 0) goto Lb6
        Lb4:
            java.lang.String r2 = "ability.call failed"
        Lb6:
            java.lang.String r0 = "errorMessage"
            r8.put(r0, r2)
        Lbb:
            java.lang.String r0 = "meta"
            java.lang.Object r9 = r9.get(r0)
            if (r9 == 0) goto Lc6
            r8.put(r0, r9)
        Lc6:
            kotlin.collections.builders.MapBuilder r8 = r8.b()
            return r8
        Lcb:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r0, r8)
            java.util.Map r8 = kotlin.collections.a.Q(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.FunctionCallResultAgentBusMapper.fromJson(java.lang.String):java.util.Map");
    }
}
