package com.obric.autogui.agents.vlm.models.omni.d;

import com.obric.autogui.agents.a.f.g;
import com.obric.autogui.agents.a.m.i;
import com.obric.autogui.agents.a.m.k;
import com.obric.autogui.agents.a.m.p;
import com.obric.autogui.agents.a.m.r;
import com.obric.autogui.agents.a.m.v;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.l.n;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OmniActionEffectTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<k> f28331a = null;

    /* JADX INFO: compiled from: OmniActionEffectTrackingReporter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28332a = null;

        static {
            int[] r0 = new int[k.values().length];
            r0[k.f26676a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[k.f26677b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[k.f26678c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[k.f26679d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f28332a = r0;
        }
    }

    public static final /* synthetic */ void a(Map r2, l r3) {
        b((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"), r3);
    }

    public static final /* synthetic */ void a(Map r2, l r3, com.obric.autogui.agents.vlm.models.omni.f r4) {
        b((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public static final Map<String, Object> a(com.obric.autogui.agents.vlm.models.omni.f r4) {
        o.e(r4, "snapshot");
        com.obric.autogui.agents.vlm.models.omni.b r0 = r4.o();
        return (Map) ZeusTransformUtils.preCheckCast(ao.d(new m[]{s.a("is_multi_action", Boolean.valueOf(r4.e())), s.a("action_count", Integer.valueOf(r4.a())), s.a("evaluated_action_count", Integer.valueOf(r4.g())), s.a("completed_action_count", Integer.valueOf(r4.h())), s.a("ineffective_action_count", Integer.valueOf(r4.i())), s.a("missing_action_count", Integer.valueOf(r4.k())), s.a("evaluation_available", Boolean.valueOf(r4.f())), s.a("evaluation_completed", Boolean.valueOf(r0.b())), s.a("effect_aggregate_completed", Boolean.valueOf(r0.b())), s.a("action_result_code", r4.m())}), Map.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Map a(com.obric.autogui.agents.vlm.models.omni.f r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = null;
    L6:
        return a(r0, r1, r2);
    }

    public static final Map<String, Object> a(com.obric.autogui.agents.vlm.models.omni.f r7, String r8, Boolean r9) {
        o.e(r7, "snapshot");
        o.e(r8, "requestActionType");
        LinkedHashMap r0 = new LinkedHashMap(a(r7));
        Boolean r1 = r7.j();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.booleanValue());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("has_dynamic_surface", r2);
    L5:
        if (r9 == null) goto L7;
        Boolean r10 = Boolean.valueOf(r9.booleanValue());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("top_activity_in_system_animation", r10);
    L7:
        String r11 = r7.n();
        if (r11 == null) goto L10;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("action_result_reason", r11);
    L10:
        com.obric.autogui.agents.vlm.models.omni.b r12 = r7.o();
        if (r7.e() == false) goto L20;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("action_type", "multi_action");
        com.obric.autogui.agents.vlm.models.omni.e r13 = r12.c();
        if (r13 == null) goto L15;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("decisive_action_index", Integer.valueOf(r13.a()));
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("decisive_action_type", r13.e().b());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("decisive_attempt_id", r13.e().a());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("effect_detection_method", a(r13.e()));
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("effect_detection_reason", b(r13.e()));
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("log_details", c(r13.e()));
    L15:
        com.obric.autogui.agents.vlm.models.omni.e r14 = b(r7);
        if (r14 == null) goto L19;
        r0.putAll(a(r14));
    L19:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    L20:
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("action_type", r8);
        com.obric.autogui.agents.vlm.models.omni.e r15 = b(r7);
        if (r15 != null) goto L23;
        r15 = r12.c();
    L23:
        if (r15 == null) goto L26;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("action_type", r15.e().b());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("attempt_id", r15.e().a());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("step_id", r15.c());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("effect_detection_method", a(r15.e()));
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("effect_detection_reason", b(r15.e()));
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put("log_details", c(r15.e()));
        r0.putAll(a(r15));
    L26:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.agents.vlm.models.omni.e b(com.obric.autogui.agents.vlm.models.omni.f r6) {
        Object r1 = null;
        if (r6.e() == false) goto L8;
        Integer r0 = r6.c();
        if (r0 == null) goto L7;
        int r2 = r0.intValue();
    L9:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r7.hasNext() == false) goto L19;
        Object r3 = r7.next();
        if (((com.obric.autogui.agents.vlm.models.omni.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.omni.e.class, "com.obric.aiagent.plugin")).a() != r2) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L11;
        r1 = r3;
        goto L19
    L15:
        r5 = false;
    L19:
        return (com.obric.autogui.agents.vlm.models.omni.e) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.agents.vlm.models.omni.e.class, "com.obric.aiagent.plugin");
    L7:
        return null;
    L8:
        r2 = 0;
        goto L9
    }

    private static final void b(Map<String, Object> r2, l r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.c r5 = r3.k();
        r4.put("rule_stability_registered", Boolean.valueOf(r5.a()));
        r4.put("rule_stability_page_switch_callback_received", Boolean.valueOf(r5.b()));
        r4.put("rule_stability_wait_duration_ms", Long.valueOf(r5.c()));
        r4.put("rule_stability_waited_for_page_switch", Boolean.valueOf(r5.d()));
    }

    private static final void b(Map<String, Object> r6, l r7, com.obric.autogui.agents.vlm.models.omni.f r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        x r10 = r7.m();
        if (r10 != null) goto L5;
        return;
    L5:
        Long r0 = r10.b();
        if (r0 == null) goto L8;
        r9.put("effect_model_viewtree_wait_elapsed_ms", Long.valueOf(n.a(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue(), 0)));
    L8:
        Long r1 = r10.d();
        if (r1 == null) goto L11;
        r9.put("white_screen_notify_wait_elapsed_ms", Long.valueOf(n.a(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue(), 0)));
    L11:
        com.obric.autogui.agents.vlm.models.omni.e r11 = b(r8);
        if (r11 == null) goto L36;
        v r2 = null;
        if (r11.d() == true) goto L17;
        r11 = null;
    L17:
        if (r11 == null) goto L37;
        g r12 = r11.e();
        if (r12 == null) goto L38;
        v r13 = r12.j();
        if (r13 != null) goto L23;
        return;
    L23:
        if (r13.b() == false) goto L25;
        r2 = r13;
    L25:
        if (r2 == null) goto L40;
        long r3 = n.a(r2.h().h() - r2.h().g(), 0) + n.a(r10.c(), 0);
        Long r14 = r10.b();
        if (r14 == null) goto L29;
        long r4 = r14.longValue();
    L30:
        long r5 = r3 + n.a(r4, 0);
        Long r15 = r10.d();
        if (r15 == null) goto L33;
        long r16 = r15.longValue();
    L34:
        r9.put("effect_core_blocking_total_elapsed_ms", Long.valueOf(r5 + n.a(r16, 0)));
        return;
    L33:
        r16 = 0;
        goto L34
    L29:
        r4 = 0;
        goto L30
    L40:
        return;
    L38:
        return;
    L37:
        return;
    }

    public static final String a(g r1) {
        o.e(r1, "evaluation");
        com.obric.autogui.agents.a.f.c r2 = r1.g();
        if (r2 == null) goto L5;
        String r3 = r2.a();
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public static final String b(g r1) {
        o.e(r1, "evaluation");
        return com.obric.autogui.agents.a.b.a(r1.h(), 240);
    }

    public static final String c(g r1) {
        o.e(r1, "evaluation");
        return com.obric.autogui.agents.a.b.a(r1.i(), 240);
    }

    public static final Map<String, Object> a(com.obric.autogui.agents.vlm.models.omni.e r19) {
        o.e(r19, "entry");
        g r0 = r19.e();
        if (r19.d() == false) goto L5;
        v r1 = r0.j();
        if (r1 != null) goto L11;
        return ao.a(s.a("effect_timing_available", false));
    L11:
        if (r1.b() == false) goto L13;
        List<p> r4 = r1.i();
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        d.a.p.a(r7, (Iterable) ZeusTransformUtils.preCheckCast(((p) ZeusTransformUtils.preCheckCast(r6.next(), p.class, "com.obric.aiagent.plugin")).e(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L16
    L18:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L19:
        boolean r12 = true;
        if (r11.hasNext() == false) goto L27;
        Object r13 = r11.next();
        if (((p) ZeusTransformUtils.preCheckCast(r13, p.class, "com.obric.aiagent.plugin")).b() == com.obric.autogui.agents.a.m.o.f26692a) goto L25;
        r12 = false;
    L25:
        if (r12 == false) goto L19;
        r10.add(r13);
        goto L19
    L27:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L29:
        if (r16.hasNext() == false) goto L31;
        d.a.p.a(r15, (Iterable) ZeusTransformUtils.preCheckCast(((p) ZeusTransformUtils.preCheckCast(r16.next(), p.class, "com.obric.aiagent.plugin")).e(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L29
    L31:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r17.iterator();
    L33:
        if (r20.hasNext() == false) goto L40;
        Object r21 = r20.next();
        if (((com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin")).b() != k.f26676a) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L33;
        r18.add(r21);
        goto L33
    L37:
        r110 = false;
        goto L38
    L40:
        List r22 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin");
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r25 = r23.iterator();
    L42:
        if (r25.hasNext() == false) goto L52;
        Object r26 = r25.next();
        p r111 = (p) ZeusTransformUtils.preCheckCast(r26, p.class, "com.obric.aiagent.plugin");
        if (r111.b() != com.obric.autogui.agents.a.m.o.f26693b) goto L46;
    L49:
        boolean r112 = true;
    L50:
        if (r112 == false) goto L42;
        r24.add(r26);
        goto L42
    L46:
        if (r111.b() == com.obric.autogui.agents.a.m.o.f26694c) goto L49;
        r112 = false;
        goto L50
    L52:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r29 = r27.iterator();
    L54:
        if (r29.hasNext() == false) goto L56;
        d.a.p.a(r28, (Iterable) ZeusTransformUtils.preCheckCast(((p) ZeusTransformUtils.preCheckCast(r29.next(), p.class, "com.obric.aiagent.plugin")).e(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L54
    L56:
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r31 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r32 = r30.iterator();
    L58:
        if (r32.hasNext() == false) goto L65;
        Object r33 = r32.next();
        if (((com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r33, com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin")).b() != k.f26676a) goto L62;
        boolean r113 = true;
    L63:
        if (r113 == false) goto L58;
        r31.add(r33);
        goto L58
    L62:
        r113 = false;
        goto L63
    L65:
        List r34 = (List) ZeusTransformUtils.preCheckCast(r31, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.m.g r35 = r1.j();
        if (r35 == null) goto L68;
        List<i> r36 = r35.e();
    L69:
        if (r36 != null) goto L71;
        r36 = d.a.p.b();
    L71:
        com.obric.autogui.agents.a.m.g r114 = r1.j();
        if (r114 == null) goto L74;
        List<com.obric.autogui.agents.a.m.e> r115 = r114.f();
    L75:
        if (r115 != null) goto L77;
        r115 = d.a.p.b();
    L77:
        m[] r116 = new m[24];
        r116[0] = s.a("effect_timing_available", true);
        r116[1] = s.a("effect_timing_schema_version", Integer.valueOf(r1.a()));
        r116[2] = s.a("effect_lifecycle_wall_elapsed_ms", Long.valueOf(n.a(r1.c(), 0)));
        com.obric.autogui.agents.a.m.s r117 = r1.d();
        if (r117 == null) goto L80;
        String r118 = r117.name();
    L81:
        String r119 = "";
        if (r118 != null) goto L84;
        r118 = "";
    L84:
        r116[3] = s.a("effect_lifecycle_finish_reason", r118);
        r r3 = r1.e();
        if (r3 == null) goto L87;
        String r37 = r3.name();
    L88:
        if (r37 != null) goto L90;
        r37 = "";
    L90:
        r116[4] = s.a("effect_cancellation_reason", r37);
        r116[5] = s.a("effect_evaluation_mode", r0.e().name());
        r116[6] = s.a("effect_core_blocking_total_elapsed_ms", Long.valueOf(r1.h().h()));
        r116[7] = s.a("effect_preparation_elapsed_ms", Long.valueOf(r1.h().a()));
        r116[8] = s.a("effect_before_operation_hook_elapsed_ms", Long.valueOf(r1.h().b()));
        r116[9] = s.a("effect_after_operation_hook_elapsed_ms", Long.valueOf(r1.h().c()));
        r116[10] = s.a("effect_skipped_operation_hook_elapsed_ms", Long.valueOf(r1.h().d()));
        r116[11] = s.a("effect_operation_hook_elapsed_ms", Long.valueOf(r1.h().e()));
        r116[12] = s.a("effect_completion_elapsed_ms", Long.valueOf(r1.h().f()));
        r116[13] = s.a("effect_model_screenshot_evaluation_elapsed_ms", Long.valueOf(r1.h().g()));
        if (r1.j() == null) goto L93;
        boolean r2 = true;
    L94:
        r116[14] = s.a("effect_evaluation_available", Boolean.valueOf(r2));
        com.obric.autogui.agents.a.m.g r38 = r1.j();
        if (r38 == null) goto L99;
        com.obric.autogui.agents.a.m.s r39 = r38.c();
        if (r39 == null) goto L99;
        String r40 = r39.name();
    L100:
        if (r40 != null) goto L102;
        r40 = "";
    L102:
        r116[15] = s.a("effect_evaluation_finish_reason", r40);
        if (r1.f() == null) goto L105;
        boolean r41 = true;
    L106:
        r116[16] = s.a("effect_framework_callback_available", Boolean.valueOf(r41));
        r116[17] = s.a("effect_round_count", Integer.valueOf(r36.size()));
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r42, Collection.class) == true) goto L109;
    L111:
        Iterator r43 = r42.iterator();
        int r44 = 0;
    L113:
        if (r43.hasNext() == false) goto L122;
        if (((i) ZeusTransformUtils.preCheckCast(r43.next(), i.class, "com.obric.aiagent.plugin")).h() != com.obric.autogui.agents.a.m.s.f26710a) goto L117;
        boolean r120 = true;
    L118:
        if (r120 == false) goto L113;
        r44 = r44 + 1;
        if (r44 >= 0) goto L113;
        d.a.p.d();
        goto L113
    L117:
        r120 = false;
    L122:
        r116[18] = s.a("effect_completed_round_count", Integer.valueOf(r44));
        r116[19] = s.a("effect_detector_execution_count", Integer.valueOf(r115.size()));
        Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r45, Collection.class) == true) goto L125;
    L127:
        Iterator r46 = r45.iterator();
        int r47 = 0;
    L129:
        if (r46.hasNext() == false) goto L138;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r46.next(), com.obric.autogui.agents.a.m.e.class, "com.obric.aiagent.plugin")).e() != com.obric.autogui.agents.a.m.s.f26712c) goto L133;
        boolean r121 = true;
    L134:
        if (r121 == false) goto L129;
        r47 = r47 + 1;
        if (r47 >= 0) goto L129;
        d.a.p.d();
        goto L129
    L133:
        r121 = false;
    L138:
        r116[20] = s.a("effect_detector_cancelled_count", Integer.valueOf(r47));
        Iterator r48 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r122 = 0;
    L140:
        if (r48.hasNext() == false) goto L142;
        r122 = r122 + n.a(((i) ZeusTransformUtils.preCheckCast(r48.next(), i.class, "com.obric.aiagent.plugin")).d(), 0);
        r1 = r1;
        goto L140
    L142:
        v r123 = r1;
        r116[21] = s.a("effect_delay_total_elapsed_ms", Long.valueOf(r122));
        Iterator r49 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r50 = 0;
    L144:
        if (r49.hasNext() == false) goto L146;
        r50 = r50 + n.a(((i) ZeusTransformUtils.preCheckCast(r49.next(), i.class, "com.obric.aiagent.plugin")).f(), 0);
        r49 = r49;
        goto L144
    L146:
        r116[22] = s.a("effect_detector_batch_total_elapsed_ms", Long.valueOf(r50));
        Iterator r51 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r52 = 0;
    L148:
        if (r51.hasNext() == false) goto L150;
        r52 = r52 + n.a(((i) ZeusTransformUtils.preCheckCast(r51.next(), i.class, "com.obric.aiagent.plugin")).g(), 0);
        r51 = r51;
        goto L148
    L150:
        r116[23] = s.a("effect_aggregation_total_elapsed_ms", Long.valueOf(r52));
        LinkedHashMap r53 = ao.d(r116);
        com.obric.autogui.agents.a.m.g r54 = r123.j();
        if (r54 == null) goto L160;
        r53.put("effect_evaluation_total_elapsed_ms", Long.valueOf(n.a(r54.a(), 0)));
        r53.put("effect_evaluation_control_elapsed_ms", Long.valueOf(n.a(r54.b(), 0)));
        r r55 = r54.d();
        if (r55 == null) goto L155;
        String r124 = r55.name();
    L156:
        if (r124 == null) goto L159;
        r119 = r124;
    L159:
        r53.put("effect_evaluation_cancellation_reason", r119);
        goto L160
    L155:
        r124 = null;
    L160:
        Long r56 = r123.f();
        if (r56 == null) goto L163;
        r53.put("registration_to_callback_elapsed_ms", Long.valueOf(n.a(((Number) ZeusTransformUtils.preCheckCast(r56, Number.class, "com.obric.aiagent.plugin")).longValue(), 0)));
    L163:
        Long r57 = r123.g();
        if (r57 == null) goto L166;
        r53.put("effect_framework_callback_processing_elapsed_ms", Long.valueOf(n.a(((Number) ZeusTransformUtils.preCheckCast(r57, Number.class, "com.obric.aiagent.plugin")).longValue(), 0)));
    L166:
        Iterator r58 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r59 = 0;
    L168:
        if (r58.hasNext() == false) goto L174;
        Long r60 = ((com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r58.next(), com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin")).d();
        if (r60 == null) goto L172;
        long r61 = n.a(r60.longValue(), 0);
    L173:
        r59 = r59 + r61;
        goto L168
    L172:
        r61 = 0;
        goto L173
    L174:
        r53.put("effect_snapshot_before_screenshot_elapsed_ms", Long.valueOf(r59));
        Iterator r62 = ((Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r63 = 0;
    L176:
        if (r62.hasNext() == false) goto L182;
        Long r64 = ((com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r62.next(), com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin")).d();
        if (r64 == null) goto L180;
        long r65 = n.a(r64.longValue(), 0);
    L181:
        r63 = r63 + r65;
        goto L176
    L180:
        r65 = 0;
        goto L181
    L182:
        r53.put("effect_snapshot_after_screenshot_elapsed_ms", Long.valueOf(r63));
        Iterable r66 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r66, Collection.class) == true) goto L185;
    L187:
        Iterator r67 = r66.iterator();
    L189:
        if (r67.hasNext() == false) goto L186;
        com.obric.autogui.agents.a.m.m r68 = (com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r67.next(), com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin");
        if (r68.b() == k.f26676a) goto L193;
    L197:
        boolean r69 = false;
    L198:
        if (r69 == false) goto L189;
        boolean r70 = true;
    L200:
        r53.put("effect_snapshot_screenshot_has_result", Boolean.valueOf(r70));
        Iterator r71 = ((Iterable) ZeusTransformUtils.preCheckCast(f28331a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L202:
        if (r71.hasNext() == false) goto L239;
        k r72 = (k) ZeusTransformUtils.preCheckCast(r71.next(), k.class, "com.obric.aiagent.plugin");
        String r73 = a(r72);
        Iterable r74 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r75 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r76 = r74.iterator();
    L205:
        if (r76.hasNext() == false) goto L212;
        Object r77 = r76.next();
        if (((com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r77, com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin")).b() != r72) goto L209;
        boolean r125 = true;
    L210:
        if (r125 == false) goto L205;
        r75.add(r77);
        goto L205
    L209:
        r125 = false;
        goto L210
    L212:
        List r78 = (List) ZeusTransformUtils.preCheckCast(r75, List.class, "com.obric.aiagent.plugin");
        String r79 = "effect_snapshot_" + r73 + "_elapsed_ms";
        Iterator r80 = ((Iterable) ZeusTransformUtils.preCheckCast(r78, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r126 = 0;
    L214:
        if (r80.hasNext() == false) goto L220;
        Long r127 = ((com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r80.next(), com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin")).d();
        if (r127 == null) goto L218;
        long r128 = n.a(r127.longValue(), 0);
    L219:
        r126 = r126 + r128;
        goto L214
    L218:
        r128 = 0;
        goto L219
    L220:
        r53.put(r79, Long.valueOf(r126));
        String r81 = "effect_snapshot_" + r73 + "_has_result";
        Iterable r82 = (Iterable) ZeusTransformUtils.preCheckCast(r78, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r82, Collection.class) == true) goto L223;
    L225:
        Iterator r83 = r82.iterator();
    L227:
        if (r83.hasNext() == false) goto L224;
        com.obric.autogui.agents.a.m.m r84 = (com.obric.autogui.agents.a.m.m) ZeusTransformUtils.preCheckCast(r83.next(), com.obric.autogui.agents.a.m.m.class, "com.obric.aiagent.plugin");
        if (r84.c() != com.obric.autogui.agents.a.m.l.f26684d) goto L231;
    L234:
        boolean r85 = true;
    L235:
        if (r85 == false) goto L227;
        boolean r86 = true;
    L237:
        r53.put(r81, Boolean.valueOf(r86));
        goto L202
    L231:
        if (r84.c() == com.obric.autogui.agents.a.m.l.f26682b) goto L234;
        r85 = false;
    L224:
        r86 = false;
        goto L237
    L223:
        if (((Collection) ZeusTransformUtils.preCheckCast(r82, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L225;
    L239:
        return (Map) ZeusTransformUtils.preCheckCast(r53, Map.class, "com.obric.aiagent.plugin");
    L193:
        if (r68.c() != com.obric.autogui.agents.a.m.l.f26684d) goto L195;
    L196:
        r69 = true;
        goto L198
    L195:
        if (r68.c() != com.obric.autogui.agents.a.m.l.f26682b) goto L197;
    L186:
        r70 = false;
        goto L200
    L185:
        if (((Collection) ZeusTransformUtils.preCheckCast(r66, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L187;
    L125:
        if (((Collection) ZeusTransformUtils.preCheckCast(r45, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L127;
        r47 = 0;
        goto L138
    L109:
        if (((Collection) ZeusTransformUtils.preCheckCast(r42, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L111;
        r44 = 0;
        goto L122
    L105:
        r41 = false;
    L99:
        r40 = null;
        goto L100
    L93:
        r2 = false;
        goto L94
    L87:
        r37 = null;
        goto L88
    L80:
        r118 = null;
        goto L81
    L74:
        r115 = null;
        goto L75
    L68:
        r36 = null;
        goto L69
    L13:
        return ao.a(s.a("effect_timing_available", false));
    L5:
        return ao.a(s.a("effect_timing_available", false));
    }

    public static final Map<String, Object> a(com.obric.autogui.agents.a.m.e r7) {
        o.e(r7, "timing");
        m[] r0 = new m[6];
        r0[0] = s.a("effect_detector_round", Integer.valueOf(n.c(r7.b(), 1)));
        r0[1] = s.a("effect_detector_type", r7.c());
        String r1 = r7.f();
        String r3 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[2] = s.a("effect_detector_status", r1);
        String r4 = r7.g();
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        r0[3] = s.a("effect_detector_reason", r3);
        r0[4] = s.a("effect_detector_finish_reason", r7.e().name());
        r0[5] = s.a("effect_detector_elapsed_ms", Long.valueOf(n.a(r7.d(), 0)));
        LinkedHashMap r2 = ao.d(r0);
        String r5 = r7.h();
        String r6 = null;
        if (r5 != null) goto L12;
    L17:
        String r8 = r7.i();
        if (r8 != null) goto L20;
    L25:
        String r9 = r7.j();
        if (r9 == null) goto L33;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L30;
        r6 = r9;
    L30:
        if (r6 == null) goto L33;
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put("effect_detector_after_activity_class_name", r6);
    L33:
        return (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");
    L20:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L25;
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put("effect_detector_before_activity_class_name", r8);
        goto L25
    L12:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put("effect_detector_page_class_name", r5);
        goto L17
    }

    public static final Map<String, Object> a(i r5) {
        o.e(r5, "timing");
        return (Map) ZeusTransformUtils.preCheckCast(ao.d(new m[]{s.a("effect_round_sequence", Long.valueOf(r5.a())), s.a("effect_round", Integer.valueOf(n.c(r5.b(), 1))), s.a("effect_round_total_elapsed_ms", Long.valueOf(n.a(r5.c(), 0))), s.a("effect_round_delay_elapsed_ms", Long.valueOf(n.a(r5.d(), 0))), s.a("effect_round_snapshot_elapsed_ms", Long.valueOf(n.a(r5.e(), 0))), s.a("effect_round_detector_batch_elapsed_ms", Long.valueOf(n.a(r5.f(), 0))), s.a("effect_round_aggregation_elapsed_ms", Long.valueOf(n.a(r5.g(), 0))), s.a("effect_round_finish_reason", r5.h().name())}), Map.class, "com.obric.aiagent.plugin");
    }

    private static final String a(k r1) {
        int r2 = a.f28332a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "screenshot";
    L5:
        if (r2 != 2) goto L7;
        return "viewtree";
    L7:
        if (r2 != 3) goto L9;
        return "top_component";
    L9:
        if (r2 != 4) goto L12;
        return "image_hash";
    L12:
        throw new d.k();
    }

    static {
        f28331a = d.a.p.b(new k[]{k.f26677b, k.f26678c});
    }
}
