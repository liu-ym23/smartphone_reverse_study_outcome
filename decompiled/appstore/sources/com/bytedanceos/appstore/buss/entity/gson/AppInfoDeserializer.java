package com.bytedanceos.appstore.buss.entity.gson;

import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.item.AppInfoItem;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/gson/AppInfoDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppInfoDeserializer implements JsonDeserializer<AppInfoEntity> {

    @NotNull
    private final Gson gson;

    public AppInfoDeserializer() {
        this.gson = new Gson();
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ AppInfoEntity deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        return deserialize(r10, r11, r12);
    }

    @NotNull
    public final Gson getGson() {
        return this.gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public AppInfoEntity deserialize(@Nullable JsonElement r10, @Nullable Type r11, @Nullable JsonDeserializationContext r12) {
        AppInfoEntity r13 = (AppInfoEntity) this.gson.fromJson(r10, AppInfoEntity.class);
        r13.setItem(new AppInfoItem(r13));
        return r13;
    }
}
