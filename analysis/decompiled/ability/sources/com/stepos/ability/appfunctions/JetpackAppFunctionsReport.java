package com.stepos.ability.appfunctions;

import D7.v;
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
import androidx.appfunctions.metadata.AppFunctionStringTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionUnitTypeMetadata;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\u0004\u0018\u00010\u0005*\u00020\u0006J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¨\u0006\""}, d2 = {"Lcom/stepos/ability/appfunctions/JetpackAppFunctionsReport;", "", AppAgent.CONSTRUCT, "()V", "toAnthropicTool", "Lorg/json/JSONObject;", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", HintConstants.AUTOFILL_HINT_NAME, "", "toOutputSchemaJson", "encodeToolName", "pkg", "functionId", "buildToolNameIndex", "", "metadatas", "", "identifierCamelToSnake", "s", "paramJsonSchema", "p", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "components", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "dataTypeToJsonSchema", "dataType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "depth", "", "inlineObjectSchema", "obj", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "resolveObjectType", "valueType", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JetpackAppFunctionsReport {
    public static final JetpackAppFunctionsReport INSTANCE = new JetpackAppFunctionsReport();

    private JetpackAppFunctionsReport() {
    }

    private final JSONObject dataTypeToJsonSchema(AppFunctionDataTypeMetadata dataType, AppFunctionComponentsMetadata components, int depth) throws JSONException {
        JSONObject jSONObjectO;
        if (depth > 6) {
            JSONObject jSONObjectPut = new JSONObject().put("type", "object");
            k.e(jSONObjectPut, "put(...)");
            return jSONObjectPut;
        }
        if (dataType instanceof AppFunctionBooleanTypeMetadata) {
            jSONObjectO = a.o("type", TypedValues.Custom.S_BOOLEAN);
        } else if (dataType instanceof AppFunctionBytesTypeMetadata) {
            jSONObjectO = new JSONObject().put("type", TypedValues.Custom.S_STRING).put("format", "byte");
        } else if ((dataType instanceof AppFunctionDoubleTypeMetadata) || (dataType instanceof AppFunctionFloatTypeMetadata)) {
            jSONObjectO = a.o("type", "number");
        } else if ((dataType instanceof AppFunctionIntTypeMetadata) || (dataType instanceof AppFunctionLongTypeMetadata)) {
            jSONObjectO = a.o("type", TypedValues.Custom.S_INT);
        } else if (dataType instanceof AppFunctionStringTypeMetadata) {
            jSONObjectO = a.o("type", TypedValues.Custom.S_STRING);
        } else if (dataType instanceof AppFunctionUnitTypeMetadata) {
            jSONObjectO = a.o("type", "null");
        } else if (dataType instanceof AppFunctionParcelableTypeMetadata) {
            jSONObjectO = a.o("type", "object").put("description", "parcelable " + ((AppFunctionParcelableTypeMetadata) dataType).getQualifiedName());
        } else if (dataType instanceof AppFunctionReferenceTypeMetadata) {
            AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata = (AppFunctionReferenceTypeMetadata) dataType;
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = components.getDataTypes().get(appFunctionReferenceTypeMetadata.getReferenceDataType());
            AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
            if (appFunctionObjectTypeMetadata != null) {
                jSONObjectO = inlineObjectSchema(appFunctionObjectTypeMetadata, components, depth + 1);
            } else {
                jSONObjectO = a.o("type", "object").put("description", "ref=" + appFunctionReferenceTypeMetadata.getReferenceDataType() + " (not resolved)");
            }
        } else {
            jSONObjectO = dataType instanceof AppFunctionObjectTypeMetadata ? inlineObjectSchema((AppFunctionObjectTypeMetadata) dataType, components, depth + 1) : dataType instanceof AppFunctionArrayTypeMetadata ? a.o("type", "array").put("items", dataTypeToJsonSchema(((AppFunctionArrayTypeMetadata) dataType).getItemType(), components, depth + 1)) : dataType instanceof AppFunctionAllOfTypeMetadata ? new JSONObject().put("type", "object").put("description", "allOf (flattened object; see static components for branches)") : dataType instanceof AppFunctionOneOfTypeMetadata ? a.o("description", "oneOf / sealed variant (see static components for alternatives)") : new JSONObject().put("type", "object").put("description", "unsupported jetpack type");
        }
        if (!m.s0(dataType.getDescription()) && !jSONObjectO.has("description")) {
            jSONObjectO.put("description", dataType.getDescription());
        }
        if (dataType.getIsNullable()) {
            jSONObjectO.put("nullable", true);
        }
        k.c(jSONObjectO);
        return jSONObjectO;
    }

    public static /* synthetic */ JSONObject dataTypeToJsonSchema$default(JetpackAppFunctionsReport jetpackAppFunctionsReport, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return jetpackAppFunctionsReport.dataTypeToJsonSchema(appFunctionDataTypeMetadata, appFunctionComponentsMetadata, i);
    }

    private final String identifierCamelToSnake(String s5) {
        if (s5.length() == 0) {
            return s5;
        }
        String lowerCase = new Regex("([a-z0-9])([A-Z])").f(s5, "$1_$2").toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final JSONObject inlineObjectSchema(AppFunctionObjectTypeMetadata obj, AppFunctionComponentsMetadata components, int depth) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : obj.getProperties().entrySet()) {
            jSONObject.put(entry.getKey(), INSTANCE.dataTypeToJsonSchema(entry.getValue(), components, depth + 1));
        }
        JSONObject jSONObjectPut = new JSONObject().put("type", "object").put("properties", jSONObject);
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = obj.getRequired().iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("required", jSONArray);
        if (m.s0(obj.getDescription())) {
            jSONObjectPut2.put("description", "object " + obj.getQualifiedName());
        } else {
            jSONObjectPut2.put("description", obj.getDescription());
        }
        k.e(jSONObjectPut2, "apply(...)");
        return jSONObjectPut2;
    }

    private final JSONObject paramJsonSchema(AppFunctionParameterMetadata p, AppFunctionComponentsMetadata components) throws JSONException {
        JSONObject jSONObjectDataTypeToJsonSchema$default = dataTypeToJsonSchema$default(this, p.getDataType(), components, 0, 4, null);
        if (!m.s0(p.getDescription())) {
            jSONObjectDataTypeToJsonSchema$default.put("description", p.getDescription());
        }
        return jSONObjectDataTypeToJsonSchema$default;
    }

    private final AppFunctionObjectTypeMetadata resolveObjectType(AppFunctionDataTypeMetadata valueType, AppFunctionComponentsMetadata components) {
        if (valueType instanceof AppFunctionObjectTypeMetadata) {
            return (AppFunctionObjectTypeMetadata) valueType;
        }
        if (valueType instanceof AppFunctionReferenceTypeMetadata) {
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = components.getDataTypes().get(((AppFunctionReferenceTypeMetadata) valueType).getReferenceDataType());
            if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
                return (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata;
            }
            return null;
        }
        if (valueType instanceof AppFunctionAllOfTypeMetadata) {
            Object objW0 = v.W0(((AppFunctionAllOfTypeMetadata) valueType).getMatchAll());
            if (objW0 instanceof AppFunctionObjectTypeMetadata) {
                return (AppFunctionObjectTypeMetadata) objW0;
            }
        }
        return null;
    }

    public static /* synthetic */ JSONObject toAnthropicTool$default(JetpackAppFunctionsReport jetpackAppFunctionsReport, AppFunctionMetadata appFunctionMetadata, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jetpackAppFunctionsReport.encodeToolName(appFunctionMetadata.getPackageName(), appFunctionMetadata.getId());
        }
        return jetpackAppFunctionsReport.toAnthropicTool(appFunctionMetadata, str);
    }

    public final Map<String, AppFunctionMetadata> buildToolNameIndex(List<AppFunctionMetadata> metadatas) {
        k.f(metadatas, "metadatas");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : metadatas) {
            AppFunctionMetadata appFunctionMetadata = (AppFunctionMetadata) obj;
            String strEncodeToolName = INSTANCE.encodeToolName(appFunctionMetadata.getPackageName(), appFunctionMetadata.getId());
            Object arrayList = linkedHashMap.get(strEncodeToolName);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strEncodeToolName, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List<AppFunctionMetadata> list = (List) entry.getValue();
            if (list.size() == 1) {
                linkedHashMap2.put(str, list.get(0));
            } else {
                for (AppFunctionMetadata appFunctionMetadata2 : list) {
                    String str2 = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf((appFunctionMetadata2.getPackageName() + "::" + appFunctionMetadata2.getId()).hashCode())}, 1));
                    int length = 63 - str2.length();
                    if (length < 1) {
                        length = 1;
                    }
                    linkedHashMap2.put(m.N0(length, str) + "_" + str2, appFunctionMetadata2);
                }
            }
        }
        return linkedHashMap2;
    }

    public final String encodeToolName(String pkg, String functionId) {
        String strI0;
        k.f(pkg, "pkg");
        k.f(functionId, "functionId");
        String string = m.R0(pkg).toString();
        String strI02 = m.I0('.', string, string);
        if (strI02.length() == 0) {
            strI02 = m.R0(pkg).toString();
        }
        String string2 = m.R0(functionId).toString();
        if (m.i0(string2, '#')) {
            strI0 = m.I0('#', string2, string2);
        } else {
            strI0 = m.I0('.', string2, string2);
            if (strI0.length() == 0) {
                strI0 = string2;
            }
        }
        if (strI0.length() != 0) {
            string2 = strI0;
        }
        String strS0 = m.S0(new Regex("_+").f(new Regex("[^a-zA-Z0-9_-]").f(B7.a.B(identifierCamelToSnake(strI02), "_", identifierCamelToSnake(string2)), "_"), "_"), '_');
        if (strS0.length() == 0) {
            strS0 = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf((pkg + "::" + functionId).hashCode())}, 1));
        }
        if (strS0.length() <= 64) {
            return strS0;
        }
        String str = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf((pkg + "::" + functionId).hashCode())}, 1));
        int length = 63 - str.length();
        return B7.a.B(m.N0(length >= 1 ? length : 1, strS0), "_", str);
    }

    public final JSONObject toAnthropicTool(AppFunctionMetadata appFunctionMetadata, String name) {
        k.f(appFunctionMetadata, "<this>");
        k.f(name, "name");
        JSONObject jSONObjectPut = new JSONObject().put("type", "object");
        JSONObject jSONObject = new JSONObject();
        for (AppFunctionParameterMetadata appFunctionParameterMetadata : appFunctionMetadata.getParameters()) {
            jSONObject.put(appFunctionParameterMetadata.getName(), INSTANCE.paramJsonSchema(appFunctionParameterMetadata, appFunctionMetadata.getComponents()));
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("properties", jSONObject);
        JSONArray jSONArray = new JSONArray();
        List<AppFunctionParameterMetadata> parameters = appFunctionMetadata.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((AppFunctionParameterMetadata) obj).getIsRequired()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AppFunctionParameterMetadata) it.next()).getName());
        }
        JSONObject jSONObjectPut3 = jSONObjectPut2.put("required", jSONArray);
        String string = m.R0(appFunctionMetadata.getDescription()).toString();
        if (m.s0(string)) {
            string = B7.a.k("AppFunction ", appFunctionMetadata.getId());
        }
        JSONObject jSONObjectPut4 = new JSONObject().put(HintConstants.AUTOFILL_HINT_NAME, name).put("description", string).put("input_schema", jSONObjectPut3);
        k.e(jSONObjectPut4, "put(...)");
        return jSONObjectPut4;
    }

    public final JSONObject toOutputSchemaJson(AppFunctionMetadata appFunctionMetadata) {
        k.f(appFunctionMetadata, "<this>");
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadataResolveObjectType = resolveObjectType(appFunctionMetadata.getResponse().getValueType(), appFunctionMetadata.getComponents());
        if (appFunctionObjectTypeMetadataResolveObjectType == null) {
            return null;
        }
        return inlineObjectSchema(appFunctionObjectTypeMetadataResolveObjectType, appFunctionMetadata.getComponents(), 0);
    }
}
