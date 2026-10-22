package com.bytedance.common.wschannel.channel.impl.ok;

/* JADX INFO: loaded from: classes2.dex */
public class WsStatus {
    public static final int CLOSING = 6;
    public static final int ConnectClosed = 3;
    public static final int ConnectFailed = 2;
    public static final int ConnectUnknown = 0;
    public static final int Connected = 4;
    public static final int Connecting = 1;
    public static final int ReConnecting = 5;

    class CODE {
        public static final int ABNORMAL_CLOSE = 1001;
        public static final int NORMAL_CLOSE = 1000;
        final /* synthetic */ WsStatus this$0;

        CODE(WsStatus r1) {
            this.this$0 = r1;
        }
    }

    public class HandshakeStatus {
        public static final int ACCESS_DENIED = 416;
        public static final int ALREADY_CONNECTED = 413;
        public static final int AUTHENTICATION_FAILED = 417;
        public static final int AUTH_ERROR = 513;
        public static final int AUTH_RESPCODE = 514;
        public static final int DEVICE_BLOCKED = 415;
        public static final int INTERNAL_ERROR = 510;
        public static final int INVALID_APPID = 411;
        public static final int INVALID_DEVICEDID = 410;
        public static final int INVALID_FPID = 409;
        public static final int OK = 0;
        public static final int SERVER_BUZY = 511;
        public static final int SERVER_SHUTTING_DOWN = 512;
        public static final int TOO_MANY_CONNECTION = 414;
        public static final int UNSUPPORTED_SUBPROTOCOL = 412;
        public static final int URI_NOT_FOUND = 404;
        final /* synthetic */ WsStatus this$0;

        public HandshakeStatus(WsStatus r1) {
            this.this$0 = r1;
        }
    }

    class TIP {
        public static final String ABNORMAL_CLOSE = "abnormal close";
        public static final String NORMAL_CLOSE = "normal close";
        final /* synthetic */ WsStatus this$0;

        TIP(WsStatus r1) {
            this.this$0 = r1;
        }
    }

    public WsStatus() {
    }
}
