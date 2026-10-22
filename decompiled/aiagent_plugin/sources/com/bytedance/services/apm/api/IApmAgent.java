package com.bytedance.services.apm.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IApmAgent extends IService {
    void monitorCommonLog(String r1, JSONObject r2);

    @Deprecated
    void monitorDuration(String r1, JSONObject r2, JSONObject r3);

    void monitorEvent(b r1);

    void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void monitorExceptionLog(String r1, JSONObject r2);

    @Deprecated
    void monitorLog(String r1, JSONObject r2);

    @Deprecated
    void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4);

    @Deprecated
    void monitorStatusRate(String r1, int r2, JSONObject r3);

    void reportLegacyMonitorLog(Context r1, long r2, long r4, boolean r6);
}
