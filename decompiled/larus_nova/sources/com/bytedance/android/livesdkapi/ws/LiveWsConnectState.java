package com.bytedance.android.livesdkapi.ws;

import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum LiveWsConnectState extends Enum<LiveWsConnectState> {
    private static final /* synthetic */ LiveWsConnectState[] $VALUES = null;
    public static final LiveWsConnectState CONNECTED = null;
    public static final LiveWsConnectState CONNECTING = null;
    public static final LiveWsConnectState CONNECTION_UNKNOWN = null;
    public static final LiveWsConnectState CONNECT_CLOSED = null;
    public static final LiveWsConnectState CONNECT_FAILED = null;
    final int mTypeValue;

    static {
        LiveWsConnectState r100 = new LiveWsConnectState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r100;
        LiveWsConnectState r101 = new LiveWsConnectState("CONNECTING", 1, 2);
        CONNECTING = r101;
        LiveWsConnectState r102 = new LiveWsConnectState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r102;
        LiveWsConnectState r103 = new LiveWsConnectState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r103;
        LiveWsConnectState r104 = new LiveWsConnectState("CONNECTED", 4, 16);
        CONNECTED = r104;
        $VALUES = new LiveWsConnectState[]{r100, r101, r102, r103, r104};
    }

    public static LiveWsConnectState[] values() {
        return (LiveWsConnectState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.mTypeValue + '}';
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }

    public static LiveWsConnectState valueOf(String r100) {
        return (LiveWsConnectState) a.a(LiveWsConnectState.class, r100);
    }

    private LiveWsConnectState(String r100, int r101, int r102) {
        super(r100, r101);
        this.mTypeValue = r102;
    }
}
