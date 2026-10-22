package com.bytedance.android.live.browser.jsbridge;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/JsIntTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JsIntTypeAdapter extends TypeAdapter<Integer> {
    public JsIntTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Integer read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        JsonToken r101 = r100.peek();
        if (r101 == null) goto L12;
        int r102 = o.f63756a[r101.ordinal()];
        if (r102 == 1) goto L10;
        if (r102 != 2) goto L12;
        r100.nextNull();
        return null;
    L10:
        return Integer.valueOf(r100.nextInt());
    L12:
        throw new JsonParseException("Expected NUMBER but was " + r101);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Integer r101) {
        Integer r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r102 != null) goto L6;
        r100.nullValue();
        return;
    L6:
        if (r102.intValue() != 0) goto L8;
        r100.value(r102);
        return;
    L8:
        r100.value(String.valueOf(r102.intValue()));
    }
}
