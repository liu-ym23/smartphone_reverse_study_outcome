package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/common/TimeTransformAdapter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Long;", "serialize", "timeMillis", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeTransformAdapter implements JsonSerializer<Long>, JsonDeserializer<Long> {
    public TimeTransformAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public Long deserialize(@NotNull JsonElement r10, @Nullable Type r11, @Nullable JsonDeserializationContext r12) {
        kotlin.jvm.internal.q.g(r10, "json");
        return Long.valueOf(r10.getAsLong() * 1000);
    }

    @NotNull
    public JsonElement serialize(long r10, @Nullable Type r11, @Nullable JsonSerializationContext r12) {
        return new JsonPrimitive(Long.valueOf(r10 / 1000));
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ Long deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        return deserialize(r10, r11, r12);
    }

    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(Long r10, Type r11, JsonSerializationContext r12) {
        return serialize(r10.longValue(), r11, r12);
    }
}
