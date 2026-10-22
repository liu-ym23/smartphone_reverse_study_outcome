package com.obric.autogui.operator.a.c.a.a;

import android.content.ComponentName;
import android.graphics.PointF;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingToolsKt;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.operator.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.au;
import org.json.JSONObject;

/* JADX INFO: compiled from: OpClickBetweenStepsCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.operator.a.c.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0770a f29734a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29737e;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.c.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpClickBetweenStepsCheck.kt */
    public static final class C0770a {
        public /* synthetic */ C0770a(h r1) {
            this();
        }

        private C0770a() {
        }
    }

    /* JADX INFO: compiled from: OpClickBetweenStepsCheck.kt */
    @f(b = "OpClickBetweenStepsCheck.kt", c = {121, 176}, d = "checkChangedBetweenSteps", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickBetweenStepsCheck")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29742e;
        Object f;
        Object g;
        Object h;
        /* synthetic */ Object i;
        final /* synthetic */ a j;
        int k;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return a.a(this.j, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpClickBetweenStepsCheck.kt */
    @f(b = "OpClickBetweenStepsCheck.kt", c = {67}, d = "perform", e = "com.obric.autogui.operator.impl.precheck.impl.click.OpClickBetweenStepsCheck")
    static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f29746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29747e;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29746d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29745c = r3;
            this.f29747e |= Integer.MIN_VALUE;
            return this.f29746d.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29734a = new C0770a(null);
    }

    @Override // com.obric.autogui.operator.a.c.a.a.b, com.obric.autogui.operator.a.c.a
    public String a() {
        return "OpClickBetweenStepsCheck";
    }

    public a() {
    }

    public static final /* synthetic */ Object a(a r6, String r7, com.obric.autogui.session.a r8, com.obric.autogui.operator.a.b.b.a r9, e r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.c.a.a.b, com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public void a(e r2) {
        o.e(r2, "step");
        super.a(r2);
        this.f29736d = r2.N();
        this.f29737e = r2.P();
        this.f29735c = r2.O();
    }

    @Override // com.obric.autogui.operator.a.c.a.a.b, com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public void b(e r2) {
        o.e(r2, "step");
        super.b(r2);
        this.f29736d = 0;
        this.f29737e = 0;
        this.f29735c = 0;
    }

    @Override // com.obric.autogui.operator.a.c.a.a.b, com.obric.autogui.operator.a.c.c, com.obric.autogui.operator.a.c.a
    public Object a(d.c.d<? super Boolean> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(true);
    }

    @Override // com.obric.autogui.operator.a.c.a.a.b
    public Object a(com.obric.autogui.session.a r9, e r10, com.obric.autogui.operator.a.b.b.a r11, d.c.d<? super com.obric.autogui.common.e> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r13, c.class, "com.obric.aiagent.plugin");
        if ((r0.f29747e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29747e -= Integer.MIN_VALUE;
    L8:
        c r7 = r0;
        Object r14 = r7.f29745c;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f29747e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r11 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r7.f29744b, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r7.f29743a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L17:
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r15.g() == true) goto L29;
        Loog.INSTANCE.w(this.b(), " - [" + this.a() + "] ClickUI ignored clicking (pixels_changed_multi_action)");
        AutoActionAgent.INSTANCE.stopPredicting();
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
        this.a("multi_step_pixel_changed", r19.append(r3).append(", multiStepId=").append(this.f29737e).append(", multiStepIndex=").append(this.f29736d).append(", multiStepSize=").append(this.f29735c).toString());
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
        String r111 = b();
        r7.f29743a = this;
        r7.f29744b = r11;
        r7.f29747e = 1;
        r14 = a(r111, r9, r11, r10, r7);
        if (r14 != r1) goto L17;
        return r1;
    L7:
        r0 = new c(this, r13);
        goto L8
    }

    private final Object a(String r28, com.obric.autogui.session.a r29, com.obric.autogui.operator.a.b.b.a r30, e r31, d.c.d<? super com.obric.autogui.common.e> r32) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if ((r5.k & Integer.MIN_VALUE) == 0) goto L7;
        r5.k -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.i;
        Object r6 = d.c.a.b.a();
        int r7 = r5.k;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        IScreenshot r0 = (IScreenshot) ZeusTransformUtils.preCheckCast(r5.f, IScreenshot.class, "com.obric.aiagent.plugin");
        e r2 = (e) ZeusTransformUtils.preCheckCast(r5.f29742e, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.a r8 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r5.f29741d, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r9 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f29740c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r5.f29739b, String.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r5.f29738a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        Object r11 = r4;
        String r13 = "agent_action_click_ignored_by_screenshot_changed";
        r30 = r8;
        String r14 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
    L78:
        IScreenshot r15 = (IScreenshot) ZeusTransformUtils.preCheckCast(r11, IScreenshot.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L82;
        Loog.INSTANCE.d(r12, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, skipped PixelsChanged judge (no-screenshot)");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_click_ignored_by_screenshot_changed, r14, r13), null, 2, null), "ignore_clicking_redrawn_multi_action", "no-curr-step", false, null, 0, 24, null);
    L82:
        Loog.INSTANCE.d(r12, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, start, sessionId: " + r9.b() + ", lastStep=" + r2);
        com.obric.autogui.operator.a.a.f r1 = r30.b().a();
        float r16 = 0.0f;
        if (r1 == null) goto L85;
        float r17 = r1.a();
    L86:
        float r18 = r17 * r15.getScale();
        com.obric.autogui.operator.a.a.f r19 = r30.b().a();
        if (r19 == null) goto L89;
        r16 = r19.b();
    L89:
        float r20 = r16 * r15.getScale();
        if ((!r10.a(new PointF(r18, r20), 4, r0.getBitmap(), r15.getBitmap())) == false) goto L93;
        Loog.INSTANCE.i(r12, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, skip click operation because of screenshot changed, x=" + r18 + ", y=" + r20);
        ComponentName r21 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        IAutoActionTrackingApi r110 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r22 = new JSONObject();
        r22.put("exception_type", "ignore_clicking_redrawn_multi_action_pixel_changed");
        r22.put("debug_info", String.valueOf(r21));
        x r23 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r110, "technical_bad_case", r22, false, false, null, 28, null);
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_click_ignored_by_screenshot_changed, r14, r13), null, 2, null), "ignore_clicking_redrawn_multi_action", "changed", false, null, 0, 24, null);
    L93:
        Loog.INSTANCE.d(r12, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, screenshot is same, location: " + r18 + ", " + r20);
        return com.obric.autogui.common.e.f29014b.a();
    L85:
        r17 = 0.0f;
        goto L86
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.agents.vlm.models.a.a.b r24 = (com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r5.h, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin");
        r2 = (e) ZeusTransformUtils.preCheckCast(r5.g, e.class, "com.obric.aiagent.plugin");
        List<e> r25 = (List) ZeusTransformUtils.preCheckCast(r5.f, List.class, "com.obric.aiagent.plugin");
        r31 = (e) ZeusTransformUtils.preCheckCast(r5.f29742e, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.a r111 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r5.f29741d, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r26 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f29740c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r5.f29739b, String.class, "com.obric.aiagent.plugin");
        r10 = (a) ZeusTransformUtils.preCheckCast(r5.f29738a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        List<e> r112 = r25;
        String r113 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r30 = r111;
        Object r33 = r4;
        String r114 = "agent_action_click_ignored_by_screenshot_changed";
        com.obric.autogui.agents.vlm.models.a.a.b r34 = r24;
        r29 = r26;
        String r210 = r27;
    L36:
        com.obric.autogui.agents.vlm.models.a.a.b r35 = (com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r33, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin");
        List<e> r36 = r112;
        com.obric.autogui.agents.vlm.models.a.a.b r115 = r34;
        com.obric.autogui.agents.vlm.models.a.a.b r37 = r35;
        r28 = r210;
    L40:
        if (r115 == null) goto L42;
        ComponentName r116 = r115.b();
    L43:
        if (r116 == null) goto L53;
        if (r37 == null) goto L46;
        ComponentName r117 = r37.b();
    L47:
        if (r117 == null) goto L53;
        String r38 = r114;
        String r118 = r113;
        Loog.INSTANCE.d(r28, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, activity-changed-check,l=" + r115.b() + ", t=" + r37.b());
        if (o.a(r115.b(), r37.b()) == true) goto L52;
        Loog.INSTANCE.d(r28, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, skipped PixelsChanged judge (activity-changed)");
        IAutoActionTrackingApi r119 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r39 = new JSONObject();
        r39.put("exception_type", "ignore_clicking_redrawn_multi_action_activity_changed");
        r39.put("debug_info", String.valueOf(r37.b()));
        x r40 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r119, "technical_bad_case", r39, false, false, null, 28, null);
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_click_ignored_by_screenshot_changed, r118, r38), null, 2, null), "ignore_clicking_redrawn_multi_action", "activity-changed", false, null, 0, 24, null);
    L52:
        r13 = r38;
        r14 = r118;
    L54:
        Iterator r41 = p.h(r36).iterator();
    L56:
        if (r41.hasNext() == false) goto L65;
        e r120 = (e) ZeusTransformUtils.preCheckCast(r41.next(), e.class, "com.obric.aiagent.plugin");
        Iterator r211 = r41;
        if (r120.P() != r10.f29737e) goto L64;
        if (r120.N() != 0) goto L64;
        if (ZeusTransformUtils.instanceOf(r120, g.class) == false) goto L64;
        g r42 = (g) ZeusTransformUtils.preCheckCast(r120, g.class, "com.obric.aiagent.plugin");
    L66:
        if (r42 == null) goto L70;
        com.obric.autogui.agents.vlm.models.a.a.b r43 = r42.n();
        if (r43 == null) goto L70;
        IScreenshot r44 = r43.a();
    L71:
        if (r44 != null) goto L74;
        Loog.INSTANCE.d(r28, " - [" + r10.a() + "] ClickJudge-Pixel-Steps, skipped PixelsChanged judge (no last step screenshot)");
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_action_click_ignored_by_screenshot_changed, r14, r13), null, 2, null), "ignore_clicking_redrawn_multi_action", "no-last-step", false, null, 0, 24, null);
    L74:
        float r121 = r44.getScale();
        r5.f29738a = r10;
        r5.f29739b = r28;
        r5.f29740c = r29;
        r5.f29741d = r30;
        r5.f29742e = r2;
        r5.f = r44;
        r5.g = null;
        r5.h = null;
        r5.k = 2;
        r11 = r10.a(r28, r29, r31, r121, r5);
        if (r11 != r6) goto L77;
        return r6;
    L77:
        r12 = r28;
        r0 = r44;
        r9 = r29;
    L70:
        r44 = null;
    L64:
        r41 = r211;
        goto L56
    L65:
        r42 = null;
        goto L66
    L46:
        r117 = null;
    L53:
        r13 = r114;
        r14 = r113;
        goto L54
    L42:
        r116 = null;
        goto L43
    L16:
        d.o.a(r4);
        if (this.f29735c >= 2) goto L21;
        Loog.INSTANCE.d(r28, " - [" + a() + "] ClickJudge-Pixel-Steps, skipped PixelsChanged judge (not-multi-step)");
        return com.obric.autogui.common.e.f29014b.a();
    L21:
        if (this.f29736d >= 1) goto L24;
        Loog.INSTANCE.d(r28, " - [" + a() + "] ClickJudge-Pixel-Steps, skipped PixelsChanged judge (not-first)");
        return com.obric.autogui.common.e.f29014b.a();
    L24:
        r36 = r29.p();
        r2 = (e) ZeusTransformUtils.preCheckCast(p.n(r36), e.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L29;
        Loog.INSTANCE.d(r28, " - [" + a() + "] ClickJudge-Pixel-Steps, skipped PixelsChanged judge (no last step)");
        return com.obric.autogui.common.e.f29014b.a();
    L29:
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L38;
        r34 = ((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).n();
        au<com.obric.autogui.agents.vlm.models.a.a.b> r122 = ((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).p();
        r114 = "agent_action_click_ignored_by_screenshot_changed";
        r113 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        if (r122 == null) goto L37;
        r5.f29738a = this;
        r5.f29739b = r28;
        r29 = r29;
        r5.f29740c = r29;
        r30 = r30;
        r5.f29741d = r30;
        r5.f29742e = r31;
        r5.f = r36;
        r5.g = r2;
        r5.h = r34;
        r5.k = 1;
        Object r45 = AOThreadingToolsKt.awaitOrNull(r122, WsConstants.EXIT_DELAY_TIME, r5);
        if (r45 != r6) goto L35;
        return r6;
    L35:
        r31 = r31;
        r2 = r2;
        r112 = r36;
        r10 = this;
        r210 = r28;
        r33 = r45;
        goto L36
    L37:
        r115 = r34;
        r37 = null;
    L39:
        r10 = this;
        goto L40
    L38:
        r114 = "agent_action_click_ignored_by_screenshot_changed";
        r113 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r37 = null;
        r115 = null;
    L7:
        r5 = new b(this, r3);
        goto L8
    }
}
