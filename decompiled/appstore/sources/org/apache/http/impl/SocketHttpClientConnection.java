package org.apache.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import org.apache.http.HttpInetConnection;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
    private volatile boolean open;
    private volatile Socket socket;

    public SocketHttpClientConnection() {
        this.socket = null;
    }

    private static void formatAddress(StringBuilder r10, SocketAddress r11) {
        if ((r11 instanceof InetSocketAddress) == false) goto L9;
        InetSocketAddress r12 = (InetSocketAddress) r11;
        if (r12.getAddress() == null) goto L7;
        Object r13 = r12.getAddress().getHostAddress();
    L8:
        r10.append(r13);
        r10.append(':');
        r10.append(r12.getPort());
        return;
    L7:
        r13 = r12.getAddress();
        goto L8
    L9:
        r10.append(r11);
    }

    public void assertNotOpen() {
        Asserts.check(!this.open, "Connection is already open");
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection
    public void assertOpen() {
        Asserts.check(this.open, "Connection is not open");
    }

    public void bind(Socket r10, HttpParams r11) throws IOException {
        Args.notNull(r10, "Socket");
        Args.notNull(r11, "HTTP parameters");
        this.socket = r10;
        int r12 = r11.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
        init(createSessionInputBuffer(r10, r12, r11), createSessionOutputBuffer(r10, r12, r11), r11);
        this.open = true;
    }

    @Override // org.apache.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.open == true) goto L5;
        return;
    L5:
        this.open = false;
        Socket r10 = this.socket;
        doFlush();     // Catch: Throwable -> L9
        r10.shutdownOutput();     // Catch: Throwable -> L9 IOException -> L16 Throwable -> L17
    L12:
        r10.close();
        return;
    L11:
        r10.shutdownInput();     // Catch: Throwable -> L9 Throwable -> L17
    L9:
        th = move-exception;
        r10.close();
        throw th;
    }

    public SessionInputBuffer createSessionInputBuffer(Socket r10, int r11, HttpParams r12) throws IOException {
        return new SocketInputBuffer(r10, r11, r12);
    }

    public SessionOutputBuffer createSessionOutputBuffer(Socket r10, int r11, HttpParams r12) throws IOException {
        return new SocketOutputBuffer(r10, r11, r12);
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        if (this.socket != null) goto L5;
        return null;
    L5:
        return this.socket.getLocalAddress();
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        if (this.socket != null) goto L5;
        return -1;
    L5:
        return this.socket.getLocalPort();
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        if (this.socket != null) goto L5;
        return null;
    L5:
        return this.socket.getInetAddress();
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        if (this.socket != null) goto L5;
        return -1;
    L5:
        return this.socket.getPort();
    }

    public Socket getSocket() {
        return this.socket;
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        if (this.socket != null) goto L8;
    L6:
        return -1;
    L8:
        return this.socket.getSoTimeout();
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        return this.open;
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int r10) {
        assertOpen();
        if (this.socket == null) goto L9;
        this.socket.setSoTimeout(r10);     // Catch: SocketException -> L6
        return;
    L10:
        return;
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        this.open = false;
        Socket r10 = this.socket;
        if (r10 == null) goto L6;
        r10.close();
        return;
    }

    public String toString() {
        if (this.socket == null) goto L11;
        StringBuilder r10 = new StringBuilder();
        SocketAddress r11 = this.socket.getRemoteSocketAddress();
        SocketAddress r12 = this.socket.getLocalSocketAddress();
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        formatAddress(r10, r12);
        r10.append("<->");
        formatAddress(r10, r11);
    L9:
        return r10.toString();
    L11:
        return super.toString();
    }
}
