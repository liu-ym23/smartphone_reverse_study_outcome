package com.obric.event.task.nlp.b;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: DeviceConditionSerializerTypeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements JsonSerializer<com.obric.event.task.nlp.api.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32958a;

    /* JADX INFO: compiled from: DeviceConditionSerializerTypeAdapter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32959a = null;

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
            f32959a = r0;
        }
    }

    public e() {
        this.f32958a = "DeviceConditionSerializerTypeAdapter";
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(com.obric.event.task.nlp.api.e r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        return a((com.obric.event.task.nlp.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.event.task.nlp.api.e.class, "com.obric.aiagent.plugin"), r6, r7);
    }

    public JsonElement a(com.obric.event.task.nlp.api.e r7, Type r8, JsonSerializationContext r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r11 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r9, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        Object r12 = null;
        if (r7 == null) goto L48;
        if (r11 == null) goto L48;
        JsonObject r0 = new JsonObject();
        if (r7.getType() == null) goto L9;
        r0.add("type", r11.serialize(r7.getType(), (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.f.class, Type.class, "com.obric.aiagent.plugin")));
    L9:
        Map<String, Object> r2 = r7.a();
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L47;
        JsonObject r4 = new JsonObject();
        com.obric.event.task.nlp.api.f r5 = r7.getType();
        if (r5 != null) goto L20;
        int r6 = -1;
    L21:
        switch(r6) {
            case 1: goto L38;
            case 2: goto L33;
            case 3: goto L28;
            case 4: goto L23;
            case 5: goto L23;
            case 6: goto L23;
            default: goto L22;
        };
    L22:
        com.obric.event.task.nlp.a.a.f32889a.d(this.f32958a, "error unhandled type: " + r7.getType());
    L44:
        if (r4.size() <= 0) goto L47;
        r0.add("params", (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L47
    L23:
        Object r13 = r2.get(com.obric.event.task.nlp.api.h.d());
        if (ZeusTransformUtils.instanceOf(r13, Integer.class) == false) goto L26;
        r12 = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.aiagent.plugin");
    L26:
        if (r12 == null) goto L44;
        r4.addProperty(com.obric.event.task.nlp.api.h.d(), (Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin"));
        goto L44
    L28:
        Object r14 = r2.get(com.obric.event.task.nlp.api.h.b());
        if (ZeusTransformUtils.instanceOf(r14, com.obric.event.task.nlp.api.a.class) == false) goto L31;
        r12 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r14, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L31:
        if (r12 == null) goto L44;
        r4.add(com.obric.event.task.nlp.api.h.b(), r11.serialize(r12, (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.a.class, Type.class, "com.obric.aiagent.plugin")));
        goto L44
    L33:
        Object r15 = r2.get(com.obric.event.task.nlp.api.h.c());
        if (ZeusTransformUtils.instanceOf(r15, com.obric.event.task.nlp.api.a.class) == false) goto L36;
        r12 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r15, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L36:
        if (r12 == null) goto L44;
        r4.add(com.obric.event.task.nlp.api.h.c(), r11.serialize(r12, (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.a.class, Type.class, "com.obric.aiagent.plugin")));
        goto L44
    L38:
        Object r16 = r2.get(com.obric.event.task.nlp.api.h.a());
        if (ZeusTransformUtils.instanceOf(r16, com.obric.event.task.nlp.api.a.class) == false) goto L41;
        r12 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r16, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L41:
        if (r12 == null) goto L44;
        r4.add(com.obric.event.task.nlp.api.h.a(), r11.serialize(r12, (Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.a.class, Type.class, "com.obric.aiagent.plugin")));
        goto L44
    L20:
        r6 = a.f32959a[r5.ordinal()];
    L47:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.aiagent.plugin");
    L12:
        if (r2.isEmpty() == true) goto L15;
        r3 = false;
    L48:
        com.obric.event.task.nlp.a.a.f32889a.d(this.f32958a, "serializer error");
        return null;
    }
}
