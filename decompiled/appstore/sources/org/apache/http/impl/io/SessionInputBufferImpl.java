package org.apache.http.impl.io;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.MessageConstraintException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream inStream;
    private final ByteArrayBuffer lineBuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl r10, int r11, int r12, MessageConstraints r13, CharsetDecoder r14) {
        Args.notNull(r10, "HTTP transport metrcis");
        Args.positive(r11, "Buffer size");
        this.metrics = r10;
        this.buffer = new byte[r11];
        this.bufferPos = 0;
        this.bufferLen = 0;
        if (r12 >= 0) goto L6;
        r12 = 512;
    L6:
        this.minChunkLimit = r12;
        if (r13 != null) goto L10;
        r13 = MessageConstraints.DEFAULT;
    L10:
        this.constraints = r13;
        this.lineBuffer = new ByteArrayBuffer(r11);
        this.decoder = r14;
    }

    private int appendDecoded(CharArrayBuffer r10, ByteBuffer r11) throws IOException {
        int r12 = 0;
        if (r11.hasRemaining() == true) goto L6;
        return 0;
    L6:
        if (this.cbuf != null) goto L8;
        this.cbuf = CharBuffer.allocate(1024);
    L8:
        this.decoder.reset();
    L10:
        if (r11.hasRemaining() == false) goto L12;
        r12 = r12 + handleDecodingResult(this.decoder.decode(r11, this.cbuf, true), r10, r11);
        goto L10
    L12:
        int r13 = r12 + handleDecodingResult(this.decoder.flush(this.cbuf), r10, r11);
        this.cbuf.clear();
        return r13;
    }

    private int handleDecodingResult(CoderResult r10, CharArrayBuffer r11, ByteBuffer r12) throws IOException {
        if (r10.isError() == false) goto L5;
        r10.throwException();
    L5:
        this.cbuf.flip();
        int r13 = this.cbuf.remaining();
    L7:
        if (this.cbuf.hasRemaining() == false) goto L9;
        r11.append(this.cbuf.get());
        goto L7
    L9:
        this.cbuf.compact();
        return r13;
    }

    private int lineFromLineBuffer(CharArrayBuffer r10) throws IOException {
        int r11 = this.lineBuffer.length();
        if (r11 <= 0) goto L12;
        if (this.lineBuffer.byteAt(r11 - 1) != 10) goto L7;
        r11 = r11 - 1;
    L7:
        if (r11 <= 0) goto L12;
        if (this.lineBuffer.byteAt(r11 - 1) != 13) goto L12;
        r11 = r11 - 1;
    L12:
        if (this.decoder != null) goto L14;
        r10.append(this.lineBuffer, 0, r11);
    L15:
        this.lineBuffer.clear();
        return r11;
    L14:
        r11 = appendDecoded(r10, ByteBuffer.wrap(this.lineBuffer.buffer(), 0, r11));
        goto L15
    }

    private int lineFromReadBuffer(CharArrayBuffer r10, int r11) throws IOException {
        int r12 = this.bufferPos;
        this.bufferPos = r11 + 1;
        if (r11 > r12) goto L5;
    L7:
        int r13 = r11 - r12;
        if (this.decoder != null) goto L11;
        r10.append(this.buffer, r12, r13);
        return r13;
    L11:
        return appendDecoded(r10, ByteBuffer.wrap(this.buffer, r12, r13));
    L5:
        if (this.buffer[r11 - 1] != 13) goto L7;
        r11 = r11 - 1;
        goto L7
    }

    private int streamRead(byte[] r10, int r11, int r12) throws IOException {
        Asserts.notNull(this.inStream, "Input stream");
        return this.inStream.read(r10, r11, r12);
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(InputStream r10) {
        this.inStream = r10;
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.bufferPos = 0;
        this.bufferLen = 0;
    }

    public int fillBuffer() throws IOException {
        int r10 = this.bufferPos;
        if (r10 <= 0) goto L8;
        int r11 = this.bufferLen - r10;
        if (r11 <= 0) goto L7;
        byte[] r12 = this.buffer;
        System.arraycopy(r12, r10, r12, 0, r11);
    L7:
        this.bufferPos = 0;
        this.bufferLen = r11;
    L8:
        int r13 = this.bufferLen;
        byte[] r14 = this.buffer;
        int r15 = streamRead(r14, r13, r14.length - r13);
        if (r15 != (-1)) goto L11;
        return -1;
    L11:
        this.bufferLen = r13 + r15;
        this.metrics.incrementBytesTransferred(r15);
        return r15;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        if (this.bufferPos >= this.bufferLen) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBound() {
        if (this.inStream == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int r10) throws IOException {
        return hasBufferedData();
    }

    @Override // org.apache.http.io.BufferInfo
    public int length() {
        return this.bufferLen - this.bufferPos;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read() throws IOException {
    L3:
        if (hasBufferedData() == true) goto L7;
        if (fillBuffer() != (-1)) goto L3;
        return -1;
    L7:
        byte[] r10 = this.buffer;
        int r11 = this.bufferPos;
        this.bufferPos = r11 + 1;
        return r10[r11] & UnsignedBytes.MAX_VALUE;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer r10) throws IOException {
        Args.notNull(r10, "Char array buffer");
        int r11 = this.constraints.getMaxLineLength();
        boolean r12 = true;
        int r13 = 0;
    L4:
        if (r12 == false) goto L36;
        int r14 = this.bufferPos;
    L7:
        if (r14 >= this.bufferLen) goto L12;
        if (this.buffer[r14] == 10) goto L13;
        r14 = r14 + 1;
    L13:
        if (r11 <= 0) goto L23;
        int r15 = this.lineBuffer.length();
        if (r14 < 0) goto L17;
        int r16 = r14;
    L19:
        if (((r15 + r16) - this.bufferPos) < r11) goto L23;
        throw new MessageConstraintException("Maximum line length limit exceeded");
    L17:
        r16 = this.bufferLen;
    L23:
        if (r14 != (-1)) goto L25;
        if (hasBufferedData() == false) goto L33;
        int r17 = this.bufferLen;
        int r18 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r18, r17 - r18);
        this.bufferPos = this.bufferLen;
    L33:
        r13 = fillBuffer();
        if (r13 != (-1)) goto L4;
    L29:
        r12 = false;
        goto L4
    L25:
        if (this.lineBuffer.isEmpty() == true) goto L27;
        int r19 = r14 + 1;
        int r20 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r20, r19 - r20);
        this.bufferPos = r19;
        goto L29
    L27:
        return lineFromReadBuffer(r10, r14);
    L12:
        r14 = -1;
        goto L13
    L36:
        if (r13 != (-1)) goto L41;
        if (this.lineBuffer.isEmpty() == false) goto L41;
        return -1;
    L41:
        return lineFromLineBuffer(r10);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] r10, int r11, int r12) throws IOException {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (hasBufferedData() == false) goto L10;
        int r13 = Math.min(r12, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, r10, r11, r13);
        this.bufferPos += r13;
        return r13;
    L10:
        if (r12 <= this.minChunkLimit) goto L16;
        int r14 = streamRead(r10, r11, r12);
        if (r14 <= 0) goto L14;
        this.metrics.incrementBytesTransferred(r14);
    L14:
        return r14;
    L16:
        if (hasBufferedData() == true) goto L20;
        if (fillBuffer() != (-1)) goto L16;
        return -1;
    L20:
        int r15 = Math.min(r12, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, r10, r11, r15);
        this.bufferPos += r15;
        return r15;
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl r10, int r11) {
        this(r10, r11, r11, null, null);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] r10) throws IOException {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return read(r10, 0, r10.length);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public String readLine() throws IOException {
        CharArrayBuffer r10 = new CharArrayBuffer(64);
        if (readLine(r10) != (-1)) goto L7;
        return null;
    L7:
        return r10.toString();
    }
}
