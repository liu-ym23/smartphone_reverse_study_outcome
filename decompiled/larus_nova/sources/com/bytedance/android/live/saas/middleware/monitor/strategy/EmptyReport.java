package com.bytedance.android.live.saas.middleware.monitor.strategy;

import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016JH\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016J$\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016J&\u0010\u001f\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J0\u0010 \u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010$\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J$\u0010$\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016J$\u0010%\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016J$\u0010&\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016JH\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010)\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010*\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/strategy/EmptyReport;", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "()V", "ensureNotReachHere", "", "t", "", "msg", "", "monitorApiError", "duration", "", RemoteMessageConst.SEND_TIME, "sendUrl", "sendIp", "traceCode", "status", "", "extJson", "Lorg/json/JSONObject;", "monitorCommonLog", "logType", "serviceName", "extra", "monitorDebugReal", "value", "monitorDirectOnCount", "type", "key", "", "monitorDirectOnTimer", "monitorDuration", "monitorEvent", "category", "metric", "extraLog", "monitorOnCount", "monitorOnStore", "monitorOnTimer", "monitorSLA", "sendDuration", "monitorStatusAndDuration", "monitorStatusRate", "logExtra", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class EmptyReport extends IMonitorReport {
    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void ensureNotReachHere(Throwable r100, String r101) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorApiError(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r100, String r101, JSONObject r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r100) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r100, String r101) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnCount(String r100, String r101, float r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnTimer(String r100, String r101, float r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r100, String r101) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r100, String r101, float r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnStore(String r100, String r101, float r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnTimer(String r100, String r101, float r102) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorSLA(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
    }

    public EmptyReport() {
    }
}
