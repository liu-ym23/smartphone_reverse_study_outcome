package com.bytedanceos.appstore.buss.cms.beta;

import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementAppListEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementArrayEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementJumpEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementPictureEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementTextEntity;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR#\u0010\u000e\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/ElementEntityDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "()V", "appGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getAppGson", "()Lcom/google/gson/Gson;", "appGson$delegate", "Lkotlin/Lazy;", "arrayGson", "getArrayGson", "arrayGson$delegate", "gson", "getGson", "gson$delegate", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementEntityDeserializer implements JsonDeserializer<BetaElementEntity<?>> {

    @NotNull
    private final Lazy appGson$delegate;

    @NotNull
    private final Lazy arrayGson$delegate;

    @NotNull
    private final Lazy gson$delegate;

    public ElementEntityDeserializer() {
        this.gson$delegate = b.b(ElementEntityDeserializer$gson$2.INSTANCE);
        this.appGson$delegate = b.b(ElementEntityDeserializer$appGson$2.INSTANCE);
        this.arrayGson$delegate = b.b(ElementEntityDeserializer$arrayGson$2.INSTANCE);
    }

    private final Gson getAppGson() {
        return (Gson) this.appGson$delegate.getValue();
    }

    private final Gson getArrayGson() {
        return (Gson) this.arrayGson$delegate.getValue();
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ BetaElementEntity<?> deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        return deserialize(r10, r11, r12);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public BetaElementEntity<?> deserialize(@Nullable JsonElement r10, @Nullable Type r11, @Nullable JsonDeserializationContext r12) {
        BetaElementEntity<?> r13 = (BetaElementEntity) getGson().fromJson(r10, BetaElementEntity.class);
        int r14 = r13.getElementType();
        if (r14 != 1) goto L5;
        r13 = (BetaElementEntity) getGson().fromJson(r10, BetaElementTextEntity.class);
    L18:
        q.d(r13);
        return r13;
    L5:
        if (r14 != 2) goto L7;
        r13 = (BetaElementEntity) getGson().fromJson(r10, BetaElementPictureEntity.class);
        goto L18
    L7:
        if (r14 != 4) goto L9;
        r13 = (BetaElementEntity) getAppGson().fromJson(r10, BetaElementAppListEntity.class);
        goto L18
    L9:
        if (r14 != 7) goto L11;
        r13 = (BetaElementEntity) getGson().fromJson(r10, BetaElementJumpEntity.class);
        goto L18
    L11:
        if (r14 != 12) goto L18;
        r13 = (BetaElementEntity) getArrayGson().fromJson(r10, BetaElementArrayEntity.class);
        goto L18
    }
}
