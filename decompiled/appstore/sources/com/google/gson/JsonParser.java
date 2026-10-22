package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement parseReader(Reader r10) throws JsonIOException, JsonSyntaxException {
        JsonReader r11 = new JsonReader(r10);     // Catch: NumberFormatException -> L9 IOException -> L11 MalformedJsonException -> L13
        JsonElement r12 = parseReader(r11);     // Catch: NumberFormatException -> L9 IOException -> L11 MalformedJsonException -> L13
        if (r12.isJsonNull() == false) goto L5;
    L15:
        return r12;
    L5:
        if (r11.peek() == JsonToken.END_DOCUMENT) goto L15;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L9 IOException -> L11 MalformedJsonException -> L13
    L13:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L11:
        e = move-exception;
        throw new JsonIOException(e);
    L9:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static JsonElement parseString(String r10) throws JsonSyntaxException {
        return parseReader(new StringReader(r10));
    }

    @Deprecated
    public JsonElement parse(String r10) throws JsonSyntaxException {
        return parseString(r10);
    }

    @Deprecated
    public JsonElement parse(Reader r10) throws JsonIOException, JsonSyntaxException {
        return parseReader(r10);
    }

    @Deprecated
    public JsonElement parse(JsonReader r10) throws JsonIOException, JsonSyntaxException {
        return parseReader(r10);
    }

    public static JsonElement parseReader(JsonReader r10) throws JsonIOException, JsonSyntaxException {
        boolean r11 = r10.isLenient();
        r10.setLenient(true);
        JsonElement r12 = Streams.parse(r10);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r10.setLenient(r11);
        return r12;
    L6:
        th = move-exception;
        r10.setLenient(r11);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r10 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r10 + " to Json", e);     // Catch: Throwable -> L6
    }
}
