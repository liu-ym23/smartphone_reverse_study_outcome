package com.obric.autogui.common.api.virtualdisplay;

import android.content.ComponentName;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.d;
import com.obric.autogui.common.e;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: AutoActionVirtualDisplay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionVirtualDisplay implements IAutoActionVDApi {
    public static final AutoActionVirtualDisplay INSTANCE = null;

    static {
        INSTANCE = new AutoActionVirtualDisplay();
    }

    private AutoActionVirtualDisplay() {
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public d<VDTrackingApp> getVdOperatingApp() {
        return acquireApi().getVdOperatingApp();
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public d<ComponentName> getVdTopComponent() {
        return acquireApi().getVdTopComponent();
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public d<ComponentName> getMDTopComponent() {
        return acquireApi().getMDTopComponent();
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public boolean isAppVisibleInMd(String r2) {
        o.e(r2, "appPackage");
        return acquireApi().isAppVisibleInMd(r2);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public Collection<DisplayedAppInfo> fetchMdTopAppInfo(int r1, boolean r2) {
        return acquireApi().fetchMdTopAppInfo(r1, r2);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public DisplayedAppInfo fetchVdTopAppInfo() {
        return acquireApi().fetchVdTopAppInfo();
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public e bringTaskToMdFront(int r1) {
        return acquireApi().bringTaskToMdFront(r1);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public e bringMdAppToVd(int r1) {
        return acquireApi().bringMdAppToVd(r1);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public e openAppInVd(String r2) {
        o.e(r2, "packageName");
        return acquireApi().openAppInVd(r2);
    }

    @Override // com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi
    public int getOperatingDisplayId() {
        return acquireApi().getOperatingDisplayId();
    }

    private final IAutoActionVDApi acquireApi() {
        IAutoActionVDApi r2 = (IAutoActionVDApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionVDApi.class), IAutoActionVDApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new RuntimeException("AutoActionVirtualDisplay service not found.");
    }
}
