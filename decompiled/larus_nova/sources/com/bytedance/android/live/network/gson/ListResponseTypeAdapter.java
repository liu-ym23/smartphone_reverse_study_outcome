package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes46.dex */
public class ListResponseTypeAdapter extends AbsJsonDeserializer<ListResponse> {
    public ListResponseTypeAdapter(Gson r100) {
        super(r100);
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        JsonObject r103 = r100.getAsJsonObject();
        int r104 = r103.get("status_code").getAsInt();
        if (r104 == 0) goto L7;
        ListResponse r105 = new ListResponse();
        r105.statusCode = r104;
        r105.extra = (R) GsonProtectorUtils.fromJson(this.f83809a, r103.get("extra"), Extra.class);
        r105.error = (RequestError) GsonProtectorUtils.fromJson(this.f83809a, r103.get("data"), RequestError.class);
        return r105;
    L7:
        return (ListResponse) GsonProtectorUtils.fromJson(this.f83809a, r100, r101);
    }
}
