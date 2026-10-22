package com.bytedance.apm.impl;

import android.content.Context;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.services.apm.api.EventConfig;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        ApmAgent.monitorEvent(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r1, JSONObject r2) {
        ApmAgent.monitorCommonLog(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r1, int r2, JSONObject r3) {
        ApmAgent.monitorStatusRate(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(EventConfig r2) {
        ApmAgent.monitorEvent(com.bytedance.apm.config.EventConfig.builder().setServiceName(r2.getServiceName()).setStatus(r2.getStatus()).setCategory(r2.getCategory()).setMetric(r2.getMetric()).setExtraLog(r2.getExtraLog()).isUploadImmediate(r2.isUploadImmediate()).build());
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r1, JSONObject r2, JSONObject r3) {
        ApmAgent.monitorDuration(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4) {
        ApmAgent.monitorStatusAndDuration(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r1, JSONObject r2) {
        ApmAgent.monitorCommonLog(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r1, JSONObject r2) {
        ApmAgent.monitorExceptionLog(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r7, long r8, long r10, boolean r12) {
        ApmAgent.reportLegacyMonitorLog(ApmContext.getContext(), r8, r10, r12);
    }
}
