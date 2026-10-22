package com.obric.autogui.operator.a.c.a.a;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import java.util.List;

/* JADX INFO: compiled from: OpClickViewTreeCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autogui.operator.a.c.a.b {

    /* JADX INFO: compiled from: OpClickViewTreeCheck.kt */
    @f(b = "OpClickViewTreeCheck.kt", c = {39}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickViewTreeCheck")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f29774e;
        final /* synthetic */ c f;
        int g;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f29774e = r7;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$_SKSmKsyPvAVal8GhyZhghr-rQg, reason: not valid java name */
    public static /* synthetic */ boolean m839lambda$_SKSmKsyPvAVal8GhyZhghrrQg(VHNode r0) {
        return a(r0);
    }

    @Override // com.obric.autogui.operator.a.c.a.b, com.obric.autogui.operator.a.c.a
    public String a() {
        return "OpClickViewTreeCheck";
    }

    public c() {
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(b("operator.precheck.click.viewtree.enable", "operator.precheck.click.viewtree.whitelist"));
    }

    @Override // com.obric.autogui.operator.a.c.a.b
    public Object a(e r23, com.obric.autogui.operator.b.a r24, List<ViewHierarchyDump> r25, List<ViewHierarchyDump> r26, d.c.d<? super com.obric.autogui.common.e> r27) {
        com.obric.autogui.operator.b.a r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r24, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        a r5 = r1;
        Object r2 = r5.f29774e;
        Object r11 = d.c.a.b.a();
        int r3 = r5.g;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (List) ZeusTransformUtils.preCheckCast(r5.f29773d, List.class, "com.obric.aiagent.plugin");
        r9 = (List) ZeusTransformUtils.preCheckCast(r5.f29772c, List.class, "com.obric.aiagent.plugin");
        r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r5.f29771b, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        c r4 = (c) ZeusTransformUtils.preCheckCast(r5.f29770a, c.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L18:
        com.obric.autogui.common.e r6 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r6.g() == true) goto L22;
        return r6;
    L22:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.operator.a.b.b.a.class) == false) goto L24;
        com.obric.autogui.operator.a.b.b.a r7 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
    L26:
        if (r7 != null) goto L29;
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] needs a valid input");
        r4.a("invalid_input", "invalid input");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), r4.b() + " no input provided"), "ignore_" + r4.b() + "_view_tree_no_input_provided", null, false, null, 0, 26, null);
    L29:
        com.obric.autogui.operator.a.a.f r12 = r7.b().a();
        float r13 = 0.0f;
        if (r12 == null) goto L32;
        float r14 = r12.a();
    L33:
        int r15 = (int) r14;
        com.obric.autogui.operator.a.a.f r16 = r7.b().a();
        if (r16 == null) goto L36;
        r13 = r16.b();
    L36:
        int r17 = (int) r13;
        ViewHierarchyDump r18 = r4.a(r9, r15, r17);
        ViewHierarchyDump r19 = r4.a(r10, r15, r17);
        if (r18 == null) goto L39;
        Integer r20 = d.c.b.a.b.a(r18.getWindowIndex());
    L40:
        if (r19 == null) goto L42;
        Integer r110 = d.c.b.a.b.a(r19.getWindowIndex());
    L44:
        if (d.h.b.o.a(r20, r110) == true) goto L72;
        Loog r21 = Loog.INSTANCE;
        String r111 = r4.b();
        StringBuilder r22 = new StringBuilder().append(" - [").append(r4.a()).append("] window diff, prev=");
        if (r18 == null) goto L48;
        Integer r112 = d.c.b.a.b.a(r18.getWindowIndex());
    L49:
        StringBuilder r28 = r22.append(r112).append(", cur=");
        if (r19 == null) goto L52;
        Integer r113 = d.c.b.a.b.a(r19.getWindowIndex());
    L53:
        r21.w(r111, r28.append(r113).toString());
        StringBuilder r29 = new StringBuilder().append("prev=");
        if (r18 == null) goto L56;
        Integer r30 = d.c.b.a.b.a(r18.getWindowIndex());
    L57:
        StringBuilder r31 = r29.append(r30).append(", cur=");
        if (r19 == null) goto L60;
        Integer r32 = d.c.b.a.b.a(r19.getWindowIndex());
    L61:
        r4.a("window_diff", r31.append(r32).append(", x=").append(r15).append(", y=").append(r17).toString());
        com.obric.autogui.common.e r33 = com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " view hierarchy different");
        String r114 = "ignore_" + r4.b() + "_view_tree_hierarchy_diff";
        StringBuilder r34 = new StringBuilder().append("(bef=");
        if (r18 == null) goto L64;
        Integer r35 = d.c.b.a.b.a(r18.getWindowIndex());
    L65:
        StringBuilder r36 = r34.append(r35).append(", aft=");
        if (r19 == null) goto L68;
        Integer r37 = d.c.b.a.b.a(r19.getWindowIndex());
    L70:
        return com.obric.autogui.common.b.a(r33, r114, r36.append(r37).append(')').toString(), false, null, 0, 24, null);
    L68:
        r37 = null;
        goto L70
    L64:
        r35 = null;
        goto L65
    L60:
        r32 = null;
        goto L61
    L56:
        r30 = null;
        goto L57
    L52:
        r113 = null;
        goto L53
    L48:
        r112 = null;
        goto L49
    L72:
        if (r18 == null) goto L74;
        VHNode r38 = r4.a(r18, r15, r17);
    L75:
        if (r19 == null) goto L77;
        VHNode r39 = r4.a(r19, r15, r17);
    L78:
        if (r39 == null) goto L80;
        VHNode.VHNodeComparison r115 = r39.compareTo(r38);
    L81:
        if (r115 != null) goto L83;
    L86:
        if (r38 == null) goto L99;
        if (r39 != null) goto L99;
    L88:
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] surface diff, prev=" + r38 + ", cur=" + r39);
        r4.a("surface_diff", "prev=" + r38 + ", cur=" + r39 + "x=" + r15 + ", y=" + r17);
        com.obric.autogui.common.e r40 = com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " view hierarchy different");
        String r41 = "ignore_" + r4.b() + "_view_tree_hierarchy_diff";
        StringBuilder r42 = new StringBuilder().append("(bef=");
        if (r18 == null) goto L91;
        Integer r43 = d.c.b.a.b.a(r18.getWindowIndex());
    L92:
        StringBuilder r44 = r42.append(r43).append(", aft=");
        if (r19 == 0) goto L95;
        Integer r45 = d.c.b.a.b.a(r19.getWindowIndex());
    L97:
        return com.obric.autogui.common.b.a(r40, r41, r44.append(r45).append(')').toString(), false, null, 0, 24, null);
    L95:
        r45 = null;
        goto L97
    L91:
        r43 = null;
    L99:
        if (r39 == null) goto L103;
        Loog.INSTANCE.d(r4.b(), " - [" + r4.a() + "] current node maybe surface view, skipped. curNode=" + r39);
        return com.obric.autogui.common.e.f29014b.a();
    L103:
        if (r18 == null) goto L105;
        VHNode r46 = r4.b(r18, r15, r17);
    L107:
        if (r19 == 0) goto L109;
        VHNode r116 = r4.b(r19, r15, r17);
    L110:
        if (r116 == null) goto L112;
        VHNode.VHNodeComparison r117 = r116.compareTo(r46);
    L113:
        if (r117 != null) goto L115;
    L118:
        if (r46 != null) goto L120;
        if (r116 == null) goto L120;
    L122:
        StringBuilder r118 = new StringBuilder().append(r4.b()).append(" node not matched (servedMeth=");
        if (r117 == null) goto L125;
        String r119 = r117.getServedMethod();
    L126:
        StringBuilder r120 = r118.append(r119).append("), (prev=").append(r46).append(":window[");
        if (r18 == null) goto L129;
        Integer r47 = d.c.b.a.b.a(r18.getWindowIndex());
    L130:
        StringBuilder r48 = r120.append(r47).append("]; cur=").append(r116).append(":window[");
        if (r19 == null) goto L133;
        Integer r49 = d.c.b.a.b.a(r19.getWindowIndex());
    L134:
        String r121 = r48.append(r49).append("]) x=").append(r15).append(", y=").append(r17).toString();
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] " + r121);
        StringBuilder r50 = new StringBuilder().append("servedMeth=");
        if (r117 == null) goto L137;
        String r51 = r117.getServedMethod();
    L138:
        r4.a("node_not_matched", r50.append(r51).append(", prev=").append(r46).append("; cur=").append(r116).append(")x=").append(r15).append(", y=").append(r17).toString());
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " node not matched"), "ignore_" + r4.b() + "_view_tree_node_diff", r121, false, null, 0, 24, null);
    L137:
        r51 = null;
        goto L138
    L133:
        r49 = null;
        goto L134
    L129:
        r47 = null;
        goto L130
    L125:
        r119 = null;
    L120:
        if (r46 == null) goto L141;
        if (r116 == null) goto L122;
    L141:
        return com.obric.autogui.common.e.f29014b.a();
    L115:
        if (r117.isSame() == true) goto L118;
        if (r117.getExact() == true) goto L122;
    L112:
        r117 = null;
        goto L113
    L109:
        r116 = null;
        goto L110
    L105:
        r46 = null;
        goto L107
    L83:
        if (r115.isSame() == true) goto L86;
        if (r115.getExact() == true) goto L88;
    L80:
        r115 = null;
        goto L81
    L77:
        r39 = null;
        goto L78
    L74:
        r38 = null;
        goto L75
    L42:
        r110 = null;
        goto L44
    L39:
        r20 = null;
        goto L40
    L32:
        r14 = 0.0f;
        goto L33
    L24:
        r7 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        r5.f29770a = this;
        r5.f29771b = r8;
        r5.f29772c = r9;
        r5.f29773d = r10;
        r5.g = 1;
        r2 = super.a(r23, r8, r9, r10, r5);
        if (r2 != r11) goto L17;
        return r11;
    L17:
        r4 = this;
    L7:
        r1 = new a(this, r0);
        goto L8
    }

    private final VHNode b(ViewHierarchyDump r1, int r2, int r3) {
        return r1.findNodeByPosition(r2, r3, $$Lambda$c$_SKSmKsyPvAVal8GhyZhghrrQg.INSTANCE);
    }

    private static final boolean a(VHNode r2) {
        VHNode r3 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "node");
        if (r3.isClickable() == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.isLongClickable() == true) goto L8;
        return false;
    }
}
