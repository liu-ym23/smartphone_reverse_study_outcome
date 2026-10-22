package org.apache.http.impl.io;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer, BufferInfo {
    private boolean ascii;
    private byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private Charset charset;
    private CharsetDecoder decoder;
    private InputStream inStream;
    private ByteArrayBuffer lineBuffer;
    private int maxLineLen;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;

    public AbstractSessionInputBuffer() {
    }

    private int appendDecoded(CharArrayBuffer r10, ByteBuffer r11) throws IOException {
        int r12 = 0;
        if (r11.hasRemaining() == true) goto L6;
        return 0;
    L6:
        if (this.decoder != null) goto L9;
        CharsetDecoder r13 = this.charset.newDecoder();
        this.decoder = r13;
        r13.onMalformedInput(this.onMalformedCharAction);
        this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
    L9:
        if (this.cbuf != null) goto L11;
        this.cbuf = CharBuffer.allocate(1024);
    L11:
        this.decoder.reset();
    L13:
        if (r11.hasRemaining() == false) goto L15;
        r12 = r12 + handleDecodingResult(this.decoder.decode(r11, this.cbuf, true), r10, r11);
        goto L13
    L15:
        int r14 = r12 + handleDecodingResult(this.decoder.flush(this.cbuf), r10, r11);
        this.cbuf.clear();
        return r14;
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
        if (this.ascii == false) goto L14;
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
        if (this.ascii == false) goto L11;
        r10.append(this.buffer, r12, r13);
        return r13;
    L11:
        return appendDecoded(r10, ByteBuffer.wrap(this.buffer, r12, r13));
    L5:
        if (this.buffer[r11 - 1] != 13) goto L7;
        r11 = r11 - 1;
        goto L7
    }

    private int locateLF() {
        int r10 = this.bufferPos;
    L4:
        if (r10 >= this.bufferLen) goto L9;
        if (this.buffer[r10] == 10) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return -1;
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
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
        int r15 = this.inStream.read(r14, r13, r14.length - r13);
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

    public void init(InputStream r10, int r11, HttpParams r12) {
        Args.notNull(r10, "Input stream");
        Args.notNegative(r11, "Buffer size");
        Args.notNull(r12, "HTTP parameters");
        this.inStream = r10;
        this.buffer = new byte[r11];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.lineBuffer = new ByteArrayBuffer(r11);
        String r13 = (String) r12.getParameter("http.protocol.element-charset");
        if (r13 == null) goto L5;
        Charset r14 = Charset.forName(r13);
    L6:
        this.charset = r14;
        this.ascii = r14.equals(Consts.ASCII);
        this.decoder = null;
        this.maxLineLen = r12.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.minChunkLimit = r12.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
        this.metrics = createTransportMetrics();
        CodingErrorAction r15 = (CodingErrorAction) r12.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (r15 != null) goto L10;
        r15 = CodingErrorAction.REPORT;
    L10:
        this.onMalformedCharAction = r15;
        CodingErrorAction r16 = (CodingErrorAction) r12.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (r16 != null) goto L14;
        r16 = CodingErrorAction.REPORT;
    L14:
        this.onUnmappableCharAction = r16;
        return;
    L5:
        r14 = Consts.ASCII;
        goto L6
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
        boolean r11 = true;
        int r12 = 0;
    L4:
        if (r11 == false) goto L26;
        int r13 = locateLF();
        if (r13 == (-1)) goto L14;
        if (this.lineBuffer.isEmpty() == true) goto L10;
        int r14 = r13 + 1;
        int r15 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r15, r14 - r15);
        this.bufferPos = r14;
    L12:
        r11 = false;
    L20:
        if (this.maxLineLen <= 0) goto L4;
        if (this.lineBuffer.length() < this.maxLineLen) goto L4;
        throw new IOException("Maximum line length limit exceeded");
    L10:
        return lineFromReadBuffer(r10, r13);
    L14:
        if (hasBufferedData() == false) goto L16;
        int r16 = this.bufferLen;
        int r17 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r17, r16 - r17);
        this.bufferPos = this.bufferLen;
    L16:
        r12 = fillBuffer();
        if (r12 != (-1)) goto L20;
    L26:
        if (r12 != (-1)) goto L31;
        if (this.lineBuffer.isEmpty() == false) goto L31;
        return -1;
    L31:
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
        int r14 = this.inStream.read(r10, r11, r12);
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
        if (readLine(r10) != (-1)) goto L5;
        return null;
    L5:
        return r10.toString();
    }
}
