package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum ConnectionInfo extends Enum<ConnectionInfo> {
    private static final /* synthetic */ ConnectionInfo[] $VALUES = null;
    public static final ConnectionInfo CONNECTION_INFO_DEPRECATED_SPDY3 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_0 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_1 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP2 = null;
    public static final ConnectionInfo CONNECTION_INFO_QUIC_UNKNOWN_VERSION = null;
    public static final ConnectionInfo CONNECTION_INFO_UNKNOWN = null;
    final int mValue;

    static {
        ConnectionInfo r10 = new ConnectionInfo("CONNECTION_INFO_UNKNOWN", 0, 0);
        CONNECTION_INFO_UNKNOWN = r10;
        ConnectionInfo r11 = new ConnectionInfo("CONNECTION_INFO_HTTP1_1", 1, 1);
        CONNECTION_INFO_HTTP1_1 = r11;
        ConnectionInfo r12 = new ConnectionInfo("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        CONNECTION_INFO_DEPRECATED_SPDY3 = r12;
        ConnectionInfo r13 = new ConnectionInfo("CONNECTION_INFO_HTTP2", 3, 4);
        CONNECTION_INFO_HTTP2 = r13;
        ConnectionInfo r14 = new ConnectionInfo("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        CONNECTION_INFO_QUIC_UNKNOWN_VERSION = r14;
        ConnectionInfo r15 = new ConnectionInfo("CONNECTION_INFO_HTTP1_0", 5, 9);
        CONNECTION_INFO_HTTP1_0 = r15;
        $VALUES = new ConnectionInfo[]{r10, r11, r12, r13, r14, r15};
    }

    private ConnectionInfo(String r10, int r11, int r12) {
        super(r10, r11);
        this.mValue = r12;
    }

    public static ConnectionInfo valueOf(String r10) {
        return (ConnectionInfo) Enum.valueOf(ConnectionInfo.class, r10);
    }

    public static ConnectionInfo[] values() {
        return (ConnectionInfo[]) $VALUES.clone();
    }
}
