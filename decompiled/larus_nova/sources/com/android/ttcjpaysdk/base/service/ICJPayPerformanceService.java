package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayPerformanceService extends ICJPayService {
    void endKeepPage(String r100);

    void init(Context r100);

    void initModule(String r100);

    boolean isInstallApmMonitor();

    boolean isInstallAppLog();

    void onApmMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void onAppLogEvent(String r100, JSONObject r101);

    void startFpsTrace(String r100, boolean r101);

    void startFpsTraceForDelayStop(String r100, boolean r101, long r102);

    void startKeepPage(String r100);

    void stopFpsTrace(String r100);
}
