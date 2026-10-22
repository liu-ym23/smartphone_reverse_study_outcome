package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: OmniClientToolTraceEventFlattener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15918a = null;

    /* JADX INFO: compiled from: OmniClientToolTraceEventFlattener.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f15918a = new a(null);
    }

    public r() {
    }

    public final Map<String, Object> a(w r8) {
        d.h.b.o.e(r8, "snapshot");
        Map<String, Object> r0 = ao.a();
        r0.put("schema_version", 1);
        r0.put("client_tool_trace_id", r8.a());
        r0.put("tool_namespace", r8.b().a());
        r0.put("tool_id", r8.b().b());
        r0.put("tool_name", r8.b().c());
        r0.put("trace_terminal_status", r8.n().a());
        a(r0, "o_omni_task_id", r8.c().a());
        a(r0, "question_id", r8.c().b());
        a(r0, "message_id", r8.c().c());
        a(r0, "o_execute_id", r8.c().d());
        Long r1 = r8.e();
        if (r1 == null) goto L5;
        r0.put("client_receive_push_timestamp_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L5:
        a(r0, "omni_task_state_at_push", r8.f());
        Boolean r2 = r8.g();
        if (r2 == null) goto L8;
        r0.put("is_omni_task_active_at_push", Boolean.valueOf(r2.booleanValue()));
    L8:
        Long r3 = a(r8.d(), Long.valueOf(r8.h()));
        if (r3 == null) goto L11;
        r0.put("tool_queue_cost_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L11:
        Long r4 = a(Long.valueOf(r8.h()), r8.i());
        if (r4 == null) goto L14;
        r0.put("tool_dispatch_cost_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L14:
        Long r5 = a(r8.i(), r8.j());
        if (r5 == null) goto L17;
        r0.put("tool_execute_cost_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L17:
        a(r0, "tool_execute_error_code", "tool_execute_error_msg", r8.o());
        Long r6 = a(r8.j(), r8.k());
        if (r6 == null) goto L20;
        r0.put("tool_delivery_cost_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L20:
        a(r0, "tool_delivery_error_code", "tool_delivery_error_msg", r8.p());
        Long r7 = r8.d();
        if (r7 == null) goto L23;
        long r9 = r7.longValue();
    L24:
        Long r10 = a(Long.valueOf(r9), r8.k());
        if (r10 == null) goto L27;
        r0.put("tool_total_cost_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).longValue()));
    L27:
        Long r11 = r8.q();
        if (r11 == null) goto L30;
        r0.put("tool_total_observed_lower_bound_ms", Long.valueOf(d.l.n.a(r11.longValue(), 0)));
    L30:
        a(r0, "trace_progress_path", r8.m());
        if (r8.n() == y.f15944a) goto L33;
        a(r0, "trace_last_reached_stage", r8.l());
    L33:
        Iterator<Map.Entry<String, Object>> r12 = r8.r().entrySet().iterator();
    L35:
        if (r12.hasNext() == false) goto L48;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r15 = r13.getValue();
        if (r15 == null) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, String.class) == true) goto L40;
        if (ZeusTransformUtils.instanceOf(r15, Number.class) == true) goto L43;
        if (ZeusTransformUtils.instanceOf(r15, Boolean.class) == false) goto L35;
        r0.put(r14, r15);
        goto L35
    L43:
        r0.put(r14, r15);
        goto L35
    L40:
        r0.put(r14, r15);
        goto L35
    L48:
        return ao.a(r0);
    L23:
        r9 = r8.h();
        goto L24
    }

    private final Long a(Long r5, Long r6) {
        if (r5 == null) goto L9;
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.longValue() >= r5.longValue()) goto L8;
        return null;
    L8:
        return Long.valueOf(r6.longValue() - r5.longValue());
    L9:
        return null;
    }

    private final void a(Map<String, Object> r2, String r3, String r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        r1.put(r3, r4);
        return;
    }

    private final void a(Map<String, Object> r2, String r3, String r4, m r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        String r6 = r5.a();
        if (r6 == null) goto L7;
        r1.put(r3, r6);
    L7:
        if (r5 == null) goto L12;
        String r7 = r5.b();
        if (r7 == null) goto L13;
        r1.put(r4, r7);
        return;
    L13:
        return;
    }
}
