package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = null;
    private static final Reader UNREADABLE_READER = null;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            r0[JsonToken.NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        UNREADABLE_READER = new AnonymousClass1();
        SENTINEL_CLOSED = new Object();
    }

    public JsonTreeReader(JsonElement r3) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(r3);
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) ZeusTransformUtils.preCheckCast(peekStack(), JsonArray.class, "com.obric.aiagent.plugin")).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int r0 = this.stackSize;
        if (r0 <= 0) goto L6;
        int[] r2 = this.pathIndices;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) ZeusTransformUtils.preCheckCast(peekStack(), JsonObject.class, "com.obric.aiagent.plugin")).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        expect(JsonToken.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int r0 = this.stackSize;
        if (r0 <= 0) goto L6;
        int[] r3 = this.pathIndices;
        int r1 = r0 - 1;
        r3[r1] = r3[r1] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken r1 = peek();
        if (r1 != JsonToken.END_OBJECT) goto L5;
    L9:
        return false;
    L5:
        if (r1 == JsonToken.END_ARRAY) goto L9;
        if (r1 == JsonToken.END_DOCUMENT) goto L9;
        return true;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.stackSize == 0) goto L5;
        Object r0 = peekStack();
        if (ZeusTransformUtils.instanceOf(r0, Iterator.class) == false) goto L20;
        boolean r1 = ZeusTransformUtils.instanceOf(this.stack[this.stackSize - 2], JsonObject.class);
        Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(r0, Iterator.class, "com.obric.aiagent.plugin");
        if (r2.hasNext() == false) goto L15;
        if (r1 == true) goto L12;
        push(r2.next());
        return peek();
    L12:
        return JsonToken.NAME;
    L15:
        if (r1 == false) goto L18;
        return JsonToken.END_OBJECT;
    L18:
        return JsonToken.END_ARRAY;
    L20:
        if (ZeusTransformUtils.instanceOf(r0, JsonObject.class) == false) goto L24;
        return JsonToken.BEGIN_OBJECT;
    L24:
        if (ZeusTransformUtils.instanceOf(r0, JsonArray.class) == false) goto L28;
        return JsonToken.BEGIN_ARRAY;
    L28:
        if (ZeusTransformUtils.instanceOf(r0, JsonPrimitive.class) == false) goto L44;
        JsonPrimitive r4 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r0, JsonPrimitive.class, "com.obric.aiagent.plugin");
        if (r4.isString() == false) goto L34;
        return JsonToken.STRING;
    L34:
        if (r4.isBoolean() == false) goto L38;
        return JsonToken.BOOLEAN;
    L38:
        if (r4.isNumber() == false) goto L42;
        return JsonToken.NUMBER;
    L42:
        throw new AssertionError();
    L44:
        if (ZeusTransformUtils.instanceOf(r0, JsonNull.class) == false) goto L48;
        return JsonToken.NULL;
    L48:
        if (r0 != SENTINEL_CLOSED) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new MalformedJsonException("Custom JsonElement subclass " + r0.getClass().getName() + " is not supported");
    L5:
        return JsonToken.END_DOCUMENT;
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] r0 = this.stack;
        int r1 = this.stackSize - 1;
        this.stackSize = r1;
        Object r3 = r0[r1];
        r0[r1] = null;
        return r3;
    }

    private void expect(JsonToken r4) {
        if (peek() != r4) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r4 + " but was " + peek() + locationString());
    }

    private String nextName(boolean r5) {
        expect(JsonToken.NAME);
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(((Iterator) ZeusTransformUtils.preCheckCast(peekStack(), Iterator.class, "com.obric.aiagent.plugin")).next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        String[] r2 = this.pathNames;
        int r3 = this.stackSize - 1;
        if (r5 == false) goto L5;
        String r6 = "<skipped>";
    L6:
        r2[r3] = r6;
        push(r0.getValue());
        return r1;
    L5:
        r6 = r1;
        goto L6
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        return nextName(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken r0 = peek();
        if (r0 != JsonToken.STRING) goto L5;
    L9:
        String r1 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(popStack(), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsString();
        int r2 = this.stackSize;
        if (r2 <= 0) goto L12;
        int[] r4 = this.pathIndices;
        int r3 = r2 - 1;
        r4[r3] = r4[r3] + 1;
    L12:
        return r1;
    L5:
        if (r0 == JsonToken.NUMBER) goto L9;
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + r0 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        expect(JsonToken.BOOLEAN);
        boolean r0 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(popStack(), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsBoolean();
        int r1 = this.stackSize;
        if (r1 <= 0) goto L5;
        int[] r3 = this.pathIndices;
        int r2 = r1 - 1;
        r3[r2] = r3[r2] + 1;
    L5:
        return r0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        expect(JsonToken.NULL);
        popStack();
        int r0 = this.stackSize;
        if (r0 <= 0) goto L6;
        int[] r2 = this.pathIndices;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken r0 = peek();
        if (r0 != JsonToken.NUMBER) goto L5;
    L9:
        double r1 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(peekStack(), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsDouble();
        if (isLenient() == false) goto L12;
    L18:
        popStack();
        int r2 = this.stackSize;
        if (r2 <= 0) goto L21;
        int[] r4 = this.pathIndices;
        int r3 = r2 - 1;
        r4[r3] = r4[r3] + 1;
    L21:
        return r1;
    L12:
        if (Double.isNaN(r1) == true) goto L17;
        if (Double.isInfinite(r1) == false) goto L18;
    L17:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r1);
    L5:
        if (r0 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + r0 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken r0 = peek();
        if (r0 != JsonToken.NUMBER) goto L5;
    L9:
        long r1 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(peekStack(), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsLong();
        popStack();
        int r2 = this.stackSize;
        if (r2 <= 0) goto L12;
        int[] r4 = this.pathIndices;
        int r3 = r2 - 1;
        r4[r3] = r4[r3] + 1;
    L12:
        return r1;
    L5:
        if (r0 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + r0 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken r0 = peek();
        if (r0 != JsonToken.NUMBER) goto L5;
    L9:
        int r1 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(peekStack(), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsInt();
        popStack();
        int r2 = this.stackSize;
        if (r2 <= 0) goto L12;
        int[] r4 = this.pathIndices;
        int r3 = r2 - 1;
        r4[r3] = r4[r3] + 1;
    L12:
        return r1;
    L5:
        if (r0 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + r0 + locationString());
    }

    JsonElement nextJsonElement() {
        JsonToken r0 = peek();
        if (r0 == JsonToken.NAME) goto L13;
        if (r0 == JsonToken.END_ARRAY) goto L13;
        if (r0 == JsonToken.END_OBJECT) goto L13;
        if (r0 == JsonToken.END_DOCUMENT) goto L13;
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(peekStack(), JsonElement.class, "com.obric.aiagent.plugin");
        skipValue();
        return r1;
    L13:
        throw new IllegalStateException("Unexpected " + r0 + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        JsonToken r0 = peek();
        int r1 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r0.ordinal()];
        if (r1 != 1) goto L5;
        nextName(true);
        return;
    L5:
        if (r1 != 2) goto L7;
        endArray();
        return;
    L7:
        if (r1 != 3) goto L9;
        endObject();
        return;
    L9:
        if (r1 == 4) goto L17;
        popStack();
        int r2 = this.stackSize;
        if (r2 <= 0) goto L18;
        int[] r3 = this.pathIndices;
        int r4 = r2 - 1;
        r3[r4] = r3[r4] + 1;
        return;
    L18:
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public void promoteNameToValue() {
        expect(JsonToken.NAME);
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(((Iterator) ZeusTransformUtils.preCheckCast(peekStack(), Iterator.class, "com.obric.aiagent.plugin")).next(), Map.Entry.class, "com.obric.aiagent.plugin");
        push(r0.getValue());
        push(new JsonPrimitive((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin")));
    }

    private void push(Object r4) {
        int r0 = this.stackSize;
        Object[] r1 = this.stack;
        if (r0 != r1.length) goto L5;
        int r2 = r0 * 2;
        this.stack = Arrays.copyOf(r1, r2);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r2);
        this.pathNames = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.pathNames, r2), String[].class, "com.obric.aiagent.plugin");
    L5:
        Object[] r3 = this.stack;
        int r5 = this.stackSize;
        this.stackSize = r5 + 1;
        r3[r5] = r4;
    }

    private String getPath(boolean r6) {
        StringBuilder r0 = new StringBuilder().append('$');
        int r1 = 0;
    L4:
        if (r1 >= this.stackSize) goto L31;
        if (ZeusTransformUtils.instanceOf(this.stack[r1], JsonArray.class) == false) goto L21;
        r1 = r1 + 1;
        if (r1 >= this.stackSize) goto L29;
        if (ZeusTransformUtils.instanceOf(this.stack[r1], Iterator.class) == false) goto L29;
        int r2 = this.pathIndices[r1];
        if (r6 == false) goto L19;
        if (r2 <= 0) goto L19;
        int r3 = this.stackSize;
        if (r1 != (r3 - 1)) goto L17;
    L18:
        r2 = r2 - 1;
        goto L19
    L17:
        if (r1 == (r3 - 2)) goto L18;
    L19:
        r0.append('[').append(r2).append(']');
    L29:
        r1 = r1 + 1;
        goto L4
    L21:
        if (ZeusTransformUtils.instanceOf(this.stack[r1], JsonObject.class) == false) goto L29;
        r1 = r1 + 1;
        if (r1 >= this.stackSize) goto L29;
        if (ZeusTransformUtils.instanceOf(this.stack[r1], Iterator.class) == false) goto L29;
        r0.append('.');
        String[] r4 = this.pathNames;
        if (r4[r1] == null) goto L29;
        r0.append(r4[r1]);
        goto L29
    L31:
        return r0.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }

    private String locationString() {
        return " at path " + getPath();
    }
}
