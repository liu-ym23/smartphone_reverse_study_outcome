package com.obric.autogui.agents.vlm.models.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BDUITarsModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0682a f27288a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.b.b[] f27289c;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BDUITarsModel.kt */
    public static final class C0682a {
        public /* synthetic */ C0682a(d.h.b.h r1) {
            this();
        }

        private C0682a() {
        }
    }

    /* JADX INFO: compiled from: BDUITarsModel.kt */
    private static final class b implements com.obric.autogui.agents.vlm.models.impl.b.b {

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BDUITarsModel.kt */
        public /* synthetic */ class C0683a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f27290a = null;

            static {
                int[] r0 = new int[com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.values().length];
                r0[com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27121a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27122b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f27290a = r0;
            }
        }

        public b() {
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.b.b
        public void a(com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.vlm.models.c.b r4, com.obric.autogui.agents.vlm.models.impl.b.a r5) {
            com.obric.autogui.agents.vlm.models.impl.b.a r2 = (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, SensitiveType.SESSION);
            d.h.b.o.e(r4, "preparation");
            d.h.b.o.e(r2, "requestEnvironment");
            com.obric.autogui.agents.vlm.b.C0677b.a r6 = r3.o();
            if (r6.a().isEmpty() == false) goto L5;
            return;
        L5:
            monitor-enter(r6);
            Iterator<com.obric.autogui.agents.vlm.b.C0677b.a.C0678a> r7 = r6.a().iterator();     // Catch: Throwable -> L23
        L8:
            if (r7.hasNext() == false) goto L20;
            com.obric.autogui.agents.vlm.b.C0677b.a.C0678a r8 = (com.obric.autogui.agents.vlm.b.C0677b.a.C0678a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autogui.agents.vlm.b.C0677b.a.C0678a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
            com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r0 = r8.getType();     // Catch: Throwable -> L23
            int r1 = C0683a.f27290a[r0.ordinal()];     // Catch: Throwable -> L23
            if (r1 != 1) goto L12;
            r2.b(r8.a());     // Catch: Throwable -> L23
            goto L8
        L12:
            if (r1 != 2) goto L14;
            r2.a(r8.a());     // Catch: Throwable -> L23
            goto L8
        L14:
            if (r1 != 3) goto L17;
            r2.c(r8.a());     // Catch: Throwable -> L23
            goto L8
        L17:
            throw new d.k();     // Catch: Throwable -> L23
        L20:
            x r9 = x.f38692a;     // Catch: Throwable -> L23
            monitor-exit(r6);
            return;
        L23:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: BDUITarsModel.kt */
    @d.c.b.a.f(b = "BDUITarsModel.kt", c = {57}, d = "makeHyperParams", e = "com.obric.autogui.agents.vlm.models.impl.BDUITarsModel")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f27295e;
        int f;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27295e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f27294d = r7;
            this.f |= Integer.MIN_VALUE;
            return this.f27295e.a(null, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27288a = new C0682a(null);
    }

    public a() {
        super(com.obric.autogui.agents.vlm.models.b.f27278b);
        this.f27289c = new com.obric.autogui.agents.vlm.models.impl.b.b[]{new b(), new com.obric.autogui.agents.vlm.models.impl.b.g(), new com.obric.autogui.agents.vlm.models.impl.b.f(), new com.obric.autogui.agents.vlm.models.impl.b.e(), new com.obric.autogui.agents.vlm.models.impl.b.d(), new com.obric.autogui.agents.vlm.models.impl.b.c()};
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.d
    public com.obric.autogui.agents.vlm.models.impl.d.b b() {
        return (com.obric.autogui.agents.vlm.models.impl.d.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.d.h(), com.obric.autogui.agents.vlm.models.impl.d.b.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, com.obric.autogui.operator.e, java.lang.Object] */
    @Override // com.obric.autogui.agents.vlm.models.impl.d
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r17, com.obric.autogui.common.a.k r18, com.obric.autogui.agents.vlm.models.c.b r19, boolean r20, d.c.d<? super JsonObject> r21) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        c r5 = r1;
        Object r2 = r5.f27294d;
        Object r8 = d.c.a.b.a();
        int r3 = r5.f;
        boolean r9 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.autogui.agents.vlm.models.c.b r4 = (com.obric.autogui.agents.vlm.models.c.b) ZeusTransformUtils.preCheckCast(r5.f27293c, com.obric.autogui.agents.vlm.models.c.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r6 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r5.f27292b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(r5.f27291a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        com.obric.autogui.agents.vlm.models.c.b r11 = r4;
        com.obric.autogui.agents.vlm.b.C0677b r10 = r6;
    L18:
        JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(r2, JsonObject.class, "com.obric.aiagent.plugin");
        String r13 = r11.a();
        Loog.INSTANCE.d("M-Std/UITars", " - [hyper-param] new step for stp/" + r13);
        List<com.obric.autogui.operator.e> r14 = r10.a().p();
        ?? r15 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(d.a.p.n(r14), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        z.f r16 = new z.f();
        if (ZeusTransformUtils.instanceOf(r15, g.class) == false) goto L21;
        r16.f38504a = r15;
    L22:
        int r22 = r14.size() - 1;
    L24:
        if ((-1) >= r22) goto L35;
        com.obric.autogui.operator.e r110 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r14.get(r22), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r110, g.class) == false) goto L34;
        if (ZeusTransformUtils.instanceOf(r110, com.obric.autogui.agents.vlm.models.a.e.class) == false) goto L31;
        Loog.INSTANCE.d("M-Std/UITars", " - [Make-HP] IndexStep: ignored `" + r110 + " (UnsolicitedStep)");
        goto L34
    L31:
        if (((g) ZeusTransformUtils.preCheckCast(r110, g.class, "com.obric.aiagent.plugin")).l() != (-1)) goto L33;
        Loog.INSTANCE.d("M-Std/UITars", " - [Make-HP] IndexStep: ignored `" + r110 + " (StepIndex-Unset)");
        goto L34
    L33:
        g r23 = (g) ZeusTransformUtils.preCheckCast(r110, g.class, "com.obric.aiagent.plugin");
    L37:
        if (r23 != null) goto L42;
        int r111 = r10.a().u();
        if (r111 == (-1)) goto L41;
        Loog.INSTANCE.d("M-Std/UITars", "[Make-HP] - stepId=" + r13 + ", stepIndex=" + r111 + " (using-session)");
    L43:
        Loog r24 = Loog.INSTANCE;
        StringBuilder r25 = new StringBuilder().append("[Make-HP] - stepId=").append(r13).append(", stepIndex=").append(r111).append(" (lastIdx=");
        if (r23 == null) goto L46;
        Integer r26 = d.c.b.a.b.a(r23.l());
    L47:
        r24.d("M-Std/UITars", r25.append(r26).append(')').toString());
        r12.addProperty("step_id", r13);
        r12.addProperty("step_index", (Number) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(r111), Number.class, "com.obric.aiagent.plugin"));
        r7.a(r10, r11, (g) ZeusTransformUtils.preCheckCast(r16.f38504a, g.class, "com.obric.aiagent.plugin"), r12);
        g r27 = (g) ZeusTransformUtils.preCheckCast(r16.f38504a, g.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L59;
        com.obric.autogui.operator.g r28 = r27.t();
        if (r28 == null) goto L59;
        r12.addProperty("exec_status_code", (Number) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(r28.d()), Number.class, "com.obric.aiagent.plugin"));
        String r29 = r28.c();
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.aiagent.plugin");
        if (r30 != null) goto L54;
    L57:
        if (r9 == true) goto L59;
        r12.addProperty("exec_result_message", r29);
        goto L59
    L54:
        if (d.o.o.d(r30) == true) goto L57;
        r9 = false;
    L59:
        Bundle r31 = r10.a().l().getTaskExtras();
        if (r31 == null) goto L62;
        String r32 = r31.getString("assistant_history");
    L63:
        if (r32 == null) goto L65;
        r12.addProperty("assistant_history", r32);
    L65:
        Bundle r33 = r10.a().l().getTaskExtras();
        if (r33 == null) goto L68;
        String r34 = r33.getString("assistant_meta");
    L69:
        if (r34 == null) goto L71;
        r12.addProperty("assistant_meta", r34);
    L71:
        Bundle r35 = r10.a().l().getTaskExtras();
        if (r35 == null) goto L74;
        String r112 = r35.getString("user_knowledge");
    L75:
        if (r112 == null) goto L77;
        r12.addProperty("user_knowledge", r112);
    L77:
        return r12;
    L74:
        r112 = null;
        goto L75
    L68:
        r34 = null;
        goto L69
    L62:
        r32 = null;
        goto L63
    L46:
        r26 = null;
        goto L47
    L41:
        Loog.INSTANCE.d("M-Std/UITars", "[Make-HP] - stepId=" + r13 + ", stepIndex=0 (last=null)");
        r111 = 0;
        goto L43
    L42:
        r111 = r23.l() + 1;
    L34:
        r22 = r22 - 1;
        goto L24
    L35:
        r23 = null;
        goto L37
    L21:
        Loog.INSTANCE.d("M-Std/UITars", " - [Make-HP] lastStep is: " + r15 + ", which is not qualified.");
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        r5.f27291a = this;
        r10 = r17;
        r5.f27292b = r10;
        r11 = r19;
        r5.f27293c = r11;
        r5.f = 1;
        r2 = super.a(r17, r18, r19, r20, r5);
        if (r2 != r8) goto L17;
        return r8;
    L17:
        r7 = this;
    L7:
        r1 = new c(this, r0);
        goto L8
    }

    private final void a(com.obric.autogui.agents.vlm.b.C0677b r8, com.obric.autogui.agents.vlm.models.c.b r9, g r10, JsonObject r11) {
        com.obric.autogui.agents.vlm.models.impl.b.h r12 = new com.obric.autogui.agents.vlm.models.impl.b.h(r8);
        com.obric.autogui.agents.vlm.models.impl.a.a r0 = d();
        if (r0 == null) goto L5;
        Collection<com.obric.autogui.agents.vlm.models.impl.a.a.C0684a> r1 = r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L6:
        if (r1 == null) goto L11;
        Loog.INSTANCE.d("M-Std/UITars", "[Make-HP] - added exec-statuses for " + r1.size() + " steps (from=" + d() + ").");
        Iterator<com.obric.autogui.agents.vlm.models.impl.a.a.C0684a> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        com.obric.autogui.agents.vlm.models.impl.a.a.C0684a r3 = (com.obric.autogui.agents.vlm.models.impl.a.a.C0684a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autogui.agents.vlm.models.impl.a.a.C0684a.class, "com.obric.aiagent.plugin");
        r12.a(r3.c(), r3.a(), r3.b());
    L11:
        com.obric.autogui.agents.vlm.models.impl.b.b[] r4 = this.f27289c;
        int r5 = r4.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        r4[r6].a(r8, r9, (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin"));
        r6 = r6 + 1;
        goto L12
    L14:
        String r7 = com.obric.autogui.util.c.f31500a.a(r8.a());
        if (r7 == null) goto L17;
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_task_system_hint_clipboard, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_system_hint_clipboard"), new Object[]{r7});
        d.h.b.o.c(r13, "getString(...)");
        r12.c(r13);
    L17:
        String r14 = com.obric.autogui.util.h.f31557a.a(r8.a());
        if (r14 == null) goto L21;
        r12.c(r14);
    L21:
        if (r9.j() == false) goto L23;
    L31:
        r12.a(r11);
        return;
    L23:
        if (g() == false) goto L31;
        if (f() == false) goto L31;
        if (h() == false) goto L29;
        String r15 = "当前网页为PC适配页面";
    L30:
        r12.c(r15);
        goto L31
    L29:
        r15 = "当前网页为手机适配页面";
        goto L30
    L5:
        r1 = null;
        goto L6
    }

    private final boolean f() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.terminate.browser_extra_msg.enable", true);
    }

    private final boolean g() {
        ComponentName r2 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r3 = r2.getPackageName();
    L7:
        return d.h.b.o.a(r3, "com.obric.browser");
    L5:
        r3 = null;
        goto L7
    }

    private final boolean h() {
        if (g() == true) goto L5;
        return false;
    L5:
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Boolean r2 = null;
        Bundle r10 = ZeusProviderTransform.call(r9.getContentResolver(), Uri.parse("content://com.obric.browser.webcapability"), "get_user_scalable", null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
    L10:
        if (r10 == null) goto L12;
        Boolean r3 = Boolean.valueOf(r10.getBoolean("success"));
    L13:
        if (r10 == null) goto L15;
        r2 = Boolean.valueOf(r10.getBoolean("user_scalable"));
    L15:
        ILogDepend.Companion.i("M-Std/UITars", "canBrowserUserCanScalable success=" + r3 + ", userScalable=" + r2);
        if (r2 != null) goto L18;
        return false;
    L18:
        return r2.booleanValue();
    L12:
        r3 = null;
    L8:
        e = move-exception;
        Loog.INSTANCE.e("M-Std/UITars", "getBrowserUserCanScalable failed, e=" + e);
        r10 = null;
        goto L10
    }
}
