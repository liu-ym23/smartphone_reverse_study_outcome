package com.bytedance.android.gamecp.base.core.service.depend;

/* JADX INFO: loaded from: classes44.dex */
public final enum GameCPConnectionState extends Enum<GameCPConnectionState> {
    public static final GameCPConnectionState CONNECTED = null;
    public static final GameCPConnectionState CONNECTING = null;
    public static final GameCPConnectionState CONNECTION_UNKNOWN = null;
    public static final GameCPConnectionState CONNECT_CLOSED = null;
    public static final GameCPConnectionState CONNECT_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameCPConnectionState[] f51402a = null;
    final int mTypeValue;

    static {
        GameCPConnectionState r100 = new GameCPConnectionState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r100;
        GameCPConnectionState r101 = new GameCPConnectionState("CONNECTING", 1, 2);
        CONNECTING = r101;
        GameCPConnectionState r102 = new GameCPConnectionState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r102;
        GameCPConnectionState r103 = new GameCPConnectionState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r103;
        GameCPConnectionState r104 = new GameCPConnectionState("CONNECTED", 4, 16);
        CONNECTED = r104;
        f51402a = new GameCPConnectionState[]{r100, r101, r102, r103, r104};
    }

    public static GameCPConnectionState[] values() {
        return (GameCPConnectionState[]) f51402a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.mTypeValue + '}';
    }

    public static GameCPConnectionState valueOf(String r100) {
        return (GameCPConnectionState) r27.a.a(GameCPConnectionState.class, r100);
    }

    public GameCPConnectionState(String r100, int r101, int r102) {
        super(r100, r101);
        this.mTypeValue = r102;
    }
}
