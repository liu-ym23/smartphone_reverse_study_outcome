package com.obric.capabilitykit.common;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/AppEntitySerializerTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements JsonSerializer<AppEntity> {
    public f() {
    }

    @NotNull
    public JsonElement a(@Nullable AppEntity r10, @Nullable Type r11, @Nullable JsonSerializationContext r12) {
        JsonElement r13 = EntityExtKt.c().toJsonTree(r10);
        kotlin.jvm.internal.q.f(r13, "innerEntityGson.toJsonTree(src)");
        return r13;
    }

    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(AppEntity r10, Type r11, JsonSerializationContext r12) {
        return a(r10, r11, r12);
    }
}
