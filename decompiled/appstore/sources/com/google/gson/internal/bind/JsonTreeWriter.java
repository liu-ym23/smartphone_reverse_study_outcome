package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonTreeWriter extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED = null;
    private static final Writer UNWRITABLE_WRITER = null;
    private String pendingName;
    private JsonElement product;
    private final List<JsonElement> stack;

    static {
        UNWRITABLE_WRITER = new AnonymousClass1();
        SENTINEL_CLOSED = new JsonPrimitive("closed");
    }

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        List<JsonElement> r10 = this.stack;
        return r10.get(r10.size() - 1);
    }

    private void put(JsonElement r10) {
        if (this.pendingName == null) goto L11;
        if (r10.isJsonNull() == true) goto L7;
    L8:
        ((JsonObject) peek()).add(this.pendingName, r10);
    L9:
        this.pendingName = null;
        return;
    L7:
        if (getSerializeNulls() == false) goto L9;
    L11:
        if (this.stack.isEmpty() == false) goto L13;
        this.product = r10;
        return;
    L13:
        JsonElement r11 = peek();
        if ((r11 instanceof JsonArray) == false) goto L18;
        ((JsonArray) r11).add(r10);
        return;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray r10 = new JsonArray();
        put(r10);
        this.stack.add(r10);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject r10 = new JsonObject();
        put(r10);
        this.stack.add(r10);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.stack.isEmpty() == false) goto L7;
        this.stack.add(SENTINEL_CLOSED);
        return;
    L7:
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonArray) == false) goto L11;
        List<JsonElement> r10 = this.stack;
        r10.remove(r10.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonObject) == false) goto L11;
        List<JsonElement> r10 = this.stack;
        r10.remove(r10.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    public JsonElement get() {
        if (this.stack.isEmpty() == false) goto L7;
        return this.product;
    L7:
        throw new IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String r10) throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonObject) == false) goto L11;
        this.pendingName = r10;
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String r10) throws IOException {
        if (r10 == null) goto L4;
        put(new JsonPrimitive(r10));
        return this;
    L4:
        return nullValue();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean r10) throws IOException {
        put(new JsonPrimitive(Boolean.valueOf(r10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean r10) throws IOException {
        if (r10 == null) goto L4;
        put(new JsonPrimitive(r10));
        return this;
    L4:
        return nullValue();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double r10) throws IOException {
        if (isLenient() == false) goto L5;
    L11:
        put(new JsonPrimitive(Double.valueOf(r10)));
        return this;
    L5:
        if (Double.isNaN(r10) == true) goto L10;
        if (Double.isInfinite(r10) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r10);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long r10) throws IOException {
        put(new JsonPrimitive(Long.valueOf(r10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number r10) throws IOException {
        if (r10 != null) goto L6;
        return nullValue();
    L6:
        if (isLenient() == true) goto L14;
        double r11 = r10.doubleValue();
        if (Double.isNaN(r11) == true) goto L13;
        if (Double.isInfinite(r11) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r10);
    L14:
        put(new JsonPrimitive(r10));
        return this;
    }
}
