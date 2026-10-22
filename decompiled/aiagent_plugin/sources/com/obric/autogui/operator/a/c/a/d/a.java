package com.obric.autogui.operator.a.c.a.d;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.k;
import d.o;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: OpTypeViewTreeCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.operator.a.c.a.b {

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpTypeViewTreeCheck.kt */
    public static final enum EnumC0775a extends Enum<EnumC0775a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0775a f29796a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0775a f29797b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0775a f29798c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0775a f29799d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0775a f29800e = null;
        private static final /* synthetic */ EnumC0775a[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        private static final /* synthetic */ EnumC0775a[] a() {
            return new EnumC0775a[]{f29796a, f29797b, f29798c, f29799d, f29800e};
        }

        private EnumC0775a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f29796a = new EnumC0775a("FOCUSED_INPUT_FOUND", 0);
            f29797b = new EnumC0775a("LIVE_IME_READY_FALLBACK", 1);
            f29798c = new EnumC0775a("PREPARED_DIRECT_INPUT_FALLBACK", 2);
            f29799d = new EnumC0775a("INPUT_MISSING", 3);
            f29800e = new EnumC0775a("IME_CHECK_FAILED", 4);
            EnumC0775a[] r0 = a();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0775a valueOf(String r2) {
            return (EnumC0775a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0775a.class, r2), EnumC0775a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0775a[] values() {
            return (EnumC0775a[]) ZeusTransformUtils.preCheckCast(f.clone(), EnumC0775a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OpTypeViewTreeCheck.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29801a = null;

        static {
            int[] r0 = new int[EnumC0775a.values().length];
            r0[EnumC0775a.f29796a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[EnumC0775a.f29797b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[EnumC0775a.f29798c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[EnumC0775a.f29800e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[EnumC0775a.f29799d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f29801a = r0;
        }
    }

    /* JADX INFO: compiled from: OpTypeViewTreeCheck.kt */
    @f(b = "OpTypeViewTreeCheck.kt", c = {50}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.type.OpTypeViewTreeCheck")
    static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29805d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f29806e;
        final /* synthetic */ a f;
        int g;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f29806e = r7;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$ASNJ7TW6dmnkSwu-NzJYykhvz9Y, reason: not valid java name */
    public static /* synthetic */ boolean m841lambda$ASNJ7TW6dmnkSwuNzJYykhvz9Y(VHNode r0) {
        return a(r0);
    }

    @Override // com.obric.autogui.operator.a.c.a.b, com.obric.autogui.operator.a.c.a
    public String a() {
        return "OpTypeViewTreeCheck";
    }

    public a() {
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(b("operator.precheck.type.viewtree.enable", "operator.precheck.type.viewtree.whitelist"));
    }

    @Override // com.obric.autogui.operator.a.c.a.b
    public Object a(e r10, com.obric.autogui.operator.b.a r11, List<ViewHierarchyDump> r12, List<ViewHierarchyDump> r13, d.c.d<? super com.obric.autogui.common.e> r14) {
        com.obric.autogui.operator.b.a r15 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, c.class) == false) goto L7;
        c r18 = (c) ZeusTransformUtils.preCheckCast(r17, c.class, "com.obric.aiagent.plugin");
        if ((r18.g & Integer.MIN_VALUE) == 0) goto L7;
        r18.g -= Integer.MIN_VALUE;
    L8:
        c r7 = r18;
        Object r19 = r7.f29806e;
        Object r110 = d.c.a.b.a();
        int r0 = r7.g;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r16 = (List) ZeusTransformUtils.preCheckCast(r7.f29805d, List.class, "com.obric.aiagent.plugin");
        r15 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r7.f29804c, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        r10 = (e) ZeusTransformUtils.preCheckCast(r7.f29803b, e.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r7.f29802a, a.class, "com.obric.aiagent.plugin");
        o.a(r19);
    L17:
        com.obric.autogui.common.e r111 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r19, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r111.g() == true) goto L21;
        return r111;
    L21:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.operator.a.b.f.b.class) == false) goto L23;
        com.obric.autogui.operator.a.b.f.b r112 = (com.obric.autogui.operator.a.b.f.b) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.operator.a.b.f.b.class, "com.obric.aiagent.plugin");
    L25:
        if (r112 != null) goto L28;
        Loog.INSTANCE.e(this.b(), " - [" + this.a() + "] needs a valid input");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), this.b() + " no input provided"), "ignore_" + this.b() + "_view_tree_no_input_provided", null, false, null, 0, 26, null);
    L28:
        int r113 = b.f29801a[this.a(r10, r16).ordinal()];
        if (r113 == 1) goto L49;
        if (r113 != 2) goto L33;
        Loog.INSTANCE.i(this.b(), " - [" + this.a() + "] live_ime_ready_without_focused_input_node, allow typing");
        return com.obric.autogui.common.e.f29014b.a();
    L33:
        if (r113 != 3) goto L35;
        Loog.INSTANCE.i(this.b(), " - [" + this.a() + "] prepared_direct_input_without_focused_input_node, allow typing");
        return com.obric.autogui.common.e.f29014b.a();
    L35:
        if (r113 != 4) goto L37;
        Loog.INSTANCE.w(this.b(), " - [" + this.a() + "] failed to query auto IME readiness");
    L42:
        Loog.INSTANCE.w(this.b(), " - [" + this.a() + "] node not matched (no focused node)");
        this.a("node_not_found", "could not find focused node");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_action_precheck_ignored_by_no_focused_input, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_precheck_ignored_by_no_focused_input"), this.b() + " node not found"), "ignore_" + this.b() + "_view_tree_no_focused_node", "node not matched (no focused node)", false, null, 0, 24, null);
    L37:
        if (r113 == 5) goto L42;
        throw new k();
    L49:
        return com.obric.autogui.common.e.f29014b.a();
    L23:
        r112 = null;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r19);
        r7.f29802a = this;
        r7.f29803b = r10;
        r7.f29804c = r15;
        r7.f29805d = r16;
        r7.g = 1;
        r19 = super.a(r10, r15, r5, r16, r7);
        if (r19 != r110) goto L17;
        return r110;
    L7:
        r18 = new c(this, r17);
        goto L8
    }

    private final EnumC0775a a(e r5, List<ViewHierarchyDump> r6) {
        if (a((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin")) != null) goto L5;
        Boolean r4 = Boolean.valueOf(AOPlatformTools.INSTANCE.special().isAutoImeReady());     // Catch: Exception -> L8 CancellationException -> L30
    L10:
        boolean r7 = true;
        if (d.h.b.o.a(r4, true) == false) goto L15;
        return EnumC0775a.f29797b;
    L15:
        if (r5 != null) goto L17;
    L22:
        r7 = false;
    L23:
        if (r7 == true) goto L25;
        if (r4 != null) goto L29;
        return EnumC0775a.f29800e;
    L29:
        return EnumC0775a.f29799d;
    L25:
        return EnumC0775a.f29798c;
    L17:
        if ((r5.M() & 4) == 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 != true) goto L22;
    L19:
        r8 = false;
        goto L20
    L30:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        Loog.INSTANCE.w(b(), " - [" + a() + "] auto IME readiness query failed, error_type=" + e.getClass().getSimpleName());
        r4 = null;
        goto L10
    L5:
        return EnumC0775a.f29796a;
    }

    private final VHNode a(List<ViewHierarchyDump> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(p.l((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        VHNode r0 = a((ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r5.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin"));
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    private final VHNode a(ViewHierarchyDump r2) {
        VHNode r1 = r2.getRootNode();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r2.findNodeAtRecursive(r1, $$Lambda$a$ASNJ7TW6dmnkSwuNzJYykhvz9Y.INSTANCE);
    }

    private static final boolean a(VHNode r5) {
        VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r5, VHNode.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "node");
        String r0 = r6.getClassName();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r6.isFocused() == true) goto L8;
    L14:
        return false;
    L8:
        if (r6.getInputType() <= 0) goto L10;
        return true;
    L10:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("EditText", CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L12;
        return true;
    L12:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TextField", CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L14;
        return true;
    }
}
