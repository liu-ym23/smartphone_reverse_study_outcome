package com.stepos.core.common.debug;

import a0.a;
import android.os.Build;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DebugInjectionGate {
    public static final DebugInjectionGate INSTANCE = new DebugInjectionGate();
    private static volatile boolean compileTimeEnabled;
    private static volatile String deviceBuildTypeOverride;

    private DebugInjectionGate() {
    }

    public final String deviceBuildType() {
        String str = deviceBuildTypeOverride;
        if (str != null) {
            return str;
        }
        String str2 = Build.TYPE;
        return str2 == null ? "" : str2;
    }

    public final String disabledReason() {
        return isEnabled() ? "enabled" : (isDeviceInjectionAllowed() || compileTimeEnabled) ? "disabled" : a.k("requires debug APK or userdebug/eng device (ro.build.type=", deviceBuildType(), ")");
    }

    public final boolean isCompileTimeEnabled() {
        return compileTimeEnabled;
    }

    public final boolean isDeviceInjectionAllowed() {
        String strDeviceBuildType = deviceBuildType();
        return g.b(strDeviceBuildType, "userdebug") || g.b(strDeviceBuildType, "eng");
    }

    public final boolean isEnabled() {
        return compileTimeEnabled || isDeviceInjectionAllowed();
    }

    public final void setDeviceBuildTypeForTest(String str) {
        deviceBuildTypeOverride = str;
    }

    public final void setEnabledFromApp(boolean z) {
        compileTimeEnabled = z;
    }
}
