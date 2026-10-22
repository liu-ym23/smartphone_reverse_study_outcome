package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.i;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/network/gson/LazyExtraJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/base/model/i;", "<init>", "()V", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LazyExtraJsonAdapter implements JsonDeserializer<i> {
    public LazyExtraJsonAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final i deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        return new i(null, r100);
    }
}
