package com.obric.memorydata.sdk.screencapture.rule;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: ScreenEventRuleDeserializerTypeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements JsonDeserializer<ScreenEventRule> {
    public e() {
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ ScreenEventRule deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }

    public ScreenEventRule a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        o.e(r2, "json");
        o.e(r1, "typeOfT");
        ScreenEventRule.a r6 = ScreenEventRule.Companion;
        String r7 = r2.toString();
        o.c(r7, "toString(...)");
        ScreenEventRule r8 = r6.a(r7);
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalArgumentException("invalid json for ScreenEventRule");
    }
}
