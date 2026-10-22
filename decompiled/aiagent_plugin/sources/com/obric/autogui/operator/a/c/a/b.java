package com.obric.autogui.operator.a.c.a;

import android.content.ComponentName;
import android.content.res.Resources;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.system.IAutoActionSystemApi;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.operator.a.c.c;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import d.o.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ViewTreeCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f29776b = null;

    /* JADX INFO: compiled from: ViewTreeCheck.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final Set<String> a() {
            return b.c();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewTreeCheck.kt */
    @f(b = "ViewTreeCheck.kt", c = {43, 60, 104}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.ViewTreeCheck")
    static final class C0772b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29781e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ b i;
        int j;

        C0772b(b r3, d.c.d<? super C0772b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ boolean lambda$ExgL60IP9VstB0dlzR0WIFm5wXc(VHNode r0) {
        return a(r0);
    }

    public Object a(e r9, com.obric.autogui.operator.b.a r10, List<ViewHierarchyDump> r11, List<ViewHierarchyDump> r12, d.c.d<? super com.obric.autogui.common.e> r13) {
        return a(this, r9, (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.c.a
    public String a() {
        return "ViewTreeWindowCheck";
    }

    public b() {
    }

    public static final /* synthetic */ Set c() {
        return f29776b;
    }

    static {
        f29775a = new a(null);
        f29776b = ax.a(new String[]{"android.view.SurfaceView", "android.view.TextureView"});
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public final Object a(String r26, e r27, com.obric.autogui.operator.b.a r28, d.c.d<? super com.obric.autogui.common.e> r29) {
        b r0 = this;
        String r1 = r26;
        e r2 = r27;
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r28, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, C0772b.class) == false) goto L7;
        C0772b r7 = (C0772b) ZeusTransformUtils.preCheckCast(r6, C0772b.class, "com.obric.aiagent.plugin");
        if ((r7.j & Integer.MIN_VALUE) == 0) goto L7;
        r7.j -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.h;
        Object r14 = d.c.a.b.a();
        int r9 = r7.j;
        String r13 = " - [";
        String r12 = null;
        if (r9 == 0) goto L18;
        if (r9 == 1) goto L17;
        if (r9 == 2) goto L16;
        if (r9 != 3) goto L15;
        o.a(r8);
    L101:
        return r8;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        com.obric.autogui.agents.vlm.models.impl.f.a r3 = (com.obric.autogui.agents.vlm.models.impl.f.a) ZeusTransformUtils.preCheckCast(r7.g, com.obric.autogui.agents.vlm.models.impl.f.a.class, "com.obric.aiagent.plugin");
        g r5 = (g) ZeusTransformUtils.preCheckCast(r7.f, g.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r10 = (List) ZeusTransformUtils.preCheckCast(r7.f29781e, List.class, "com.obric.aiagent.plugin");
        r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r7.f29780d, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        e r11 = (e) ZeusTransformUtils.preCheckCast(r7.f29779c, e.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r7.f29778b, String.class, "com.obric.aiagent.plugin");
        b r16 = (b) ZeusTransformUtils.preCheckCast(r7.f29777a, b.class, "com.obric.aiagent.plugin");
        o.a(r8);
    L47:
        com.obric.autogui.agents.vlm.models.impl.f.a r17 = r3;
        com.obric.autogui.operator.b.a r18 = r4;
        List<ViewHierarchyDump> r19 = (List) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");
        b r24 = r16;
        g r20 = r5;
        r1 = r15;
        e r21 = r11;
        b r22 = r24;
    L48:
        if (r19 != null) goto L51;
        Loog.INSTANCE.d(r1, r13 + r22.a() + "] Failed to dump current viewTree, skip check");
        return com.obric.autogui.common.e.f29014b.a();
    L51:
        if (r17 != null) goto L55;
        if (r20 == null) goto L54;
        r20.a(new com.obric.autogui.agents.vlm.models.impl.f.a(r19, AOSystemTools.INSTANCE.nowTimeMillis(), com.obric.autogui.common.a.d.f28974a.H()));
    L54:
        Loog.INSTANCE.d(r1, "[OAutoActionEffect] - [" + r22.a() + "] cached current viewtree for pre-execution reuse");
    L55:
        ViewHierarchyDump r23 = r22.a(r10);
        ViewHierarchyDump r25 = r22.a(r19);
        if (r23 == null) goto L58;
        Integer r30 = d.c.b.a.b.a(r23.getWindowIndex());
    L59:
        if (r25 == null) goto L61;
        Integer r31 = d.c.b.a.b.a(r25.getWindowIndex());
    L63:
        if (d.h.b.o.a(r30, r31) == true) goto L98;
        Loog r32 = Loog.INSTANCE;
        StringBuilder r33 = new StringBuilder().append(r13).append(r22.a()).append("] window changed, pre=");
        if (r23 == null) goto L67;
        Integer r110 = d.c.b.a.b.a(r23.getWindowIndex());
    L68:
        StringBuilder r34 = r33.append(r110).append(", cur=");
        if (r25 == null) goto L71;
        Integer r111 = d.c.b.a.b.a(r25.getWindowIndex());
    L72:
        r32.w(r1, r34.append(r111).toString());
        StringBuilder r35 = new StringBuilder().append("window shown or hided, pre=");
        if (r23 == null) goto L75;
        Integer r112 = d.c.b.a.b.a(r23.getWindowIndex());
    L76:
        StringBuilder r36 = r35.append(r112).append(", cur=");
        if (r25 == null) goto L79;
        Integer r113 = d.c.b.a.b.a(r25.getWindowIndex());
    L80:
        r22.a("window_changed", r36.append(r113).toString());
        com.obric.autogui.common.e.a r37 = com.obric.autogui.common.e.f29014b;
        int r38 = ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_content_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_content_changed");
        StringBuilder r39 = new StringBuilder().append("node not matched: occluding window changed (prev=");
        if (r23 == null) goto L83;
        Integer r114 = d.c.b.a.b.a(r23.getWindowIndex());
    L84:
        StringBuilder r40 = r39.append(r114).append(", cur=");
        if (r25 == null) goto L87;
        Integer r115 = d.c.b.a.b.a(r25.getWindowIndex());
    L88:
        com.obric.autogui.common.e r41 = r37.a(r38, r40.append(r115).append(')').toString());
        String r42 = "ignore_" + r1 + "_viewTree_window_change";
        StringBuilder r43 = new StringBuilder().append("prevWindow=");
        if (r23 == null) goto L91;
        Integer r116 = d.c.b.a.b.a(r23.getWindowIndex());
    L92:
        StringBuilder r44 = r43.append(r116).append(", curWindow=");
        if (r25 == null) goto L95;
        Integer r117 = d.c.b.a.b.a(r25.getWindowIndex());
    L97:
        return com.obric.autogui.common.b.a(r41, r42, r44.append(r117).toString(), false, null, 0, 24, null);
    L95:
        r117 = null;
        goto L97
    L91:
        r116 = null;
        goto L92
    L87:
        r115 = null;
        goto L88
    L83:
        r114 = null;
        goto L84
    L79:
        r113 = null;
        goto L80
    L75:
        r112 = null;
        goto L76
    L71:
        r111 = null;
        goto L72
    L67:
        r110 = null;
        goto L68
    L98:
        r7.f29777a = null;
        r7.f29778b = null;
        r7.f29779c = null;
        r7.f29780d = null;
        r7.f29781e = null;
        r7.f = null;
        r7.g = null;
        r7.j = 3;
        r8 = r22.a(r21, r18, r10, r19, r7);
        if (r8 != r14) goto L101;
        return r14;
    L61:
        r31 = null;
        goto L63
    L58:
        r30 = null;
        goto L59
    L17:
        r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r7.f29780d, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        e r45 = (e) ZeusTransformUtils.preCheckCast(r7.f29779c, e.class, "com.obric.aiagent.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r7.f29778b, String.class, "com.obric.aiagent.plugin");
        b r46 = (b) ZeusTransformUtils.preCheckCast(r7.f29777a, b.class, "com.obric.aiagent.plugin");
        o.a(r8);
        r2 = r45;
        r0 = r46;
    L22:
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L27;
        r20 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.a.a.b r47 = ((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).n();
        if (r47 == null) goto L26;
        List<ViewHierarchyDump> r48 = r47.c();
    L28:
        if (r48 != null) goto L34;
        Loog r49 = Loog.INSTANCE;
        StringBuilder r50 = new StringBuilder().append(" - [").append(r0.a()).append("] No viewTree found for step=");
        if (r2 == null) goto L32;
        r12 = r2.W();
    L32:
        r49.d(r1, r50.append(r12).append(", skip check").toString());
        return com.obric.autogui.common.e.f29014b.a();
    L34:
        Loog.INSTANCE.i(r1, " - [" + r0.a() + "] - prepare viewtree for pre-check");
        long r118 = AOSystemTools.INSTANCE.nowTimeMillis();
        if (r20 == null) goto L37;
        r17 = r20.d(r118);
    L38:
        if (r17 == null) goto L43;
        List<ViewHierarchyDump> r51 = r17.a();
        if (r51 == null) goto L43;
        r21 = r2;
        r18 = r4;
        r10 = r48;
        r19 = r51;
        r13 = " - [";
        r22 = r0;
    L43:
        IAutoActionSystemApi r52 = AOPlatformTools.INSTANCE.system();
        int r119 = AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId();
        r7.f29777a = r0;
        r7.f29778b = r1;
        r7.f29779c = r2;
        r7.f29780d = r4;
        r7.f29781e = r48;
        r7.f = r20;
        r7.g = r17;
        r7.j = 2;
        com.obric.autogui.agents.vlm.models.impl.f.a r120 = r17;
        Object r53 = IAutoActionSystemApi.DefaultImpls.dumpViewHierarchy$default(r52, r119, false, r7, 2, null);
        if (r53 != r14) goto L46;
        return r14;
    L46:
        r15 = r1;
        r5 = r20;
        r16 = r0;
        r3 = r120;
        r11 = r2;
        r10 = r48;
        r8 = r53;
        goto L47
    L37:
        r17 = null;
        goto L38
    L26:
        r48 = null;
        goto L28
    L27:
        r20 = null;
        r48 = null;
        goto L28
    L18:
        o.a(r8);
        r7.f29777a = r0;
        r7.f29778b = r1;
        r7.f29779c = r2;
        r7.f29780d = r4;
        r7.j = 1;
        if (super.a(r1, r2, r4, r7) != r14) goto L22;
        return r14;
    L7:
        r7 = new C0772b(r0, r6);
        goto L8
    }

    static /* synthetic */ Object a(b r0, e r1, com.obric.autogui.operator.b.a r2, List<ViewHierarchyDump> r3, List<ViewHierarchyDump> r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        com.obric.autogui.operator.b.a r6 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    public final boolean b(String r6, String r7) {
        d.h.b.o.e(r6, "enableKey");
        d.h.b.o.e(r7, "whiteListKey");
        if (AutoActionConfigs.INSTANCE.getBooleanCfg(r6, false) == true) goto L5;
        return false;
    L5:
        List<?> r5 = AutoActionConfigs.INSTANCE.getListCfg(r7);
        if (ZeusTransformUtils.instanceOf(r5, List.class) == true) goto L9;
        r5 = null;
    L9:
        if (r5 != null) goto L11;
        r5 = p.b();
    L11:
        ComponentName r8 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        String r9 = r8.flattenToString();
        if (r9 == null) goto L15;
    L17:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L31;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L21;
    L23:
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L22;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        if (new k(r12).a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L25;
        boolean r13 = true;
    L29:
        if (r13 == true) goto L31;
        return false;
    L22:
        r13 = false;
        goto L29
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
    L31:
        return true;
    L15:
        r9 = "";
        goto L17
    }

    public final ViewHierarchyDump a(List<ViewHierarchyDump> r5, int r6, int r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "viewHierarchy");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(p.l((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L22;
        ViewHierarchyDump r9 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r8.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        VHNode r1 = r9.getRootNode();
        if (r1 == null) goto L4;
        VHNode.Bounds r2 = r1.getBounds();
        if (r2 == null) goto L4;
        if (r6 >= r2.getScreenLeft()) goto L13;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L4;
        return r9;
    L13:
        if (r6 >= (r2.getScreenLeft() + r2.getWidth())) goto L19;
        if (r7 < r2.getScreenTop()) goto L19;
        if (r7 >= (r2.getScreenTop() + r2.getHeight())) goto L19;
        r3 = true;
        goto L20
    L22:
        return null;
    }

    private final ViewHierarchyDump a(List<ViewHierarchyDump> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (r14.size() > 1) goto L5;
        return null;
    L5:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(p.l((Iterable) ZeusTransformUtils.preCheckCast(r14.subList(1, r14.size()), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r15.hasNext() == false) goto L21;
        ViewHierarchyDump r0 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r15.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        VHNode r3 = r0.getRootNode();
        if (r3 == null) goto L7;
        VHNode.Bounds r4 = r3.getBounds();
        if (r4 == null) goto L7;
        if (r4.getWidth() <= 0) goto L7;
        if (r4.getHeight() <= 0) goto L7;
        int r8 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (a(this, r4.getScreenLeft(), r4.getScreenLeft() + r4.getWidth(), r8, 0, 8, null) == false) goto L7;
        return r0;
    L21:
        return null;
    }

    static /* synthetic */ boolean a(b r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = 1;
    L7:
        return r0.a(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isHorizontallyCentered");
    }

    private final boolean a(int r1, int r2, int r3, int r4) {
        if (Math.abs((r1 + r2) - r3) > (r4 * 2)) goto L5;
        return true;
    L5:
        return false;
    }

    public final VHNode a(ViewHierarchyDump r1, int r2, int r3) {
        d.h.b.o.e(r1, "<this>");
        return r1.findNodeByPosition(r2, r3, $$Lambda$b$ExgL60IP9VstB0dlzR0WIFm5wXc.INSTANCE);
    }

    private static final boolean a(VHNode r3) {
        VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "node");
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(f29776b, Iterable.class, "com.obric.aiagent.plugin"), r4.getClassName());
    }
}
