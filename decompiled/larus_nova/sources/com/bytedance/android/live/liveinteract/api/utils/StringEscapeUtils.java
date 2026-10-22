package com.bytedance.android.live.liveinteract.api.utils;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: loaded from: classes46.dex */
public final class StringEscapeUtils {

    public static class StringBuilderWriter extends Writer implements Serializable {
        private static final long serialVersionUID = -146927496096066153L;
        private final StringBuilder builder;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this.builder.toString();
        }

        public StringBuilderWriter() {
            this.builder = new StringBuilder();
        }

        public StringBuilderWriter(StringBuilder r100) {
            if (r100 != null) goto L6;
            r100 = new StringBuilder();
        L6:
            this.builder = r100;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char r100) {
            this.builder.append(r100);
            return this;
        }

        @Override // java.io.Writer
        public void write(String r100) {
            if (r100 == null) goto L5;
            this.builder.append(r100);
            return;
        }

        public StringBuilderWriter(int r100) {
            this.builder = new StringBuilder(r100);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r100) {
            this.builder.append(r100);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r100) throws IOException {
            return append(r100);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
            return append(r100);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r100, int r101, int r102) {
            this.builder.append(r100, r101, r102);
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] r100, int r101, int r102) {
            if (r100 == null) goto L5;
            this.builder.append(r100, r101, r102);
            return;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) throws IOException {
            return append(r100, r101, r102);
        }
    }

    public static String a(String r100) {
        if (r100 != null) goto L9;
        return null;
    L9:
        StringBuilderWriter r101 = new StringBuilderWriter(r100.length() * 2);     // Catch: IOException -> L6
        b(r101, r100);     // Catch: IOException -> L6
        return r101.toString();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String c(char r100) {
        return Integer.toHexString(r100).toUpperCase(Locale.ENGLISH);
    }

    public static void b(Writer r100, String r101) throws IOException {
        if (r101 == null) goto L40;
        int r102 = r101.length();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L56;
        char r104 = r101.charAt(r103);
        if (r104 <= 4095) goto L9;
        r100.write("\\u" + c(r104));
    L39:
        r103 = r103 + 1;
        goto L4
    L9:
        if (r104 <= 255) goto L12;
        r100.write("\\u0" + c(r104));
        goto L39
    L12:
        if (r104 <= 127) goto L15;
        r100.write("\\u00" + c(r104));
        goto L39
    L15:
        if (r104 >= ' ') goto L28;
        switch(r104) {
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L24;
            case 12: goto L19;
            case 13: goto L18;
            default: goto L24;
        };
    L18:
        r100.write(92);
        r100.write(114);
        goto L24
    L19:
        r100.write(92);
        r100.write(102);
        goto L39
    L20:
        r100.write(92);
        r100.write(110);
        goto L39
    L21:
        r100.write(92);
        r100.write(116);
        goto L39
    L22:
        r100.write(92);
        r100.write(98);
    L24:
        if (r104 <= 15) goto L26;
        r100.write("\\u00" + c(r104));
        goto L39
    L26:
        r100.write("\\u000" + c(r104));
        goto L39
    L28:
        if (r104 != '\"') goto L30;
        r100.write(92);
        r100.write(34);
        goto L39
    L30:
        if (r104 != '\'') goto L32;
        r100.write(39);
        goto L39
    L32:
        if (r104 == '/') goto L36;
        if (r104 == '\\') goto L35;
        r100.write(r104);
        goto L39
    L35:
        r100.write(92);
        r100.write(92);
        goto L39
    L36:
        r100.write(47);
        goto L39
    L56:
        return;
    }
}
