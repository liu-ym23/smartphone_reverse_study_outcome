package com.stepos.ability.appfunctions;

import B7.a;
import D7.N;
import H4.o;
import androidx.appfunctions.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionArrayTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionBooleanTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionBytesTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionDoubleTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionFloatTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionIntTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionLongTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionObjectTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionOneOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionParcelableTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionReferenceTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.AppFunctionStringTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionUnitTypeMetadata;
import androidx.autofill.HintConstants;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b*\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u0005*\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\u001fH\u0002¢\u0006\u0004\b\u000e\u0010 J\u001b\u0010#\u001a\u00020\r*\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020(*\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\u001f*\u00020\rH\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0-*\u00020\rH\u0002¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\b\u0012\u0004\u0012\u00020!0\u0004*\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b0\u0010\fJ\u0019\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004*\u00020\u0007H\u0002¢\u0006\u0004\b1\u0010\fJ\u0019\u00102\u001a\b\u0012\u0004\u0012\u00020&0%*\u00020\u0007H\u0002¢\u0006\u0004\b2\u00103J\u0019\u00104\u001a\b\u0012\u0004\u0012\u00020!0%*\u00020\u0007H\u0002¢\u0006\u0004\b4\u00103J\u001d\u00106\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010-*\u000205¢\u0006\u0004\b6\u00107J7\u0010;\u001a\u0004\u0018\u0001052\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020!¢\u0006\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010@\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010>R\u0014\u0010A\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010>R\u0014\u0010B\u001a\u00020&8\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010>R\u0014\u0010E\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010>R\u0014\u0010F\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010>R\u0014\u0010G\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010>R\u0014\u0010H\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010>R\u0014\u0010I\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010>R\u0014\u0010J\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010>R\u0014\u0010K\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010>R\u0014\u0010L\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010>R\u0014\u0010M\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010>R\u0014\u0010N\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010>R\u0014\u0010O\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010>R\u0014\u0010P\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010>R\u0014\u0010Q\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010>R\u0014\u0010R\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010>R\u0014\u0010S\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010>R\u0014\u0010T\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010>R\u0014\u0010U\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010>R\u0014\u0010V\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010>R\u0014\u0010W\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010>R\u0014\u0010X\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010>R\u0014\u0010Y\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010>R\u0014\u0010Z\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010>R\u0014\u0010[\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010>R\u0014\u0010\\\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\\\u0010>R\u0014\u0010]\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010>R\u0014\u0010^\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010>¨\u0006_"}, d2 = {"Lcom/stepos/ability/appfunctions/JetpackAppFunctionsExt;", "", AppAgent.CONSTRUCT, "()V", "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "parameters", "Lorg/json/JSONArray;", "parametersToJson", "(Ljava/util/List;)Lorg/json/JSONArray;", "arr", "parametersFromJson", "(Lorg/json/JSONArray;)Ljava/util/List;", "Lorg/json/JSONObject;", "toJson", "(Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;)Lorg/json/JSONObject;", "toParameter", "(Lorg/json/JSONObject;)Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "response", "responseToJson", "(Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;)Lorg/json/JSONObject;", "obj", "responseFromJson", "(Lorg/json/JSONObject;)Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "components", "componentsToJson", "(Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Lorg/json/JSONObject;", "componentsFromJson", "(Lorg/json/JSONObject;)Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;)Lorg/json/JSONObject;", "", JetpackAppFunctionsExt.FIELD_KIND, "primitiveJson", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)Lorg/json/JSONObject;", "", "", "values", "LC7/r;", "putEnumValues", "(Lorg/json/JSONObject;Ljava/util/Set;)V", "toDataType", "(Lorg/json/JSONObject;)Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "", "toPropertiesMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "toStringList", "toDataTypeList", "toIntSet", "(Lorg/json/JSONArray;)Ljava/util/Set;", "toStringSet", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "toExecutionExtra", "(Landroidx/appfunctions/metadata/AppFunctionMetadata;)Ljava/util/Map;", "extra", "packageName", "functionId", "metadataFromExtra", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Landroidx/appfunctions/metadata/AppFunctionMetadata;", "KEY_VERSION", "Ljava/lang/String;", "KEY_PARAMETERS_JSON", "KEY_RESPONSE_JSON", "KEY_COMPONENTS_JSON", "CURRENT_VERSION", "I", "FIELD_KIND", "FIELD_IS_NULLABLE", "FIELD_DESCRIPTION", "FIELD_ENUM_VALUES", "FIELD_QUALIFIED_NAME", "FIELD_REQUIRED", "FIELD_PROPERTIES", "FIELD_ITEM_TYPE", "FIELD_REFERENCE_DATA_TYPE", "FIELD_MATCH_ALL", "FIELD_MATCH_ONE_OF", "FIELD_VALUE_TYPE", "FIELD_DATA_TYPES", "KIND_BOOLEAN", "KIND_INT", "KIND_LONG", "KIND_FLOAT", "KIND_DOUBLE", "KIND_STRING", "KIND_BYTES", "KIND_UNIT", "KIND_OBJECT", "KIND_ARRAY", "KIND_REFERENCE", "KIND_ALL_OF", "KIND_ONE_OF", "KIND_PARCELABLE", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JetpackAppFunctionsExt {
    public static final int CURRENT_VERSION = 1;
    private static final String FIELD_DATA_TYPES = "dataTypes";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_ENUM_VALUES = "enumValues";
    private static final String FIELD_IS_NULLABLE = "isNullable";
    private static final String FIELD_ITEM_TYPE = "itemType";
    private static final String FIELD_KIND = "kind";
    private static final String FIELD_MATCH_ALL = "matchAll";
    private static final String FIELD_MATCH_ONE_OF = "matchOneOf";
    private static final String FIELD_PROPERTIES = "properties";
    private static final String FIELD_QUALIFIED_NAME = "qualifiedName";
    private static final String FIELD_REFERENCE_DATA_TYPE = "referenceDataType";
    private static final String FIELD_REQUIRED = "required";
    private static final String FIELD_VALUE_TYPE = "valueType";
    public static final JetpackAppFunctionsExt INSTANCE = new JetpackAppFunctionsExt();
    public static final String KEY_COMPONENTS_JSON = "jetpackComponentsJson";
    public static final String KEY_PARAMETERS_JSON = "jetpackParametersJson";
    public static final String KEY_RESPONSE_JSON = "jetpackResponseJson";
    public static final String KEY_VERSION = "jetpackSchemaVersion";
    private static final String KIND_ALL_OF = "allOf";
    private static final String KIND_ARRAY = "array";
    private static final String KIND_BOOLEAN = "boolean";
    private static final String KIND_BYTES = "bytes";
    private static final String KIND_DOUBLE = "double";
    private static final String KIND_FLOAT = "float";
    private static final String KIND_INT = "int";
    private static final String KIND_LONG = "long";
    private static final String KIND_OBJECT = "object";
    private static final String KIND_ONE_OF = "oneOf";
    private static final String KIND_PARCELABLE = "parcelable";
    private static final String KIND_REFERENCE = "reference";
    private static final String KIND_STRING = "string";
    private static final String KIND_UNIT = "unit";

    private JetpackAppFunctionsExt() {
    }

    private final AppFunctionComponentsMetadata componentsFromJson(JSONObject obj) throws JSONException {
        JSONObject jSONObject = obj.getJSONObject(FIELD_DATA_TYPES);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            k.e(jSONObject2, "getJSONObject(...)");
            linkedHashMap.put(next, toDataType(jSONObject2));
        }
        return new AppFunctionComponentsMetadata(linkedHashMap);
    }

    private final JSONObject componentsToJson(AppFunctionComponentsMetadata components) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : components.getDataTypes().entrySet()) {
            jSONObject2.put(entry.getKey(), INSTANCE.toJson(entry.getValue()));
        }
        jSONObject.put(FIELD_DATA_TYPES, jSONObject2);
        return jSONObject;
    }

    private final List<AppFunctionParameterMetadata> parametersFromJson(JSONArray arr) throws JSONException {
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = arr.getJSONObject(i);
            k.e(jSONObject, "getJSONObject(...)");
            arrayList.add(toParameter(jSONObject));
        }
        return arrayList;
    }

    private final JSONArray parametersToJson(List<AppFunctionParameterMetadata> parameters) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            jSONArray.put(INSTANCE.toJson((AppFunctionParameterMetadata) it.next()));
        }
        return jSONArray;
    }

    private final JSONObject primitiveJson(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FIELD_KIND, str);
        jSONObject.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
        jSONObject.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
        return jSONObject;
    }

    private final void putEnumValues(JSONObject jSONObject, Set<Integer> set) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Number) it.next()).intValue());
        }
        jSONObject.put(FIELD_ENUM_VALUES, jSONArray);
    }

    private final AppFunctionResponseMetadata responseFromJson(JSONObject obj) throws JSONException {
        JSONObject jSONObject = obj.getJSONObject(FIELD_VALUE_TYPE);
        k.e(jSONObject, "getJSONObject(...)");
        AppFunctionDataTypeMetadata dataType = toDataType(jSONObject);
        String strOptString = obj.optString(FIELD_DESCRIPTION, "");
        k.e(strOptString, "optString(...)");
        return new AppFunctionResponseMetadata(dataType, strOptString);
    }

    private final JSONObject responseToJson(AppFunctionResponseMetadata response) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FIELD_DESCRIPTION, response.getDescription());
        jSONObject.put(FIELD_VALUE_TYPE, INSTANCE.toJson(response.getValueType()));
        return jSONObject;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final AppFunctionDataTypeMetadata toDataType(JSONObject jSONObject) throws JSONException {
        Set stringSet;
        String string = jSONObject.getString(FIELD_KIND);
        boolean zOptBoolean = jSONObject.optBoolean(FIELD_IS_NULLABLE, false);
        String strOptString = jSONObject.optString(FIELD_DESCRIPTION, "");
        if (string != null) {
            switch (string.hashCode()) {
                case -1325958191:
                    if (string.equals(KIND_DOUBLE)) {
                        k.c(strOptString);
                        return new AppFunctionDoubleTypeMetadata(zOptBoolean, strOptString);
                    }
                    break;
                case -1023368385:
                    if (string.equals(KIND_OBJECT)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(FIELD_PROPERTIES);
                        k.e(jSONObject2, "getJSONObject(...)");
                        Map<String, AppFunctionDataTypeMetadata> propertiesMap = toPropertiesMap(jSONObject2);
                        List<String> stringList = toStringList(jSONObject.optJSONArray(FIELD_REQUIRED));
                        String string2 = jSONObject.getString(FIELD_QUALIFIED_NAME);
                        k.c(strOptString);
                        return new AppFunctionObjectTypeMetadata(propertiesMap, stringList, string2, zOptBoolean, strOptString);
                    }
                    break;
                case -925155509:
                    if (string.equals("reference")) {
                        String string3 = jSONObject.getString(FIELD_REFERENCE_DATA_TYPE);
                        k.e(string3, "getString(...)");
                        k.c(strOptString);
                        return new AppFunctionReferenceTypeMetadata(string3, zOptBoolean, strOptString);
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(FIELD_ENUM_VALUES);
                        stringSet = jSONArrayOptJSONArray != null ? toStringSet(jSONArrayOptJSONArray) : null;
                        Set set = stringSet;
                        if (set == null || set.isEmpty()) {
                            k.c(strOptString);
                            return new AppFunctionStringTypeMetadata(zOptBoolean, strOptString, null, 4, null);
                        }
                        k.c(strOptString);
                        return new AppFunctionStringTypeMetadata(zOptBoolean, strOptString, stringSet);
                    }
                    break;
                case 104431:
                    if (string.equals(KIND_INT)) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(FIELD_ENUM_VALUES);
                        stringSet = jSONArrayOptJSONArray2 != null ? toIntSet(jSONArrayOptJSONArray2) : null;
                        Set set2 = stringSet;
                        if (set2 == null || set2.isEmpty()) {
                            k.c(strOptString);
                            return new AppFunctionIntTypeMetadata(zOptBoolean, strOptString, null, 4, null);
                        }
                        k.c(strOptString);
                        return new AppFunctionIntTypeMetadata(zOptBoolean, strOptString, stringSet);
                    }
                    break;
                case 3327612:
                    if (string.equals(KIND_LONG)) {
                        k.c(strOptString);
                        return new AppFunctionLongTypeMetadata(zOptBoolean, strOptString);
                    }
                    break;
                case 3594628:
                    if (string.equals(KIND_UNIT)) {
                        k.c(strOptString);
                        return new AppFunctionUnitTypeMetadata(zOptBoolean, strOptString);
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        k.c(strOptString);
                        return new AppFunctionBooleanTypeMetadata(zOptBoolean, strOptString);
                    }
                    break;
                case 92905304:
                    if (string.equals(KIND_ALL_OF)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(FIELD_MATCH_ALL);
                        k.e(jSONArray, "getJSONArray(...)");
                        List<AppFunctionDataTypeMetadata> dataTypeList = toDataTypeList(jSONArray);
                        String strOptString2 = jSONObject.optString(FIELD_QUALIFIED_NAME, "");
                        k.c(strOptString);
                        return new AppFunctionAllOfTypeMetadata(dataTypeList, strOptString2, zOptBoolean, strOptString);
                    }
                    break;
                case 93090393:
                    if (string.equals(KIND_ARRAY)) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject(FIELD_ITEM_TYPE);
                        k.e(jSONObject3, "getJSONObject(...)");
                        AppFunctionDataTypeMetadata dataType = toDataType(jSONObject3);
                        k.c(strOptString);
                        return new AppFunctionArrayTypeMetadata(dataType, zOptBoolean, strOptString);
                    }
                    break;
                case 94224491:
                    if (string.equals("bytes")) {
                        k.c(strOptString);
                        return new AppFunctionBytesTypeMetadata(zOptBoolean, strOptString);
                    }
                    break;
                case 97526364:
                    if (string.equals("float")) {
                        k.c(strOptString);
                        return new AppFunctionFloatTypeMetadata(zOptBoolean, strOptString);
                    }
                    break;
                case 105887453:
                    if (string.equals(KIND_ONE_OF)) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray(FIELD_MATCH_ONE_OF);
                        k.e(jSONArray2, "getJSONArray(...)");
                        List<AppFunctionDataTypeMetadata> dataTypeList2 = toDataTypeList(jSONArray2);
                        String strOptString3 = jSONObject.optString(FIELD_QUALIFIED_NAME, "");
                        k.e(strOptString3, "optString(...)");
                        k.c(strOptString);
                        return new AppFunctionOneOfTypeMetadata(dataTypeList2, strOptString3, zOptBoolean, strOptString);
                    }
                    break;
                case 2010605795:
                    if (string.equals(KIND_PARCELABLE)) {
                        String string4 = jSONObject.getString(FIELD_QUALIFIED_NAME);
                        k.e(string4, "getString(...)");
                        k.c(strOptString);
                        return new AppFunctionParcelableTypeMetadata(string4, zOptBoolean, strOptString);
                    }
                    break;
            }
        }
        throw new IllegalArgumentException(a.k("Unknown dataType kind: ", string));
    }

    private final List<AppFunctionDataTypeMetadata> toDataTypeList(JSONArray jSONArray) throws JSONException {
        ListBuilder listBuilder = new ListBuilder(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JetpackAppFunctionsExt jetpackAppFunctionsExt = INSTANCE;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            k.e(jSONObject, "getJSONObject(...)");
            listBuilder.add(jetpackAppFunctionsExt.toDataType(jSONObject));
        }
        return o.q(listBuilder);
    }

    private final Set<Integer> toIntSet(JSONArray jSONArray) {
        SetBuilder setBuilder = new SetBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            setBuilder.add(Integer.valueOf(jSONArray.getInt(i)));
        }
        return N.m(setBuilder);
    }

    private final JSONObject toJson(AppFunctionParameterMetadata appFunctionParameterMetadata) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, appFunctionParameterMetadata.getName());
        jSONObject.put("isRequired", appFunctionParameterMetadata.getIsRequired());
        jSONObject.put(FIELD_DESCRIPTION, appFunctionParameterMetadata.getDescription());
        jSONObject.put("dataType", INSTANCE.toJson(appFunctionParameterMetadata.getDataType()));
        return jSONObject;
    }

    private final AppFunctionParameterMetadata toParameter(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString(HintConstants.AUTOFILL_HINT_NAME);
        k.e(string, "getString(...)");
        boolean zOptBoolean = jSONObject.optBoolean("isRequired", false);
        JSONObject jSONObject2 = jSONObject.getJSONObject("dataType");
        k.e(jSONObject2, "getJSONObject(...)");
        AppFunctionDataTypeMetadata dataType = toDataType(jSONObject2);
        String strOptString = jSONObject.optString(FIELD_DESCRIPTION, "");
        k.e(strOptString, "optString(...)");
        return new AppFunctionParameterMetadata(string, zOptBoolean, dataType, strOptString);
    }

    private final Map<String, AppFunctionDataTypeMetadata> toPropertiesMap(JSONObject jSONObject) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            k.e(jSONObject2, "getJSONObject(...)");
            linkedHashMap.put(next, toDataType(jSONObject2));
        }
        return linkedHashMap;
    }

    private final List<String> toStringList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return EmptyList.f4893a;
        }
        ListBuilder listBuilder = new ListBuilder(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            k.e(string, "getString(...)");
            listBuilder.add(string);
        }
        return o.q(listBuilder);
    }

    private final Set<String> toStringSet(JSONArray jSONArray) throws JSONException {
        SetBuilder setBuilder = new SetBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            k.e(string, "getString(...)");
            setBuilder.add(string);
        }
        return N.m(setBuilder);
    }

    public final AppFunctionMetadata metadataFromExtra(Map<String, ? extends Object> extra, String packageName, String functionId) {
        Object obj;
        String string;
        Object obj2;
        String string2;
        Object obj3;
        String string3;
        String string4;
        k.f(packageName, "packageName");
        k.f(functionId, "functionId");
        if (extra != null && !extra.isEmpty()) {
            Object obj4 = extra.get(KEY_VERSION);
            Integer numF0 = (obj4 == null || (string4 = obj4.toString()) == null) ? null : t.f0(string4);
            if (numF0 != null && numF0.intValue() <= 1 && (obj = extra.get(KEY_PARAMETERS_JSON)) != null && (string = obj.toString()) != null) {
                if (m.s0(string)) {
                    string = null;
                }
                if (string != null && (obj2 = extra.get(KEY_RESPONSE_JSON)) != null && (string2 = obj2.toString()) != null) {
                    if (m.s0(string2)) {
                        string2 = null;
                    }
                    if (string2 != null && (obj3 = extra.get(KEY_COMPONENTS_JSON)) != null && (string3 = obj3.toString()) != null) {
                        if (m.s0(string3)) {
                            string3 = null;
                        }
                        if (string3 != null) {
                            String string5 = m.R0(packageName).toString();
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
                                return new AppFunctionMetadata(str2, str, true, null, parametersFromJson(new JSONArray(string)), responseFromJson(new JSONObject(string2)), componentsFromJson(new JSONObject(string3)), "", null, 256, null);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final Map<String, Object> toExecutionExtra(AppFunctionMetadata appFunctionMetadata) {
        k.f(appFunctionMetadata, "<this>");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put(KEY_VERSION, 1);
        JetpackAppFunctionsExt jetpackAppFunctionsExt = INSTANCE;
        String string = jetpackAppFunctionsExt.parametersToJson(appFunctionMetadata.getParameters()).toString();
        k.e(string, "toString(...)");
        mapBuilder.put(KEY_PARAMETERS_JSON, string);
        String string2 = jetpackAppFunctionsExt.responseToJson(appFunctionMetadata.getResponse()).toString();
        k.e(string2, "toString(...)");
        mapBuilder.put(KEY_RESPONSE_JSON, string2);
        String string3 = jetpackAppFunctionsExt.componentsToJson(appFunctionMetadata.getComponents()).toString();
        k.e(string3, "toString(...)");
        mapBuilder.put(KEY_COMPONENTS_JSON, string3);
        return mapBuilder.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JSONObject toJson(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata) throws JSONException {
        Set set;
        if (appFunctionDataTypeMetadata instanceof AppFunctionBooleanTypeMetadata) {
            return primitiveJson(appFunctionDataTypeMetadata, "boolean");
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionIntTypeMetadata) {
            JSONObject jSONObjectPrimitiveJson = primitiveJson(appFunctionDataTypeMetadata, KIND_INT);
            Set<Integer> enumValues = ((AppFunctionIntTypeMetadata) appFunctionDataTypeMetadata).getEnumValues();
            if (enumValues != null) {
                set = enumValues.isEmpty() ? null : enumValues;
                if (set != null) {
                    INSTANCE.putEnumValues(jSONObjectPrimitiveJson, set);
                }
            }
            return jSONObjectPrimitiveJson;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionLongTypeMetadata) {
            return primitiveJson(appFunctionDataTypeMetadata, KIND_LONG);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionFloatTypeMetadata) {
            return primitiveJson(appFunctionDataTypeMetadata, "float");
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionDoubleTypeMetadata) {
            return primitiveJson(appFunctionDataTypeMetadata, KIND_DOUBLE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionStringTypeMetadata) {
            JSONObject jSONObjectPrimitiveJson2 = primitiveJson(appFunctionDataTypeMetadata, "string");
            Set<String> enumValues2 = ((AppFunctionStringTypeMetadata) appFunctionDataTypeMetadata).getEnumValues();
            if (enumValues2 != null) {
                set = enumValues2.isEmpty() ? null : enumValues2;
                if (set != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObjectPrimitiveJson2.put(FIELD_ENUM_VALUES, jSONArray);
                }
            }
            return jSONObjectPrimitiveJson2;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionBytesTypeMetadata) {
            return primitiveJson(appFunctionDataTypeMetadata, "bytes");
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionUnitTypeMetadata) {
            return primitiveJson(appFunctionDataTypeMetadata, KIND_UNIT);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FIELD_KIND, KIND_OBJECT);
            jSONObject.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
            jSONObject.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
            AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata;
            jSONObject.put(FIELD_QUALIFIED_NAME, appFunctionObjectTypeMetadata.getQualifiedName());
            JSONArray jSONArray2 = new JSONArray();
            Iterator<T> it2 = appFunctionObjectTypeMetadata.getRequired().iterator();
            while (it2.hasNext()) {
                jSONArray2.put((String) it2.next());
            }
            jSONObject.put(FIELD_REQUIRED, jSONArray2);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : appFunctionObjectTypeMetadata.getProperties().entrySet()) {
                jSONObject2.put(entry.getKey(), INSTANCE.toJson(entry.getValue()));
            }
            jSONObject.put(FIELD_PROPERTIES, jSONObject2);
            return jSONObject;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionArrayTypeMetadata) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(FIELD_KIND, KIND_ARRAY);
            jSONObject3.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
            jSONObject3.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
            jSONObject3.put(FIELD_ITEM_TYPE, INSTANCE.toJson(((AppFunctionArrayTypeMetadata) appFunctionDataTypeMetadata).getItemType()));
            return jSONObject3;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionReferenceTypeMetadata) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(FIELD_KIND, "reference");
            jSONObject4.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
            jSONObject4.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
            jSONObject4.put(FIELD_REFERENCE_DATA_TYPE, ((AppFunctionReferenceTypeMetadata) appFunctionDataTypeMetadata).getReferenceDataType());
            return jSONObject4;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(FIELD_KIND, KIND_ALL_OF);
            jSONObject5.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
            jSONObject5.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
            AppFunctionAllOfTypeMetadata appFunctionAllOfTypeMetadata = (AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata;
            String qualifiedName = appFunctionAllOfTypeMetadata.getQualifiedName();
            if (qualifiedName != null) {
                jSONObject5.put(FIELD_QUALIFIED_NAME, qualifiedName);
            }
            JSONArray jSONArray3 = new JSONArray();
            Iterator<T> it3 = appFunctionAllOfTypeMetadata.getMatchAll().iterator();
            while (it3.hasNext()) {
                jSONArray3.put(INSTANCE.toJson((AppFunctionDataTypeMetadata) it3.next()));
            }
            jSONObject5.put(FIELD_MATCH_ALL, jSONArray3);
            return jSONObject5;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionOneOfTypeMetadata) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(FIELD_KIND, KIND_ONE_OF);
            jSONObject6.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
            jSONObject6.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
            AppFunctionOneOfTypeMetadata appFunctionOneOfTypeMetadata = (AppFunctionOneOfTypeMetadata) appFunctionDataTypeMetadata;
            String qualifiedName2 = appFunctionOneOfTypeMetadata.getQualifiedName();
            if (qualifiedName2 != null) {
                jSONObject6.put(FIELD_QUALIFIED_NAME, qualifiedName2);
            }
            JSONArray jSONArray4 = new JSONArray();
            Iterator<T> it4 = appFunctionOneOfTypeMetadata.getMatchOneOf().iterator();
            while (it4.hasNext()) {
                jSONArray4.put(INSTANCE.toJson((AppFunctionDataTypeMetadata) it4.next()));
            }
            jSONObject6.put(FIELD_MATCH_ONE_OF, jSONArray4);
            return jSONObject6;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionParcelableTypeMetadata) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(FIELD_KIND, KIND_PARCELABLE);
            jSONObject7.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
            jSONObject7.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
            jSONObject7.put(FIELD_QUALIFIED_NAME, ((AppFunctionParcelableTypeMetadata) appFunctionDataTypeMetadata).getQualifiedName());
            return jSONObject7;
        }
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put(FIELD_KIND, EnvironmentCompat.MEDIA_UNKNOWN);
        jSONObject8.put(FIELD_IS_NULLABLE, appFunctionDataTypeMetadata.getIsNullable());
        jSONObject8.put(FIELD_DESCRIPTION, appFunctionDataTypeMetadata.getDescription());
        return jSONObject8;
    }
}
