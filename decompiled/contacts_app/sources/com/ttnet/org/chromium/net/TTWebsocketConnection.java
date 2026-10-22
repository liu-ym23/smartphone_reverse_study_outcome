package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTWebsocketConnection {

    public static abstract class Builder {
        public abstract TTWebsocketConnection build();

        public abstract Builder setAppId(int r1);

        public abstract Builder setAppKey(String r1);

        public abstract Builder setAppToken(String r1);

        public abstract Builder setAppVersion(int r1);

        public abstract Builder setCustomizedHeaders(Map<String, String> r1);

        public abstract Builder setCustomizedParams(Map<String, String> r1);

        public abstract Builder setDeviceId(long r1);

        public abstract Builder setFpid(int r1);

        public abstract Builder setInstallId(long r1);

        public abstract Builder setSessionId(String r1);

        public abstract Builder setSharedConnection(boolean r1);

        public abstract Builder setUrlList(List<String> r1);

        public abstract Builder useFrontierProtocol(boolean r1);

        public Builder() {
        }
    }

    public static abstract class Callback {
        public abstract void onConnectionError(TTWebsocketConnection r1, int r2, String r3, String r4);

        public abstract void onConnectionStateChanged(TTWebsocketConnection r1, int r2, String r3);

        public void onFeedbackLog(TTWebsocketConnection r1, String r2) {
        }

        public abstract void onMessageReceived(TTWebsocketConnection r1, ByteBuffer r2, int r3) throws Exception;

        public void onTrafficChanged(TTWebsocketConnection r1, String r2, long r3, long r5, boolean r7) {
        }

        public Callback() {
        }
    }

    public static class Status {
        public static final int ConnectClosed = 3;
        public static final int ConnectFailed = 2;
        public static final int ConnectUnknown = -1;
        public static final int Connected = 4;
        public static final int Connecting = 0;
        public static final int Disconnecting = 1;

        private Status() {
        }
    }

    public abstract void asyncSendBinary(ByteBuffer r1);

    public abstract void asyncSendText(String r1);

    public abstract void destroyConnection();

    public abstract boolean isConnected();

    public abstract void startConnection();

    public abstract void stopConnection();

    public TTWebsocketConnection() {
    }
}
