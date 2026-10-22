package com.stepos.ability.agentbusclient;

import H4.o;
import J7.c;
import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.agentbus.IAbilityCatalog;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.CallType;
import com.stepos.ability.commoninternal.CallingMethod;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import dagger.hilt.android.qualifiers.ApplicationContext;
import j9.m;
import j9.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u00020\u00132\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0001*\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 J*\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$¨\u0006&"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityListExecutor;", "", "Landroid/content/Context;", "context", "Lcom/stepos/ability/api/agentbus/IAbilityCatalog;", "abilityCatalog", AppAgent.CONSTRUCT, "(Landroid/content/Context;Lcom/stepos/ability/api/agentbus/IAbilityCatalog;)V", "", "appNamesJson", "", "parseAppNames", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "", "toAgentBusMap", "(Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;)Ljava/util/Map;", "", "abilities", "LC7/r;", "appendGuiAgentIfMissing", "(Ljava/util/List;)V", "guiAgentSchema", "()Ljava/util/Map;", "toSchemaPayload", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "jsonToKotlin", "(Ljava/lang/Object;)Ljava/lang/Object;", "code", "message", "errorPayload", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "execute", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Lcom/stepos/ability/api/agentbus/IAbilityCatalog;", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityListExecutor {
    private static final Companion Companion = new Companion(null);
    private static final String GUI_AGENT_METHOD = "gui_agent";
    private static final int GUI_AGENT_TIMEOUT_SEC = 600;
    private static final String TAG = "AbilityListExecutor";
    private final IAbilityCatalog abilityCatalog;
    private final Context context;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityListExecutor$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "GUI_AGENT_METHOD", "GUI_AGENT_TIMEOUT_SEC", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @c(c = "com.stepos.ability.agentbusclient.AbilityListExecutor", f = "AbilityListExecutor.kt", l = {28}, m = "execute", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.AbilityListExecutor$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbilityListExecutor.this.execute(null, this);
        }
    }

    @Inject
    public AbilityListExecutor(@ApplicationContext Context context, IAbilityCatalog abilityCatalog) {
        k.f(context, "context");
        k.f(abilityCatalog, "abilityCatalog");
        this.context = context;
        this.abilityCatalog = abilityCatalog;
    }

    private final void appendGuiAgentIfMissing(List<Map<String, Object>> abilities) {
        List<Map<String, Object>> list = abilities;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                if (k.b(map.get(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD), GUI_AGENT_METHOD) || k.b(map.get("toolName"), GUI_AGENT_METHOD)) {
                    return;
                }
            }
        }
        MapBuilder mapBuilder = new MapBuilder();
        Map<String, Object> mapGuiAgentSchema = guiAgentSchema();
        mapBuilder.put(HintConstants.AUTOFILL_HINT_NAME, GUI_AGENT_METHOD);
        mapBuilder.put("toolName", GUI_AGENT_METHOD);
        mapBuilder.put("description", "GUI Agent task runner");
        mapBuilder.put(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, GUI_AGENT_METHOD);
        mapBuilder.put("functionName", GUI_AGENT_METHOD);
        mapBuilder.put("packageName", this.context.getPackageName());
        mapBuilder.put("params", mapGuiAgentSchema);
        mapBuilder.put("inputSchema", mapGuiAgentSchema);
        mapBuilder.put(InjectExperienceResult.REASON_TIMEOUT, 600);
        mapBuilder.put("callingMethod", CallingMethod.LOCAL);
        mapBuilder.put("callType", CallType.FUNCTION_CALL);
        abilities.add(mapBuilder.b());
    }

    private final Map<String, Object> errorPayload(String code, String message) {
        return kotlin.collections.a.R(new Pair("ok", Boolean.FALSE), new Pair("errorCode", code), new Pair("errorMessage", message));
    }

    public static /* synthetic */ Object execute$default(AbilityListExecutor abilityListExecutor, String str, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return abilityListExecutor.execute(str, cVar);
    }

    private final Map<String, Object> guiAgentSchema() {
        return kotlin.collections.a.R(new Pair("type", "object"), new Pair("properties", kotlin.collections.a.Q(new Pair("gui_agent_param", kotlin.collections.a.R(new Pair("type", "object"), new Pair("properties", kotlin.collections.a.R(new Pair(GuiAgentConfigKt.META_KEY_APP_NAME, kotlin.collections.a.R(new Pair("type", TypedValues.Custom.S_STRING), new Pair("description", "Target app name"))), new Pair("task", kotlin.collections.a.R(new Pair("type", TypedValues.Custom.S_STRING), new Pair("description", "Task description"))), new Pair("meta", kotlin.collections.a.R(new Pair("type", "object"), new Pair("description", "Optional task metadata"))))), new Pair("required", o.N(GuiAgentConfigKt.META_KEY_APP_NAME, "task")))))), new Pair("required", o.M("gui_agent_param")));
    }

    private final Object jsonToKotlin(Object value) {
        if (value instanceof JSONObject) {
            MapBuilder mapBuilder = new MapBuilder();
            JSONObject jSONObject = (JSONObject) value;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                k.c(next);
                mapBuilder.put(next, jsonToKotlin(jSONObject.opt(next)));
            }
            return mapBuilder.b();
        }
        if (!(value instanceof JSONArray)) {
            return (k.b(value, JSONObject.NULL) || value == null) ? "" : value;
        }
        ListBuilder listBuilderY = o.y();
        JSONArray jSONArray = (JSONArray) value;
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            listBuilderY.add(jsonToKotlin(jSONArray.opt(i)));
        }
        return o.q(listBuilderY);
    }

    private final List<String> parseAppNames(String appNamesJson) {
        if (appNamesJson == null || m.s0(appNamesJson)) {
            return null;
        }
        String string = m.R0(appNamesJson).toString();
        if (!t.e0(string, "[", false)) {
            return o.M(string);
        }
        JSONArray jSONArray = new JSONArray(string);
        ListBuilder listBuilderY = o.y();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String strOptString = jSONArray.optString(i);
            k.e(strOptString, "optString(...)");
            String string2 = m.R0(strOptString).toString();
            if (string2.length() > 0) {
                listBuilderY.add(string2);
            }
        }
        ListBuilder listBuilderQ = o.q(listBuilderY);
        if (listBuilderQ.isEmpty()) {
            return null;
        }
        return listBuilderQ;
    }

    private final Map<String, Object> toAgentBusMap(AbilityMetaDataResult abilityMetaDataResult) {
        MapBuilder mapBuilder = new MapBuilder();
        Object schemaPayload = toSchemaPayload(abilityMetaDataResult.getInputSchema());
        mapBuilder.put(HintConstants.AUTOFILL_HINT_NAME, abilityMetaDataResult.getToolName());
        mapBuilder.put("toolName", abilityMetaDataResult.getToolName());
        mapBuilder.put("description", abilityMetaDataResult.getDescription());
        mapBuilder.put(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, abilityMetaDataResult.getToolName());
        mapBuilder.put("functionName", abilityMetaDataResult.getFunctionName());
        mapBuilder.put("packageName", abilityMetaDataResult.getPackageName());
        mapBuilder.put("params", schemaPayload);
        mapBuilder.put("inputSchema", schemaPayload);
        mapBuilder.put(InjectExperienceResult.REASON_TIMEOUT, Integer.valueOf(abilityMetaDataResult.getTimeout()));
        if (abilityMetaDataResult.getIcon().length() > 0) {
            mapBuilder.put("icon", abilityMetaDataResult.getIcon());
        }
        if (abilityMetaDataResult.getAppVersion().length() > 0) {
            mapBuilder.put("appVersion", abilityMetaDataResult.getAppVersion());
        }
        if (abilityMetaDataResult.getPkgSign().length() > 0) {
            mapBuilder.put("pkgSign", abilityMetaDataResult.getPkgSign());
        }
        if (abilityMetaDataResult.getCallingMethod().length() > 0) {
            mapBuilder.put("callingMethod", abilityMetaDataResult.getCallingMethod());
        }
        if (abilityMetaDataResult.getCallType().length() > 0) {
            mapBuilder.put("callType", abilityMetaDataResult.getCallType());
        }
        Map<String, Object> extra = abilityMetaDataResult.getExtra();
        if (extra != null) {
            if (extra.isEmpty()) {
                extra = null;
            }
            if (extra != null) {
                mapBuilder.put("extra", extra);
            }
        }
        return mapBuilder.b();
    }

    private final Object toSchemaPayload(String str) {
        Object objA;
        if (m.s0(str)) {
            return kotlin.collections.a.M();
        }
        try {
            objA = jsonToKotlin(new JSONTokener(str).nextValue());
        } catch (Throwable th) {
            objA = b.a(th);
        }
        return Result.a(objA) == null ? objA : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(java.lang.String r9, H7.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r10) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityListExecutor.execute(java.lang.String, H7.c):java.lang.Object");
    }
}
