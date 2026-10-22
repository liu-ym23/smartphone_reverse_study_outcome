package com.bytedance.android.gamecp.common.network.networklib.gson;

import com.bytedance.android.gamecp.base.network.response.RequestError;
import com.bytedance.android.gamecp.base.network.response.g;
import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes44.dex */
public class ListResponseTypeAdapter extends AbsJsonDeserializer<g> {
    public ListResponseTypeAdapter(Gson r100) {
        super(r100);
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        JsonObject r103 = r100.getAsJsonObject();
        int r104 = r103.get("status_code").getAsInt();
        if (r104 == 0) goto L7;
        g r105 = new g();
        r105.statusCode = r104;
        r105.extra = (R) GsonProtectorUtils.fromJson(this.f56700a, r103.get("extra"), Extra.class);
        r105.f51685a = (RequestError) GsonProtectorUtils.fromJson(this.f56700a, r103.get("data"), RequestError.class);
        return r105;
    L7:
        return (g) GsonProtectorUtils.fromJson(this.f56700a, r100, r101);
    }
}
