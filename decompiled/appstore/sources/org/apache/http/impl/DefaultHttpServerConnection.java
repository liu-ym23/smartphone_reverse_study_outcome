package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class DefaultHttpServerConnection extends SocketHttpServerConnection {
    public DefaultHttpServerConnection() {
    }

    @Override // org.apache.http.impl.SocketHttpServerConnection
    public void bind(Socket r10, HttpParams r11) throws IOException {
        Args.notNull(r10, "Socket");
        Args.notNull(r11, "HTTP parameters");
        assertNotOpen();
        boolean r12 = true;
        r10.setTcpNoDelay(r11.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true));
        r10.setSoTimeout(r11.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0));
        r10.setKeepAlive(r11.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false));
        int r13 = r11.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
        if (r13 < 0) goto L8;
        if (r13 <= 0) goto L6;
        boolean r14 = true;
    L7:
        r10.setSoLinger(r14, r13);
        goto L8
    L6:
        r14 = false;
    L8:
        if (r13 < 0) goto L13;
        if (r13 > 0) goto L12;
        r12 = false;
    L12:
        r10.setSoLinger(r12, r13);
    L13:
        super.bind(r10, r11);
    }
}
