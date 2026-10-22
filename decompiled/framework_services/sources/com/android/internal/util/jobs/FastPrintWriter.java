package com.android.internal.util.jobs;

import android.util.Log;
import android.util.Printer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes.dex */
public class FastPrintWriter extends PrintWriter {
    private final boolean mAutoFlush;
    private final int mBufferLen;
    private final ByteBuffer mBytes;
    private CharsetEncoder mCharset;
    private boolean mIoError;
    private final OutputStream mOutputStream;
    private int mPos;
    private final Printer mPrinter;
    private final String mSeparator;
    private final char[] mText;
    private final Writer mWriter;

    private static class DummyWriter extends Writer {
        /* synthetic */ DummyWriter(FastPrintWriterIA r1) {
            this();
        }

        private DummyWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            UnsupportedOperationException ex = new UnsupportedOperationException("Shouldn't be here");
            throw ex;
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            close();
        }

        @Override // java.io.Writer
        public void write(char[] buf, int offset, int count) throws IOException {
            close();
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r1, int r2, int r3) throws IOException {
        return append(r1, r2, r3);
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) throws IOException {
        return append(r1, r2, r3);
    }

    public FastPrintWriter(OutputStream out) {
        this(out, false, 8192);
    }

    public FastPrintWriter(OutputStream out, boolean autoFlush) {
        this(out, autoFlush, 8192);
    }

    public FastPrintWriter(OutputStream out, boolean autoFlush, int bufferLen) {
        super(new DummyWriter(null), autoFlush);
        if (out == null) goto L7;
        this.mBufferLen = bufferLen;
        this.mText = new char[bufferLen];
        this.mBytes = ByteBuffer.allocate(this.mBufferLen);
        this.mOutputStream = out;
        this.mWriter = null;
        this.mPrinter = null;
        this.mAutoFlush = autoFlush;
        this.mSeparator = System.lineSeparator();
        initDefaultEncoder();
        return;
    L7:
        throw new NullPointerException("out is null");
    }

    public FastPrintWriter(Writer wr) {
        this(wr, false, 8192);
    }

    public FastPrintWriter(Writer wr, boolean autoFlush) {
        this(wr, autoFlush, 8192);
    }

    public FastPrintWriter(Writer wr, boolean autoFlush, int bufferLen) {
        super(new DummyWriter(null), autoFlush);
        if (wr == null) goto L7;
        this.mBufferLen = bufferLen;
        this.mText = new char[bufferLen];
        this.mBytes = null;
        this.mOutputStream = null;
        this.mWriter = wr;
        this.mPrinter = null;
        this.mAutoFlush = autoFlush;
        this.mSeparator = System.lineSeparator();
        initDefaultEncoder();
        return;
    L7:
        throw new NullPointerException("wr is null");
    }

    public FastPrintWriter(Printer pr) {
        this(pr, 512);
    }

    public FastPrintWriter(Printer pr, int bufferLen) {
        super(new DummyWriter(null), true);
        if (pr == null) goto L7;
        this.mBufferLen = bufferLen;
        this.mText = new char[bufferLen];
        this.mBytes = null;
        this.mOutputStream = null;
        this.mWriter = null;
        this.mPrinter = pr;
        this.mAutoFlush = true;
        this.mSeparator = System.lineSeparator();
        initDefaultEncoder();
        return;
    L7:
        throw new NullPointerException("pr is null");
    }

    private final void initEncoder(String csn) throws UnsupportedEncodingException {
        this.mCharset = Charset.forName(csn).newEncoder();     // Catch: Exception -> L5
        this.mCharset.onMalformedInput(CodingErrorAction.REPLACE);
        this.mCharset.onUnmappableCharacter(CodingErrorAction.REPLACE);
        return;
    L7:
        throw new UnsupportedEncodingException(csn);
    }

