package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String r10) {
        this(new StringReader(r10));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Object r10 = this.lock;
        monitor-enter(r10);
        if (this.parser.peek() == JsonToken.END_DOCUMENT) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L10
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ JsonElement next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader r10) {
        JsonReader r11 = new JsonReader(r10);
        this.parser = r11;
        r11.setLenient(true);
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext() == false) goto L21;
        return Streams.parse(this.parser);
    L6:
        e = move-exception;
        if ((e.getCause() instanceof EOFException) == true) goto L15;
        throw e;
    L15:
        throw new NoSuchElementException();
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L10:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L21:
        throw new NoSuchElementException();
    }
}
