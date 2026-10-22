package com.stepos.ability.manager.convertor;

import D7.w;
import Y7.e;
import Y7.f;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.appfunctions.DirectAppFunctions;
import com.stepos.ability.appfunctions.ExecutionExtra;
import com.stepos.ability.commoninternal.CallType;
import com.stepos.ability.commoninternal.CallingMethod;
import com.stepos.ability.net.biz.model.InputSchema;
import com.stepos.ability.net.biz.model.Item;
import com.stepos.ability.net.biz.model.OutputSchema;
import com.stepos.ability.net.biz.model.Property;
import com.stepos.ability.net.biz.model.ToolItem;
import com.stepos.mcp.sdk.java.ServerExt;
import g1.AbstractC1451a;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import org.json.JSONArray;
import org.json.JSONObject;
import u9.c;
import u9.d;

/* loaded from: classes3.dex */
public abstract class a {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020 A[PHI: r3
      0x0020: PHI (r3v11 int) = (r3v3 int), (r3v4 int) binds: [B:6:0x001e, B:9:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.ability.net.biz.model.ToolItem a(b4.C0825a r22) {
        /*
            r0 = r22
            int r1 = r0.c
            io.modelcontextprotocol.spec.McpSchema$Tool r2 = r0.f2015a
            java.lang.String r4 = r2.name()
            java.lang.String r5 = r2.name()
            java.lang.String r3 = "name(...)"
            kotlin.jvm.internal.k.e(r5, r3)
            java.lang.String r3 = r2.description()
            if (r3 != 0) goto L1b
            java.lang.String r3 = ""
        L1b:
            r6 = r3
            r3 = 15
            if (r1 >= r3) goto L22
        L20:
            r1 = r3
            goto L27
        L22:
            r3 = 600(0x258, float:8.41E-43)
            if (r1 <= r3) goto L27
            goto L20
        L27:
            io.modelcontextprotocol.spec.McpSchema$JsonSchema r3 = r2.inputSchema()
            java.lang.String r7 = "inputSchema(...)"
            kotlin.jvm.internal.k.e(r3, r7)
            java.util.Map r7 = r3.properties()
            java.util.LinkedHashMap r7 = c(r7)
            com.stepos.ability.net.biz.model.InputSchema r14 = new com.stepos.ability.net.biz.model.InputSchema
            java.lang.String r8 = r3.type()
            java.lang.String r9 = "object"
            if (r8 != 0) goto L43
            r8 = r9
        L43:
            java.util.List r3 = r3.required()
            r14.<init>(r8, r7, r3)
            java.util.Map r2 = r2.outputSchema()
            r3 = 0
            if (r2 == 0) goto Lb4
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L58
            goto Lb4
        L58:
            java.lang.String r7 = "type"
            java.lang.Object r7 = r2.get(r7)
            if (r7 == 0) goto L68
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L67
            goto L68
        L67:
            r9 = r7
        L68:
            java.lang.String r7 = "properties"
            java.lang.Object r7 = r2.get(r7)
            boolean r8 = r7 instanceof java.util.Map
            if (r8 == 0) goto L75
            java.util.Map r7 = (java.util.Map) r7
            goto L76
        L75:
            r7 = r3
        L76:
            java.util.LinkedHashMap r7 = c(r7)
            java.lang.String r8 = "required"
            java.lang.Object r2 = r2.get(r8)
            boolean r8 = r2 instanceof java.util.List
            if (r8 == 0) goto L87
            java.util.List r2 = (java.util.List) r2
            goto L88
        L87:
            r2 = r3
        L88:
            if (r2 == 0) goto Lad
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r8 = 10
            int r8 = D7.w.c0(r2, r8)
            r3.<init>(r8)
            java.util.Iterator r2 = r2.iterator()
        L9b:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto Lad
            java.lang.Object r8 = r2.next()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r3.add(r8)
            goto L9b
        Lad:
            com.stepos.ability.net.biz.model.OutputSchema r2 = new com.stepos.ability.net.biz.model.OutputSchema
            r2.<init>(r9, r7, r3)
            r15 = r2
            goto Lb5
        Lb4:
            r15 = r3
        Lb5:
            java.util.Map r2 = r0.b
            java.lang.String r0 = r0.d
            com.stepos.ability.net.biz.model.ToolItem r3 = new com.stepos.ability.net.biz.model.ToolItem
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r20 = 24632(0x6038, float:3.4517E-41)
            r21 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "MCP"
            java.lang.String r11 = "LOCAL"
            java.lang.String r13 = "PHONE"
            r17 = 0
            r18 = 0
            r19 = r0
            r16 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.convertor.a.a(b4.a):com.stepos.ability.net.biz.model.ToolItem");
    }

    public static ToolItem b(DirectAppFunctions.Entry entry, String toolName) {
        OutputSchema outputSchema;
        k.f(entry, "entry");
        k.f(toolName, "toolName");
        DirectAppFunctions directAppFunctions = DirectAppFunctions.INSTANCE;
        JSONObject anthropicTool = directAppFunctions.toAnthropicTool(entry, toolName);
        String strOptString = anthropicTool.optString("description");
        if (m.s0(strOptString) && (strOptString = entry.getDescription()) == null) {
            strOptString = B7.a.k("AppFunction ", entry.getFunctionId());
        }
        JSONObject jSONObject = anthropicTool.getJSONObject("input_schema");
        k.e(jSONObject, "getJSONObject(...)");
        InputSchema inputSchemaF = f(jSONObject);
        JSONObject outputSchemaJson = directAppFunctions.toOutputSchemaJson(entry);
        if (outputSchemaJson != null) {
            InputSchema inputSchemaF2 = f(outputSchemaJson);
            outputSchema = new OutputSchema(inputSchemaF2.getType(), inputSchemaF2.getProperties(), inputSchemaF2.getRequired());
        } else {
            outputSchema = null;
        }
        OutputSchema outputSchema2 = outputSchema;
        String functionId = entry.getFunctionId();
        k.c(strOptString);
        return new ToolItem(toolName, functionId, strOptString, null, null, null, CallType.FUNCTION_CALL, CallingMethod.LOCAL, 150, "PHONE", inputSchemaF, outputSchema2, ExecutionExtra.INSTANCE.toExecutionExtra(entry), null, null, null, 57400, null);
    }

    public static LinkedHashMap c(Map map) {
        Property property;
        LinkedHashMap linkedHashMapC;
        Item item;
        Item item2;
        String string;
        ArrayList arrayList;
        String string2;
        if (map == null || map.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !(value instanceof Map)) {
                property = new Property(TypedValues.Custom.S_STRING, null, null, null, null, 28, null);
            } else {
                Map map2 = (Map) value;
                Object obj = map2.get("type");
                String str = (obj == null || (string2 = obj.toString()) == null) ? "object" : string2;
                Object obj2 = map2.get("description");
                String string3 = obj2 != null ? obj2.toString() : null;
                Object obj3 = map2.get("default");
                if (str.equals("object")) {
                    Object obj4 = map2.get("properties");
                    linkedHashMapC = c(obj4 instanceof Map ? (Map) obj4 : null);
                } else {
                    linkedHashMapC = null;
                }
                if (str.equals("array")) {
                    Object obj5 = map2.get("items");
                    if (obj5 == null || !(obj5 instanceof Map)) {
                        item2 = null;
                    } else {
                        Map map3 = (Map) obj5;
                        Object obj6 = map3.get("type");
                        if (obj6 == null || (string = obj6.toString()) == null) {
                            string = TypedValues.Custom.S_STRING;
                        }
                        Object obj7 = map3.get("properties");
                        LinkedHashMap linkedHashMapC2 = c(obj7 instanceof Map ? (Map) obj7 : null);
                        Object obj8 = map3.get("required");
                        List list = obj8 instanceof List ? (List) obj8 : null;
                        if (list != null) {
                            List list2 = list;
                            arrayList = new ArrayList(w.c0(list2, 10));
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(String.valueOf(it.next()));
                            }
                        } else {
                            arrayList = null;
                        }
                        item2 = new Item(string, linkedHashMapC2, arrayList);
                    }
                    item = item2;
                } else {
                    item = null;
                }
                property = new Property(str, string3, linkedHashMapC, item, obj3);
            }
            linkedHashMap.put(key, property);
        }
        return linkedHashMap;
    }

    public static LinkedHashMap d(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, e(jSONObject.get(next)));
        }
        return linkedHashMap;
    }

    public static Object e(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return d((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        f fVarX = AbstractC1451a.X(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
        e it = fVarX.iterator();
        while (it.c) {
            arrayList.add(e(jSONArray.get(it.nextInt())));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.ability.net.biz.model.InputSchema f(org.json.JSONObject r7) {
        /*
            java.lang.String r0 = "type"
            java.lang.String r1 = "object"
            java.lang.String r0 = r7.optString(r0, r1)
            java.lang.String r1 = "properties"
            org.json.JSONObject r1 = r7.optJSONObject(r1)
            r2 = 0
            if (r1 == 0) goto L1a
            java.util.LinkedHashMap r1 = d(r1)
            java.util.LinkedHashMap r1 = c(r1)
            goto L1b
        L1a:
            r1 = r2
        L1b:
            java.lang.String r3 = "required"
            org.json.JSONArray r7 = r7.optJSONArray(r3)
            if (r7 == 0) goto L57
            r3 = 0
            int r4 = r7.length()
            Y7.f r3 = g1.AbstractC1451a.X(r3, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            Y7.e r3 = r3.iterator()
        L35:
            boolean r5 = r3.c
            if (r5 == 0) goto L56
            int r5 = r3.nextInt()
            java.lang.Object r5 = r7.opt(r5)
            if (r5 == 0) goto L4f
            java.lang.Object r6 = org.json.JSONObject.NULL
            if (r5 != r6) goto L48
            r5 = r2
        L48:
            if (r5 == 0) goto L4f
            java.lang.String r5 = r5.toString()
            goto L50
        L4f:
            r5 = r2
        L50:
            if (r5 == 0) goto L35
            r4.add(r5)
            goto L35
        L56:
            r2 = r4
        L57:
            com.stepos.ability.net.biz.model.InputSchema r7 = new com.stepos.ability.net.biz.model.InputSchema
            kotlin.jvm.internal.k.c(r0)
            r7.<init>(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.convertor.a.f(org.json.JSONObject):com.stepos.ability.net.biz.model.InputSchema");
    }

    public static Object g(List list, List list2, ServerExt serverExt, String str, ContinuationImpl continuationImpl) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(c.f6743a, new ToolConverter$processList$2(serverExt, list, list2, str, null), continuationImpl);
    }
}
