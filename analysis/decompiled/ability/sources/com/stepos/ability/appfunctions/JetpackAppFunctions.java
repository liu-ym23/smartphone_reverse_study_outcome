package com.stepos.ability.appfunctions;

import B7.a;
import C7.r;
import D7.q;
import D7.v;
import D7.w;
import H4.o;
import J7.c;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.ExecuteAppFunctionResponse;
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
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionParcelableTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionReferenceTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionStringTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionUnitTypeMetadata;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import j9.m;
import j9.s;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001YB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001c\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u001f\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b*\u0010+J1\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b,\u0010-J1\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u00020)H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00101\u001a\u00020)H\u0002¢\u0006\u0004\b5\u00106J!\u00108\u001a\u0004\u0018\u00010\u00072\u0006\u00101\u001a\u00020)2\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u0002022\u0006\u00101\u001a\u00020)2\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u00020<2\u0006\u00101\u001a\u00020)2\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u0002022\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020D2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bE\u0010FJ*\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040J2\u0006\u0010H\u001a\u00020G2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0004\bK\u0010LJ<\u0010P\u001a\b\u0012\u0004\u0012\u00020\"0M2\u0006\u0010H\u001a\u00020G2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0086@¢\u0006\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010UR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Lcom/stepos/ability/appfunctions/JetpackAppFunctions;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "metadata", "", "", "args", "Landroidx/appfunctions/AppFunctionData;", "buildParameters", "(Landroidx/appfunctions/metadata/AppFunctionMetadata;Ljava/util/Map;)Landroidx/appfunctions/AppFunctionData;", "Landroidx/appfunctions/AppFunctionData$Builder;", "builder", "key", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "dataType", "raw", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "components", "LC7/r;", "writeValue", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/Object;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "objType", "buildObjectData", "(Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;Ljava/lang/Object;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Landroidx/appfunctions/AppFunctionData;", "Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;", "writeAllOf", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;Ljava/lang/Object;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "itemType", "writeArray", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "response", "Lcom/stepos/ability/appfunctions/JetpackAppFunctions$JetpackExecResult;", "parseSuccess", "(Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;Landroidx/appfunctions/metadata/AppFunctionMetadata;)Lcom/stepos/ability/appfunctions/JetpackAppFunctions$JetpackExecResult;", "valueType", "resolveObjectType", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", SettingsConfig.KEY_DATA, "Lorg/json/JSONObject;", "objectDataToJson", "(Landroidx/appfunctions/AppFunctionData;Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Lorg/json/JSONObject;", "readValue", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Ljava/lang/Object;", "Lorg/json/JSONArray;", "readArray", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Lorg/json/JSONArray;", "payload", "", "evaluateBusinessSuccess", "(Lorg/json/JSONObject;)Z", "extractErrorMessage", "(Lorg/json/JSONObject;)Ljava/lang/String;", "field", "jsonFieldAsDisplayString", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "readJsonBoolean", "(Lorg/json/JSONObject;Ljava/lang/String;)Z", "", "readJsonLong", "(Lorg/json/JSONObject;Ljava/lang/String;)J", "v", "coerceBoolean", "(Ljava/lang/Object;)Z", "coerceLong", "(Ljava/lang/Object;)J", "", "coerceDouble", "(Ljava/lang/Object;)D", "Landroid/content/Context;", "context", "targetPackage", "", "scan", "(Landroid/content/Context;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lkotlin/Result;", "execute-BWLJW6A", "(Landroid/content/Context;Landroidx/appfunctions/metadata/AppFunctionMetadata;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "execute", "TAG", "Ljava/lang/String;", "", "SUCCESS_FIELD_NAMES", "Ljava/util/Set;", "STATUS_CODE_FIELD_NAMES", "ERROR_MESSAGE_FIELD_NAMES", "Ljava/util/List;", "JetpackExecResult", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JetpackAppFunctions {
    private static final String TAG = "JetpackAppFunctions";
    public static final JetpackAppFunctions INSTANCE = new JetpackAppFunctions();
    private static final Set<String> SUCCESS_FIELD_NAMES = q.K0(new String[]{"success", "isSuccess", "ok"});
    private static final Set<String> STATUS_CODE_FIELD_NAMES = q.K0(new String[]{"code", "errorCode", "statusCode", "errno"});
    private static final List<String> ERROR_MESSAGE_FIELD_NAMES = o.N("errorMessage", "message", "error", "reason");

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/ability/appfunctions/JetpackAppFunctions$JetpackExecResult;", "", "success", "", "payload", "Lorg/json/JSONObject;", "errorMessage", "", AppAgent.CONSTRUCT, "(ZLorg/json/JSONObject;Ljava/lang/String;)V", "getSuccess", "()Z", "getPayload", "()Lorg/json/JSONObject;", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class JetpackExecResult {
        private final String errorMessage;
        private final JSONObject payload;
        private final boolean success;

        public JetpackExecResult(boolean z10, JSONObject payload, String str) {
            k.f(payload, "payload");
            this.success = z10;
            this.payload = payload;
            this.errorMessage = str;
        }

        public static /* synthetic */ JetpackExecResult copy$default(JetpackExecResult jetpackExecResult, boolean z10, JSONObject jSONObject, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = jetpackExecResult.success;
            }
            if ((i & 2) != 0) {
                jSONObject = jetpackExecResult.payload;
            }
            if ((i & 4) != 0) {
                str = jetpackExecResult.errorMessage;
            }
            return jetpackExecResult.copy(z10, jSONObject, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component2, reason: from getter */
        public final JSONObject getPayload() {
            return this.payload;
        }

        /* renamed from: component3, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final JetpackExecResult copy(boolean success, JSONObject payload, String errorMessage) {
            k.f(payload, "payload");
            return new JetpackExecResult(success, payload, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JetpackExecResult)) {
                return false;
            }
            JetpackExecResult jetpackExecResult = (JetpackExecResult) other;
            return this.success == jetpackExecResult.success && k.b(this.payload, jetpackExecResult.payload) && k.b(this.errorMessage, jetpackExecResult.errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final JSONObject getPayload() {
            return this.payload;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public int hashCode() {
            int iHashCode = (this.payload.hashCode() + (Boolean.hashCode(this.success) * 31)) * 31;
            String str = this.errorMessage;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean z10 = this.success;
            JSONObject jSONObject = this.payload;
            String str = this.errorMessage;
            StringBuilder sb = new StringBuilder("JetpackExecResult(success=");
            sb.append(z10);
            sb.append(", payload=");
            sb.append(jSONObject);
            sb.append(", errorMessage=");
            return a.q(sb, str, ")");
        }
    }

    @c(c = "com.stepos.ability.appfunctions.JetpackAppFunctions", f = "JetpackAppFunctions.kt", l = {95}, m = "scan", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.appfunctions.JetpackAppFunctions$scan$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JetpackAppFunctions.this.scan(null, null, this);
        }
    }

    private JetpackAppFunctions() {
    }

    private final AppFunctionData buildObjectData(AppFunctionObjectTypeMetadata objType, Object raw, AppFunctionComponentsMetadata components) {
        AppFunctionComponentsMetadata appFunctionComponentsMetadata;
        Object objA;
        Map map = raw instanceof Map ? (Map) raw : null;
        if (map == null) {
            Log.w(TAG, "object expects Map but got " + raw.getClass());
            return null;
        }
        AppFunctionData.Builder builder = new AppFunctionData.Builder(objType, components);
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : objType.getProperties().entrySet()) {
            String key = entry.getKey();
            AppFunctionDataTypeMetadata value = entry.getValue();
            Object obj = map.get(key);
            if (obj == null) {
                appFunctionComponentsMetadata = components;
            } else {
                appFunctionComponentsMetadata = components;
                try {
                    INSTANCE.writeValue(builder, key, value, obj, appFunctionComponentsMetadata);
                    objA = r.f317a;
                } catch (Throwable th) {
                    objA = b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    androidx.constraintlayout.core.dsl.a.x("nested obj: set '", key, "' failed: ", thA.getMessage(), TAG);
                }
            }
            components = appFunctionComponentsMetadata;
        }
        return builder.build();
    }

    private final AppFunctionData buildParameters(AppFunctionMetadata metadata, Map<String, ? extends Object> args) {
        Object objA;
        AppFunctionData.Builder builder = new AppFunctionData.Builder(metadata.getParameters(), metadata.getComponents());
        for (AppFunctionParameterMetadata appFunctionParameterMetadata : metadata.getParameters()) {
            Object obj = args.get(appFunctionParameterMetadata.getName());
            if (obj != null) {
                try {
                    INSTANCE.writeValue(builder, appFunctionParameterMetadata.getName(), appFunctionParameterMetadata.getDataType(), obj, metadata.getComponents());
                    objA = r.f317a;
                } catch (Throwable th) {
                    objA = b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    androidx.constraintlayout.core.dsl.a.x("execute: set param '", appFunctionParameterMetadata.getName(), "' failed: ", thA.getMessage(), TAG);
                }
            } else if (appFunctionParameterMetadata.getIsRequired() && !appFunctionParameterMetadata.getDataType().getIsNullable()) {
                androidx.constraintlayout.core.dsl.a.x("execute: required param '", appFunctionParameterMetadata.getName(), "' missing for ", metadata.getId(), TAG);
            }
        }
        return builder.build();
    }

    private final boolean coerceBoolean(Object v10) {
        if (v10 instanceof Boolean) {
            return ((Boolean) v10).booleanValue();
        }
        if (v10 instanceof Number) {
            return ((Number) v10).intValue() != 0;
        }
        if (v10 instanceof String) {
            return t.X((String) v10, "true") || k.b(v10, "1");
        }
        return false;
    }

    private final double coerceDouble(Object v10) {
        if (v10 instanceof Number) {
            return ((Number) v10).doubleValue();
        }
        if (!(v10 instanceof String)) {
            return ((v10 instanceof Boolean) && ((Boolean) v10).booleanValue()) ? 1.0d : 0.0d;
        }
        Double dU = s.U((String) v10);
        if (dU != null) {
            return dU.doubleValue();
        }
        return 0.0d;
    }

    private final long coerceLong(Object v10) {
        if (v10 instanceof Number) {
            return ((Number) v10).longValue();
        }
        if (!(v10 instanceof String)) {
            return ((v10 instanceof Boolean) && ((Boolean) v10).booleanValue()) ? 1L : 0L;
        }
        String str = (String) v10;
        Long lG0 = t.g0(str);
        if (lG0 != null) {
            return lG0.longValue();
        }
        Double dU = s.U(str);
        Long lValueOf = dU != null ? Long.valueOf((long) dU.doubleValue()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    private final boolean evaluateBusinessSuccess(JSONObject payload) {
        for (String str : SUCCESS_FIELD_NAMES) {
            if (payload.has(str) && !readJsonBoolean(payload, str)) {
                return false;
            }
        }
        for (String str2 : STATUS_CODE_FIELD_NAMES) {
            if (payload.has(str2) && readJsonLong(payload, str2) != 0) {
                return false;
            }
        }
        return true;
    }

    private final String extractErrorMessage(JSONObject payload) {
        String strJsonFieldAsDisplayString;
        for (String str : ERROR_MESSAGE_FIELD_NAMES) {
            if (payload.has(str) && (strJsonFieldAsDisplayString = jsonFieldAsDisplayString(payload, str)) != null) {
                return strJsonFieldAsDisplayString;
            }
        }
        return null;
    }

    private final String jsonFieldAsDisplayString(JSONObject payload, String field) throws JSONException {
        Object obj = null;
        if (payload.has(field) && !payload.isNull(field)) {
            Object obj2 = payload.get(field);
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (!m.s0(str) && !k.b(str, "null")) {
                    obj = obj2;
                }
                return (String) obj;
            }
            if (obj2 instanceof JSONArray) {
                String strOptString = ((JSONArray) obj2).optString(0);
                k.c(strOptString);
                if (!m.s0(strOptString) && !strOptString.equals("null")) {
                    return strOptString;
                }
            }
        }
        return null;
    }

    private final JSONObject objectDataToJson(AppFunctionData data, AppFunctionObjectTypeMetadata objType, AppFunctionComponentsMetadata components) throws JSONException {
        Object objA;
        Object objA2;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : objType.getProperties().entrySet()) {
            String key = entry.getKey();
            AppFunctionDataTypeMetadata value = entry.getValue();
            try {
                objA = Boolean.valueOf(data.containsKey(key));
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Object obj = Boolean.FALSE;
            if (objA instanceof Result.Failure) {
                objA = obj;
            }
            if (((Boolean) objA).booleanValue()) {
                try {
                    objA2 = INSTANCE.readValue(data, key, value, components);
                } catch (Throwable th2) {
                    objA2 = b.a(th2);
                }
                if (objA2 instanceof Result.Failure) {
                    objA2 = null;
                }
                if (objA2 != null) {
                    jSONObject.put(key, objA2);
                }
            }
        }
        return jSONObject;
    }

    private final JetpackExecResult parseSuccess(ExecuteAppFunctionResponse.Success response, AppFunctionMetadata metadata) throws JSONException {
        Object objA;
        JSONObject jSONObjectObjectDataToJson;
        Object objA2;
        AppFunctionDataTypeMetadata valueType = metadata.getResponse().getValueType();
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadataResolveObjectType = resolveObjectType(valueType, metadata.getComponents());
        String strExtractErrorMessage = null;
        if (appFunctionObjectTypeMetadataResolveObjectType != null) {
            try {
                objA = response.getReturnValue().getAppFunctionData(ExecuteAppFunctionResponse.Success.PROPERTY_RETURN_VALUE);
            } catch (Throwable th) {
                objA = b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            AppFunctionData appFunctionData = (AppFunctionData) objA;
            jSONObjectObjectDataToJson = appFunctionData != null ? objectDataToJson(appFunctionData, appFunctionObjectTypeMetadataResolveObjectType, metadata.getComponents()) : new JSONObject();
        } else {
            try {
                objA2 = readValue(response.getReturnValue(), ExecuteAppFunctionResponse.Success.PROPERTY_RETURN_VALUE, valueType, metadata.getComponents());
            } catch (Throwable th2) {
                objA2 = b.a(th2);
            }
            if (objA2 instanceof Result.Failure) {
                objA2 = null;
            }
            JSONObject jSONObject = new JSONObject();
            if (objA2 != null) {
                jSONObject.put("returnValue", objA2);
            }
            jSONObjectObjectDataToJson = jSONObject;
        }
        boolean zEvaluateBusinessSuccess = evaluateBusinessSuccess(jSONObjectObjectDataToJson);
        if (!zEvaluateBusinessSuccess && (strExtractErrorMessage = extractErrorMessage(jSONObjectObjectDataToJson)) == null) {
            strExtractErrorMessage = "AppFunction returned business failure";
        }
        return new JetpackExecResult(zEvaluateBusinessSuccess, jSONObjectObjectDataToJson, strExtractErrorMessage);
    }

    private final JSONArray readArray(AppFunctionData data, String key, AppFunctionDataTypeMetadata itemType, AppFunctionComponentsMetadata components) throws JSONException {
        if (itemType instanceof AppFunctionStringTypeMetadata) {
            List<String> stringList = data.getStringList(key);
            if (stringList == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = stringList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            return jSONArray;
        }
        int i = 0;
        if (itemType instanceof AppFunctionBooleanTypeMetadata) {
            boolean[] booleanArray = data.getBooleanArray(key);
            if (booleanArray == null) {
                return null;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = booleanArray.length;
            while (i < length) {
                jSONArray2.put(booleanArray[i]);
                i++;
            }
            return jSONArray2;
        }
        if (itemType instanceof AppFunctionIntTypeMetadata) {
            int[] intArray = data.getIntArray(key);
            if (intArray == null) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray();
            int length2 = intArray.length;
            while (i < length2) {
                jSONArray3.put(intArray[i]);
                i++;
            }
            return jSONArray3;
        }
        if (itemType instanceof AppFunctionLongTypeMetadata) {
            long[] longArray = data.getLongArray(key);
            if (longArray == null) {
                return null;
            }
            JSONArray jSONArray4 = new JSONArray();
            int length3 = longArray.length;
            while (i < length3) {
                jSONArray4.put(longArray[i]);
                i++;
            }
            return jSONArray4;
        }
        if (itemType instanceof AppFunctionDoubleTypeMetadata) {
            double[] doubleArray = data.getDoubleArray(key);
            if (doubleArray == null) {
                return null;
            }
            JSONArray jSONArray5 = new JSONArray();
            int length4 = doubleArray.length;
            while (i < length4) {
                jSONArray5.put(doubleArray[i]);
                i++;
            }
            return jSONArray5;
        }
        if (itemType instanceof AppFunctionFloatTypeMetadata) {
            float[] floatArray = data.getFloatArray(key);
            if (floatArray == null) {
                return null;
            }
            JSONArray jSONArray6 = new JSONArray();
            int length5 = floatArray.length;
            while (i < length5) {
                jSONArray6.put(floatArray[i]);
                i++;
            }
            return jSONArray6;
        }
        if (itemType instanceof AppFunctionObjectTypeMetadata) {
            List<AppFunctionData> appFunctionDataList = data.getAppFunctionDataList(key);
            if (appFunctionDataList == null) {
                return null;
            }
            JSONArray jSONArray7 = new JSONArray();
            Iterator<T> it2 = appFunctionDataList.iterator();
            while (it2.hasNext()) {
                jSONArray7.put(INSTANCE.objectDataToJson((AppFunctionData) it2.next(), (AppFunctionObjectTypeMetadata) itemType, components));
            }
            return jSONArray7;
        }
        if (itemType instanceof AppFunctionReferenceTypeMetadata) {
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = components.getDataTypes().get(((AppFunctionReferenceTypeMetadata) itemType).getReferenceDataType());
            AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
            List<AppFunctionData> appFunctionDataList2 = data.getAppFunctionDataList(key);
            if (appFunctionDataList2 != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (AppFunctionData appFunctionData : appFunctionDataList2) {
                    if (appFunctionObjectTypeMetadata != null) {
                        jSONArray8.put(INSTANCE.objectDataToJson(appFunctionData, appFunctionObjectTypeMetadata, components));
                    }
                }
                return jSONArray8;
            }
        }
        return null;
    }

    private final boolean readJsonBoolean(JSONObject payload, String field) throws JSONException {
        if (payload.has(field) && !payload.isNull(field)) {
            Object obj = payload.get(field);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                if (((Number) obj).intValue() != 0) {
                    return true;
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() > 0 && jSONArray.optBoolean(0)) {
                    return true;
                }
            } else if ((obj instanceof String) && (t.X((String) obj, "true") || k.b(obj, "1"))) {
                return true;
            }
        }
        return false;
    }

    private final long readJsonLong(JSONObject payload, String field) throws JSONException {
        Long lG0;
        if (payload.has(field) && !payload.isNull(field)) {
            Object obj = payload.get(field);
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() > 0) {
                    return jSONArray.optLong(0);
                }
                return 0L;
            }
            if ((obj instanceof String) && (lG0 = t.g0((String) obj)) != null) {
                return lG0.longValue();
            }
        }
        return 0L;
    }

    private final Object readValue(AppFunctionData data, String key, AppFunctionDataTypeMetadata dataType, AppFunctionComponentsMetadata components) {
        if (dataType instanceof AppFunctionBooleanTypeMetadata) {
            return Boolean.valueOf(data.getBoolean(key));
        }
        if (dataType instanceof AppFunctionIntTypeMetadata) {
            return Integer.valueOf(data.getInt(key));
        }
        if (dataType instanceof AppFunctionLongTypeMetadata) {
            return Long.valueOf(data.getLong(key));
        }
        if (dataType instanceof AppFunctionFloatTypeMetadata) {
            return Double.valueOf(data.getFloat(key));
        }
        if (dataType instanceof AppFunctionDoubleTypeMetadata) {
            return Double.valueOf(data.getDouble(key));
        }
        if (dataType instanceof AppFunctionStringTypeMetadata) {
            return data.getString(key);
        }
        if (dataType instanceof AppFunctionBytesTypeMetadata) {
            byte[] byteArray = data.getByteArray(key);
            if (byteArray != null) {
                return Base64.encodeToString(byteArray, 2);
            }
            return null;
        }
        if (dataType instanceof AppFunctionUnitTypeMetadata) {
            return null;
        }
        if (dataType instanceof AppFunctionObjectTypeMetadata) {
            AppFunctionData appFunctionData = data.getAppFunctionData(key);
            if (appFunctionData != null) {
                return INSTANCE.objectDataToJson(appFunctionData, (AppFunctionObjectTypeMetadata) dataType, components);
            }
            return null;
        }
        if (dataType instanceof AppFunctionReferenceTypeMetadata) {
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = components.getDataTypes().get(((AppFunctionReferenceTypeMetadata) dataType).getReferenceDataType());
            AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
            AppFunctionData appFunctionData2 = data.getAppFunctionData(key);
            if (appFunctionData2 == null || appFunctionObjectTypeMetadata == null) {
                return null;
            }
            return INSTANCE.objectDataToJson(appFunctionData2, appFunctionObjectTypeMetadata, components);
        }
        if (dataType instanceof AppFunctionArrayTypeMetadata) {
            return readArray(data, key, ((AppFunctionArrayTypeMetadata) dataType).getItemType(), components);
        }
        if (dataType instanceof AppFunctionAllOfTypeMetadata) {
            Object objW0 = v.W0(((AppFunctionAllOfTypeMetadata) dataType).getMatchAll());
            AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata2 = objW0 instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) objW0 : null;
            AppFunctionData appFunctionData3 = data.getAppFunctionData(key);
            if (appFunctionData3 != null && appFunctionObjectTypeMetadata2 != null) {
                return INSTANCE.objectDataToJson(appFunctionData3, appFunctionObjectTypeMetadata2, components);
            }
        }
        return null;
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

    public static /* synthetic */ Object scan$default(JetpackAppFunctions jetpackAppFunctions, Context context, String str, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return jetpackAppFunctions.scan(context, str, cVar);
    }

    private final void writeAllOf(AppFunctionData.Builder builder, String key, AppFunctionAllOfTypeMetadata dataType, Object raw, AppFunctionComponentsMetadata components) {
        Object objW0 = v.W0(dataType.getMatchAll());
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = objW0 instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) objW0 : null;
        if (appFunctionObjectTypeMetadata == null) {
            Log.w(TAG, androidx.constraintlayout.core.dsl.a.d(dataType.getMatchAll().size(), "param '", key, "' AllOf with ", " members is not supported"));
            return;
        }
        AppFunctionData appFunctionDataBuildObjectData = buildObjectData(appFunctionObjectTypeMetadata, raw, components);
        if (appFunctionDataBuildObjectData != null) {
            builder.setAppFunctionData(key, appFunctionDataBuildObjectData);
        }
    }

    private final void writeArray(AppFunctionData.Builder builder, String key, AppFunctionDataTypeMetadata itemType, Object raw, AppFunctionComponentsMetadata components) {
        String string;
        Double dValueOf = Double.valueOf(0.0d);
        int i = 0;
        List list = raw instanceof List ? (List) raw : null;
        if (list == null) {
            Log.w(TAG, "param '" + key + "' array expects List but got " + raw.getClass());
            return;
        }
        if (itemType instanceof AppFunctionStringTypeMetadata) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            for (Object obj : list2) {
                if (obj == null || (string = obj.toString()) == null) {
                    string = "";
                }
                arrayList.add(string);
            }
            builder.setStringList(key, arrayList);
            return;
        }
        if (itemType instanceof AppFunctionBooleanTypeMetadata) {
            int size = list.size();
            boolean[] zArr = new boolean[size];
            while (i < size) {
                JetpackAppFunctions jetpackAppFunctions = INSTANCE;
                Object obj2 = list.get(i);
                if (obj2 == null) {
                    obj2 = Boolean.FALSE;
                }
                zArr[i] = jetpackAppFunctions.coerceBoolean(obj2);
                i++;
            }
            builder.setBooleanArray(key, zArr);
            return;
        }
        if (itemType instanceof AppFunctionIntTypeMetadata) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            while (i < size2) {
                JetpackAppFunctions jetpackAppFunctions2 = INSTANCE;
                Object obj3 = list.get(i);
                if (obj3 == null) {
                    obj3 = 0;
                }
                iArr[i] = (int) jetpackAppFunctions2.coerceLong(obj3);
                i++;
            }
            builder.setIntArray(key, iArr);
            return;
        }
        if (itemType instanceof AppFunctionLongTypeMetadata) {
            int size3 = list.size();
            long[] jArr = new long[size3];
            while (i < size3) {
                JetpackAppFunctions jetpackAppFunctions3 = INSTANCE;
                Object obj4 = list.get(i);
                if (obj4 == null) {
                    obj4 = 0;
                }
                jArr[i] = jetpackAppFunctions3.coerceLong(obj4);
                i++;
            }
            builder.setLongArray(key, jArr);
            return;
        }
        if (itemType instanceof AppFunctionDoubleTypeMetadata) {
            int size4 = list.size();
            double[] dArr = new double[size4];
            while (i < size4) {
                JetpackAppFunctions jetpackAppFunctions4 = INSTANCE;
                Object obj5 = list.get(i);
                if (obj5 == null) {
                    obj5 = dValueOf;
                }
                dArr[i] = jetpackAppFunctions4.coerceDouble(obj5);
                i++;
            }
            builder.setDoubleArray(key, dArr);
            return;
        }
        if (itemType instanceof AppFunctionFloatTypeMetadata) {
            int size5 = list.size();
            float[] fArr = new float[size5];
            while (i < size5) {
                JetpackAppFunctions jetpackAppFunctions5 = INSTANCE;
                Object obj6 = list.get(i);
                if (obj6 == null) {
                    obj6 = dValueOf;
                }
                fArr[i] = (float) jetpackAppFunctions5.coerceDouble(obj6);
                i++;
            }
            builder.setFloatArray(key, fArr);
            return;
        }
        if (itemType instanceof AppFunctionObjectTypeMetadata) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                AppFunctionData appFunctionDataBuildObjectData = next != null ? INSTANCE.buildObjectData((AppFunctionObjectTypeMetadata) itemType, next, components) : null;
                if (appFunctionDataBuildObjectData != null) {
                    arrayList2.add(appFunctionDataBuildObjectData);
                }
            }
            builder.setAppFunctionDataList(key, arrayList2);
            return;
        }
        if (!(itemType instanceof AppFunctionReferenceTypeMetadata)) {
            androidx.constraintlayout.core.dsl.a.x("param '", key, "' array of unsupported item ", itemType.getClass().getSimpleName(), TAG);
            return;
        }
        AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata = (AppFunctionReferenceTypeMetadata) itemType;
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = components.getDataTypes().get(appFunctionReferenceTypeMetadata.getReferenceDataType());
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
        if (appFunctionObjectTypeMetadata == null) {
            Log.w(TAG, androidx.appfunctions.metadata.a.m("param '", key, "' array reference '", appFunctionReferenceTypeMetadata.getReferenceDataType(), "' not found"));
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            AppFunctionData appFunctionDataBuildObjectData2 = next2 != null ? INSTANCE.buildObjectData(appFunctionObjectTypeMetadata, next2, components) : null;
            if (appFunctionDataBuildObjectData2 != null) {
                arrayList3.add(appFunctionDataBuildObjectData2);
            }
        }
        builder.setAppFunctionDataList(key, arrayList3);
    }

    private final void writeValue(AppFunctionData.Builder builder, String key, AppFunctionDataTypeMetadata dataType, Object raw, AppFunctionComponentsMetadata components) {
        if (dataType instanceof AppFunctionBooleanTypeMetadata) {
            builder.setBoolean(key, coerceBoolean(raw));
            return;
        }
        if (dataType instanceof AppFunctionIntTypeMetadata) {
            builder.setInt(key, (int) coerceLong(raw));
            return;
        }
        if (dataType instanceof AppFunctionLongTypeMetadata) {
            builder.setLong(key, coerceLong(raw));
            return;
        }
        if (dataType instanceof AppFunctionFloatTypeMetadata) {
            builder.setFloat(key, (float) coerceDouble(raw));
            return;
        }
        if (dataType instanceof AppFunctionDoubleTypeMetadata) {
            builder.setDouble(key, coerceDouble(raw));
            return;
        }
        if (dataType instanceof AppFunctionStringTypeMetadata) {
            builder.setString(key, raw.toString());
            return;
        }
        if (dataType instanceof AppFunctionBytesTypeMetadata) {
            if (raw instanceof byte[]) {
                builder.setByteArray(key, (byte[]) raw);
                return;
            }
            if (raw instanceof String) {
                byte[] bArrDecode = Base64.decode((String) raw, 0);
                k.e(bArrDecode, "decode(...)");
                builder.setByteArray(key, bArrDecode);
                return;
            } else {
                Log.w(TAG, "param '" + key + "' bytes expects ByteArray/Base64 string, got " + raw.getClass());
                return;
            }
        }
        if (dataType instanceof AppFunctionUnitTypeMetadata) {
            return;
        }
        if (dataType instanceof AppFunctionObjectTypeMetadata) {
            AppFunctionData appFunctionDataBuildObjectData = buildObjectData((AppFunctionObjectTypeMetadata) dataType, raw, components);
            if (appFunctionDataBuildObjectData != null) {
                builder.setAppFunctionData(key, appFunctionDataBuildObjectData);
                return;
            }
            return;
        }
        if (dataType instanceof AppFunctionReferenceTypeMetadata) {
            AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata = (AppFunctionReferenceTypeMetadata) dataType;
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = components.getDataTypes().get(appFunctionReferenceTypeMetadata.getReferenceDataType());
            AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
            if (appFunctionObjectTypeMetadata == null) {
                Log.w(TAG, androidx.appfunctions.metadata.a.m("param '", key, "' reference '", appFunctionReferenceTypeMetadata.getReferenceDataType(), "' not found in components"));
                return;
            }
            AppFunctionData appFunctionDataBuildObjectData2 = buildObjectData(appFunctionObjectTypeMetadata, raw, components);
            if (appFunctionDataBuildObjectData2 != null) {
                builder.setAppFunctionData(key, appFunctionDataBuildObjectData2);
                return;
            }
            return;
        }
        if (dataType instanceof AppFunctionArrayTypeMetadata) {
            writeArray(builder, key, ((AppFunctionArrayTypeMetadata) dataType).getItemType(), raw, components);
            return;
        }
        if (dataType instanceof AppFunctionAllOfTypeMetadata) {
            writeAllOf(builder, key, (AppFunctionAllOfTypeMetadata) dataType, raw, components);
            return;
        }
        if (!(dataType instanceof AppFunctionParcelableTypeMetadata)) {
            androidx.constraintlayout.core.dsl.a.x("param '", key, "' unsupported dataType ", dataType.getClass().getSimpleName(), TAG);
            return;
        }
        Log.w(TAG, "param '" + key + "' Parcelable type is not supported by caller-side JSON args");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: execute-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7337executeBWLJW6A(android.content.Context r9, androidx.appfunctions.metadata.AppFunctionMetadata r10, java.util.Map<java.lang.String, ? extends java.lang.Object> r11, H7.c<? super kotlin.Result<com.stepos.ability.appfunctions.JetpackAppFunctions.JetpackExecResult>> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.stepos.ability.appfunctions.JetpackAppFunctions$execute$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.ability.appfunctions.JetpackAppFunctions$execute$1 r0 = (com.stepos.ability.appfunctions.JetpackAppFunctions$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ability.appfunctions.JetpackAppFunctions$execute$1 r0 = new com.stepos.ability.appfunctions.JetpackAppFunctions$execute$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = " failed: "
            java.lang.String r4 = "execute "
            java.lang.String r5 = "JetpackAppFunctions"
            r6 = 1
            if (r2 == 0) goto L53
            if (r2 != r6) goto L4b
            java.lang.Object r9 = r0.L$5
            androidx.appfunctions.ExecuteAppFunctionRequest r9 = (androidx.appfunctions.ExecuteAppFunctionRequest) r9
            java.lang.Object r9 = r0.L$4
            androidx.appfunctions.AppFunctionData r9 = (androidx.appfunctions.AppFunctionData) r9
            java.lang.Object r9 = r0.L$3
            androidx.appfunctions.AppFunctionManager r9 = (androidx.appfunctions.AppFunctionManager) r9
            java.lang.Object r9 = r0.L$2
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r9 = r0.L$1
            r10 = r9
            androidx.appfunctions.metadata.AppFunctionMetadata r10 = (androidx.appfunctions.metadata.AppFunctionMetadata) r10
            java.lang.Object r9 = r0.L$0
            android.content.Context r9 = (android.content.Context) r9
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            goto L91
        L46:
            r8 = move-exception
            goto Lb3
        L48:
            r8 = move-exception
            goto Lc7
        L4b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L53:
            kotlin.b.b(r12)
            androidx.appfunctions.AppFunctionManager$Companion r12 = androidx.appfunctions.AppFunctionManager.INSTANCE
            androidx.appfunctions.AppFunctionManager r9 = r12.getInstance(r9)
            if (r9 != 0) goto L6a
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "AppFunctionManager unavailable"
            r8.<init>(r9)
            kotlin.Result$Failure r8 = kotlin.b.a(r8)
            return r8
        L6a:
            androidx.appfunctions.AppFunctionData r11 = r8.buildParameters(r10, r11)     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            androidx.appfunctions.ExecuteAppFunctionRequest r12 = new androidx.appfunctions.ExecuteAppFunctionRequest     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            java.lang.String r2 = r10.getPackageName()     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            java.lang.String r7 = r10.getId()     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r12.<init>(r2, r7, r11)     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r11 = 0
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r0.L$4 = r11     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r0.L$5 = r11     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r0.label = r6     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            java.lang.Object r12 = r9.executeAppFunction(r12, r0)     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            if (r12 != r1) goto L91
            return r1
        L91:
            androidx.appfunctions.ExecuteAppFunctionResponse r12 = (androidx.appfunctions.ExecuteAppFunctionResponse) r12     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            boolean r9 = r12 instanceof androidx.appfunctions.ExecuteAppFunctionResponse.Success     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            if (r9 == 0) goto L9e
            androidx.appfunctions.ExecuteAppFunctionResponse$Success r12 = (androidx.appfunctions.ExecuteAppFunctionResponse.Success) r12     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            com.stepos.ability.appfunctions.JetpackAppFunctions$JetpackExecResult r8 = r8.parseSuccess(r12, r10)     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            return r8
        L9e:
            boolean r8 = r12 instanceof androidx.appfunctions.ExecuteAppFunctionResponse.Error     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            if (r8 == 0) goto Lad
            androidx.appfunctions.ExecuteAppFunctionResponse$Error r12 = (androidx.appfunctions.ExecuteAppFunctionResponse.Error) r12     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            androidx.appfunctions.AppFunctionException r8 = r12.getError()     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            kotlin.Result$Failure r8 = kotlin.b.a(r8)     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            return r8
        Lad:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            r8.<init>()     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
            throw r8     // Catch: java.lang.Throwable -> L46 androidx.appfunctions.AppFunctionException -> L48
        Lb3:
            java.lang.String r9 = r10.getId()
            java.lang.String r10 = r8.getMessage()
            java.lang.String r9 = B7.a.n(r4, r9, r3, r10)
            android.util.Log.e(r5, r9, r8)
            kotlin.Result$Failure r8 = kotlin.b.a(r8)
            goto Lda
        Lc7:
            java.lang.String r9 = r10.getId()
            java.lang.String r10 = r8.getMessage()
            java.lang.String r9 = B7.a.n(r4, r9, r3, r10)
            android.util.Log.e(r5, r9, r8)
            kotlin.Result$Failure r8 = kotlin.b.a(r8)
        Lda:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.JetpackAppFunctions.m7337executeBWLJW6A(android.content.Context, androidx.appfunctions.metadata.AppFunctionMetadata, java.util.Map, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scan(android.content.Context r12, java.lang.String r13, H7.c<? super java.util.List<androidx.appfunctions.metadata.AppFunctionMetadata>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stepos.ability.appfunctions.JetpackAppFunctions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ability.appfunctions.JetpackAppFunctions$scan$1 r0 = (com.stepos.ability.appfunctions.JetpackAppFunctions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ability.appfunctions.JetpackAppFunctions$scan$1 r0 = new com.stepos.ability.appfunctions.JetpackAppFunctions$scan$1
            r0.<init>(r14)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            java.lang.String r2 = "JetpackAppFunctions"
            r3 = 1
            if (r1 == 0) goto L49
            if (r1 != r3) goto L41
            java.lang.Object r12 = r0.L$4
            androidx.appfunctions.AppFunctionSearchSpec r12 = (androidx.appfunctions.AppFunctionSearchSpec) r12
            java.lang.Object r12 = r0.L$3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r0.L$2
            androidx.appfunctions.AppFunctionManager r12 = (androidx.appfunctions.AppFunctionManager) r12
            java.lang.Object r12 = r0.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r0.L$0
            android.content.Context r12 = (android.content.Context) r12
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L3d
            goto L9c
        L3d:
            r0 = move-exception
            r11 = r0
            goto Lbe
        L41:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L49:
            kotlin.b.b(r11)
            androidx.appfunctions.AppFunctionManager$Companion r11 = androidx.appfunctions.AppFunctionManager.INSTANCE
            androidx.appfunctions.AppFunctionManager r11 = r11.getInstance(r12)
            if (r11 != 0) goto L5c
            java.lang.String r11 = "scan: AppFunctionManager unavailable (feature unsupported / not API 33+)"
            android.util.Log.w(r2, r11)
            kotlin.collections.EmptyList r11 = kotlin.collections.EmptyList.f4893a
            return r11
        L5c:
            r12 = 0
            if (r13 == 0) goto L70
            java.lang.CharSequence r13 = j9.m.R0(r13)
            java.lang.String r13 = r13.toString()
            if (r13 == 0) goto L70
            int r1 = r13.length()
            if (r1 <= 0) goto L70
            goto L71
        L70:
            r13 = r12
        L71:
            if (r13 == 0) goto L79
            java.util.Set r13 = D7.N.Q(r13)
            r5 = r13
            goto L7a
        L79:
            r5 = r12
        L7a:
            androidx.appfunctions.AppFunctionSearchSpec r4 = new androidx.appfunctions.AppFunctionSearchSpec
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            p9.c r11 = r11.observeAppFunctions(r4)     // Catch: java.lang.Throwable -> L3d
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L3d
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L3d
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L3d
            r0.L$3 = r12     // Catch: java.lang.Throwable -> L3d
            r0.L$4 = r12     // Catch: java.lang.Throwable -> L3d
            r0.label = r3     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r11 = kotlinx.coroutines.flow.d.h(r11, r0)     // Catch: java.lang.Throwable -> L3d
            if (r11 != r14) goto L9c
            return r14
        L9c:
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Throwable -> L3d
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3d
            r12.<init>()     // Catch: java.lang.Throwable -> L3d
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L3d
        La7:
            boolean r13 = r11.hasNext()     // Catch: java.lang.Throwable -> L3d
            if (r13 == 0) goto Lbd
            java.lang.Object r13 = r11.next()     // Catch: java.lang.Throwable -> L3d
            androidx.appfunctions.metadata.AppFunctionPackageMetadata r13 = (androidx.appfunctions.metadata.AppFunctionPackageMetadata) r13     // Catch: java.lang.Throwable -> L3d
            java.util.List r13 = r13.getAppFunctions()     // Catch: java.lang.Throwable -> L3d
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch: java.lang.Throwable -> L3d
            D7.A.e0(r13, r12)     // Catch: java.lang.Throwable -> L3d
            goto La7
        Lbd:
            return r12
        Lbe:
            java.lang.String r12 = r11.getMessage()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "scan failed: "
            r13.<init>(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            android.util.Log.e(r2, r12, r11)
            kotlin.collections.EmptyList r11 = kotlin.collections.EmptyList.f4893a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.appfunctions.JetpackAppFunctions.scan(android.content.Context, java.lang.String, H7.c):java.lang.Object");
    }
}
