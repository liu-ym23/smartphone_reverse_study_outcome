package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.r;
import java.lang.reflect.Type;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class AppEventTypeAdapter implements JsonDeserializer<AppEvent> {
    private final Gson mInnerJsonParser;

    public AppEventTypeAdapter() {
        this.mInnerJsonParser = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AppEvent deserialize(JsonElement r5, Type r6, JsonDeserializationContext r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r9 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r7, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        Object r10 = null;
        if (r5 == null) goto L5;
        JsonObject r11 = r5.getAsJsonObject();
    L6:
        if (r11 == null) goto L10;
        JsonElement r12 = r11.get("type");
        if (r12 == null) goto L10;
        String r13 = r12.getAsString();
    L11:
        Iterator<T> r0 = EventTypeKt.a().iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        Object r2 = r0.next();
        if (o.a(((r) ZeusTransformUtils.preCheckCast(r2, r.class, "com.obric.aiagent.plugin")).a(), r13) == false) goto L13;
        r10 = r2;
    L17:
        r r14 = (r) ZeusTransformUtils.preCheckCast(r10, r.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L24;
        Class r15 = (Class) ZeusTransformUtils.preCheckCast(r14.b(), Class.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L24;
        Object r4 = this.mInnerJsonParser.fromJson(r5, r15);
        o.c(r4, "mInnerJsonParser.fromJson(json, targetClass)");
        return (AppEvent) ZeusTransformUtils.preCheckCast(r4, AppEvent.class, "com.obric.aiagent.plugin");
    L24:
        throw new IllegalArgumentException("Unknown entity type: " + r13);
    L10:
        r13 = null;
        goto L11
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ AppEvent deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }
}
