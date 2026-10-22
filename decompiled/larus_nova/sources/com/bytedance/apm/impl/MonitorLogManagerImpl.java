package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.IMonitorLogManager;
import ff7.f;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    public MonitorLogManagerImpl() {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r100, String r101) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r100, long r101, String r102, f r103) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return ks3.a.a().f505906a.f16222a;
    }
}
