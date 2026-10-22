package com.obric.autogui.agents.a.a.a;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.input.InjectTextResponse;
import com.obric.autogui.common.api.platform.input.InjectTextResponseListener;
import com.obric.autogui.common.api.platform.input.InjectTextViewTreeNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TypeActionEffectHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends com.obric.autogui.agents.a.a.a.b {
    private static final String TAG = "TypeActionEffectHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.operator.a.b.f.b f26206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f26208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile d f26209e;
    private volatile com.obric.autogui.agents.a.a.h f;
    private volatile com.obric.autogui.agents.a.l.c g;
    private final InjectTextResponseListener h;
    private final p i;

    /* JADX INFO: compiled from: TypeActionEffectHandler.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TypeActionEffectHandler.kt */
    @d.c.b.a.f(b = "TypeActionEffectHandler.kt", c = {203}, d = "lockInputResultBeforeEnter", e = "com.obric.autogui.agents.actioneffect.attempt.handler.TypeActionEffectHandler")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f26214e;
        final /* synthetic */ o f;
        int g;

        b(o r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26214e = r3;
            this.g |= Integer.MIN_VALUE;
            return o.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TypeActionEffectHandler.kt */
    @d.c.b.a.f(b = "TypeActionEffectHandler.kt", c = {101}, d = "onBeforeOperation", e = "com.obric.autogui.agents.actioneffect.attempt.handler.TypeActionEffectHandler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f26218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f26219e;
        int f;

        c(o r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26219e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26218d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f26219e.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26205a = new a(null);
    }

    public static /* synthetic */ void lambda$2RykOvgh4qTYTY03NK2KiKCB4No(o r0, InjectTextResponse r1) {
        a(r0, r1);
    }

    public static final /* synthetic */ Object a(o r2, d r3, d.c.d r4) {
        return r2.a((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public o(com.obric.autogui.operator.e r11) {
        d.h.b.o.e(r11, "step");
        super(com.obric.autogui.operator.b.EnumC0777b.f);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        boolean r2 = true;
        String r3 = null;
        if (r12.hasNext() == false) goto L11;
        Object r0 = r12.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L3;
    L12:
        com.obric.autogui.operator.e.C0780e r13 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L15;
        com.obric.autogui.operator.b.a r14 = r13.b();
    L17:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.autogui.operator.a.b.f.b.class) == false) goto L19;
        com.obric.autogui.operator.a.b.f.b r15 = (com.obric.autogui.operator.a.b.f.b) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.operator.a.b.f.b.class, "com.obric.aiagent.plugin");
    L20:
        this.f26206b = r15;
        if (r15 == null) goto L23;
        r3 = r15.c();
    L23:
        this.f26207c = r3;
        if (r15 == null) goto L26;
        r2 = r15.d();
    L26:
        this.f26208d = r2;
        InjectTextResponseListener r5 = new $$Lambda$o$2RykOvgh4qTYTY03NK2KiKCB4No(this);
        this.h = r5;
        this.i = new p(r5, null, null, null, 14, null);
        return;
    L19:
        r15 = null;
        goto L20
    L15:
        r14 = null;
        goto L17
    L8:
        r4 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    private static final void a(o r12, InjectTextResponse r13) {
        d.h.b.o.e(r13, "response");
        d r0 = r12.f26209e;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = AOSystemTools.INSTANCE.bootTimeMillis();
        p.d r14 = r12.i.a(r13);
        String r4 = null;
        if (r14.a() == false) goto L10;
        com.obric.autogui.agents.a.a.e r3 = com.obric.autogui.agents.a.a.c.a(r13);
        if (r3 == null) goto L11;
        r0.a(r3);
    L11:
        long r2 = d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r1, 0);
        boolean r6 = true;
        int r7 = 0;
        if (r14.a() == true) goto L14;
    L16:
        boolean r5 = false;
    L17:
        Loog r8 = Loog.INSTANCE;
        StringBuilder r9 = new StringBuilder();
        StringBuilder r10 = r9.append("[OAutoActionEffect] injectText callback evaluated ").append(r0.g()).append(", type=").append(r13.getType()).append(", accepted=").append(r14.a()).append(", callback_status=");
        if (r3 == null) goto L20;
        com.obric.autogui.agents.a.f.k r11 = r3.a();
    L21:
        StringBuilder r15 = r10.append(r11).append(", callback_reason=");
        if (r3 == null) goto L24;
        com.obric.autogui.agents.a.a.d r16 = r3.b();
    L25:
        StringBuilder r17 = r15.append(r16).append(", selected_status=");
        com.obric.autogui.agents.a.a.e r18 = r0.f();
        if (r18 == null) goto L28;
        com.obric.autogui.agents.a.f.k r19 = r18.a();
    L29:
        StringBuilder r20 = r17.append(r19).append(", framework_callback_available=");
        if (r14.b() == null) goto L32;
        boolean r21 = true;
    L33:
        StringBuilder r22 = r20.append(r21).append(", registration_to_callback_elapsed_ms=");
        Long r110 = r14.b();
        if (r110 == null) goto L36;
        r4 = r110.toString();
    L36:
        if (r4 != null) goto L38;
        r4 = "";
    L38:
        StringBuilder r111 = r22.append(r4).append(", viewtree_available=");
        if (r13.getInputNodes() != null) goto L42;
        r6 = false;
    L42:
        StringBuilder r112 = r111.append(r6).append(", input_node_count=");
        List<InjectTextViewTreeNode> r113 = r13.getInputNodes();
        if (r113 == null) goto L45;
        r7 = r113.size();
    L45:
        r112.append(r7).append(", framework_callback_processing_elapsed_ms=").append(r2).append(", processing_timing_recorded=");
        r9.append(r5);
        r8.i(TAG, r9.toString());
        return;
    L32:
        r21 = false;
        goto L33
    L28:
        r19 = null;
        goto L29
    L24:
        r16 = null;
        goto L25
    L20:
        r11 = null;
        goto L21
    L14:
        if (r0.a(r2) == false) goto L16;
        r5 = true;
        goto L17
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public com.obric.autogui.agents.a.a.a.a b() {
        return (com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast(new n(this.f26207c, this.f26208d, this.f, this.g), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public Object a(d r6, com.obric.autogui.operator.e.C0780e r7, com.obric.autogui.operator.b r8, d.c.d<? super x> r9) {
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, c.class) == false) goto L7;
        c r12 = (c) ZeusTransformUtils.preCheckCast(r11, c.class, "com.obric.aiagent.plugin");
        if ((r12.f & Integer.MIN_VALUE) == 0) goto L7;
        r12.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r12.f26218d;
        Object r1 = d.c.a.b.a();
        int r2 = r12.f;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        com.obric.autogui.operator.e.C0780e r5 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r12.f26217c, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        r10 = (d) ZeusTransformUtils.preCheckCast(r12.f26216b, d.class, "com.obric.aiagent.plugin");
        o r14 = (o) ZeusTransformUtils.preCheckCast(r12.f26215a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        r7 = r5;
        o this = r14;
    L20:
        if (r7.a() != com.obric.autogui.operator.b.EnumC0777b.f) goto L22;
        List<ViewHierarchyDump> r15 = r10.c().b();
        if (r15 == null) goto L26;
        boolean r0 = true;
    L27:
        this.f = new com.obric.autogui.agents.a.a.h(r0, com.obric.autogui.agents.a.n.a.f26730a.b(r15));
        this.d(r10);
        Loog r16 = Loog.INSTANCE;
        StringBuilder r17 = new StringBuilder().append("[OAutoActionEffect] type target resolved ").append(r10.g()).append(", viewtree_available=");
        com.obric.autogui.agents.a.a.h r18 = this.f;
        if (r18 != null) goto L30;
    L32:
        boolean r19 = false;
    L33:
        StringBuilder r20 = r17.append(r19).append(", has_input_target=");
        com.obric.autogui.agents.a.a.h r21 = this.f;
        if (r21 == null) goto L36;
        com.obric.autogui.agents.a.n.a.e r22 = r21.b();
    L37:
        if (r22 != null) goto L40;
        r3 = false;
    L40:
        r16.i(TAG, r20.append(r3).toString());
        return x.f38692a;
    L36:
        r22 = null;
        goto L37
    L30:
        if (r18.a() != true) goto L32;
        r19 = true;
        goto L33
    L26:
        r0 = false;
        goto L27
    L22:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        if (a(r10, r7) == false) goto L20;
        r12.f26215a = this;
        r12.f26216b = r10;
        r12.f26217c = r7;
        r12.f = 1;
        if (a(r10, r12) != r1) goto L20;
        return r1;
    L7:
        r12 = new c(this, r11);
        goto L8
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public void a(d r3, com.obric.autogui.operator.e.C0780e r4, com.obric.autogui.operator.c r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.c r7 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "scope");
        d.h.b.o.e(r4, "operation");
        d.h.b.o.e(r7, "result");
        if (r4.a() == com.obric.autogui.operator.b.EnumC0777b.f) goto L5;
        return;
    L5:
        if (r7.a() == false) goto L9;
        a(r6, "type operation failed");
        return;
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public void b(d r3, com.obric.autogui.operator.e.C0780e r4, com.obric.autogui.operator.c r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.c r7 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "scope");
        d.h.b.o.e(r4, "operation");
        d.h.b.o.e(r7, "result");
        if (r4.a() == com.obric.autogui.operator.b.EnumC0777b.f) goto L5;
        return;
    L5:
        if (r7.a() == false) goto L9;
        a(r6, "type operation skipped with failure");
        return;
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public e a(d r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "scope");
        p.c r7 = c(r9);
        p.a r0 = r7.a();
        Long r1 = null;
        if (r0 == null) goto L7;
        InjectTextResponse r2 = r0.a();
        if (r2 == null) goto L7;
        com.obric.autogui.agents.a.a.e r3 = com.obric.autogui.agents.a.a.c.a(r2);
    L8:
        Loog r4 = Loog.INSTANCE;
        StringBuilder r10 = new StringBuilder().append("[OAutoActionEffect] injectText callback frozen ").append(r9.g()).append(", framework_callback_available=");
        boolean r5 = true;
        if (r0 == null) goto L11;
        boolean r6 = true;
    L12:
        StringBuilder r11 = r10.append(r6).append(", framework_callback_usable=");
        if (r3 != null) goto L16;
        r5 = false;
    L16:
        StringBuilder r12 = r11.append(r5).append(", callback_status=");
        if (r3 == null) goto L19;
        com.obric.autogui.agents.a.f.k r13 = r3.a();
    L20:
        StringBuilder r14 = r12.append(r13).append(", callback_reason=");
        if (r3 == null) goto L23;
        com.obric.autogui.agents.a.a.d r15 = r3.b();
    L24:
        StringBuilder r16 = r14.append(r15).append(", registration_to_callback_elapsed_ms=");
        if (r0 == null) goto L27;
        String r17 = Long.valueOf(r0.b()).toString();
    L28:
        if (r17 != null) goto L30;
        r17 = "";
    L30:
        StringBuilder r18 = r16.append(r17).append(", callback_wait_ms=").append(r7.b()).append(", fallback=");
        if (r3 != null) goto L33;
        String r19 = "virtual_viewtree";
    L34:
        r4.i(TAG, r18.append(r19).toString());
        if (r0 == null) goto L38;
        r1 = Long.valueOf(r0.b());
    L38:
        return new e(r3, r1, r7.b());
    L33:
        r19 = "framework";
        goto L34
    L27:
        r17 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L11:
        r6 = false;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public boolean b(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "scope");
        p.f r0 = this.i.b();
        this.f26209e = null;
        if (r0.a() == true) goto L7;
        return true;
    L7:
        if (r0.b() == false) goto L9;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] injectText listener released " + r6.g() + ", unregistered=true");
    L11:
        return r0.b();
    L9:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] injectText listener release failed " + r6.g() + ", retryable=true");
        goto L11
    }

    private final Object a(d r20, d.c.d<? super x> r21) {
        o r0 = this;
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r20, d.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
        r5.g -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f26214e;
        Object r7 = d.c.a.b.a();
        int r8 = r5.g;
        String r9 = null;
        List<ViewHierarchyDump> r10 = null;
        boolean r11 = false;
        int r12 = 0;
        boolean r13 = true;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        r0 = (o) ZeusTransformUtils.preCheckCast(r5.f26213d, o.class, "com.obric.aiagent.plugin");
        p.c r3 = (p.c) ZeusTransformUtils.preCheckCast(r5.f26212c, p.c.class, "com.obric.aiagent.plugin");
        d r14 = (d) ZeusTransformUtils.preCheckCast(r5.f26211b, d.class, "com.obric.aiagent.plugin");
        o r1 = (o) ZeusTransformUtils.preCheckCast(r5.f26210a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        Object r15 = r6;
        p.c r16 = r3;
        r2 = r14;
    L37:
        r0.g = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");
        Loog r17 = Loog.INSTANCE;
        StringBuilder r18 = new StringBuilder().append("[OAutoActionEffect] type result locked before enter ").append(r2.g()).append(", framework_callback_available=false, callback_wait_ms=").append(r16.b()).append(", fallback=virtual_viewtree, available_viewtree=");
        com.obric.autogui.agents.a.l.c r19 = r1.g;
        if (r19 == null) goto L40;
        r10 = r19.b();
    L40:
        if (r10 != null) goto L43;
        r13 = false;
    L43:
        StringBuilder r22 = r18.append(r13).append(", error_count=");
        com.obric.autogui.agents.a.l.c r23 = r1.g;
        if (r23 == null) goto L46;
        r12 = r23.f();
    L46:
        r17.i(TAG, r22.append(r12).toString());
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        r2.b("type_before_enter");
        r16 = r0.c(r2);
        p.a r24 = r16.a();
        if (r24 == null) goto L21;
        InjectTextResponse r110 = r24.a();
        if (r110 == null) goto L21;
        com.obric.autogui.agents.a.a.e r111 = com.obric.autogui.agents.a.a.c.a(r110);
        if (r111 == null) goto L21;
        r2.a(r111);
    L21:
        com.obric.autogui.agents.a.a.e r112 = r2.f();
        if (r112 == null) goto L33;
        Loog r25 = Loog.INSTANCE;
        StringBuilder r26 = new StringBuilder().append("[OAutoActionEffect] type result snapshot skipped ").append(r2.g()).append(", status=").append(r112.a()).append(", reason=").append(r112.b()).append(", framework_callback_available=");
        if (r24 == null) goto L26;
        r11 = true;
    L26:
        StringBuilder r27 = r26.append(r11).append(", registration_to_callback_elapsed_ms=");
        if (r24 == null) goto L29;
        r9 = d.c.b.a.b.a(r24.b()).toString();
    L29:
        if (r9 != null) goto L31;
        r9 = "";
    L31:
        r25.i(TAG, r27.append(r9).append(", callback_wait_ms=").append(r16.b()).toString());
        return x.f38692a;
    L33:
        com.obric.autogui.agents.a.l.a r28 = new com.obric.autogui.agents.a.l.a(false, true, false, false, 8, null);
        r5.f26210a = r0;
        r5.f26211b = r2;
        r5.f26212c = r16;
        r5.f26213d = r0;
        r5.g = 1;
        Object r29 = r2.a("type_before_enter", r28, r5);
        if (r29 != r7) goto L36;
        return r7;
    L36:
        r15 = r29;
        r1 = r0;
    L7:
        r5 = new b(r0, r4);
        goto L8
    }

    private final p.c c(d r3) {
        if (((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).f() != null) goto L5;
        long r0 = 30;
    L7:
        return this.i.a(r0);
    L5:
        r0 = 0;
        goto L7
    }

    private final void d(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.f26209e = r5;
        p.e r0 = this.i.a();
        if (r0.a() == true) goto L5;
        this.f26209e = null;
    L5:
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] injectText listener registered " + r5.g() + ", registered=" + r0.a() + ", skipped_closed=" + r0.b() + ", framework_callback_timer_started=" + r0.a());
    }

    private final void a(d r3, String r4) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).a(new com.obric.autogui.agents.a.a.e(com.obric.autogui.agents.a.f.k.f26445d, com.obric.autogui.agents.a.a.d.f26244c, r4));
    }

    private final boolean a(d r4, com.obric.autogui.operator.e.C0780e r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (this.f26207c != null) goto L5;
        return false;
    L5:
        if (r5.a() == com.obric.autogui.operator.b.EnumC0777b.g) goto L7;
        return false;
    L7:
        if (r6.a(com.obric.autogui.operator.b.EnumC0777b.f) == false) goto L22;
        com.obric.autogui.operator.b.a r3 = r5.b();
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.operator.a.b.c.C0765c.class) == false) goto L12;
        com.obric.autogui.operator.a.b.c.C0765c r7 = (com.obric.autogui.operator.a.b.c.C0765c) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.a.b.c.C0765c.class, "com.obric.aiagent.plugin");
    L13:
        if (r7 != null) goto L16;
        return false;
    L16:
        if (r7.getType() != com.obric.autogui.operator.a.b.c.b.f29640d) goto L21;
        return true;
    L21:
        return false;
    L12:
        r7 = null;
        goto L13
    L22:
        return false;
    }
}
