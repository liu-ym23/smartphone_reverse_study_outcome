package com.bytedance.apm6.hub.a;

import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrequencyConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.apm6.frequency.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm6.frequency.c f5407a;

    static /* synthetic */ void a(f r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public f() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    private void a(JSONObject r20, boolean r21) {
        if (r20 != null) goto L5;
        return;
    L5:
        JSONObject r0 = com.bytedance.apm6.perf.base.a.a(r20, "frequency");
        if (r0 != null) goto L8;
        return;
    L8:
        boolean r3 = true;
        if (r0.optInt("enable_frequency_monitor", 0) != 1) goto L11;
        boolean r1 = true;
    L13:
        if (r0.optInt("enable_exception_monitor", 0) == 1) goto L16;
        r3 = false;
    L16:
        int r4 = r0.optInt("front_exception_check_interval", 0);
        int r5 = r0.optInt("background_exception_check_interval", 0);
        JSONObject r6 = r0.optJSONObject("front_exception_threshold_per_min");
        String r9 = "com.obric.aiagent.plugin";
        if (r6 == null) goto L22;
        HashMap<String, Float> r11 = new HashMap();
        Iterator<String> r12 = r6.keys();
    L20:
        if (r12.hasNext() == false) goto L23;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin");
        r11.put(r13, Float.valueOf((float) r6.optDouble(r13, 0.0d)));
    L23:
        JSONObject r7 = r0.optJSONObject("background_exception_threshold_per_min");
        if (r7 == null) goto L30;
        HashMap<String, Float> r14 = new HashMap();
        Iterator<String> r15 = r7.keys();
    L27:
        if (r15.hasNext() == false) goto L29;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        r14.put(r16, Float.valueOf((float) r7.optDouble(r16, 0.0d)));
        r11 = r11;
        goto L27
    L29:
        HashMap<String, Float> r17 = r11;
    L31:
        int r8 = r0.optInt("exception_report_top_count", 0);
        int r2 = r0.optInt("report_interval", 0);
        int r10 = r0.optInt("event_sampling_rate", KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        JSONObject r18 = r0.optJSONObject("front_report_threshold_per_min");
        if (r18 == null) goto L38;
        HashMap<String, Float> r19 = new HashMap();
        Iterator<String> r110 = r18.keys();
    L35:
        if (r110.hasNext() == false) goto L37;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin");
        r19.put(r22, Float.valueOf((float) r18.optDouble(r22, 0.0d)));
        r17 = r17;
        r110 = r110;
        r5 = r5;
        r8 = r8;
        goto L35
    L37:
        int r111 = r5;
        int r112 = r8;
        HashMap<String, Float> r23 = r17;
    L39:
        JSONObject r24 = r0.optJSONObject("background_report_threshold_per_min");
        if (r24 == null) goto L45;
        HashMap<String, Float> r25 = new HashMap();
        Iterator<String> r26 = r24.keys();
    L43:
        if (r26.hasNext() == false) goto L46;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, r9);
        r25.put(r27, Float.valueOf((float) r24.optDouble(r27, 0.0d)));
        r9 = r9;
    L46:
        this.f5407a = new com.bytedance.apm6.frequency.c.a().a(r1).b(r3).a(r4).b(r111).a(r23).b(r14).c(r112).d(r2).e(r10).c(r19).d(r25).a();
        com.bytedance.apm6.frequency.b.a().a(a());
        return;
    L45:
        r25 = null;
        goto L46
    L38:
        r111 = r5;
        r112 = r8;
        r23 = r17;
        r19 = null;
        goto L39
    L30:
        r17 = r11;
        r14 = null;
        goto L31
    L22:
        r11 = null;
        goto L23
    L11:
        r1 = false;
        goto L13
    }

    public com.bytedance.apm6.frequency.c a() {
        return this.f5407a;
    }
}
