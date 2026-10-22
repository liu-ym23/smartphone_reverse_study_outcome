package com.byted.cast.common.api;

import com.byted.cast.common.source.ServiceInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IConnectListener {
    public static final int ERROR_CODE_BDLINK_GET_DEVICE_INFO_ERROR = 23200002;
    public static final int ERROR_CODE_BDLINK_SERVICE_DISCONNECT = 23200001;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED = 10200001;
    public static final int ERROR_CODE_CLOUDLINK_DISCONNECT = 25200001;
    public static final int ERROR_CODE_CLOUDLINK_INVALID_DEVICE = 25200002;
    public static final int ERROR_CODE_DIAL_APP_IS_NOT_PULLED_UP = 28200006;
    public static final int ERROR_CODE_DIAL_CONNECT_FAILED = 28200000;
    public static final int ERROR_CODE_DIAL_IO_EXCEPTION = 28200002;
    public static final int ERROR_CODE_DIAL_LINK_TIMEOUT = 28200003;
    public static final int ERROR_CODE_DIAL_NOT_FOUND_APP = 28200001;
    public static final int ERROR_CODE_DIAL_OLD_VERSION = 28200005;
    public static final int ERROR_CODE_DIAL_SERVER_FAIL = 28200004;
    public static final int ERROR_CODE_DIAL_SERVICE_DISCONNECT = 28200011;
    public static final int ERROR_CODE_DIAL_TV_DIAL_ENABLE_FALSE = 28200007;
    public static final int ERROR_CODE_DLNA_SERVICE_DISCONNECT = 29200000;
    public static final int ERROR_CODE_GOOGLECAST_ALREADY_CONNECTED = 26200008;
    public static final int ERROR_CODE_GOOGLECAST_DISCONNECT = 26200002;
    public static final int ERROR_CODE_GOOGLECAST_INNER_EXCEPTION = 26200006;
    public static final int ERROR_CODE_GOOGLECAST_INVALID_DEVICE = 26200007;
    public static final int ERROR_CODE_GOOGLECAST_NO_DEVICE = 26200003;
    public static final int ERROR_CODE_GOOGLECAST_NULL_SERVICE_INFO = 26200005;
    public static final int ERROR_CODE_GOOGLECAST_RESUME_FAILED = 26200004;
    public static final int ERROR_CODE_GOOGLECAST_TIMEOUT = 26200001;
    public static final int ERROR_CODE_GOOGLECAST_UNKNOWN_REASON = 26200000;
    public static final String ERROR_MSG_BDLINK_GET_DEVICE_INFO_ERROR = "BDLink connect failed due to getDeviceInfo error";
    public static final String ERROR_MSG_BDLINK_SERVICE_DISCONNECT = "BDLink service disconnect";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED = "ByteLink connect failed";
    public static final String ERROR_MSG_CLOUDLINK_DISCONNECT = "cloudLink disconnect";
    public static final String ERROR_MSG_CLOUDLINK_INVALID_DEVICE = "cloudLink connect failed due to invalid device";
    public static final String ERROR_MSG_DIAL_APP_IS_NOT_PULLED_UP = "dial name App is not woken up by TV OS";
    public static final String ERROR_MSG_DIAL_CONNECT_FAILED = "DIAL connect failed";
    public static final String ERROR_MSG_DIAL_IO_EXCEPTION = "An io exception occurred during dial connection";
    public static final String ERROR_MSG_DIAL_LINK_TIMEOUT = "Timeout occurred during connection";
    public static final String ERROR_MSG_DIAL_NOT_FOUND_APP = "The specified app was not found on the dial device";
    public static final String ERROR_MSG_DIAL_OLD_VERSION = "What is being pulled up is an old version of the client and needs to be upgraded.";
    public static final String ERROR_MSG_DIAL_SERVER_FAIL = "Failed to start service";
    public static final String ERROR_MSG_DIAL_SERVICE_DISCONNECT = "The connected dial device has been disconnected";
    public static final String ERROR_MSG_DIAL_TV_DIAL_ENABLE_FALSE = "The dial switch on the receiving end is turned off.";
    public static final String ERROR_MSG_DLNA_SERVICE_DISCONNECT = "The connected dlna device has been disconnected";
    public static final String ERROR_MSG_GOOGLECAST_ALREADY_CONNECTED = "GoogleCast already connected";
    public static final String ERROR_MSG_GOOGLECAST_DISCONNECT = "GoogleCast disconnect";
    public static final String ERROR_MSG_GOOGLECAST_INNER_EXCEPTION = "GoogleCast connect failed due to inner exception";
    public static final String ERROR_MSG_GOOGLECAST_INVALID_DEVICE = "GoogleCast connect failed due to invalid device";
    public static final String ERROR_MSG_GOOGLECAST_NO_DEVICE = "GoogleCast connect failed due to no device";
    public static final String ERROR_MSG_GOOGLECAST_NULL_SERVICE_INFO = "GoogleCast connect failed due to null service info";
    public static final String ERROR_MSG_GOOGLECAST_RESUME_FAILED = "GoogleCast disconnect due to resume failed";
    public static final String ERROR_MSG_GOOGLECAST_TIMEOUT = "GoogleCast disconnect due to timeout";
    public static final String ERROR_MSG_GOOGLECAST_UNKNOWN_REASON = "GoogleCast failed to connect due to unknown reason";

    /* JADX INFO: renamed from: com.byted.cast.common.api.IConnectListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onConnect(IConnectListener r100, ServiceInfo r101, int r102) {
        }

        public static void $default$onConnectFailed(IConnectListener r100, ServiceInfo r101, int r102, String r103) {
        }

        public static void $default$onConnected(IConnectListener r100, ServiceInfo r101) {
        }

        public static void $default$onConnecting(IConnectListener r100, ServiceInfo r101) {
        }

        public static void $default$onDisconnect(IConnectListener r100, ServiceInfo r101, int r102, int r103) {
        }

        public static void $default$onDisconnected(IConnectListener r100, ServiceInfo r101, int r102, String r103) {
        }

        public static void $default$onDisconnecting(IConnectListener r100, ServiceInfo r101) {
        }

        public static void $default$onError(IConnectListener r100, ServiceInfo r101, int r102, String r103) {
        }

        public static void $default$onInfo(IConnectListener r100, ServiceInfo r101, int r102, String r103) {
        }
    }

    void onConnect(ServiceInfo r100, int r101);

    void onConnectFailed(ServiceInfo r100, int r101, String r102);

    void onConnected(ServiceInfo r100);

    void onConnecting(ServiceInfo r100);

    void onDisconnect(ServiceInfo r100, int r101, int r102);

    void onDisconnected(ServiceInfo r100, int r101, String r102);

    void onDisconnecting(ServiceInfo r100);

    void onError(ServiceInfo r100, int r101, String r102);

    void onInfo(ServiceInfo r100, int r101, String r102);
}
