package com.bytedance.android.anniex.solutions.card.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes43.dex */
public class DataTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Object> f41339a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41340a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f41340a = r100;
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f41340a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f41340a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f41340a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f41340a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f41340a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public DataTypeAdapter() {
        this.f41339a = new Gson().getAdapter(Object.class);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) throws IOException {
        switch(a.f41340a[r100.peek().ordinal()]) {
            case 1: goto L31;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r100.nextNull();
        return null;
    L10:
        double r101 = r100.nextDouble();
        if (r101 > 9.223372036854776E18d) goto L13;
        long r102 = (long) r101;
        if (r101 != r102) goto L22;
        return Integer.valueOf((int) r102);
    L20:
        return Long.valueOf(r102);
    L22:
        return Double.valueOf(r101);
    L13:
        return Double.valueOf(r101);
    L25:
        LinkedTreeMap r103 = new LinkedTreeMap();
        r100.beginObject();
    L27:
        if (r100.hasNext() == false) goto L29;
        r103.put(r100.nextName(), read(r100));
        goto L27
    L29:
        r100.endObject();
        return r103;
    L31:
        ArrayList r104 = new ArrayList();
        r100.beginArray();
    L33:
        if (r100.hasNext() == false) goto L35;
        r104.add(read(r100));
        goto L33
    L35:
        r100.endArray();
        return r104;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r100.nextBoolean());
    L24:
        return r100.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) throws IOException {
        this.f41339a.write(r100, r101);
    }
}
