package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public interface IBindSdkInfoListener {
    public static final int ERROR_AUTH_FAILURE = 10002;
    public static final int ERROR_AUTH_TIMEOUT = 10001;
    public static final int ERROR_CONFIG_FAILURE = 10004;
    public static final int ERROR_CONFIG_TIMEOUT = 10003;
    public static final int ERROR_LELINK_AUTH_DEFAULT = -100;
    public static final int ERROR_LELINK_AUTH_DISABLE = 402;
    public static final int ERROR_LELINK_AUTH_PARAM_ERROR = 401;
    public static final int ERROR_LELINK_AUTH_SERVER_ERROR = 405;
    public static final int ERROR_LELINK_AUTH_TIMEOUT = -101;
    public static final int ERROR_NO_LELINK = 10006;
    public static final int ERROR_PARAM_GENERAL = 10005;
    public static final int ERROR_UNKNOW = 10000;

    void onByteCastFail(int r100, String r101, Exception r102);

    void onByteCastSuccess();

    void onLelinkFail(int r100, String r101, Exception r102);

    void onLelinkSuccess();
}
