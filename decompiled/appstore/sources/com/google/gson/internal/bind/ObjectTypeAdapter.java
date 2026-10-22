package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = null;
    private final Gson gson;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r10 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r10;
            r10[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        FACTORY = new AnonymousClass1();
    }

    public ObjectTypeAdapter(Gson r10) {
        this.gson = r10;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r10) throws IOException {
        JsonToken r11 = r10.peek();
        switch(AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r11.ordinal()]) {
            case 1: goto L20;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r10.nextNull();
        return null;
    L14:
        LinkedTreeMap r12 = new LinkedTreeMap();
        r10.beginObject();
    L16:
        if (r10.hasNext() == false) goto L18;
        r12.put(r10.nextName(), read(r10));
        goto L16
    L18:
        r10.endObject();
        return r12;
    L20:
        ArrayList r13 = new ArrayList();
        r10.beginArray();
    L22:
        if (r10.hasNext() == false) goto L24;
        r13.add(read(r10));
        goto L22
    L24:
        r10.endArray();
        return r13;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r10.nextBoolean());
    L11:
        return Double.valueOf(r10.nextDouble());
    L13:
        return r10.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r10, Object r11) throws IOException {
        if (r11 != null) goto L5;
        r10.nullValue();
        return;
    L5:
        TypeAdapter r12 = this.gson.getAdapter(r11.getClass());
        if ((r12 instanceof ObjectTypeAdapter) == false) goto L9;
        r10.beginObject();
        r10.endObject();
        return;
    L9:
        r12.write(r10, r11);
    }
}
