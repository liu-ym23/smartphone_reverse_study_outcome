package com.bytedance.android.live.saas.middleware.middlelayer;

import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.d;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import wm0.b;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0007H\u0016JH\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010$\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010%\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010*\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010+\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010+\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010,\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016J$\u0010-\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020#H\u0016JH\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J,\u00100\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u00102\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u00103\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/MonitorServiceImpl;", "Lwm0/b;", "Lcom/bytedance/android/livehostapi/platform/IHostMonitor;", "monitor", "Lorg/json/JSONObject;", "extra", "generateFinalExtra", "", e.f25671s, "key", "", "status", "logExtr", "", "beforeMonitor", "duration", "", "t", "msg", "ensureNotReachHere", "serviceName", "", "isNotHitSampled", "", RemoteMessageConst.SEND_TIME, "sendUrl", "sendIp", "traceCode", "extJson", "monitorApiError", "logType", "monitorCommonLog", "value", "monitorDebugReal", "type", "", "monitorDirectOnCount", "monitorDirectOnTimer", "monitorDuration", "category", "metric", "extraLog", "monitorEvent", "monitorOnCount", "monitorOnStore", "monitorOnTimer", "sendDuration", "monitorSLA", "monitorStatusAndDuration", "logExtra", "monitorStatusRate", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "DEBUG", "Z", "getDEBUG", "()Z", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class MonitorServiceImpl implements b {
    private final boolean DEBUG;
    private final String TAG;

    public boolean isNotHitSampled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        return false;
    }

    private final IHostMonitor monitor() {
        return (IHostMonitor) BaseServices.as(IHostMonitor.class);
    }

    public MonitorServiceImpl() {
        this.TAG = LiveSlardarMonitor.TAG;
    }

    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    public final String getTAG() {
        return this.TAG;
    }

    private final JSONObject generateFinalExtra(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        r101.put("tag", "ttlive_sdk");     // Catch: JSONException -> L7
        r101.put("ttlive_sdk_version", String.valueOf(4210));     // Catch: JSONException -> L7
        if (r100 == null) goto L9;
        r101.put("extra", r100);     // Catch: JSONException -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        Logger.e(this.TAG, e.getMessage());
        goto L9
    }

    public void monitorDebugReal(String r100) {
        IHostMonitor r101 = monitor();
        if (r101 == null) goto L6;
        r101.monitorDebugReal(r100);
        return;
    }

    @Override // wm0.b
    public void ensureNotReachHere(Throwable r100, String r101) {
        d.d(r100, r101);
    }

    @Override // wm0.b
    public void monitorCommonLog(String r100, JSONObject r101) {
        if (r101 != null) goto L4;
        r101 = new JSONObject();
    L4:
        IHostMonitor r102 = monitor();
        if (r102 == null) goto L8;
        r102.monitorCommonLog(r100, r101);
        return;
    }

    public void monitorDebugReal(String r100, String r101) {
        IHostMonitor r102 = monitor();
        if (r102 == null) goto L6;
        r102.monitorDebugReal(r100, r101);
        return;
    }

    public void monitorOnCount(String r100, String r101) {
        IHostMonitor r102 = monitor();
        if (r102 == null) goto L6;
        r102.monitorOnCount(r100, r101);
        return;
    }

    @Override // wm0.b
    public void monitorCommonLog(String r100, String r101, JSONObject r102) {
        if (r102 != null) goto L14;
        r102 = new JSONObject();
    L14:
    L8:
        e = move-exception;
        Logger.e(this.TAG, e.getMessage());
    L10:
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L16;
        r103.monitorCommonLog(r100, r102);
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r102.put("service", r101);     // Catch: JSONException -> L8
        goto L10
    }

    public void monitorDirectOnCount(String r100, String r101, float r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorDirectOnCount(r100, r101, r102);
        return;
    }

    @Override // wm0.b
    public void monitorDirectOnTimer(String r100, String r101, float r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorDirectOnTimer(r100, r101, r102);
        return;
    }

    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorDuration(r100, r101, r102);
        return;
    }

    public void monitorOnCount(String r100, String r101, float r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorOnCount(r100, r101, r102);
        return;
    }

    public void monitorOnStore(String r100, String r101, float r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorOnStore(r100, r101, r102);
        return;
    }

    public void monitorOnTimer(String r100, String r101, float r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorOnTimer(r100, r101, r102);
        return;
    }

    @Override // wm0.b
    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorStatusRate(r100, r101, r102);
        return;
    }

    private final void beforeMonitor(String r100, String r101, int r102, JSONObject r110) {
        beforeMonitor(r100, r101, r102, null, r110);
    }

    @Override // wm0.b
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        IHostMonitor r104 = monitor();
        if (r104 == null) goto L6;
        r104.monitorEvent(r100, r101, r102, r103);
        return;
    }

    @Override // wm0.b
    public void monitorStatusAndDuration(String r100, int r101, JSONObject r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        JSONObject r112 = generateFinalExtra(r111);
        beforeMonitor("monitorStatusAndDuration", r100, r101, r110, r112);
        IHostMonitor r102 = monitor();
        if (r102 == null) goto L6;
        r102.monitorStatusAndDuration(r100, r101, r110, r112);
        return;
    }

    private final void beforeMonitor(String r100, String r101, int r102, JSONObject r103, JSONObject r104) {
        if (this.DEBUG == false) goto L6;
        Logger.e(this.TAG, "method = " + r100 + ",key = " + r101 + ",status = " + r102 + ",duration = " + r103 + ",logJson = " + r104);
        return;
    }

    public void monitorApiError(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r116) {
        IHostMonitor r100 = monitor();
        if (r100 == null) goto L6;
        r100.monitorApiError(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    public void monitorSLA(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r116) {
        IHostMonitor r100 = monitor();
        if (r100 == null) goto L6;
        r100.monitorSLA(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
