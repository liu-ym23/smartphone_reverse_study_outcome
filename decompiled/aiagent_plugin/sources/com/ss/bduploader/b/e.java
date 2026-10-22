package com.ss.bduploader.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: SmartSpeedTest.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f37482c;

    public e() {
        this.f37480a = -1;
        this.f37481b = "";
    }

    @Override // com.ss.bduploader.b.a
    public void a() {
        this.f37482c = new d();
    }

    @Override // com.ss.bduploader.b.a
    public void b(String r1) {
        this.f37481b = r1;
    }

    @Override // com.ss.bduploader.b.a
    public void a(String r2) {
        this.f37481b = new JSONObject(r2).getString("intelligent_model_url");     // Catch: Exception -> L4
        return;
    L4:
        this.f37481b = "";
    }

    @Override // com.ss.bduploader.b.a
    public void b() {
        this.f37482c.a(1000, "mlsdk");
        this.f37482c.a(1001, "smart_upload_speed");
        this.f37482c.a(1002, "regression");
        this.f37482c.a(1003, this.f37481b);
        this.f37482c.a();
    }

    @Override // com.ss.bduploader.b.a
    public void c() {
        c r0 = this.f37482c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.ss.bduploader.b.a
    public void a(int r1) {
        this.f37480a = r1;
    }

    @Override // com.ss.bduploader.b.a
    public float a(JSONObject r4) {
        if (this.f37482c.c() == true) goto L5;
        return -1.0f;
    L5:
        if (this.f37480a != 1) goto L7;
        Map r5 = b(r4);
    L8:
        if (r5 != null) goto L12;
        a("intelligent_speedtest", "input processing invalid");
        return -1.0f;
    L12:
        return this.f37482c.a(r5);
    L7:
        r5 = c(r4);
        goto L8
    }

    public Map b(JSONObject r10) {
        a("intelligent_speedtest", "speed test input info is " + r10);
        HashMap r1 = new HashMap();
        if (r10.getJSONObject("optimized_info") == null) goto L24;
        if (r10.getInt("origin_speed_test") <= 0) goto L24;
        r1.put("origin_speed_test", Float.valueOf(a(r10, "origin_speed_test", 0)));
        r1.put("init_rtt", Double.valueOf(((double) a(r10, "init_rtt", 1)) / 1000.0d));
        r1.put("close_rtt", Double.valueOf(((double) a(r10, "close_rtt", 1)) / 1000.0d));
        r1.put("mss", Float.valueOf(a(r10, "mss", 1)));
        r1.put("inner_time", Double.valueOf(((double) a(r10, "inner", 1)) / 1000.0d));
        r1.put("origin_time", Double.valueOf(((double) a(r10, "origin", 1)) / 1000.0d));
        String r0 = b(r10, "apply_start", 0);
        String r4 = b(r10, "apply_end", 0);
        if (r4.isEmpty() == true) goto L24;
        if (r0.isEmpty() == true) goto L24;
        float r2 = Long.valueOf(r4).longValue() - Long.valueOf(r0).longValue();
        if (r2 >= 0.0f) goto L16;
        return null;
    L16:
        r1.put("apply_duration", Float.valueOf(r2));
        String r9 = b(r10, "node_type", 0);
        r9.hashCode();
        if (r9.equals("Origin") == false) goto L19;
        r1.put("node_type", Float.valueOf(2.0f));
    L23:
        return r1;
    L19:
        if (r9.equals("Edge") == true) goto L21;
        r1.put("node_type", Float.valueOf(0.0f));
        goto L23
    L21:
        r1.put("node_type", Float.valueOf(1.0f));
    L24:
        return null;
    }

    public Map c(JSONObject r15) {
        a("intelligent_speed_ttnet", "info is " + r15);
        HashMap r0 = new HashMap();
        if (r15.getJSONObject("speedtest_request_log") == null) goto L26;
        if (r15.getInt("origin_speed_test") <= 0) goto L26;
        String r2 = b(r15, "apply_start", 0);     // Catch: Exception -> L27
        String r3 = b(r15, "apply_end", 0);     // Catch: Exception -> L27
        if (r3.isEmpty() == true) goto L26;
        if (r2.isEmpty() == true) goto L26;
        float r4 = Long.valueOf(r3).longValue() - Long.valueOf(r2).longValue();     // Catch: Exception -> L27
        if (r4 >= 0.0f) goto L16;
        return null;
    L16:
        r0.put("apply_duration", Float.valueOf(r4));     // Catch: Exception -> L27
        Iterator r5 = Arrays.asList(new String[]{"origin_speed_test", "speedtest_request_log.timing.detailed_duration.send", "speedtest_request_log.timing.detailed_duration.inner", "speedtest_request_log.timing.detailed_duration.ttfb", "speedtest_request_log.timing.request.duration", "speedtest_request_log.nqe.http_rtt", "speedtest_request_log.nqe.tcp_rtt", "speedtest_request_log.nqe.downlink_throughput", "speedtest_request_log.nqe.real_net_type", "speedtest_request_log.nqe.effective_net_type"}).iterator();     // Catch: Exception -> L27
    L18:
        if (r5.hasNext() == false) goto L24;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
        String[] r7 = r6.split("\\.");     // Catch: Exception -> L27
        String r8 = r7[r7.length - 1].toLowerCase(Locale.US);     // Catch: Exception -> L27
        float r9 = a(r15, r6);     // Catch: Exception -> L27
        if (r9 == (-1.0f)) goto L21;
        r0.put(r8, Float.valueOf(r9));     // Catch: Exception -> L27
    L21:
        return null;
    L24:
        a("intelligent_ttnet", "result" + r0);
        return r0;
    L26:
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

    private String b(JSONObject r1, String r2, int r3) {
        if (r3 != 1) goto L5;
        String r0 = r1.getJSONObject("optimized_info").getString(r2);     // Catch: Exception -> L7
    L9:
        return r0;
    L5:
        r0 = r1.getString(r2);     // Catch: Exception -> L7
    L7:
        return "";
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
