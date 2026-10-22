package com.byted.cast.common.source;

import com.byted.cast.common.bean.SinkDeviceInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface ISinkDeviceInfoListener {
    public static final int ERROR_CODE_BYTELINK_IS_NOT_CONNECTED_YET = 17020005;
    public static final int ERROR_CODE_GOOGLECAST_IS_NOT_CONNECTED_YET = 17020004;
    public static final int ERROR_CODE_NETWORK_COMMUNICATION_ERROR = 17020002;
    public static final int ERROR_CODE_SEND_MESSAGE_TIMEOUT = 17020003;
    public static final int ERROR_CODE_UNSUPPORTED_DEVICE = 17020001;
    public static final String ERROR_MSG_BYTELINK_IS_NOT_CONNECTED_YET = "ByteLink is not connected yet";
    public static final String ERROR_MSG_GOOGLECAST_IS_NOT_CONNECTED_YET = "GoogleCast is not connected yet";
    public static final String ERROR_MSG_NETWORK_COMMUNICATION_ERROR = "Network Communication Error";
    public static final String ERROR_MSG_SEND_MESSAGE_TIMEOUT = "send message timeout";
    public static final String ERROR_MSG_UNSUPPORTED_DEVICE = "Unsupported Device";

    void onError(ServiceInfo r100, int r101, String r102);

    void onSuccess(SinkDeviceInfo r100);
}
