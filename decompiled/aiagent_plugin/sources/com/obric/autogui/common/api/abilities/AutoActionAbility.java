package com.obric.autogui.common.api.abilities;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: AutoActionAbility.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AutoActionAbility extends Enum<AutoActionAbility> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AutoActionAbility[] $VALUES = null;
    public static final AutoActionAbility AutoAction = null;
    public static final AutoActionAbility PkgAccessLauncherShortcuts = null;
    public static final AutoActionAbility ProdDataDonation = null;
    public static final AutoActionAbility ProdOperateHostApp = null;
    public static final AutoActionAbility SysThermalThrottleLimits = null;
    public static final AutoActionAbility WmCaptureMainDisplay = null;

    private static final /* synthetic */ AutoActionAbility[] $values() {
        return new AutoActionAbility[]{AutoAction, WmCaptureMainDisplay, PkgAccessLauncherShortcuts, SysThermalThrottleLimits, ProdOperateHostApp, ProdDataDonation};
    }

    public static a<AutoActionAbility> getEntries() {
        return $ENTRIES;
    }

    private AutoActionAbility(String r1, int r2) {
        super(r1, r2);
    }

    static {
        AutoAction = new AutoActionAbility("AutoAction", 0);
        WmCaptureMainDisplay = new AutoActionAbility("WmCaptureMainDisplay", 1);
        PkgAccessLauncherShortcuts = new AutoActionAbility("PkgAccessLauncherShortcuts", 2);
        SysThermalThrottleLimits = new AutoActionAbility("SysThermalThrottleLimits", 3);
        ProdOperateHostApp = new AutoActionAbility("ProdOperateHostApp", 4);
        ProdDataDonation = new AutoActionAbility("ProdDataDonation", 5);
        AutoActionAbility[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AutoActionAbility valueOf(String r2) {
        return (AutoActionAbility) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoActionAbility.class, r2), AutoActionAbility.class, "com.obric.aiagent.plugin");
    }

    public static AutoActionAbility[] values() {
        return (AutoActionAbility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoActionAbility[].class, "com.obric.aiagent.plugin");
    }
}
