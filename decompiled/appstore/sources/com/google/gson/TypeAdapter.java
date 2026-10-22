package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeAdapter<T> {
    public TypeAdapter() {
    }

    public final T fromJson(Reader r10) throws IOException {
        return read(new JsonReader(r10));
    }

    public final T fromJsonTree(JsonElement r10) {
        return read(new JsonTreeReader(r10));
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final TypeAdapter<T> nullSafe() {
        return new AnonymousClass1(this);
    }

    public abstract T read(JsonReader r10) throws IOException;

    public final void toJson(Writer r10, T r11) throws IOException {
        write(new JsonWriter(r10), r11);
    }

    public final JsonElement toJsonTree(T r10) {
        JsonTreeWriter r11 = new JsonTreeWriter();     // Catch: IOException -> L4
        write(r11, r10);     // Catch: IOException -> L4
        return r11.get();
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public abstract void write(JsonWriter r10, T r11) throws IOException;

    public final T fromJson(String r10) throws IOException {
        return fromJson(new StringReader(r10));
    }

    public final String toJson(T r10) {
        StringWriter r11 = new StringWriter();
        toJson(r11, r10);     // Catch: IOException -> L6
        return r11.toString();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }
}
