package com.obric.appstore.network.entity.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.obric.appstore.network.entity.template.ElementAppEntity;
import com.obric.appstore.network.entity.template.ElementArrayEntity;
import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import com.obric.appstore.network.entity.template.ElementType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/appstore/network/entity/gson/ElementEntityDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/appstore/network/entity/template/ElementEntity;", "()V", "arrayGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getArrayGson", "()Lcom/google/gson/Gson;", "arrayGson$delegate", "Lkotlin/Lazy;", "gson", "getGson", "gson$delegate", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementEntityDeserializer implements JsonDeserializer<ElementEntity<?>> {

    @NotNull
    private final Lazy arrayGson$delegate;

    @NotNull
    private final Lazy gson$delegate;

    public ElementEntityDeserializer() {
        this.gson$delegate = b.b(ElementEntityDeserializer$gson$2.INSTANCE);
        this.arrayGson$delegate = b.b(ElementEntityDeserializer$arrayGson$2.INSTANCE);
    }

    private final Gson getArrayGson() {
        return (Gson) this.arrayGson$delegate.getValue();
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ ElementEntity<?> deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        return deserialize(r10, r11, r12);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ElementEntity<?> deserialize(@Nullable JsonElement r10, @Nullable Type r11, @Nullable JsonDeserializationContext r12) {
        ElementEntity<?> r13 = (ElementEntity) getGson().fromJson(r10, ElementEntity.class);
        int r14 = r13.getElementType();
        if (r14 != ElementType.TEXT.getValue()) goto L6;
    L7:
        r13 = (ElementEntity) getGson().fromJson(r10, ElementTextEntity.class);
    L14:
        q.d(r13);
        return r13;
    L6:
        if (r14 == ElementType.IMAGE.getValue()) goto L7;
        if (r14 != ElementType.ARRAY.getValue()) goto L12;
        r13 = (ElementEntity) getArrayGson().fromJson(r10, ElementArrayEntity.class);
        goto L14
    L12:
        if (r14 != ElementType.APP.getValue()) goto L14;
        r13 = (ElementEntity) getGson().fromJson(r10, ElementAppEntity.class);
        goto L14
    }
}
