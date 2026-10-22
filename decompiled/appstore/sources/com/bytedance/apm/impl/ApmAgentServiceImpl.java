package com.bytedance.apm.impl;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.apm.ApmAgent;
import com.bytedance.services.apm.api.IApmAgent;
import h1.d;
import i6.b;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r10, JSONObject r11) {
        ApmAgent.e(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r10, JSONObject r11, JSONObject r12) {
        ApmAgent.g(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        ApmAgent.h(r10, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r10, JSONObject r11) {
        ApmAgent.i(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r10, JSONObject r11) {
        ApmAgent.e(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r10, int r11, JSONObject r12, JSONObject r13) {
        ApmAgent.k(r10, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r10, int r11, JSONObject r12) {
        ApmAgent.l(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r10, long r11, long r12, boolean r13) {
        ApmAgent.q(c.g(), r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(b r10) {
        ApmAgent.monitorEvent(d.a().l(r10.d()).m(r10.e()).i(r10.a()).k(r10.c()).j(r10.b()).h(r10.f()).g());
    }
}
