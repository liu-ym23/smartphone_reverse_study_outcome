package com.slardaros.client.monitor.network.httpurlconnection;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.obric.olog.OLog;
import com.slardaros.client.Constants;
import com.slardaros.client.SlardarAgent;
import com.slardaros.client.monitor.Util;
import com.slardaros.client.monitor.network.NetUtil;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MonitorRecorder {
    private static final String TAG = "MonitorRecorder";

    public static void reportExceptionMonitor(TransactionState r0, Exception r1) {
    }

    public MonitorRecorder() {
    }

    public static void recordRequest(Request r2, TransactionState r3) {
        if (r2 == null) goto L22;
        if (r3 == null) goto L26;
        r3.addAssistData("NetworkLib", "OkHttp3");
        r3.setUrl(r2.url().toString());
        r3.setMethod(r2.method());
        r3.setStartTime(System.currentTimeMillis());
        r3.setCarrier("");
        r3.setWanType("");
        RequestBody r4 = r2.body();
        if (r4 == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        if ((r4 instanceof FormBody) == false) goto L14;
        r3.setBytesSent(((FormBody) r4).contentLength());
        return;
    L14:
        if ((r4 instanceof MultipartBody) == false) goto L25;
        r3.setBytesSent(r4.contentLength());     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        Log.d("TransactionData:", "can not get MultipartBody content length", e);
        return;
    L25:
        return;
    L8:
        r0 = false;
        goto L9
    L26:
        return;
    }

    public static void recordResponse(Response r2, TransactionState r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L11;
        r3.setStatusCode(r2.code());
        if (r2.body() == null) goto L10;
        r3.setBytesReceived(r2.body().contentLength());
        return;
    L10:
        return;
    L11:
        return;
    }

    public static void reportMonitorData(TransactionState r0, Response r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        reportMonitorData(r0, "okhttp");
        return;
    L8:
        return;
    }

    public static void reportMonitorData(TransactionState r6, String r7) {
        if (r6 != null) goto L5;
        return;
    L5:
        TransactionData r0 = r6.end();
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L17
        String r2 = r0.getUrl();     // Catch: Exception -> L17
        String r8 = r2.replace("http://", "").replace("https://", "");     // Catch: Exception -> L17
        int r3 = r8.indexOf(47);     // Catch: Exception -> L17
        boolean r5 = false;
        if (r3 == (-1)) goto L9;
        r8 = r8.substring(0, r3);     // Catch: Exception -> L17
    L9:
        r1.put("original_host", r8);     // Catch: Exception -> L17
        r1.put("host", r8);     // Catch: Exception -> L17
        r1.put("original_url", r2);     // Catch: Exception -> L17
        r1.put("url", r2);     // Catch: Exception -> L17
        r1.put("protocol", NetUtil.getProtocol(r2));     // Catch: Exception -> L17
        r1.put("status_code", r0.getStatusCode());     // Catch: Exception -> L17
        r1.put("net_error", r0.getErrorCode());     // Catch: Exception -> L17
        r1.put("is_background", r6.getIsBackground());     // Catch: Exception -> L17
        if (r6.getException() != null) goto L12;
        r5 = true;
    L12:
        r1.put("request_success", r5);     // Catch: Exception -> L17
        r1.put("network_type", NetUtil.getNetworkType(SlardarAgent.getContext()));     // Catch: Exception -> L17
        r1.put("network_lib", "httpurlconnection");     // Catch: Exception -> L17
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L17
        r9.put("duration", r0.getTotalTime());     // Catch: Exception -> L17
        r9.put(ICronetClient.KEY_TOTAL_TIME, r0.getTotalTime());     // Catch: Exception -> L17
        r9.put("send_bytes", r0.getBytesSent());     // Catch: Exception -> L17
        r9.put("received_bytes", r0.getBytesReceived());     // Catch: Exception -> L17
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L17
        if (r6.getException() == null) goto L15;
        r4.put("exception", r6.getException().getMessage());     // Catch: Exception -> L17
    L15:
        Util.sendMetricEvent(Constants.METRIC_EVENT_NETWORK, r1, r9, r4);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        OLog.e(TAG, e.getMessage());
    }
}
