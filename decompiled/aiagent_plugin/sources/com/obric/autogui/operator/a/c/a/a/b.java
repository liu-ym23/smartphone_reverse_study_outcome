package com.obric.autogui.operator.a.c.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.common.api.AOImageUtil;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: OpClickPixelsChangedCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b extends com.obric.autogui.operator.a.c.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29748b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IScreenshot f29749a;

    /* JADX INFO: compiled from: OpClickPixelsChangedCheck.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpClickPixelsChangedCheck.kt */
    @f(b = "OpClickPixelsChangedCheck.kt", c = {242}, d = "checkPixelsChanged", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickPixelsChangedCheck")
    static final class C0771b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f29753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f29754e;
        /* synthetic */ Object f;
        final /* synthetic */ b g;
        int h;

        C0771b(b r3, d.c.d<? super C0771b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f = r7;
            this.h |= Integer.MIN_VALUE;
            return b.a(this.g, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpClickPixelsChangedCheck.kt */
    @f(b = "OpClickPixelsChangedCheck.kt", c = {136, 149}, d = "getCurrentStepScreenshotLazy", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickPixelsChangedCheck")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29759e;
        /* synthetic */ Object f;
        final /* synthetic */ b g;
        int h;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f = r7;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, 0.0f, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpClickPixelsChangedCheck.kt */
    @f(b = "OpClickPixelsChangedCheck.kt", c = {76, 98}, d = "perform$suspendImpl", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickPixelsChangedCheck")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f29764e;
        final /* synthetic */ b f;
        int g;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29764e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpClickPixelsChangedCheck.kt */
    @f(b = "OpClickPixelsChangedCheck.kt", c = {107}, d = "perform$suspendImpl", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickPixelsChangedCheck")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f29768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29769e;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29768d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29767c = r3;
            this.f29769e |= Integer.MIN_VALUE;
            return b.a(this.f29768d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29748b = new a(null);
    }

    /* JADX INFO: renamed from: lambda$9oroAU3C6-u1imuT21qgg2f2j6w, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.agents.a.d.c m838lambda$9oroAU3C6u1imuT21qgg2f2j6w(IScreenshot r0) {
        return a(r0);
    }

    public Object a(com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, com.obric.autogui.operator.a.b.b.a r5, d.c.d<? super com.obric.autogui.common.e> r6) {
        return a(this, r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(String r3, com.obric.autogui.operator.e r4, com.obric.autogui.operator.b.a r5, d.c.d<? super com.obric.autogui.common.e> r6) {
        return a(this, r3, r4, (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.c.a
    public String a() {
        return "OpClickPixelsChangedCheck";
    }

    public b() {
    }

    public static final /* synthetic */ Object a(b r6, String r7, com.obric.autogui.session.a r8, com.obric.autogui.operator.a.b.b.a r9, com.obric.autogui.operator.e r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public void a(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.a(r2);
        IScreenshot r3 = this.f29749a;
        if (r3 == null) goto L5;
        r3.release();
    L5:
        this.f29749a = null;
    }

    @Override // com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public void b(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.b(r2);
        IScreenshot r3 = this.f29749a;
        if (r3 == null) goto L5;
        r3.release();
    L5:
        this.f29749a = null;
    }

    static /* synthetic */ Object a(b r1, d.c.d<? super Boolean> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(AutoActionConfigs.INSTANCE.getBooleanCfg("operator.click.precheck_pixel", false));
    }

    static /* synthetic */ Object a(b r7, String r8, com.obric.autogui.operator.e r9, com.obric.autogui.operator.b.a r10, d.c.d<? super com.obric.autogui.common.e> r11) {
        com.obric.autogui.operator.b.a r12 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r13, d.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f29764e;
        Object r2 = d.c.a.b.a();
        int r3 = r0.g;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r14);
    L33:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r0.f29763d, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        r9 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r0.f29762c, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        r8 = (String) ZeusTransformUtils.preCheckCast(r0.f29761b, String.class, "com.obric.aiagent.plugin");
        r7 = (b) ZeusTransformUtils.preCheckCast(r0.f29760a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L19:
        com.obric.autogui.session.a r15 = com.obric.autogui.session.c.f30777a.b();
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.operator.a.b.b.a.class) == false) goto L22;
        com.obric.autogui.operator.a.b.b.a r16 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
    L24:
        if (r15 != null) goto L27;
        Loog.INSTANCE.e(r8, " - [" + r7.a() + "] ClickUI needs an ongoing session to be runnable.");
        r7.a("invalid_session", "session null");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L27:
        if (r16 != null) goto L30;
        Loog.INSTANCE.e(r8, " - [" + r7.a() + "] ClickUI needs a valid input");
        r7.a("invalid_input", "invalid input");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L30:
        r0.f29760a = null;
        r0.f29761b = null;
        r0.f29762c = null;
        r0.f29763d = null;
        r0.g = 2;
        r14 = r7.a(r15, r9, r16, r0);
        if (r14 != r2) goto L33;
        return r2;
    L22:
        r16 = null;
        goto L24
    L16:
        d.o.a(r14);
        r0.f29760a = r7;
        r0.f29761b = r8;
        r0.f29762c = r9;
        r0.f29763d = r12;
        r0.g = 1;
        if (super.a(r8, r9, r12, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new d(r7, r13);
        goto L8
    }

    static /* synthetic */ Object a(b r8, com.obric.autogui.session.a r9, com.obric.autogui.operator.e r10, com.obric.autogui.operator.a.b.b.a r11, d.c.d<? super com.obric.autogui.common.e> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.aiagent.plugin");
        if ((r0.f29769e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29769e -= Integer.MIN_VALUE;
    L8:
        e r7 = r0;
        Object r14 = r7.f29767c;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f29769e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r11 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r7.f29766b, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
        r8 = (b) ZeusTransformUtils.preCheckCast(r7.f29765a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L17:
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r15.g() == true) goto L29;
        Loog.INSTANCE.w(r8.b(), " - [" + r8.a() + "] ClickUI ignored clicking (pixels_changed)");
        StringBuilder r16 = new StringBuilder().append("x=");
        com.obric.autogui.operator.a.a.f r17 = r11.b().a();
        Float r3 = null;
        if (r17 == null) goto L22;
        Float r18 = d.c.b.a.b.a(r17.a());
    L23:
        StringBuilder r19 = r16.append(r18).append(", y=");
        com.obric.autogui.operator.a.a.f r110 = r11.b().a();
        if (r110 == null) goto L26;
        r3 = d.c.b.a.b.a(r110.b());
    L26:
        r8.a("pixel_changed", r19.append(r3).toString());
        return r15;
    L22:
        r18 = null;
        goto L23
    L29:
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        String r111 = r8.b();
        r7.f29765a = r8;
        r7.f29766b = r11;
        r7.f29769e = 1;
        r14 = r8.a(r111, r9, r11, r10, r7);
        if (r14 != r1) goto L17;
        return r1;
    L7:
        r0 = new e(r8, r13);
        goto L8
    }

    public final Object a(String r22, com.obric.autogui.session.a r23, com.obric.autogui.operator.e r24, float r25, d.c.d<? super IScreenshot> r26) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r6.h & Integer.MIN_VALUE) == 0) goto L7;
        r6.h -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f;
        Object r15 = d.c.a.b.a();
        int r7 = r6.h;
        com.obric.autogui.agents.a.d.c r16 = null;
        boolean r17 = false;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 != 2) goto L20;
        IScreenshot r1 = (IScreenshot) ZeusTransformUtils.preCheckCast(r6.f29759e, IScreenshot.class, "com.obric.aiagent.plugin");
        ScreenshotResult r2 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r6.f29758d, ScreenshotResult.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r8 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6.f29757c, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.f29756b, String.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r6.f29755a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Exception -> L15 CancellationException -> L17
        String r10 = "[OAutoActionEffect] - [";
    L67:
        r16 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L17 Exception -> L54
    L59:
        com.obric.autogui.operator.e r11 = r8;
        ScreenshotResult r12 = r2;
        String r20 = r9;
        final IScreenshot r13 = r1;
        b r14 = r3;
        String r18 = r20;
    L60:
        com.obric.autogui.agents.a.d.c r19 = r16;
        if (r19 == null) goto L64;
        ((g) ZeusTransformUtils.preCheckCast(r11, g.class, "com.obric.aiagent.plugin")).a(new com.obric.autogui.agents.vlm.models.impl.b(r19, r12.getTopComponent(), AOSystemTools.INSTANCE.nowTimeMillis(), 1000));
        Loog.INSTANCE.d(r18, r10 + r14.a() + "] cached image fingerprint for pre-execution reuse");
    L64:
        return r13;
    L54:
        e = e;
    L58:
        Loog.INSTANCE.w(r9, r10 + r3.a() + "] failed to cache pre-execution image fingerprint, error_type=" + e.getClass().getSimpleName());
    L15:
        e = e;
        r10 = "[OAutoActionEffect] - [";
        goto L58
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        com.obric.autogui.operator.e r0 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6.f29757c, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r6.f29756b, String.class, "com.obric.aiagent.plugin");
        b r27 = (b) ZeusTransformUtils.preCheckCast(r6.f29755a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r18 = r21;
        r14 = r27;
        r11 = r0;
        Object r28 = r5;
    L36:
        r12 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r28, ScreenshotResult.class, "com.obric.aiagent.plugin");
        r13 = r12.getPic();
        r14.f29749a = r13;
        if (r13 == null) goto L64;
        if (ZeusTransformUtils.instanceOf(r11, g.class) == false) goto L64;
        if (r12.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L43;
    L44:
        r17 = true;
    L45:
        if (r17 == false) goto L47;
        r10 = "[OAutoActionEffect] - [";
        Loog.INSTANCE.d(r18, r10 + r14.a() + "] skip pre-execution image fingerprint on secure screenshot");
        goto L60
    L47:
        r10 = r13;
        d.h.a.a r29 = new $$Lambda$b$9oroAU3C6u1imuT21qgg2f2j6w(r13);     // Catch: CancellationException -> L17 Exception -> L56
        r6.f29755a = r14;     // Catch: CancellationException -> L17 Exception -> L56
        r6.f29756b = r18;     // Catch: CancellationException -> L17 Exception -> L56
        r6.f29757c = r11;     // Catch: CancellationException -> L17 Exception -> L56
        r6.f29758d = r12;     // Catch: CancellationException -> L17 Exception -> L56
        r6.f29759e = r13;     // Catch: CancellationException -> L17 Exception -> L56
        r6.h = 2;     // Catch: CancellationException -> L17 Exception -> L56
        Object r30 = r13.withResourcesLocked(r29, r6);     // Catch: CancellationException -> L17 Exception -> L56
        if (r30 != r15) goto L51;
        return r15;
    L51:
        r2 = r12;
        r8 = r11;
        r5 = r30;
        String r210 = r18;
        r3 = r14;
        r1 = r13;
        r9 = r210;
    L56:
        e = e;
        r2 = r12;
        r8 = r11;
        String r211 = r18;
        r3 = r14;
        r1 = r13;
        r9 = r211;
        goto L58
    L43:
        if ((r12.getFlags() & 1) == 0) goto L45;
    L22:
        d.o.a(r5);
        IScreenshot r31 = this.f29749a;
        if (r31 != null) goto L25;
    L30:
        if (r31 == null) goto L32;
        r31.release();
    L32:
        Loog.INSTANCE.d(r22, "Recording new screenshot for ClickUI at Step-#" + r23.s());
        com.obric.autogui.agents.vlm.models.a.a r32 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r25), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        r6.f29755a = this;
        r6.f29756b = r22;
        r11 = r24;
        r6.f29757c = r11;
        r6.h = 1;
        Object r33 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r32, "ClickUI-Screenshot", null, false, false, r6, 14, null);
        if (r33 != r15) goto L35;
        return r15;
    L35:
        r14 = this;
        r28 = r33;
        r18 = r22;
        goto L36
    L25:
        if (r31.getScale() != r25) goto L27;
        boolean r34 = true;
    L28:
        if (r34 == false) goto L30;
        return r31;
    L27:
        r34 = false;
    L17:
        e = move-exception;
        throw e;
    L7:
        r6 = new c(this, r4);
        goto L8
    }

    private static final com.obric.autogui.agents.a.d.c a(IScreenshot r2) {
        Bitmap r3 = ((IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin")).getBitmap();
        return com.obric.autogui.agents.a.d.d.f26364a.a(r3);
    }

    public final boolean a(PointF r1, int r2, Bitmap r3, Bitmap r4) {
        o.e(r1, "atPoint");
        return AOImageUtil.INSTANCE.isSameBitmapInPointArea(r4, r3, r1, r2);
    }

    private final Object a(String r23, com.obric.autogui.session.a r24, com.obric.autogui.operator.a.b.b.a r25, com.obric.autogui.operator.e r26, d.c.d<? super com.obric.autogui.common.e> r27) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C0771b.class) == false) goto L7;
        C0771b r1 = (C0771b) ZeusTransformUtils.preCheckCast(r0, C0771b.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        C0771b r5 = r1;
        Object r2 = r5.f;
        Object r9 = d.c.a.b.a();
        int r3 = r5.h;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        float r4 = r5.f29754e;
        float r6 = r5.f29753d;
        IScreenshot r7 = (IScreenshot) ZeusTransformUtils.preCheckCast(r5.f29752c, IScreenshot.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.f29751b, String.class, "com.obric.aiagent.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r5.f29750a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L58:
        IScreenshot r11 = (IScreenshot) ZeusTransformUtils.preCheckCast(r2, IScreenshot.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L63;
        Loog.INSTANCE.d(r8, " - [" + r10.a() + "] ClickJudge, skipped PixelsChanged judge (no current-screenshot)");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_click_ignored_by_screenshot_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_click_ignored_by_screenshot_changed"), null, 2, null), "ignore_clicking_not_fetchable", "x=" + r6 + ", y=" + r4, false, null, 0, 24, null);
    L63:
        if ((!r10.a(new PointF(r6, r4), 4, r7.getBitmap(), r11.getBitmap())) == false) goto L66;
        Loog.INSTANCE.i(r8, " - [" + r10.a() + "] ClickJudge, skip click operation because of screenshot changed, x=" + r6 + ", y=" + r4);
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_click_ignored_by_screenshot_changed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_click_ignored_by_screenshot_changed"), null, 2, null), "ignore_clicking_redrawn", "x=" + r6 + ", y=" + r4, false, null, 0, 24, null);
    L66:
        Loog.INSTANCE.d(r8, " - [" + r10.a() + "] ClickJudge, screenshot is same, location: " + r6 + ", " + r4);
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        List<com.obric.autogui.operator.e> r12 = r24.p();
        Loog.INSTANCE.d(r23, " - [" + a() + "] ClickJudge-Pixel, start (AsConfigured), sessionId: " + r24.b() + ", history size: " + r12.size());
        boolean r13 = false;
        int r14 = Math.max(0, r12.size() - 3);
        int r15 = r12.size() - 1;
        if (r14 > r15) goto L34;
    L16:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r12.get(r15), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L19;
    L21:
        Iterator r17 = r16.iterator();
    L23:
        if (r17.hasNext() == false) goto L20;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == false) goto L23;
        boolean r19 = true;
    L30:
        if (r19 == true) goto L31;
        if (r15 == r14) goto L34;
        r15 = r15 - 1;
        goto L16
    L31:
        r13 = true;
        goto L34
    L27:
        r18 = false;
    L20:
        r19 = false;
        goto L30
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L21;
    L34:
        if (r13 == true) goto L38;
        Loog.INSTANCE.d(r23, " - [" + a() + "] ClickJudge, no open_app operation in recent history, proceed clicking.");
        return com.obric.autogui.common.e.f29014b.a();
    L38:
        if (ZeusTransformUtils.instanceOf(r26, g.class) == false) goto L40;
        com.obric.autogui.agents.vlm.models.a.a.b r20 = ((g) ZeusTransformUtils.preCheckCast(r26, g.class, "com.obric.aiagent.plugin")).n();
    L41:
        if (r20 == null) goto L43;
        IScreenshot r110 = r20.a();
    L44:
        if (r110 != null) goto L47;
        Loog.INSTANCE.d(r23, " - [" + a() + "] ClickJudge, skipped PixelsChanged judge (no screenshot)");
        return com.obric.autogui.common.e.f29014b.a();
    L47:
        com.obric.autogui.operator.a.a.f r21 = r25.b().a();
        float r22 = 0.0f;
        if (r21 == null) goto L50;
        float r28 = r21.a();
    L51:
        float r111 = r28 * r110.getScale();
        com.obric.autogui.operator.a.a.f r29 = r25.b().a();
        if (r29 == null) goto L54;
        r22 = r29.b();
    L54:
        float r112 = r22 * r110.getScale();
        float r30 = r110.getScale();
        r5.f29750a = this;
        r5.f29751b = r23;
        r5.f29752c = r110;
        r5.f29753d = r111;
        r5.f29754e = r112;
        r5.h = 1;
        r2 = a(r23, r24, r26, r30, r5);
        if (r2 != r9) goto L57;
        return r9;
    L57:
        r10 = this;
        r8 = r23;
        r7 = r110;
        r6 = r111;
        r4 = r112;
        goto L58
    L50:
        r28 = 0.0f;
        goto L51
    L43:
        r110 = null;
        goto L44
    L40:
        r20 = null;
    L7:
        r1 = new C0771b(this, r0);
        goto L8
    }
}
