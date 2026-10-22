package com.bytedance.android.monitorV2.util;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/util/JsonToStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class JsonToStringAdapter extends TypeAdapter<String> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f163228a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f163228a = r100;
        }
    }

    public JsonToStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final String read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "readIn");
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        r100.nextNull();
    L15:
        return null;
    L9:
        if (r102 == 2) goto L18;
        JsonElement r103 = Streams.parse(r100);
        if (r103 == null) goto L15;
        return r103.toString();
    L18:
        return r100.nextString();
    L5:
        r102 = a.f163228a[r101.ordinal()];
        goto L7
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, String r101) {
        String r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        JsonElement r103 = GsonProtectorUtils.parse(new JsonParser(), r102);
        TypeAdapters.JSON_ELEMENT.write(r100, r103);
    }
}
