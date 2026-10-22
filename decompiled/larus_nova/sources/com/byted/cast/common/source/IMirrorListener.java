package com.byted.cast.common.source;

import com.byted.cast.common.api.IConnectListener;

/* JADX INFO: loaded from: classes39.dex */
public interface IMirrorListener extends IConnectListener {
    public static final int ERROR_CODE_AUDIO_RECORD_FAILED = 14004004;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_EXCEPTION = 14004001;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_ALREADY_EXISTED = 14004006;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_AUDIO_EXCEPTION = 14004004;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_CREATE = 14004007;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_ENCODE = 14004008;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_INVALID_PARAMS = 14004002;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_STATUS_EXCEPTION = 14004003;
    public static final int ERROR_CODE_BYTELINK_CAPTURE_FAILIED_SYSTEM_NOT_SUPPORT = 14004005;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED = 10020001;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_ADDRESS = 10020008;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_BLACKLIST = 10020004;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_BLOCK = 10020009;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_COMMAND = 10020014;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_INTERUPTED = 10020010;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_REFUSED = 10020002;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_SELECT_1 = 10020011;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_SELECT_2 = 10020013;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_SELECT_TIMEOUT = 100200012;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_SOCKET_CREATE = 10020007;
    public static final int ERROR_CODE_BYTELINK_CONNECT_FAILED_TIMEOUT = 10020003;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT = 10022007;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED = 10022005;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED_COMMAND = 10022013;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED_FATAL = 10022010;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED_HEARTBEAT = 10022011;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED_NETWORK = 10022008;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED_RECONNECT = 10022012;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_FAILED_WIFI_INVALID = 10022014;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_KICKED_BY_SERVER = 10022007;
    public static final int ERROR_CODE_BYTELINK_DISCONNECT_TIMEOUT = 10022006;
    public static final int ERROR_CODE_BYTELINK_REQUEST_MIRROR_FAILED = 10030001;
    public static final int ERROR_CODE_BYTELINK_REQUEST_MIRROR_FAILED_ERR_RESPONSE = 10030005;
    public static final int ERROR_CODE_BYTELINK_REQUEST_MIRROR_FAILED_TIMEOUT = 10030002;
    public static final int ERROR_CODE_BYTELINK_SINK_STOP_MIRROR = 10022000;
    public static final int ERROR_CODE_BYTELINK_SOURCE_KILL_PROCESS = 10030014;
    public static final int ERROR_CODE_BYTELINK_STOP_MIRROR_FAILED = 10030003;
    public static final int ERROR_CODE_BYTELINK_STOP_MIRROR_FAILED_TIMEOUT = 10030004;
    public static final int ERROR_CODE_CREATE_MEDIACODEC = 14004007;
    public static final int ERROR_CODE_ENCODE_FAILED = 14004008;
    public static final int ERROR_CODE_INVALID_ARGS = 14004002;
    public static final int ERROR_CODE_SCREEN_SHARE_EXIST = 14004006;
    public static final int ERROR_CODE_UNEXCEPTED = 14004001;
    public static final int ERROR_CODE_UNSUPPORTED_ANDROID_VERSION = 14004005;
    public static final int ERROR_CODE_USBCAST_ADB = 12300001;
    public static final int ERROR_CODE_USBCAST_QUERY_FAILED = 12300004;
    public static final int ERROR_CODE_USBCAST_SINK_NOT_AVAILABLE = 12300002;
    public static final int ERROR_CODE_USBCAST_TRANS_OPEN_FAILED = 12300003;
    public static final int ERROR_CODE_USBCAST_TRANS_RECEIVE = 12300006;
    public static final int ERROR_CODE_USBCAST_TRANS_SEND = 12300005;
    public static final int ERROR_CODE_USBCAST_TRANS_TYPE = 12300007;
    public static final int ERROR_CODE_WRONG_STATUS = 14004003;
    public static final String ERROR_MSG_AUDIO_RECORD_FAILED = "cast error due to audio record failed";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_EXCEPTION = "bytelink capture failed due to exception";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_ALREADY_EXISTED = "bytelink capture failed due to already existed";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_AUDIO_EXCEPTION = "bytelink capture failed due to audio exception";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_CREATE = "bytelink capture failed due to create failed";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_ENCODE = "bytelink capture failed due to encode failed";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_INVALID_PARAMS = "bytelink capture failed due to invalid params";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_STATUS_EXCEPTION = "bytelink capture failed due to status exception";
    public static final String ERROR_MSG_BYTELINK_CAPTURE_FAILIED_SYSTEM_NOT_SUPPORT = "bytelink capture failed due to system not support";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED = "bytelink connect failed";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_ADDRESS = "bytelink connect failed due to invalid ip address";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_BLACKLIST = "bytelink connect failed due to blacklist";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_BLOCK = "bytelink connect failed due to block";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_COMMAND = "bytelink connect failed due to command error";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_INTERUPTED = "bytelink connect failed due to interupted";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_REFUSED = "bytelink connect failed due to be refused";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_SELECT_1 = "bytelink connect failed due to system-invoke-select error 1";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_SELECT_2 = "bytelink connect failed due to system-invoke-select error 2";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_SELECT_TIMEOUT = "bytelink connect failed due to system-invoke-select timeout";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_SOCKET_CREATE = "bytelink connect failed due to create socket error";
    public static final String ERROR_MSG_BYTELINK_CONNECT_FAILED_TIMEOUT = "bytelink connect failed due to timeout";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT = "bytelink disconnect";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED = "bytelink disconnect failed";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED_COMMAND = "bytelink disconnect failed due to command error";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED_FATAL = "bytelink disconnect failed due to fatal error";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED_HEARTBEAT = "bytelink disconnect failed due to heartbeat error";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED_NETWORK = "bytelink disconnect failed due to network";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED_RECONNECT = "bytelink disconnect failed due to re-connect error";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_FAILED_WIFI_INVALID = "bytelink disconnect failed due to wifi invalid";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_KICKED_BY_SERVER = "bytelink disconnect failed due to kicked by server";
    public static final String ERROR_MSG_BYTELINK_DISCONNECT_TIMEOUT = "bytelink disconnect failed due to timeout";
    public static final String ERROR_MSG_BYTELINK_REQUEST_MIRROR_FAILED = "bytelink request mirror failed";
    public static final String ERROR_MSG_BYTELINK_REQUEST_MIRROR_FAILED_ERR_RESPONSE = "bytelink request mirror failed due to err response";
    public static final String ERROR_MSG_BYTELINK_REQUEST_MIRROR_FAILED_TIMEOUT = "bytelink request mirror failed due to timeout";
    public static final String ERROR_MSG_BYTELINK_SINK_STOP_MIRROR = "bytelink stop due to server stopped";
    public static final String ERROR_MSG_BYTELINK_SOURCE_KILL_PROCESS = "bytelink stop due to process been killed on client";
    public static final String ERROR_MSG_BYTELINK_STOP_MIRROR_FAILED = "bytelink stop mirror failed";
    public static final String ERROR_MSG_BYTELINK_STOP_MIRROR_FAILED_TIMEOUT = "bytelink stop mirror failed due to timeout";
    public static final String ERROR_MSG_CREATE_MEDIACODEC = "cast error due to create mediacodec failed";
    public static final String ERROR_MSG_ENCODE_FAILED = "cast error due to encode failed";
    public static final String ERROR_MSG_INVALID_ARGS = "cast error due to invalid args";
    public static final String ERROR_MSG_SCREEN_SHARE_EXIST = "cast error due to screen share exist";
    public static final String ERROR_MSG_UNEXCEPTED = "cast error due to no permission for screen capture";
    public static final String ERROR_MSG_UNSUPPORTED_ANDROID_VERSION = "cast error due to unsupported android version";
    public static final String ERROR_MSG_USBCAST_ADB = "usbcast failed due to debug mode not shutdown";
    public static final String ERROR_MSG_USBCAST_QUERY_FAILED = "usbcast failed due to query error";
    public static final String ERROR_MSG_USBCAST_SINK_NOT_AVAILABLE = "usbcast failed due to sink not available";
    public static final String ERROR_MSG_USBCAST_TRANS_OPEN_FAILED = "usbcast failed due to trans open error";
    public static final String ERROR_MSG_USBCAST_TRANS_RECEIVE = "usbcast failed due to trans receive error";
    public static final String ERROR_MSG_USBCAST_TRANS_SEND = "usbcast failed due to trans send error";
    public static final String ERROR_MSG_USBCAST_TRANS_TYPE = "usbcast failed due to trans type error";
    public static final String ERROR_MSG_WRONG_STATUS = "cast error due to wrong status";

    /* JADX INFO: renamed from: com.byted.cast.common.source.IMirrorListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onError(IMirrorListener r100, int r101, int r102, int r103, String r104) {
        }

        public static void $default$onError(IMirrorListener r100, ServiceInfo r101, int r102, String r103) {
        }

        public static void $default$onInfo(IMirrorListener r100, int r101, int r102, int r103, String r104) {
        }

        public static boolean $default$onInvite(IMirrorListener r100, String r101, int r102) {
            return true;
        }

        public static boolean $default$onInvite(IMirrorListener r100, String r101, int r102, String r103) {
            return true;
        }

        public static boolean $default$onStartMirrorAuthorization(IMirrorListener r100) {
            return true;
        }
    }

    void onError(int r100, int r101, int r102, String r103);

    @Override // com.byted.cast.common.api.IConnectListener
    void onError(ServiceInfo r100, int r101, String r102);

    void onInfo(int r100, int r101, int r102, String r103);

    boolean onInvite(String r100, int r101);

    boolean onInvite(String r100, int r101, String r102);

    void onMirrorModeChange(int r100);

    void onStart(int r100);

    boolean onStartMirrorAuthorization();

    void onStatistics(Statistics r100);

    void onStop(int r100);
}
