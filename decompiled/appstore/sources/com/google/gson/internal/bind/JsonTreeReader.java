package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = null;
    private static final Reader UNREADABLE_READER = null;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    static {
        UNREADABLE_READER = new AnonymousClass1();
        SENTINEL_CLOSED = new Object();
    }

    public JsonTreeReader(JsonElement r10) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(r10);
    }

    private void expect(JsonToken r10) throws IOException {
        if (peek() != r10) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r10 + " but was " + peek() + locationString());
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] r10 = this.stack;
        int r11 = this.stackSize - 1;
        this.stackSize = r11;
        Object r12 = r10[r11];
        r10[r11] = null;
        return r12;
    }

    private void push(Object r10) {
        int r11 = this.stackSize;
        Object[] r12 = this.stack;
        if (r11 != r12.length) goto L5;
        int r13 = r11 * 2;
        this.stack = Arrays.copyOf(r12, r13);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r13);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r13);
    L5:
        Object[] r14 = this.stack;
        int r15 = this.stackSize;
        this.stackSize = r15 + 1;
        r14[r15] = r10;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int r10 = this.stackSize;
        if (r10 <= 0) goto L6;
        int[] r11 = this.pathIndices;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        popStack();
        popStack();
        int r10 = this.stackSize;
        if (r10 <= 0) goto L6;
        int[] r11 = this.pathIndices;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder r10 = new StringBuilder();
        r10.append('$');
        int r11 = 0;
    L4:
        if (r11 >= this.stackSize) goto L19;
        Object[] r12 = this.stack;
        Object r13 = r12[r11];
        if ((r13 instanceof JsonArray) == false) goto L11;
        r11 = r11 + 1;
        if ((r12[r11] instanceof Iterator) == false) goto L17;
        r10.append('[');
        r10.append(this.pathIndices[r11]);
        r10.append(']');
    L17:
        r11 = r11 + 1;
        goto L4
    L11:
        if ((r13 instanceof JsonObject) == false) goto L17;
        r11 = r11 + 1;
        if ((r12[r11] instanceof Iterator) == false) goto L17;
        r10.append('.');
        String r14 = this.pathNames[r11];
        if (r14 == null) goto L17;
        r10.append(r14);
        goto L17
    L19:
        return r10.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken r10 = peek();
        if (r10 != JsonToken.END_OBJECT) goto L5;
    L7:
        return false;
    L5:
        if (r10 == JsonToken.END_ARRAY) goto L7;
        return true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        boolean r10 = ((JsonPrimitive) popStack()).getAsBoolean();
        int r11 = this.stackSize;
        if (r11 <= 0) goto L5;
        int[] r12 = this.pathIndices;
        int r13 = r11 - 1;
        r12[r13] = r12[r13] + 1;
    L5:
        return r10;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken r10 = peek();
        JsonToken r11 = JsonToken.NUMBER;
        if (r10 != r11) goto L5;
    L9:
        double r12 = ((JsonPrimitive) peekStack()).getAsDouble();
        if (isLenient() == false) goto L12;
    L18:
        popStack();
        int r13 = this.stackSize;
        if (r13 <= 0) goto L21;
        int[] r14 = this.pathIndices;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L21:
        return r12;
    L12:
        if (Double.isNaN(r12) == true) goto L17;
        if (Double.isInfinite(r12) == false) goto L18;
    L17:
        throw new NumberFormatException("JSON forbids NaN and infinities: " + r12);
    L5:
        if (r10 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken r10 = peek();
        JsonToken r11 = JsonToken.NUMBER;
        if (r10 != r11) goto L5;
    L9:
        int r12 = ((JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int r13 = this.stackSize;
        if (r13 <= 0) goto L12;
        int[] r14 = this.pathIndices;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L12:
        return r12;
    L5:
        if (r10 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken r10 = peek();
        JsonToken r11 = JsonToken.NUMBER;
        if (r10 != r11) goto L5;
    L9:
        long r12 = ((JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int r13 = this.stackSize;
        if (r13 <= 0) goto L12;
        int[] r14 = this.pathIndices;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L12:
        return r12;
    L5:
        if (r10 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry r10 = (Map.Entry) ((Iterator) peekStack()).next();
        String r11 = (String) r10.getKey();
        this.pathNames[this.stackSize - 1] = r11;
        push(r10.getValue());
        return r11;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
        int r10 = this.stackSize;
        if (r10 <= 0) goto L6;
        int[] r11 = this.pathIndices;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken r10 = peek();
        JsonToken r11 = JsonToken.STRING;
        if (r10 != r11) goto L5;
    L9:
        String r12 = ((JsonPrimitive) popStack()).getAsString();
        int r13 = this.stackSize;
        if (r13 <= 0) goto L12;
        int[] r14 = this.pathIndices;
        int r15 = r13 - 1;
        r14[r15] = r14[r15] + 1;
    L12:
        return r12;
    L5:
        if (r10 == JsonToken.NUMBER) goto L9;
        throw new IllegalStateException("Expected " + r11 + " but was " + r10 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) goto L5;
        Object r10 = peekStack();
        if ((r10 instanceof Iterator) == false) goto L20;
        boolean r11 = this.stack[this.stackSize - 2] instanceof JsonObject;
        Iterator r12 = (Iterator) r10;
        if (r12.hasNext() == false) goto L15;
        if (r11 == true) goto L12;
        push(r12.next());
        return peek();
    L12:
        return JsonToken.NAME;
    L15:
        if (r11 == false) goto L18;
        return JsonToken.END_OBJECT;
    L18:
        return JsonToken.END_ARRAY;
    L20:
        if ((r10 instanceof JsonObject) == false) goto L24;
        return JsonToken.BEGIN_OBJECT;
    L24:
        if ((r10 instanceof JsonArray) == false) goto L28;
        return JsonToken.BEGIN_ARRAY;
    L28:
        if ((r10 instanceof JsonPrimitive) == false) goto L44;
        JsonPrimitive r13 = (JsonPrimitive) r10;
        if (r13.isString() == false) goto L34;
        return JsonToken.STRING;
    L34:
        if (r13.isBoolean() == false) goto L38;
        return JsonToken.BOOLEAN;
    L38:
        if (r13.isNumber() == false) goto L42;
        return JsonToken.NUMBER;
    L42:
        throw new AssertionError();
    L44:
        if ((r10 instanceof JsonNull) == false) goto L48;
        return JsonToken.NULL;
    L48:
        if (r10 != SENTINEL_CLOSED) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new AssertionError();
    L5:
        return JsonToken.END_DOCUMENT;
    }

    public void promoteNameToValue() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry r10 = (Map.Entry) ((Iterator) peekStack()).next();
        push(r10.getValue());
        push(new JsonPrimitive((String) r10.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() != JsonToken.NAME) goto L5;
        nextName();
        this.pathNames[this.stackSize - 2] = "null";
    L8:
        int r10 = this.stackSize;
        if (r10 <= 0) goto L12;
        int[] r11 = this.pathIndices;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    L12:
        return;
    L5:
        popStack();
        int r13 = this.stackSize;
        if (r13 <= 0) goto L8;
        this.pathNames[r13 - 1] = "null";
        goto L8
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }
}
