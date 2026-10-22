package com.obric.autogui.common.api;

import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;

/* JADX INFO: compiled from: AOThermalManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOThermalManager {
    public static final AOThermalManager INSTANCE = null;

    static {
        INSTANCE = new AOThermalManager();
    }

    private AOThermalManager() {
    }

    private final IAutoActionThermalStateApi acquireApi() {
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.SysThermalThrottleLimits) == true) goto L7;
        Loog.INSTANCE.w("AO-ThmMgr", "SysThermalThrottleLimits is not supported.");
        return null;
    L7:
        return AOPlatformTools.INSTANCE.system().getThermalManager();
    }

    public final void initThermalStateMonitor() {
        IAutoActionThermalStateApi r0 = acquireApi();
        if (r0 == null) goto L6;
        r0.initThermalStateMonitor();
        return;
    }

    public final IAutoActionThermalStateApi.ThermalLevelState getThermalLevelState() {
        IAutoActionThermalStateApi r0 = acquireApi();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getThermalLevelState();
    }

    public final void resetThermalState() {
        IAutoActionThermalStateApi r0 = acquireApi();
        if (r0 == null) goto L6;
        r0.resetThermalState();
        return;
    }
}
