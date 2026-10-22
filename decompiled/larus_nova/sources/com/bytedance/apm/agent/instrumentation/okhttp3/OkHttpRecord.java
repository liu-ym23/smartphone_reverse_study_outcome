package com.bytedance.apm.agent.instrumentation.okhttp3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.apm.d;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.Version;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
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
            this.libcore = "okhttp";
            this.version = Version.userAgent();
            this.is_main_process = d.k();
        }
    }

    public class RecordResponse {
        public int code;
        public boolean network_accessed;
        public long received_bytes;
        public long sent_bytes;
        final /* synthetic */ OkHttpRecord this$0;
        public boolean via_Proxy;

        public RecordResponse(OkHttpRecord r100) {
            this.this$0 = r100;
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

    private void dealHeader() {
        JSONObject r100 = new JSONObject();
        r100.put(OkHttpEventListener.X_TT_CONTENT_ENCODING, this.headerRequest.x_tt_content_encoding);     // Catch: JSONException -> L9
        r100.put(OkHttpEventListener.X_TT_TRACE_HOST, this.headerRequest.x_tt_trace_host);     // Catch: JSONException -> L9
        r100.put(OkHttpEventListener.X_TT_TRACE_ID, this.headerRequest.x_tt_trace_id);     // Catch: JSONException -> L9
        r100.put(OkHttpEventListener.X_TT_TRACE_TAG, this.headerRequest.x_tt_trace_tag);     // Catch: JSONException -> L9
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L9
        Iterator<String> r102 = this.headerRequest.serverTimings.iterator();     // Catch: JSONException -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put(r102.next());     // Catch: JSONException -> L9
        goto L5
    L7:
        r100.put("server-timing", r101);     // Catch: JSONException -> L9
    L16:
        this.recordJson.put("header", r100);     // Catch: JSONException -> L13
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
        JSONObject r100 = new JSONObject();
        r100.put("libcore", this.otherInfo.libcore);     // Catch: JSONException -> L5
        r100.put("version", this.otherInfo.version);     // Catch: JSONException -> L5
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, this.otherInfo.is_main_process);     // Catch: JSONException -> L5
    L14:
        this.recordJson.put("other", r100);     // Catch: JSONException -> L9
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
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        r101.put("duration", this.timeRequest.duration);     // Catch: JSONException -> L5
        r101.put("request_sent_time", this.timeRequest.request_sent_time);     // Catch: JSONException -> L5
        r101.put("response_recv_time", this.timeRequest.response_recv_time);     // Catch: JSONException -> L5
        r101.put(ILoadStallMonitor.START_TIME, this.timeRequest.start_time);     // Catch: JSONException -> L5
        r100.put("request", r101);     // Catch: JSONException -> L5
    L7:
        JSONObject r102 = new JSONObject();
        r102.put("edge", this.timeDetailedDuration.edge);     // Catch: JSONException -> L10
        r102.put(MonitorConstants.TTFB, this.timeDetailedDuration.ttfb);     // Catch: JSONException -> L10
        r102.put("rtt", this.timeDetailedDuration.rtt);     // Catch: JSONException -> L10
        r102.put(RNParamRegisterEventHandler.SRC_INNER, this.timeDetailedDuration.inner);     // Catch: JSONException -> L10
        r102.put("cdn_hit_cache", this.timeDetailedDuration.cdn_hit_cache);     // Catch: JSONException -> L10
        r102.put(PlayerResolution.SDKKEY.ORIGIN, this.timeDetailedDuration.origin);     // Catch: JSONException -> L10
        r102.put("proxy", this.timeDetailedDuration.proxy);     // Catch: JSONException -> L10
        r102.put(MultiProcessFileUtils.KEY_DNS, this.timeDetailedDuration.dns);     // Catch: JSONException -> L10
        r102.put("tcp", this.timeDetailedDuration.tcp);     // Catch: JSONException -> L10
        r102.put(TTVideoEngineInterface.PLAY_API_KEY_SSL, this.timeDetailedDuration.ssl);     // Catch: JSONException -> L10
        r102.put("send", this.timeDetailedDuration.send);     // Catch: JSONException -> L10
        r102.put("header_recv", this.timeDetailedDuration.header_recv);     // Catch: JSONException -> L10
        r102.put("body_recv", this.timeDetailedDuration.body_recv);     // Catch: JSONException -> L10
        r100.put("detailed_duration", r102);     // Catch: JSONException -> L10
    L17:
        this.recordJson.put("timing", r100);     // Catch: JSONException -> L14
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
        JSONObject r100 = new JSONObject();
        if (this.addressList.isEmpty() == true) goto L17;
        JSONArray r101 = new JSONArray();
        Iterator<DnsInfo> r102 = this.addressList.iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        r101.put(r102.next().address);
        goto L6
    L19:
        r100.put("address_list", r101);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L17:
        this.recordJson.put(MultiProcessFileUtils.KEY_DNS, r100);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    private void fillResponse() {
        JSONObject r100 = new JSONObject();
        r100.put("code", this.recordResponse.code);     // Catch: JSONException -> L5
        r100.put(StreamTrafficObservable.STREAM_SENTBYTES, this.recordResponse.sent_bytes);     // Catch: JSONException -> L5
        r100.put(StreamTrafficObservable.STREAM_RECEIVEDBYTES, this.recordResponse.received_bytes);     // Catch: JSONException -> L5
        r100.put("via_proxy", this.recordResponse.via_Proxy);     // Catch: JSONException -> L5
        r100.put("network_accessed", this.recordResponse.network_accessed);     // Catch: JSONException -> L5
    L14:
        this.recordJson.put("response", r100);     // Catch: JSONException -> L9
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
        JSONObject r100 = new JSONObject();
        r100.put("remote", this.socketInfo.remote);     // Catch: JSONException -> L5
        r100.put("remote_host", this.socketInfo.host);     // Catch: JSONException -> L5
        r100.put("remote_port", this.socketInfo.port);     // Catch: JSONException -> L5
        r100.put("socket_reused", this.socketInfo.socketReused);     // Catch: JSONException -> L5
    L12:
        this.recordJson.put("socket", r100);     // Catch: JSONException -> L9
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
