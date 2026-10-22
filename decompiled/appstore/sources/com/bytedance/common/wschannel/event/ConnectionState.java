package com.bytedance.common.wschannel.event;

/* JADX INFO: loaded from: classes.dex */
public final enum ConnectionState extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES = null;
    public static final ConnectionState CONNECTED = null;
    public static final ConnectionState CONNECTING = null;
    public static final ConnectionState CONNECTION_UNKNOWN = null;
    public static final ConnectionState CONNECT_CLOSED = null;
    public static final ConnectionState CONNECT_FAILED = null;
    final int mTypeValue;

    static {
        ConnectionState r10 = new ConnectionState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r10;
        ConnectionState r11 = new ConnectionState("CONNECTING", 1, 2);
        CONNECTING = r11;
        ConnectionState r12 = new ConnectionState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r12;
        ConnectionState r13 = new ConnectionState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r13;
        ConnectionState r14 = new ConnectionState("CONNECTED", 4, 16);
        CONNECTED = r14;
        $VALUES = new ConnectionState[]{r10, r11, r12, r13, r14};
    }

    private ConnectionState(String r10, int r11, int r12) {
        super(r10, r11);
        this.mTypeValue = r12;
    }

    public static ConnectionState valueOf(String r10) {
        return (ConnectionState) Enum.valueOf(ConnectionState.class, r10);
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.mTypeValue + '}';
    }
}
