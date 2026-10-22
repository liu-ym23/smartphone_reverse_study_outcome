package com.bytedance.android.live.browser.jsbridge;

import androidx.camera.video.AudioStats;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/JsDoubleTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JsDoubleTypeAdapter extends TypeAdapter<Double> {
    public JsDoubleTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Double read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        JsonToken r101 = r100.peek();
        if (r101 == null) goto L12;
        int r102 = m.f63224a[r101.ordinal()];
        if (r102 == 1) goto L10;
        if (r102 != 2) goto L12;
        r100.nextNull();
        return null;
    L10:
        return Double.valueOf(r100.nextDouble());
    L12:
        throw new JsonParseException("Expected NUMBER but was " + r101);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Double r101) {
        Double r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r102 != null) goto L6;
        r100.nullValue();
        return;
    L6:
        if (Intrinsics.areEqual(r102, AudioStats.AUDIO_AMPLITUDE_NONE) == false) goto L8;
        r100.value(r102.doubleValue());
        return;
    L8:
        r100.value(String.valueOf(r102.doubleValue()));
    }
}
