package com.bytedance.android.livesdkapi.message.lazy;

import com.bytedance.android.live.base.model.message.a5;
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

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/lazy/LazyTextJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/livesdkapi/message/lazy/LazyText;", "Lcom/google/gson/JsonSerializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
final class LazyTextJsonAdapter implements JsonDeserializer<LazyText>, JsonSerializer<LazyText> {
    public LazyTextJsonAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public LazyText deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        LazyText r103 = new LazyText(null);
        r103.setJsonDecoded$live_model_api_saasRelease((a5) r102.deserialize(r100, a5.class));
        return r103;
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public JsonElement serialize2(LazyText r100, Type r101, JsonSerializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r100.getSerializedJson$live_model_api_saasRelease();
        if (r103 == null) goto L6;
        return r103;
    L6:
        return r102.serialize(r100.getText());
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ LazyText deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        return deserialize(r100, r101, r102);
    }

    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(LazyText r100, Type r101, JsonSerializationContext r102) {
        return serialize2(r100, r101, r102);
    }
}
