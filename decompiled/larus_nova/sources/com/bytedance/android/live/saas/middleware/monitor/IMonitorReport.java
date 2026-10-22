package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public abstract class IMonitorReport {
    public IMonitorReport() {
    }

    public abstract void ensureNotReachHere(Throwable r100, String r101);

    public void init(Application r100) {
    }

    public abstract void monitorApiError(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106);

    public abstract void monitorCommonLog(String r100, String r101, JSONObject r102);

    public abstract void monitorCommonLog(String r100, JSONObject r101);

    public abstract void monitorDebugReal(String r100);

    public abstract void monitorDebugReal(String r100, String r101);

    public abstract void monitorDirectOnCount(String r100, String r101, float r102);

    public abstract void monitorDirectOnTimer(String r100, String r101, float r102);

    public abstract void monitorDuration(String r100, JSONObject r101, JSONObject r102);

    public abstract void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    public abstract void monitorOnCount(String r100, String r101);

    public abstract void monitorOnCount(String r100, String r101, float r102);

    public abstract void monitorOnStore(String r100, String r101, float r102);

    public abstract void monitorOnTimer(String r100, String r101, float r102);

    public abstract void monitorSLA(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106);

    public abstract void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    public abstract void monitorStatusRate(String r100, int r101, JSONObject r102);

    public void callInit(Application r100) {
        init(r100);
    }
}
