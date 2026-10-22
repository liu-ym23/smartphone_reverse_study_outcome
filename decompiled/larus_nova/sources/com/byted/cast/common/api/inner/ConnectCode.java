package com.byted.cast.common.api.inner;

/* JADX INFO: loaded from: classes39.dex */
public final class ConnectCode {
    public static int CONNECT_ERROR_FAILED = 201;
    public static int CONNECT_ERROR_FATAL = 0;
    public static int CONNECT_ERROR_IM_BLACKLIST = 0;
    public static int CONNECT_ERROR_IM_REJECT = 0;
    public static int CONNECT_ERROR_IM_TIMEOUT = 0;
    public static int CONNECT_ERROR_IM_WAITTING = 0;
    public static int CONNECT_ERROR_IO = 0;
    public static int CONNECT_ERROR_KICK_OUT = 0;
    public static int CONNECT_ERROR_NORMAL = 400;
    public static int CONNECT_INFO_DISCONNECT = 200;
    public static final int ERROR_CODE_BYTECAST_CONNECT_NOT_AUTH = 0;
    public static final String ERROR_MSG_BYTECAST_CONNECT_NOT_AUTH = "ByteCast connect not auth";

    public ConnectCode() {
    }

    static {
        CONNECT_ERROR_IO = 400 + 1;
        CONNECT_ERROR_IM_WAITTING = 400 + 2;
        CONNECT_ERROR_IM_REJECT = 400 + 3;
        CONNECT_ERROR_IM_TIMEOUT = 400 + 4;
        CONNECT_ERROR_IM_BLACKLIST = 400 + 5;
        CONNECT_ERROR_KICK_OUT = 400 + 6;
        CONNECT_ERROR_FATAL = 400 + 7;
        ERROR_CODE_BYTECAST_CONNECT_NOT_AUTH = 400 + 8;
    }
}
