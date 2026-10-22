package com.obric.capabilitykit.common;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements JsonSerializer<MetaValue> {
    public o() {
    }

    public JsonElement a(MetaValue r2, Type r3, JsonSerializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r5 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        JsonElement r6 = EntityExtKt.b().toJsonTree(r2);
        d.h.b.o.c(r6, "innerEntityGson.toJsonTree(src)");
        return r6;
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(MetaValue r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        return a((MetaValue) ZeusTransformUtils.preCheckCast(r3, MetaValue.class, "com.obric.aiagent.plugin"), r6, r7);
    }
}
