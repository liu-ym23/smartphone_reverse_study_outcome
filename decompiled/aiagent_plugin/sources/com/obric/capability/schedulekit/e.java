package com.obric.capability.schedulekit;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapterFactory;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.ExtraTypeAdapterFactory;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentPayloadHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f31908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f31909b = null;

    /* JADX INFO: compiled from: IntentPayloadHelper.kt */
    static final class a extends p implements d.h.a.a<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f31910a = null;

        static {
            f31910a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Gson invoke() {
            return a();
        }

        public final Gson a() {
            return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).registerTypeAdapterFactory((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(new ExtraTypeAdapterFactory(), TypeAdapterFactory.class, "com.obric.aiagent.plugin")).create();
        }
    }

    private e() {
    }

    static {
        f31908a = new e();
        f31909b = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f31910a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f31909b.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    public final String a(String r8, IntentParams r9, long r10, String r12, Map<String, String> r13) {
        IntentParams r11 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r9, IntentParams.class, "com.obric.aiagent.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "intentName");
        o.e(r6, "actionExt");
        if (r11 == null) goto L5;
        JsonObject r14 = new JsonParser().parse(f31908a.a().toJson(r11)).getAsJsonObject();
    L7:
        return a(r8, r14, r10, r12, r6);
    L5:
        r14 = null;
        goto L7
    }

    public final String a(String r8, String r9, long r10, String r12, Map<String, String> r13) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "intentName");
        o.e(r6, "actionExt");
        if (r9 == null) goto L5;
        JsonObject r11 = new JsonParser().parse(r9).getAsJsonObject();
    L7:
        return a(r8, r11, r10, r12, r6);
    L5:
        r11 = null;
        goto L7
    }

    private final String a(String r23, JsonObject r24, long r25, String r27, Map<String, String> r28) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        com.obric.capability.schedulekit.b.a.b r4 = com.obric.capability.schedulekit.b.a.b.a(new com.obric.capability.schedulekit.b.a.b().a(), r23, null, 2, null);
        if (r27 == null) goto L5;
        r4.a(r27);
    L5:
        if (r24 == null) goto L26;
        Iterator<String> r1 = r24.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L26;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r6 = r24.get(r5);
        if (ZeusTransformUtils.instanceOf(r6, JsonObject.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r6, JsonArray.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r6, JsonPrimitive.class) == false) goto L8;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin")).isBoolean() == true) goto L18;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin")).isNumber() == true) goto L21;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin")).isString() == false) goto L8;
        o.c(r5, "key");
        r4.a(r5, (com.obric.capabilitykit.common.execution.a.b) ZeusTransformUtils.preCheckCast(new com.obric.capabilitykit.common.execution.a.a.b(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsString()), com.obric.capabilitykit.common.execution.a.b.class, "com.obric.aiagent.plugin"));
        goto L8
    L21:
        o.c(r5, "key");
        r4.a(r5, (com.obric.capabilitykit.common.execution.a.b) ZeusTransformUtils.preCheckCast(new com.obric.capabilitykit.common.execution.a.a.b(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsNumber()), com.obric.capabilitykit.common.execution.a.b.class, "com.obric.aiagent.plugin"));
        goto L8
    L18:
        o.c(r5, "key");
        r4.a(r5, (com.obric.capabilitykit.common.execution.a.b) ZeusTransformUtils.preCheckCast(new com.obric.capabilitykit.common.execution.a.a.b(Boolean.valueOf(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsBoolean())), com.obric.capabilitykit.common.execution.a.b.class, "com.obric.aiagent.plugin"));
    L25:
        o.c(r5, "key");
        r4.a(r5, (com.obric.capabilitykit.common.execution.a.b) ZeusTransformUtils.preCheckCast(new com.obric.capabilitykit.common.execution.a.a.c(r6), com.obric.capabilitykit.common.execution.a.b.class, "com.obric.aiagent.plugin"));
    L26:
        JSONObject r0 = new JSONObject();
        r0.put("Version", 3);
        String r3 = r0.put("Content", r4.b().b().toString()).toString();
        o.c(r3, "JSONObject().let {\n     …g())\n        }.toString()");
        String r7 = com.obric.capabilitykit.common.a.a().toJson(new IMAppAction(0, Long.valueOf(r25), null, 0, Long.valueOf(r25), null, r3, null, 0, 0, 0, a(r2), 1965, null));
        o.c(r7, "gson.toJson(\n           …,\n            )\n        )");
        return r7;
    }

    public final IMAppActionExt a(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "actionExt");
        IMAppActionExt r3 = new IMAppActionExt();
        r3.putAll(r1);
        r3.put("to_server", "false");
        return r3;
    }
}
