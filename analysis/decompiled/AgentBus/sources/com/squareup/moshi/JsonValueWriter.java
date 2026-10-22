package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import ob.b;
import ob.h;
import ob.i;
import ob.p;

/* loaded from: classes.dex */
final class JsonValueWriter extends JsonWriter {

    @Nullable
    private String deferredName;
    Object[] stack = new Object[32];

    public JsonValueWriter() {
        pushScope(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JsonValueWriter add(@Nullable Object obj) {
        String str;
        Object objPut;
        int iPeekScope = peekScope();
        int i2 = this.stackSize;
        if (i2 == 1) {
            if (iPeekScope != 6) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            this.scopes[i2 - 1] = 7;
            this.stack[i2 - 1] = obj;
            return this;
        }
        if (iPeekScope != 3 || (str = this.deferredName) == null) {
            if (iPeekScope == 1) {
                ((List) this.stack[i2 - 1]).add(obj);
                return this;
            }
            if (iPeekScope == 9) {
                throw new IllegalStateException("Sink from valueSink() was not closed");
            }
            throw new IllegalStateException("Nesting problem.");
        }
        if ((obj == null && !this.serializeNulls) || (objPut = ((Map) this.stack[i2 - 1]).put(str, obj)) == null) {
            this.deferredName = null;
            return this;
        }
        throw new IllegalArgumentException("Map key '" + this.deferredName + "' has multiple values at path " + getPath() + ": " + objPut + " and " + obj);
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginArray() {
        if (this.promoteValueToName) {
            throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
        }
        int i2 = this.stackSize;
        int i10 = this.flattenStackSize;
        if (i2 == i10 && this.scopes[i2 - 1] == 1) {
            this.flattenStackSize = ~i10;
            return this;
        }
        checkStack();
        ArrayList arrayList = new ArrayList();
        add(arrayList);
        Object[] objArr = this.stack;
        int i11 = this.stackSize;
        objArr[i11] = arrayList;
        this.pathIndices[i11] = 0;
        pushScope(1);
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginObject() {
        if (this.promoteValueToName) {
            throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
        }
        int i2 = this.stackSize;
        int i10 = this.flattenStackSize;
        if (i2 == i10 && this.scopes[i2 - 1] == 3) {
            this.flattenStackSize = ~i10;
            return this;
        }
        checkStack();
        LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
        add(linkedHashTreeMap);
        this.stack[this.stackSize] = linkedHashTreeMap;
        pushScope(3);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i2 = this.stackSize;
        if (i2 > 1 || (i2 == 1 && this.scopes[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endArray() {
        if (peekScope() != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        int i2 = this.stackSize;
        int i10 = this.flattenStackSize;
        if (i2 == (~i10)) {
            this.flattenStackSize = ~i10;
            return this;
        }
        int i11 = i2 - 1;
        this.stackSize = i11;
        this.stack[i11] = null;
        int[] iArr = this.pathIndices;
        int i12 = i2 - 2;
        iArr[i12] = iArr[i12] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endObject() {
        if (peekScope() != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        int i2 = this.stackSize;
        int i10 = this.flattenStackSize;
        if (i2 == (~i10)) {
            this.flattenStackSize = ~i10;
            return this;
        }
        this.promoteValueToName = false;
        int i11 = i2 - 1;
        this.stackSize = i11;
        this.stack[i11] = null;
        this.pathNames[i11] = null;
        int[] iArr = this.pathIndices;
        int i12 = i2 - 2;
        iArr[i12] = iArr[i12] + 1;
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter name(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        if (peekScope() != 3 || this.deferredName != null || this.promoteValueToName) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.deferredName = str;
        this.pathNames[this.stackSize - 1] = str;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter nullValue() {
        if (this.promoteValueToName) {
            throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
        }
        add(null);
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    public Object root() {
        int i2 = this.stackSize;
        if (i2 > 1 || (i2 == 1 && this.scopes[i2 - 1] != 7)) {
            throw new IllegalStateException("Incomplete document");
        }
        return this.stack[0];
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(@Nullable String str) {
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(str);
        }
        add(str);
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public i valueSink() {
        if (this.promoteValueToName) {
            throw new IllegalStateException("BufferedSink cannot be used as a map key in JSON at path " + getPath());
        }
        if (peekScope() == 9) {
            throw new IllegalStateException("Sink from valueSink() was not closed");
        }
        pushScope(9);
        final h hVar = new h();
        return b.b(new p(hVar) { // from class: com.squareup.moshi.JsonValueWriter.1
            @Override // ob.p, ob.i0, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (JsonValueWriter.this.peekScope() == 9) {
                    JsonValueWriter jsonValueWriter = JsonValueWriter.this;
                    Object[] objArr = jsonValueWriter.stack;
                    int i2 = jsonValueWriter.stackSize;
                    if (objArr[i2] == null) {
                        jsonValueWriter.stackSize = i2 - 1;
                        Object jsonValue = JsonReader.of(hVar).readJsonValue();
                        JsonValueWriter jsonValueWriter2 = JsonValueWriter.this;
                        boolean z4 = jsonValueWriter2.serializeNulls;
                        jsonValueWriter2.serializeNulls = true;
                        try {
                            jsonValueWriter2.add(jsonValue);
                            JsonValueWriter jsonValueWriter3 = JsonValueWriter.this;
                            jsonValueWriter3.serializeNulls = z4;
                            int[] iArr = jsonValueWriter3.pathIndices;
                            int i10 = jsonValueWriter3.stackSize - 1;
                            iArr[i10] = iArr[i10] + 1;
                            return;
                        } catch (Throwable th) {
                            JsonValueWriter.this.serializeNulls = z4;
                            throw th;
                        }
                    }
                }
                throw new AssertionError();
            }
        });
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(boolean z4) {
        if (!this.promoteValueToName) {
            add(Boolean.valueOf(z4));
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(@Nullable Boolean bool) {
        if (!this.promoteValueToName) {
            add(bool);
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(double d6) {
        if (!this.lenient && (Double.isNaN(d6) || d6 == Double.NEGATIVE_INFINITY || d6 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d6);
        }
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Double.toString(d6));
        }
        add(Double.valueOf(d6));
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(long j2) {
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Long.toString(j2));
        }
        add(Long.valueOf(j2));
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(@Nullable Number number) {
        if (!(number instanceof Byte) && !(number instanceof Short) && !(number instanceof Integer) && !(number instanceof Long)) {
            if ((number instanceof Float) || (number instanceof Double)) {
                return value(number.doubleValue());
            }
            if (number == null) {
                return nullValue();
            }
            BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
            if (this.promoteValueToName) {
                this.promoteValueToName = false;
                return name(bigDecimal.toString());
            }
            add(bigDecimal);
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        return value(number.longValue());
    }
}
