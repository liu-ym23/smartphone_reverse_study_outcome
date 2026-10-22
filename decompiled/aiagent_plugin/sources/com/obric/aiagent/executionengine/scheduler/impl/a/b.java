package com.obric.aiagent.executionengine.scheduler.impl.a;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: AtomExecutorUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements JsonDeserializer<AppEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f18030a;

    public b() {
        this.f18030a = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).create();
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ AppEntity deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
    }

    public AppEntity a(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonDeserializationContext r7 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
        Integer r8 = null;
        if (r3 == null) goto L5;
        JsonObject r9 = r3.getAsJsonObject();
    L6:
        if (r9 == null) goto L10;
        JsonElement r10 = r9.get("type");
        if (r10 == null) goto L10;
        r8 = Integer.valueOf(r10.getAsInt());
    L10:
        EntityClassData r11 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(r8), EntityClassData.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L32;
        Class r12 = r11.getClazz();
        if (r12 == null) goto L32;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L16
        b r14 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Object r15 = n.f((AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r3, r12), AppEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L19:
        if (n.c(r15) == null) goto L26;
        n.a r16 = n.f38560a;     // Catch: Throwable -> L23
        r15 = n.f((AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.c().fromJson(r3, r12), AppEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        n.a r0 = n.f38560a;
        r15 = n.f(o.a(th));
    L26:
        if (n.c(r15) == null) goto L29;
        r15 = (AppEntity) ZeusTransformUtils.preCheckCast(this.f18030a.fromJson(r3, r12), AppEntity.class, "com.obric.aiagent.plugin");
    L29:
        d.h.b.o.c(r15, "getOrElse(...)");
        return (AppEntity) ZeusTransformUtils.preCheckCast(r15, AppEntity.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        n.a r1 = n.f38560a;
        r15 = n.f(o.a(th));
    L32:
        throw new IllegalArgumentException("Unknown entity type: " + r8);
    L5:
        r9 = null;
        goto L6
    }
}
