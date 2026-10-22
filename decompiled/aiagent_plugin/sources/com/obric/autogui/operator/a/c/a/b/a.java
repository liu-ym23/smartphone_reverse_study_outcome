package com.obric.autogui.operator.a.c.a.b;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.a.c.a.b;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import java.util.List;

/* JADX INFO: compiled from: OpScrollWheelViewTreeCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpScrollWheelViewTreeCheck.kt */
    @f(b = "OpScrollWheelViewTreeCheck.kt", c = {38}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.scrollwheel.OpScrollWheelViewTreeCheck")
    static final class C0773a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f29786e;
        final /* synthetic */ a f;
        int g;

        C0773a(a r3, d.c.d<? super C0773a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f29786e = r7;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.operator.a.c.a.b, com.obric.autogui.operator.a.c.a
    public String a() {
        return "OpScrollWheelViewTreeCheck";
    }

    public a() {
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(b("operator.precheck.scrollwheel.viewtree.enable", "operator.precheck.scrollwheel.viewtree.whitelist"));
    }

    @Override // com.obric.autogui.operator.a.c.a.b
    public Object a(e r27, com.obric.autogui.operator.b.a r28, List<ViewHierarchyDump> r29, List<ViewHierarchyDump> r30, d.c.d<? super com.obric.autogui.common.e> r31) {
        com.obric.autogui.operator.b.a r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r28, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C0773a.class) == false) goto L7;
        C0773a r1 = (C0773a) ZeusTransformUtils.preCheckCast(r0, C0773a.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        C0773a r5 = r1;
        Object r2 = r5.f29786e;
        Object r11 = d.c.a.b.a();
        int r3 = r5.g;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (List) ZeusTransformUtils.preCheckCast(r5.f29785d, List.class, "com.obric.aiagent.plugin");
        r9 = (List) ZeusTransformUtils.preCheckCast(r5.f29784c, List.class, "com.obric.aiagent.plugin");
        r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r5.f29783b, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r5.f29782a, a.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L18:
        com.obric.autogui.common.e r6 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r6.g() == true) goto L22;
        return r6;
    L22:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.operator.a.b.b.d.b.class) == false) goto L24;
        com.obric.autogui.operator.a.b.b.d.b r7 = (com.obric.autogui.operator.a.b.b.d.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.a.b.b.d.b.class, "com.obric.aiagent.plugin");
    L26:
        if (r7 != null) goto L29;
        Loog.INSTANCE.e(r4.b(), " - [" + r4.a() + "] no input provided");
        r4.a("invalid_input", "invalid input");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), r4.b() + " no input provided"), "ignore_" + r4.b() + "_view_tree_no_input_provided", null, false, null, 0, 26, null);
    L29:
        int r12 = (int) ((Number) ZeusTransformUtils.preCheckCast(r7.a().a(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        int r13 = (int) ((Number) ZeusTransformUtils.preCheckCast(r7.a().b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        ViewHierarchyDump r14 = r4.a(r9, r12, r13);
        ViewHierarchyDump r15 = r4.a(r10, r12, r13);
        if (r14 == null) goto L32;
        Integer r16 = d.c.b.a.b.a(r14.getWindowIndex());
    L33:
        if (r15 == null) goto L35;
        Integer r17 = d.c.b.a.b.a(r15.getWindowIndex());
    L37:
        if (d.h.b.o.a(r16, r17) == true) goto L65;
        Loog r18 = Loog.INSTANCE;
        String r19 = r4.b();
        StringBuilder r20 = new StringBuilder().append(" - [").append(r4.a()).append("] window diff, prev=");
        if (r14 == null) goto L41;
        Integer r21 = d.c.b.a.b.a(r14.getWindowIndex());
    L42:
        StringBuilder r22 = r20.append(r21).append(", cur=");
        if (r15 == null) goto L45;
        Integer r23 = d.c.b.a.b.a(r15.getWindowIndex());
    L46:
        r18.w(r19, r22.append(r23).toString());
        StringBuilder r24 = new StringBuilder().append("prev=");
        if (r14 == null) goto L49;
        Integer r25 = d.c.b.a.b.a(r14.getWindowIndex());
    L50:
        StringBuilder r26 = r24.append(r25).append(", cur=");
        if (r15 == null) goto L53;
        Integer r32 = d.c.b.a.b.a(r15.getWindowIndex());
    L54:
        r4.a("window_diff", r26.append(r32).append(", x=").append(r12).append(", y=").append(r13).toString());
        com.obric.autogui.common.e r110 = com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " view hierarchy different");
        String r111 = "ignore_" + r4.b() + "_view_tree_hierarchy_diff";
        StringBuilder r33 = new StringBuilder().append("(bef=");
        if (r14 == null) goto L57;
        Integer r34 = d.c.b.a.b.a(r14.getWindowIndex());
    L58:
        StringBuilder r35 = r33.append(r34).append(", aft=");
        if (r15 == null) goto L61;
        Integer r36 = d.c.b.a.b.a(r15.getWindowIndex());
    L63:
        return com.obric.autogui.common.b.a(r110, r111, r35.append(r36).append(')').toString(), false, null, 0, 24, null);
    L61:
        r36 = null;
        goto L63
    L57:
        r34 = null;
        goto L58
    L53:
        r32 = null;
        goto L54
    L49:
        r25 = null;
        goto L50
    L45:
        r23 = null;
        goto L46
    L41:
        r21 = null;
        goto L42
    L65:
        if (r14 == null) goto L67;
        VHNode r112 = r4.a(r14, r12, r13);
    L68:
        if (r15 == null) goto L70;
        VHNode r37 = r4.a(r15, r12, r13);
    L71:
        if (r37 == null) goto L73;
        VHNode.VHNodeComparison r113 = r37.compareTo(r112);
    L74:
        if (r113 != null) goto L76;
    L79:
        if (r112 == null) goto L92;
        if (r37 != null) goto L92;
    L81:
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] surface diff, prev=" + r112 + ", cur=" + r37);
        r4.a("surface_diff", "prev=" + r112 + ", cur=" + r37 + "x=" + r12 + ", y=" + r13);
        com.obric.autogui.common.e r38 = com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " view hierarchy different");
        String r39 = "ignore_" + r4.b() + "_view_tree_hierarchy_diff";
        StringBuilder r40 = new StringBuilder().append("(bef=");
        if (r14 == null) goto L84;
        Integer r41 = d.c.b.a.b.a(r14.getWindowIndex());
    L85:
        StringBuilder r42 = r40.append(r41).append(", aft=");
        if (r15 == 0) goto L88;
        Integer r43 = d.c.b.a.b.a(r15.getWindowIndex());
    L90:
        return com.obric.autogui.common.b.a(r38, r39, r42.append(r43).append(')').toString(), false, null, 0, 24, null);
    L88:
        r43 = null;
        goto L90
    L84:
        r41 = null;
    L92:
        if (r37 == null) goto L95;
        Loog.INSTANCE.d(r4.b(), " - [" + r4.a() + "] current node maybe surface view, skipped. curNode=" + r37);
        return com.obric.autogui.common.e.f29014b.a();
    L95:
        VHNode r44 = null;
        if (r14 == null) goto L98;
        r44 = ViewHierarchyDump.findNodeByPosition$default(r14, r12, r13, null, 4, null);
    L98:
        VHNode r45 = null;
        if (r15 == 0) goto L101;
        r45 = ViewHierarchyDump.findNodeByPosition$default(r15, r12, r13, null, 4, null);
    L101:
        if (r45 == null) goto L103;
        VHNode.VHNodeComparison r46 = r45.compareTo(r44);
    L104:
        if (r46 != null) goto L106;
    L109:
        if (r44 != null) goto L111;
        if (r45 == null) goto L111;
    L113:
        StringBuilder r114 = new StringBuilder().append(r4.b()).append(" node not matched (servedMeth=");
        if (r46 == null) goto L116;
        String r115 = r46.getServedMethod();
    L117:
        String r116 = r114.append(r115).append(")(prev=").append(r44).append("; cur=").append(r45).append(')').toString();
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] " + r116);
        StringBuilder r47 = new StringBuilder().append("servedMeth=");
        if (r46 == null) goto L120;
        String r48 = r46.getServedMethod();
    L121:
        r4.a("node_not_matched", r47.append(r48).append(", prev=").append(r44).append(", cur=").append(r45).append(", x=").append(r12).append(", y=").append(r13).toString());
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " node not matched"), "ignore_" + r4.b() + "_view_tree_node_diff", r116, false, null, 0, 24, null);
    L120:
        r48 = null;
        goto L121
    L116:
        r115 = null;
    L111:
        if (r44 == null) goto L124;
        if (r45 == null) goto L113;
    L124:
        return com.obric.autogui.common.e.f29014b.a();
    L106:
        if (r46.isSame() == true) goto L109;
        if (r46.getExact() == true) goto L113;
    L103:
        r46 = null;
        goto L104
    L76:
        if (r113.isSame() == true) goto L79;
        if (r113.getExact() == true) goto L81;
    L73:
        r113 = null;
        goto L74
    L70:
        r37 = null;
        goto L71
    L67:
        r112 = null;
        goto L68
    L35:
        r17 = null;
        goto L37
    L32:
        r16 = null;
        goto L33
    L24:
        r7 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        r5.f29782a = this;
        r5.f29783b = r8;
        r5.f29784c = r9;
        r5.f29785d = r10;
        r5.g = 1;
        r2 = super.a(r27, r8, r9, r10, r5);
        if (r2 != r11) goto L17;
        return r11;
    L17:
        r4 = this;
    L7:
        r1 = new C0773a(this, r0);
        goto L8
    }
}
