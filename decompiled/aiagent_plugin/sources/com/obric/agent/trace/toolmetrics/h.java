package com.obric.agent.trace.toolmetrics;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniClientNetworkTraceContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f15890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15891b;

    /* JADX INFO: compiled from: OmniClientNetworkTraceContext.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f15890a = new a(null);
    }

    public h() {
        this(0, 1, null);
    }

    public h(long r1) {
        this.f15891b = r1;
    }

    public /* synthetic */ h(long r1, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = SystemClock.elapsedRealtime();
    L5:
        this(r1);
    }

    public final u a(f r14, Map<String, String> r15) {
        Map<String, String> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "channel");
        d.h.b.o.e(r16, "params");
        long r2 = SystemClock.elapsedRealtime();
        LinkedHashMap r17 = ao.d(new d.m[]{d.s.a("channel", r14.a())});
        JSONObject r18 = a(r16);
        if (r18 == null) goto L12;
        String r5 = r18.optString("log_id");
        if (r5 == null) goto L12;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin")).put("log_id", r5);
    L12:
        Long r0 = a((Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin"), r18, r2);
        a(this, (Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin"), r18, "retry_count", "retry_count", null, 16, null);
        a((Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin"), r18, "encrypt_cost_ms", "screenshot_encrypt_duration_ms", r0);
        a((Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin"), r18, "request_build_duration_ms", "request_build_duration_ms", r0);
        return new u(v.f15930a, "network", (Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin"));
    }

    private final Long a(Map<String, Object> r16, JSONObject r17, long r18) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        Long r3 = a(r17, "flow_received_elapsed_ms");
        if (r3 == null) goto L16;
        long r5 = r3.longValue();
        Long r4 = a(r17, "request_started_elapsed_ms");
        if (r4 == null) goto L16;
        long r7 = r4.longValue();
        Long r1 = a(r17, "response_finished_elapsed_ms");
        if (r1 == null) goto L16;
        long r9 = r1.longValue();
        if (a(new long[]{this.f15891b, r5, r7, r9, r18}) == true) goto L11;
        return null;
    L11:
        long r0 = this.f15891b;
        long r11 = r5 - r0;
        long r6 = r7 - r5;
        long r8 = r9 - r7;
        long r10 = r18 - r9;
        long r12 = r18 - r0;
        if ((((r11 + r6) + r8) + r10) == r12) goto L14;
        return null;
    L14:
        r2.put("client_dispatch_duration_ms", Long.valueOf(r11));
        r2.put("flow_prepare_duration_ms", Long.valueOf(r6));
        r2.put("request_duration_ms", Long.valueOf(r8));
        r2.put("result_return_duration_ms", Long.valueOf(r10));
        r2.put("total_duration_ms", Long.valueOf(r12));
        return Long.valueOf(r6);
    L16:
        return null;
    }

    static /* synthetic */ void a(h r6, Map r7, JSONObject r8, String r9, String r10, Long r11, int r12, Object r13) {
        Map<String, Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.a(r1, r8, r9, r10, r11);
    }

    private final void a(Map<String, Object> r5, JSONObject r6, String r7, String r8, Long r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Long r4 = a(r6, r7);
        if (r4 == null) goto L17;
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r11 < 0) goto L10;
        if (r9 != null) goto L8;
    L9:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L18;
        r10.put(r8, Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue()));
        return;
    L18:
        return;
    L8:
        if (r11 <= r9.longValue()) goto L9;
    L10:
        r12 = false;
        goto L11
    }

    private final JSONObject a(Map<String, String> r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).get("__omni_network_trace_payload"), String.class, "com.obric.aiagent.plugin");
        Object r4 = null;
        if (r2 == null) goto L16;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L6
        Object r5 = d.n.f(new JSONObject(r2));     // Catch: Throwable -> L6
    L9:
        if (d.n.b(r5) == true) goto L13;
        r4 = r5;
    L13:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin");
    L6:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L9
    L16:
        return null;
    }

    private final Long a(JSONObject r2, String r3) {
        if (r2 == null) goto L14;
        Object r4 = r2.opt(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L11;
        return Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue());
    L11:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L13;
        return null;
    L13:
        return d.o.o.e((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
    L14:
        return null;
    }

    private final boolean a(long... r7) {
        int r6 = d.a.i.a(r7);
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L7;
        long r2 = r7[r1];
        r1 = r1 + 1;
        if (r2 <= r7[r1]) goto L3;
        return false;
    L7:
        return true;
    }
}
