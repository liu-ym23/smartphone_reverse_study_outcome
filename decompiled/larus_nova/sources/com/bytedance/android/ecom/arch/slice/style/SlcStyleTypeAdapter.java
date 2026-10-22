package com.bytedance.android.ecom.arch.slice.style;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/style/SlcStyleTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcStyleTypeAdapter implements JsonDeserializer<SlcStyle>, JsonSerializer<SlcStyle> {
    public SlcStyleTypeAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final SlcStyle deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.isJsonObject() == true) goto L6;
        return null;
    L6:
        return new SlcStyle((HashMap) r102.deserialize(r100.getAsJsonObject(), new a().getType()));
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(SlcStyle r100, Type r101, JsonSerializationContext r102) {
        SlcStyle r103 = r100;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 == null) goto L5;
        Map<String, Object> r104 = r103.getAttrs();
    L6:
        if (r104 == null) goto L23;
        JsonObject r105 = new JsonObject();
        Iterator<Map.Entry<String, Object>> r106 = r103.getAttrs().entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L16;
        Map.Entry<String, Object> r107 = r106.next();
        String r108 = r107.getKey();
        Object r109 = r107.getValue();
        if (r109 == null) goto L13;
        r105.add(r108, r102.serialize(r109));
        goto L10
    L13:
        r105.add(r108, JsonNull.INSTANCE);
        goto L10
    L16:
        return r105;
    L23:
        return new JsonObject();
    L5:
        r104 = null;
        goto L6
    }
}