    @Override // java.io.PrintWriter
    public boolean checkError() {
        flush();
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        boolean r1 = this.mIoError;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter
    protected void clearError() {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        this.mIoError = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter
    protected void setError() {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        this.mIoError = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void initDefaultEncoder() {
        this.mCharset = Charset.defaultCharset().newEncoder();
        this.mCharset.onMalformedInput(CodingErrorAction.REPLACE);
        this.mCharset.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private void appendLocked(char c) throws IOException {
        int pos = this.mPos;
        if (pos < (this.mBufferLen - 1)) goto L5;
        flushLocked();
        pos = this.mPos;
    L5:
        this.mText[pos] = c;
        this.mPos = pos + 1;
    }

    private void appendLocked(String str, int i, int length) throws IOException {
        int BUFFER_LEN = this.mBufferLen;
        if (length <= BUFFER_LEN) goto L12;
        int end = i + length;
    L5:
        if (i >= end) goto L11;
        int next = i + BUFFER_LEN;
        if (next >= end) goto L9;
        int r3 = BUFFER_LEN;
    L10:
        appendLocked(str, i, r3);
        i = next;
        goto L5
    L9:
        r3 = end - i;
        goto L10
    L11:
        return;
    L12:
        int pos = this.mPos;
        if ((pos + length) <= BUFFER_LEN) goto L15;
        flushLocked();
        pos = this.mPos;
    L15:
        str.getChars(i, i + length, this.mText, pos);
        this.mPos = pos + length;
    }

    private void appendLocked(char[] buf, int i, int length) throws IOException {
        int BUFFER_LEN = this.mBufferLen;
        if (length <= BUFFER_LEN) goto L12;
        int end = i + length;
    L5:
        if (i >= end) goto L11;
        int next = i + BUFFER_LEN;
        if (next >= end) goto L9;
        int r3 = BUFFER_LEN;
    L10:
        appendLocked(buf, i, r3);
        i = next;
        goto L5
    L9:
        r3 = end - i;
        goto L10
    L11:
        return;
    L12:
        int pos = this.mPos;
        if ((pos + length) <= BUFFER_LEN) goto L15;
        flushLocked();
        pos = this.mPos;
    L15:
        System.arraycopy(buf, i, this.mText, pos, length);
        this.mPos = pos + length;
    }

    private void flushBytesLocked() throws IOException {
        if (this.mIoError == true) goto L8;
        int position = this.mBytes.position();
        if (position <= 0) goto L9;
        this.mBytes.flip();
        this.mOutputStream.write(this.mBytes.array(), 0, position);
        this.mBytes.clear();
        return;
    L9:
        return;
    }

    private void flushLocked() throws IOException {
        if (this.mPos > 0) goto L5;
        return;
    L5:
        if (this.mOutputStream == null) goto L21;
        CharBuffer charBuffer = CharBuffer.wrap(this.mText, 0, this.mPos);
        CoderResult result = this.mCharset.encode(charBuffer, this.mBytes, true);
    L8:
        if (this.mIoError == true) goto L17;
        if (result.isError() == true) goto L15;
        if (result.isOverflow() == false) goto L17;
        flushBytesLocked();
        result = this.mCharset.encode(charBuffer, this.mBytes, true);
        goto L8
    L15:
        throw new IOException(result.toString());
    L17:
        if (this.mIoError == true) goto L38;
        flushBytesLocked();
        this.mOutputStream.flush();
    L38:
        this.mPos = 0;
        return;
    L21:
        if (this.mWriter != null) goto L23;
        int nonEolOff = 0;
        int sepLen = this.mSeparator.length();
        if (sepLen >= this.mPos) goto L28;
        int len = sepLen;
    L30:
        if (nonEolOff >= len) goto L35;
        if (this.mText[(this.mPos - 1) - nonEolOff] != this.mSeparator.charAt((this.mSeparator.length() - 1) - nonEolOff)) goto L35;
        nonEolOff = nonEolOff + 1;
    L35:
        if (nonEolOff < this.mPos) goto L37;
        this.mPrinter.println("");
        goto L38
    L37:
        this.mPrinter.println(new String(this.mText, 0, this.mPos - nonEolOff));
        goto L38
    L28:
        len = this.mPos;
        goto L30
    L23:
        if (this.mIoError == true) goto L38;
        this.mWriter.write(this.mText, 0, this.mPos);
        this.mWriter.flush();
        goto L38
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        flushLocked();     // Catch: Throwable -> L9 IOException -> L11
        if (this.mIoError == false) goto L7;
    L25:
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mOutputStream == null) goto L14;
        this.mOutputStream.flush();     // Catch: Throwable -> L9 IOException -> L11
        goto L25
    L14:
        if (this.mWriter == null) goto L25;
        this.mWriter.flush();     // Catch: Throwable -> L9 IOException -> L11
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L9
        setError();     // Catch: Throwable -> L9
        goto L19
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        flushLocked();     // Catch: Throwable -> L7 IOException -> L9
        if (this.mOutputStream == null) goto L12;
        this.mOutputStream.close();     // Catch: Throwable -> L7 IOException -> L9
    L23:
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L12:
        if (this.mWriter == null) goto L23;
        this.mWriter.close();     // Catch: Throwable -> L7 IOException -> L9
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L7
        setError();     // Catch: Throwable -> L7
        goto L17
    }

    @Override // java.io.PrintWriter
    public void print(char[] charArray) {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(charArray, 0, charArray.length);     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L6
        setError();     // Catch: Throwable -> L6
        goto L10
    }

    @Override // java.io.PrintWriter
    public void print(char ch) {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(ch);     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L6
        setError();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter
    public void print(String str) {
        if (str != null) goto L4;
        str = String.valueOf(null);
    L4:
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(str, 0, str.length());     // Catch: Throwable -> L8 IOException -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L8
        setError();     // Catch: Throwable -> L8
        goto L12
    }

    @Override // java.io.PrintWriter
    public void print(int inum) {
        if (inum != 0) goto L4;
        print("0");
        return;
    L4:
        super.print(inum);
    }

    @Override // java.io.PrintWriter
    public void print(long lnum) {
        if (lnum != 0) goto L5;
        print("0");
        return;
    L5:
        super.print(lnum);
    }

    @Override // java.io.PrintWriter
    public void println() {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(this.mSeparator, 0, this.mSeparator.length());     // Catch: Throwable -> L8 IOException -> L10
        if (this.mAutoFlush == false) goto L15;
        flushLocked();     // Catch: Throwable -> L8 IOException -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L8
        setError();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter
    public void println(int inum) {
        if (inum != 0) goto L4;
        println("0");
        return;
    L4:
        super.println(inum);
    }

    @Override // java.io.PrintWriter
    public void println(long lnum) {
        if (lnum != 0) goto L5;
        println("0");
        return;
    L5:
        super.println(lnum);
    }

    @Override // java.io.PrintWriter
    public void println(char[] chars) {
        print(chars);
        println();
    }

    @Override // java.io.PrintWriter
    public void println(char c) {
        print(c);
        println();
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] buf, int offset, int count) {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(buf, offset, count);     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L6
        setError();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int oneChar) {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked((char) oneChar);     // Catch: Throwable -> L7 IOException -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L7
        setError();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str) {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(str, 0, str.length());     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L6
        setError();     // Catch: Throwable -> L6
        goto L10
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int offset, int count) {
        Object r0 = ((PrintWriter) this).lock;
        monitor-enter(r0);
        appendLocked(str, offset, count);     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Log.w("FastPrintWriter", "Write failure", e);     // Catch: Throwable -> L6
        setError();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.lang.Appendable
    public PrintWriter append(CharSequence csq, int start, int end) {
        if (csq != null) goto L4;
        csq = "null";
    L4:
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return this;
    }
}
