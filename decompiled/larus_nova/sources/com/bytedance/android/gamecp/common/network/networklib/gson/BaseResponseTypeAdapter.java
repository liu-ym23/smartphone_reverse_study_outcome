package com.bytedance.android.gamecp.common.network.networklib.gson;

import com.bytedance.android.gamecp.base.network.response.RequestError;
import com.bytedance.android.gamecp.base.network.response.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes44.dex */
public class BaseResponseTypeAdapter extends AbsJsonDeserializer<b> {
    public BaseResponseTypeAdapter(Gson r100) {
        super(r100);
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        b r103 = (b) GsonProtectorUtils.fromJson(this.f56700a, r100, r101);
        if (r103.statusCode == 0) goto L5;
        r103.f51687b = (RequestError) GsonProtectorUtils.fromJson(this.f56700a, r100.getAsJsonObject().get("data"), RequestError.class);
    L5:
        return r103;
    }
}
