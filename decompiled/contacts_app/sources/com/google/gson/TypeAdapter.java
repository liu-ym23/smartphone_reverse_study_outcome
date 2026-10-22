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

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeAdapter<T> {
    public abstract T read(JsonReader r1) throws IOException;

    public abstract void write(JsonWriter r1, T r2) throws IOException;

    public TypeAdapter() {
    }

    public final void toJson(Writer r2, T r3) throws IOException {
        write(new JsonWriter(r2), r3);
    }

    public final String toJson(T r2) {
        StringWriter r0 = new StringWriter();
        toJson(r0, r2);     // Catch: IOException -> L6
        return r0.toString();
    L6:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final JsonElement toJsonTree(T r2) {
        JsonTreeWriter r0 = new JsonTreeWriter();     // Catch: IOException -> L4
        write(r0, r2);     // Catch: IOException -> L4
        return r0.get();
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final T fromJson(Reader r2) throws IOException {
        return read(new JsonReader(r2));
    }

    public final T fromJson(String r2) throws IOException {
        return fromJson(new StringReader(r2));
    }

    public final T fromJsonTree(JsonElement r2) {
        return read(new JsonTreeReader(r2));
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final TypeAdapter<T> nullSafe() {
        return new AnonymousClass1(this);
    }
}
