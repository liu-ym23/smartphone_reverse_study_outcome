package com.byted.cast.common.source;

import com.byted.cast.common.sink.ServerInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IServerListener {
    public static final int CONNECT_ERROR_FAILED = 401;
    public static final int CONNECT_INFO_CONNECT = 200;
    public static final int CONNECT_INFO_DISCONNECT = 400;

    void onConnect(int r100, ServiceInfo r101, int r102);

    void onDisconnect(int r100, ServiceInfo r101, int r102, int r103);

    void onError(int r100, int r101, int r102);

    void onStart(int r100, ServerInfo r101);

    void onStop(int r100);
}
