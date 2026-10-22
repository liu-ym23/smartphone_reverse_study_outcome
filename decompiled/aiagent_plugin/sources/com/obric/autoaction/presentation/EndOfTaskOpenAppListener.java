package com.obric.autoaction.presentation;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import java.util.Collection;

/* JADX INFO: compiled from: EndOfTaskOpenAppListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EndOfTaskOpenAppListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String TAG = "EoT/OpenApp";

    /* JADX INFO: compiled from: EndOfTaskOpenAppListener.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    private static final String bringTaskToMainDisplay$lambda$5() {
        return "bringing lastTask";
    }

    /* JADX INFO: renamed from: lambda$9CUpqeSeZ1qqbP6DNab-E7DTGGI, reason: not valid java name */
    public static /* synthetic */ String m586lambda$9CUpqeSeZ1qqbP6DNabE7DTGGI() {
        return bringTaskToMainDisplay$lambda$5();
    }

    public static /* synthetic */ String lambda$DIKOLhXTuAPJlIjpYfa8nhSCKuc(DisplayedAppInfo r0) {
        return startAppOnMainDisplay$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$EkX-NgKeb1xWx9U-Xts7Ngw_PXw, reason: not valid java name */
    public static /* synthetic */ String m587lambda$EkXNgKeb1xWx9UXts7Ngw_PXw(String r0) {
        return startAppOnMainDisplay$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$N-g85fFXiJ0mY8rTwepiAFxbYWA, reason: not valid java name */
    public static /* synthetic */ String m588lambda$Ng85fFXiJ0mY8rTwepiAFxbYWA(int r0) {
        return bringTaskToMainDisplay$lambda$4(r0);
    }

    public EndOfTaskOpenAppListener() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r1, r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        IAutoActionAgentEventListener.DefaultImpls.onBizStatusChanged(this, r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onOperatingAppChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, QueueStatus r2) {
        IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onSessionEnqueued(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3) {
        o.e(r2, "sessionInfo");
        o.e(r3, "stepInfo");
        if (r3.isLastStep() == false) goto L6;
        maybeOpenAppBeforeTermination(r3);
        return;
    }

    private final void maybeOpenAppBeforeTermination(IAutoActionAgentEventListener.AgentStepInfo r7) {
        if (r7.isLastStep() == true) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (isKeyguardLocked(r0) == true) goto L8;
    L11:
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        IAutoActionPresentationApi.PlayerVisibility r2 = r1.getPlayerVisibility(r0);
    L15:
        boolean r4 = true;
        if (r2 != IAutoActionPresentationApi.PlayerVisibility.Invisible) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L30;
        Bundle r8 = r7.getExtras();
        if (r8 != null) goto L23;
    L25:
        r4 = false;
    L26:
        Loog.INSTANCE.d(TAG, "open app by model config " + r4);
        if (r4 == false) goto L31;
        startAppOnMainDisplay(r0);
        return;
    L31:
        return;
    L23:
        if (r8.getBoolean("open_app", false) != true) goto L25;
    L30:
        return;
    L18:
        r3 = false;
        goto L19
    L14:
        r2 = null;
        goto L15
    L8:
        if (hasExternalTopAppRunning() == false) goto L11;
        Loog.INSTANCE.d(TAG, "skip open app because screen locked and external app is on top");
    }

    private final boolean isKeyguardLocked(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L15
        EndOfTaskOpenAppListener r3 = (EndOfTaskOpenAppListener) ZeusTransformUtils.preCheckCast(this, EndOfTaskOpenAppListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
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
        r9 = n.f(d.o.a(th));
        goto L18
    }

    private final boolean hasExternalTopAppRunning() {
        boolean r0 = true;
        String r4 = null;
        Collection r5 = IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 1, false, 2, null);
        if (r5 == null) goto L9;
        DisplayedAppInfo r6 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        ComponentName r7 = r6.getTopActivity();
        if (r7 == null) goto L9;
        r4 = r7.getPackageName();
    L9:
        String r8 = AOSystemTools.INSTANCE.getHostAppPackage();
        if (r4 != null) goto L12;
    L14:
        r0 = false;
    L15:
        Loog.INSTANCE.i(TAG, "current top=" + r4 + ", host=" + r8 + ", external=" + r0);
        return r0;
    L12:
        if (o.a(r4, r8) == false) goto L14;
        goto L14
    }

    private final void startAppOnMainDisplay(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(TAG, "startAppOnMainDisplay, no activeSpace currently.");
        return;
    L6:
        final DisplayedAppInfo r1 = r0.fetchTopDisplayed();
        if (r1 != null) goto L11;
        Loog.INSTANCE.d(TAG, "startAppOnMainDisplay, executingApp is null");
        return;
    L11:
        if (r1.getTaskId() <= 0) goto L13;
        bringTaskToMainDisplay(r1.getTaskId());
        return;
    L13:
        ComponentName r5 = r1.getTopActivity();
        if (r5 == null) goto L16;
        final String r8 = r5.getPackageName();
    L17:
        Loog.INSTANCE.dp(TAG, new $$Lambda$EndOfTaskOpenAppListener$EkXNgKeb1xWx9UXts7Ngw_PXw(r8), new $$Lambda$EndOfTaskOpenAppListener$DIKOLhXTuAPJlIjpYfa8nhSCKuc(r1));
        if (r8 == null) goto L22;
        AOPackagesTools.INSTANCE.openAppOnMainDisplay(r7, r8);
        return;
    L22:
        return;
    L16:
        r8 = null;
        goto L17
    }

    private static final String startAppOnMainDisplay$lambda$1(String r2) {
        return "startAppOnMainDisplay, taskId not available; opening (" + r2 + ')';
    }

    private static final String startAppOnMainDisplay$lambda$2(DisplayedAppInfo r2) {
        return "startAppOnMainDisplay, taskId not available; opening taskId=" + ((DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r2, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getTaskId();
    }

    private final com.obric.autogui.common.e bringTaskToMainDisplay(final int r4) {
        Loog.INSTANCE.dp(TAG, new $$Lambda$EndOfTaskOpenAppListener$Ng85fFXiJ0mY8rTwepiAFxbYWA(r4), $$Lambda$EndOfTaskOpenAppListener$9CUpqeSeZ1qqbP6DNabE7DTGGI.INSTANCE);
        return AutoActionVirtualDisplay.INSTANCE.bringTaskToMdFront(r4);
    }

    private static final String bringTaskToMainDisplay$lambda$4(int r2) {
        return " - bringing lastTask: " + r2;
    }
}
