package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.util.Log;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionData;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TrafficConsts;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.g;
import okhttp3.h;
import org.json.JSONObject;
import s1.b;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class MonitorRecorder {
    private static final String TAG = "MonitorRecorder";

    public MonitorRecorder() {
    }

    public static void recordRequest(Request r10, TransactionState r11) {
        if (r10 == null) goto L19;
        if (r11 == null) goto L23;
        r11.addAssistData("NetworkLib", "OkHttp3");
        r11.setUrl(r10.k().toString());
        r11.setMethod(r10.g());
        r11.setStartTime(System.currentTimeMillis());
        r11.setCarrier("");
        r11.setWanType("");
        RequestBody r12 = r10.a();
        if (r12 != null) goto L8;
        return;
    L8:
        if ((r12 instanceof g) == false) goto L11;
        r11.setBytesSent(((g) r12).a());
        return;
    L11:
        if ((r12 instanceof h) == false) goto L22;
        r11.setBytesSent(r12.a());     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        Log.d("TransactionData:", "can not get MultipartBody content length", e);
        return;
    L22:
        return;
    L23:
        return;
    }

    public static void recordResponse(Response r10, TransactionState r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L11;
        r11.setStatusCode(r10.d());
        if (r10.a() == null) goto L10;
        r11.setBytesReceived(r10.a().contentLength());
        return;
    L10:
        return;
    L11:
        return;
    }

    public static void reportExceptionMonitor(TransactionState r10, Exception r11) {
    }

    public static void reportMonitorData(TransactionState r10, Response r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        reportMonitorData(r10, TrafficConsts.NET_CONSUME_TYPE_OK);
        return;
    L8:
        return;
    }

    public static void reportMonitorData(TransactionState r13, String r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        TransactionData r10 = r13.end();
        if (c.B() == false) goto L18;
        s1.c.d(b.f24486d, new String[]{"auto plugin, reportMonitorData: " + r10.toString()});
    L18:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L11
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L11
        r12.put("sent_bytes", r10.getBytesSent());     // Catch: Exception -> L11
        r12.put("received_bytes", r10.getBytesReceived());     // Catch: Exception -> L11
        r11.put("response", r12);     // Catch: Exception -> L11
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L11
        r15.put("request_log", r11);     // Catch: Exception -> L11
        r15.put(TrafficConsts.KEY_NET_CONSUME_TYPE, r14);     // Catch: Exception -> L11
        long r16 = r10.getTotalTime();     // Catch: Exception -> L11
        if (r13.getStartTime() != 0) goto L13;
        long r17 = r10.getRequestStart();     // Catch: Exception -> L11
    L14:
        MonitorTool.monitorSLA(r16, r17, r10.getUrl(), "", "", r10.getStatusCode(), r15);     // Catch: Exception -> L11
        return;
    L13:
        r17 = r13.getStartTime();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
