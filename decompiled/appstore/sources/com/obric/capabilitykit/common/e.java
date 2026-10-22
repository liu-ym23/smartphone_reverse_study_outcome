package com.obric.capabilitykit.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/AppEntityDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements JsonDeserializer<AppEntity> {
    public e() {
    }

    @NotNull
    public AppEntity a(@Nullable JsonElement r10, @Nullable Type r11, @Nullable JsonDeserializationContext r12) {
        Integer r13 = null;
        if (r10 == null) goto L5;
        JsonObject r14 = r10.getAsJsonObject();
    L6:
        if (r14 == null) goto L10;
        JsonElement r15 = r14.get("type");
        if (r15 == null) goto L10;
        r13 = Integer.valueOf(r15.getAsInt());
    L10:
        EntityClassData<? extends AppEntity> r16 = EntityType.INSTANCE.getClassMap().get(r13);
        if (r16 == null) goto L17;
        GenericDeclaration r17 = r16.getClazz();
        if (r17 == null) goto L17;
        Object r18 = EntityExtKt.c().fromJson(r10, r17);
        kotlin.jvm.internal.q.f(r18, "innerEntityGson.fromJson(json, targetClass)");
        return (AppEntity) r18;
    L17:
        throw new IllegalArgumentException("Unknown entity type: " + r13);
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ AppEntity deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        return a(r10, r11, r12);
    }
}
