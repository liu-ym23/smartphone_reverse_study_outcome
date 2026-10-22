package com.bytedance.android.ad.sdk.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import u6.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ad/sdk/utils/JsonToStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final class JsonToStringAdapter extends TypeAdapter<String> {
    public JsonToStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final String read(JsonReader r100) {
        JsonToken r101 = r100.peek();
        if (r101 == null) goto L9;
        int r102 = a.f548914a[r101.ordinal()];
        if (r102 != 1) goto L8;
        r100.nextNull();
    L14:
        return null;
    L8:
        if (r102 != 2) goto L9;
        return r100.nextString();
    L9:
        JsonElement r103 = Streams.parse(r100);
        if (r103 == null) goto L14;
        return r103.toString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, String r101) {
        String r102 = r101;
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        JsonElement r103 = GsonProtectorUtils.parse(new JsonParser(), r102);
        TypeAdapters.JSON_ELEMENT.write(r100, r103);
    }
}
