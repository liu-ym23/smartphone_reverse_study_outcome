package com.byted.cast.common.api;

import com.byted.cast.common.Logger;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.ClientInfo;
import com.byted.cast.common.sink.ServerInfo;
import com.byted.cast.common.sink.Statistics;

/* JADX INFO: loaded from: classes39.dex */
public interface IServerListener {
    public static final int EXTRA_INVALID_CAST = 100;
    public static final int EXTRA_MDNS_REGISTER_SERVICE_FAILED = 282151;
    public static final int EXTRA_PUSH_CONTEXT_ERROR = 20004;
    public static final int EXTRA_PUSH_DLNA_DEVICE_ERROR = 20005;
    public static final int EXTRA_PUSH_NET_DISCONNECT = 20001;
    public static final int EXTRA_PUSH_OPEN_ERROR = 20003;
    public static final int EXTRA_PUSH_PORT_ERROR = 20002;
    public static final int EXTRA_SERVER_ALREADY_STARTED_BYTECAST = 20006;
    public static final int EXTRA_SERVER_ALREADY_STARTED_DLNA = 20007;
    public static final int EXTRA_SERVER_NO_SUPPORT_PROTOCOL = 20009;
    public static final int EXTRA_SERVER_PROTOCOL_NULL = 20008;
    public static final int SDK_AUTH_FAILED = 2;
    public static final int SDK_AUTH_SERVER_FAILED = 3;
    public static final int SDK_AUTH_SUCCESS = 1;
    public static final int WHAT_INVALID_CAST = 1;
    public static final int WHAT_PUSH_NSD_SERVER = 10009;
    public static final int WHAT_PUSH_START_SERVER = 10007;
    public static final int WHAT_PUSH_STOP_SERVER = 10008;

    /* JADX INFO: renamed from: com.byted.cast.common.api.IServerListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAudioFrame(IServerListener r100, byte[] r101, int r102, int r103, int r104, int r105, long r106) {
        }

        public static void $default$onCast(IServerListener r100, int r101, CastInfo r102) {
        }

        public static void $default$onSinkLatencyStat(IServerListener r100, int r101, String r102, String r103) {
        }

        public static void $default$onSinkStuckStat(IServerListener r100, int r101, String r102, String r103) {
        }

        public static void $default$onStart(IServerListener r100, int r101) {
        }

        public static void $default$onStart(IServerListener r100, int r101, ServerInfo r102) {
        }

        public static boolean $default$onStartMirrorAuthorization(IServerListener r100) {
            Logger.d("onStartMirrorAuthorization");
            return true;
        }

        public static void $default$onStartRecorder(IServerListener r100, int r101) {
            Logger.d("onStartRecorder");
        }

        public static void $default$onStatistics(IServerListener r100, Statistics r101) {
            Logger.d("onStatistics:" + r101.f33718nx);
        }

        public static void $default$onStopRecorder(IServerListener r100, int r101) {
            Logger.d("onStopRecorder");
        }

        public static void $default$onAuthSDK(IServerListener r100, int r101, int r102) {
            Logger.d("ServerListener", "on authSDK id:" + r101 + ",status:" + r102);
        }

        public static void $default$onConnect(IServerListener r100, int r101, ClientInfo r102) {
            Logger.d("ServerListener", "on connect id:" + r101 + ",info:" + r102);
        }

        public static void $default$onDisconnect(IServerListener r100, int r101, ClientInfo r102) {
            Logger.d("ServerListener", "on disconnect id:" + r101 + ",info:" + r102);
        }
    }

    void onAudioFrame(byte[] r100, int r101, int r102, int r103, int r104, long r105);

    void onAuthSDK(int r100, int r101);

    void onCast(int r100, CastInfo r101);

    void onConnect(int r100, ClientInfo r101);

    void onDisconnect(int r100, ClientInfo r101);

    void onError(int r100, int r101, int r102);

    void onSinkLatencyStat(int r100, String r101, String r102);

    void onSinkStuckStat(int r100, String r101, String r102);

    void onStart(int r100);

    void onStart(int r100, ServerInfo r101);

    boolean onStartMirrorAuthorization();

    void onStartRecorder(int r100);

    void onStatistics(Statistics r100);

    void onStop(int r100);

    void onStopRecorder(int r100);
}
