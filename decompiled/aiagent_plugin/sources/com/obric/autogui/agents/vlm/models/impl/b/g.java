package com.obric.autogui.agents.vlm.models.impl.b;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenshotFeedbackUpdater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements b {
    private static final String TAG = "ModelEnv/Screenshot";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27599a = null;

    /* JADX INFO: compiled from: ScreenshotFeedbackUpdater.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27599a = new a(null);
    }

    private static final String a() {
        return "[StartInPlace - HP] mdAppPackage";
    }

    public static /* synthetic */ String lambda$9dUefYngS55iz3DIIuHIo3sW7wo(CharSequence r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$sWMcsY-TQMnmIk-LDMfIxOiU3bs, reason: not valid java name */
    public static /* synthetic */ String m747lambda$sWMcsYTQMnmIkLDMfIxOiU3bs() {
        return a();
    }

    public g() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.b.b
    public void a(com.obric.autogui.agents.vlm.b.C0677b r5, com.obric.autogui.agents.vlm.models.c.b r6, com.obric.autogui.agents.vlm.models.impl.b.a r7) {
        com.obric.autogui.agents.vlm.models.impl.b.a r8 = (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r6, "preparation");
        o.e(r8, "requestEnvironment");
        ScreenshotResult r0 = r6.g();
        if (r0 == null) goto L5;
        ScreenshotResult.Status r1 = r0.getStatus();
    L7:
        if (r1 != ScreenshotResult.Status.ContainsSecure) goto L20;
        ScreenshotResult r2 = r6.g();
        boolean r3 = false;
        if (r2 == null) goto L11;
        int r4 = r2.getFlags();
    L13:
        if ((r4 & 1) == 0) goto L16;
        r3 = true;
    L16:
        if (r3 == false) goto L18;
        int r9 = ZeusTransformUtils.mapRes(R.string.agent_stepexec_screenshot_contains_robots_constrained, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_screenshot_contains_robots_constrained");
    L19:
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r9);
        o.c(r10, "getString(...)");
        r8.c(r10);
        goto L20
    L18:
        r9 = ZeusTransformUtils.mapRes(R.string.agent_stepexec_screenshot_contains_secure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_screenshot_contains_secure");
        goto L19
    L11:
        r4 = 0;
    L20:
        b(r5, r6, r8);
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void b(com.obric.autogui.agents.vlm.b.C0677b r8, com.obric.autogui.agents.vlm.models.c.b r9, com.obric.autogui.agents.vlm.models.impl.b.a r10) {
        com.obric.autogui.agents.vlm.models.impl.b.a r7 = (com.obric.autogui.agents.vlm.models.impl.b.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.agents.vlm.models.impl.b.a.class, "com.obric.aiagent.plugin");
        ScreenshotResult r11 = r9.g();
        CharSequence r12 = null;
        if (r11 == null) goto L7;
        IScreenshot r13 = r11.getPic();
        if (r13 == null) goto L7;
        AOOperatingSpace.SpaceType r14 = r13.getSpaceType();
    L9:
        if (r14 != AOOperatingSpace.SpaceType.MainDisplay) goto L33;
        com.obric.autogui.session.state.a r15 = r8.a().m().a(BizStatus.OPERATING);
        if (ZeusTransformUtils.instanceOf(r15, com.obric.autogui.session.state.a.h.class) == false) goto L13;
        com.obric.autogui.session.state.a.h r16 = (com.obric.autogui.session.state.a.h) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.session.state.a.h.class, "com.obric.aiagent.plugin");
    L14:
        if (r16 == null) goto L20;
        DisplayedAppInfo r17 = r16.a();
        if (r17 == null) goto L20;
        ComponentName r18 = r17.getRealActivity();
        if (r18 == null) goto L20;
        final String r19 = r18.getPackageName();
    L21:
        if (r19 == null) goto L33;
        AppInfoEntry r1 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r19);
        if (r1 == null) goto L26;
        final CharSequence r2 = r1.getAppLabel();
        if (r2 == null) goto L26;
    L27:
        Loog.INSTANCE.dp(TAG, new $$Lambda$g$9dUefYngS55iz3DIIuHIo3sW7wo(r2, r19), $$Lambda$g$sWMcsYTQMnmIkLDMfIxOiU3bs.INSTANCE);
        if (r2.length() <= 0) goto L30;
        boolean r20 = true;
    L31:
        if (r20 == false) goto L33;
        r12 = r2;
        goto L33
    L30:
        r20 = false;
    L26:
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L20:
        r19 = null;
        goto L21
    L13:
        r16 = null;
    L33:
        if (r12 == null) goto L36;
        String r21 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stepexec_userresponse_start_in_place_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stepexec_userresponse_start_in_place_hint"), new Object[]{r12});
        o.c(r21, "getString(...)");
        r7.c(r21);
        return;
    L36:
        return;
    L7:
        r14 = null;
        goto L9
    }

    private static final String a(CharSequence r2, String r3) {
        return "[StartInPlace - HP] mdAppPackage, appName: " + ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin")) + ", appPkg = " + r3;
    }
}
