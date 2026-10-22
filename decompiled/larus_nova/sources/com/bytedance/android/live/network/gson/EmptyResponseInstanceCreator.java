package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.a;
import com.bytedance.android.live.network.response.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/network/gson/EmptyResponseInstanceCreator;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/network/response/a;", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmptyResponseInstanceCreator implements JsonDeserializer<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f83810a;

    public EmptyResponseInstanceCreator(Gson r100) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        this.f83810a = r100;
    }

    @Override // com.google.gson.JsonDeserializer
    public final a deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.isJsonObject() == false) goto L14;
        JsonObject r103 = r100.getAsJsonObject();
        JsonElement r104 = r103.get("status_code");
        if (r104 == null) goto L12;
        int r105 = r104.getAsInt();
        if (r105 != 0) goto L10;
        return new b.C1274b((Extra) GsonProtectorUtils.fromJson(this.f83810a, r103.get("extra"), Extra.class));
    L10:
        return new b.a(r105, (RequestError) GsonProtectorUtils.fromJson(this.f83810a, r103.get("data"), RequestError.class), (Extra) GsonProtectorUtils.fromJson(this.f83810a, r103.get("extra"), Extra.class));
    L12:
        throw new IllegalArgumentException(("status_code not found in response: " + r100).toString());
    L14:
        throw new IllegalStateException(("wrong type of json element for " + r101 + ", current: " + r100).toString());
    }
}
