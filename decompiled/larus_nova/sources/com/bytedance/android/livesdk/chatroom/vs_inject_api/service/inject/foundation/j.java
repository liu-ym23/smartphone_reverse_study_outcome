package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface j {
    float a();

    void forceStopLoadStallMonitor(long r100, boolean r101);

    void onEnterPlay();

    void onEnterRoom();

    void onExitRoom();

    void onModuleStart(String r100, Map<String, String> r101);

    void onModuleStop(String r100);

    void release(int r100);

    void setStreamType(int r100);

    void startLoadStallMonitor(long r100);

    void startTimerMonitor(int r100);

    void stopTimerMonitor(int r100);
}
