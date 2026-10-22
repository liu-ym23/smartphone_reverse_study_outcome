package com.obric.capabilitykit.corecommon;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.obric.oui.material.MaterialConfigBuilder;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/corecommon/JsonParserExt;", "", "()V", "parseReader", "Lcom/google/gson/JsonElement;", "reader", "Lcom/google/gson/stream/JsonReader;", "Ljava/io/Reader;", "parseString", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JsonParserExt {
    public static final JsonParserExt INSTANCE = null;

    static {
        INSTANCE = new JsonParserExt();
    }

    private JsonParserExt() {
    }

    public final JsonElement parseReader(JsonReader r6) {
        Intrinsics.checkNotNullParameter(r6, "reader");
        boolean r1 = r6.isLenient();
        r6.setLenient(true);
        JsonElement r2 = Streams.parse(r6);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            Streams.parse(reader)\n        }");     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
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
        Intrinsics.checkNotNullParameter(r2, "reader");
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
