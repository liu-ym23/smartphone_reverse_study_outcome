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
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeWriter extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED = null;
    private static final Writer UNWRITABLE_WRITER = null;
    private String pendingName;
    private JsonElement product;
    private final List<JsonElement> stack;

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    static {
        UNWRITABLE_WRITER = new AnonymousClass1();
        SENTINEL_CLOSED = new JsonPrimitive("closed");
    }

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }

    public JsonElement get() {
        if (this.stack.isEmpty() == false) goto L7;
        return this.product;
    L7:
        throw new IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    private JsonElement peek() {
        List<JsonElement> r1 = this.stack;
        return r1.get(r1.size() - 1);
    }

    private void put(JsonElement r3) {
        if (this.pendingName == null) goto L11;
        if (r3.isJsonNull() == true) goto L7;
    L8:
        ((JsonObject) peek()).add(this.pendingName, r3);
    L9:
        this.pendingName = null;
        return;
    L7:
        if (getSerializeNulls() == false) goto L9;
    L11:
        if (this.stack.isEmpty() == false) goto L13;
        this.product = r3;
        return;
    L13:
        JsonElement r2 = peek();
        if ((r2 instanceof JsonArray) == false) goto L18;
        ((JsonArray) r2).add(r3);
        return;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray r0 = new JsonArray();
        put(r0);
        this.stack.add(r0);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonArray) == false) goto L11;
        List<JsonElement> r0 = this.stack;
        r0.remove(r0.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject r0 = new JsonObject();
        put(r0);
        this.stack.add(r0);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonObject) == false) goto L11;
        List<JsonElement> r0 = this.stack;
        r0.remove(r0.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String r2) throws IOException {
        Objects.requireNonNull(r2, "name == null");
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonObject) == false) goto L11;
        this.pendingName = r2;
        return this;
    L11:
        throw new IllegalStateException("Please begin an object before writing a name.");
    L13:
        throw new IllegalStateException("Did not expect a name");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String r2) throws IOException {
        if (r2 == null) goto L4;
        put(new JsonPrimitive(r2));
        return this;
    L4:
        return nullValue();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean r2) throws IOException {
        put(new JsonPrimitive(Boolean.valueOf(r2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean r2) throws IOException {
        if (r2 == null) goto L4;
        put(new JsonPrimitive(r2));
        return this;
    L4:
        return nullValue();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(float r3) throws IOException {
        if (isLenient() == false) goto L5;
    L11:
        put(new JsonPrimitive(Float.valueOf(r3)));
        return this;
    L5:
        if (Float.isNaN(r3) == true) goto L10;
        if (Float.isInfinite(r3) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r3);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double r3) throws IOException {
        if (isLenient() == false) goto L5;
    L11:
        put(new JsonPrimitive(Double.valueOf(r3)));
        return this;
    L5:
        if (Double.isNaN(r3) == true) goto L10;
        if (Double.isInfinite(r3) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r3);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long r2) throws IOException {
        put(new JsonPrimitive(Long.valueOf(r2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number r4) throws IOException {
        if (r4 != null) goto L6;
        return nullValue();
    L6:
        if (isLenient() == true) goto L14;
        double r0 = r4.doubleValue();
        if (Double.isNaN(r0) == true) goto L13;
        if (Double.isInfinite(r0) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r4);
    L14:
        put(new JsonPrimitive(r4));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter jsonValue(String r1) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.stack.isEmpty() == false) goto L7;
        this.stack.add(SENTINEL_CLOSED);
        return;
    L7:
        throw new IOException("Incomplete document");
    }
}
