package com.bytedance.apm.agent.instrumentation.okhttp3;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.common.net.HttpHeaders;
import com.obric.capabilitykit.common.Ext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.Version;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpRecord {
    public List<DnsInfo> addressList;
    public HeaderRequest headerRequest;
    public OtherInfo otherInfo;
    public JSONObject recordJson;
    public RecordResponse recordResponse;
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
        public boolean is_main_process;
        public String libcore;
        public String version;

        public OtherInfo() {
            this.libcore = TrafficConsts.NET_CONSUME_TYPE_OK;
            this.version = Version.userAgent();
            this.is_main_process = c.F();
        }
    }

    public class RecordResponse {
        public int code;
        public boolean network_accessed;
        public long received_bytes;
        public long sent_bytes;
        final /* synthetic */ OkHttpRecord this$0;
        public boolean via_Proxy;

        public RecordResponse(OkHttpRecord r10) {
            this.this$0 = r10;
        }
    }

    public static class SocketInfo {
        public String host;
        public String port;
        public String remote;
        public boolean socketReused;

        public SocketInfo() {
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
    }

    private void dealHeader() {
        JSONObject r10 = new JSONObject();
        r10.put(OkHttpEventListener.X_TT_CONTENT_ENCODING, this.headerRequest.x_tt_content_encoding);     // Catch: JSONException -> L7
        r10.put(OkHttpEventListener.X_TT_TRACE_HOST, this.headerRequest.x_tt_trace_host);     // Catch: JSONException -> L7
        r10.put(OkHttpEventListener.X_TT_TRACE_ID, this.headerRequest.x_tt_trace_id);     // Catch: JSONException -> L7
        r10.put(OkHttpEventListener.X_TT_TRACE_TAG, this.headerRequest.x_tt_trace_tag);     // Catch: JSONException -> L7
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L7
        Iterator<String> r12 = this.headerRequest.serverTimings.iterator();     // Catch: JSONException -> L7
    L5:
        if (r12.hasNext() == false) goto L9;
        r11.put(r12.next());     // Catch: JSONException -> L7
        goto L5
    L9:
        r10.put("server-timing", r11);     // Catch: JSONException -> L7
    L19:
        this.recordJson.put("header", r10);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private void dealOther() {
        JSONObject r10 = new JSONObject();
        r10.put("libcore", this.otherInfo.libcore);     // Catch: JSONException -> L5
        r10.put("version", this.otherInfo.version);     // Catch: JSONException -> L5
        r10.put("is_main_process", this.otherInfo.is_main_process);     // Catch: JSONException -> L5
    L14:
        this.recordJson.put(AppInfo.SEARCH_SOURCE_EXTENAL, r10);     // Catch: JSONException -> L9
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

    private void dealTime() {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        r11.put("duration", this.timeRequest.duration);     // Catch: JSONException -> L5
        r11.put("request_sent_time", this.timeRequest.request_sent_time);     // Catch: JSONException -> L5
        r11.put("response_recv_time", this.timeRequest.response_recv_time);     // Catch: JSONException -> L5
        r11.put("start_time", this.timeRequest.start_time);     // Catch: JSONException -> L5
        r10.put(Ext.KEY_REQUEST, r11);     // Catch: JSONException -> L5
    L7:
        JSONObject r12 = new JSONObject();
        r12.put("edge", this.timeDetailedDuration.edge);     // Catch: JSONException -> L10
        r12.put(ICronetClient.KEY_TTFB, this.timeDetailedDuration.ttfb);     // Catch: JSONException -> L10
        r12.put("rtt", this.timeDetailedDuration.rtt);     // Catch: JSONException -> L10
        r12.put("inner", this.timeDetailedDuration.inner);     // Catch: JSONException -> L10
        r12.put("cdn_hit_cache", this.timeDetailedDuration.cdn_hit_cache);     // Catch: JSONException -> L10
        r12.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, this.timeDetailedDuration.origin);     // Catch: JSONException -> L10
        r12.put("proxy", this.timeDetailedDuration.proxy);     // Catch: JSONException -> L10
        r12.put("dns", this.timeDetailedDuration.dns);     // Catch: JSONException -> L10
        r12.put("tcp", this.timeDetailedDuration.tcp);     // Catch: JSONException -> L10
        r12.put("ssl", this.timeDetailedDuration.ssl);     // Catch: JSONException -> L10
        r12.put(CommonKey.KEY_SEND, this.timeDetailedDuration.send);     // Catch: JSONException -> L10
        r12.put("header_recv", this.timeDetailedDuration.header_recv);     // Catch: JSONException -> L10
        r12.put("body_recv", this.timeDetailedDuration.body_recv);     // Catch: JSONException -> L10
        r10.put("detailed_duration", r12);     // Catch: JSONException -> L10
    L17:
        this.recordJson.put("timing", r10);     // Catch: JSONException -> L14
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

    private void fillDnsInfo() {
        JSONObject r10 = new JSONObject();
        if (this.addressList.isEmpty() == true) goto L17;
        JSONArray r11 = new JSONArray();
        Iterator<DnsInfo> r12 = this.addressList.iterator();
    L6:
        if (r12.hasNext() == false) goto L19;
        r11.put(r12.next().address);
        goto L6
    L19:
        r10.put("address_list", r11);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L17:
        this.recordJson.put("dns", r10);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    private void fillResponse() {
        JSONObject r10 = new JSONObject();
        r10.put(ServerElements.CODE, this.recordResponse.code);     // Catch: JSONException -> L5
        r10.put("sent_bytes", this.recordResponse.sent_bytes);     // Catch: JSONException -> L5
        r10.put("received_bytes", this.recordResponse.received_bytes);     // Catch: JSONException -> L5
        r10.put("via_proxy", this.recordResponse.via_Proxy);     // Catch: JSONException -> L5
        r10.put("network_accessed", this.recordResponse.network_accessed);     // Catch: JSONException -> L5
    L14:
        this.recordJson.put("response", r10);     // Catch: JSONException -> L9
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
        JSONObject r10 = new JSONObject();
        r10.put("remote", this.socketInfo.remote);     // Catch: JSONException -> L5
        r10.put("remote_host", this.socketInfo.host);     // Catch: JSONException -> L5
        r10.put("remote_port", this.socketInfo.port);     // Catch: JSONException -> L5
        r10.put(ICronetClient.KEY_SOCKET_REUSED, this.socketInfo.socketReused);     // Catch: JSONException -> L5
    L12:
        this.recordJson.put("socket", r10);     // Catch: JSONException -> L9
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

    public String toString() {
        fillDnsInfo();
        fillSocketInfo();
        fillResponse();
        dealTime();
        dealOther();
        dealHeader();
        return this.recordJson.toString();
    }
}
