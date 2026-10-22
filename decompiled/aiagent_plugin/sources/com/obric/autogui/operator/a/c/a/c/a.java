package com.obric.autogui.operator.a.c.a.c;

import android.graphics.PointF;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.c.b.a.f;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: OpSwipeViewTreeCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.operator.a.c.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0774a f29787b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f29788d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VHNode f29789c;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpSwipeViewTreeCheck.kt */
    public static final class C0774a {
        public /* synthetic */ C0774a(h r1) {
            this();
        }

        private C0774a() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin")).b(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin")).b(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f29790a;

        public c(Comparator r3) {
            this.f29790a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r2 = this.f29790a.compare(r3, r4);
            if (r2 != 0) goto L7;
            m r5 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((VHNode) ZeusTransformUtils.preCheckCast(r5.a(), VHNode.class, "com.obric.aiagent.plugin")).getBounds().getWidth() * ((VHNode) ZeusTransformUtils.preCheckCast(r5.a(), VHNode.class, "com.obric.aiagent.plugin")).getBounds().getHeight()), Comparable.class, "com.obric.aiagent.plugin");
            m r7 = (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin");
            return d.b.a.a(r6, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((VHNode) ZeusTransformUtils.preCheckCast(r7.a(), VHNode.class, "com.obric.aiagent.plugin")).getBounds().getWidth() * ((VHNode) ZeusTransformUtils.preCheckCast(r7.a(), VHNode.class, "com.obric.aiagent.plugin")).getBounds().getHeight()), Comparable.class, "com.obric.aiagent.plugin"));
        L7:
            return r2;
        }
    }

    /* JADX INFO: compiled from: OpSwipeViewTreeCheck.kt */
    @f(b = "OpSwipeViewTreeCheck.kt", c = {61}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.swipe.OpSwipeViewTreeCheck")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f29795e;
        final /* synthetic */ a f;
        int g;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f29795e = r7;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ x lambda$9lnGMOJugbDHPHhpuAfwBxM3dEc(List r0, VHNode r1, float r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$NOHQLtPKyH5IqjZCZd8qd0z_AKE(VHNode r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$ZcKwTqjHb07BCFo7Dq9Cybng0o8(q r0, PointF r1, PointF r2, int r3, int r4, VHNode r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ String lambda$i32x5xuAwDmIsC1o8OkpgrVbldc(List r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$rRRj2Ugy3if53-kWuIVW799RLOg, reason: not valid java name */
    public static /* synthetic */ x m840lambda$rRRj2Ugy3if53kWuIVW799RLOg(List r0, VHNode r1, float r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.autogui.operator.a.c.a.b, com.obric.autogui.operator.a.c.a
    public String a() {
        return "OpSwipeViewTreeCheck";
    }

    public a() {
    }

    static {
        f29787b = new C0774a(null);
        f29788d = ax.a("android.webkit.WebView");
    }

    public final VHNode d() {
        return this.f29789c;
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public void a(e r2) {
        o.e(r2, "step");
        super.a(r2);
        this.f29789c = null;
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public void b(e r2) {
        o.e(r2, "step");
        super.b(r2);
        this.f29789c = null;
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(b("operator.precheck.swipe.viewtree.enable", "operator.precheck.swipe.viewtree.whitelist"));
    }

    @Override // com.obric.autogui.operator.a.c.a.b
    public Object a(e r28, com.obric.autogui.operator.b.a r29, List<ViewHierarchyDump> r30, List<ViewHierarchyDump> r31, d.c.d<? super com.obric.autogui.common.e> r32) {
        com.obric.autogui.operator.b.a r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
        r1.g -= Integer.MIN_VALUE;
    L8:
        d r5 = r1;
        Object r2 = r5.f29795e;
        Object r11 = d.c.a.b.a();
        int r3 = r5.g;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (List) ZeusTransformUtils.preCheckCast(r5.f29794d, List.class, "com.obric.aiagent.plugin");
        r9 = (List) ZeusTransformUtils.preCheckCast(r5.f29793c, List.class, "com.obric.aiagent.plugin");
        r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r5.f29792b, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r5.f29791a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L18:
        com.obric.autogui.common.e r6 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r6.g() == true) goto L22;
        return r6;
    L22:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.operator.a.b.e.b.class) == false) goto L24;
        com.obric.autogui.operator.a.b.e.b r7 = (com.obric.autogui.operator.a.b.e.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.a.b.e.b.class, "com.obric.aiagent.plugin");
    L26:
        if (r7 != null) goto L30;
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] no input provided");
        r4.a("invalid_input", "invalid input");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), r4.b() + " no input provided"), "ignore_" + r4.b() + "_view_tree_no_input_provided", null, false, null, 0, 26, null);
    L30:
        if (r7.a() != com.obric.autogui.operator.a.b.e.a.f29658a) goto L127;
        PointF r12 = ((com.obric.autogui.operator.a.b.e.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.a.b.e.b.class, "com.obric.aiagent.plugin")).b();
        PointF r13 = ((com.obric.autogui.operator.a.b.e.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.a.b.e.b.class, "com.obric.aiagent.plugin")).c();
        ViewHierarchyDump r14 = r4.a(r9, r12, r13);
        ViewHierarchyDump r15 = r4.a(r10, r12, r13);
        if (r14 == null) goto L34;
        Integer r16 = d.c.b.a.b.a(r14.getWindowIndex());
    L35:
        if (r15 == null) goto L37;
        Integer r17 = d.c.b.a.b.a(r15.getWindowIndex());
    L39:
        if (o.a(r16, r17) == true) goto L67;
        Loog r18 = Loog.INSTANCE;
        String r19 = r4.b();
        StringBuilder r20 = new StringBuilder().append(" - [").append(r4.a()).append("] window diff, prev=");
        if (r14 == null) goto L43;
        Integer r110 = d.c.b.a.b.a(r14.getWindowIndex());
    L44:
        StringBuilder r21 = r20.append(r110).append(", cur=");
        if (r15 == null) goto L47;
        Integer r111 = d.c.b.a.b.a(r15.getWindowIndex());
    L48:
        r18.w(r19, r21.append(r111).toString());
        StringBuilder r22 = new StringBuilder().append("(prev=");
        if (r14 == null) goto L51;
        Integer r23 = d.c.b.a.b.a(r14.getWindowIndex());
    L52:
        StringBuilder r24 = r22.append(r23).append(", cur=");
        if (r15 == null) goto L55;
        Integer r25 = d.c.b.a.b.a(r15.getWindowIndex());
    L56:
        r4.a("window_diff, ", r24.append(r25).append(", fromPos=").append(r12).append(", toPos=").append(r13).toString());
        com.obric.autogui.common.e r26 = com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " view hierarchy different");
        String r112 = "ignore_" + r4.b() + "_view_tree_hierarchy_diff";
        StringBuilder r27 = new StringBuilder().append("(bef=");
        if (r14 == null) goto L59;
        Integer r33 = d.c.b.a.b.a(r14.getWindowIndex());
    L60:
        StringBuilder r34 = r27.append(r33).append(", aft=");
        if (r15 == null) goto L63;
        Integer r35 = d.c.b.a.b.a(r15.getWindowIndex());
    L65:
        return com.obric.autogui.common.b.a(r26, r112, r34.append(r35).append(')').toString(), false, null, 0, 24, null);
    L63:
        r35 = null;
        goto L65
    L59:
        r33 = null;
        goto L60
    L55:
        r25 = null;
        goto L56
    L51:
        r23 = null;
        goto L52
    L47:
        r111 = null;
        goto L48
    L43:
        r110 = null;
        goto L44
    L67:
        if (r14 == null) goto L69;
        VHNode r113 = r4.b(r14, r12, r13);
    L70:
        if (r15 == null) goto L72;
        VHNode r36 = r4.b(r15, r12, r13);
    L73:
        if (r36 == null) goto L75;
        VHNode.VHNodeComparison r114 = r36.compareTo(r113);
    L76:
        if (r114 != null) goto L78;
    L81:
        if (r113 == null) goto L94;
        if (r36 != null) goto L94;
    L83:
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] obstructed view diff, prev=" + r113 + ", cur=" + r36);
        r4.a("obstructed_view_diff", "prev=" + r113 + ", cur=" + r36 + "fromPos=" + r12 + ", toPos=" + r13);
        com.obric.autogui.common.e r115 = com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " view hierarchy different");
        String r116 = "ignore_" + r4.b() + "_view_tree_hierarchy_diff";
        StringBuilder r37 = new StringBuilder().append("(bef=");
        if (r14 == null) goto L86;
        Integer r38 = d.c.b.a.b.a(r14.getWindowIndex());
    L87:
        StringBuilder r39 = r37.append(r38).append(", aft=");
        if (r15 == 0) goto L90;
        Integer r40 = d.c.b.a.b.a(r15.getWindowIndex());
    L92:
        return com.obric.autogui.common.b.a(r115, r116, r39.append(r40).append(')').toString(), false, null, 0, 24, null);
    L90:
        r40 = null;
        goto L92
    L86:
        r38 = null;
    L94:
        if (r36 == null) goto L97;
        Loog.INSTANCE.d(r4.b(), " - [" + r4.a() + "] current node maybe obstructed view, skipped. curNode=" + r36);
        return com.obric.autogui.common.e.f29014b.a();
    L97:
        if (r14 == null) goto L99;
        VHNode r41 = r4.a(r14, r12, r13);
    L100:
        if (r15 == 0) goto L102;
        VHNode r42 = r4.a(r15, r12, r13);
    L103:
        if (r42 == null) goto L105;
        VHNode.VHNodeComparison r43 = r42.compareTo(r41);
    L106:
        if (r43 != null) goto L108;
    L111:
        if (r41 != null) goto L113;
        if (r42 == null) goto L113;
    L115:
        StringBuilder r117 = new StringBuilder().append(r4.b()).append(" node not matched, servedMeth=");
        if (r43 == null) goto L118;
        String r118 = r43.getServedMethod();
    L119:
        String r119 = r117.append(r118).append(", prev=").append(r41).append("; cur=").append(r42).append(")fromPos=").append(r12).append(", toPos=").append(r13).toString();
        Loog.INSTANCE.w(r4.b(), " - [" + r4.a() + "] " + r119);
        StringBuilder r44 = new StringBuilder().append("servedMeth=");
        if (r43 == null) goto L122;
        String r45 = r43.getServedMethod();
    L123:
        r4.a("node_not_matched", r44.append(r45).append(", prev=").append(r41).append(", cur=").append(r42).append(", fromPos=").append(r12).append(", toPos=").append(r13).toString());
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed"), r4.b() + " node not matched"), "ignore_" + r4.b() + "_view_tree_node_diff", r119, false, null, 0, 24, null);
    L122:
        r45 = null;
        goto L123
    L118:
        r118 = null;
    L113:
        if (r41 == null) goto L125;
        if (r42 == null) goto L115;
    L125:
        r4.f29789c = r42;
        goto L127
    L108:
        if (r43.isSame() == true) goto L111;
        if (r43.getExact() == true) goto L115;
    L105:
        r43 = null;
        goto L106
    L102:
        r42 = null;
        goto L103
    L99:
        r41 = null;
        goto L100
    L78:
        if (r114.isSame() == true) goto L81;
        if (r114.getExact() == true) goto L83;
    L75:
        r114 = null;
        goto L76
    L72:
        r36 = null;
        goto L73
    L69:
        r113 = null;
        goto L70
    L37:
        r17 = null;
        goto L39
    L34:
        r16 = null;
    L127:
        return com.obric.autogui.common.e.f29014b.a();
    L24:
        r7 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        r5.f29791a = this;
        r5.f29792b = r8;
        r5.f29793c = r9;
        r5.f29794d = r10;
        r5.g = 1;
        r2 = super.a(r28, r8, r9, r10, r5);
        if (r2 != r11) goto L17;
        return r11;
    L17:
        r4 = this;
    L7:
        r1 = new d(this, r0);
        goto L8
    }

    public final ViewHierarchyDump a(List<ViewHierarchyDump> r5, PointF r6, PointF r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "viewHierarchy");
        o.e(r6, "startPoint");
        o.e(r7, "endPoint");
        float r1 = 2;
        int r8 = (int) ((r6.x + r7.x) / r1);
        int r9 = (int) ((r6.y + r7.y) / r1);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(p.l((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L22;
        ViewHierarchyDump r11 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r10.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        VHNode r2 = r11.getRootNode();
        if (r2 == null) goto L4;
        VHNode.Bounds r3 = r2.getBounds();
        if (r3 == null) goto L4;
        if (r8 >= r3.getScreenLeft()) goto L13;
    L19:
        boolean r12 = false;
    L20:
        if (r12 == false) goto L4;
        return r11;
    L13:
        if (r8 > (r3.getScreenLeft() + r3.getWidth())) goto L19;
        if (r9 < r3.getScreenTop()) goto L19;
        if (r9 > (r3.getScreenTop() + r3.getHeight())) goto L19;
        r12 = true;
        goto L20
    L22:
        return null;
    }

    private final boolean a(PointF r1, PointF r2) {
        if (Math.abs(r2.y - r1.y) <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean b(PointF r1, PointF r2) {
        if (Math.abs(r2.x - r1.x) <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final VHNode a(ViewHierarchyDump r13, PointF r14, PointF r15) {
        boolean r8 = a(r14, r15);
        boolean r9 = b(r14, r15);
        final List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        VHNode r1 = r13.getRootNode();
        if (r1 == null) goto L6;
        a(r1, r14, r15, r8, r9, true, new $$Lambda$a$rRRj2Ugy3if53kWuIVW799RLOg(r11));
    L6:
        if (r11.isEmpty() == false) goto L11;
        VHNode r2 = r13.getRootNode();
        if (r2 == null) goto L11;
        a(r2, r14, r15, r8, r9, false, new $$Lambda$a$9lnGMOJugbDHPHhpuAfwBxM3dEc(r11));
    L11:
        if (r11.isEmpty() == false) goto L14;
        return null;
    L14:
        p.a(r11, (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.dp(b(), new $$Lambda$a$i32x5xuAwDmIsC1o8OkpgrVbldc(r11));
        return (VHNode) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(p.k(r11), m.class, "com.obric.aiagent.plugin")).a(), VHNode.class, "com.obric.aiagent.plugin");
    }

    private static final x a(List r2, VHNode r3, float r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r6, "node");
        r5.add(s.a(r6, Float.valueOf(r4)));
        return x.f38692a;
    }

    private static final x b(List r2, VHNode r3, float r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r6, "node");
        r5.add(s.a(r6, Float.valueOf(r4)));
        return x.f38692a;
    }

    private static final String a(List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder().append("found scrollable node candidates : ");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        m r3 = (m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.aiagent.plugin");
        r2.add(((VHNode) ZeusTransformUtils.preCheckCast(r3.a(), VHNode.class, "com.obric.aiagent.plugin")).getClassName() + ' ' + ((VHNode) ZeusTransformUtils.preCheckCast(r3.a(), VHNode.class, "com.obric.aiagent.plugin")).getId() + ' ' + ((VHNode) ZeusTransformUtils.preCheckCast(r3.a(), VHNode.class, "com.obric.aiagent.plugin")).getBounds() + " score=" + ((Number) ZeusTransformUtils.preCheckCast(r3.b(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L4
    L7:
        return r0.append((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).append('}').toString();
    }

    private final void a(VHNode r13, PointF r14, PointF r15, boolean r16, boolean r17, boolean r18, d.h.a.m<? super VHNode, ? super Float, x> r19) {
        VHNode r0 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r13, VHNode.class, "com.obric.aiagent.plugin");
        d.h.a.m<? super VHNode, ? super Float, x> r2 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.m.class, "com.obric.aiagent.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.getChildren(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        a((VHNode) ZeusTransformUtils.preCheckCast(r11.next(), VHNode.class, "com.obric.aiagent.plugin"), r14, r15, r16, r17, r18, r2);
        goto L4
    L7:
        if (ZeusTransformUtils.instanceOf(r0, ScrollableVTNode.class) == true) goto L9;
        return;
    L9:
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r0, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable() == false) goto L24;
        boolean r3 = true;
        if (r18 == false) goto L16;
        if (r16 == false) goto L14;
        r3 = ((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r0, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableVertical();
        goto L16
    L14:
        if (r17 == false) goto L16;
        r3 = ((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r0, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableHorizontal();
    L16:
        if (r3 == false) goto L25;
        float r4 = a(r0, r14, r15);
        if (r4 < 0.2f) goto L20;
        r2.invoke(r0, Float.valueOf(r4));
        return;
    L20:
        Loog.INSTANCE.d(b(), " - ignore scrollable node " + r0 + ", score=" + r4);
        return;
    L25:
        return;
    }

    private final float a(VHNode r8, PointF r9, PointF r10) {
        VHNode.Bounds r7 = ((VHNode) ZeusTransformUtils.wrapperContextForParams(r8, VHNode.class, "com.obric.aiagent.plugin")).getBounds();
        int r11 = 0;
        int r0 = 0;
    L3:
        float r1 = r11 / 9;
        float r3 = r9.x + ((r10.x - r9.x) * r1);
        float r4 = r9.y + ((r10.y - r9.y) * r1);
        if (r3 >= r7.getScreenLeft()) goto L6;
    L12:
        if (r11 == 9) goto L15;
        r11 = r11 + 1;
        goto L3
    L15:
        return r0 / 10;
    L6:
        if (r3 > r7.getScreenRight()) goto L12;
        if (r4 < r7.getScreenTop()) goto L12;
        if (r4 > r7.getScreenBottom()) goto L12;
        r0 = r0 + 1;
        goto L12
    }

    private static final boolean a(VHNode r2, int r3, int r4) {
        VHNode r5 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r5, "node");
        VHNode.Bounds r6 = r5.getBounds();
        if (r3 >= r6.getScreenLeft()) goto L5;
    L11:
        return false;
    L5:
        if (r3 > r6.getScreenRight()) goto L11;
        if (r4 < r6.getScreenTop()) goto L11;
        if (r4 > r6.getScreenBottom()) goto L11;
        return true;
    }

    private final VHNode b(ViewHierarchyDump r8, final PointF r9, final PointF r10) {
        final $$Lambda$a$NOHQLtPKyH5IqjZCZd8qd0z_AKE r1 = $$Lambda$a$NOHQLtPKyH5IqjZCZd8qd0z_AKE.INSTANCE;
        float r0 = 2;
        final int r4 = (int) ((r9.x + r10.x) / r0);
        final int r5 = (int) ((r9.y + r10.y) / r0);
        VHNode r7 = r8.getRootNode();
        if (r7 != null) goto L7;
        return null;
    L7:
        return r8.findNodeAtRecursive(r7, new $$Lambda$a$ZcKwTqjHb07BCFo7Dq9Cybng0o8(r1, r9, r10, r4, r5));
    }

    private static final boolean a(q r4, PointF r5, PointF r6, int r7, int r8, VHNode r9) {
        q r10 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        VHNode r11 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r9, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r11, "node");
        String r0 = r11.getClassName();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r11, Integer.valueOf((int) r5.x), Integer.valueOf((int) r5.y)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L5;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L13;
        return false;
    L13:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.operator.a.c.a.b.f29775a.a(), Iterable.class, "com.obric.aiagent.plugin"), r0) == true) goto L17;
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(f29788d, Iterable.class, "com.obric.aiagent.plugin"), r0) == true) goto L17;
        return false;
    L17:
        return true;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r11, Integer.valueOf((int) r6.x), Integer.valueOf((int) r6.y)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L10;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r11, Integer.valueOf(r7), Integer.valueOf(r8)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L10;
        r12 = false;
        goto L11
    }
}
