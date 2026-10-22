package com.bytedance.apm.impl;

import android.content.Context;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.d;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(ff7.a r100) {
        d.a r101 = d.a();
        r101.f190465a = r100.f476661a;
        r101.f190466b = 0;
        r101.f190467c = r100.f476662b;
        r101.f190468d = null;
        r101.f190469e = null;
        r101.f190470f = r100.f476663c;
        ApmAgent.monitorEvent(new d(r101));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r100, JSONObject r101) {
        ApmAgent.monitorCommonLog(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r100, JSONObject r101) {
        ApmAgent.monitorExceptionLog(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r100, JSONObject r101) {
        ApmAgent.monitorCommonLog(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        ApmAgent.monitorDuration(r100, r101, r102);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
        ApmAgent.monitorStatusRate(r100, r101, r102);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ApmAgent.monitorEvent(r100, r101, r102, r103);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        ApmAgent.monitorStatusAndDuration(r100, r101, r102, r103);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r100, long r101, long r110, boolean r111) {
        ApmAgent.reportLegacyMonitorLog(com.bytedance.apm.d.getContext(), r101, r110, r111);
    }
}
