package com.android.server.pm.pkg;

import android.content.pm.ComponentInfo;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public class PackageUserStateUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "PackageUserStateUtils";

    public PackageUserStateUtils() {
    }

    public static boolean isMatch(PackageUserState state, ComponentInfo componentInfo, long flags) {
        return isMatch(state, componentInfo.applicationInfo.isSystemApp(), componentInfo.applicationInfo.enabled, componentInfo.enabled, componentInfo.directBootAware, componentInfo.name, flags);
    }

    public static boolean isMatch(PackageUserState state, boolean isSystem, boolean isPackageEnabled, ParsedMainComponent component, long flags) {
        return isMatch(state, isSystem, isPackageEnabled, component.isEnabled(), component.isDirectBootAware(), component.getName(), flags);
    }

    public static boolean isMatch(PackageUserState state, boolean isSystem, boolean isPackageEnabled, boolean isComponentEnabled, boolean isComponentDirectBootAware, String componentName, long flags) {
        boolean r8 = true;
        if ((4202496 & flags) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean matchUninstalled = r0;
        if (isAvailable(state, flags) == true) goto L13;
        if (isSystem == false) goto L11;
        if (matchUninstalled == true) goto L13;
    L11:
        return reportIfDebug(false, flags);
    L13:
        if (isEnabled(state, isPackageEnabled, isComponentEnabled, componentName, flags) == true) goto L17;
        return reportIfDebug(false, flags);
    L17:
        if ((DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES & flags) == 0) goto L22;
        if (isSystem == true) goto L22;
        return reportIfDebug(false, flags);
    L22:
        if ((262144 & flags) == 0) goto L25;
        if (isComponentDirectBootAware == true) goto L25;
        boolean matchesUnaware = true;
    L27:
        if ((524288 & flags) == 0) goto L30;
        if (isComponentDirectBootAware == false) goto L30;
        boolean matchesAware = true;
    L31:
        if (matchesUnaware == true) goto L36;
        if (matchesAware == true) goto L36;
        r8 = false;
    L36:
        return reportIfDebug(r8, flags);
    L30:
        matchesAware = false;
    L25:
        matchesUnaware = false;
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    public static boolean isAvailable(PackageUserState state, long flags) {
        if ((4194304 & flags) == 0) goto L5;
        boolean matchAnyUser = true;
    L7:
        if ((8192 & flags) == 0) goto L9;
        boolean matchUninstalled = true;
    L11:
        if ((4294967296L & flags) == 0) goto L13;
        boolean matchArchived = true;
    L14:
        if (matchUninstalled == true) goto L18;
        if (matchArchived == true) goto L18;
        boolean matchDataExists = false;
    L19:
        if (matchAnyUser == false) goto L22;
        return true;
    L22:
        if (state.isInstalled() == true) goto L24;
        if (matchDataExists == true) goto L29;
        return false;
    L29:
        if (state.dataExists() == true) goto L31;
        return false;
    L31:
        return true;
    L24:
        if (state.isHidden() == true) goto L26;
        return true;
    L26:
        return matchDataExists;
    L18:
        matchDataExists = true;
        goto L19
    L13:
        matchArchived = false;
        goto L14
    L9:
        matchUninstalled = false;
        goto L11
    L5:
        matchAnyUser = false;
        goto L7
    }

    public static boolean reportIfDebug(boolean result, long flags) {
        return result;
    }

    public static boolean isEnabled(PackageUserState state, ComponentInfo componentInfo, long flags) {
        return isEnabled(state, componentInfo.applicationInfo.enabled, componentInfo.enabled, componentInfo.name, flags);
    }

    public static boolean isEnabled(PackageUserState state, boolean isPackageEnabled, ParsedMainComponent parsedComponent, long flags) {
        return isEnabled(state, isPackageEnabled, parsedComponent.isEnabled(), parsedComponent.getName(), flags);
    }

    public static boolean isEnabled(PackageUserState state, boolean isPackageEnabled, boolean isComponentEnabled, String componentName, long flags) {
        if ((512 & flags) == 0) goto L6;
        return true;
    L6:
        if ((8589934592L & flags) != 0) goto L11;
        if (state.isQuarantined() == false) goto L11;
        return false;
    L11:
        switch(state.getEnabledState()) {
            case 0: goto L17;
            case 1: goto L20;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L14;
            default: goto L20;
        };
    L16:
        return false;
    L17:
        if (isPackageEnabled == true) goto L20;
        return false;
    L14:
        if ((32768 & flags) != 0) goto L17;
        return false;
    L20:
        if (state.isComponentEnabled(componentName) == false) goto L23;
        return true;
    L23:
        if (state.isComponentDisabled(componentName) == false) goto L25;
        return false;
    L25:
        return isComponentEnabled;
    }

    public static boolean isPackageEnabled(PackageUserState state, AndroidPackage pkg) {
        switch(state.getEnabledState()) {
            case 1: goto L8;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L8:
        return true;
    L5:
        return pkg.isEnabled();
    }
}
