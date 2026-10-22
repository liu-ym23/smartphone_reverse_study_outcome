package com.obric.capabilitykit.corecommon;

import androidx.annotation.Keep;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/corecommon/JsonParserExt;", "", "()V", "parseReader", "Lcom/google/gson/JsonElement;", "reader", "Lcom/google/gson/stream/JsonReader;", "Ljava/io/Reader;", "parseString", "json", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JsonParserExt {

    @NotNull
    public static final JsonParserExt INSTANCE = null;

    static {
        INSTANCE = new JsonParserExt();
    }

    private JsonParserExt() {
    }

    @NotNull
    public final JsonElement parseReader(@NotNull JsonReader r10) {
        q.g(r10, "reader");
        boolean r11 = r10.isLenient();
        r10.setLenient(true);
        JsonElement r12 = Streams.parse(r10);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L10
        q.f(r12, "{\n            Streams.parse(reader)\n        }");     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L10
        r10.setLenient(r11);
        return r12;
    L6:
        th = move-exception;
        r10.setLenient(r11);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r10 + " to Json", e);     // Catch: Throwable -> L6
    L10:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r10 + " to Json", e);     // Catch: Throwable -> L6
    }

    @NotNull
    public final JsonElement parseString(@Nullable String r10) {
        return parseReader(new StringReader(r10));
    }

    @NotNull
    public final JsonElement parseReader(@NotNull Reader r10) {
        q.g(r10, "reader");
        JsonReader r11 = new JsonReader(r10);     // Catch: NumberFormatException -> L10 IOException -> L12 MalformedJsonException -> L14
        JsonElement r12 = parseReader(r11);     // Catch: NumberFormatException -> L10 IOException -> L12 MalformedJsonException -> L14
        if (r12.isJsonNull() == false) goto L6;
    L16:
        return r12;
    L6:
        if (r11.peek() == JsonToken.END_DOCUMENT) goto L16;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L10 IOException -> L12 MalformedJsonException -> L14
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L12:
        e = move-exception;
        throw new JsonIOException(e);
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }
}
