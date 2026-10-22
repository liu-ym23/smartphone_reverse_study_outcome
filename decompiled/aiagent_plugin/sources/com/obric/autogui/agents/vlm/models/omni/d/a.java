package com.obric.autogui.agents.vlm.models.omni.d;

import com.obric.autogui.agents.a.f.g;
import com.obric.autogui.agents.a.m.i;
import com.obric.autogui.agents.a.m.v;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniActionEffectTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "OmniActionEffectTrack";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28330a = null;

    static {
        f28330a = new a();
    }

    private a() {
    }

    public final void a(l r2, String r3, com.obric.autogui.agents.vlm.models.omni.e r4) {
        o.e(r2, "action");
        o.e(r4, "entry");
        a(r2, r3, r4, "action_completion");
        b(r2, r3, r4, "action_completion");
    }

    public final void a(l r37, String r38, com.obric.autogui.agents.vlm.models.omni.f r39, int r40, boolean r41, boolean r42, String r43, String r44) {
        o.e(r37, "action");
        o.e(r39, "evaluation");
        com.obric.autogui.agents.vlm.models.omni.b r9 = r39.o();
        Boolean r10 = r37.j();
        Boolean r20 = r37.l();
        com.obric.autogui.agents.vlm.models.impl.c r21 = r37.k();
        Map r11 = ao.e(b.a(r39, r37.f(), r10));
        b.a(r11, r37, r39);
        b.a(r11, r37);
        String r25 = null;
        n.a r26 = n.f38560a;     // Catch: Throwable -> L107
        Boolean r27 = r10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        IAutoActionTrackingApi r28 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        JSONObject r4 = r3.a(r37, r38);     // Catch: Throwable -> L105
        r4.put("report_phase", "notify");     // Catch: Throwable -> L105
        Iterator r12 = r11.entrySet().iterator();     // Catch: Throwable -> L105
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        r4.put((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin"), r13.getValue());     // Catch: Throwable -> L105
        goto L7
    L9:
        String r0 = r37.g();     // Catch: Throwable -> L105
        if (r0 == null) goto L12;
        r4.put("model_action_args", r0);     // Catch: Throwable -> L105
    L12:
        if (r43 == null) goto L14;
        r4.put("attached_first_effect_evaluation", r43);     // Catch: Throwable -> L105
    L14:
        if (r44 == null) goto L16;
        r4.put("attached_end_effect_evaluation", r44);     // Catch: Throwable -> L105
    L16:
        r4.put("notify_code", r40);     // Catch: Throwable -> L105
        r4.put("notify_success", r41);     // Catch: Throwable -> L105
        r4.put("effect_evaluation_attached", r42);     // Catch: Throwable -> L105
        if (r20 == null) goto L19;
        r4.put("is_white_screen", r20.booleanValue());     // Catch: Throwable -> L105
    L19:
        x r1 = x.f38692a;     // Catch: Throwable -> L105
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r28, "oauto_post_action_check", r4, false, false, null, 28, null);     // Catch: Throwable -> L105
        Loog r2 = Loog.INSTANCE;     // Catch: Throwable -> L105
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L105
        StringBuilder r6 = r5.append("[OAutoActionEffect]  request_action_type=").append(r37.f()).append(", tool_id=").append(r37.a().g()).append(", log_id=");     // Catch: Throwable -> L105
        if (r38 != null) goto L22;
        String r14 = "";
    L23:
        r6.append(r14).append(", is_multi_action=").append(r39.e()).append(", action_count=").append(r39.a()).append(", evaluated_action_count=").append(r39.g()).append(", completed_action_count=").append(r39.h()).append(", ineffective_action_count=").append(r39.i()).append(", missing_action_count=").append(r39.k()).append(", aggregate_completed=").append(r9.b()).append(", first_evaluations=").append(r39.l().a()).append(", end_evaluations=");     // Catch: Throwable -> L105
        StringBuilder r7 = r5.append(r39.l().b()).append(", action_result_code=").append(r39.m()).append(", action_result_reason=");     // Catch: Throwable -> L105
        String r15 = r39.n();     // Catch: Throwable -> L105
        if (r15 != null) goto L26;
        r15 = "";
    L26:
        StringBuilder r8 = r7.append(r15).append(", overall_end_status=").append(r9.a()).append(", has_dynamic_surface=");     // Catch: Throwable -> L105
        Boolean r16 = r39.j();     // Catch: Throwable -> L105
        if (r16 == null) goto L29;
        String r17 = r16.toString();     // Catch: Throwable -> L105
    L30:
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        StringBuilder r18 = r8.append(r17).append(", decisive_action_index=");     // Catch: Throwable -> L105
        com.obric.autogui.agents.vlm.models.omni.e r19 = r9.c();     // Catch: Throwable -> L105
        if (r19 == null) goto L35;
        String r22 = Integer.valueOf(r19.a()).toString();     // Catch: Throwable -> L105
    L36:
        if (r22 != null) goto L38;
        r22 = "";
    L38:
        StringBuilder r23 = r18.append(r22).append(", decisive_action_type=");     // Catch: Throwable -> L105
        com.obric.autogui.agents.vlm.models.omni.e r24 = r9.c();     // Catch: Throwable -> L105
        if (r24 == null) goto L43;
        g r29 = r24.e();     // Catch: Throwable -> L105
        if (r29 == null) goto L43;
        String r30 = r29.b();     // Catch: Throwable -> L105
    L44:
        if (r30 != null) goto L46;
        r30 = "";
    L46:
        StringBuilder r31 = r23.append(r30).append(", decisive_attempt_id=");     // Catch: Throwable -> L105
        com.obric.autogui.agents.vlm.models.omni.e r32 = r9.c();     // Catch: Throwable -> L105
        if (r32 == null) goto L51;
        g r33 = r32.e();     // Catch: Throwable -> L105
        if (r33 == null) goto L51;
        String r34 = r33.a();     // Catch: Throwable -> L105
    L52:
        if (r34 != null) goto L54;
        r34 = "";
    L54:
        StringBuilder r35 = r31.append(r34).append(", attached_first_evaluations=");     // Catch: Throwable -> L105
        if (r43 != null) goto L57;
        String r36 = "";
    L58:
        StringBuilder r45 = r35.append(r36).append(", attached_end_evaluations=");     // Catch: Throwable -> L105
        if (r44 != null) goto L61;
        String r46 = "";
    L62:
        StringBuilder r47 = r45.append(r46).append(", model_action_args_available=");     // Catch: Throwable -> L105
        if (r37.g() == null) goto L65;
        boolean r48 = true;
    L66:
        StringBuilder r49 = r47.append(r48).append(", model_action_args_length=");     // Catch: Throwable -> L105
        String r50 = r37.g();     // Catch: Throwable -> L105
        if (r50 == null) goto L69;
        int r51 = r50.length();     // Catch: Throwable -> L105
    L70:
        r49.append(r51);     // Catch: Throwable -> L105
        String r52 = ", top_activity_in_system_animation=";
        StringBuilder r53 = r5.append(r52);     // Catch: Throwable -> L103
        if (r27 == null) goto L75;
        String r110 = r27.toString();     // Catch: Throwable -> L103
    L76:
        if (r110 != null) goto L78;
        r110 = "";
    L78:
        StringBuilder r54 = r53.append(r110);     // Catch: Throwable -> L103
        String r111 = ", top_activity_in_system_animation_available=";
        StringBuilder r55 = r54.append(r111);     // Catch: Throwable -> L100
        if (r27 == null) goto L83;
        boolean r112 = true;
    L84:
        String r56 = ", is_white_screen=";
        StringBuilder r57 = r55.append(r112).append(", rule_stability_registered=").append(r21.a()).append(", rule_stability_page_switch_callback_received=").append(r21.b()).append(", rule_stability_wait_duration_ms=").append(r21.c()).append(", rule_stability_waited_for_page_switch=").append(r21.d()).append(r56);     // Catch: Throwable -> L98
        if (r20 == null) goto L89;
        String r58 = r20.toString();     // Catch: Throwable -> L98
    L90:
        if (r58 != null) goto L92;
        r58 = "";
    L92:
        r57.append(r58).append(", notify_code=").append(r40).append(", notify_success=").append(r41).append(", evaluation_attached=").append(r42);     // Catch: Throwable -> L98
        String r59 = r5.toString();     // Catch: Throwable -> L98
        String r60 = TAG;
        r2.i(r60, r59);     // Catch: Throwable -> L96
        Object r61 = n.f(x.f38692a);     // Catch: Throwable -> L96
    L111:
        Throwable r62 = n.c(r61);
        if (r62 == null) goto L134;
        Loog r63 = Loog.INSTANCE;
        StringBuilder r64 = new StringBuilder().append("[OAutoActionEffect] request_action_type=").append(r37.f()).append(", tool_id=").append(r37.a().g()).append(", log_id=");
        if (r38 != null) goto L116;
        String r113 = "";
    L117:
        StringBuilder r65 = r64.append(r113).append(", is_multi_action=").append(r39.e()).append(", action_count=").append(r39.a()).append(r52);
        if (r27 == null) goto L120;
        String r66 = r27.toString();
    L121:
        if (r66 != null) goto L123;
        r66 = "";
    L123:
        StringBuilder r67 = r65.append(r66).append(r111);
        if (r27 == null) goto L126;
        boolean r68 = true;
    L127:
        StringBuilder r69 = r67.append(r68).append(r56);
        if (r20 == null) goto L130;
        r25 = r20.toString();
    L130:
        if (r25 != null) goto L132;
        String r70 = "";
    L133:
        r63.w(r60, r69.append(r70).append(", error_type=").append(com.obric.autogui.agents.a.b.a(r62)).toString());
        goto L134
    L132:
        r70 = r25;
        goto L133
    L126:
        r68 = false;
        goto L127
    L120:
        r66 = null;
        goto L121
    L116:
        r113 = r38;
    L134:
        b(r37, r38, r39, r40, r41, r42, r43, r44);
        return;
    L96:
        th = th;
    L110:
        n.a r71 = n.f38560a;
        r61 = n.f(d.o.a(th));
        goto L111
    L89:
        r58 = null;
    L98:
        th = th;
    L102:
        r60 = TAG;
        goto L110
    L83:
        r112 = false;
    L100:
        th = th;
        r56 = ", is_white_screen=";
        goto L102
    L75:
        r110 = null;
    L103:
        th = th;
        r56 = ", is_white_screen=";
        r60 = TAG;
        r111 = ", top_activity_in_system_animation_available=";
        goto L110
    L69:
        r51 = 0;
        goto L70
    L65:
        r48 = false;
        goto L66
    L61:
        r46 = r44;
        goto L62
    L57:
        r36 = r43;
    L51:
        r34 = null;
    L43:
        r30 = null;
        goto L44
    L35:
        r22 = null;
        goto L36
    L29:
        r17 = null;
        goto L30
    L22:
        r14 = r38;
    L105:
        th = th;
    L109:
        r56 = ", is_white_screen=";
        r60 = TAG;
        r111 = ", top_activity_in_system_animation_available=";
        r52 = ", top_activity_in_system_animation=";
    L107:
        th = th;
        r27 = r10;
        goto L109
    }

    public final void a(l r33, String r34, com.obric.autogui.agents.vlm.models.omni.f r35, com.obric.autogui.agents.vlm.models.omni.e r36, int r37, boolean r38, String r39, String r40) {
        String r2 = r34;
        String r17 = TAG;
        o.e(r33, "action");
        o.e(r35, "snapshot");
        String r18 = ", top_activity_in_system_animation_available=";
        o.e(r36, "completedEntry");
        Boolean r14 = r33.j();
        Map r7 = ao.e(b.a(r35, r33.f(), r14));
        b.a(r7, r33, r35);
        b.a(r7, r33);
        String r21 = null;
        n.a r22 = n.f38560a;     // Catch: Throwable -> L83
        a r0 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L83
        IAutoActionTrackingApi r24 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L81
        JSONObject r1 = r0.a(r33, r2);     // Catch: Throwable -> L81
        r1.put("report_phase", "async_completion");     // Catch: Throwable -> L81
        Iterator r8 = r7.entrySet().iterator();     // Catch: Throwable -> L81
    L7:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L81
        r1.put((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin"), r9.getValue());     // Catch: Throwable -> L81
        goto L7
    L9:
        String r3 = r33.g();     // Catch: Throwable -> L81
        if (r3 == null) goto L12;
        r1.put("model_action_args", r3);     // Catch: Throwable -> L81
    L12:
        r1.put("late_completed_action_index", r36.a());     // Catch: Throwable -> L81
        if (r39 == null) goto L15;
        r1.put("attached_first_effect_evaluation", r39);     // Catch: Throwable -> L81
    L15:
        if (r40 == null) goto L17;
        r1.put("attached_end_effect_evaluation", r40);     // Catch: Throwable -> L81
    L17:
        r1.put("notify_code", r37);     // Catch: Throwable -> L81
        r1.put("notify_success", r38);     // Catch: Throwable -> L81
        boolean r5 = false;
        r1.put("effect_evaluation_attached", false);     // Catch: Throwable -> L79
        x r4 = x.f38692a;     // Catch: Throwable -> L79
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r24, "oauto_post_action_check", r1, false, false, null, 28, null);     // Catch: Throwable -> L79
        Loog r6 = Loog.INSTANCE;     // Catch: Throwable -> L79
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L79
        StringBuilder r11 = r10.append("[OAutoActionEffect] 异步请求级终态补报已提交 action=").append(r36.e().b()).append(", attempt_id=").append(r36.e().a()).append(", action_index=").append(r36.a()).append(", action_count=").append(r36.b()).append(", tool_id=").append(r33.a().g()).append(", log_id=");     // Catch: Throwable -> L79
        if (r2 != null) goto L22;
        String r12 = "";
    L23:
        StringBuilder r13 = r11.append(r12).append(", aggregate_completed=").append(r35.o().b()).append(", first_evaluations=").append(r35.l().a()).append(", end_evaluations=").append(r35.l().b()).append(", overall_end_status=").append(r35.o().a()).append(", model_action_args_available=");     // Catch: Throwable -> L79
        if (r33.g() == null) goto L26;
        boolean r15 = true;
    L27:
        r13.append(r15).append(", model_action_args_length=");     // Catch: Throwable -> L79
        String r16 = r33.g();     // Catch: Throwable -> L79
        if (r16 == null) goto L30;
        int r19 = r16.length();     // Catch: Throwable -> L79
    L31:
        String r20 = ", top_activity_in_system_animation=";
        StringBuilder r23 = r10.append(r19).append(r20);     // Catch: Throwable -> L77
        if (r14 == null) goto L36;
        String r25 = r14.toString();     // Catch: Throwable -> L77
    L37:
        if (r25 != null) goto L39;
        r25 = "";
    L39:
        StringBuilder r26 = r23.append(r25);     // Catch: Throwable -> L77
        r18 = r18;
        StringBuilder r27 = r26.append(r18);     // Catch: Throwable -> L75
        if (r14 == null) goto L44;
        boolean r110 = true;
    L45:
        StringBuilder r28 = r27.append(r110).append(", rule_stability_registered=");     // Catch: Throwable -> L75
        com.obric.autogui.agents.vlm.models.impl.c r111 = r33.k();     // Catch: Throwable -> L75
        if (r111 == null) goto L48;
        String r112 = Boolean.valueOf(r111.a()).toString();     // Catch: Throwable -> L75
    L49:
        if (r112 != null) goto L51;
        r112 = "";
    L51:
        StringBuilder r29 = r28.append(r112).append(", rule_stability_page_switch_callback_received=");     // Catch: Throwable -> L75
        com.obric.autogui.agents.vlm.models.impl.c r113 = r33.k();     // Catch: Throwable -> L75
        if (r113 == null) goto L54;
        String r114 = Boolean.valueOf(r113.b()).toString();     // Catch: Throwable -> L75
    L55:
        if (r114 != null) goto L57;
        r114 = "";
    L57:
        StringBuilder r30 = r29.append(r114).append(", rule_stability_wait_duration_ms=");     // Catch: Throwable -> L75
        com.obric.autogui.agents.vlm.models.impl.c r115 = r33.k();     // Catch: Throwable -> L75
        if (r115 == null) goto L60;
        String r116 = Long.valueOf(r115.c()).toString();     // Catch: Throwable -> L75
    L61:
        if (r116 != null) goto L63;
        r116 = "";
    L63:
        StringBuilder r31 = r30.append(r116).append(", rule_stability_waited_for_page_switch=");     // Catch: Throwable -> L75
        com.obric.autogui.agents.vlm.models.impl.c r117 = r33.k();     // Catch: Throwable -> L75
        if (r117 == null) goto L66;
        String r118 = Boolean.valueOf(r117.d()).toString();     // Catch: Throwable -> L75
    L67:
        if (r118 != null) goto L69;
        r118 = "";
    L69:
        r31.append(r118).append(", notify_code=").append(r37).append(", notify_success=").append(r38).append(", evaluation_attached=false");     // Catch: Throwable -> L75
        r17 = r17;
        r6.i(r17, r10.toString());     // Catch: Throwable -> L73
        Object r32 = n.f(x.f38692a);     // Catch: Throwable -> L73
    L87:
        Throwable r41 = n.c(r32);
        if (r41 == null) goto L116;
        Loog r42 = Loog.INSTANCE;
        StringBuilder r43 = new StringBuilder().append("[OAutoActionEffect] 异步请求级终态补报失败 action=").append(r36.e().b()).append(", attempt_id=").append(r36.e().a()).append(", action_index=").append(r36.a()).append(", action_count=").append(r36.b()).append(", tool_id=").append(r33.a().g()).append(", log_id=");
        if (r2 != null) goto L92;
        r2 = "";
    L92:
        StringBuilder r44 = r43.append(r2).append(r20);
        if (r14 == null) goto L95;
        r21 = r14.toString();
    L95:
        if (r21 != null) goto L97;
        String r45 = "";
    L98:
        StringBuilder r46 = r44.append(r45).append(r18);
        if (r14 == null) goto L101;
        r5 = true;
    L101:
        r42.w(r17, r46.append(r5).append(", error_type=").append(com.obric.autogui.agents.a.b.a(r41)).toString());
        return;
    L97:
        r45 = r21;
        goto L98
    L116:
        return;
    L73:
        th = th;
    L86:
        n.a r47 = n.f38560a;
        r32 = n.f(d.o.a(th));
        goto L87
    L66:
        r118 = null;
        goto L67
    L60:
        r116 = null;
        goto L61
    L54:
        r114 = null;
        goto L55
    L48:
        r112 = null;
        goto L49
    L44:
        r110 = false;
    L75:
        th = th;
        r17 = r17;
        goto L86
    L36:
        r25 = null;
    L77:
        th = th;
        r17 = r17;
        r18 = r18;
        goto L86
    L30:
        r19 = 0;
        goto L31
    L26:
        r15 = false;
        goto L27
    L22:
        r12 = r2;
    L79:
        th = th;
        r17 = r17;
        r18 = r18;
        r20 = ", top_activity_in_system_animation=";
    L81:
        th = th;
        r20 = ", top_activity_in_system_animation=";
    L85:
        r5 = false;
    L83:
        th = th;
        r20 = ", top_activity_in_system_animation=";
        goto L85
    }

    private final void a(l r24, String r25, com.obric.autogui.agents.vlm.models.omni.e r26, String r27) {
        String r1 = r25;
        if (r26.d() == true) goto L5;
        return;
    L5:
        v r0 = r26.e().j();
        if (r0 == null) goto L10;
        com.obric.autogui.agents.a.m.g r2 = r0.j();
        if (r2 == null) goto L10;
        List<com.obric.autogui.agents.a.m.e> r3 = r2.f();
    L11:
        if (r3 != null) goto L13;
        r3 = p.b();
    L13:
        List<com.obric.autogui.agents.a.m.e> r4 = r3;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r6 = 0;
    L14:
        String r7 = "";
        if (r5.hasNext() == false) goto L44;
        com.obric.autogui.agents.a.m.e r12 = (com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.autogui.agents.a.m.e.class, "com.obric.aiagent.plugin");
        a r8 = f28330a;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L31
        IAutoActionTrackingApi r14 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        Iterator r23 = r5;
        JSONObject r9 = r8.c(r24, r1, r26, r27);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, Object>> r16 = b.a(r12).entrySet().iterator();     // Catch: Throwable -> L29
    L21:
        if (r16.hasNext() == false) goto L25;
        String r22 = r7;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        r9.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin"), r10.getValue());     // Catch: Throwable -> L27
        r7 = r22;
    L27:
        th = th;
    L34:
        n.a r11 = n.f38560a;
        Object r15 = n.f(d.o.a(th));
    L35:
        Throwable r17 = n.c(r15);
        if (r17 == null) goto L42;
        Loog r18 = Loog.INSTANCE;
        StringBuilder r19 = new StringBuilder().append("[OAutoActionEffect] detector timing tracking failed phase=").append(r27).append(", action=").append(r26.e().b()).append(", attempt_id=").append(r26.e().a()).append(", log_id=");
        if (r1 != null) goto L40;
        String r20 = r22;
    L41:
        r18.w(TAG, r19.append(r20).append(", round=").append(r12.b()).append(", detector=").append(r12.c()).append(", error_type=").append(com.obric.autogui.agents.a.b.a(r17)).toString());
        goto L42
    L40:
        r20 = r1;
    L42:
        r5 = r23;
        goto L14
    L25:
        r22 = r7;
        x r21 = x.f38692a;     // Catch: Throwable -> L27
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r14, "oauto_action_effect_detector_timing", r9, false, false, null, 28, null);     // Catch: Throwable -> L27
        r6 = r6 + 1;     // Catch: Throwable -> L27
        r15 = n.f(x.f38692a);     // Catch: Throwable -> L27
    L29:
        th = th;
    L33:
        r22 = r7;
    L31:
        th = th;
        r23 = r5;
        goto L33
    L44:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L61;
        Loog r28 = Loog.INSTANCE;
        StringBuilder r29 = new StringBuilder().append("[OAutoActionEffect] detector timing tracking reported phase=").append(r27).append(", action=").append(r26.e().b()).append(", attempt_id=").append(r26.e().a()).append(", log_id=");
        if (r1 != null) goto L48;
        r1 = "";
    L48:
        r28.i(TAG, r29.append(r1).append(", event_count=").append(r6).append(", expected_count=").append(r4.size()).toString());
        return;
    L61:
        return;
    L10:
        r3 = null;
        goto L11
    }

    private final void b(l r24, String r25, com.obric.autogui.agents.vlm.models.omni.e r26, String r27) {
        String r1 = r25;
        if (r26.d() == true) goto L5;
        return;
    L5:
        v r0 = r26.e().j();
        if (r0 == null) goto L10;
        com.obric.autogui.agents.a.m.g r2 = r0.j();
        if (r2 == null) goto L10;
        List<i> r3 = r2.e();
    L11:
        if (r3 != null) goto L13;
        r3 = p.b();
    L13:
        List<i> r4 = r3;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r6 = 0;
    L14:
        String r7 = "";
        if (r5.hasNext() == false) goto L44;
        i r12 = (i) ZeusTransformUtils.preCheckCast(r5.next(), i.class, "com.obric.aiagent.plugin");
        a r8 = f28330a;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L31
        IAutoActionTrackingApi r14 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        Iterator r23 = r5;
        JSONObject r9 = r8.c(r24, r1, r26, r27);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, Object>> r16 = b.a(r12).entrySet().iterator();     // Catch: Throwable -> L29
    L21:
        if (r16.hasNext() == false) goto L25;
        String r22 = r7;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        r9.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin"), r10.getValue());     // Catch: Throwable -> L27
        r7 = r22;
    L27:
        th = th;
    L34:
        n.a r11 = n.f38560a;
        Object r15 = n.f(d.o.a(th));
    L35:
        Throwable r17 = n.c(r15);
        if (r17 == null) goto L42;
        Loog r18 = Loog.INSTANCE;
        StringBuilder r19 = new StringBuilder().append("[OAutoActionEffect] round timing tracking failed phase=").append(r27).append(", action=").append(r26.e().b()).append(", attempt_id=").append(r26.e().a()).append(", log_id=");
        if (r1 != null) goto L40;
        String r20 = r22;
    L41:
        r18.w(TAG, r19.append(r20).append(", round=").append(r12.b()).append(", error_type=").append(com.obric.autogui.agents.a.b.a(r17)).toString());
        goto L42
    L40:
        r20 = r1;
    L42:
        r5 = r23;
        goto L14
    L25:
        r22 = r7;
        x r21 = x.f38692a;     // Catch: Throwable -> L27
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r14, "oauto_action_effect_round_timing", r9, false, false, null, 28, null);     // Catch: Throwable -> L27
        r6 = r6 + 1;     // Catch: Throwable -> L27
        r15 = n.f(x.f38692a);     // Catch: Throwable -> L27
    L29:
        th = th;
    L33:
        r22 = r7;
    L31:
        th = th;
        r23 = r5;
        goto L33
    L44:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L61;
        Loog r28 = Loog.INSTANCE;
        StringBuilder r29 = new StringBuilder().append("[OAutoActionEffect] round timing tracking reported phase=").append(r27).append(", action=").append(r26.e().b()).append(", attempt_id=").append(r26.e().a()).append(", log_id=");
        if (r1 != null) goto L48;
        r1 = "";
    L48:
        r28.i(TAG, r29.append(r1).append(", event_count=").append(r6).append(", expected_count=").append(r4.size()).toString());
        return;
    L61:
        return;
    L10:
        r3 = null;
        goto L11
    }

    private final void b(l r24, String r25, com.obric.autogui.agents.vlm.models.omni.f r26, int r27, boolean r28, boolean r29, String r30, String r31) {
        String r1 = r25;
        String r3 = r30;
        String r4 = r31;
        String r9 = "";
        Map<String, Object> r11 = b.a(r26);
        n.a r12 = n.f38560a;     // Catch: Throwable -> L27
        a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        IAutoActionTrackingApi r14 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        JSONObject r15 = r13.a(r24, r1);     // Catch: Throwable -> L27
        Iterator<Map.Entry<String, Object>> r16 = r11.entrySet().iterator();     // Catch: Throwable -> L27
    L4:
        if (r16.hasNext() == false) goto L8;
        String r22 = r9;
        Iterator<Map.Entry<String, Object>> r23 = r16;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r15.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin"), r10.getValue());     // Catch: Throwable -> L25
        r16 = r23;
        r9 = r22;
    L25:
        th = th;
    L29:
        n.a r2 = n.f38560a;
        Object r0 = n.f(d.o.a(th));
    L30:
        Throwable r5 = n.c(r0);
        if (r5 == null) goto L42;
        Loog r6 = Loog.INSTANCE;
        StringBuilder r7 = new StringBuilder().append("[OAutoActionEffect] notify有效性埋点提交失败 tool_id=").append(r24.a().g()).append(", log_id=");
        if (r1 != null) goto L35;
        r1 = r22;
    L35:
        r6.w(TAG, r7.append(r1).append(", is_multi_action=").append(r26.e()).append(", action_count=").append(r26.a()).append(", error_type=").append(com.obric.autogui.agents.a.b.a(r5)).toString());
        return;
    L42:
        return;
    L8:
        r22 = r9;
        r15.put("notify_code", r27);     // Catch: Throwable -> L25
        r15.put("notify_success", r28);     // Catch: Throwable -> L25
        r15.put("effect_evaluation_attached", r29);     // Catch: Throwable -> L25
        if (r3 == null) goto L11;
        r15.put("attached_first_effect_evaluation", r3);     // Catch: Throwable -> L25
    L11:
        if (r4 == null) goto L13;
        r15.put("attached_end_effect_evaluation", r4);     // Catch: Throwable -> L25
    L13:
        x r17 = x.f38692a;     // Catch: Throwable -> L25
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r14, "oauto_action_effect_notify", r15, false, false, null, 28, null);     // Catch: Throwable -> L25
        Loog r18 = Loog.INSTANCE;     // Catch: Throwable -> L25
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L25
        StringBuilder r110 = r19.append("[OAutoActionEffect] notify有效性埋点已提交 tool_id=").append(r24.a().g()).append(", log_id=");     // Catch: Throwable -> L25
        if (r1 != null) goto L16;
        String r111 = r22;
    L17:
        r110.append(r111).append(", is_multi_action=").append(r26.e()).append(", action_count=").append(r26.a()).append(", evaluated_action_count=").append(r26.g()).append(", completed_action_count=").append(r26.h()).append(", ineffective_action_count=").append(r26.i()).append(", missing_action_count=").append(r26.k()).append(", aggregate_completed=").append(r26.o().b()).append(", first_evaluations=").append(r26.l().a()).append(", end_evaluations=").append(r26.l().b()).append(", action_result_code=");     // Catch: Throwable -> L25
        StringBuilder r112 = r19.append(r26.m()).append(", attached_first_evaluations=");     // Catch: Throwable -> L25
        if (r3 != null) goto L20;
        r3 = r22;
    L20:
        StringBuilder r8 = r112.append(r3).append(", attached_end_evaluations=");     // Catch: Throwable -> L25
        if (r4 != null) goto L23;
        r4 = r22;
    L23:
        r8.append(r4).append(", notify_success=").append(r28).append(", evaluation_attached=").append(r29);     // Catch: Throwable -> L25
        r18.i(TAG, r19.toString());     // Catch: Throwable -> L25
        r0 = n.f(x.f38692a);     // Catch: Throwable -> L25
        goto L30
    L16:
        r111 = r1;
    L27:
        th = th;
        r22 = r9;
        goto L29
    }

    private final JSONObject c(l r2, String r3, com.obric.autogui.agents.vlm.models.omni.e r4, String r5) {
        g r0 = r4.e();
        JSONObject r1 = a(r2, r3);
        r1.put("action_type", r0.b());
        r1.put("attempt_id", r0.a());
        r1.put("step_id", r4.c());
        boolean r6 = true;
        if (r4.b() > 1) goto L6;
        r6 = false;
    L6:
        r1.put("is_multi_action", r6);
        r1.put("action_index", r4.a());
        r1.put("action_count", r4.b());
        r1.put("report_phase", r5);
        return r1;
    }

    private final JSONObject a(l r3, String r4) {
        JSONObject r2 = new JSONObject();
        r2.put("session_id", r3.a().b());
        f.a(r2, r4);
        String r5 = r3.a().j();
        if (r5 == null) goto L5;
        r2.put("instruction_id", r5);
    L5:
        r2.put("tool_id", r3.a().g());
        r2.put("tool_name", r3.a().h());
        r2.put("instruction_type", r3.a().i());
        Long r6 = r3.a().a();
        if (r6 == null) goto L8;
        String r7 = r6.toString();
    L9:
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r2.put("doubao_message_id", r7);
        return r2;
    L8:
        r7 = null;
        goto L9
    }
}
