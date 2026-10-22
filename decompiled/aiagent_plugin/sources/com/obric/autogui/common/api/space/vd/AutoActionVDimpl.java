package com.obric.autogui.common.api.space.vd;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.common.d;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: AutoActionVDimpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionVDimpl implements IAutoActionVDApi {
    public static final Companion Companion = null;
    private static final String TAG = "AA-VDImpl";

    /* JADX INFO: compiled from: AutoActionVDimpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AutoActionVDimpl() {
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public d<VDTrackingApp> getVdOperatingApp() {
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(TAG, "getVdOperatingApp: no active space found.");
        return new d(false, null, 0, null, 14, null);
    L6:
        DisplayedAppInfo r1 = r0.fetchTopDisplayed();
        if (r1 != null) goto L10;
        Loog.INSTANCE.d(TAG, " - [VD] no top task found on vd.");
        return new d(false, null, 0, null, 14, null);
    L10:
        ComponentName r2 = r1.getBaseActivity();
        if (r2 != null) goto L14;
        Loog.INSTANCE.d(TAG, " - [VD] no base activity found on vd (task=" + r1.getTaskId() + ").");
        return new d(false, null, 0, null, 14, null);
    L14:
        String r3 = r2.getPackageName();
        o.c(r3, "getPackageName(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L22;
        return new d(false, null, 0, null, 14, null);
    L22:
        if (IAutoActionVDApi.Companion.isWaivedTrackingPackage(r3) == false) goto L26;
        Loog.INSTANCE.d(TAG, " - [VD] in-vd pkg `" + r3 + "` is waived tracking; ignored.");
        return new d(false, null, 0, null, 14, null);
    L26:
        return new d(true, null, 0, new VDTrackingApp(r1.getTaskId(), r3), 6, null);
    L17:
        r4 = false;
        goto L18
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public d<ComponentName> getVdTopComponent() {
        AOOperatingSpace r14 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r14 != null) goto L6;
        Loog.INSTANCE.e(TAG, "getVdTopComponent: no active space found.");
        return new d(false, null, 0, null, 14, null);
    L6:
        DisplayedAppInfo r15 = r14.fetchTopDisplayed();
        if (r15 == null) goto L13;
        ComponentName r4 = r15.getTopActivity();
        if (r4 == null) goto L13;
        return new d(true, null, 0, r4, 6, null);
    L13:
        return new d(false, null, 0, null, 14, null);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public d<ComponentName> getMDTopComponent() {
        DisplayAccessor r0 = AOPlatformTools.INSTANCE.display().getMDAccess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(TAG, "isAppVisibleInMd: cannot access the MainDisplay.");
        return d.f29012a.a("cannot access the MainDisplay.");
    L6:
        DisplayedAppInfo r1 = r0.getTopDisplayedApp();
        if (r1 != null) goto L11;
        Loog.INSTANCE.d(TAG, " - [MD] no top app found on md.");
        return new d(false, null, 0, null, 14, null);
    L11:
        return new d(true, null, 0, r1.getTopActivity(), 6, null);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public boolean isAppVisibleInMd(String r7) {
        o.e(r7, "appPackage");
        DisplayAccessor r6 = AOPlatformTools.INSTANCE.display().getMDAccess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r6 != null) goto L6;
        Loog.INSTANCE.e(TAG, "isAppVisibleInMd: cannot access the MainDisplay.");
        return false;
    L6:
        boolean r2 = r6.isPackageVisible(r7);
        if (r2 == true) goto L9;
    L19:
        return r2;
    L9:
        if (o.a(r7, AOHostAppTools.INSTANCE.getHostAppPackage()) == false) goto L19;
        DisplayedAppInfo r8 = r6.getTopDisplayedApp();
        if (r8 == null) goto L13;
        ComponentName r9 = r8.getTopActivity();
    L14:
        if (r9 == null) goto L19;
        AOHostAppTools r10 = AOHostAppTools.INSTANCE;
        String r3 = r9.getPackageName();
        o.c(r3, "getPackageName(...)");
        String r4 = r9.getClassName();
        o.c(r4, "getClassName(...)");
        if (r10.isSelf(r3, r4) == false) goto L19;
        Loog.INSTANCE.w(TAG, "[MD] Ignoring AutoAction's activity on MD: " + r9);
        return false;
    L13:
        r9 = null;
        goto L14
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public Collection<DisplayedAppInfo> fetchMdTopAppInfo(int r4, boolean r5) {
        DisplayAccessor r3 = AOPlatformTools.INSTANCE.display().getMDAccess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r3 != null) goto L11;
        Loog.INSTANCE.e(TAG, "fetchMdTopAppInfo: cannot access the MainDisplay.");
        return null;
    L11:
        return r3.getTopDisplayedApps(r4, r5);
    L8:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - failed to fetch top apps: " + th);
        return null;
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public DisplayedAppInfo fetchVdTopAppInfo() {
        AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r5 != null) goto L14;
        Loog.INSTANCE.e(TAG, "fetchVdTopAppInfo: no active space found.");
        return null;
    L14:
        DisplayedAppInfo r6 = r5.fetchTopDisplayed();     // Catch: Throwable -> L11
        if (r6 != null) goto L10;
        Loog.INSTANCE.d(TAG, " - [VD] no top task found on vd.");     // Catch: Throwable -> L11
        return null;
    L10:
        return r6;
    L11:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - failed to fetch top apps: " + th);
        return null;
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public e bringTaskToMdFront(int r8) {
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        DisplayAccessor r1 = AOPlatformTools.INSTANCE.display().getMDAccess(r7);
        if (r1 != null) goto L6;
        Loog.INSTANCE.e(TAG, "bringTaskToMdFront: cannot access the MainDisplay.");
        return e.f29014b.b("cannot access the MainDisplay.");
    L6:
        AOOperatingSpace r3 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        boolean r4 = true;
        if (r3 != null) goto L10;
    L17:
        if (r4 == false) goto L25;
        Loog.INSTANCE.d(TAG, " - [VD-BringTaskToMd] try Move-to-Front method.");
        if (AOPlatformTools.INSTANCE.display().bringTaskToFront(r7, r8) == true) goto L23;
        Loog.INSTANCE.e(TAG, "bringTaskToFront failed.");
        return e.f29014b.b("bringTaskToFront failed.");
    L23:
        return e.f29014b.a();
    L25:
        return e.f29014b.a();
    L10:
        if (ZeusTransformUtils.instanceOf(r3, DisplayOperatingSpace.class) == true) goto L13;
        Loog.INSTANCE.e(TAG, "bringTaskToMdFront (via taskId): only supported between [DisplayOperatingSpace]s.");
        return e.f29014b.b("active space is not DisplayOperatingSpace.");
    L13:
        Loog.INSTANCE.w(TAG, " - [VD-BringTaskToMd] vd still available. try Move-to-Md method.");
        if (((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayAccessor().moveTaskTo(r7, r8, r1, true) == false) goto L17;
        r4 = false;
        goto L17
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public e bringMdAppToVd(int r6) {
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        DisplayAccessor r1 = AOPlatformTools.INSTANCE.display().getMDAccess(r5);
        if (r1 != null) goto L6;
        Loog.INSTANCE.e(TAG, "bringMdAppToVd: cannot access the MainDisplay.");
        return e.f29014b.b("cannot access the MainDisplay.");
    L6:
        AOOperatingSpace r3 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r3 != null) goto L11;
        Loog.INSTANCE.e(TAG, "bringMdAppToVd: no active space found.");
        return e.f29014b.b("no active space found.");
    L11:
        if (ZeusTransformUtils.instanceOf(r3, DisplayOperatingSpace.class) == true) goto L15;
        Loog.INSTANCE.e(TAG, "bringMdAppToVd (via taskId): only supported between [DisplayOperatingSpace]s.");
        return e.f29014b.b("active space is not DisplayOperatingSpace.");
    L15:
        if (r1.moveTaskTo(r5, r6, ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayAccessor(), true) == true) goto L19;
        return e.f29014b.b("displayId is DEFAULT_DISPLAY");
    L19:
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public e openAppInVd(String r7) {
        o.e(r7, "packageName");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Intent r2 = AOPackagesTools.INSTANCE.getLaunchIntent(r1, r7);
        if (r2 != null) goto L6;
        Loog.INSTANCE.e(TAG, "openAppInVd: getLaunchIntent failed failed.");
        return e.f29014b.b("getLaunchIntent failed.");
    L6:
        StartActivityResult r8 = AOSystemTools.startActivity$default(AOSystemTools.INSTANCE, r1, r2, null, 4, null);
        Loog.INSTANCE.d(TAG, "openAppInVd: result = " + r8);
        if (r8.getOk() == false) goto L11;
        return e.f29014b.a();
    L11:
        return e.f29014b.b("startActivity failed. reason = " + r8.getStatus().name());
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public int getOperatingDisplayId() {
        AOOperatingSpace r3 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r3 != null) goto L7;
        Loog.INSTANCE.e(TAG, "getOperatingDisplayId: no active space found.");
        return 0;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, DisplayOperatingSpace.class) == true) goto L11;
        Loog.INSTANCE.e(TAG, "getOperatingDisplayId: active space is not DisplayOperatingSpace.");
        return 0;
    L11:
        return ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId();
    }
}
