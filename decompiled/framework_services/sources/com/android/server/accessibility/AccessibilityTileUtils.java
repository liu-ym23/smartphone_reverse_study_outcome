package com.android.server.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityShortcutInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityTileUtils {
    private static final String TAG = "AccessibilityTileUtils";

    /* JADX INFO: renamed from: $r8$lambda$Oos7u-JbDCrRVuSrqmT1kE0YGRw, reason: not valid java name */
    public static /* synthetic */ void m635$r8$lambda$Oos7uJbDCrRVuSrqmT1kE0YGRw(Context r0, PackageManagerInternal r1, int r2, Set r3, AccessibilityServiceInfo r4) {
        lambda$getValidA11yTileServices$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$yloXV6SHJLyDBW74g8cd0k0xyrc(Context r0, PackageManagerInternal r1, int r2, Set r3, AccessibilityShortcutInfo r4) {
        lambda$getValidA11yTileServices$1(r0, r1, r2, r3, r4);
    }

    private AccessibilityTileUtils() {
    }

    private static boolean isComponentValidTileService(Context context, PackageManagerInternal pm, ComponentName componentName, int userId) {
        Intent intent = new Intent("android.service.quicksettings.action.QS_TILE");
        intent.setComponent(componentName);
        ResolveInfo resolveInfo = pm.resolveService(intent, intent.resolveTypeIfNeeded(context.getContentResolver()), 0, userId, Process.myUid());
        if (resolveInfo != null) goto L5;
    L21:
        Slog.w(TAG, "TileService could not be resolved: " + componentName);
        return false;
    L5:
        if (resolveInfo.serviceInfo == null) goto L21;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo.exported == true) goto L12;
        Slog.w(TAG, "TileService is not exported: " + componentName);
        return false;
    L12:
        if ("android.permission.BIND_QUICK_SETTINGS_TILE".equals(serviceInfo.permission) == true) goto L15;
        Slog.w(TAG, "TileService is not protected by BIND_QUICK_SETTINGS_TILE permission: " + componentName);
        return false;
    L15:
        int enabledSetting = pm.getComponentEnabledSetting(componentName, Process.myUid(), userId);
        if (resolveEnabledComponent(enabledSetting, serviceInfo.enabled) == true) goto L19;
        Slog.w(TAG, "TileService is not enabled: " + componentName.flattenToShortString());
        return false;
    L19:
        return true;
    }

    private static boolean resolveEnabledComponent(int pmResult, boolean defaultValue) {
        if (pmResult != 1) goto L5;
        return true;
    L5:
        if (pmResult != 0) goto L7;
        return defaultValue;
    L7:
        return false;
    }

    public static Set<ComponentName> getValidA11yTileServices(final Context context, final PackageManagerInternal pm, List<AccessibilityServiceInfo> accessibilityServiceInfos, List<AccessibilityShortcutInfo> accessibilityShortcutInfos, final int userId) {
        final Set<ComponentName> validA11yTileServices = new ArraySet();
        if (pm != null) goto L5;
        return validA11yTileServices;
    L5:
        if (accessibilityServiceInfos == null) goto L7;
        accessibilityServiceInfos.forEach(new AccessibilityTileUtils$$ExternalSyntheticLambda0(context, pm, userId, validA11yTileServices));
    L7:
        if (accessibilityShortcutInfos == null) goto L9;
        accessibilityShortcutInfos.forEach(new AccessibilityTileUtils$$ExternalSyntheticLambda1(context, pm, userId, validA11yTileServices));
    L9:
        return validA11yTileServices;
    }

    private static /* synthetic */ void lambda$getValidA11yTileServices$0(Context context, PackageManagerInternal pm, int userId, Set validA11yTileServices, AccessibilityServiceInfo a11yServiceInfo) {
        String tileServiceName = a11yServiceInfo.getTileServiceName();
        if (TextUtils.isEmpty(tileServiceName) == true) goto L8;
        ResolveInfo resolveInfo = a11yServiceInfo.getResolveInfo();
        ComponentName a11yFeature = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        ComponentName tileService = new ComponentName(a11yFeature.getPackageName(), tileServiceName);
        if (isComponentValidTileService(context, pm, tileService, userId) == false) goto L9;
        validA11yTileServices.add(tileService);
        return;
    L9:
        return;
    }

    private static /* synthetic */ void lambda$getValidA11yTileServices$1(Context context, PackageManagerInternal pm, int userId, Set validA11yTileServices, AccessibilityShortcutInfo a11yShortcutInfo) {
        String tileServiceName = a11yShortcutInfo.getTileServiceName();
        if (TextUtils.isEmpty(tileServiceName) == true) goto L8;
        ComponentName a11yFeature = a11yShortcutInfo.getComponentName();
        ComponentName tileService = new ComponentName(a11yFeature.getPackageName(), tileServiceName);
        if (isComponentValidTileService(context, pm, tileService, userId) == false) goto L9;
        validA11yTileServices.add(tileService);
        return;
    L9:
        return;
    }
}
