package com.obric.autogui.operator.a.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OpDeviceAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autogui.operator.a.b {
    private static final String TAG = "Op-DeviceAct";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29634b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.a.g f29635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0765c f29636d;

    /* JADX INFO: compiled from: OpDeviceAction.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OpDeviceAction.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29637a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f29638b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f29639c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f29640d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f29641e = null;
        private static final /* synthetic */ b[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final int f;

        private static final /* synthetic */ b[] b() {
            return new b[]{f29637a, f29638b, f29639c, f29640d, f29641e};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final int a() {
            return this.f;
        }

        static {
            f29637a = new b("BACK", 0, ZeusTransformUtils.mapRes(R.string.agent_action_press_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_press_back"));
            f29638b = new b("HOME", 1, ZeusTransformUtils.mapRes(R.string.agent_action_press_home, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_press_home"));
            f29639c = new b("POWER", 2, ZeusTransformUtils.mapRes(R.string.agent_action_press_power, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_press_power"));
            f29640d = new b("ENTER", 3, ZeusTransformUtils.mapRes(R.string.agent_action_press_enter, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_press_enter"));
            f29641e = new b("SCREENSHOT", 4, ZeusTransformUtils.mapRes(R.string.agent_action_press_screenshot, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_press_screenshot"));
            b[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpDeviceAction.kt */
    public static final class C0765c implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f29642a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0765c.class) == true) goto L8;
            return false;
        L8:
            C0765c r6 = (C0765c) ZeusTransformUtils.preCheckCast(r5, C0765c.class, "com.obric.aiagent.plugin");
            if (this.f29642a == r6.f29642a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f29642a.hashCode();
        }

        public String toString() {
            return "Input(type=" + this.f29642a + ')';
        }

        public C0765c(b r2) {
            o.e(r2, "type");
            this.f29642a = r2;
        }

        public final b getType() {
            return this.f29642a;
        }
    }

    /* JADX INFO: compiled from: OpDeviceAction.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29643a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f29637a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[b.f29638b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[b.f29639c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[b.f29640d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f29643a = r0;
        }
    }

    /* JADX INFO: compiled from: OpDeviceAction.kt */
    @d.c.b.a.f(b = "OpDeviceAction.kt", c = {115, 117, 132}, d = "performScreenshotOperation", e = "com.obric.autogui.operator.impl.op.OpDeviceAction")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f29647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29648e;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29647d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29646c = r3;
            this.f29648e |= Integer.MIN_VALUE;
            return c.a(this.f29647d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29634b = new a(null);
    }

    public static /* synthetic */ boolean lambda$CXGetXdvWBgWNTiLkvKwFgoxDD0(Context r0, IScreenshot r1) {
        return a(r0, r1);
    }

    public c() {
        this.f29635c = new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1.0f);
    }

    public static final /* synthetic */ Object a(c r2, Context r3, d.c.d r4) {
        return r2.d((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, C0765c.class) == true) goto L6;
        return false;
    L6:
        this.f29636d = (C0765c) ZeusTransformUtils.preCheckCast(r4, C0765c.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // com.obric.autogui.operator.a.b
    public Object c(Context r7, d.c.d<? super com.obric.autogui.common.e> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        C0765c r0 = this.f29636d;
        if (r0 == null) goto L5;
        AOOperatingSpace r1 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r1 != null) goto L10;
        Loog.INSTANCE.e(TAG, "[DeviceAction] no current operating space.");
        return com.obric.autogui.common.e.f29014b.b("no current operating space");
    L10:
        int r2 = d.f29643a[r0.getType().ordinal()];
        int r5 = 4;
        if (r2 != 1) goto L13;
    L22:
        if (r5 == (-1)) goto L26;
        return com.obric.autogui.operator.a.c.f29713a.a(r1, r5);
    L26:
        if (r0.getType() != b.f29641e) goto L30;
        return d(r9, r10);
    L30:
        return com.obric.autogui.common.e.f29014b.b("no viable ways to perform device action: " + r0.getType().name());
    L13:
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L18;
        r5 = -1;
        goto L22
    L18:
        r5 = 66;
        goto L22
    L19:
        r5 = 26;
        goto L22
    L21:
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_stepexec_last_step_not_supported, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_last_step_not_supported"), null, 2, null);
    L5:
        return com.obric.autogui.common.e.f29014b.b("no input provided");
    }

    private final Object d(Context r17, d.c.d<? super com.obric.autogui.common.e> r18) {
        c r0 = this;
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if ((r5.f29648e & Integer.MIN_VALUE) == 0) goto L7;
        r5.f29648e -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f29646c;
        Object r14 = d.c.a.b.a();
        int r7 = r5.f29648e;
        String r13 = TAG;
        int r12 = 2;
        if (r7 == 0) goto L18;
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        IScreenshot r1 = (IScreenshot) ZeusTransformUtils.preCheckCast(r5.f29645b, IScreenshot.class, "com.obric.aiagent.plugin");
        c r3 = (c) ZeusTransformUtils.preCheckCast(r5.f29644a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L40:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L42;
        com.obric.autogui.common.e r8 = com.obric.autogui.common.e.f29014b.b("cannot save screen-shot to gallery.");
    L43:
        final IScreenshot r9 = r1;
        r0 = r3;
        com.obric.autogui.common.e r10 = r8;
    L45:
        if (r9 == null) goto L47;
        r0.f29635c.a(r9);
    L47:
        return r10;
    L42:
        r8 = com.obric.autogui.common.e.f29014b.a();
        goto L43
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r2 = (Context) ZeusTransformUtils.preCheckCast(r5.f29645b, Context.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r5.f29644a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        Object r11 = r6;
        r12 = 2;
    L27:
        ScreenshotResult r15 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r11, ScreenshotResult.class, "com.obric.aiagent.plugin");
    L28:
        r9 = r15.getPic();
        if (r15.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L32;
        Loog.INSTANCE.w(r13, " - [screenshot-action] screenshot not saved (contains secure-layer).");
        r10 = com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_stepexec_screenshot_action_failed_contains_secure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_screenshot_action_failed_contains_secure"), null, r12, null);
        goto L45
    L32:
        if (r15.ok() == false) goto L44;
        if (r9 == null) goto L44;
        d.h.a.a r16 = new $$Lambda$c$CXGetXdvWBgWNTiLkvKwFgoxDD0(r2, r9);
        r5.f29644a = r0;
        r5.f29645b = r9;
        r5.f29648e = 3;
        r6 = r9.withResourcesLocked(r16, r5);
        if (r6 != r14) goto L38;
        return r14;
    L38:
        r3 = r0;
        r1 = r9;
    L44:
        Loog.INSTANCE.e(r13, " - [screenshot-action] screenshot not saved (s=" + r15.getStatus() + ").");
        r10 = com.obric.autogui.common.e.f29014b.b("cannot obtain screen-shot.");
        goto L45
    L17:
        r2 = (Context) ZeusTransformUtils.preCheckCast(r5.f29645b, Context.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r5.f29644a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        Object r19 = r6;
    L23:
        r15 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r19, ScreenshotResult.class, "com.obric.aiagent.plugin");
        r13 = TAG;
        goto L28
    L18:
        d.o.a(r6);
        if (AutoActionAgent.INSTANCE.getTrackingApp().a() != null) goto L24;
        Loog.INSTANCE.i(TAG, "[ScreenShot-Action] no active apps in VD; screenshot the main screen instead.");
        com.obric.autogui.agents.vlm.models.a.a r20 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(r0.f29635c, com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        r5.f29644a = r0;
        r5.f29645b = r2;
        r5.f29648e = 1;
        r19 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r20, "dev_action_scrshot", null, false, r5, 6, null);
        if (r19 != r14) goto L23;
        return r14;
    L24:
        r12 = 2;
        com.obric.autogui.agents.vlm.models.a.a r21 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(r0.f29635c, com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        r5.f29644a = r0;
        r5.f29645b = r2;
        r5.f29648e = 2;
        r11 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r21, "dev_action_scrshot", null, false, false, r5, 14, null);
        if (r11 != r14) goto L27;
        return r14;
    L7:
        r5 = new e(r0, r4);
        goto L8
    }

    private static final boolean a(Context r2, IScreenshot r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        IScreenshot r5 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.util.a.a.f31494a.a(r4, r5.getBitmap());
    }
}
