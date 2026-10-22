package com.obric.autogui.agents.a;

import com.obric.autogui.agents.a.f.i;
import com.obric.autogui.agents.a.m.g;
import com.obric.autogui.agents.a.m.k;
import com.obric.autogui.agents.a.m.m;
import com.obric.autogui.agents.a.m.r;
import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.v;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26286a = null;

    static {
        f26286a = new c();
    }

    public static /* synthetic */ CharSequence lambda$Fpfu_Mha649Dd_lDvIAcLt1De4c(com.obric.autogui.agents.a.f.b r0) {
        return a(r0);
    }

    private c() {
    }

    public final String a(com.obric.autogui.agents.a.a.a r2) {
        o.e(r2, "attempt");
        return a(a.f26155a.a(r2));
    }

    public final String a(com.obric.autogui.agents.a.a.f r2) {
        o.e(r2, "input");
        return a(r2.k());
    }

    public final String a(a r2) {
        o.e(r2, "context");
        return a(r2.a(), r2.b());
    }

    public final String a(String r4, String r5) {
        o.e(r4, "action");
        o.e(r5, "attemptId");
        return "action=" + b.a(r4, 0, 1, null) + ", attempt_id=" + b.a(r5, 0, 1, null);
    }

    public final void a(String r11, a r12, int r13, com.obric.autogui.agents.a.f.b r14, long r15, s r17, String r18, boolean r19) {
        o.e(r11, "tag");
        o.e(r12, "context");
        o.e(r14, "result");
        o.e(r17, "finishReason");
        o.e(r18, "details");
        String r1 = a(r12, r13, r14, r15, r17, r18);
        if (r19 == false) goto L5;
        Loog.INSTANCE.w(r11, r1);
        return;
    L5:
        Loog.INSTANCE.i(r11, r1);
    }

    public final String a(a r5, int r6, com.obric.autogui.agents.a.f.b r7, long r8, s r10, String r11) {
        o.e(r5, "context");
        o.e(r7, "result");
        o.e(r10, "finishReason");
        o.e(r11, "details");
        boolean r1 = true;
        String r2 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r11 = null;
    L7:
        if (r11 == null) goto L9;
        r2 = ", details=" + b.a(r11, 240);
    L9:
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        StringBuilder r4 = new StringBuilder().append("[OAutoActionEffect] detector result ").append(a(r5)).append(", round=").append(r6).append(", detector=").append(r7.a().a()).append(", status=").append(r7.b()).append(", finish_reason=").append(r10).append(", elapsed_ms=").append(n.a(r8, 0)).append(", reason=").append(b.a(r7.c(), 240)).append(r2).append(", has_hint=");
        if (r7.d() != null) goto L16;
        r1 = false;
    L16:
        return r4.append(r1).toString();
    }

    public final void a(String r21, com.obric.autogui.agents.a.a.f r22, i r23, v r24) {
        o.e(r21, "tag");
        o.e(r22, "input");
        o.e(r23, "outcome");
        o.e(r24, "timingReport");
        String r2 = b.a(r23.d(), 240);
        g r5 = r24.j();
        Loog r6 = Loog.INSTANCE;
        StringBuilder r7 = new StringBuilder();
        StringBuilder r3 = r7.append("[OAutoActionEffect] end ").append(a(r22)).append(", start_status=").append(r23.a()).append(", status=").append(r23.b()).append(", finish_reason=").append(r23.i()).append(", detector=").append(r23.c()).append(", served_reason=").append(r2).append(", detect_count=").append(r23.f()).append(", completed_round_count=");
        boolean r8 = false;
        if (r5 == null) goto L7;
        List<com.obric.autogui.agents.a.m.i> r9 = r5.e();
        if (r9 == null) goto L7;
        int r10 = r9.size();
    L8:
        StringBuilder r4 = r3.append(r10).append(", detector_execution_count=");
        if (r5 == null) goto L13;
        List<com.obric.autogui.agents.a.m.e> r11 = r5.f();
        if (r11 == null) goto L13;
        int r12 = r11.size();
    L14:
        StringBuilder r13 = r4.append(r12).append(", cancelled_detector_count=");
        if (r5 == null) goto L34;
        List<com.obric.autogui.agents.a.m.e> r14 = r5.f();
        if (r14 == null) goto L34;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L21;
    L23:
        Iterator r16 = r15.iterator();
        int r17 = 0;
    L25:
        if (r16.hasNext() == false) goto L35;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.autogui.agents.a.m.e.class, "com.obric.aiagent.plugin")).e() != s.f26712c) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == false) goto L25;
        r17 = r17 + 1;
        if (r17 >= 0) goto L25;
        p.d();
        goto L25
    L29:
        r18 = false;
    L35:
        StringBuilder r19 = r13.append(r17).append(", framework_callback_available=");
        if (r24.f() == null) goto L38;
        boolean r110 = true;
    L39:
        r19.append(r110).append(", registration_to_callback_elapsed_ms=");
        Long r20 = r24.f();
        String r111 = null;
        if (r20 == null) goto L42;
        String r25 = r20.toString();
    L43:
        String r112 = "";
        if (r25 != null) goto L46;
        r25 = "";
    L46:
        StringBuilder r1 = r7.append(r25).append(", callback_wait_ms=").append(r22.g()).append(", framework_callback_processing_elapsed_ms=");
        Long r26 = r24.g();
        if (r26 == null) goto L49;
        String r27 = r26.toString();
    L50:
        if (r27 != null) goto L52;
        r27 = "";
    L52:
        StringBuilder r28 = r1.append(r27).append(", total_elapsed_ms=");
        if (r5 == null) goto L55;
        String r29 = Long.valueOf(r5.a()).toString();
    L56:
        if (r29 != null) goto L58;
        r29 = "";
    L58:
        StringBuilder r30 = r28.append(r29).append(", error_reason=");
        com.obric.autogui.agents.a.f.e r31 = r23.h();
        if (r31 == null) goto L61;
        r111 = r31.name();
    L61:
        if (r111 == null) goto L64;
        r112 = r111;
    L64:
        StringBuilder r32 = r30.append(r112).append(", detector_results=").append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r23.e(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$c$Fpfu_Mha649Dd_lDvIAcLt1De4c.INSTANCE, 30, null)).append(", has_hint=");
        if (r23.g() == null) goto L67;
        r8 = true;
    L67:
        r32.append(r8);
        r6.i(r21, r7.toString());
        return;
    L55:
        r29 = null;
        goto L56
    L49:
        r27 = null;
        goto L50
    L42:
        r25 = null;
        goto L43
    L38:
        r110 = false;
        goto L39
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
    L34:
        r17 = 0;
    L13:
        r12 = 0;
    L7:
        r10 = 0;
        goto L8
    }

    private static final CharSequence a(com.obric.autogui.agents.a.f.b r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a().a() + ':' + r2.b(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r19, a r20, v r21) {
        o.e(r19, "tag");
        o.e(r20, "context");
        o.e(r21, "report");
        List<com.obric.autogui.agents.a.m.p> r2 = r21.i();
        g r4 = r21.j();
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        p.a(r7, (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.agents.a.m.p) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.autogui.agents.a.m.p.class, "com.obric.aiagent.plugin")).e(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        Loog r9 = Loog.INSTANCE;
        StringBuilder r10 = new StringBuilder();
        StringBuilder r1 = r10.append("[OAutoActionEffect] timing ").append(a(r20)).append(", schema_version=").append(r21.a()).append(", final=").append(r21.b()).append(", lifecycle_finish_reason=");
        s r11 = r21.d();
        String r12 = null;
        if (r11 == null) goto L9;
        String r13 = r11.name();
    L10:
        String r14 = "";
        if (r13 != null) goto L13;
        r13 = "";
    L13:
        StringBuilder r3 = r1.append(r13).append(", cancellation_reason=");
        r r15 = r21.e();
        if (r15 == null) goto L16;
        String r16 = r15.name();
    L17:
        if (r16 != null) goto L19;
        r16 = "";
    L19:
        r3.append(r16).append(", lifecycle_wall_elapsed_ms=").append(n.a(r21.c(), 0)).append(", core_blocking_total_elapsed_ms=").append(r21.h().h()).append(", preparation_elapsed_ms=").append(r21.h().a()).append(", before_operation_hook_elapsed_ms=").append(r21.h().b()).append(", after_operation_hook_elapsed_ms=").append(r21.h().c()).append(", skipped_operation_hook_elapsed_ms=").append(r21.h().d()).append(", completion_elapsed_ms=");
        StringBuilder r17 = r10.append(r21.h().f()).append(", model_screenshot_evaluation_elapsed_ms=").append(r21.h().g()).append(", framework_callback_available=");
        if (r21.f() == null) goto L22;
        boolean r18 = true;
    L23:
        StringBuilder r22 = r17.append(r18).append(", registration_to_callback_elapsed_ms=");
        Long r23 = r21.f();
        if (r23 == null) goto L26;
        String r24 = r23.toString();
    L27:
        if (r24 != null) goto L29;
        r24 = "";
    L29:
        StringBuilder r25 = r22.append(r24).append(", framework_callback_processing_elapsed_ms=");
        Long r26 = r21.g();
        if (r26 == null) goto L32;
        String r27 = r26.toString();
    L33:
        if (r27 != null) goto L35;
        r27 = "";
    L35:
        StringBuilder r28 = r25.append(r27).append(", evaluation_total_elapsed_ms=");
        if (r4 == null) goto L38;
        String r29 = Long.valueOf(r4.a()).toString();
    L39:
        if (r29 != null) goto L41;
        r29 = "";
    L41:
        StringBuilder r30 = r28.append(r29).append(", evaluation_control_elapsed_ms=");
        if (r4 == null) goto L44;
        r12 = Long.valueOf(r4.b()).toString();
    L44:
        if (r12 == null) goto L47;
        r14 = r12;
    L47:
        StringBuilder r31 = r30.append(r14).append(", round_count=");
        if (r4 == null) goto L52;
        List<com.obric.autogui.agents.a.m.i> r32 = r4.e();
        if (r32 == null) goto L52;
        int r33 = r32.size();
    L53:
        StringBuilder r34 = r31.append(r33).append(", detector_execution_count=");
        if (r4 == null) goto L58;
        List<com.obric.autogui.agents.a.m.e> r35 = r4.f();
        if (r35 == null) goto L58;
        int r36 = r35.size();
    L59:
        StringBuilder r37 = r34.append(r36).append(", snapshot_call_count=").append(r2.size()).append(", snapshot_call_wall_total_elapsed_ms=");
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r39 = 0;
    L61:
        if (r38.hasNext() == false) goto L63;
        r39 = r39 + n.a(((com.obric.autogui.agents.a.m.p) ZeusTransformUtils.preCheckCast(r38.next(), com.obric.autogui.agents.a.m.p.class, "com.obric.aiagent.plugin")).c(), 0);
        goto L61
    L63:
        StringBuilder r40 = r37.append(r39).append(", snapshot_wait_total_elapsed_ms=");
        Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r42 = 0;
    L65:
        if (r41.hasNext() == false) goto L67;
        r42 = r42 + n.a(((com.obric.autogui.agents.a.m.p) ZeusTransformUtils.preCheckCast(r41.next(), com.obric.autogui.agents.a.m.p.class, "com.obric.aiagent.plugin")).d(), 0);
        goto L65
    L67:
        r40.append(r42);
        StringBuilder r43 = r10.append(", screenshot_execution_count=");
        Iterable r44 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r44, Collection.class) == true) goto L70;
    L72:
        Iterator r45 = r44.iterator();
        int r46 = 0;
    L74:
        if (r45.hasNext() == false) goto L85;
        m r47 = (m) ZeusTransformUtils.preCheckCast(r45.next(), m.class, "com.obric.aiagent.plugin");
        if (r47.b() == k.f26676a) goto L78;
    L80:
        boolean r48 = false;
    L81:
        if (r48 == false) goto L74;
        r46 = r46 + 1;
        if (r46 >= 0) goto L74;
        p.d();
        goto L74
    L78:
        if (r47.d() == null) goto L80;
        r48 = true;
    L85:
        StringBuilder r49 = r43.append(r46).append(", viewtree_execution_count=");
        Iterable r50 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r50, Collection.class) == true) goto L88;
    L90:
        Iterator r51 = r50.iterator();
        int r52 = 0;
    L92:
        if (r51.hasNext() == false) goto L103;
        m r53 = (m) ZeusTransformUtils.preCheckCast(r51.next(), m.class, "com.obric.aiagent.plugin");
        if (r53.b() == k.f26677b) goto L96;
    L98:
        boolean r54 = false;
    L99:
        if (r54 == false) goto L92;
        r52 = r52 + 1;
        if (r52 >= 0) goto L92;
        p.d();
        goto L92
    L96:
        if (r53.d() == null) goto L98;
        r54 = true;
    L103:
        StringBuilder r55 = r49.append(r52).append(", top_component_execution_count=");
        Iterable r56 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r56, Collection.class) == true) goto L106;
    L108:
        Iterator r57 = r56.iterator();
        int r58 = 0;
    L110:
        if (r57.hasNext() == false) goto L121;
        m r59 = (m) ZeusTransformUtils.preCheckCast(r57.next(), m.class, "com.obric.aiagent.plugin");
        if (r59.b() == k.f26678c) goto L114;
    L116:
        boolean r60 = false;
    L117:
        if (r60 == false) goto L110;
        r58 = r58 + 1;
        if (r58 >= 0) goto L110;
        p.d();
        goto L110
    L114:
        if (r59.d() == null) goto L116;
        r60 = true;
    L121:
        StringBuilder r61 = r55.append(r58).append(", image_hash_execution_count=");
        Iterable r62 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r62, Collection.class) == true) goto L124;
    L126:
        Iterator r63 = r62.iterator();
        int r64 = 0;
    L128:
        if (r63.hasNext() == false) goto L139;
        m r65 = (m) ZeusTransformUtils.preCheckCast(r63.next(), m.class, "com.obric.aiagent.plugin");
        if (r65.b() == k.f26679d) goto L132;
    L134:
        boolean r66 = false;
    L135:
        if (r66 == false) goto L128;
        r64 = r64 + 1;
        if (r64 >= 0) goto L128;
        p.d();
        goto L128
    L132:
        if (r65.d() == null) goto L134;
        r66 = true;
        goto L135
    L139:
        int r110 = r64;
    L140:
        r61.append(r110);
        r9.i(r19, r10.toString());
        return;
    L124:
        if (((Collection) ZeusTransformUtils.preCheckCast(r62, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L126;
        r110 = 0;
        goto L140
    L106:
        if (((Collection) ZeusTransformUtils.preCheckCast(r56, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L108;
        r58 = 0;
        goto L121
    L88:
        if (((Collection) ZeusTransformUtils.preCheckCast(r50, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L90;
        r52 = 0;
        goto L103
    L70:
        if (((Collection) ZeusTransformUtils.preCheckCast(r44, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L72;
        r46 = 0;
    L58:
        r36 = 0;
    L52:
        r33 = 0;
        goto L53
    L38:
        r29 = null;
        goto L39
    L32:
        r27 = null;
        goto L33
    L26:
        r24 = null;
        goto L27
    L22:
        r18 = false;
        goto L23
    L16:
        r16 = null;
        goto L17
    L9:
        r13 = null;
        goto L10
    }
}
