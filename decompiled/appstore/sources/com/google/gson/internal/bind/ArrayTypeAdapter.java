package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = null;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    public ArrayTypeAdapter(Gson r10, TypeAdapter<E> r11, Class<E> r12) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r10, r11, r12);
        this.componentType = r12;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r10) throws IOException {
        if (r10.peek() != JsonToken.NULL) goto L6;
        r10.nextNull();
        return null;
    L6:
        ArrayList r11 = new ArrayList();
        r10.beginArray();
    L8:
        if (r10.hasNext() == false) goto L10;
        r11.add(this.componentTypeAdapter.read(r10));
        goto L8
    L10:
        r10.endArray();
        int r12 = r11.size();
        Object r13 = Array.newInstance(this.componentType, r12);
        int r14 = 0;
    L11:
        if (r14 >= r12) goto L13;
        Array.set(r13, r14, r11.get(r14));
        r14 = r14 + 1;
        goto L11
    L13:
        return r13;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r10, Object r11) throws IOException {
        if (r11 != null) goto L5;
        r10.nullValue();
        return;
    L5:
        r10.beginArray();
        int r12 = Array.getLength(r11);
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        Object r14 = Array.get(r11, r13);
        this.componentTypeAdapter.write(r10, (E) r14);
        r13 = r13 + 1;
        goto L6
    L8:
        r10.endArray();
    }
}
