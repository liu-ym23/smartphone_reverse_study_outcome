package org.apache.http.impl.io;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = null;
    private boolean ascii;
    private ByteBuffer bbuf;
    private ByteArrayBuffer buffer;
    private Charset charset;
    private CharsetEncoder encoder;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;
    private OutputStream outStream;

    static {
        CRLF = new byte[]{Ascii.CR, 10};
    }

    public AbstractSessionOutputBuffer(OutputStream r10, int r11, Charset r12, int r13, CodingErrorAction r14, CodingErrorAction r15) {
        Args.notNull(r10, "Input stream");
        Args.notNegative(r11, "Buffer size");
        this.outStream = r10;
        this.buffer = new ByteArrayBuffer(r11);
        if (r12 != null) goto L6;
        r12 = Consts.ASCII;
    L6:
        this.charset = r12;
        this.ascii = r12.equals(Consts.ASCII);
        this.encoder = null;
        if (r13 >= 0) goto L10;
        r13 = 512;
    L10:
        this.minChunkLimit = r13;
        this.metrics = createTransportMetrics();
        if (r14 != null) goto L14;
        r14 = CodingErrorAction.REPORT;
    L14:
        this.onMalformedCharAction = r14;
        if (r15 != null) goto L18;
        r15 = CodingErrorAction.REPORT;
    L18:
        this.onUnmappableCharAction = r15;
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

    private void writeEncoded(CharBuffer r10) throws IOException {
        if (r10.hasRemaining() == true) goto L6;
        return;
    L6:
        if (this.encoder != null) goto L9;
        CharsetEncoder r11 = this.charset.newEncoder();
        this.encoder = r11;
        r11.onMalformedInput(this.onMalformedCharAction);
        this.encoder.onUnmappableCharacter(this.onUnmappableCharAction);
    L9:
        if (this.bbuf != null) goto L11;
        this.bbuf = ByteBuffer.allocate(1024);
    L11:
        this.encoder.reset();
    L13:
        if (r10.hasRemaining() == false) goto L15;
        handleEncodingResult(this.encoder.encode(r10, this.bbuf, true));
        goto L13
    L15:
        handleEncodingResult(this.encoder.flush(this.bbuf));
        this.bbuf.clear();
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    public HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        this.outStream.flush();
    }

    public void flushBuffer() throws IOException {
        int r10 = this.buffer.length();
        if (r10 <= 0) goto L6;
        this.outStream.write(this.buffer.buffer(), 0, r10);
        this.buffer.clear();
        this.metrics.incrementBytesTransferred(r10);
        return;
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public void init(OutputStream r10, int r11, HttpParams r12) {
        Args.notNull(r10, "Input stream");
        Args.notNegative(r11, "Buffer size");
        Args.notNull(r12, "HTTP parameters");
        this.outStream = r10;
        this.buffer = new ByteArrayBuffer(r11);
        String r13 = (String) r12.getParameter("http.protocol.element-charset");
        if (r13 == null) goto L5;
        Charset r14 = Charset.forName(r13);
    L6:
        this.charset = r14;
        this.ascii = r14.equals(Consts.ASCII);
        this.encoder = null;
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
        return this.buffer.length();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] r10, int r11, int r12) throws IOException {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r12 <= this.minChunkLimit) goto L7;
    L13:
        flushBuffer();
        this.outStream.write(r10, r11, r12);
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
        if (this.ascii == false) goto L12;
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
        if (this.ascii == false) goto L15;
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
        if (this.buffer.isFull() == false) goto L5;
        flushBuffer();
    L5:
        this.buffer.append(r10);
    }

    public AbstractSessionOutputBuffer() {
    }
}
