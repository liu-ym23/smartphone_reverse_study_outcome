package com.byted.cast.sink.api;

/* JADX INFO: loaded from: classes43.dex */
public interface IServerListener {
    public static final int EXTRA_INVALID_CAST = 100;
    public static final int WHAT_BYTELINK_SINK_ERROR = 1000;
    public static final int WHAT_INVALID_CAST = 1;
    public static final int WHAT_NSD_ERROR = 1001;

    void onCast(int r100, CastInfo r101);

    void onConnect(int r100, ClientInfo r101);

    void onDisconnect(int r100, ClientInfo r101);

    void onError(int r100, int r101, int r102, String r103);

    void onFirstVideoFrame(String r100);

    void onMonitorEvent(String r100, String r101);

    void onRecvMetaData(int r100, ClientInfo r101, String r102);

    void onSinkLatencyStat(int r100, String r101, String r102);

    void onSinkStuckStat(int r100, String r101, String r102);

    void onStart(int r100, ServerInfo r101);

    void onStop(int r100);
}
