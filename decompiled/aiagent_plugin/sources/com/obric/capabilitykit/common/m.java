package com.obric.capabilitykit.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements JsonDeserializer<MetaValue> {
    public m() {
    }

    public MetaValue a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        Integer r6 = null;
        if (r2 == null) goto L5;
        JsonObject r7 = r2.getAsJsonObject();
    L6:
        if (r7 == null) goto L10;
        JsonElement r8 = r7.get("type");
        if (r8 == null) goto L10;
        r6 = Integer.valueOf(r8.getAsInt());
    L10:
        Class r9 = (Class) ZeusTransformUtils.preCheckCast(MetaType.INSTANCE.getClassMap().get(r6), Class.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        Object r10 = EntityExtKt.b().fromJson(r2, r9);
        d.h.b.o.c(r10, "innerEntityGson.fromJson(json, targetClass)");
        return (MetaValue) ZeusTransformUtils.preCheckCast(r10, MetaValue.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalArgumentException("Unknown meta type: " + r6);
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ MetaValue deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }
}
