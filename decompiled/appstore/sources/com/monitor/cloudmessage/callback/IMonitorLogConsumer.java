package com.monitor.cloudmessage.callback;

import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMonitorLogConsumer {
    void handleLogData(long r10, long r11, String r12, IMonitorLogQueryCallback r13);

    void notifyLogDataConsumed(String r10, String r11);

    String[] parseLogType(JSONObject r10);
}
