package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
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

    public static String b(String r100) {
        if (r100 != null) goto L9;
        return null;
    L9:
        StringBuilderWriter r101 = new StringBuilderWriter(r100.length());     // Catch: IOException -> L6
        a(r101, r100);     // Catch: IOException -> L6
        return r101.toString();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void a(Writer r110, String r111) throws IOException {
        if (r111 == null) goto L61;
        int r100 = r111.length();
        StringBuilder r101 = new StringBuilder(4);
        int r102 = 0;
        boolean r103 = false;
        boolean r104 = false;
    L5:
        if (r102 >= r100) goto L49;
        char r105 = r111.charAt(r102);
        if (r104 == false) goto L16;
        r101.append(r105);
        if (r101.length() != 4) goto L48;
        r110.write((char) CastIntegerProtector.parseInt(r101.toString(), 16));     // Catch: NumberFormatException -> L12
        r101.setLength(0);     // Catch: NumberFormatException -> L12
        r103 = false;
        r104 = false;
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to parse unicode value: " + r101, e);
    L48:
        r102 = r102 + 1;
        goto L5
    L16:
        if (r103 == true) goto L18;
        if (r105 != '\\') goto L47;
        r103 = true;
        goto L48
    L47:
        r110.write(r105);
        goto L48
    L18:
        if (r105 != '\"') goto L20;
        r110.write(34);
    L44:
        r103 = false;
        goto L48
    L20:
        if (r105 == '\'') goto L42;
        if (r105 != '\\') goto L23;
        r110.write(92);
        goto L44
    L23:
        if (r105 != 'b') goto L25;
        r110.write(8);
        goto L44
    L25:
        if (r105 != 'f') goto L27;
        r110.write(12);
        goto L44
    L27:
        if (r105 != 'n') goto L29;
        r110.write(10);
        goto L44
    L29:
        if (r105 != 'r') goto L31;
        r110.write(13);
        goto L44
    L31:
        if (r105 != 't') goto L33;
        r110.write(9);
        goto L44
    L33:
        if (r105 == 'u') goto L35;
        r110.write(r105);
        goto L44
    L35:
        r103 = false;
        r104 = true;
        goto L48
    L42:
        r110.write(39);
        goto L44
    L49:
        if (r103 == false) goto L62;
        r110.write(92);
        return;
    L62:
        return;
    }
}
