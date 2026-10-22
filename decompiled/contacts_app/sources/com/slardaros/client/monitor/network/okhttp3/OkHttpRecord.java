package com.slardaros.client.monitor.network.okhttp3;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.obric.capabilitykit.common.Ext;
import com.obric.olog.OLog;
import com.slardaros.client.SlardarAgent;
import com.slardaros.client.monitor.network.NetUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obric.widget.search.data.GloableSearchConfig;
import okhttp3.internal.Version;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OkHttpRecord {
    public static final String TAG = "OkHttpRecord";
    public List<DnsInfo> addressList;
    public int connectAttempts;
    public boolean connectSuccess;
    public String exceptionInfo;
    public String finalHost;
    public String finalUrl;
    public HeaderRequest headerRequest;
    public boolean isBackground;
    public String originalHost;
    public String originalUrl;
    public OtherInfo otherInfo;
    public JSONObject recordJson;
    public RecordResponse recordResponse;
    public String remoteIp;
    public boolean requestSuccess;
    public SocketInfo socketInfo;
    public DetailedDuration timeDetailedDuration;
    public TimeRequest timeRequest;

    public static class DetailedDuration {
        public int body_recv;
        public boolean cdn_hit_cache;
        public int dns;
        public int edge;
        public int header_recv;
        public int inner;
        public int origin;
        public int proxy;
        public int recv;
        public int rtt;
        public int send;
        public int ssl;
        public int tcp;
        public int ttfb;

        public DetailedDuration() {
            this.proxy = -3;
        }
    }

    public static class DnsInfo {
        public String address;

        public DnsInfo() {
        }
    }

    public static class HeaderRequest {
        public List<String> serverTimings;
        public String x_tt_content_encoding;
        public String x_tt_trace_host;
        public String x_tt_trace_id;
        public String x_tt_trace_tag;

        public HeaderRequest() {
            this.serverTimings = new ArrayList();
        }
    }

    public static class OtherInfo {
        public String libcore;
        public String version;

        public OtherInfo() {
            this.libcore = "okhttp";
            this.version = Version.userAgent();
        }
    }

    public class RecordResponse {
        public int code;
        boolean is_cached;
        public boolean network_accessed;
        public int network_type;
        public long received_bytes;
        public long sent_bytes;
        final /* synthetic */ OkHttpRecord this$0;
        public boolean via_Proxy;

        public RecordResponse(OkHttpRecord r1) {
            this.this$0 = r1;
        }
    }

    public static class SocketInfo {
        public int addressFamily;
        public String connectionInfo;
        public String host;
        public String port;
        public String remote;
        public boolean socketReused;

        public SocketInfo() {
            this.addressFamily = 0;
            this.connectionInfo = "";
        }
    }

    public static class TimeRequest {
        public long duration;
        public long request_sent_time;
        public long response_recv_time;
        public long start_time;

        public TimeRequest() {
        }
    }

    public OkHttpRecord() {
        this.recordJson = new JSONObject();
        this.addressList = new ArrayList();
        this.socketInfo = new SocketInfo();
        this.recordResponse = new RecordResponse(this);
        this.timeRequest = new TimeRequest();
        this.timeDetailedDuration = new DetailedDuration();
        this.otherInfo = new OtherInfo();
        this.headerRequest = new HeaderRequest();
        this.originalUrl = "";
        this.finalUrl = "";
        this.originalHost = "";
        this.finalHost = "";
        this.remoteIp = "";
        this.connectAttempts = 0;
        this.isBackground = false;
        this.exceptionInfo = null;
        this.connectSuccess = false;
        this.requestSuccess = false;
    }

    public String toString() {
        fillDnsInfo();
        fillSocketInfo();
        fillResponse();
        dealTime();
        dealOther();
        dealHeader();
        return this.recordJson.toString();
    }

    public void getMetricEventObj(JSONObject r5, JSONObject r6) {
        r5.put("original_host", this.originalHost);     // Catch: JSONException -> L13
        r5.put("host", this.finalHost);     // Catch: JSONException -> L13
        r5.put("original_url", this.originalUrl);     // Catch: JSONException -> L13
        r5.put("url", this.finalUrl);     // Catch: JSONException -> L13
        r5.put("address_family", this.socketInfo.addressFamily);     // Catch: JSONException -> L13
        r5.put(ICronetClient.KEY_REMOTE_IP, this.remoteIp);     // Catch: JSONException -> L13
        int r2 = 0;
        if (this.socketInfo.addressFamily == 2) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r5.put("is_dns64", r0);     // Catch: JSONException -> L13
        r5.put("is_cached", this.recordResponse.is_cached);     // Catch: JSONException -> L13
        r5.put("status_code", this.recordResponse.code);     // Catch: JSONException -> L13
        r5.put("via_proxy", this.recordResponse.via_Proxy);     // Catch: JSONException -> L13
        r5.put("protocol", NetUtil.getProtocol(this.finalUrl));     // Catch: JSONException -> L13
        int r1 = this.connectAttempts;     // Catch: JSONException -> L13
        if (r1 <= 1) goto L11;
        r2 = r1 - 1;     // Catch: JSONException -> L13
    L11:
        r5.put(ICronetClient.KEY_RETRY_ATTEMPTS, r2);     // Catch: JSONException -> L13
        r5.put("connection_info", this.socketInfo.connectionInfo);     // Catch: JSONException -> L13
        r5.put("is_background", this.isBackground);     // Catch: JSONException -> L13
        r5.put("network_type", NetUtil.getNetworkType(SlardarAgent.getContext()));     // Catch: JSONException -> L13
        r5.put("network_lib", "okhttp3");     // Catch: JSONException -> L13
        r5.put("network_lib_version", this.otherInfo.version);     // Catch: JSONException -> L13
        r5.put("connect_success", this.connectSuccess);     // Catch: JSONException -> L13
        r5.put("request_success", this.requestSuccess);     // Catch: JSONException -> L13
        r6.put("duration", this.timeRequest.duration);     // Catch: JSONException -> L13
        r6.put(ICronetClient.KEY_TOTAL_TIME, this.timeRequest.duration);     // Catch: JSONException -> L13
        r6.put("proxy_time", this.timeDetailedDuration.proxy);     // Catch: JSONException -> L13
        r6.put(ICronetClient.KEY_DNS_TIME, this.timeDetailedDuration.dns);     // Catch: JSONException -> L13
        r6.put("tcp_time", this.timeDetailedDuration.tcp);     // Catch: JSONException -> L13
        r6.put(ICronetClient.KEY_SEND_TIME, this.timeDetailedDuration.send);     // Catch: JSONException -> L13
        r6.put("rtt_time", this.timeDetailedDuration.rtt);     // Catch: JSONException -> L13
        r6.put("edge_time", this.timeDetailedDuration.edge);     // Catch: JSONException -> L13
        r6.put("origin_time", this.timeDetailedDuration.origin);     // Catch: JSONException -> L13
        r6.put("inner_time", this.timeDetailedDuration.inner);     // Catch: JSONException -> L13
        r6.put("waiting_time", this.timeDetailedDuration.ttfb);     // Catch: JSONException -> L13
        r6.put(ICronetClient.KEY_RECEIVE_TIME, this.timeDetailedDuration.recv);     // Catch: JSONException -> L13
        r6.put("send_bytes", this.recordResponse.sent_bytes);     // Catch: JSONException -> L13
        r6.put("received_bytes", this.recordResponse.received_bytes);     // Catch: JSONException -> L13
        r6.put("header_recv_time", this.timeDetailedDuration.header_recv);     // Catch: JSONException -> L13
        r6.put("body_recv_time", this.timeDetailedDuration.body_recv);     // Catch: JSONException -> L13
        return;
    L5:
        if (this.remoteIp.startsWith("64:ff9b::") == false) goto L7;
        r0 = true;
    L13:
        e = move-exception;
        OLog.e(TAG, "getMetricEventObj " + e.getMessage());
    }

    private void dealHeader() {
        JSONObject r0 = new JSONObject();
        r0.put("x-tt-content-encoding", this.headerRequest.x_tt_content_encoding);     // Catch: JSONException -> L9
        r0.put("x-tt-trace-host", this.headerRequest.x_tt_trace_host);     // Catch: JSONException -> L9
        r0.put("x-tt-trace-id", this.headerRequest.x_tt_trace_id);     // Catch: JSONException -> L9
        r0.put("x-tt-trace-tag", this.headerRequest.x_tt_trace_tag);     // Catch: JSONException -> L9
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L9
        Iterator<String> r2 = this.headerRequest.serverTimings.iterator();     // Catch: JSONException -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.put(r2.next());     // Catch: JSONException -> L9
        goto L5
    L7:
        r0.put("server-timing", r1);     // Catch: JSONException -> L9
    L16:
        this.recordJson.put("header", r0);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void dealOther() {
        JSONObject r0 = new JSONObject();
        r0.put("libcore", this.otherInfo.libcore);     // Catch: JSONException -> L5
        r0.put(GloableSearchConfig.KEY_VERSION, this.otherInfo.version);     // Catch: JSONException -> L5
    L12:
        this.recordJson.put("other", r0);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void dealTime() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("duration", this.timeRequest.duration);     // Catch: JSONException -> L5
        r1.put("request_sent_time", this.timeRequest.request_sent_time);     // Catch: JSONException -> L5
        r1.put("response_recv_time", this.timeRequest.response_recv_time);     // Catch: JSONException -> L5
        r1.put("start_time", this.timeRequest.start_time);     // Catch: JSONException -> L5
        r0.put(Ext.KEY_REQUEST, r1);     // Catch: JSONException -> L5
    L7:
        JSONObject r2 = new JSONObject();
        r2.put("edge", this.timeDetailedDuration.edge);     // Catch: JSONException -> L10
        r2.put(ICronetClient.KEY_TTFB, this.timeDetailedDuration.ttfb);     // Catch: JSONException -> L10
        r2.put("rtt", this.timeDetailedDuration.rtt);     // Catch: JSONException -> L10
        r2.put("inner", this.timeDetailedDuration.inner);     // Catch: JSONException -> L10
        r2.put("cdn_hit_cache", this.timeDetailedDuration.cdn_hit_cache);     // Catch: JSONException -> L10
        r2.put("origin", this.timeDetailedDuration.origin);     // Catch: JSONException -> L10
        r2.put("proxy", this.timeDetailedDuration.proxy);     // Catch: JSONException -> L10
        r2.put(MultiProcessFileUtils.KEY_DNS, this.timeDetailedDuration.dns);     // Catch: JSONException -> L10
        r2.put("tcp", this.timeDetailedDuration.tcp);     // Catch: JSONException -> L10
        r2.put("ssl", this.timeDetailedDuration.ssl);     // Catch: JSONException -> L10
        r2.put(CommonKey.KEY_SEND, this.timeDetailedDuration.send);     // Catch: JSONException -> L10
        r2.put("header_recv", this.timeDetailedDuration.header_recv);     // Catch: JSONException -> L10
        r2.put("body_recv", this.timeDetailedDuration.body_recv);     // Catch: JSONException -> L10
        r0.put("detailed_duration", r2);     // Catch: JSONException -> L10
    L17:
        this.recordJson.put("timing", r0);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void fillResponse() {
        JSONObject r0 = new JSONObject();
        r0.put("code", this.recordResponse.code);     // Catch: JSONException -> L5
        r0.put("sent_bytes", this.recordResponse.sent_bytes);     // Catch: JSONException -> L5
        r0.put("received_bytes", this.recordResponse.received_bytes);     // Catch: JSONException -> L5
        r0.put("via_proxy", this.recordResponse.via_Proxy);     // Catch: JSONException -> L5
        r0.put("network_accessed", this.recordResponse.network_accessed);     // Catch: JSONException -> L5
    L14:
        this.recordJson.put(ApmTrafficStats.TTNET_RESPONSE, r0);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private void fillSocketInfo() {
        JSONObject r0 = new JSONObject();
        r0.put("remote", this.socketInfo.remote);     // Catch: JSONException -> L5
        r0.put("remote_host", this.socketInfo.host);     // Catch: JSONException -> L5
        r0.put("remote_port", this.socketInfo.port);     // Catch: JSONException -> L5
        r0.put(ICronetClient.KEY_SOCKET_REUSED, this.socketInfo.socketReused);     // Catch: JSONException -> L5
    L12:
        this.recordJson.put("socket", r0);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void fillDnsInfo() {
        JSONObject r0 = new JSONObject();
        if (this.addressList.isEmpty() == true) goto L17;
        JSONArray r1 = new JSONArray();
        Iterator<DnsInfo> r2 = this.addressList.iterator();
    L6:
        if (r2.hasNext() == false) goto L19;
        r1.put(r2.next().address);
        goto L6
    L19:
        r0.put("address_list", r1);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L17:
        this.recordJson.put(MultiProcessFileUtils.KEY_DNS, r0);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }
}
