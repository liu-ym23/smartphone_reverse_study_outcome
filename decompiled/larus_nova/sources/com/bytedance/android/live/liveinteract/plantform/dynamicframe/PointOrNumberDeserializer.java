package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/PointOrNumberDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PointOrNumberDeserializer implements JsonDeserializer<Object> {
    public PointOrNumberDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.isJsonObject() == false) goto L6;
        return (Number) r102.deserialize(r100, tf0.s.class);
    L6:
        if (r100.isJsonPrimitive() == false) goto L10;
        return r100.getAsNumber();
    L10:
        throw new JsonParseException("Unexpected JSON type: " + r100.getClass());
    }
}
