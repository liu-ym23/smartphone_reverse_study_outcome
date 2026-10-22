package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    public static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = null;

        static {
            INSTANCE = new NullWriter();
        }

        private NullWriter() {
        }

        public static /* synthetic */ NullWriter access$000() {
            return INSTANCE;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char r10) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int r10) {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r10) throws IOException {
            return append(r10);
        }

        @Override // java.io.Writer
        public void write(char[] r10) {
            Preconditions.checkNotNull(r10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r10) throws IOException {
            return append(r10);
        }

        @Override // java.io.Writer
        public void write(char[] r10, int r11, int r12) {
            Preconditions.checkPositionIndexes(r11, r12 + r11, r10.length);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r10, int r11, int r12) throws IOException {
            return append(r10, r11, r12);
        }

        @Override // java.io.Writer
        public void write(String r10) {
            Preconditions.checkNotNull(r10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r10) {
            Preconditions.checkNotNull(r10);
            return this;
        }

        @Override // java.io.Writer
        public void write(String r10, int r11, int r12) {
            Preconditions.checkPositionIndexes(r11, r12 + r11, r10.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r10, int r11, int r12) {
            Preconditions.checkPositionIndexes(r11, r12, r10.length());
            return this;
        }
    }

    private CharStreams() {
    }

    @Beta
    public static Writer asWriter(Appendable r10) {
        if ((r10 instanceof Writer) == false) goto L7;
        return (Writer) r10;
    L7:
        return new AppendableWriter(r10);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable r10, Appendable r11) throws IOException {
        if ((r10 instanceof Reader) == true) goto L5;
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        CharBuffer r12 = createBuffer();
        long r13 = 0;
    L12:
        if (r10.read(r12) == (-1)) goto L14;
        r12.flip();
        r11.append(r12);
        r13 = r13 + ((long) r12.remaining());
        r12.clear();
        goto L12
    L14:
        return r13;
    L5:
        if ((r11 instanceof StringBuilder) == false) goto L9;
        return copyReaderToBuilder((Reader) r10, (StringBuilder) r11);
    L9:
        return copyReaderToWriter((Reader) r10, asWriter(r11));
    }

    @CanIgnoreReturnValue
    public static long copyReaderToBuilder(Reader r10, StringBuilder r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        char[] r12 = new char[2048];
        long r13 = 0;
    L3:
        int r14 = r10.read(r12);
        if (r14 == (-1)) goto L6;
        r11.append(r12, 0, r14);
        r13 = r13 + ((long) r14);
        goto L3
    L6:
        return r13;
    }

    @CanIgnoreReturnValue
    public static long copyReaderToWriter(Reader r10, Writer r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        char[] r12 = new char[2048];
        long r13 = 0;
    L3:
        int r14 = r10.read(r12);
        if (r14 == (-1)) goto L6;
        r11.write(r12, 0, r14);
        r13 = r13 + ((long) r14);
        goto L3
    L6:
        return r13;
    }

    public static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable r10) throws IOException {
        CharBuffer r11 = createBuffer();
        long r12 = 0;
    L3:
        long r13 = r10.read(r11);
        if (r13 == (-1)) goto L6;
        r12 = r12 + r13;
        r11.clear();
        goto L3
    L6:
        return r12;
    }

    @Beta
    public static Writer nullWriter() {
        return NullWriter.access$000();
    }

    @Beta
    public static List<String> readLines(Readable r10) throws IOException {
        ArrayList r11 = new ArrayList();
        LineReader r12 = new LineReader(r10);
    L3:
        String r13 = r12.readLine();
        if (r13 == null) goto L6;
        r11.add(r13);
        goto L3
    L6:
        return r11;
    }

    @Beta
    public static void skipFully(Reader r10, long r11) throws IOException {
        Preconditions.checkNotNull(r10);
    L4:
        if (r11 <= 0) goto L10;
        long r12 = r10.skip(r11);
        if (r12 == 0) goto L9;
        r11 = r11 - r12;
        goto L4
    L9:
        throw new EOFException();
    }

    public static String toString(Readable r10) throws IOException {
        return toStringBuilder(r10).toString();
    }

    private static StringBuilder toStringBuilder(Readable r10) throws IOException {
        StringBuilder r11 = new StringBuilder();
        if ((r10 instanceof Reader) == false) goto L5;
        copyReaderToBuilder((Reader) r10, r11);
    L6:
        return r11;
    L5:
        copy(r10, r11);
        goto L6
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readLines(Readable r10, LineProcessor<T> r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        LineReader r12 = new LineReader(r10);
    L3:
        String r13 = r12.readLine();
        if (r13 == null) goto L8;
        if (r11.processLine(r13) == true) goto L3;
    L8:
        return r11.getResult();
    }
}
