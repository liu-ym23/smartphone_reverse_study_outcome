package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.util.k;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpEventListener extends EventListener {
    public static final String X_TT_CONTENT_ENCODING = "x-tt-content-encoding";
    public static final String X_TT_TRACE_HOST = "x-tt-trace-host";
    public static final String X_TT_TRACE_ID = "x-tt-trace-id";
    public static final String X_TT_TRACE_TAG = "x-tt-trace-tag";
    private static String sIgnoreMonitorLabel;
    private long connectStartTime;
    private long dnsStartTime;
    private boolean needToDeal;
    private OkHttpRecord okHttpRecord;
    public EventListener originListener;
    private long requestBodyEndTime;
    private JSONObject requestHeader;
    private long requestHeadersEndTime;
    private long requestHeadersStartTime;
    private long responseBodyStartTime;
    private JSONObject responseHeader;
    private long responseHeadersStartTime;
    private long secureConnectStartTime;
    private String url;

    public OkHttpEventListener(EventListener r10) {
        this.needToDeal = true;
        this.originListener = r10;
        this.okHttpRecord = new OkHttpRecord();
    }

    private void dealSpecialHeader(Response r12) {
        Iterator r13 = r12.h("server-timing").iterator();
    L4:
        if (r13.hasNext() == false) goto L79;
        String r10 = (String) r13.next();
        if (TextUtils.isEmpty(r10) == true) goto L7;
        this.okHttpRecord.headerRequest.serverTimings.add(r10);
        String[] r11 = r10.split(",");
        int r14 = r11.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L4;
        String r16 = r11[r15];
        if (TextUtils.isEmpty(r16) == false) goto L14;
    L78:
        r15 = r15 + 1;
        goto L9
    L14:
        if (r16.contains(";") == false) goto L78;
        String[] r17 = r16.split(";");
        if (r17.length < 2) goto L78;
        String r18 = r17[0].replace(" ", "");
        String r19 = r17[1].replace(" ", "");
        if (TextUtils.isEmpty(r18) == true) goto L78;
        r18.hashCode();
        byte r20 = -1;
        switch(r18.hashCode()) {
            case -1008619738: goto L35;
            case -138105374: goto L31;
            case 3108285: goto L27;
            case 100355670: goto L23;
            default: goto L38;
        };
    L38:
        switch(r20) {
            case 0: goto L70;
            case 1: goto L59;
            case 2: goto L50;
            case 3: goto L41;
            default: goto L78;
        };
    L41:
        if (TextUtils.isEmpty(r19) == true) goto L78;
        String[] r21 = r19.split("=");
        if (r21.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r22 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r21[1]) == true) goto L47;
        int r23 = Integer.parseInt(r21[1]);
    L48:
        r22.inner = r23;
        goto L78
    L47:
        r23 = 0;
        goto L48
    L50:
        if (TextUtils.isEmpty(r19) == true) goto L78;
        String[] r24 = r19.split("=");
        if (r24.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r25 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r24[1]) == true) goto L56;
        int r26 = Integer.parseInt(r24[1]);
    L57:
        r25.edge = r26;
        goto L78
    L56:
        r26 = 0;
        goto L57
    L59:
        if (TextUtils.isEmpty(r19) == true) goto L78;
        String[] r27 = r19.split("=");
        if (r27.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r28 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r27[1]) == false) goto L65;
    L67:
        boolean r29 = false;
    L68:
        r28.cdn_hit_cache = r29;
        goto L78
    L65:
        if (r27[1].equalsIgnoreCase("hit") == false) goto L67;
        r29 = true;
        goto L68
    L70:
        if (TextUtils.isEmpty(r19) == true) goto L78;
        String[] r30 = r19.split("=");
        if (r30.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r31 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r30[1]) == true) goto L76;
        int r32 = Integer.parseInt(r30[1]);
    L77:
        r31.origin = r32;
        goto L78
    L76:
        r32 = 0;
        goto L77
    L23:
        if (r18.equals("inner") == false) goto L38;
        r20 = 3;
        goto L38
    L27:
        if (r18.equals("edge") == false) goto L38;
        r20 = 2;
        goto L38
    L31:
        if (r18.equals("cdn-cache") == false) goto L38;
        r20 = 1;
        goto L38
    L35:
        if (r18.equals(HttpHeaders.ReferrerPolicyValues.ORIGIN) == false) goto L38;
        r20 = 0;
        goto L38
    L7:
        return;
    L79:
        OkHttpRecord.DetailedDuration r110 = this.okHttpRecord.timeDetailedDuration;
        int r111 = r110.ttfb - r110.edge;
        int r33 = r110.origin;
        int r112 = r111 - r33;
        if (r112 <= 0) goto L82;
        r110.rtt = r112;
    L82:
        int r34 = r33 - r110.inner;
        if (r34 <= 0) goto L91;
        r110.origin = r34;
        return;
    }

    private JSONObject getHeaders(Headers r10) {
        JSONObject r11 = new JSONObject();
        if (r10 != null) goto L19;
    L16:
        return r11;
    L19:
        Iterator r12 = r10.e().iterator();     // Catch: Exception -> L10
    L5:
        if (r12.hasNext() == false) goto L16;
        String r13 = (String) r12.next();     // Catch: Exception -> L10
        r11.put(r13, r10.b(r13));     // Catch: Exception -> L10 JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void record() {
        if (this.needToDeal == true) goto L5;
        return;
    L5:
        OkHttpRecord r10 = this.okHttpRecord;
        if (r10 != null) goto L8;
        return;
    L8:
        OkHttpRecord.TimeRequest r11 = r10.timeRequest;
        r11.duration = System.currentTimeMillis() - this.okHttpRecord.timeRequest.start_time;
        JSONObject r12 = new JSONObject(this.okHttpRecord.toString());     // Catch: JSONException -> L13
        r12.put(TrafficConsts.KEY_SENT_BYTES, this.okHttpRecord.recordResponse.sent_bytes);     // Catch: JSONException -> L13
        r12.put(TrafficConsts.KEY_RECEIVED_BYTES, this.okHttpRecord.recordResponse.received_bytes);     // Catch: JSONException -> L13
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L13
        r13.put("request_log", r12);     // Catch: JSONException -> L13
        r13.put(TrafficConsts.KEY_NET_CONSUME_TYPE, TrafficConsts.NET_CONSUME_TYPE_OK);     // Catch: JSONException -> L13
        JSONObject r14 = this.requestHeader;     // Catch: JSONException -> L13
        String r15 = "";
        if (r14 == null) goto L15;
        String r16 = r14.toString();     // Catch: JSONException -> L13
    L16:
        r13.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, r16);     // Catch: JSONException -> L13
        JSONObject r17 = this.responseHeader;     // Catch: JSONException -> L13
        if (r17 == null) goto L19;
        r15 = r17.toString();     // Catch: JSONException -> L13
    L19:
        r13.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, r15);     // Catch: JSONException -> L13
        OkHttpRecord r18 = this.okHttpRecord;     // Catch: JSONException -> L13
        OkHttpRecord.TimeRequest r19 = r18.timeRequest;     // Catch: JSONException -> L13
        MonitorTool.monitorSLA(r19.duration, r19.start_time, this.url, r18.socketInfo.remote, "", r18.recordResponse.code, r13);     // Catch: JSONException -> L13
        return;
    L15:
        r16 = "";
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setIgnoreMonitorLabel(String r10) {
        sIgnoreMonitorLabel = r10;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call r10) {
        super.callEnd(r10);
        EventListener r11 = this.originListener;
        if (r11 == null) goto L5;
        r11.callEnd(r10);
    L5:
        record();
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call r10, IOException r11) {
        super.callFailed(r10, r11);
        EventListener r12 = this.originListener;
        if (r12 == null) goto L5;
        r12.callFailed(r10, r11);
    L5:
        record();
    }

    @Override // okhttp3.EventListener
    public void callStart(Call r10) {
        super.callStart(r10);
        EventListener r11 = this.originListener;
        if (r11 == null) goto L6;
        r11.callStart(r10);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord.TimeRequest r12 = this.okHttpRecord.timeRequest;
        r12.start_time = System.currentTimeMillis();
        return;
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call r10, InetSocketAddress r11, Proxy r12, @Nullable Protocol r13) {
        super.connectEnd(r10, r11, r12, r13);
        EventListener r14 = this.originListener;
        if (r14 == null) goto L6;
        r14.connectEnd(r10, r11, r12, r13);
    L6:
        if (this.needToDeal == false) goto L17;
        OkHttpRecord.RecordResponse r15 = this.okHttpRecord.recordResponse;
        if (r12.address() == null) goto L10;
        boolean r16 = true;
    L11:
        r15.via_Proxy = r16;
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.getAddress() == null) goto L19;
        this.okHttpRecord.socketInfo.remote = r11.getAddress().getHostAddress() + ":" + r11.getPort();
        this.okHttpRecord.socketInfo.host = r11.getAddress().getHostAddress();
        this.okHttpRecord.socketInfo.port = r11.getPort() + "";
        return;
    L19:
        return;
    L10:
        r16 = false;
        goto L11
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call r10, InetSocketAddress r11, Proxy r12, @Nullable Protocol r13, IOException r14) {
        super.connectFailed(r10, r11, r12, r13, r14);
        EventListener r15 = this.originListener;
        if (r15 == null) goto L6;
        r15.connectFailed(r10, r11, r12, r13, r14);
        return;
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call r10, InetSocketAddress r11, Proxy r12) {
        super.connectStart(r10, r11, r12);
        if (this.needToDeal == false) goto L5;
        this.connectStartTime = System.currentTimeMillis();
    L5:
        EventListener r13 = this.originListener;
        if (r13 == null) goto L9;
        r13.connectStart(r10, r11, r12);
        return;
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call r10, Connection r11) {
        super.connectionAcquired(r10, r11);
        EventListener r12 = this.originListener;
        if (r12 == null) goto L6;
        r12.connectionAcquired(r10, r11);
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

    @Override // okhttp3.EventListener
    public void connectionReleased(Call r10, Connection r11) {
        super.connectionReleased(r10, r11);
        EventListener r12 = this.originListener;
        if (r12 == null) goto L6;
        r12.connectionReleased(r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call r10, String r11, List<InetAddress> r12) {
        super.dnsEnd(r10, r11, r12);
        EventListener r13 = this.originListener;
        if (r13 == null) goto L6;
        r13.dnsEnd(r10, r11, r12);
    L6:
        if (this.needToDeal == false) goto L15;
        OkHttpRecord.DetailedDuration r14 = this.okHttpRecord.timeDetailedDuration;
        r14.dns = (int) (System.currentTimeMillis() - this.dnsStartTime);
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.size() <= 0) goto L18;
        Iterator<InetAddress> r15 = r12.iterator();
    L13:
        if (r15.hasNext() == false) goto L19;
        InetAddress r16 = r15.next();
        OkHttpRecord.DnsInfo r17 = new OkHttpRecord.DnsInfo();
        r17.address = r16.getHostAddress();
        this.okHttpRecord.addressList.add(r17);
        goto L13
    L19:
        return;
    L18:
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call r10, String r11) {
        super.dnsStart(r10, r11);
        if (this.needToDeal == false) goto L5;
        this.dnsStartTime = System.currentTimeMillis();
    L5:
        EventListener r12 = this.originListener;
        if (r12 == null) goto L9;
        r12.dnsStart(r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call r10, long r11) {
        super.requestBodyEnd(r10, r11);
        if (this.needToDeal == false) goto L5;
        this.requestBodyEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        EventListener r12 = this.originListener;
        if (r12 == null) goto L9;
        r12.requestBodyEnd(r10, r11);
    L9:
        if (this.needToDeal == false) goto L12;
        this.okHttpRecord.recordResponse.sent_bytes += r11;
        return;
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call r10) {
        super.requestBodyStart(r10);
        EventListener r11 = this.originListener;
        if (r11 == null) goto L6;
        r11.requestBodyStart(r10);
        return;
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call r10, Request r11) {
        super.requestHeadersEnd(r10, r11);
        if (this.needToDeal == false) goto L5;
        this.requestHeadersEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        EventListener r12 = this.originListener;
        if (r12 == null) goto L8;
        r12.requestHeadersEnd(r10, r11);
    L8:
        String r13 = r11.c("User-Agent");
        String r14 = sIgnoreMonitorLabel;
        if (r14 == null) goto L15;
        if (r13 == null) goto L15;
        if (r13.contains(r14) == false) goto L15;
        this.needToDeal = false;
    L15:
        if (this.needToDeal == false) goto L18;
        this.okHttpRecord.recordResponse.sent_bytes += r11.e().a();
        this.url = r11.k().toString();
        this.requestHeader = getHeaders(r11.e());
        return;
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call r10) {
        super.requestHeadersStart(r10);
        if (this.needToDeal == false) goto L5;
        long r11 = System.currentTimeMillis();
        this.requestHeadersStartTime = r11;
        this.okHttpRecord.timeRequest.request_sent_time = r11;
    L5:
        EventListener r12 = this.originListener;
        if (r12 == null) goto L9;
        r12.requestHeadersStart(r10);
        return;
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call r10, long r11) {
        super.responseBodyEnd(r10, r11);
        EventListener r12 = this.originListener;
        if (r12 == null) goto L6;
        r12.responseBodyEnd(r10, r11);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord r13 = this.okHttpRecord;
        r13.recordResponse.received_bytes += r11;
        r13.timeDetailedDuration.body_recv = (int) (System.currentTimeMillis() - this.responseBodyStartTime);
        return;
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call r10) {
        super.responseBodyStart(r10);
        if (this.needToDeal == false) goto L5;
        this.responseBodyStartTime = System.currentTimeMillis();
    L5:
        EventListener r11 = this.originListener;
        if (r11 == null) goto L9;
        r11.responseBodyStart(r10);
        return;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call r10, Response r11) {
        super.responseHeadersEnd(r10, r11);
        EventListener r12 = this.originListener;
        if (r12 == null) goto L6;
        r12.responseHeadersEnd(r10, r11);
    L6:
        if (this.needToDeal == false) goto L14;
        this.okHttpRecord.timeDetailedDuration.header_recv = (int) (System.currentTimeMillis() - this.responseHeadersStartTime);
        this.okHttpRecord.recordResponse.code = r11.d();
        this.okHttpRecord.recordResponse.received_bytes += r11.i().a();
        this.okHttpRecord.recordResponse.network_accessed = k.b(c.g());
        this.okHttpRecord.headerRequest.x_tt_trace_id = r11.g(X_TT_TRACE_ID, "");
        this.okHttpRecord.headerRequest.x_tt_trace_host = r11.g(X_TT_TRACE_HOST, "");
        this.okHttpRecord.headerRequest.x_tt_trace_tag = r11.g(X_TT_TRACE_TAG, "");
        this.okHttpRecord.headerRequest.x_tt_content_encoding = r11.g(X_TT_CONTENT_ENCODING, "");
        dealSpecialHeader(r11);     // Catch: Exception -> L11
    L9:
        this.responseHeader = getHeaders(r11.i());
        return;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call r10) {
        super.responseHeadersStart(r10);
        if (this.needToDeal == false) goto L10;
        this.responseHeadersStartTime = System.currentTimeMillis();
        if (this.requestBodyEndTime == 0) goto L8;
        long r11 = System.currentTimeMillis();
        long r12 = this.requestBodyEndTime;
    L7:
        long r13 = r11 - r12;
        OkHttpRecord r14 = this.okHttpRecord;
        int r15 = (int) r13;
        r14.timeDetailedDuration.ttfb = r15;
        OkHttpRecord.TimeRequest r16 = r14.timeRequest;
        r16.response_recv_time = System.currentTimeMillis();
        goto L10
    L8:
        r11 = System.currentTimeMillis();
        r12 = this.requestHeadersEndTime;
    L10:
        EventListener r17 = this.originListener;
        if (r17 == null) goto L14;
        r17.responseHeadersStart(r10);
        return;
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call r10, @Nullable Handshake r11) {
        super.secureConnectEnd(r10, r11);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r12 = this.okHttpRecord.timeDetailedDuration;
        r12.ssl = (int) (System.currentTimeMillis() - this.secureConnectStartTime);
    L5:
        EventListener r13 = this.originListener;
        if (r13 == null) goto L9;
        r13.secureConnectEnd(r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call r10) {
        super.secureConnectStart(r10);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r11 = this.okHttpRecord.timeDetailedDuration;
        r11.tcp = (int) (System.currentTimeMillis() - this.connectStartTime);
        this.secureConnectStartTime = System.currentTimeMillis();
    L5:
        EventListener r12 = this.originListener;
        if (r12 == null) goto L9;
        r12.secureConnectStart(r10);
        return;
    }
}
