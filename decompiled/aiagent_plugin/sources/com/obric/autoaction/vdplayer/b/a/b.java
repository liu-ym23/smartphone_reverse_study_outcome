package com.obric.autoaction.vdplayer.b.a;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.vdplayer.api.function.IFunctionController;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: EnterManualOperateUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25189a = null;

    /* JADX INFO: compiled from: EnterManualOperateUseCase.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f25189a = new a(null);
    }

    public b() {
    }

    public final boolean a() {
        if (c() == false) goto L9;
        IFunctionController r2 = (IFunctionController) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFunctionController.class), IFunctionController.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r2.startFunction("ManualOperating");
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public final boolean b() {
        IFunctionController r2 = (IFunctionController) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFunctionController.class), IFunctionController.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r3 = r2.getActiveFunctionType();
    L7:
        return o.a(r3, "CallUser");
    L5:
        r3 = null;
        goto L7
    }

    public final boolean c() {
        if (AutoActionAgent.INSTANCE.isOngoingSessionActive() == true) goto L5;
        return false;
    L5:
        VDTrackingApp r5 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getTrackingApp().a(), VDTrackingApp.class, "com.obric.aiagent.plugin");
        VDTrackingApp r1 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp().a(), VDTrackingApp.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L29;
        if (r1 == null) goto L29;
        AppBlackListEvent r2 = AppBlackListEventHolder.INSTANCE.getBlackListEvent();
        if (r2 != null) goto L12;
    L17:
        IFunctionController r6 = (IFunctionController) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFunctionController.class), IFunctionController.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L20;
        String r7 = r6.getActiveFunctionType();
    L22:
        if (r7 != null) goto L24;
        return true;
    L24:
        if (o.a(r7, "Clarify") == false) goto L26;
        return true;
    L26:
        Loog.INSTANCE.d("EnterManualOperateUseCase", "canEnterManualOpMode ==> false, func=" + r7);
        return false;
    L20:
        r7 = null;
        goto L22
    L12:
        if (o.a(r2.getActivityName().getPackageName(), r5.getPackageName()) == false) goto L17;
        if (r2.getBlackListState() == AppBlackListState.UserDefinedBlackList) goto L17;
        Loog.INSTANCE.d("EnterManualOperateUseCase", "blocked by BL event: " + r2);
        return false;
    L29:
        Loog.INSTANCE.d("EnterManualOperateUseCase", "canEnterManualOpMode ==> false, no tracking app.");
        return false;
    }
}
