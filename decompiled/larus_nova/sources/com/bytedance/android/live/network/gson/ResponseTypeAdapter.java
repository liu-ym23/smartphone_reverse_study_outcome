package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes46.dex */
public class ResponseTypeAdapter extends AbsJsonDeserializer<Response> {
    public ResponseTypeAdapter(Gson r100) {
        super(r100);
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        Response r103 = (Response) GsonProtectorUtils.fromJson(this.f83809a, r100, r101);
        if (r103.statusCode == 0) goto L5;
        r103.error = (RequestError) GsonProtectorUtils.fromJson(this.f83809a, r100.getAsJsonObject().get("data"), RequestError.class);
    L5:
        return r103;
    }
}
