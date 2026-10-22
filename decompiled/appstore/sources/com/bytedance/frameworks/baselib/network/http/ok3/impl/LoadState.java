package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum LoadState extends Enum<LoadState> {
    private static final /* synthetic */ LoadState[] $VALUES = null;
    public static final LoadState CONNECTING = null;
    public static final LoadState DOWNLOADING_PAC_FILE = null;
    public static final LoadState ESTABLISHING_PROXY_TUNNEL = null;
    public static final LoadState IDLE = null;
    public static final LoadState READING_RESPONSE = null;
    public static final LoadState RESOLVING_HOST = null;
    public static final LoadState RESOLVING_HOST_IN_PAC_FILE = null;
    public static final LoadState RESOLVING_PROXY_FOR_URL = null;
    public static final LoadState SENDING_REQUEST = null;
    public static final LoadState SSL_HANDSHAKE = null;
    public static final LoadState WAITING_FOR_APPCACHE = null;
    public static final LoadState WAITING_FOR_AVAILABLE_SOCKET = null;
    public static final LoadState WAITING_FOR_CACHE = null;
    public static final LoadState WAITING_FOR_DELEGATE = null;
    public static final LoadState WAITING_FOR_RESPONSE = null;
    public static final LoadState WAITING_FOR_STALLED_SOCKET_POOL = null;

    static {
        LoadState r10 = new LoadState("IDLE", 0);
        IDLE = r10;
        LoadState r11 = new LoadState("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        WAITING_FOR_STALLED_SOCKET_POOL = r11;
        LoadState r12 = new LoadState("WAITING_FOR_AVAILABLE_SOCKET", 2);
        WAITING_FOR_AVAILABLE_SOCKET = r12;
        LoadState r13 = new LoadState("WAITING_FOR_DELEGATE", 3);
        WAITING_FOR_DELEGATE = r13;
        LoadState r14 = new LoadState("WAITING_FOR_CACHE", 4);
        WAITING_FOR_CACHE = r14;
        LoadState r15 = new LoadState("WAITING_FOR_APPCACHE", 5);
        WAITING_FOR_APPCACHE = r15;
        LoadState r16 = new LoadState("DOWNLOADING_PAC_FILE", 6);
        DOWNLOADING_PAC_FILE = r16;
        LoadState r17 = new LoadState("RESOLVING_PROXY_FOR_URL", 7);
        RESOLVING_PROXY_FOR_URL = r17;
        LoadState r18 = new LoadState("RESOLVING_HOST_IN_PAC_FILE", 8);
        RESOLVING_HOST_IN_PAC_FILE = r18;
        LoadState r19 = new LoadState("ESTABLISHING_PROXY_TUNNEL", 9);
        ESTABLISHING_PROXY_TUNNEL = r19;
        LoadState r110 = new LoadState("RESOLVING_HOST", 10);
        RESOLVING_HOST = r110;
        LoadState r111 = new LoadState("CONNECTING", 11);
        CONNECTING = r111;
        LoadState r112 = new LoadState("SSL_HANDSHAKE", 12);
        SSL_HANDSHAKE = r112;
        LoadState r113 = new LoadState("SENDING_REQUEST", 13);
        SENDING_REQUEST = r113;
        LoadState r114 = new LoadState("WAITING_FOR_RESPONSE", 14);
        WAITING_FOR_RESPONSE = r114;
        LoadState r115 = new LoadState("READING_RESPONSE", 15);
        READING_RESPONSE = r115;
        $VALUES = new LoadState[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115};
    }

    private LoadState(String r10, int r11) {
        super(r10, r11);
    }

    public static LoadState valueOf(String r10) {
        return (LoadState) Enum.valueOf(LoadState.class, r10);
    }

    public static LoadState[] values() {
        return (LoadState[]) $VALUES.clone();
    }
}
