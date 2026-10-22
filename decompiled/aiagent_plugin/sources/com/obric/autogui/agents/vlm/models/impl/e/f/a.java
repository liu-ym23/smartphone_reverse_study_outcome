package com.obric.autogui.agents.vlm.models.impl.e.f;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.agents.scripted.b.f;
import com.obric.autogui.agents.scripted.impl.w;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOBizPerformanceReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {
    private static final String TAG = "Script-PerformanceReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0696a f27879a = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.e.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOBizPerformanceReporter.kt */
    public static final class C0696a {
        public /* synthetic */ C0696a(h r1) {
            this();
        }

        private C0696a() {
        }
    }

    static {
        f27879a = new C0696a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.f.c
    public void a(String r11, d r12, long r13, String r15) {
        o.e(r12, "stats");
        o.e(r15, ObricMemoryConstants.KEY_SESSION_ID);
        long r7 = System.currentTimeMillis() - r13;     // Catch: Exception -> L14
        w.a r14 = r12.c();     // Catch: Exception -> L14
        if (r14 != null) goto L6;
        r14 = w.f27103a.a();     // Catch: Exception -> L14
    L6:
        Map<String, Object> r10 = b(r11, r12, r7, r15);     // Catch: Exception -> L14
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L14
        Iterator<Map.Entry<String, Object>> r17 = r10.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r17.hasNext() == false) goto L10;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        r16.put((String) ZeusTransformUtils.preCheckCast(r18.getKey(), String.class, "com.obric.aiagent.plugin"), r18.getValue());     // Catch: Exception -> L14
        goto L8
    L10:
        if (r14 == null) goto L12;
        r14.a(r16);     // Catch: Exception -> L14
    L12:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "run_ao_script_performance", r16, false, false, null, 28, null);     // Catch: Exception -> L14
        Loog.INSTANCE.d(TAG, "Performance reported: " + r16);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        f.f26914a.a(TAG, "Failed to report performance metrics", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final Map<String, Object> b(String r5, d r6, long r7, String r9) {
        m[] r1 = new m[7];
        String r2 = SensitiveType.UNKNOWN;
        if (r5 != null) goto L5;
        r5 = SensitiveType.UNKNOWN;
    L5:
        r1[0] = s.a("ability_id", r5);
        String r3 = r6.b();
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r1[1] = s.a("script_id", r2);
        r1[2] = s.a("result", r6.e());
        String r4 = r6.f();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r1[3] = s.a("reason", r4);
        r1[4] = s.a("time_consumption_ms", Long.valueOf(r7));
        r1[5] = s.a("operation_count", Integer.valueOf(r6.a()));
        r1[6] = s.a("session_id", r9);
        LinkedHashMap r8 = ao.d(r1);
        a((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), r6);     // Catch: Exception -> L15
    L18:
        return (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
    L15:
        e = move-exception;
        f.f26914a.a(TAG, "Failed to append script memory fields", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L18
    }

    private final void a(Map<String, Object> r4, d r5) {
        Map<String, Object> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.scripted.b.b r6 = r5.d();
        if (r6 != null) goto L5;
        return;
    L5:
        r6.a(r3, "script_before_close", "before_close");
        r6.b(r3, "script_terminal", "memory_total_pss_terminal_delta_kb");
        Long r7 = r6.a("script_before_close", "script_terminal");
        if (r7 == null) goto L9;
        r3.put("memory_total_pss_close_attempt_delta_kb", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue()));
        return;
    }
}
