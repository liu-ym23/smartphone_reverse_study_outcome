package org.apache.http.impl.io;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class SessionOutputBufferImpl implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = null;
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outStream;

    static {
        CRLF = new byte[]{Ascii.CR, 10};
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl r10, int r11, int r12, CharsetEncoder r13) {
        Args.positive(r11, "Buffer size");
        Args.notNull(r10, "HTTP transport metrcis");
        this.metrics = r10;
        this.buffer = new ByteArrayBuffer(r11);
        if (r12 >= 0) goto L6;
        r12 = 0;
    L6:
        this.fragementSizeHint = r12;
        this.encoder = r13;
    }

    private void flushBuffer() throws IOException {
        int r10 = this.buffer.length();
        if (r10 <= 0) goto L6;
        streamWrite(this.buffer.buffer(), 0, r10);
        this.buffer.clear();
        this.metrics.incrementBytesTransferred(r10);
        return;
    }

    private void flushStream() throws IOException {
        OutputStream r10 = this.outStream;
        if (r10 == null) goto L6;
        r10.flush();
        return;
    }

    private void handleEncodingResult(CoderResult r10) throws IOException {
        if (r10.isError() == false) goto L5;
        r10.throwException();
    L5:
        this.bbuf.flip();
    L7:
        if (this.bbuf.hasRemaining() == false) goto L9;
        write(this.bbuf.get());
        goto L7
    L9:
        this.bbuf.compact();
    }

    private void streamWrite(byte[] r10, int r11, int r12) throws IOException {
        Asserts.notNull(this.outStream, "Output stream");
        this.outStream.write(r10, r11, r12);
    }

    private void writeEncoded(CharBuffer r10) throws IOException {
        if (r10.hasRemaining() == true) goto L6;
        return;
    L6:
        if (this.bbuf != null) goto L8;
        this.bbuf = ByteBuffer.allocate(1024);
    L8:
        this.encoder.reset();
    L10:
        if (r10.hasRemaining() == false) goto L12;
        handleEncodingResult(this.encoder.encode(r10, this.bbuf, true));
        goto L10
    L12:
        handleEncodingResult(this.encoder.flush(this.bbuf));
        this.bbuf.clear();
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(OutputStream r10) {
        this.outStream = r10;
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        flushStream();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean isBound() {
        if (this.outStream == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.http.io.BufferInfo
    public int length() {
        return this.buffer.length();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] r10, int r11, int r12) throws IOException {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r12 <= this.fragementSizeHint) goto L7;
    L13:
        flushBuffer();
        streamWrite(r10, r11, r12);
        this.metrics.incrementBytesTransferred(r12);
        return;
    L7:
        if (r12 > this.buffer.capacity()) goto L13;
        if (r12 <= (this.buffer.capacity() - this.buffer.length())) goto L12;
        flushBuffer();
    L12:
        this.buffer.append(r10, r11, r12);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String r10) throws IOException {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length() > 0) goto L7;
    L13:
        write(CRLF);
        return;
    L7:
        if (this.encoder != null) goto L12;
        int r11 = 0;
    L10:
        if (r11 >= r10.length()) goto L13;
        write(r10.charAt(r11));
        r11 = r11 + 1;
        goto L10
    L12:
        writeEncoded(CharBuffer.wrap(r10));
        goto L13
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl r10, int r11) {
        this(r10, r11, r11, null);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] r10) throws IOException {
        if (r10 != null) goto L4;
        return;
    L4:
        write(r10, 0, r10.length);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer r10) throws IOException {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = 0;
        if (this.encoder != null) goto L15;
        int r12 = r10.length();
    L7:
        if (r12 <= 0) goto L16;
        int r13 = Math.min(this.buffer.capacity() - this.buffer.length(), r12);
        if (r13 <= 0) goto L12;
        this.buffer.append(r10, r11, r13);
    L12:
        if (this.buffer.isFull() == false) goto L14;
        flushBuffer();
    L14:
        r11 = r11 + r13;
        r12 = r12 - r13;
    L16:
        write(CRLF);
        return;
    L15:
        writeEncoded(CharBuffer.wrap(r10.buffer(), 0, r10.length()));
        goto L16
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(int r10) throws IOException {
        if (this.fragementSizeHint > 0) goto L5;
        flushBuffer();
        this.outStream.write(r10);
        return;
    L5:
        if (this.buffer.isFull() == false) goto L7;
        flushBuffer();
    L7:
        this.buffer.append(r10);
    }
}
