package org.apache.http.params;

import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class HttpConnectionParams implements CoreConnectionPNames {
    private HttpConnectionParams() {
    }

    public static int getConnectionTimeout(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
    }

    public static int getLinger(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
    }

    public static boolean getSoKeepalive(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false);
    }

    public static boolean getSoReuseaddr(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false);
    }

    public static int getSoTimeout(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0);
    }

    public static int getSocketBufferSize(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
    }

    public static boolean getTcpNoDelay(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true);
    }

    public static boolean isStaleCheckingEnabled(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
    }

    public static void setConnectionTimeout(HttpParams r10, int r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, r11);
    }

    public static void setLinger(HttpParams r10, int r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setIntParameter(CoreConnectionPNames.SO_LINGER, r11);
    }

    public static void setSoKeepalive(HttpParams r10, boolean r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, r11);
    }

    public static void setSoReuseaddr(HttpParams r10, boolean r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, r11);
    }

    public static void setSoTimeout(HttpParams r10, int r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, r11);
    }

    public static void setSocketBufferSize(HttpParams r10, int r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, r11);
    }

    public static void setStaleCheckingEnabled(HttpParams r10, boolean r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, r11);
    }

    public static void setTcpNoDelay(HttpParams r10, boolean r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, r11);
    }
}
