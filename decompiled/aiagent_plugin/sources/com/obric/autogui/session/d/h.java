package com.obric.autogui.session.d;

import android.app.KeyguardManager;
import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: MainDisplayAsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.obric.autogui.session.d.a<ScreenshotResult> {
    private static final String TAG = "MainDisplayAsyncResource";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30900b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f30901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.session.d.c<ScreenshotResult> f30902d;

    /* JADX INFO: compiled from: MainDisplayAsyncResource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MainDisplayAsyncResource.kt */
    @d.c.b.a.f(b = "MainDisplayAsyncResource.kt", c = {54}, d = "invokeSuspend", e = "com.obric.autogui.session.preload.MainDisplayAsyncResource$acquireScreenshot$3")
    static final class b extends d.c.b.a.l implements d.h.a.b<d.c.d<? super ScreenshotResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.a.g f30904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f30905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ScreenshotConfig f30906d;

        b(com.obric.autogui.agents.vlm.models.a.g r3, h r4, ScreenshotConfig r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30904b = r3;
            this.f30905c = r4;
            this.f30906d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super ScreenshotResult> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30904b, this.f30905c, this.f30906d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super ScreenshotResult> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30903a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autogui.agents.vlm.models.a.g r8 = this.f30904b;
            String r2 = "pre_first_shot_" + h.a(this.f30905c).a();
            ScreenshotConfig r3 = this.f30906d;
            d.c.d<? super ScreenshotResult> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30903a = 1;
            r7 = r8.a(r2, r3, true, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MainDisplayAsyncResource.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<d.c.d<? super ScreenshotResult>, Object> {
        c(Object r8) {
            super(1, r8, h.class, "acquireScreenshot", "acquireScreenshot(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(d.c.d<? super ScreenshotResult> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return h.a((h) ZeusTransformUtils.preCheckCast(this.receiver, h.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super ScreenshotResult> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30900b = new a(null);
    }

    /* JADX INFO: renamed from: lambda$2FQh9A-d1G4KZS8BBpfnD5eDBCk, reason: not valid java name */
    public static /* synthetic */ x m885lambda$2FQh9Ad1G4KZS8BBpfnD5eDBCk(h r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$JR4vXu-cy5cZc7aoP4eqedwXGJU, reason: not valid java name */
    public static /* synthetic */ ScreenshotResult m886lambda$JR4vXucy5cZc7aoP4eqedwXGJU() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$SuPo-INVBNk7EVC2YZVziL7LNfQ, reason: not valid java name */
    public static /* synthetic */ boolean m887lambda$SuPoINVBNk7EVC2YZVziL7LNfQ(h r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$_sw2Nv096SDZ-xI4vHB1SemuMa0, reason: not valid java name */
    public static /* synthetic */ x m888lambda$_sw2Nv096SDZxI4vHB1SemuMa0(ScreenshotResult r0) {
        return a(r0);
    }

    public static final /* synthetic */ com.obric.autogui.session.a a(h r0) {
        return r0.f30901c;
    }

    public static final /* synthetic */ Object a(h r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public h(com.obric.autogui.session.a r9) {
        d.h.b.o.e(r9, SensitiveType.SESSION);
        super(null, 1, null);
        this.f30901c = r9;
        this.f30902d = new com.obric.autogui.session.d.c(TAG, (d.h.a.b) ZeusTransformUtils.preCheckCast((d.m.e) ZeusTransformUtils.preCheckCast(new c(this), d.m.e.class, "com.obric.aiagent.plugin"), d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$h$JR4vXucy5cZc7aoP4eqedwXGJU.INSTANCE, new $$Lambda$h$SuPoINVBNk7EVC2YZVziL7LNfQ(this), $$Lambda$h$_sw2Nv096SDZxI4vHB1SemuMa0.INSTANCE);
    }

    @Override // com.obric.autogui.session.d.a
    public com.obric.autogui.session.d.c<ScreenshotResult> a() {
        return this.f30902d;
    }

    private static final boolean b(h r1) {
        if (com.obric.autogui.common.a.d.f28974a.q() == true) goto L5;
    L9:
        return false;
    L5:
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.WmCaptureMainDisplay) == false) goto L9;
        if (r1.a("start") == false) goto L9;
        return true;
    }

    private static final ScreenshotResult g() {
        return new ScreenshotResult(ScreenshotResult.Status.ApiError, null, null, 0, null, null, 62, null);
    }

    private static final x a(ScreenshotResult r1) {
        d.h.b.o.e(r1, "result");
        IScreenshot r2 = r1.getPic();
        if (r2 == null) goto L6;
        r2.release();
    L6:
        return x.f38692a;
    }

    private final Object b(d.c.d<? super ScreenshotResult> r14) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30901c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L6;
        Loog.INSTANCE.i(TAG, "skip MainDisplay preload screenshot because keyguard locked");
        return null;
    L6:
        com.obric.autogui.agents.vlm.models.a.g r15 = new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30901c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0.5f);
        ScreenshotConfig r2 = new ScreenshotConfig(AssistantAbilityHelper.INSTANCE.getScreenshotExcludingPackages((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30901c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), 0.0f, f(), 2, null);
        return d.a(d.f30886a, null, new $$Lambda$h$2FQh9Ad1G4KZS8BBpfnD5eDBCk(this), (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r15, this, r2, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r6, 1, null);
    }

    private static final x c(h r1) {
        r1.b("capture");
        return x.f38692a;
    }

    private final boolean a(String r4) {
        boolean r0 = d.a(d.f30886a, null, 1, null);
        if (r0 == true) goto L5;
        b(r4);
    L5:
        return r0;
    }

    private final void b(String r3) {
        Loog.INSTANCE.i(TAG, "skip MainDisplay preload screenshot because AutoGUI execution consent is not granted, phase=" + r3);
    }

    private final ScreenshotConfig.HeifConfig f() {
        if (com.obric.autogui.common.a.d.f28974a.s() == true) goto L7;
        return null;
    L7:
        return new ScreenshotConfig.HeifConfig(com.obric.autogui.common.a.d.f28974a.t(), com.obric.autogui.common.a.d.f28974a.u());
    }

    private final boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L15
        h r3 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Object r6 = r5.getSystemService("keyguard");     // Catch: Throwable -> L15
        if (ZeusTransformUtils.instanceOf(r6, KeyguardManager.class) == false) goto L6;
        KeyguardManager r7 = (KeyguardManager) ZeusTransformUtils.preCheckCast(r6, KeyguardManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L7:
        boolean r8 = true;
        if (r7 != null) goto L10;
    L12:
        r8 = false;
    L13:
        Object r9 = n.f(Boolean.valueOf(r8));     // Catch: Throwable -> L15
    L18:
        if (n.b(r9) == false) goto L21;
        r9 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        if (r7.isKeyguardLocked() != true) goto L12;
    L6:
        r7 = null;
    L15:
        th = move-exception;
        n.a r10 = n.f38560a;
        r9 = n.f(o.a(th));
        goto L18
    }
}
