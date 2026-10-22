package com.bytedance.android.livesdk.gift.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftExtraWrapperJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/livesdk/gift/model/GiftExtraWrapper;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class GiftExtraWrapperJsonAdapter implements JsonDeserializer<GiftExtraWrapper>, JsonSerializer<GiftExtraWrapper> {
    public GiftExtraWrapperJsonAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final GiftExtraWrapper deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(new GiftExtraWrapper((g0) r102.deserialize(r100, g0.class), null, r100.getAsJsonObject()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == true) goto L12;
        r103 = r105;
    L12:
        return (GiftExtraWrapper) r103;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(GiftExtraWrapper r100, Type r101, JsonSerializationContext r102) {
        GiftExtraWrapper r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r104 = r103.getRawJson();
        if (r104 == null) goto L6;
        return r104;
    L6:
        return r102.serialize(r103.getDecoded());
    }
}
