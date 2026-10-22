package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r1, String r2) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r1, long r3, String r5, g r6) {
        g r0 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.aiagent.plugin");
    }

    public MonitorLogManagerImpl() {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return com.bytedance.apm.d.c.a.a().b();
    }
}
