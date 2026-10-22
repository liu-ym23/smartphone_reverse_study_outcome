package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import java.util.List;
import n1.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    public MonitorLogManagerImpl() {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r10, String r11) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r10, long r11, String r12, IMonitorLogQueryCallback r13) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return a.b().c();
    }
}
