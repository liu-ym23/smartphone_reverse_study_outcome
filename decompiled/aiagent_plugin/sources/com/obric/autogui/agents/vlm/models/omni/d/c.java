package com.obric.autogui.agents.vlm.models.omni.d;

import com.obric.autogui.agents.a.a.j;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.z;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniPreActionPageStateTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "OmniPreActionPageState";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28333a = null;

    static {
        f28333a = new c();
    }

    private c() {
    }

    public final void a(l r34, String r35, g r36, com.obric.autogui.agents.vlm.a r37, j r38) {
        String r1 = r35;
        o.e(r34, "action");
        o.e(r36, "step");
        o.e(r37, "position");
        o.e(r38, "observation");
        if (ZeusTransformUtils.instanceOf(r36, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.a.b r0 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r36, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L12;
        String r2 = r0.f();
        if (r2 == null) goto L12;
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r3 == null) goto L12;
        String r4 = r3.toLowerCase(Locale.ROOT);
        o.c(r4, "toLowerCase(...)");
    L14:
        if (r4 != null) goto L16;
        String r14 = "";
    L18:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        Loog.INSTANCE.i(TAG, "[OAutoPreActionPageState] 动作前页面埋点跳过 step_id=" + r36.W() + ", reason=empty_action_type");
        return;
    L25:
        long r16 = AOSystemTools.INSTANCE.bootTimeMillis();
        com.obric.autogui.agents.vlm.models.impl.c.b r6 = r36.o();     // Catch: Exception -> L89 CancellationException -> L96
        com.obric.autogui.agents.vlm.models.impl.c.b r7 = com.obric.autogui.agents.vlm.models.impl.c.c.f27619a.a(r38.a(), r38.b());     // Catch: Exception -> L89 CancellationException -> L96
        com.obric.autogui.agents.vlm.models.impl.c.a r8 = com.obric.autogui.agents.vlm.models.impl.c.c.f27619a.a(r6, r7);     // Catch: Exception -> L89 CancellationException -> L96
        z r9 = r34.i();     // Catch: Exception -> L89 CancellationException -> L96
        int r10 = r37.a();     // Catch: Exception -> L89 CancellationException -> L96
        Boolean r15 = Boolean.valueOf(r8.b());     // Catch: Exception -> L89 CancellationException -> L96
        r15.booleanValue();     // Catch: Exception -> L89 CancellationException -> L96
        if (r8.a() == true) goto L30;
        r15 = null;
    L30:
        Boolean r19 = Boolean.valueOf(r8.d());     // Catch: Exception -> L89 CancellationException -> L96
        r19.booleanValue();     // Catch: Exception -> L89 CancellationException -> L96
        if (r8.c() == false) goto L33;
        Boolean r13 = r19;
    L100:
        Boolean r20 = Boolean.valueOf(r8.f());     // Catch: Exception -> L87 CancellationException -> L96
        r20.booleanValue();     // Catch: Exception -> L87 CancellationException -> L96
        if (r8.e() == false) goto L37;
        Boolean r12 = r20;
    L102:
        boolean r11 = r9.a(r10, r15, r13, r12);     // Catch: Exception -> L85 CancellationException -> L96
        long r17 = n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r16, 0);     // Catch: Exception -> L85 CancellationException -> L96
        String r18 = r34.a().g() + ':' + r37.a() + ':' + r36.W();     // Catch: Exception -> L85 CancellationException -> L96
        IAutoActionTrackingApi r22 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L85 CancellationException -> L96
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("schema_version", 1);     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("report_phase", "before_action");     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("observation_point", "action_effect_primary_operation_before_perform");     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "session_id", r34.a().b());     // Catch: Exception -> L85 CancellationException -> L96
        f.a(r110, r1);     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "instruction_id", r34.a().j());     // Catch: Exception -> L85 CancellationException -> L96
        Long r111 = r34.a().a();     // Catch: Exception -> L85 CancellationException -> L96
        if (r111 == null) goto L41;
        String r112 = r111.toString();     // Catch: Exception -> L85 CancellationException -> L96
    L42:
        d.a(r110, "doubao_message_id", r112);     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "tool_id", r34.a().g());     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "tool_name", r34.a().h());     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "instruction_type", r34.a().i());     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "request_action_type", r34.f());     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("action_type", r14);     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "step_id", r36.W());     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("action_index", r37.a());     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("action_count", r37.b());     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("is_multi_action", r37.c());     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("fingerprint_scope", "tool_action_salted_128bit");     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "model", r6, r18);     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, "pre_action", r7, r18);     // Catch: Exception -> L85 CancellationException -> L96
        d.a(r110, r8);     // Catch: Exception -> L85 CancellationException -> L96
        r110.put("pre_action_digest_elapsed_ms", r17);     // Catch: Exception -> L85 CancellationException -> L96
        if (r6 == null) goto L45;
        Long r21 = r6.a();     // Catch: Exception -> L85 CancellationException -> L96
    L46:
        Long r113 = r7.a();     // Catch: Exception -> L85 CancellationException -> L96
        if (r21 == null) goto L52;
        if (r113 == null) goto L52;
        long r30 = r17;
        long r114 = r113.longValue() - r21.longValue();     // Catch: Exception -> L85 CancellationException -> L96
        if (r114 < 0) goto L53;
        r110.put("model_to_action_evidence_elapsed_ms", r114);     // Catch: Exception -> L85 CancellationException -> L96
    L53:
        x r23 = x.f38692a;     // Catch: Exception -> L85 CancellationException -> L96
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r22, "oauto_pre_action_page_state", r110, false, false, null, 28, null);     // Catch: Exception -> L85 CancellationException -> L96
        Loog r24 = Loog.INSTANCE;     // Catch: Exception -> L85 CancellationException -> L96
        StringBuilder r115 = new StringBuilder();     // Catch: Exception -> L85 CancellationException -> L96
        StringBuilder r116 = r115.append("[OAutoPreActionPageState] 动作前页面埋点已提交 action=").append(r14).append(", step_id=").append(r36.W()).append(", tool_id=").append(r34.a().g()).append(", log_id=");     // Catch: Exception -> L85 CancellationException -> L96
        if (r1 != null) goto L56;
        String r117 = "";
    L57:
        StringBuilder r118 = r116.append(r117).append(", action_index=").append(r37.a()).append(", action_count=").append(r37.b()).append(", model_source=");     // Catch: Exception -> L85 CancellationException -> L96
        if (r6 == null) goto L60;
        String r119 = r6.b();     // Catch: Exception -> L85 CancellationException -> L96
    L61:
        if (r119 != null) goto L63;
        r119 = r13;
    L63:
        StringBuilder r120 = r118.append(r119).append(", pre_action_source=").append(r7.b()).append(", model_dimensions=");     // Catch: Exception -> L85 CancellationException -> L96
        if (r6 == null) goto L66;
        String r25 = r6.l();     // Catch: Exception -> L85 CancellationException -> L96
    L67:
        if (r25 != null) goto L69;
        r25 = r13;
    L69:
        r120.append(r25).append(", pre_action_dimensions=").append(r7.l()).append(", compared_dimensions=").append(r8.k()).append(", page_state_changed=");     // Catch: Exception -> L85 CancellationException -> L96
        if (r8.h() == false) goto L72;
        String r26 = String.valueOf(r8.i());     // Catch: Exception -> L85 CancellationException -> L96
    L73:
        StringBuilder r27 = r115.append(r26).append(", changed_dimensions=").append(r8.j()).append(", image_hamming_distance=");     // Catch: Exception -> L85 CancellationException -> L96
        Integer r28 = r8.g();     // Catch: Exception -> L85 CancellationException -> L96
        if (r28 == null) goto L76;
        String r121 = r28.toString();     // Catch: Exception -> L85 CancellationException -> L96
    L77:
        if (r121 != null) goto L79;
        r121 = r13;
    L79:
        r27.append(r121).append(", hyper_params_comparison_recorded=").append(r11).append(", digest_elapsed_ms=").append(r30);     // Catch: Exception -> L85 CancellationException -> L96
        String r29 = r115.toString();     // Catch: Exception -> L85 CancellationException -> L96
        String r31 = TAG;
        r24.i(r31, r29);     // Catch: Exception -> L83 CancellationException -> L96
    L106:
        return;
    L83:
        e = e;
    L91:
        Loog r32 = Loog.INSTANCE;
        StringBuilder r33 = new StringBuilder().append("[OAutoPreActionPageState] 动作前页面埋点失败 action=").append(r14).append(", step_id=").append(r36.W()).append(", tool_id=").append(r34.a().g()).append(", log_id=");
        if (r1 != null) goto L94;
        r1 = r19;
    L94:
        r32.w(r31, r33.append(r1).append(", action_index=").append(r37.a()).append(", action_count=").append(r37.b()).append(", error_type=").append(e.getClass().getSimpleName()).append(", original_action_preserved=true").toString());
        return;
    L76:
        r121 = null;
        goto L77
    L72:
        r26 = r13;
        goto L73
    L66:
        r25 = null;
        goto L67
    L60:
        r119 = null;
        goto L61
    L56:
        r117 = r1;
    L52:
        r30 = r17;
        goto L53
    L45:
        r21 = null;
        goto L46
    L41:
        r112 = null;
    L85:
        e = e;
        r31 = r12;
        goto L91
    L37:
        r12 = null;
    L87:
        e = e;
        r31 = TAG;
        goto L91
    L33:
        r13 = null;
    L89:
        e = e;
        r31 = TAG;
        String r122 = "";
    L96:
        e = move-exception;
        throw e;
    L20:
        r5 = false;
        goto L22
    L16:
        r14 = r4;
    L12:
        r4 = null;
        goto L14
    L5:
        r0 = null;
        goto L6
    }
}
