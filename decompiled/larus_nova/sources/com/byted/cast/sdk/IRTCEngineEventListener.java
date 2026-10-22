package com.byted.cast.sdk;

/* JADX INFO: loaded from: classes43.dex */
public interface IRTCEngineEventListener {

    /* JADX INFO: renamed from: com.byted.cast.sdk.IRTCEngineEventListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCastPortSet(IRTCEngineEventListener r100, int r101, int r102, int r103, int r104) {
        }

        public static void $default$onCastPortUnSet(IRTCEngineEventListener r100, int r101, int r102, int r103, int r104) {
        }

        public static void $default$onFirstVideoFrame(IRTCEngineEventListener r100, String r101) {
        }

        public static void $default$onInfo(IRTCEngineEventListener r100, int r101, int r102, String r103) {
        }

        public static void $default$onIntoBackground(IRTCEngineEventListener r100, String r101) {
        }

        public static void $default$onIntoForeground(IRTCEngineEventListener r100, String r101) {
        }

        public static void $default$onServerStart(IRTCEngineEventListener r100, int r101) {
        }

        public static void $default$onServerStop(IRTCEngineEventListener r100, int r101) {
        }

        public static void $default$onSinkLatencyStat(IRTCEngineEventListener r100, String r101, String r102) {
        }

        public static void $default$onSinkStuckStat(IRTCEngineEventListener r100, String r101, String r102) {
        }
    }

    void OnVideoSizeChanged(String r100, int r101, int r102, int r103);

    void onAudioSetVolume(String r100, float r101, float r102);

    void onCancelRequest(String r100);

    void onCancelSuccess();

    void onCastControl(int r100, int r101);

    void onCastPortSet(int r100, int r101, int r102, int r103);

    void onCastPortUnSet(int r100, int r101, int r102, int r103);

    boolean onCastRequest(String r100, String r101);

    void onCastSuccess();

    void onConnect(String r100, String r101);

    void onConnectStateChanged(RTCEngine.ConnectState r100);

    void onConnectSuccess(int r100, int r101, int r102);

    void onDisconnect(RTCEngine.ExitReason r100, String r101);

    void onDisconnect(String r100, RTCEngine.ExitReason r101, String r102);

    void onError(int r100, String r101);

    void onFirstVideoFrame(String r100);

    void onInfo(int r100, int r101, String r102);

    void onIntoBackground(String r100);

    void onIntoForeground(String r100);

    void onKilled();

    void onLogMonitor(String r100, String[][] r101);

    void onMonitorEvent(String r100, String r101);

    void onPaused();

    void onRecvMetaData(String r100);

    void onRecvMetaData(String r100, String r101);

    void onResumed();

    void onServerStart(int r100);

    void onServerStop(int r100);

    void onSinkLatencyStat(String r100, String r101);

    void onSinkStuckStat(String r100, String r101);

    void onStat(String r100);

    void onStopped();

    void onStuckStat(String r100);

    void onVideoEncoder(String r100, int r101, int r102, int r103, int r104, boolean r105, int r106);
}
