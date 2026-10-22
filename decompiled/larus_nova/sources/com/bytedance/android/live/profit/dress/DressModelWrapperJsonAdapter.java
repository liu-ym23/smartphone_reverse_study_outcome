package com.bytedance.android.live.profit.dress;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/dress/DressModelWrapperJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/profit/dress/DressModelWrapper;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
final class DressModelWrapperJsonAdapter implements JsonDeserializer<DressModelWrapper>, JsonSerializer<DressModelWrapper> {
    public DressModelWrapperJsonAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final DressModelWrapper deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new DressModelWrapper((o) r102.deserialize(r100, o.class), null, r100.getAsJsonObject());
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(DressModelWrapper r100, Type r101, JsonSerializationContext r102) {
        DressModelWrapper r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r104 = r103.getJson();
        if (r104 == null) goto L6;
        return r104;
    L6:
        return r102.serialize(r103.getDecoded());
    }
}
