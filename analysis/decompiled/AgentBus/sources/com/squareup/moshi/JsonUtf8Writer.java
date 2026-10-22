package com.squareup.moshi;

import java.io.IOException;
import javax.annotation.Nullable;
import ob.b;
import ob.h;
import ob.i;
import ob.i0;
import ob.m0;

/* loaded from: classes.dex */
final class JsonUtf8Writer extends JsonWriter {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private String separator = ":";
    private final i sink;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            REPLACEMENT_CHARS[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public JsonUtf8Writer(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = iVar;
        pushScope(6);
    }

    private void beforeName() {
        int iPeekScope = peekScope();
        if (iPeekScope == 5) {
            this.sink.writeByte(44);
        } else if (iPeekScope != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() {
        int iPeekScope = peekScope();
        int i2 = 2;
        if (iPeekScope == 1) {
            newline();
        } else if (iPeekScope == 2) {
            this.sink.writeByte(44);
            newline();
        } else if (iPeekScope == 4) {
            this.sink.M(this.separator);
            i2 = 5;
        } else {
            if (iPeekScope == 9) {
                throw new IllegalStateException("Sink from valueSink() was not closed");
            }
            i2 = 7;
            if (iPeekScope != 6) {
                if (iPeekScope != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
        }
        replaceTop(i2);
    }

    private JsonWriter close(int i2, int i10, char c10) {
        int iPeekScope = peekScope();
        if (iPeekScope != i10 && iPeekScope != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        int i11 = this.stackSize;
        int i12 = ~this.flattenStackSize;
        if (i11 == i12) {
            this.flattenStackSize = i12;
            return this;
        }
        int i13 = i11 - 1;
        this.stackSize = i13;
        this.pathNames[i13] = null;
        int[] iArr = this.pathIndices;
        int i14 = i11 - 2;
        iArr[i14] = iArr[i14] + 1;
        if (iPeekScope == i10) {
            newline();
        }
        this.sink.writeByte(c10);
        return this;
    }

    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.sink.writeByte(10);
        int i2 = this.stackSize;
        for (int i10 = 1; i10 < i2; i10++) {
            this.sink.M(this.indent);
        }
    }

    private JsonWriter open(int i2, int i10, char c10) {
        int i11;
        int i12 = this.stackSize;
        int i13 = this.flattenStackSize;
        if (i12 == i13 && ((i11 = this.scopes[i12 - 1]) == i2 || i11 == i10)) {
            this.flattenStackSize = ~i13;
            return this;
        }
        beforeValue();
        checkStack();
        pushScope(i2);
        this.pathIndices[this.stackSize - 1] = 0;
        this.sink.writeByte(c10);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void string(ob.i r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.squareup.moshi.JsonUtf8Writer.REPLACEMENT_CHARS
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.f(r8, r4, r3)
        L2e:
            r7.M(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.f(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Writer.string(ob.i, java.lang.String):void");
    }

    private void writeDeferredName() {
        if (this.deferredName != null) {
            beforeName();
            string(this.sink, this.deferredName);
            this.deferredName = null;
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginArray() {
        if (!this.promoteValueToName) {
            writeDeferredName();
            return open(1, 2, '[');
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginObject() {
        if (!this.promoteValueToName) {
            writeDeferredName();
            return open(3, 5, '{');
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endArray() {
        return close(1, 2, ']');
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endObject() {
        this.promoteValueToName = false;
        return close(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.sink.flush();
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter name(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        int iPeekScope = peekScope();
        if ((iPeekScope != 3 && iPeekScope != 5) || this.deferredName != null || this.promoteValueToName) {
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
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue();
        this.sink.M("null");
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public void setIndent(String str) {
        super.setIndent(str);
        this.separator = !str.isEmpty() ? ": " : ":";
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(str);
        }
        writeDeferredName();
        beforeValue();
        string(this.sink, str);
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
        writeDeferredName();
        beforeValue();
        pushScope(9);
        return b.b(new i0() { // from class: com.squareup.moshi.JsonUtf8Writer.1
            @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (JsonUtf8Writer.this.peekScope() != 9) {
                    throw new AssertionError();
                }
                JsonUtf8Writer jsonUtf8Writer = JsonUtf8Writer.this;
                int i2 = jsonUtf8Writer.stackSize;
                jsonUtf8Writer.stackSize = i2 - 1;
                int[] iArr = jsonUtf8Writer.pathIndices;
                int i10 = i2 - 2;
                iArr[i10] = iArr[i10] + 1;
            }

            @Override // ob.i0, java.io.Flushable
            public void flush() {
                JsonUtf8Writer.this.sink.flush();
            }

            @Override // ob.i0
            public m0 timeout() {
                return m0.f8007d;
            }

            @Override // ob.i0
            public void write(h hVar, long j2) {
                JsonUtf8Writer.this.sink.write(hVar, j2);
            }
        });
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(boolean z4) {
        if (!this.promoteValueToName) {
            writeDeferredName();
            beforeValue();
            this.sink.M(z4 ? "true" : "false");
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sink.close();
        int i2 = this.stackSize;
        if (i2 <= 1 && (i2 != 1 || this.scopes[i2 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        return value(bool.booleanValue());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(double d6) {
        if (!this.lenient && (Double.isNaN(d6) || Double.isInfinite(d6))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d6);
        }
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Double.toString(d6));
        }
        writeDeferredName();
        beforeValue();
        this.sink.M(Double.toString(d6));
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
        writeDeferredName();
        beforeValue();
        this.sink.M(Long.toString(j2));
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(@Nullable Number number) {
        if (number == null) {
            return nullValue();
        }
        String string = number.toString();
        if (!this.lenient && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(string);
        }
        writeDeferredName();
        beforeValue();
        this.sink.M(string);
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }
}
