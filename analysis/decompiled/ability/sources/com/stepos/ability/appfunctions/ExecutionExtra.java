package com.stepos.ability.appfunctions;

import H4.o;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.appfunctions.DirectAppFunctions;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f*\u00020\rJ0\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0016H\u0002J\f\u0010\u001b\u001a\u00020\u0016*\u00020\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\fH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\f2\u0006\u0010 \u001a\u00020\u001aH\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001eH\u0002J\f\u0010!\u001a\u00020\u001e*\u00020\u001aH\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\"H\u0002J\f\u0010#\u001a\u00020\"*\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/stepos/ability/appfunctions/ExecutionExtra;", "", AppAgent.CONSTRUCT, "()V", "KEY_VERSION", "", "KEY_PARAMETERS_JSON", "KEY_COMPONENTS_JSON", "KEY_RESPONSE_TYPE_REF", "CURRENT_VERSION", "", "toExecutionExtra", "", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$Entry;", "entryFromExtra", "extra", "pkg", "functionId", "parametersToJson", "Lorg/json/JSONArray;", "parameters", "", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$Param;", "parametersFromJson", "arr", "toJson", "Lorg/json/JSONObject;", "toParam", "componentsToJson", "components", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$ObjectSchema;", "componentsFromJson", "root", "toObjectSchema", "Lcom/stepos/ability/appfunctions/DirectAppFunctions$PropertySchema;", "toPropertySchema", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExecutionExtra {
    public static final int CURRENT_VERSION = 1;
    public static final ExecutionExtra INSTANCE = new ExecutionExtra();
    public static final String KEY_COMPONENTS_JSON = "componentsJson";
    public static final String KEY_PARAMETERS_JSON = "parametersJson";
    public static final String KEY_RESPONSE_TYPE_REF = "responseTypeRef";
    public static final String KEY_VERSION = "executionSchemaVersion";

    private ExecutionExtra() {
    }

    private final Map<String, DirectAppFunctions.ObjectSchema> componentsFromJson(JSONObject root) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = root.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject = root.getJSONObject(next);
            k.e(jSONObject, "getJSONObject(...)");
            linkedHashMap.put(next, toObjectSchema(jSONObject));
        }
        return linkedHashMap;
    }

    private final JSONObject componentsToJson(Map<String, DirectAppFunctions.ObjectSchema> components) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, DirectAppFunctions.ObjectSchema> entry : components.entrySet()) {
            jSONObject.put(entry.getKey(), INSTANCE.toJson(entry.getValue()));
        }
        return jSONObject;
    }

    private final List<DirectAppFunctions.Param> parametersFromJson(JSONArray arr) throws JSONException {
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = arr.getJSONObject(i);
            k.e(jSONObject, "getJSONObject(...)");
            arrayList.add(toParam(jSONObject));
        }
        return arrayList;
    }

    private final JSONArray parametersToJson(List<DirectAppFunctions.Param> parameters) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            jSONArray.put(INSTANCE.toJson((DirectAppFunctions.Param) it.next()));
        }
        return jSONArray;
    }

    private final JSONObject toJson(DirectAppFunctions.Param param) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, param.getName());
        jSONObject.put("isRequired", param.isRequired());
        jSONObject.put("type", param.getType());
        jSONObject.put("isNullable", param.isNullable());
        if (param.getDescription() != null) {
            jSONObject.put("description", param.getDescription());
        }
        if (param.getRefQualifiedName() != null) {
            jSONObject.put("refQualifiedName", param.getRefQualifiedName());
        }
        return jSONObject;
    }

    private final DirectAppFunctions.ObjectSchema toObjectSchema(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
            k.e(jSONObject3, "getJSONObject(...)");
            linkedHashMap.put(next, toPropertySchema(jSONObject3));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("required");
        ListBuilder listBuilderY = o.y();
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                listBuilderY.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        ListBuilder listBuilderQ = o.q(listBuilderY);
        String string = jSONObject.getString("qualifiedName");
        k.e(string, "getString(...)");
        return new DirectAppFunctions.ObjectSchema(string, linkedHashMap, listBuilderQ, jSONObject.optBoolean("isNullable", true));
    }

    private final DirectAppFunctions.Param toParam(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString(HintConstants.AUTOFILL_HINT_NAME);
        k.e(string, "getString(...)");
        boolean zOptBoolean = jSONObject.optBoolean("isRequired", false);
        int iOptInt = jSONObject.optInt("type");
        boolean zOptBoolean2 = jSONObject.optBoolean("isNullable", false);
        String strOptString = jSONObject.optString("description");
        k.c(strOptString);
        if (m.s0(strOptString)) {
            strOptString = null;
        }
        String strOptString2 = jSONObject.optString("refQualifiedName");
        k.c(strOptString2);
        return new DirectAppFunctions.Param(string, zOptBoolean, iOptInt, zOptBoolean2, strOptString, !m.s0(strOptString2) ? strOptString2 : null);
    }

    private final DirectAppFunctions.PropertySchema toPropertySchema(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("type");
        boolean zOptBoolean = jSONObject.optBoolean("isNullable", false);
        String strOptString = jSONObject.optString("description");
        k.c(strOptString);
        if (m.s0(strOptString)) {
            strOptString = null;
        }
        String strOptString2 = jSONObject.optString("refQualifiedName");
        k.c(strOptString2);
        String str = !m.s0(strOptString2) ? strOptString2 : null;
        String strOptString3 = jSONObject.optString("arrayItemQualifiedName");
        k.c(strOptString3);
        return new DirectAppFunctions.PropertySchema(iOptInt, zOptBoolean, strOptString, str, !m.s0(strOptString3) ? strOptString3 : null);
    }

    public final DirectAppFunctions.Entry entryFromExtra(Map<String, ? extends Object> extra, String pkg, String functionId) {
        Object obj;
        String string;
        String string2;
        String string3;
        String string4;
        k.f(pkg, "pkg");
        k.f(functionId, "functionId");
        if (extra != null && !extra.isEmpty() && (obj = extra.get(KEY_PARAMETERS_JSON)) != null && (string = obj.toString()) != null) {
            if (m.s0(string)) {
                string = null;
            }
            if (string != null) {
                String string5 = m.R0(pkg).toString();
                String str = string5.length() > 0 ? string5 : null;
                if (str == null) {
                    return null;
                }
                String string6 = m.R0(functionId).toString();
                String str2 = string6.length() > 0 ? string6 : null;
                if (str2 == null) {
                    return null;
                }
                try {
                    List<DirectAppFunctions.Param> listParametersFromJson = parametersFromJson(new JSONArray(string));
                    Object obj2 = extra.get(KEY_COMPONENTS_JSON);
                    if (obj2 == null || (string2 = obj2.toString()) == null || m.s0(string2)) {
                        string2 = null;
                    }
                    Map<String, DirectAppFunctions.ObjectSchema> mapComponentsFromJson = string2 != null ? componentsFromJson(new JSONObject(string2)) : a.M();
                    Object obj3 = extra.get(KEY_RESPONSE_TYPE_REF);
                    return new DirectAppFunctions.Entry(str, str2, "", null, null, 0L, null, false, listParametersFromJson, (obj3 == null || (string3 = obj3.toString()) == null || (string4 = m.R0(string3).toString()) == null || string4.length() <= 0) ? null : string4, mapComponentsFromJson, 248, null);
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    public final Map<String, Object> toExecutionExtra(DirectAppFunctions.Entry entry) {
        k.f(entry, "<this>");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put(KEY_VERSION, 1);
        ExecutionExtra executionExtra = INSTANCE;
        String string = executionExtra.parametersToJson(entry.getParameters()).toString();
        k.e(string, "toString(...)");
        mapBuilder.put(KEY_PARAMETERS_JSON, string);
        String string2 = executionExtra.componentsToJson(entry.getComponents()).toString();
        k.e(string2, "toString(...)");
        mapBuilder.put(KEY_COMPONENTS_JSON, string2);
        String responseTypeRef = entry.getResponseTypeRef();
        if (responseTypeRef != null) {
            if (m.s0(responseTypeRef)) {
                responseTypeRef = null;
            }
            if (responseTypeRef != null) {
                mapBuilder.put(KEY_RESPONSE_TYPE_REF, responseTypeRef);
            }
        }
        return mapBuilder.b();
    }

    private final JSONObject toJson(DirectAppFunctions.ObjectSchema objectSchema) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("qualifiedName", objectSchema.getQualifiedName());
        jSONObject.put("isNullable", objectSchema.isNullable());
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = objectSchema.getRequired().iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        jSONObject.put("required", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, DirectAppFunctions.PropertySchema> entry : objectSchema.getProperties().entrySet()) {
            jSONObject2.put(entry.getKey(), INSTANCE.toJson(entry.getValue()));
        }
        jSONObject.put("properties", jSONObject2);
        return jSONObject;
    }

    private final JSONObject toJson(DirectAppFunctions.PropertySchema propertySchema) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", propertySchema.getType());
        jSONObject.put("isNullable", propertySchema.isNullable());
        if (propertySchema.getDescription() != null) {
            jSONObject.put("description", propertySchema.getDescription());
        }
        if (propertySchema.getRefQualifiedName() != null) {
            jSONObject.put("refQualifiedName", propertySchema.getRefQualifiedName());
        }
        if (propertySchema.getArrayItemQualifiedName() != null) {
            jSONObject.put("arrayItemQualifiedName", propertySchema.getArrayItemQualifiedName());
        }
        return jSONObject;
    }
}
