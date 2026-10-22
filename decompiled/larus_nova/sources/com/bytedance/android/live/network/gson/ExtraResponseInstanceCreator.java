package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.d;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/network/gson/ExtraResponseInstanceCreator;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtraResponseInstanceCreator implements JsonDeserializer<ExtraResponse<?, ?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f83811a;

    public ExtraResponseInstanceCreator(Gson r100) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        this.f83811a = r100;
    }

    @Override // com.google.gson.JsonDeserializer
    public final ExtraResponse<?, ?> deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101 instanceof ParameterizedType) == false) goto L20;
        if (r100.isJsonObject() == false) goto L18;
        JsonObject r103 = r100.getAsJsonObject();
        JsonElement r104 = r103.get("status_code");
        if (r104 != null) goto L9;
        r104 = r103.get(LKBaseResponseModel.ERROR_NO_KEY);
    L9:
        if (r104 == null) goto L16;
        int r105 = r104.getAsInt();
        if (r105 != 0) goto L14;
        ParameterizedType r106 = (ParameterizedType) r101;
        return new d.b(GsonProtectorUtils.fromJson(this.f83811a, r103.get("data"), r106.getActualTypeArguments()[0]), (Extra) GsonProtectorUtils.fromJson(this.f83811a, r103.get("extra"), r106.getActualTypeArguments()[1]));
    L14:
        return new d.a(r105, (RequestError) GsonProtectorUtils.fromJson(this.f83811a, r103.get("data"), RequestError.class), (Extra) GsonProtectorUtils.fromJson(this.f83811a, r103.get("extra"), ((ParameterizedType) r101).getActualTypeArguments()[1]));
    L16:
        throw new IllegalArgumentException(("status_code not found in response: " + r100).toString());
    L18:
        throw new IllegalStateException(("wrong type of json element for " + r101 + ", current: " + r100).toString());
    L20:
        throw new IllegalStateException(("typeOfT must be ParameterizedType, current is: " + r101).toString());
    }
}
