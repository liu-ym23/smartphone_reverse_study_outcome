package com.bytedance.android.ec.model.response.anchorv3;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/JsonToStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class JsonToStringAdapter extends TypeAdapter<String> {
    public JsonToStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final String read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "in");
        JsonElement r101 = Streams.parse(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        JsonParser r102 = new JsonParser();
        JsonElement r103 = GsonProtectorUtils.parse(r102, r101);
        TypeAdapters.JSON_ELEMENT.write(r100, r103);
    }
}
