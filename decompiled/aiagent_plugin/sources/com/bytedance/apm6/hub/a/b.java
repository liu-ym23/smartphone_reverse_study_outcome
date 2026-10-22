package com.bytedance.apm6.hub.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: CpuOnlineConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.apm6.cpu.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm6.cpu.b.a f5398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.cpu.b.c f5399b;

    static /* synthetic */ void a(b r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public b() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    public com.bytedance.apm6.cpu.b.a a() {
        return this.f5398a;
    }

    public com.bytedance.apm6.cpu.b.c b() {
        return this.f5399b;
    }

    private void a(JSONObject r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        JSONObject r13 = com.bytedance.apm6.perf.base.a.a(r11, MonitorConstants.CPU);
        if (r13 == null) goto L79;
        this.f5398a = new com.bytedance.apm6.cpu.b.a();
        boolean r1 = true;
        if (r13.optInt("enable_upload", 0) != 1) goto L9;
        boolean r14 = true;
    L10:
        this.f5398a.a(r14);
        if (r13.optInt("enable_collect_all_process", 0) != 1) goto L13;
        boolean r15 = true;
    L14:
        this.f5398a.b(r15);
        long r4 = r13.optLong("front_collect_interval", 0);
        if (r4 <= 0) goto L17;
        this.f5398a.a(r4);
    L17:
        long r5 = r13.optLong("back_collect_interval", 0);
        if (r5 <= 0) goto L20;
        this.f5398a.b(r5);
    L20:
        long r6 = r13.optLong("monitor_interval", 0);
        if (r6 <= 0) goto L23;
        this.f5398a.c(r6);
    L23:
        long r7 = r13.optLong("front_thread_collect_interval", 0);
        if (r7 <= 0) goto L26;
        this.f5398a.e(r7);
    L26:
        long r8 = r13.optLong("back_thread_collect_interval", 0);
        if (r8 <= 0) goto L29;
        this.f5398a.d(r8);
    L29:
        this.f5399b = new com.bytedance.apm6.cpu.b.c();
        if (r13.optInt("exception_switch", 0) != 1) goto L32;
        boolean r16 = true;
    L33:
        this.f5399b.a(r16);
        double r9 = r13.optDouble("exception_process_back_max_speed", 0.0d);
        if (r9 <= 0.0d) goto L36;
        this.f5399b.a(r9);
    L36:
        double r10 = r13.optDouble("exception_process_fore_max_speed", 0.0d);
        if (r10 <= 0.0d) goto L40;
        this.f5399b.c(r10);
    L40:
        if (r13.optInt("main_thread_collect_enabled", 0) != 1) goto L42;
        boolean r17 = true;
    L43:
        this.f5399b.b(r17);
        if (r13.optInt("exception_collect_all_process", 0) != 1) goto L46;
        boolean r18 = true;
    L47:
        this.f5399b.c(r18);
        if (r13.optInt("exception_thread_stack_enabled", 1) == 1) goto L51;
        r1 = false;
    L51:
        this.f5399b.d(r1);
        double r19 = r13.optDouble("exception_thread_max_usage", 0.0d);
        if (r19 <= 0.0d) goto L54;
        this.f5399b.b(r19);
    L54:
        JSONObject r110 = r13.optJSONObject("exception_thread_max_usage_map");
        HashMap r2 = new HashMap();
        if (r110 == null) goto L62;
        Iterator<String> r20 = r110.keys();
    L58:
        if (r20.hasNext() == false) goto L62;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.aiagent.plugin");
        double r22 = r110.optDouble(r21, 0.0d);
        if (r22 <= 0.0d) goto L58;
        r2.put(r21, Double.valueOf(r22));
    L62:
        this.f5399b.c(r2);
        this.f5399b.a(r13.optInt("process_detect_interval", 30));
        this.f5399b.b(r13.optInt("thread_detect_interval", 30));
        JSONObject r111 = r13.optJSONObject("exception_fore_max_speed_scene");
        HashMap r3 = new HashMap();
        if (r111 == null) goto L70;
        Iterator<String> r23 = r111.keys();
    L66:
        if (r23.hasNext() == false) goto L70;
        String r24 = (String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.aiagent.plugin");
        double r25 = r111.optDouble(r24, 0.0d);
        if (r25 <= 0.0d) goto L66;
        r3.put(r24, Double.valueOf(r25));
    L70:
        this.f5399b.b(r3);
        JSONObject r112 = r13.optJSONObject("exception_back_max_speed_scene");
        HashMap r26 = new HashMap();
        if (r112 == null) goto L78;
        Iterator<String> r27 = r112.keys();
    L74:
        if (r27.hasNext() == false) goto L78;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r27.next(), String.class, "com.obric.aiagent.plugin");
        double r29 = r112.optDouble(r28, 0.0d);
        if (r29 <= 0.0d) goto L74;
        r26.put(r28, Double.valueOf(r29));
    L78:
        this.f5399b.a(r26);
        this.f5399b.e(r13.optBoolean("exception_native_thread_enabled", false));
        goto L79
    L46:
        r18 = false;
        goto L47
    L42:
        r17 = false;
        goto L43
    L32:
        r16 = false;
        goto L33
    L13:
        r15 = false;
        goto L14
    L9:
        r14 = false;
    L79:
        com.bytedance.apm6.util.c.b.a("APM-CPU", a() + " " + b());
        com.bytedance.apm6.cpu.a.b.a().a(a());
        com.bytedance.apm6.cpu.c.c.a().a(b());
    }
}
