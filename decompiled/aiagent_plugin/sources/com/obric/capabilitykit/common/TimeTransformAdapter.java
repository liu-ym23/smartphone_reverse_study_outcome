package com.obric.capabilitykit.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeTransformAdapter implements JsonDeserializer<Long>, JsonSerializer<Long> {
    public TimeTransformAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Long deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "json");
        return Long.valueOf(r2.getAsLong() * 1000);
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ Long deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }

    public JsonElement serialize(long r2, Type r4, JsonSerializationContext r5) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r3 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        return new JsonPrimitive(Long.valueOf(r2 / 1000));
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(Long r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.aiagent.plugin");
        return serialize(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue(), r6, r7);
    }
}
