package org.apache.http.params;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class HttpParamConfig {
    private HttpParamConfig() {
    }

    public static ConnectionConfig getConnectionConfig(HttpParams r10) {
        MessageConstraints r11 = getMessageConstraints(r10);
        String r12 = (String) r10.getParameter("http.protocol.element-charset");
        ConnectionConfig.Builder r13 = ConnectionConfig.custom();
        if (r12 == null) goto L5;
        Charset r14 = Charset.forName(r12);
    L7:
        return r13.setCharset(r14).setMalformedInputAction((CodingErrorAction) r10.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION)).setMalformedInputAction((CodingErrorAction) r10.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION)).setMessageConstraints(r11).build();
    L5:
        r14 = null;
        goto L7
    }

    public static MessageConstraints getMessageConstraints(HttpParams r10) {
        return MessageConstraints.custom().setMaxHeaderCount(r10.getIntParameter(CoreConnectionPNames.MAX_HEADER_COUNT, -1)).setMaxLineLength(r10.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1)).build();
    }

    public static SocketConfig getSocketConfig(HttpParams r10) {
        return SocketConfig.custom().setSoTimeout(r10.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0)).setSoReuseAddress(r10.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false)).setSoKeepAlive(r10.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false)).setSoLinger(r10.getIntParameter(CoreConnectionPNames.SO_LINGER, -1)).setTcpNoDelay(r10.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true)).build();
    }
}
