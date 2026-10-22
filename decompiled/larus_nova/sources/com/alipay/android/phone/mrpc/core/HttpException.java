package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: classes28.dex */
public class HttpException extends Exception {
    public static final int NETWORK_AUTH_ERROR = 8;
    public static final int NETWORK_CONNECTION_EXCEPTION = 3;
    public static final int NETWORK_DNS_ERROR = 9;
    public static final int NETWORK_IO_EXCEPTION = 6;
    public static final int NETWORK_SCHEDULE_ERROR = 7;
    public static final int NETWORK_SERVER_EXCEPTION = 5;
    public static final int NETWORK_SOCKET_EXCEPTION = 4;
    public static final int NETWORK_SSL_EXCEPTION = 2;
    public static final int NETWORK_UNAVAILABLE = 1;
    public static final int NETWORK_UNKNOWN_ERROR = 0;
    public static final long serialVersionUID = -6320569206365033676L;
    public int mCode;
    public String mMsg;

    public HttpException(Integer r100, String r101) {
        StringBuilder r102 = new StringBuilder("Http Transport error");
        if (r100 == null) goto L5;
        r102.append("[");
        r102.append(r100);
        r102.append("]");
    L5:
        r102.append(" : ");
        if (r101 == null) goto L8;
        r102.append(r101);
    L8:
        super(r102.toString());
        this.mCode = r100.intValue();
        this.mMsg = r101;
    }

    public HttpException(String r100) {
        super(r100);
        this.mCode = 0;
        this.mMsg = r100;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }
}
