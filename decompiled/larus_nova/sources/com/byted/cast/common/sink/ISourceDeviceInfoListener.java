package com.byted.cast.common.sink;

import com.byted.cast.common.bean.SourceDeviceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface ISourceDeviceInfoListener {
    public static final int ERROR_CODE_NETWORK_COMMUNICATION_ERROR = 17020002;
    public static final int ERROR_CODE_SEND_MESSAGE_TIMEOUT = 17020003;
    public static final int ERROR_CODE_UNSUPPORTED_DEVICE = 17020001;
    public static final String ERROR_MSG_DESC_NETWORK_COMMUNICATION_ERROR = "Network Communication Error";
    public static final String ERROR_MSG_DESC_SEND_MESSAGE_TIMEOUT = "send message timeout";
    public static final String ERROR_MSG_DESC_UNSUPPORTED_DEVICE = "Unsupported Device";

    void onError(String r100, int r101, String r102);

    void onSuccess(List<SourceDeviceInfo> r100);
}
