package com.bytedance.android.livehostapi.foundation;

import com.bytedance.android.live.base.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostCommerceMonitor extends IService {
    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void startFluencyMonitor(String r100, String r101);

    void startFpsMonitor(String r100);

    void stopFluencyMonitor(String r100, String r101);

    void stopFpsMonitor(String r100);
}
