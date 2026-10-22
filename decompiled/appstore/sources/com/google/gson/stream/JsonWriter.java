package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = null;
    private static final String[] REPLACEMENT_CHARS = null;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack;
    private int stackSize;

    static {
        REPLACEMENT_CHARS = new String[128];
        int r10 = 0;
    L4:
        if (r10 > 31) goto L6;
        REPLACEMENT_CHARS[r10] = String.format("\\u%04x", new Object[]{Integer.valueOf(r10)});
        r10 = r10 + 1;
        goto L4
    L6:
        String[] r11 = REPLACEMENT_CHARS;
        r11[34] = "\\\"";
        r11[92] = "\\\\";
        r11[9] = "\\t";
        r11[8] = "\\b";
        r11[10] = "\\n";
        r11[13] = "\\r";
        r11[12] = "\\f";
        String[] r12 = (String[]) r11.clone();
        HTML_SAFE_REPLACEMENT_CHARS = r12;
        r12[60] = "\\u003c";
        r12[62] = "\\u003e";
        r12[38] = "\\u0026";
        r12[61] = "\\u003d";
        r12[39] = "\\u0027";
    }

    public JsonWriter(Writer r10) {
        this.stack = new int[32];
        this.stackSize = 0;
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (r10 == null) goto L7;
        this.out = r10;
        return;
    L7:
        throw new NullPointerException("out == null");
    }

    private void beforeName() throws IOException {
        int r10 = peek();
        if (r10 != 5) goto L6;
        this.out.write(44);
    L7:
        newline();
        replaceTop(4);
        return;
    L6:
        if (r10 == 3) goto L7;
        throw new IllegalStateException("Nesting problem.");
    }

    private void beforeValue() throws IOException {
        int r10 = peek();
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L6;
        this.out.append(',');
        newline();
        return;
    L6:
        if (r10 != 4) goto L8;
        this.out.append(this.separator);
        replaceTop(5);
        return;
    L8:
        if (r10 == 6) goto L17;
        if (r10 != 7) goto L16;
        if (this.lenient == true) goto L17;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L16:
        throw new IllegalStateException("Nesting problem.");
    L17:
        replaceTop(7);
        return;
    L20:
        replaceTop(2);
        newline();
    }

    private JsonWriter close(int r10, int r11, char r12) throws IOException {
        int r13 = peek();
        if (r13 == r11) goto L9;
        if (r13 == r10) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.deferredName != null) goto L16;
        this.stackSize--;
        if (r13 != r11) goto L13;
        newline();
    L13:
        this.out.write(r12);
        return this;
    L16:
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    private void newline() throws IOException {
        if (this.indent != null) goto L5;
        return;
    L5:
        this.out.write(10);
        int r10 = this.stackSize;
        int r11 = 1;
    L6:
        if (r11 >= r10) goto L8;
        this.out.write(this.indent);
        r11 = r11 + 1;
        goto L6
    }

    private JsonWriter open(int r10, char r11) throws IOException {
        beforeValue();
        push(r10);
        this.out.write(r11);
        return this;
    }

    private int peek() {
        int r10 = this.stackSize;
        if (r10 == 0) goto L7;
        return this.stack[r10 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int r10) {
        int r11 = this.stackSize;
        int[] r12 = this.stack;
        if (r11 != r12.length) goto L5;
        this.stack = Arrays.copyOf(r12, r11 * 2);
    L5:
        int[] r13 = this.stack;
        int r14 = this.stackSize;
        this.stackSize = r14 + 1;
        r13[r14] = r10;
    }

    private void replaceTop(int r10) {
        this.stack[this.stackSize - 1] = r10;
    }

    private void string(String r10) throws IOException {
        if (this.htmlSafe == false) goto L5;
        String[] r11 = HTML_SAFE_REPLACEMENT_CHARS;
    L6:
        this.out.write(34);
        int r12 = r10.length();
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r13 >= r12) goto L23;
        char r15 = r10.charAt(r13);
        if (r15 >= 128) goto L14;
        String r16 = r11[r15];
        if (r16 == null) goto L22;
    L19:
        if (r14 >= r13) goto L21;
        this.out.write(r10, r14, r13 - r14);
    L21:
        this.out.write(r16);
        r14 = r13 + 1;
    L22:
        r13 = r13 + 1;
        goto L7
    L14:
        if (r15 != 8232) goto L17;
        r16 = "\\u2028";
        goto L19
    L17:
        if (r15 != 8233) goto L22;
        r16 = "\\u2029";
        goto L19
    L23:
        if (r14 >= r12) goto L25;
        this.out.write(r10, r14, r12 - r14);
    L25:
        this.out.write(34);
        return;
    L5:
        r11 = REPLACEMENT_CHARS;
        goto L6
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName == null) goto L6;
        beforeName();
        string(this.deferredName);
        this.deferredName = null;
        return;
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, '{');
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, ']');
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) goto L7;
        this.out.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String r10) throws IOException {
        if (r10 == null) goto L4;
        writeDeferredName();
        beforeValue();
        this.out.append(r10);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter name(String r10) throws IOException {
        if (r10 == null) goto L14;
        if (this.deferredName != null) goto L12;
        if (this.stackSize == 0) goto L10;
        this.deferredName = r10;
        return this;
    L10:
        throw new IllegalStateException("JsonWriter is closed.");
    L12:
        throw new IllegalStateException();
    L14:
        throw new NullPointerException("name == null");
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) goto L5;
    L9:
        beforeValue();
        this.out.write("null");
        return this;
    L5:
        if (this.serializeNulls == false) goto L7;
        writeDeferredName();
        goto L9
    L7:
        this.deferredName = null;
        return this;
    }

    public final void setHtmlSafe(boolean r10) {
        this.htmlSafe = r10;
    }

    public final void setIndent(String r10) {
        if (r10.length() != 0) goto L5;
        this.indent = null;
        this.separator = ":";
        return;
    L5:
        this.indent = r10;
        this.separator = ": ";
    }

    public final void setLenient(boolean r10) {
        this.lenient = r10;
    }

    public final void setSerializeNulls(boolean r10) {
        this.serializeNulls = r10;
    }

    public JsonWriter value(String r10) throws IOException {
        if (r10 == null) goto L4;
        writeDeferredName();
        beforeValue();
        string(r10);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter value(boolean r10) throws IOException {
        writeDeferredName();
        beforeValue();
        Writer r11 = this.out;
        if (r10 == false) goto L5;
        String r12 = "true";
    L6:
        r11.write(r12);
        return this;
    L5:
        r12 = "false";
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int r10 = this.stackSize;
        if (r10 > 1) goto L10;
        if (r10 == 1) goto L6;
    L7:
        this.stackSize = 0;
        return;
    L6:
        if (this.stack[r10 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public JsonWriter value(Boolean r10) throws IOException {
        if (r10 == null) goto L4;
        writeDeferredName();
        beforeValue();
        Writer r11 = this.out;
        if (r10.booleanValue() == false) goto L8;
        String r12 = "true";
    L9:
        r11.write(r12);
        return this;
    L8:
        r12 = "false";
        goto L9
    L4:
        return nullValue();
    }

    public JsonWriter value(double r10) throws IOException {
        writeDeferredName();
        if (this.lenient == false) goto L5;
    L11:
        beforeValue();
        this.out.append(Double.toString(r10));
        return this;
    L5:
        if (Double.isNaN(r10) == true) goto L10;
        if (Double.isInfinite(r10) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r10);
    }

    public JsonWriter value(long r10) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(r10));
        return this;
    }

    public JsonWriter value(Number r10) throws IOException {
        if (r10 == null) goto L4;
        writeDeferredName();
        String r11 = r10.toString();
        if (this.lenient == false) goto L8;
    L16:
        beforeValue();
        this.out.append(r11);
        return this;
    L8:
        if (r11.equals("-Infinity") == true) goto L15;
        if (r11.equals("Infinity") == true) goto L15;
        if (r11.equals("NaN") == false) goto L16;
    L15:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r10);
    L4:
        return nullValue();
    }
}
