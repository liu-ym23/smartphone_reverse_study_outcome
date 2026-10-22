package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.d;
import com.bytedance.apm.util.m;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.i;
import okhttp3.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class OkHttpEventListener extends i {
    public static final String X_TT_CONTENT_ENCODING = "x-tt-content-encoding";
    public static final String X_TT_TRACE_HOST = "x-tt-trace-host";
    public static final String X_TT_TRACE_ID = "x-tt-trace-id";
    public static final String X_TT_TRACE_TAG = "x-tt-trace-tag";
    private static String sIgnoreMonitorLabel;
    private long connectStartTime;
    private long dnsStartTime;
    private boolean needToDeal;
    private OkHttpRecord okHttpRecord;
    public i originListener;
    private long requestBodyEndTime;
    private JSONObject requestHeader;
    private long requestHeadersEndTime;
    private long requestHeadersStartTime;
    private long responseBodyStartTime;
    private JSONObject responseHeader;
    private long responseHeadersStartTime;
    private long secureConnectStartTime;
    private String url;

    private void record() {
        if (this.needToDeal == true) goto L5;
        return;
    L5:
        OkHttpRecord r100 = this.okHttpRecord;
        if (r100 != null) goto L8;
        return;
    L8:
        OkHttpRecord.TimeRequest r101 = r100.timeRequest;
        r101.duration = System.currentTimeMillis() - this.okHttpRecord.timeRequest.start_time;
        JSONObject r102 = new JSONObject(this.okHttpRecord.toString());     // Catch: JSONException -> L19
        r102.put("timing_totalSendBytes", this.okHttpRecord.recordResponse.sent_bytes);     // Catch: JSONException -> L19
        r102.put("timing_totalReceivedBytes", this.okHttpRecord.recordResponse.received_bytes);     // Catch: JSONException -> L19
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L19
        r110.put("request_log", r102);     // Catch: JSONException -> L19
        r110.put("net_consume_type", "okhttp");     // Catch: JSONException -> L19
        JSONObject r103 = this.requestHeader;     // Catch: JSONException -> L19
        String r104 = "";
        if (r103 == null) goto L13;
        String r105 = r103.toString();     // Catch: JSONException -> L19
    L14:
        r110.put("requestHeader", r105);     // Catch: JSONException -> L19
        JSONObject r106 = this.responseHeader;     // Catch: JSONException -> L19
        if (r106 == null) goto L17;
        r104 = r106.toString();     // Catch: JSONException -> L19
    L17:
        r110.put("responseHeader", r104);     // Catch: JSONException -> L19
        OkHttpRecord r107 = this.okHttpRecord;     // Catch: JSONException -> L19
        OkHttpRecord.TimeRequest r108 = r107.timeRequest;     // Catch: JSONException -> L19
        MonitorTool.monitorSLA(r108.duration, r108.start_time, this.url, r107.socketInfo.remote, "", r107.recordResponse.code, r110);     // Catch: JSONException -> L19
        return;
    L13:
        r105 = "";
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public OkHttpEventListener(i r100) {
        this.needToDeal = true;
        this.originListener = r100;
        this.okHttpRecord = new OkHttpRecord();
    }

    private void dealSpecialHeader(Response r110) {
        Iterator<String> r111 = r110.headers("server-timing").iterator();
    L4:
        if (r111.hasNext() == false) goto L80;
        String r100 = r111.next();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.okHttpRecord.headerRequest.serverTimings.add(r100);
        String[] r101 = r100.split(",");
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L4;
        String r104 = r101[r103];
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L79:
        r103 = r103 + 1;
        goto L9
    L14:
        if (r104.contains(com.alipay.sdk.m.u.i.f25853b) == false) goto L79;
        String[] r105 = r104.split(com.alipay.sdk.m.u.i.f25853b);
        if (r105.length < 2) goto L79;
        String r106 = r105[0].replace(" ", "");
        boolean r107 = true;
        String r108 = r105[1].replace(" ", "");
        if (TextUtils.isEmpty(r106) == true) goto L79;
        r106.getClass();
        byte r109 = -1;
        switch(r106.hashCode()) {
            case -1008619738: goto L35;
            case -138105374: goto L31;
            case 3108285: goto L27;
            case 100355670: goto L23;
            default: goto L39;
        };
    L23:
        if (r106.equals(RNParamRegisterEventHandler.SRC_INNER) == false) goto L39;
        r109 = 3;
        goto L39
    L27:
        if (r106.equals("edge") == false) goto L39;
        r109 = 2;
        goto L39
    L31:
        if (r106.equals("cdn-cache") == false) goto L39;
        r109 = 1;
        goto L39
    L35:
        if (r106.equals(PlayerResolution.SDKKEY.ORIGIN) == false) goto L39;
        r109 = 0;
    L39:
        switch(r109) {
            case 0: goto L71;
            case 1: goto L60;
            case 2: goto L51;
            case 3: goto L42;
            default: goto L79;
        };
    L42:
        if (TextUtils.isEmpty(r108) == true) goto L79;
        String[] r112 = r108.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r112.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r113 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r112[1]) == true) goto L48;
        int r114 = CastIntegerProtector.parseInt(r112[1]);
    L49:
        r113.inner = r114;
        goto L79
    L48:
        r114 = 0;
        goto L49
    L51:
        if (TextUtils.isEmpty(r108) == true) goto L79;
        String[] r115 = r108.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r115.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r116 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r115[1]) == true) goto L57;
        int r117 = CastIntegerProtector.parseInt(r115[1]);
    L58:
        r116.edge = r117;
        goto L79
    L57:
        r117 = 0;
        goto L58
    L60:
        if (TextUtils.isEmpty(r108) == true) goto L79;
        String[] r118 = r108.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r118.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r119 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r118[1]) == false) goto L66;
    L68:
        r107 = false;
    L69:
        r119.cdn_hit_cache = r107;
        goto L79
    L66:
        if (r118[1].equalsIgnoreCase(BaseHttpRequestInfo.KEY_HIT) == false) goto L68;
    L71:
        if (TextUtils.isEmpty(r108) == true) goto L79;
        String[] r120 = r108.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r120.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r121 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r120[1]) == true) goto L77;
        int r122 = CastIntegerProtector.parseInt(r120[1]);
    L78:
        r121.origin = r122;
        goto L79
    L77:
        r122 = 0;
        goto L78
    L7:
        return;
    L80:
        OkHttpRecord.DetailedDuration r123 = this.okHttpRecord.timeDetailedDuration;
        int r124 = r123.ttfb - r123.edge;
        int r125 = r123.origin;
        int r126 = r124 - r125;
        if (r126 <= 0) goto L83;
        r123.rtt = r126;
    L83:
        int r127 = r125 - r123.inner;
        if (r127 <= 0) goto L92;
        r123.origin = r127;
        return;
    }

    private JSONObject getHeaders(Headers r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L18;
    L15:
        return r101;
    L18:
        Iterator<String> r102 = r100.names().iterator();     // Catch: Exception -> L13
    L5:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: Exception -> L13
        r101.put(r103, r100.get(r103));     // Catch: JSONException -> L10 Exception -> L13
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static void setIgnoreMonitorLabel(String r100) {
        sIgnoreMonitorLabel = r100;
    }

    @Override // okhttp3.i
    public void callEnd(Call r100) {
        super.callEnd(r100);
        i r101 = this.originListener;
        if (r101 == null) goto L5;
        r101.callEnd(r100);
    L5:
        record();
    }

    @Override // okhttp3.i
    public void callStart(Call r100) {
        super.callStart(r100);
        i r101 = this.originListener;
        if (r101 == null) goto L6;
        r101.callStart(r100);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord.TimeRequest r102 = this.okHttpRecord.timeRequest;
        r102.start_time = System.currentTimeMillis();
        return;
    }

    @Override // okhttp3.i
    public void requestBodyStart(Call r100) {
        super.requestBodyStart(r100);
        i r101 = this.originListener;
        if (r101 == null) goto L6;
        r101.requestBodyStart(r100);
        return;
    }

    @Override // okhttp3.i
    public void requestHeadersStart(Call r100) {
        super.requestHeadersStart(r100);
        if (this.needToDeal == false) goto L5;
        long r101 = System.currentTimeMillis();
        this.requestHeadersStartTime = r101;
        this.okHttpRecord.timeRequest.request_sent_time = r101;
    L5:
        i r102 = this.originListener;
        if (r102 == null) goto L9;
        r102.requestHeadersStart(r100);
        return;
    }

    @Override // okhttp3.i
    public void responseBodyStart(Call r100) {
        super.responseBodyStart(r100);
        if (this.needToDeal == false) goto L5;
        this.responseBodyStartTime = System.currentTimeMillis();
    L5:
        i r101 = this.originListener;
        if (r101 == null) goto L9;
        r101.responseBodyStart(r100);
        return;
    }

    @Override // okhttp3.i
    public void responseHeadersStart(Call r100) {
        super.responseHeadersStart(r100);
        if (this.needToDeal == false) goto L9;
        this.responseHeadersStartTime = System.currentTimeMillis();
        if (this.requestBodyEndTime == 0) goto L7;
        long r101 = System.currentTimeMillis();
        long r102 = this.requestBodyEndTime;
    L8:
        long r103 = r101 - r102;
        OkHttpRecord r104 = this.okHttpRecord;
        int r105 = (int) r103;
        r104.timeDetailedDuration.ttfb = r105;
        OkHttpRecord.TimeRequest r106 = r104.timeRequest;
        r106.response_recv_time = System.currentTimeMillis();
        goto L9
    L7:
        r101 = System.currentTimeMillis();
        r102 = this.requestHeadersEndTime;
    L9:
        i r107 = this.originListener;
        if (r107 == null) goto L13;
        r107.responseHeadersStart(r100);
        return;
    }

    @Override // okhttp3.i
    public void secureConnectStart(Call r100) {
        super.secureConnectStart(r100);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r101 = this.okHttpRecord.timeDetailedDuration;
        r101.tcp = (int) (System.currentTimeMillis() - this.connectStartTime);
        this.secureConnectStartTime = System.currentTimeMillis();
    L5:
        i r102 = this.originListener;
        if (r102 == null) goto L9;
        r102.secureConnectStart(r100);
        return;
    }

    @Override // okhttp3.i
    public void callFailed(Call r100, IOException r101) {
        super.callFailed(r100, r101);
        i r102 = this.originListener;
        if (r102 == null) goto L5;
        r102.callFailed(r100, r101);
    L5:
        record();
    }

    @Override // okhttp3.i
    public void connectionAcquired(Call r100, Connection r101) {
        super.connectionAcquired(r100, r101);
        i r102 = this.originListener;
        if (r102 == null) goto L6;
        r102.connectionAcquired(r100, r101);
    L6:
        if (this.needToDeal == true) goto L8;
        return;
    L8:
        if (this.dnsStartTime != 0) goto L10;
        this.okHttpRecord.socketInfo.socketReused = true;
        return;
    L10:
        this.okHttpRecord.socketInfo.socketReused = false;
    }

    @Override // okhttp3.i
    public void connectionReleased(Call r100, Connection r101) {
        super.connectionReleased(r100, r101);
        i r102 = this.originListener;
        if (r102 == null) goto L6;
        r102.connectionReleased(r100, r101);
        return;
    }

    @Override // okhttp3.i
    public void dnsStart(Call r100, String r101) {
        super.dnsStart(r100, r101);
        if (this.needToDeal == false) goto L5;
        this.dnsStartTime = System.currentTimeMillis();
    L5:
        i r102 = this.originListener;
        if (r102 == null) goto L9;
        r102.dnsStart(r100, r101);
        return;
    }

    @Override // okhttp3.i
    public void requestBodyEnd(Call r100, long r101) {
        super.requestBodyEnd(r100, r101);
        if (this.needToDeal == false) goto L5;
        this.requestBodyEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        i r102 = this.originListener;
        if (r102 == null) goto L9;
        r102.requestBodyEnd(r100, r101);
    L9:
        if (this.needToDeal == false) goto L12;
        this.okHttpRecord.recordResponse.sent_bytes += r101;
        return;
    }

    @Override // okhttp3.i
    public void requestHeadersEnd(Call r100, Request r101) {
        super.requestHeadersEnd(r100, r101);
        if (this.needToDeal == false) goto L5;
        this.requestHeadersEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        i r102 = this.originListener;
        if (r102 == null) goto L8;
        r102.requestHeadersEnd(r100, r101);
    L8:
        String r103 = r101.header("User-Agent");
        String r104 = sIgnoreMonitorLabel;
        if (r104 == null) goto L15;
        if (r103 == null) goto L15;
        if (r103.contains(r104) == false) goto L15;
        this.needToDeal = false;
    L15:
        if (this.needToDeal == false) goto L18;
        this.okHttpRecord.recordResponse.sent_bytes += r101.headers().byteCount();
        this.url = r101.url().toString();
        this.requestHeader = getHeaders(r101.headers());
        return;
    }

    @Override // okhttp3.i
    public void responseBodyEnd(Call r100, long r101) {
        super.responseBodyEnd(r100, r101);
        i r102 = this.originListener;
        if (r102 == null) goto L6;
        r102.responseBodyEnd(r100, r101);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord r103 = this.okHttpRecord;
        r103.recordResponse.received_bytes += r101;
        r103.timeDetailedDuration.body_recv = (int) (System.currentTimeMillis() - this.responseBodyStartTime);
        return;
    }

    @Override // okhttp3.i
    public void responseHeadersEnd(Call r100, Response r101) {
        super.responseHeadersEnd(r100, r101);
        i r102 = this.originListener;
        if (r102 == null) goto L6;
        r102.responseHeadersEnd(r100, r101);
    L6:
        if (this.needToDeal == false) goto L14;
        this.okHttpRecord.timeDetailedDuration.header_recv = (int) (System.currentTimeMillis() - this.responseHeadersStartTime);
        this.okHttpRecord.recordResponse.code = r101.code();
        this.okHttpRecord.recordResponse.received_bytes += r101.headers().byteCount();
        this.okHttpRecord.recordResponse.network_accessed = m.b(d.getContext());
        this.okHttpRecord.headerRequest.x_tt_trace_id = r101.header(X_TT_TRACE_ID, "");
        this.okHttpRecord.headerRequest.x_tt_trace_host = r101.header(X_TT_TRACE_HOST, "");
        this.okHttpRecord.headerRequest.x_tt_trace_tag = r101.header(X_TT_TRACE_TAG, "");
        this.okHttpRecord.headerRequest.x_tt_content_encoding = r101.header(X_TT_CONTENT_ENCODING, "");
        dealSpecialHeader(r101);     // Catch: Exception -> L11
    L9:
        this.responseHeader = getHeaders(r101.headers());
        return;
    }

    @Override // okhttp3.i
    public void secureConnectEnd(Call r100, j r101) {
        super.secureConnectEnd(r100, r101);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r102 = this.okHttpRecord.timeDetailedDuration;
        r102.ssl = (int) (System.currentTimeMillis() - this.secureConnectStartTime);
    L5:
        i r103 = this.originListener;
        if (r103 == null) goto L9;
        r103.secureConnectEnd(r100, r101);
        return;
    }

    @Override // okhttp3.i
    public void connectStart(Call r100, InetSocketAddress r101, Proxy r102) {
        super.connectStart(r100, r101, r102);
        if (this.needToDeal == false) goto L5;
        this.connectStartTime = System.currentTimeMillis();
    L5:
        i r103 = this.originListener;
        if (r103 == null) goto L9;
        r103.connectStart(r100, r101, r102);
        return;
    }

    @Override // okhttp3.i
    public void dnsEnd(Call r100, String r101, List<InetAddress> r102) {
        super.dnsEnd(r100, r101, r102);
        i r103 = this.originListener;
        if (r103 == null) goto L6;
        r103.dnsEnd(r100, r101, r102);
    L6:
        if (this.needToDeal == false) goto L15;
        OkHttpRecord.DetailedDuration r104 = this.okHttpRecord.timeDetailedDuration;
        r104.dns = (int) (System.currentTimeMillis() - this.dnsStartTime);
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.size() <= 0) goto L18;
        Iterator<InetAddress> r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        InetAddress r106 = r105.next();
        OkHttpRecord.DnsInfo r107 = new OkHttpRecord.DnsInfo();
        r107.address = r106.getHostAddress();
        this.okHttpRecord.addressList.add(r107);
        goto L13
    L19:
        return;
    L18:
        return;
    }

    @Override // okhttp3.i
    public void connectEnd(Call r100, InetSocketAddress r101, Proxy r102, Protocol r103) {
        super.connectEnd(r100, r101, r102, r103);
        i r104 = this.originListener;
        if (r104 == null) goto L6;
        r104.connectEnd(r100, r101, r102, r103);
    L6:
        if (this.needToDeal == false) goto L17;
        OkHttpRecord.RecordResponse r105 = this.okHttpRecord.recordResponse;
        if (r102.address() == null) goto L10;
        boolean r106 = true;
    L11:
        r105.via_Proxy = r106;
        if (r101 != null) goto L14;
        return;
    L14:
        if (r101.getAddress() == null) goto L19;
        this.okHttpRecord.socketInfo.remote = r101.getAddress().getHostAddress() + ":" + r101.getPort();
        this.okHttpRecord.socketInfo.host = r101.getAddress().getHostAddress();
        this.okHttpRecord.socketInfo.port = r101.getPort() + "";
        return;
    L19:
        return;
    L10:
        r106 = false;
        goto L11
    }

    @Override // okhttp3.i
    public void connectFailed(Call r100, InetSocketAddress r101, Proxy r102, Protocol r110, IOException r111) {
        super.connectFailed(r100, r101, r102, r110, r111);
        i r103 = this.originListener;
        if (r103 == null) goto L6;
        r103.connectFailed(r100, r101, r102, r110, r111);
        return;
    }
}
