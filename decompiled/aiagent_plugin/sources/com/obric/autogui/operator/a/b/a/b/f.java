package com.obric.autogui.operator.a.b.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.LauncherApps;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.packages.StartActivityPosition;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.k;
import d.h.a.m;
import d.h.b.h;
import d.n.j;
import d.n.l;
import d.o;
import d.s;
import d.x;

/* JADX INFO: compiled from: ShortcutOpener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.obric.autogui.operator.a.b.a.b.b implements com.obric.autogui.operator.a.b.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f29507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f29508e;

    /* JADX INFO: compiled from: ShortcutOpener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ShortcutOpener.kt */
    @d.c.b.a.f(b = "ShortcutOpener.kt", c = {95}, d = "doOpenAfterPreCheck", e = "com.obric.autogui.operator.impl.op.openapp.opener.ShortcutOpener")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f29512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29513e;

        b(f r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29512d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29511c = r3;
            this.f29513e |= Integer.MIN_VALUE;
            return this.f29512d.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortcutOpener.kt */
    @d.c.b.a.f(b = "ShortcutOpener.kt", c = {151}, d = "maybeKillApp", e = "com.obric.autogui.operator.impl.op.openapp.opener.ShortcutOpener")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f29516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29517d;

        c(f r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29516c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29515b = r3;
            this.f29517d |= Integer.MIN_VALUE;
            return this.f29516c.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortcutOpener.kt */
    @d.c.b.a.f(b = "ShortcutOpener.kt", c = {50, 56}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.opener.ShortcutOpener$providePreChecks$1")
    static final class d extends k implements m<l<? super com.obric.autogui.operator.a.b.a.b.b.b>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f29519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f29520c;

        d(f r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29519b = r3;
            super(2, r5);
        }

        public final Object a(l<? super com.obric.autogui.operator.a.b.a.b.b.b> r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f29519b, r5);
            r0.f29520c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(l<? super com.obric.autogui.operator.a.b.a.b.b.b> r3, d.c.d<? super x> r4) {
            return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29518a;
            ComponentName r3 = null;
            Object[] r4 = 0;
            int r5 = 1;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r8);
        L19:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            l r2 = (l) ZeusTransformUtils.preCheckCast(this.f29520c, l.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L15:
            com.obric.autogui.operator.a.b.a.b.b.d r9 = new com.obric.autogui.operator.a.b.a.b.b.d(this.f29519b.b(), this.f29519b.d());
            d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29520c = null;
            this.f29518a = 2;
            if (r2.a(r9, r6) != r0) goto L19;
            return r0;
        L10:
            o.a(r8);
            r2 = (l) ZeusTransformUtils.preCheckCast(this.f29520c, l.class, "com.obric.aiagent.plugin");
            if (this.f29519b.e() == null) goto L15;
            com.obric.autogui.operator.a.b.a.b.b.c r10 = new com.obric.autogui.operator.a.b.a.b.b.c(r3, this.f29519b.e(), r5, r4 == true ? 1 : 0);
            d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29520c = r2;
            this.f29518a = 1;
            if (r2.a(r10, r7) != r0) goto L15;
            return r0;
        }
    }

    static {
        f29504a = new a(null);
    }

    public /* synthetic */ f(String r2, String r3, String r4, String r5, int r6, h r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public final String c() {
        return this.f29506c;
    }

    public final String d() {
        return this.f29507d;
    }

    public final String e() {
        return this.f29508e;
    }

    public f(String r2, String r3, String r4, String r5) {
        d.h.b.o.e(r2, "shortcutId");
        d.h.b.o.e(r3, "appPackage");
        this.f29505b = r2;
        this.f29506c = r3;
        this.f29507d = r4;
        this.f29508e = r5;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b
    public j<com.obric.autogui.operator.a.b.a.b.b.b> a() {
        return d.n.m.a((m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b
    public Object c(Context r36, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r37) {
        f r1 = this;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if ((r4.f29513e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f29513e -= Integer.MIN_VALUE;
    L8:
        Object r2 = r4.f29511c;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f29513e;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        r3 = (Context) ZeusTransformUtils.preCheckCast(r4.f29510b, Context.class, "com.obric.aiagent.plugin");
        r1 = (f) ZeusTransformUtils.preCheckCast(r4.f29509a, f.class, "com.obric.aiagent.plugin");
        o.a(r2);     // Catch: Throwable -> L14
    L35:
        Loog.INSTANCE.d("Op-OpenApp/ShortcutOpener", " - [ShortcutOpener] package open status: " + ((com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
    L36:
        StartActivityResult r7 = AOPackagesTools.INSTANCE.startShortcut(r3, r1.f29506c, r1.f29505b, StartActivityPosition.ActiveOperatingSpace);     // Catch: Throwable -> L14
        Loog.INSTANCE.e("Op-OpenApp/ShortcutOpener", " - [ShortcutOpener] Start shortcut `" + r1.f29505b + "` for package `" + r1.f29506c + "`: " + r7);     // Catch: Throwable -> L14
        if (r7.getOk() == true) goto L41;
        com.obric.autogui.operator.a.b.a.b r16 = com.obric.autogui.operator.a.b.a.b.l;     // Catch: Throwable -> L14
        String r8 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_not_openable_general, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_not_openable_general"));     // Catch: Throwable -> L14
        d.h.b.o.c(r8, "getString(...)");     // Catch: Throwable -> L14
        return new com.obric.autogui.operator.a.b.a.c(r16, r8, "shortcut,appName=" + r1.f29507d + ",p=" + r1.f29506c, com.obric.autogui.common.a.b.f28964b, r1.f29506c, false, null, 96, null);
    L41:
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.p, null, "shortcut,a=" + r1.f29507d + ",p=" + r1.f29506c, null, r1.b(), false, null, 106, null);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r2);
        LauncherApps r9 = (LauncherApps) ZeusTransformUtils.preCheckCast(r3.getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
    L23:
        if (r9 != null) goto L26;
        Loog.INSTANCE.w("Op-OpenApp/ShortcutOpener", " - [ShortcutOpener] LauncherApps service is not available.");
        com.obric.autogui.operator.a.b.a.b r17 = com.obric.autogui.operator.a.b.a.b.f29446b;
        String r10 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_task_user_interrupt_open_app_internal, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_interrupt_open_app_internal"));
        d.h.b.o.c(r10, "getString(...)");
        return new com.obric.autogui.operator.a.b.a.c(r17, r10, "shortcut,appName=" + r1.f29507d + ",p=" + r1.f29506c, com.obric.autogui.common.a.b.f28964b, r1.f29506c, false, null, 96, null);
    L26:
        IAutoActionPresentationApi r11 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r11 == null) goto L29;
        IAutoActionPresentationApi.PlayerVisibility r12 = r11.getPlayerVisibility(r3);     // Catch: Throwable -> L14
    L31:
        if (r12 != IAutoActionPresentationApi.PlayerVisibility.Invisible) goto L36;
        e r13 = new e(r3, r1.f29506c);     // Catch: Throwable -> L14
        r4.f29509a = r1;     // Catch: Throwable -> L14
        r4.f29510b = r3;     // Catch: Throwable -> L14
        r4.f29513e = 1;     // Catch: Throwable -> L14
        r2 = r13.a(r3, r4);     // Catch: Throwable -> L14
        if (r2 != r5) goto L35;
        return r5;
    L29:
        r12 = null;
    L21:
        th = move-exception;
        Loog.INSTANCE.w("Op-OpenApp/ShortcutOpener", " - [ShortcutOpener] Failed to get LauncherApps service.", th);
        r9 = null;
    L14:
        th = move-exception;
        Loog.INSTANCE.e("Op-OpenApp/ShortcutOpener", " - [ShortcutOpener] Failed to start shortcut `" + r1.f29505b + "` for package `" + r1.f29506c + "`.", th);
        com.obric.autogui.operator.a.b.a.b r18 = com.obric.autogui.operator.a.b.a.b.l;
        String r14 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_not_openable_general, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_not_openable_general"));
        d.h.b.o.c(r14, "getString(...)");
        return new com.obric.autogui.operator.a.b.a.c(r18, r14, "shortcut,appName=" + r1.f29507d + ",p=" + r1.f29506c, com.obric.autogui.common.a.b.f28964b, r1.f29506c, false, null, 96, null);
    L7:
        r4 = new b(r1, r0);
        goto L8
    }

    @Override // com.obric.autogui.operator.a.b.a.b.c
    public String b() {
        return this.f29506c;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.a
    public Object b(Context r11, d.c.d<? super d.m<Boolean, String>> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, c.class) == false) goto L7;
        c r15 = (c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.aiagent.plugin");
        if ((r15.f29517d & Integer.MIN_VALUE) == 0) goto L7;
        r15.f29517d -= Integer.MIN_VALUE;
    L8:
        c r7 = r15;
        Object r16 = r7.f29515b;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f29517d;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        f this = (f) ZeusTransformUtils.preCheckCast(r7.f29514a, f.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L18:
        return s.a(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()), this.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        IAutoActionPackagesApi r18 = AOPlatformTools.INSTANCE.packages();
        String r3 = b();
        r7.f29514a = this;
        r7.f29517d = 1;
        r16 = IAutoActionPackagesApi.DefaultImpls.killAppAndDelay$default(r18, r3, false, 0, r7, 4, null);
        if (r16 != r17) goto L18;
        return r17;
    L7:
        r15 = new c(this, r14);
        goto L8
    }
}
