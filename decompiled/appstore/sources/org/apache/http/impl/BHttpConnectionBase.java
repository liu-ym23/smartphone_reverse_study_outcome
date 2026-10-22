package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.EmptyInputStream;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.NetUtils;

/* JADX INFO: loaded from: classes4.dex */
public class BHttpConnectionBase implements HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inBuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final MessageConstraints messageConstraints;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference<Socket> socketHolder;

    public BHttpConnectionBase(int r13, int r14, CharsetDecoder r15, CharsetEncoder r16, MessageConstraints r17, ContentLengthStrategy r18, ContentLengthStrategy r19) {
        Args.positive(r13, "Buffer size");
        HttpTransportMetricsImpl r10 = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl r11 = new HttpTransportMetricsImpl();
        if (r17 == null) goto L5;
        MessageConstraints r12 = r17;
    L6:
        this.inBuffer = new SessionInputBufferImpl(r10, r13, -1, r12, r15);
        this.outbuffer = new SessionOutputBufferImpl(r11, r13, r14, r16);
        this.messageConstraints = r17;
        this.connMetrics = new HttpConnectionMetricsImpl(r10, r11);
        if (r18 == null) goto L9;
        ContentLengthStrategy r20 = r18;
    L10:
        this.incomingContentStrategy = r20;
        if (r19 == null) goto L13;
        ContentLengthStrategy r21 = r19;
    L14:
        this.outgoingContentStrategy = r21;
        this.socketHolder = new AtomicReference();
        return;
    L13:
        r21 = StrictContentLengthStrategy.INSTANCE;
        goto L14
    L9:
        r20 = LaxContentLengthStrategy.INSTANCE;
        goto L10
    L5:
        r12 = MessageConstraints.DEFAULT;
        goto L6
    }

    private int fillInputBuffer(int r10) throws IOException {
        Socket r11 = this.socketHolder.get();
        int r12 = r11.getSoTimeout();
        r11.setSoTimeout(r10);     // Catch: Throwable -> L6
        int r13 = this.inBuffer.fillBuffer();     // Catch: Throwable -> L6
        r11.setSoTimeout(r12);
        return r13;
    L6:
        th = move-exception;
        r11.setSoTimeout(r12);
        throw th;
    }

    public boolean awaitInput(int r10) throws IOException {
        if (this.inBuffer.hasBufferedData() == false) goto L6;
        return true;
    L6:
        fillInputBuffer(r10);
        return this.inBuffer.hasBufferedData();
    }

    public void bind(Socket r10) throws IOException {
        Args.notNull(r10, "Socket");
        this.socketHolder.set(r10);
        this.inBuffer.bind(null);
        this.outbuffer.bind(null);
    }

    @Override // org.apache.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket r10 = this.socketHolder.getAndSet(null);
        if (r10 != null) goto L16;
        return;
    L16:
        this.inBuffer.clear();     // Catch: Throwable -> L7
        this.outbuffer.flush();     // Catch: Throwable -> L7
        r10.shutdownOutput();     // Catch: Throwable -> L7 IOException -> L14 Throwable -> L15
    L10:
        r10.close();
        return;
    L9:
        r10.shutdownInput();     // Catch: Throwable -> L7 Throwable -> L15
    L7:
        th = move-exception;
        r10.close();
        throw th;
    }

    public InputStream createInputStream(long r10, SessionInputBuffer r11) {
        if (r10 != (-2)) goto L7;
        return new ChunkedInputStream(r11, this.messageConstraints);
    L7:
        if (r10 != (-1)) goto L11;
        return new IdentityInputStream(r11);
    L11:
        if (r10 != 0) goto L15;
        return EmptyInputStream.INSTANCE;
    L15:
        return new ContentLengthInputStream(r11, r10);
    }

    public OutputStream createOutputStream(long r10, SessionOutputBuffer r11) {
        if (r10 != (-2)) goto L7;
        return new ChunkedOutputStream(2048, r11);
    L7:
        if (r10 != (-1)) goto L11;
        return new IdentityOutputStream(r11);
    L11:
        return new ContentLengthOutputStream(r11, r10);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void ensureOpen() throws IOException {
        Socket r10 = this.socketHolder.get();
        if (r10 == null) goto L12;
        if (this.inBuffer.isBound() == true) goto L8;
        this.inBuffer.bind(getSocketInputStream(r10));
    L8:
        if (this.outbuffer.isBound() == true) goto L13;
        this.outbuffer.bind(getSocketOutputStream(r10));
        return;
    L13:
        return;
    L12:
        throw new ConnectionClosedException();
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        Socket r10 = this.socketHolder.get();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getLocalAddress();
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        Socket r10 = this.socketHolder.get();
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getLocalPort();
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        Socket r10 = this.socketHolder.get();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getInetAddress();
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        Socket r10 = this.socketHolder.get();
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getPort();
    }

    public SessionInputBuffer getSessionInputBuffer() {
        return this.inBuffer;
    }

    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    public Socket getSocket() {
        return this.socketHolder.get();
    }

    public InputStream getSocketInputStream(Socket r10) throws IOException {
        return r10.getInputStream();
    }

    public OutputStream getSocketOutputStream(Socket r10) throws IOException {
        return r10.getOutputStream();
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        Socket r10 = this.socketHolder.get();
        if (r10 != null) goto L8;
    L6:
        return -1;
    L8:
        return r10.getSoTimeout();
    }

    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        if (this.socketHolder.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        if (isOpen() == true) goto L13;
        return true;
    L13:
        if (fillInputBuffer(1) >= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    L16:
        return true;
    }

    public HttpEntity prepareInput(HttpMessage r10) throws HttpException {
        BasicHttpEntity r11 = new BasicHttpEntity();
        long r12 = this.incomingContentStrategy.determineLength(r10);
        InputStream r13 = createInputStream(r12, this.inBuffer);
        if (r12 != (-2)) goto L6;
        r11.setChunked(true);
        r11.setContentLength(-1);
        r11.setContent(r13);
    L9:
        Header r14 = r10.getFirstHeader("Content-Type");
        if (r14 == null) goto L12;
        r11.setContentType(r14);
    L12:
        Header r15 = r10.getFirstHeader("Content-Encoding");
        if (r15 == null) goto L15;
        r11.setContentEncoding(r15);
    L15:
        return r11;
    L6:
        if (r12 != (-1)) goto L8;
        r11.setChunked(false);
        r11.setContentLength(-1);
        r11.setContent(r13);
        goto L9
    L8:
        r11.setChunked(false);
        r11.setContentLength(r12);
        r11.setContent(r13);
        goto L9
    }

    public OutputStream prepareOutput(HttpMessage r10) throws HttpException {
        return createOutputStream(this.outgoingContentStrategy.determineLength(r10), this.outbuffer);
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int r10) {
        Socket r11 = this.socketHolder.get();
        if (r11 == null) goto L9;
        r11.setSoTimeout(r10);     // Catch: SocketException -> L6
        return;
    L10:
        return;
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        Socket r10 = this.socketHolder.getAndSet(null);
        if (r10 != null) goto L12;
        return;
    L12:
        r10.setSoLinger(true, 0);     // Catch: IOException -> L11 Throwable -> L7
    L7:
        th = move-exception;
        r10.close();
        throw th;
    L6:
        r10.close();
    }

    public String toString() {
        Socket r10 = this.socketHolder.get();
        if (r10 == null) goto L10;
        StringBuilder r11 = new StringBuilder();
        SocketAddress r12 = r10.getRemoteSocketAddress();
        SocketAddress r13 = r10.getLocalSocketAddress();
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        NetUtils.formatAddress(r11, r13);
        r11.append("<->");
        NetUtils.formatAddress(r11, r12);
    L9:
        return r11.toString();
    L10:
        return "[Not bound]";
    }
}
