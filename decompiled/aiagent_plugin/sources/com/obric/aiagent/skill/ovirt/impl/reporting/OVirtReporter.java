package com.obric.aiagent.skill.ovirt.impl.reporting;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ae;
import com.obric.aiagent.skill.ovirt.impl.f.b;
import com.obric.aiagent.skill.virt.api.VirtReportSink;
import com.obric.aiagent.skill.virt.api.t;
import com.obric.aiagent.skill.virt.api.w;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: OVirtReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OVirtReporter implements VirtReportSink {
    private static final Set<String> ALLOWED_ROOT_ERROR_REASONS = null;
    public static final a Companion = null;
    private static final String EVENT_SHELL_EXECUTION_PERF = "obric_omni_skill_shell_execution_perf";
    private static final String EVENT_SKILL_PERFORMANCE = "obric_omni_skill_performance";
    private static final String EVENT_SKILL_SWITCH = "obric_omni_skill_switch";
    private static final String EVENT_VIRT_DIAGNOSTICS = "obric_omni_skill_virt_diagnostics";
    private static final String PARAM_SCHEMA_VERSION = "schema_version";
    private static final String PARAM_SWITCH_STATUS = "switch_status";
    private static final int PERFORMANCE_SCHEMA_VERSION = 2;
    private static final String SWITCH_STATUS_OFF = "off";
    private static final String SWITCH_STATUS_ON = "on";
    private static final String TAG = "OVirtReporter";

    /* JADX INFO: compiled from: OVirtReporter.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ void a(a r0, t r1) {
            r0.a(r1);
        }

        public static final /* synthetic */ boolean a(a r0, String r1, JSONObject r2) {
            return r0.a(r1, r2);
        }

        public static /* synthetic */ void a(a r11, String r12, long r13, ae r15, b r16, String r17, String r18, String r19, int r20, Object r21) {
            if ((r20 & 16) == 0) goto L5;
            String r8 = null;
        L7:
            if ((r20 & 32) == 0) goto L9;
            String r9 = null;
        L11:
            if ((r20 & 64) == 0) goto L13;
            String r10 = null;
        L14:
            r11.a(r12, r13, r15, r16, r8, r9, r10);
            return;
        L13:
            r10 = r19;
            goto L14
        L9:
            r9 = r18;
            goto L11
        L5:
            r8 = r17;
            goto L7
        }

        public final void a(String r17, long r18, ae r20, b r21, String r22, String r23, String r24) {
            o.e(r17, DBDefinition.TASK_ID);
            boolean r1 = false;
            if (r20 == null) goto L5;
            int r2 = r20.h();
        L6:
            if (r21 == null) goto L10;
            List<com.obric.aiagent.skill.ovirt.impl.f.a> r3 = r21.a();
            if (r3 == null) goto L10;
            int r4 = n.c(r3.size() - r2, 0);
        L11:
            String r5 = null;
            if (r21 == null) goto L16;
            List<com.obric.aiagent.skill.ovirt.impl.f.a> r6 = r21.a();
            if (r6 == null) goto L16;
            List r7 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"), r4);
        L17:
            if (r7 != null) goto L19;
            r7 = p.b();
        L19:
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L22;
        L24:
            Iterator r9 = r8.iterator();
            int r10 = 0;
        L26:
            if (r9.hasNext() == false) goto L32;
            if (((com.obric.aiagent.skill.ovirt.impl.f.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiagent.skill.ovirt.impl.f.a.class, "com.obric.aiagent.plugin")).a() == false) goto L26;
            r10 = r10 + 1;
            if (r10 >= 0) goto L26;
            p.d();
        L32:
            int r11 = r4 - r10;
            String r12 = "fail";
            if (r22 != null) goto L45;
            if (r21 == null) goto L47;
            if (r21.b() == false) goto L47;
            if (r21.c() == false) goto L47;
            if (r2 != 0) goto L43;
            if (r11 != 0) goto L43;
            r12 = "success";
        L43:
            if (r10 <= 0) goto L47;
            r12 = "partial";
        L47:
            if (r23 == null) goto L49;
            String r13 = r23;
        L62:
            if (r24 == null) goto L64;
            String r14 = r24;
        L74:
            JSONObject r15 = new JSONObject();
            r15.put(OVirtReporter.PARAM_SCHEMA_VERSION, 2);
            r15.put("operation", "skill_projection");
            r15.put("result", r12);
            long r16 = 0;
            r15.put("duration_ms", n.a(r18, 0));
            r15.put("trace_id", UUID.randomUUID().toString());
            r15.put("attempt_index", 1);
            r15.put(KnowledgeActivity.KEY_TASK_ID, r17);
            if (r20 == null) goto L77;
            long r19 = r20.a();
        L78:
            r15.put("manager_initialize_duration_ms", r19);
            if (r20 == null) goto L81;
            long r110 = r20.b();
        L82:
            r15.put("admission_duration_ms", r110);
            if (r20 == null) goto L85;
            r16 = r20.c();
        L85:
            r15.put("host_prepare_duration_ms", r16);
            if (r20 == null) goto L88;
            int r0 = r20.d();
        L89:
            r15.put("installed_count", r0);
            if (r20 == null) goto L92;
            int r25 = r20.e();
        L93:
            r15.put("admitted_count", r25);
            if (r20 == null) goto L96;
            int r26 = r20.f();
        L97:
            r15.put("rejected_count", r26);
            if (r20 == null) goto L100;
            int r27 = r20.g();
        L101:
            r15.put("prepare_attempted_count", r27);
            r15.put("prepare_failed_count", r2);
            if (r20 == null) goto L104;
            int r28 = r20.i();
        L105:
            r15.put("cli_tool_count", r28);
            r15.put("projected_skill_attempted_count", r4);
            r15.put("projected_skill_succeeded_count", r10);
            r15.put("projected_skill_failed_count", r11);
            if (r21 != null) goto L108;
        L110:
            boolean r29 = false;
        L111:
            r15.put("root_prepared", r29);
            if (r21 != null) goto L114;
        L116:
            r15.put("root_linked", r1);
            a r30 = OVirtReporter.Companion;
            if (r21 == null) goto L119;
            r5 = r21.d();
        L119:
            String r31 = r30.a(r5);
            if (r31 == null) goto L122;
            r15.put("root_error_reason", r31);
        L122:
            if (r13 == null) goto L124;
            r15.put("failure_stage", r13);
        L124:
            if (r14 == null) goto L126;
            r15.put("error_code", r14);
        L126:
            x r32 = x.f38692a;
            a(OVirtReporter.EVENT_SKILL_PERFORMANCE, r15);
            return;
        L114:
            if (r21.c() != true) goto L116;
            r1 = true;
            goto L116
        L108:
            if (r21.b() != true) goto L110;
            r29 = true;
            goto L111
        L104:
            r28 = 0;
            goto L105
        L100:
            r27 = 0;
            goto L101
        L96:
            r26 = 0;
            goto L97
        L92:
            r25 = 0;
            goto L93
        L88:
            r0 = 0;
            goto L89
        L81:
            r110 = 0;
            goto L82
        L77:
            r19 = 0;
            goto L78
        L64:
            if (o.a(r12, "success") == true) goto L66;
            String r33 = r12;
        L67:
            if (r33 != null) goto L69;
            r14 = null;
            goto L74
        L69:
            if (o.a(r33, "cancel") == false) goto L71;
            r14 = "cancelled";
            goto L74
        L71:
            r14 = "skill_projection_failed";
            goto L74
        L66:
            r33 = null;
            goto L67
        L49:
            if (o.a(r12, "success") == false) goto L51;
            r13 = null;
            goto L62
        L51:
            if (r21 != null) goto L53;
        L57:
            if (r11 <= 0) goto L59;
        L58:
            r13 = "skill_projection";
            goto L62
        L59:
            if (r2 <= 0) goto L58;
            r13 = "manager_prepare";
            goto L62
        L53:
            if (r21.b() == true) goto L55;
        L56:
            r13 = "projection_root";
            goto L62
        L55:
            if (r21.c() == true) goto L57;
        L45:
            r12 = r22;
            goto L47
        L22:
            if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L24;
            r10 = 0;
        L16:
            r7 = null;
        L10:
            r4 = 0;
            goto L11
        L5:
            r2 = 0;
            goto L6
        }

        public static /* synthetic */ void a(a r7, String r8, long r9, com.obric.aiagent.skill.ovirt.impl.reporting.a r11, b r12, boolean r13, int r14, Object r15) {
            if ((r14 & 16) == 0) goto L5;
            r13 = false;
        L5:
            r7.a(r8, r9, r11, r12, r13);
        }

        public final void a(String r7, long r8, com.obric.aiagent.skill.ovirt.impl.reporting.a r10, b r11, boolean r12) {
            o.e(r7, DBDefinition.TASK_ID);
            o.e(r10, "reason");
            boolean r0 = false;
            if (r12 == true) goto L16;
            if (r11 != null) goto L6;
        L13:
            boolean r2 = false;
        L14:
            if (r2 == false) goto L16;
            boolean r3 = true;
        L17:
            JSONObject r4 = new JSONObject();
            r4.put(OVirtReporter.PARAM_SCHEMA_VERSION, 2);
            r4.put("operation", "skill_projection_fallback");
            if (r12 == false) goto L20;
            String r5 = "cancel";
        L23:
            r4.put("result", r5);
            r4.put("duration_ms", n.a(r8, 0));
            r4.put("trace_id", UUID.randomUUID().toString());
            r4.put("attempt_index", 1);
            String r9 = null;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L27;
            r7 = null;
        L27:
            if (r7 == null) goto L29;
            r4.put(KnowledgeActivity.KEY_TASK_ID, r7);
        L29:
            r4.put("fallback_reason", r10.a());
            if (r11 != null) goto L32;
        L34:
            boolean r13 = false;
        L35:
            r4.put("root_prepared", r13);
            if (r11 != null) goto L38;
        L40:
            r4.put("root_linked", r0);
            a r14 = OVirtReporter.Companion;
            if (r11 == null) goto L43;
            String r15 = r11.d();
        L44:
            String r16 = r14.a(r15);
            if (r16 != null) goto L50;
            if (r12 == false) goto L48;
            r9 = "fallback_cancelled";
        L51:
            if (r9 == null) goto L53;
            r4.put("root_error_reason", r9);
        L53:
            if (r3 == true) goto L58;
            if (r12 == false) goto L56;
            String r17 = "cancelled";
        L57:
            r4.put("error_code", r17);
            r4.put("failure_stage", "skill_projection");
            goto L58
        L56:
            r17 = "skill_projection_failed";
        L58:
            x r18 = x.f38692a;
            a(OVirtReporter.EVENT_SKILL_PERFORMANCE, r4);
            return;
        L48:
            if (r11 != null) goto L51;
            r9 = "fallback_projection_failed";
            goto L51
        L50:
            r9 = r16;
            goto L51
        L43:
            r15 = null;
            goto L44
        L38:
            if (r11.c() != true) goto L40;
            r0 = true;
            goto L40
        L32:
            if (r11.b() != true) goto L34;
            r13 = true;
            goto L35
        L20:
            if (r3 == false) goto L22;
            r5 = "success";
            goto L23
        L22:
            r5 = "fail";
            goto L23
        L6:
            if (r11.b() == true) goto L8;
        L10:
            boolean r6 = false;
        L11:
            if (r6 != true) goto L13;
            r2 = true;
            goto L14
        L8:
            if (r11.c() == false) goto L10;
            r6 = true;
        L16:
            r3 = false;
            goto L17
        }

        private final void a(t r6) {
            JSONObject r0 = new JSONObject();
            r0.put(OVirtReporter.PARAM_SCHEMA_VERSION, 2);
            r0.put("shell_type", r6.a());
            String r1 = r6.b();
            String r2 = null;
            if (r1 != null) goto L5;
        L10:
            r0.put("backend_type", r6.c());
            String r3 = r6.d();
            if (r3 != null) goto L13;
        L18:
            r0.put("result", r6.e());
            Integer r4 = r6.f();
            if (r4 == null) goto L21;
            r0.put("exit_code", ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
        L21:
            String r5 = r6.g();
            if (r5 != null) goto L24;
        L28:
            r0.put("entered_shell", r6.h());
            r0.put("primary_command", r6.i());
            r0.put("command_family", r6.j());
            r0.put("command_count", r6.k());
            r0.put("completed", r6.l());
            r0.put("killed", r6.m());
            r0.put("duration_ms", r6.n());
            r0.put("preprocess_duration_ms", r6.o());
            r0.put("backend_duration_ms", r6.p());
            r0.put("output_duration_ms", r6.q());
            r0.put("stdout_chars", r6.r());
            r0.put("stderr_chars", r6.s());
            x r7 = x.f38692a;
            a(OVirtReporter.EVENT_SHELL_EXECUTION_PERF, r0);
            return;
        L24:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L26;
            r2 = r5;
        L26:
            if (r2 == null) goto L28;
            r0.put("return_reason", r2);
            goto L28
        L13:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
            r3 = null;
        L16:
            if (r3 == null) goto L18;
            r0.put("execution_id", r3);
            goto L18
        L5:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
            r1 = null;
        L8:
            if (r1 == null) goto L10;
            r0.put(DBHelper.BATTERY_COL_SCENE, r1);
            goto L10
        }

        public final void a(String r14, String r15, int r16, long r17, int r19, int r20, int r21, boolean r22) {
            o.e(r14, DBDefinition.TASK_ID);
            o.e(r15, "skillSlug");
            if (r22 == false) goto L5;
            String r5 = "cancel";
        L10:
            JSONObject r6 = new JSONObject();
            r6.put(OVirtReporter.PARAM_SCHEMA_VERSION, 2);
            r6.put("operation", "skill_load_hook");
            r6.put("result", r5);
            r6.put("duration_ms", n.a(r17, 0));
            r6.put("trace_id", UUID.randomUUID().toString());
            r6.put("attempt_index", 1);
            r6.put(KnowledgeActivity.KEY_TASK_ID, r14);
            r6.put("skill_id", r15);
            r6.put("required_cli_count", n.c(r16, 0));
            r6.put("listener_count", n.c(r19, 0));
            r6.put("listener_succeeded_count", n.c(r20, 0));
            r6.put("listener_failed_count", n.c(r21, 0));
            if (o.a(r5, "success") == true) goto L17;
            r6.put("failure_stage", "skill_load_hook");
            if (r22 == false) goto L15;
            String r0 = "cancelled";
        L16:
            r6.put("error_code", r0);
            goto L17
        L15:
            r0 = "internal_failed";
        L17:
            x r1 = x.f38692a;
            a(OVirtReporter.EVENT_SKILL_PERFORMANCE, r6);
            return;
        L5:
            if (r21 != 0) goto L7;
            r5 = "success";
            goto L10
        L7:
            if (r20 <= 0) goto L9;
            r5 = "partial";
            goto L10
        L9:
            r5 = "fail";
            goto L10
        }

        public final void a(boolean r3) {
            JSONObject r0 = new JSONObject();
            if (r3 == false) goto L5;
            String r4 = OVirtReporter.SWITCH_STATUS_ON;
        L6:
            r0.put(OVirtReporter.PARAM_SWITCH_STATUS, r4);
            x r5 = x.f38692a;
            a(OVirtReporter.EVENT_SKILL_SWITCH, r0);
            return;
        L5:
            r4 = OVirtReporter.SWITCH_STATUS_OFF;
            goto L6
        }

        private final boolean a(String r11, JSONObject r12) {
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L18;
            ILogDepend.Companion.w(OVirtReporter.TAG, "report Virt event ignored blank event");
            return false;
        L18:
            d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
            a r10 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            AOBizTracking.INSTANCE.reportEvent(r11, r12, false, false, TrackingReportTarget.DEFAULT);     // Catch: Throwable -> L8
            Object r13 = d.n.f(true);     // Catch: Throwable -> L8
        L10:
            Throwable r14 = d.n.c(r13);
            if (r14 == null) goto L14;
            ILogDepend.Companion.w(OVirtReporter.TAG, "report Virt event failed event=" + r11, r14);
        L14:
            if (d.n.b(r13) == false) goto L17;
            r13 = false;
        L17:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L8:
            th = move-exception;
            d.n.a r15 = d.n.f38560a;
            r13 = d.n.f(d.o.a(th));
            goto L10
        }

        private final String a(String r2) {
            if (r2 != null) goto L5;
        L11:
            if (r2 == null) goto L15;
            return SensitiveType.UNKNOWN;
        L15:
            return null;
        L5:
            if (OVirtReporter.access$getALLOWED_ROOT_ERROR_REASONS$cp().contains(r2) == false) goto L7;
            String r0 = r2;
        L8:
            if (r0 == null) goto L11;
            return r0;
        L7:
            r0 = null;
            goto L8
        }
    }

    public OVirtReporter() {
    }

    public static final /* synthetic */ Set access$getALLOWED_ROOT_ERROR_REASONS$cp() {
        return ALLOWED_ROOT_ERROR_REASONS;
    }

    @Override // com.obric.aiagent.skill.virt.api.VirtReportSink
    public void reportShell(t r1) {
        o.e(r1, "report");
        a.a(Companion, r1);
    }

    @Override // com.obric.aiagent.skill.virt.api.VirtReportSink
    public boolean reportDiagnostics(w r6) {
        o.e(r6, "report");
        a r5 = Companion;
        JSONObject r0 = new JSONObject();
        r0.put(PARAM_SCHEMA_VERSION, 2);
        r0.put("backend_type", r6.a());
        r0.put("trigger", r6.b());
        r0.put("batch_id", r6.c());
        r0.put("chunk_index", r6.d());
        r0.put("chunk_count", r6.e());
        r0.put("source_type", r6.f());
        r0.put("bytes_read", r6.g());
        r0.put("line_count", r6.h());
        r0.put("malformed_line_count", r6.i());
        Long r1 = r6.j();
        if (r1 == null) goto L5;
        r0.put("first_timestamp_ms", ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue());
    L5:
        Long r2 = r6.k();
        if (r2 == null) goto L8;
        r0.put("last_timestamp_ms", ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue());
    L8:
        Long r3 = r6.l();
        if (r3 == null) goto L11;
        r0.put("first_monotonic_ns", ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue());
    L11:
        Long r4 = r6.m();
        if (r4 == null) goto L14;
        r0.put("last_monotonic_ns", ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue());
    L14:
        r0.put("info_count", r6.n());
        r0.put("warning_count", r6.o());
        r0.put("error_count", r6.p());
        r0.put("runtime_event_count", r6.q());
        r0.put("shell_event_count", r6.r());
        r0.put("process_event_count", r6.s());
        r0.put("file_event_count", r6.t());
        r0.put("other_event_count", r6.u());
        r0.put("failure_event_count", r6.v());
        r0.put("timeout_event_count", r6.w());
        r0.put("kill_event_count", r6.x());
        r0.put("cursor_reset", r6.y());
        r0.put("rotated", r6.z());
        r0.put("clear_status", r6.A());
        x r7 = x.f38692a;
        return a.a(r5, EVENT_VIRT_DIAGNOSTICS, r0);
    }

    static {
        Companion = new a(null);
        ALLOWED_ROOT_ERROR_REASONS = ax.a(new String[]{"share_root_unavailable", "root_prepare_failed", "item_cleanup_failed", "root_link_failed"});
    }
}
