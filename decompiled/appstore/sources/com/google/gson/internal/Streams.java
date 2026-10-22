package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public final class Streams {

    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        public static class CurrentWrite implements CharSequence {
            char[] chars;

            public CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int r10) {
                return this.chars[r10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r10, int r11) {
                return new String(this.chars, r10, r11 - r10);
            }
        }

        public AppendableWriter(Appendable r10) {
            this.currentWrite = new CurrentWrite();
            this.appendable = r10;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] r10, int r11, int r12) throws IOException {
            CurrentWrite r13 = this.currentWrite;
            r13.chars = r10;
            this.appendable.append(r13, r11, r12 + r11);
        }

        @Override // java.io.Writer
        public void write(int r10) throws IOException {
            this.appendable.append((char) r10);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader r10) throws JsonParseException {
        r10.peek();     // Catch: NumberFormatException -> L6 IOException -> L8 MalformedJsonException -> L10 EOFException -> L20
        boolean r11 = false;
        return TypeAdapters.JSON_ELEMENT.read(r10);
    L12:
        e = e;
    L22:
        if (r11 == false) goto L26;
        return JsonNull.INSTANCE;
    L26:
        throw new JsonSyntaxException(e);
    L20:
        e = e;
        r11 = true;
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L8:
        e = move-exception;
        throw new JsonIOException(e);
    L6:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static void write(JsonElement r10, JsonWriter r11) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(r11, r10);
    }

    public static Writer writerForAppendable(Appendable r10) {
        if ((r10 instanceof Writer) == false) goto L6;
        return (Writer) r10;
    L6:
        return new AppendableWriter(r10);
    }
}
