package com.byted.cast.common.api;

import com.byted.cast.common.source.ServiceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface IBrowseListener {
    public static final int BROWSE_CODE_STOP = 17100002;
    public static final int BROWSE_CODE_SUCCESS = 17100001;
    public static final int BROWSE_ERROR_AUTH = -1;
    public static final String BROWSE_MSG_STOP = "browse stop";
    public static final String BROWSE_MSG_SUCCESS = "browse success";
    public static final int BROWSE_STOP = 17100002;
    public static final int BROWSE_SUCCESS = 17100001;
    public static final int BROWSE_UNKNOWN_ERROR = 4;
    public static final int ERROR_CODE_DLNA_START_NULL_CONTROL_POINT = 22100002;
    public static final int ERROR_CODE_DLNA_START_SERVER_FAILED = 22100001;
    public static final int ERROR_CODE_GOOGLECAST_UNSUPPORTED_DEVICE = 26100001;
    public static final String ERROR_MSG_DLNA_START_NULL_CONTROL_POINT = "dlna start control class is null";
    public static final String ERROR_MSG_DLNA_START_SERVER_FAILED = "dlna start server failed";
    public static final String ERROR_MSG_GOOGLECAST_UNSUPPORTED_DEVICE = "the device does not support google cast";

    /* JADX INFO: renamed from: com.byted.cast.common.api.IBrowseListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onBrowseInvalidDevice(IBrowseListener r100, int r101, List r102) {
        }

        public static void $default$onError(IBrowseListener r100, int r101, String r102) {
        }
    }

    void onBrowse(int r100, List<ServiceInfo> r101);

    void onBrowseInvalidDevice(int r100, List<ServiceInfo> r101);

    void onError(int r100, String r101);
}
