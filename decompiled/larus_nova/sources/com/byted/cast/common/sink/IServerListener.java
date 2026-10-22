package com.byted.cast.common.sink;

/* JADX INFO: loaded from: classes39.dex */
public interface IServerListener {
    public static final int ERROR_CODE_BDLINK_NETWORK_NOT_AVAILABLE = 23000001;
    public static final int ERROR_CODE_BDLINK_PORT_NOT_AVAILABLE = 23000002;
    public static final int ERROR_CODE_BYTELINK_SERVER_CREATE_SOCKET = 10010001;
    public static final int ERROR_CODE_DLNA_CONTEXT_IS_NULL = 22000003;
    public static final int ERROR_CODE_DLNA_DEVICE_XML_EXCEPTION = 22000004;
    public static final int ERROR_CODE_DLNA_NETWORK_NOT_AVAILABLE = 22000001;
    public static final int ERROR_CODE_DLNA_SERVER_OPEN_FAILED = 22000002;
    public static final String ERROR_MSG_BDLINK_NETWORK_NOT_AVAILABLE = "BDLink start server error due to network not available";
    public static final String ERROR_MSG_BDLINK_PORT_NOT_AVAILABLE = "BDLink start server error due to no available port";
    public static final String ERROR_MSG_BYTELINK_SERVER_CREATE_SOCKET = "bytelink server error due to socket create failed";
    public static final String ERROR_MSG_DLNA_CONTEXT_IS_NULL = "BDDLNA start server error due to context is null ";
    public static final String ERROR_MSG_DLNA_DEVICE_XML_EXCEPTION = "BDDLNA start server error due to device xml exception ";
    public static final String ERROR_MSG_DLNA_NETWORK_NOT_AVAILABLE = "BDDLNA start server error due to network not available";
    public static final String ERROR_MSG_DLNA_SERVER_OPEN_FAILED = "BDDLNA start server error due to server open failed ";

    void onConnect(int r100, ClientInfo r101);

    void onDisconnect(int r100, ClientInfo r101);

    void onError(int r100, int r101, String r102);

    void onStart(int r100, ServerInfo r101);

    void onStop(int r100);
}
