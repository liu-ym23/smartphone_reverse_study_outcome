package com.bytedance.android.shopping.anchorv3.utils;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public class BooleanTypeAdapter extends TypeAdapter<Boolean> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f165295a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f165295a = r100;
            r100[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f165295a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f165295a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public BooleanTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Boolean read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        int r102 = a.f165295a[r101.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L17;
        if (r102 != 2) goto L7;
        r100.nextNull();
        return null;
    L7:
        if (r102 != 3) goto L14;
        if (r100.nextInt() != 0) goto L18;
        r103 = false;
    L18:
        return Boolean.valueOf(r103);
    L14:
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r101);
    L17:
        return Boolean.valueOf(r100.nextBoolean());
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Boolean r101) throws IOException {
        Boolean r102 = r101;
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(r102);
    }
}
