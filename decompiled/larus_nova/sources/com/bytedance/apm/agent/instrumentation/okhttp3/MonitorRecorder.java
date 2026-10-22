package com.bytedance.apm.agent.instrumentation.okhttp3;

import com.bytedance.apm.agent.instrumentation.transaction.TransactionData;
import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.d;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.k;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: classes14.dex */
public class MonitorRecorder {
    private static final String TAG = "MonitorRecorder";

    public MonitorRecorder() {
    }

    public static void reportExceptionMonitor(TxState r100, Exception r101) {
    }

    public static void recordRequest(Request r100, TxState r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L24;
        r101.addAssistData("NetworkLib", "OkHttp3");
        r101.setUrl(r100.url().toString());
        r101.setMethod(r100.method());
        r101.setStartTime(System.currentTimeMillis());
        r101.setCarrier("");
        r101.setWanType("");
        RequestBody r102 = r100.body();
        if (r102 == null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        return;
    L11:
        if ((r102 instanceof FormBody) == false) goto L14;
        r101.setBytesSent(((FormBody) r102).contentLength());
        return;
    L14:
        if ((r102 instanceof k) == false) goto L23;
        r101.setBytesSent(r102.contentLength());     // Catch: IOException -> L17
        return;
    L25:
        return;
    L23:
        return;
    L8:
        r103 = false;
        goto L9
    L24:
        return;
    }

    public static void recordResponse(Response r100, TxState r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L11;
        r101.setStatusCode(r100.code());
        if (r100.body() == null) goto L10;
        r101.setBytesReceived(r100.body().contentLength());
        return;
    L10:
        return;
    L11:
        return;
    }

    public static void reportMonitorData(TxState r110, String r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        TransactionData r100 = r110.end();
        if (d.j() == false) goto L16;
        b.a(new String[]{"auto plugin, reportMonitorData: " + r100.toString()});
    L16:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L13
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L13
        r102.put(StreamTrafficObservable.STREAM_SENTBYTES, r100.getBytesSent());     // Catch: Exception -> L13
        r102.put(StreamTrafficObservable.STREAM_RECEIVEDBYTES, r100.getBytesReceived());     // Catch: Exception -> L13
        r101.put("response", r102);     // Catch: Exception -> L13
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L13
        r112.put("request_log", r101);     // Catch: Exception -> L13
        r112.put("net_consume_type", r111);     // Catch: Exception -> L13
        long r103 = r100.getTotalTime();     // Catch: Exception -> L13
        if (r110.getStartTime() != 0) goto L10;
        long r113 = r100.getRequestStart();     // Catch: Exception -> L13
    L11:
        MonitorTool.monitorSLA(r103, r113, r100.getUrl(), "", "", r100.getStatusCode(), r112);     // Catch: Exception -> L13
        return;
    L10:
        r113 = r110.getStartTime();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static void reportMonitorData(TxState r100, Response r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        reportMonitorData(r100, "okhttp");
        return;
    L8:
        return;
    }
}
