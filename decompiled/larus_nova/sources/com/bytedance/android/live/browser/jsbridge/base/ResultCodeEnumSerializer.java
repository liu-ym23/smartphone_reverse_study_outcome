package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import w20.z9;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/ResultCodeEnumSerializer;", "Lcom/google/gson/JsonSerializer;", "Lw20/z9;", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResultCodeEnumSerializer implements JsonSerializer<z9> {
    public ResultCodeEnumSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(z9 r100, Type r101, JsonSerializationContext r102) {
        z9 r103 = r100;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.getCode());
    L7:
        return new JsonPrimitive(r104);
    L5:
        r104 = null;
        goto L7
    }
}
