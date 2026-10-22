package com.ss.bduploader.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: SmartRouting.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f37474b;

    public b() {
        this.f37473a = "";
    }

    @Override // com.ss.bduploader.b.a
    public void a() {
        this.f37474b = new d();
    }

    @Override // com.ss.bduploader.b.a
    public void b() {
        a("intelligent_routing", "config_server engine_type: mlsdk outputType: regression service name: smart_upload_tcp_quic engineType: mlsdk model_url: " + this.f37473a);
        this.f37474b.a(1000, "mlsdk");
        this.f37474b.a(1001, "smart_upload_tcp_quic");
        this.f37474b.a(1002, "regression");
        this.f37474b.a(1003, this.f37473a);
        this.f37474b.a();
    }

    @Override // com.ss.bduploader.b.a
    public void c() {
        c r0 = this.f37474b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.ss.bduploader.b.a
    public float a(JSONObject r7) {
        a("intelligent_routing", "predict float value intelligent");
        if (this.f37474b.c() == false) goto L18;
        a("intelligent_speedtest", "service is valid");
        Map r3 = new HashMap();
        if (r7.getInt("routing_using_vcn") != 1) goto L9;
        r3 = c(r7);     // Catch: Exception -> L16
    L11:
        if (r3 != null) goto L15;
        a("intelligent_speedtest", "input processing invalid");
        return -1.0f;
    L15:
        return this.f37474b.a(r3);
    L9:
        if (r7.getInt("routing_using_vcn") != 0) goto L11;
        r3 = b(r7);     // Catch: Exception -> L16
        goto L11
    L19:
        return -1.0f;
    L18:
        return -1.0f;
    }

    @Override // com.ss.bduploader.b.a
    public void a(String r5) {
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L4
        a("intelligent_routing", "parse url" + r5);     // Catch: Exception -> L4
        this.f37473a = r0.getString("intelligent_model_url");     // Catch: Exception -> L4
        return;
    L4:
        this.f37473a = "";
    }

    @Override // com.ss.bduploader.b.a
    public void b(String r1) {
        this.f37473a = r1;
    }

    public Map b(JSONObject r20) {
        a("intelligent_routing", "routing ttnet input info is " + r20);
        HashMap r4 = new HashMap();
    L38:
        e = move-exception;
        b("exception", String.valueOf(e));
        return null;
    L4:
        if (r20.getInt("est_file_size") > 0) goto L6;
        return null;
    L6:
        if (r20.getJSONObject("tcp_domain") != null) goto L8;
        return null;
    L8:
        if (r20.getJSONObject("quic_domain") == null) goto L48;
        List r6 = Arrays.asList(new String[]{"tcp", "quic"});     // Catch: Exception -> L38
        List r7 = Arrays.asList(new String[]{"SeverSpeed", "speed", "duration", "routing_request_log.timing.detailed_duration.inner", "routing_request_log.timing.detailed_duration.send", "routing_request_log.timing.detailed_duration.ttfb", "routing_request_log.timing.request.duration"});     // Catch: Exception -> L38
        List r8 = Arrays.asList(new String[]{"routing_request_log.nqe.http_rtt", "routing_request_log.nqe.tcp_rtt", "routing_request_log.nqe.downlink_throughput", "routing_request_log.nqe.real_net_type", "routing_request_log.nqe.effective_net_type"});     // Catch: Exception -> L38
        int r10 = 0;
    L13:
        if (r10 >= r6.size()) goto L26;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.get(r10), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        JSONObject r14 = r20.getJSONObject(r11 + "_domain");     // Catch: Exception -> L38
        Iterator r15 = r7.iterator();     // Catch: Exception -> L38
    L16:
        if (r15.hasNext() == false) goto L25;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        String[] r9 = r5.split("\\.");     // Catch: Exception -> L38
        List r17 = r6;
        List r18 = r7;
        String r12 = r11 + "_" + r9[r9.length - 1].toLowerCase(Locale.US);     // Catch: Exception -> L38
        if (r5.equals("duration") == false) goto L20;
        r12 = r12 + "_bd";     // Catch: Exception -> L38
    L20:
        float r13 = a(r14, r5);     // Catch: Exception -> L38
        if (r13 == (-1.0f)) goto L22;
        r4.put(r12, Float.valueOf(r13));     // Catch: Exception -> L38
        r6 = r17;
        r7 = r18;
        goto L16
    L22:
        return null;
    L25:
        r10 = r10 + 1;     // Catch: Exception -> L38
        goto L13
    L26:
        Iterator r16 = r8.iterator();     // Catch: Exception -> L38
    L28:
        if (r16.hasNext() == false) goto L30;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        String[] r21 = r19.split("\\.");     // Catch: Exception -> L38
        r4.put(r21[r21.length - 1].toLowerCase(Locale.US), Float.valueOf(a(r20.getJSONObject("tcp_domain"), r19)));     // Catch: Exception -> L38
        goto L28
    L30:
        float r0 = a(r20, "est_file_size", 0);     // Catch: Exception -> L38
        if (r0 > 0.0f) goto L34;
        return null;
    L34:
        r4.put("est_file_size", Float.valueOf(r0));     // Catch: Exception -> L38
        return r4;
    L48:
        return null;
    }

    public Map c(JSONObject r11) {
        a("intelligent_routing", "speed test input info is " + r11);
        HashMap r2 = new HashMap();
        if (r11.getInt("est_file_size") <= 0) goto L12;
        if (r11.getJSONObject("optimized_info") == null) goto L12;
        if (r11.getInt("origin_speed_test") <= 0) goto L12;
        a("intelligent_routing", "input is valid");
        r2.put("origin_speed_test", Float.valueOf(a(r11, "origin_speed_test", 0)));
        r2.put("speed_test_protocol", Float.valueOf(a(r11, "speed_test_protocol", 0)));
        r2.put("init_rtt", Double.valueOf(((double) a(r11, "init_rtt", 1)) / 1000.0d));
        r2.put("close_rtt", Double.valueOf(((double) a(r11, "close_rtt", 1)) / 1000.0d));
        r2.put("mss", Float.valueOf(a(r11, "mss", 1)));
        r2.put("inner_time", Double.valueOf(((double) a(r11, "inner", 1)) / 1000.0d));
        r2.put("origin_time", Double.valueOf(((double) a(r11, "origin", 1)) / 1000.0d));
        a("intelligent_routing", "grab file_size info");
        r2.put("est_file_size", Float.valueOf(a(r11, "est_file_size", 0)));
        return r2;
    L12:
        return null;
    }

    private float a(JSONObject r1, String r2, int r3) {
        if (r3 != 1) goto L5;
        double r0 = r1.getJSONObject("optimized_info").getDouble(r2);     // Catch: Exception -> L7
    L6:
        return (float) r0;
    L5:
        r0 = r1.getDouble(r2);     // Catch: Exception -> L7
    L7:
        return 0.0f;
    }

    private float a(JSONObject r3, String r4) {
        String[] r2 = r4.split("\\.");
        int r5 = 0;
    L15:
    L13:
        b("intelligent_routing", "value of key" + r2 + "invalid" + r3);
        return -1.0f;
    L5:
        if (r5 >= (r2.length - 1)) goto L7;
        r3 = r3.getJSONObject(r2[r5]);     // Catch: Exception -> L13
        r5 = r5 + 1;     // Catch: Exception -> L13
        goto L15
    L7:
        String r6 = r2[r2.length - 1];     // Catch: Exception -> L13
        if (r3.has(r6) == true) goto L10;
        return -1.0f;
    L10:
        return (float) r3.getDouble(r6);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
