package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CharStreams {
    private static final int BUF_SIZE = 2048;

    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = null;

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char r1) {
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
        public void write(int r1) {
        }

        private NullWriter() {
        }

        static /* synthetic */ NullWriter access$000() {
            return INSTANCE;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) throws IOException {
            return append(r1, r2, r3);
        }

        static {
            INSTANCE = new NullWriter();
        }

        @Override // java.io.Writer
        public void write(char[] r1) {
            Preconditions.checkNotNull(r1);
        }

        @Override // java.io.Writer
        public void write(char[] r1, int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3 + r2, r1.length);
        }

        @Override // java.io.Writer
        public void write(String r1) {
            Preconditions.checkNotNull(r1);
        }

        @Override // java.io.Writer
        public void write(String r1, int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3 + r2, r1.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r1, int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3, r1.length());
            return this;
        }
    }

    private CharStreams() {
    }

    public static long copy(Readable r5, Appendable r6) throws IOException {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        CharBuffer r0 = CharBuffer.allocate(2048);
        long r1 = 0;
    L4:
        if (r5.read(r0) == (-1)) goto L6;
        r0.flip();
        r6.append(r0);
        r1 = r1 + ((long) r0.remaining());
        r0.clear();
        goto L4
    L6:
        return r1;
    }

    public static String toString(Readable r0) throws IOException {
        return toStringBuilder(r0).toString();
    }

    private static StringBuilder toStringBuilder(Readable r1) throws IOException {
        StringBuilder r0 = new StringBuilder();
        copy(r1, r0);
        return r0;
    }

    public static List<String> readLines(Readable r2) throws IOException {
        ArrayList r0 = new ArrayList();
        LineReader r1 = new LineReader(r2);
    L3:
        String r3 = r1.readLine();
        if (r3 == null) goto L6;
        r0.add(r3);
        goto L3
    L6:
        return r0;
    }

    public static <T> T readLines(Readable r1, LineProcessor<T> r2) throws IOException {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        LineReader r0 = new LineReader(r1);
    L3:
        String r3 = r0.readLine();
        if (r3 == null) goto L8;
        if (r2.processLine(r3) == true) goto L3;
    L8:
        return r2.getResult();
    }

    public static void skipFully(Reader r4, long r5) throws IOException {
        Preconditions.checkNotNull(r4);
    L4:
        if (r5 <= 0) goto L13;
        long r2 = r4.skip(r5);
        if (r2 == 0) goto L8;
        r5 = r5 - r2;
        goto L4
    L8:
        if (r4.read() == (-1)) goto L11;
        r5 = r5 - 1;
        goto L4
    L11:
        throw new EOFException();
    }

    public static Writer nullWriter() {
        return NullWriter.access$000();
    }

    public static Writer asWriter(Appendable r1) {
        if ((r1 instanceof Writer) == false) goto L7;
        return (Writer) r1;
    L7:
        return new AppendableWriter(r1);
    }

    static Reader asReader(final Readable r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof Reader) == false) goto L7;
        return (Reader) r1;
    L7:
        return new AnonymousClass1(r1);
    }
}
