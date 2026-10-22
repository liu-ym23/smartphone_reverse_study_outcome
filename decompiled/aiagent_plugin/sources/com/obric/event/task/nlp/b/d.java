package com.obric.event.task.nlp.b;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DeviceConditionDeserializerTypeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements JsonDeserializer<com.obric.event.task.nlp.api.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32956a;

    /* JADX INFO: compiled from: DeviceConditionDeserializerTypeAdapter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32957a = null;

        static {
            int[] r0 = new int[com.obric.event.task.nlp.api.f.values().length];
            r0[com.obric.event.task.nlp.api.f.f32906c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[com.obric.event.task.nlp.api.f.f32904a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[com.obric.event.task.nlp.api.f.f32905b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[com.obric.event.task.nlp.api.f.f32907d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[com.obric.event.task.nlp.api.f.f32908e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[com.obric.event.task.nlp.api.f.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f32957a = r0;
        }
    }

    public d() {
        this.f32956a = "DeviceConditionDeserializerTypeAdapter";
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ com.obric.event.task.nlp.api.e deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.event.task.nlp.api.e a(JsonElement r6, Type r7, JsonDeserializationContext r8) {
        Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r10 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r8, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        Map r11 = null;
        if (r6 == null) goto L45;
        if (r10 == null) goto L45;
        JsonObject r12 = r6.getAsJsonObject();
        JsonElement r0 = r12.get("type");
        if (r0 != null) goto L9;
    L11:
        com.obric.event.task.nlp.api.f r1 = null;
    L12:
        JsonElement r13 = r12.get("params");
        if (r13 == null) goto L44;
        if (r13.isJsonObject() == false) goto L44;
        JsonObject r14 = r13.getAsJsonObject();
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        int r3 = -1;
    L20:
        switch(r3) {
            case 1: goto L38;
            case 2: goto L35;
            case 3: goto L32;
            case 4: goto L29;
            case 5: goto L26;
            case 6: goto L23;
            default: goto L21;
        };
    L21:
        com.obric.event.task.nlp.a.a.f32889a.d(this.f32956a, WsConstants.KEY_CONNECTION_ERROR);
    L41:
        if ((!r2.isEmpty()) == false) goto L44;
        r11 = r2;
        goto L44
    L23:
        if (r14.has(com.obric.event.task.nlp.api.h.d()) == false) goto L41;
        r2.put(com.obric.event.task.nlp.api.h.d(), Integer.valueOf(r14.get(com.obric.event.task.nlp.api.h.d()).getAsInt()));
        goto L41
    L26:
        if (r14.has(com.obric.event.task.nlp.api.h.d()) == false) goto L41;
        r2.put(com.obric.event.task.nlp.api.h.d(), Integer.valueOf(r14.get(com.obric.event.task.nlp.api.h.d()).getAsInt()));
        goto L41
    L29:
        if (r14.has(com.obric.event.task.nlp.api.h.d()) == false) goto L41;
        r2.put(com.obric.event.task.nlp.api.h.d(), Integer.valueOf(r14.get(com.obric.event.task.nlp.api.h.d()).getAsInt()));
        goto L41
    L32:
        if (r14.has(com.obric.event.task.nlp.api.h.b()) == false) goto L41;
        r2.put(com.obric.event.task.nlp.api.h.b(), r10.deserialize(r14.get(com.obric.event.task.nlp.api.h.b()), (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.a.class, Type.class, "com.obric.aiagent.plugin")));
        goto L41
    L35:
        if (r14.has(com.obric.event.task.nlp.api.h.c()) == false) goto L41;
        r2.put(com.obric.event.task.nlp.api.h.c(), r10.deserialize(r14.get(com.obric.event.task.nlp.api.h.c()), (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.a.class, Type.class, "com.obric.aiagent.plugin")));
        goto L41
    L38:
        if (r14.has(com.obric.event.task.nlp.api.h.a()) == false) goto L41;
        r2.put(com.obric.event.task.nlp.api.h.a(), r10.deserialize(r14.get(com.obric.event.task.nlp.api.h.a()), (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.a.class, Type.class, "com.obric.aiagent.plugin")));
        goto L41
    L19:
        r3 = a.f32957a[r1.ordinal()];
    L44:
        return new com.obric.event.task.nlp.api.e(r1, r11);
    L9:
        if (r0.isJsonNull() == true) goto L11;
        r1 = (com.obric.event.task.nlp.api.f) ZeusTransformUtils.preCheckCast(r10.deserialize(r0, (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.f.class, Type.class, "com.obric.aiagent.plugin")), com.obric.event.task.nlp.api.f.class, "com.obric.aiagent.plugin");
    L45:
        com.obric.event.task.nlp.a.a.f32889a.d("DeviceConditionDeserializerTypeAdapter", "deserializer error");
        return null;
    }
}
