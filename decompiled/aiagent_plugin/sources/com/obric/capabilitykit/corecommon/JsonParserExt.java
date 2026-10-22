package com.obric.capabilitykit.corecommon;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import d.h.b.o;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonParserExt {
    public static final JsonParserExt INSTANCE = null;

    static {
        INSTANCE = new JsonParserExt();
    }

    private JsonParserExt() {
    }

    public final JsonElement parseReader(JsonReader r6) {
        o.e(r6, "reader");
        boolean r1 = r6.isLenient();
        r6.setLenient(true);
        JsonElement r2 = Streams.parse(r6);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        o.c(r2, "{\n            Streams.parse(reader)\n        }");     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r6.setLenient(r1);
        return r2;
    L6:
        th = move-exception;
        r6.setLenient(r1);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    }

    public final JsonElement parseReader(Reader r2) {
        o.e(r2, "reader");
        JsonReader r0 = new JsonReader(r2);     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
        JsonElement r1 = parseReader(r0);     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
        if (r1.isJsonNull() == false) goto L6;
    L10:
        return r1;
    L6:
        if (r0.peek() == JsonToken.END_DOCUMENT) goto L10;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
    L17:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L14:
        e = move-exception;
        throw new JsonIOException(e);
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public final JsonElement parseString(String r2) {
        return parseReader(new StringReader(r2));
    }
}
